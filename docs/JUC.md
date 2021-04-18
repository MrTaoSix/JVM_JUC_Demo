# JUC知识点笔记
- [JMM](#JMM)
- [volatile关键字](volatile关键字)



# JMM
JMM是指Java**内存模型**，不是Java**内存布局**。不是所谓的栈、堆、方法区。    
每个java线程都有自己的**工作内存**。操作数据的时候首先从主内存中拷贝一份数据到工作内存，操作完毕之后写回主内存。        
![](https://mrtao-bucket.oss-cn-shanghai.aliyuncs.com/JMM.png)

> JMM可能带来**可见性**、**原子性**、**一致性**问题
> + 可见性：一个线程对主内存内容的修改，应该立即通知到其他线程    
> + 原子性：一个操作是不可分割的。不可能执行到一半就停止不执行了。    
> + 有序性：指令是有序的，不会被重新排列    

# volatile关键字
volatile关键字是Java提供的一种**轻量级**同步机制。他能够保证**可见性**和**有序性**。但是不能保证原子性
## 可见性代码测试
```java
class MyData{

    //是用volatile修饰
    volatile int number = 0;
    public void chageNumber(){
        number = 60;
    }
}

public class VolatileDemo {
    public static void main(String[] args) {
        MyData myData = new MyData();
        new Thread(() ->{
            try { TimeUnit.SECONDS.sleep(3);}catch (InterruptedException e){ e.printStackTrace();   }
            myData.chageNumber();
            System.out.println(Thread.currentThread().getName()+"/t update number value:"+myData.number);
        },"AAA").start();
        while (myData.number==0){

        }
        System.out.println(Thread.currentThread().getName()+"/t mission is over,main get number value:"+myData.number);
    }
}
```
> *number如果没有用volatile修饰，线程AAA对它的修改对其他变量是不可见的。所以程序会一直循坏*
## 原子性
原子性是指一个操作不可分割，某个线程正在执行任务时，中间不可以被加塞或分割。需要整体完整。
>volatile并不能保证操作的**原子性**。number++在底层分为三步操作
> 1. 从主内存中读取值到工作内存
> 2. 修改工作内存
> 3. 写会主内存
> *在每个线程将值写回主内存的过程中可能会发生挂起 再次执行的主内存中的值可能已经发生了改变*

解决办法
1. 使用synchronized修饰方法
2. 使用 Java.util.concurrent.AtomicInteger 类

## 指令重排
计算机在执行程序的时候，为了提高性能。编译器和处理器常常会对**指令进行**重排。一般分为三种
![](https://mrtao-bucket.oss-cn-shanghai.aliyuncs.com/%E6%8C%87%E4%BB%A4%E9%87%8D%E6%8E%92.png)
单线程环境里面确保执行的结果与代码顺序执行的结果是已知的
处理器在进行重排序必须要指令之间的数据**依赖性**
多线程环境中线程交替执行，由于编译器优化重排的存在，两个线程中使用的变量是否能保持一致性是无法确定的，结果无法预测
```Java
int x = 11; //语句1
int y = 12; //语句2
x = x + 5;  //语句3
y = x * x;  //语句4
```
以上例子，可能出现的执行顺序有1234、2134、1342，这三个都没有问题，最终结果都是x = 16，y=256。但是如果是4开头，就有问题了，y=0。这个时候就**不需要**指令重排序。
volatile使用内存屏障（memory Barrier）来实现的，如果在指令之间插入一条memory barrier则会告诉编译器和cpu，任何指令都不能和这条指令进行重排。内存屏障的另一个作用就是强制刷新各种cpu的缓存数据，因此cp上的任何线程都能读到最新的数据。
# CAS
CAS 是指**Compare And Swap**,比较并交换，是一种很重要的思想，如果主内存中的值跟期望的一样，那么就进行修改，否则就一直重试，直到一致为止。
AtomicInteger内部维护了volatile int value和private static final Unsafe unsafe两个比较重要的参数。

```Java
public final int getAndIncrement(){
    return unsafe.getAndAddInt(this,valueOffset,1);
}
AtomicInteger.getAndIncrement()调用了Unsafe.getAndAddInt()方法。Unsafe类的大部分方法都是native的，用来像C语言一样从底层操作内存。

public final int getAnddAddInt(Object var1,long var2,int var4){
    int var5;
    do{
        var5 = this.getIntVolatile(var1, var2);
    } while(!this.compareAndSwapInt(var1, var2, var5, var5 + var4));
    return var5;
}

```
这个方法的var1和var2，就是根据对象和偏移量得到在主内存的快照值var5。然后compareAndSwapInt方法通过var1和var2得到当前主内存的实际值。如果这个实际值跟快照值相等，那么就更新主内存的值为var5+var4。如果不等，那么就一直循环，一直获取快照，一直对比，直到实际值和快照值相等为止。

比如有A、B两个线程，一开始都从主内存中拷贝了原值为3，A线程执行到var5=this.getIntVolatile，即var5=3。此时A线程挂起，B修改原值为4，B线程执行完毕，由于加了volatile，所以这个修改是立即可见的。A线程被唤醒，执行this.compareAndSwapInt()方法，发现这个时候主内存的值不等于快照值3，所以继续循环，重新从主内存获取。
## CAS缺点
 > CAS实际上是一种自旋锁
 > - 一直循环 开销比较大
 > - 只能保证一个变量的原子操作，多个还是要加锁
 > - ABA问题

 # ABA问题
 所谓的aba问题指的是两个线程去修改同一个变量的时候，由于其中一个线程的速度比较快，将变量A修改为B又重复修改为A，对另一个线程来说是不知道的，另一个线程进行比较和交换的时候认为该A值是没有改变过的。
 ## AtomicReference
 AtomicReference可以对一个POJO进行封装，使其操作原子化
```Java
User user1 = new User("Jack",25);
User user2 = new User("Lucy",21);
AtomicReference<User> atomicReference = new AtomicReference<>();
atomicReference.set(user1);
System.out.println(atomicReference.compareAndSet(user1,user2)); // true
System.out.println(atomicReference.compareAndSet(user1,user2)); //false
```

## AtomicStampedReference
使用StomicStampedReference 可以用来解决ABA问题。这个类会维护一个版本号，在惊醒CAS操作的时候，不经要比较当前值，还需要比较版本号，两者都相同才会进行更新操作

# 集合类不安全类
# List
ArrayList是线程不安全的类，再多线程同时写入的情况下，会抛出Java.util.ConcurrentModificationException 异常
```Java
public class ContainerNotSafeDemo {


    public static void main(String[] args) {

        List<String> integers = new CopyOnWriteArrayList<String>();

        for (int i = 0; i < 300; i++) {

            new Thread(()->{
                integers.add(UUID.randomUUID().toString().substring(0,8));
            },i+"-Thread").start();

        }
        while (Thread.activeCount()>2){
            Thread.yield();
        }
        System.out.println(integers);

    }

}

```

## 解决方案

- 使用Vector,该对象存在于1.0版本，其底层将所有方法都加锁synchronized ,太重
- 使用Collecitons.SynchronizedList()转换成线程安全的，和Vector差不多
- 使用CopyOnWriteArrayLis，使用写时复制实现，

### CopyOnWriteArrayList
这是JUC的类，通过写时复制来实现的读写分离，在调用add()方法的时候会Copy一个新数组，大小是原数组+1，并将元素添加到新数组，并将原对象的指针移过来。
```Java
public boolean add(E e) {
    final ReentrantLock lock = this.lock;
    lock.lock();
    try {
        //得到旧数组
        Object[] elements = getArray();
        int len = elements.length;
        //复制新数组
        Object[] newElements = Arrays.copyOf(elements, len + 1);
        //设置新元素
        newElements[len] = e;
        //设置新数组
        setArray(newElements);
        return true;
    } finally {
        lock.unlock();
    }
}
```
## Set
跟List类似，HashSet和TreeSet都是线程不安全的，与之对应的有CopyOnWriteSet这个安全类，这个类的底层维护了一个CopyOnWriteArrayList数组
```Java
private final CopyOnWriteArrayList<E> al;
public CopyOnWriteArraySet() {
    al = new CopyOnWriteArrayList<E>();
}
```
## Map
HashMap不是线程安全的，HashTable是线程安全的，跟Vector一样 太重，所以也有类似CopyOnWrite,不过叫ConcurrentHashMap.
# Java锁
## 公平锁/非公平锁
**概念**：所谓公平锁，每个线程按照申请锁的顺序来获取锁，先到先的，**非公平锁**则是多个线程抢占锁，会导致优先级反转和饥饿现象。   

**区别**：公平锁在获取锁的时候会先查看此锁的维护队列，如果队列为或者自己在队列的队首位置，则占有锁，否则插入等待队列，FIFO原则，非公平锁比较粗鲁，上来直接尝试占有锁，失败则采用公平锁方式，非公平锁的优点是吞吐量大。

**Synchronized**和juc.ReentrantLock默认都是非公平锁，ReentrantLock在构造的时候传入True就是公平锁

## 可重入锁/递归锁
可重入锁又叫递归锁，指的是同一个线程在获取外层锁的时候，进入内层方法会自动获取锁，也就是说线程可以进入任何一个他已经拥有锁的代码块，

## 锁的匹配
锁之间要配对，加了几把锁就需要解开几把锁，不然会进入死循坏

## 自旋锁 SpinLock
 所谓自旋锁就是尝试获取锁的线程不会堵塞，会以循环分方式不断的获取锁，这样会减少线程切换上下文的开销，缺点是小号cpu，CAs的底层就是使用自旋锁思想

 ```Java

public class SpinLockDemo {

    AtomicReference<Thread> threadAtomicReference = new AtomicReference<>();

    public void lock(){

        Thread thread = Thread.currentThread();
        while (!threadAtomicReference.compareAndSet(null,thread)){
            System.out.println(Thread.currentThread().getName()+"/t 尝试中。。。。");
        }
        System.out.println(Thread.currentThread().getName()+"/t 获得了锁");
    }

    public void unlock(){
        Thread thread = Thread.currentThread();
        threadAtomicReference.compareAndSet(thread,null);
    }

    public static void main(String[] args) {

        SpinLockDemo demo1 = new SpinLockDemo();

        new Thread(()->{
            demo1.lock();
            try { TimeUnit.SECONDS.sleep(1);    }catch (Exception e){    e.printStackTrace();  }
            demo1.unlock();
            System.out.println(Thread.currentThread().getName()+"/t 完成任务");
        },"T1").start();

        new Thread(()->{
            demo1.lock();
            try { TimeUnit.SECONDS.sleep(1);    }catch (Exception e){    e.printStackTrace();  }
            demo1.unlock();
            System.out.println(Thread.currentThread().getName()+"/t 完成任务");
        },"T2").start();

    }

}
```
## 读写锁 ReadWriteLock

读写锁，即多个线程能同时读取一个资源，提高读取的并发量。但写的时候只能有一个线程写入，既JUC.ReentrantReadWriteLock

比如缓存就是用读写锁来控制的，只能一个人写，但是可以同时多个人来读，
## Synchronized和Lock的区别

1. Synchronized是JVM层面的，Lock是JDK层面的
2. 使用方法，sync不需要手动释放，lock需要配对使用，即手动释放
3. sync不可中断，除非抛出异常，Lock可以调用interrupt()方法中断
4. sync不是公平锁，lock可通过构造参数来改变是否公平
5. sync只能随机唤醒，lock可以绑定多个条件随机唤醒
6. syuc只能同步变量，方法，lock可以同步代码块

## CountDownLatch 减少计数器

**CountDownLatch** 维护了一个计数器，只有当计数器=0时，某些线程才会停止堵塞，继续执行
主要使用方法主要两个，**countDwon**计数器减一，**await()**当计数器等于0时堵塞线程自动唤醒。
## cyclicBarrier 增加计数器
与上面一个刚好相反，上面是递减，CyclicBarrier是递增，递增到一定的时候堵塞线程自动唤醒    
比如开会哪个（员工）线程先到调用（等待）await()，当所有线程到齐之后开始

 ## Semaphore 信号量
 semaphore 是一个线程同步的辅助类，可以维护当前访问自身的线程个数，并提供类同步机制，，可以控制同时访问资源的线程个数，例如实现一个文件允许的并发访问次数

  **semaphore.acquire()** 请求获取许可，许可数减一   
  **semaphonre.release()** 释放许可，许可数加一
