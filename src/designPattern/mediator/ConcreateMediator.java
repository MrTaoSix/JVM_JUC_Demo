package designPattern.mediator;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mrtao
 * @date 2021/4/16 5:25 下午
 * @Description：
 */
public class ConcreateMediator extends  Mediator {

    private List<Colleague> colleagues = new ArrayList<>();

    @Override
    public void register(Colleague colleague) {
        if (!colleagues.contains(colleague)){
            colleagues.add(colleague);
            colleague.setMedium(this);
        }

    }

    @Override
    public void relay(Colleague cl) {
        for (Colleague ob : colleagues) {
            if (!ob.equals(cl)) {
                ((Colleague) ob).receive();
            }
        }
    }
}
