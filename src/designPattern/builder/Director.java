package designPattern.builder;

/**
 * @author mrtao
 * @date 2021/4/12 3:11 下午
 * @Description：
 */
public class Director {

    private Builder builder;

    public Director(Builder builder){
        this.builder = builder;
    }

    public Product construct(){
        builder.setAtt1();
        builder.setAtt2();
        builder.setAtt3();
        return builder.product;
    }

}
