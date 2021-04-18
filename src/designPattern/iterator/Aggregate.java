package designPattern.iterator;

/**
 * @author mrtao
 * @date 2021/4/16 5:59 下午
 * @Description：
 */
public interface Aggregate {
    public void add(Object obj);
    public void remove(Object obj);
    public Iterator getIterator();
}
