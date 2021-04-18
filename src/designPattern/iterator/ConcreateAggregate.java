package designPattern.iterator;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mrtao
 * @date 2021/4/16 5:59 下午
 * @Description：
 */
public class ConcreateAggregate implements Aggregate {

    private List<Object> list = new ArrayList<>();
    @Override
    public void add(Object obj) {
        list.add(obj);
    }

    @Override
    public void remove(Object obj) {
        list.remove(obj);
    }

    @Override
    public Iterator getIterator() {
        return (new ConcreateIterator(list));
    }
}
