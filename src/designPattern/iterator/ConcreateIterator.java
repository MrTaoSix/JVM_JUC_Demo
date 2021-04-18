package designPattern.iterator;

import java.util.List;

/**
 * @author mrtao
 * @date 2021/4/16 5:50 下午
 * @Description：
 */
public class ConcreateIterator implements Iterator {
    private List<Object> list = null;
    private int index = -1;

    public ConcreateIterator(java.util.List<Object> list) {
        this.list = list;
    }

    @Override
    public Object first() {
        index = 0;
        Object obj = list.get(index);
        return obj;
    }
    @Override
    public Object next() {
        Object obj = null;
        if (this.hasNext()){
          obj = list.get(++index);
        }
        return obj;
    }

    @Override
    public boolean hasNext() {
        if (index< list.size()-1){
            return true;
        }else {
            return false;
        }
    }
}
