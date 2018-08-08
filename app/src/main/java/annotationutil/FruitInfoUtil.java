package annotationutil;

import java.lang.reflect.Field;

import annotation.FruitName;
import annotation.FruitProvider;

/**
 * 在此添加 类功能描述
 *
 * @author shanliang
 * @date 2018/7/23
 */
public class FruitInfoUtil {
    public static void getFruitInfo(Class<?> clazz) {
        String strFruitName = "水果名称：";
        String strFruitProvider = "供应商信息：";

        Field[] fields = clazz.getDeclaredFields();

        for(Field field : fields) {
            if(field.isAnnotationPresent(FruitName.class)) {
                FruitName fruitName = (FruitName)
                        field.getAnnotation(FruitName.class);
                strFruitName = strFruitName + fruitName.value();
            } else if(field.isAnnotationPresent(FruitProvider.class)) {
                FruitProvider fruitProvider = (FruitProvider)
                        field.getAnnotation(FruitProvider.class);
                strFruitProvider = strFruitProvider + "供应商编号：" + fruitProvider.address() + "供应商名称：" + fruitProvider.name()
                        + "供应商地址：" + fruitProvider.address();
            }
        }
    }
}
