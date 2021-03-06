package cn.ling.medicalview.pojo.log;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 总定义注解
 */
//在方法上作用
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Log {

    /**
     * 存放用户操作行为描述
     * @return
     */
    String value() default "";
}
