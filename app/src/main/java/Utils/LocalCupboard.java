package Utils;

import model.Person;
import nl.qbusict.cupboard.Cupboard;
import nl.qbusict.cupboard.CupboardBuilder;

/**
 * 在此添加 类功能描述
 *
 * @author shanliang
 * @date 2018/8/15
 */
public class LocalCupboard {

    private static Cupboard cupboard;

    static {
        getInstance().register(Person.class);
    }

    public static Cupboard getInstance() {
        if (cupboard == null) {
            cupboard = new CupboardBuilder().build();
        }
        return cupboard;
    }

    public static Cupboard getAnnotatedInstance() {
        return new CupboardBuilder(getInstance())
                .useAnnotations()
                .build();
    }

    private LocalCupboard() {
    }

}
