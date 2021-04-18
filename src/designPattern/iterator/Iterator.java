package designPattern.iterator;

import java.util.Objects;

/**
 * @author mrtao
 * @date 2021/4/16 5:49 下午
 * @Description：
 */
 interface Iterator {
     Object first();
     Object next();
    boolean hasNext();
}
