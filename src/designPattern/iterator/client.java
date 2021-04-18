package designPattern.iterator;

/**
 * @author mrtao
 * @date 2021/4/16 6:01 下午
 * @Description：
 */
public class client {
    public static void main(String[] args) {
        Aggregate ag = new ConcreateAggregate();
        ag.add("中山大学");
        ag.add("华南理工");
        ag.add("韶关学院");
        System.out.println("聚合的内容有：");
        Iterator it = ag.getIterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }

    }

}
