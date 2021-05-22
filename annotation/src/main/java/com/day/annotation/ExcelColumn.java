package com.day.annotation;

import java.lang.annotation.*;


/**
 * 实现对于excel导出的时候的字段实现标注使用
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ExcelColumn {

    String value() default "";

    int col() default 0;
}