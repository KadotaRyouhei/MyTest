package Utils;

import java.lang.reflect.Field;

import annotation.CarNameTarget;

/**
 * Created by shanliang on 2018/4/19.
 */

public class CarInfoUtil {
    public static void getFruitInfo(Class<?> clazz) {
        Field[] fields = clazz.getDeclaredFields();
        for(Field field : fields) {
            if(field.isAnnotationPresent(CarNameTarget.class)) {
                CarNameTarget name = (CarNameTarget) field.getAnnotation(CarNameTarget.class);
                String carColour ="汽车的中文名："+name.name();
                System.out.println(carColour);
            }
        }
    }
}
