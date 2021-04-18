package designPattern.builder;

/**
 * @author mrtao
 * @date 2021/4/12 3:08 下午
 * @Description：
 */
abstract class Builder {

    protected Product product = new Product();

    abstract void setAtt1();

    abstract void setAtt2();

    abstract void setAtt3();


    public Product getResult(){
        return product;
    }

}
