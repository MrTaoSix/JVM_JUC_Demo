package designPattern.visitor;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author mrtao
 * @date 2021/4/17 2:57 下午
 * @Description：
 */
public class ObjectStructure {

    private List<Element> list = new ArrayList<>();

    public void accpt(Visitor visitor){
        Iterator<Element> i = list.iterator();
        while (i.hasNext()){
            i.next().accept(visitor);
        }
    }

    public void add(Element element) {
        list.add(element);
    }
    public void remove(Element element) {
        list.remove(element);
    }

}
