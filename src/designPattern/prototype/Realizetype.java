package designPattern.prototype;

/**
 * @author mrtao
 * @date 2021/4/10 4:30 下午
 * @Description：浅克隆
 */
public class Realizetype  implements  Cloneable{
    Realizetype(){

    }
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

