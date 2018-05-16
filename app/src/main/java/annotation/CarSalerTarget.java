package annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by shanliang on 2018/4/19.
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface CarSalerTarget {
    public String salerName();
    public int age() default  1;
}
