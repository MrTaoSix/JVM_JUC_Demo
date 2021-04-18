package thread;

/**
 * @author mrtao
 * @date 2021/3/18 11:21 上午
 * @Description：test
 */
public class T1 {

    volatile  int number = 0;

    public void add(){
        number++;
    }
}
