package com.voidshell.common.utils;

import org.apache.commons.lang3.ArchUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.JavaVersion;
import org.apache.commons.lang3.SystemUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class CommonsExample {
    /**
     *
     * -ArrayUtils
     * BooleanUtils
     * ClassPathUtils
     * EnumUtils
     * ObjectUtils
     * RandomUtils
     * StringUtils
     * NumberUtils
     * -DateUtils
     * -DateFormatUtils
     * ClassUtils
     *
     * ArchUtils
     * -SystemUtils
     * CharUtils
     * CharSetUtils
     * CharSequenceUtils
     * ConcurrentUtils
     * ConstructorUtils
     * EnumUtils
     * EventUtils
     * ExceptionUtils
     * FieldUtils
     * IEEE754rUtils
     * LocaleUtils
     * MethodUtils
     * RandomStringUtils
     * RandomUtils
     * StopWatch
     * SerializationUtils
     * StringEscapeUtils
     * ThreadUtils
     * TypeUtils
     * WordUtils
     * @param args
     */
    public static void main(String[] args) {
        dateDemo();
    }

    private static void dateDemo() {
        System.out.println("date一般用法");
        System.out.println(DateUtils.addDays(new Date(),1));
        System.out.println(DateUtils.round(new Date(),DateUtils.RANGE_MONTH_MONDAY));
        System.out.println("format一般用法");
        System.out.println(DateFormatUtils.format(new Date(),"yyyy-MM-dd"));
        System.out.println(DateFormatUtils.format(System.currentTimeMillis(),"yyyy-MM-dd hh:mm:ss"));
        System.out.println(DateFormatUtils.format(Calendar.getInstance(),"yyyy-MM-dd hh:mm:ss"));
        System.out.println("format指定地区");
        System.out.println(DateFormatUtils.format(new Date(),"yyyy-MM-dd hh:mm:ss",TimeZone.getDefault(), Locale.GERMAN));
        System.out.println(DateFormatUtils.format(System.currentTimeMillis(),"yyyy-MM-dd hh:mm:ss", Locale.FRANCE));
        System.out.println(DateFormatUtils.format(Calendar.getInstance(),"yyyy-MM-dd hh:mm:ss", Locale.FRANCE));
    }

    private static void systemDemo() {
        System.out.println(SystemUtils.getHostName());
        System.out.println(SystemUtils.getJavaHome());
        System.out.println(SystemUtils.getJavaIoTmpDir());
        System.out.println(SystemUtils.getUserDir());
        System.out.println(SystemUtils.getUserHome());
        System.out.println(SystemUtils.isJavaAwtHeadless());
        System.out.println(SystemUtils.isJavaVersionAtLeast(JavaVersion.JAVA_1_8));
        System.out.println(SystemUtils.IS_OS_IRIX);
    }

    private static void arrayDemo() {
        System.out.println("-----ArrayUtils-----");
        int[] a = new int[]{};
        a = ArrayUtils.add(a,1);
        System.out.println("为数组添加指定数据，返回新的数组引用");
        System.out.println(a[0]);
        a = ArrayUtils.addAll(a,2,4,1);
        System.out.println(ArrayUtils.toString(a));
        System.out.println("克隆数组(不知道有什么卵用)");
        System.out.println(a);
        a=ArrayUtils.clone(a);
        System.out.println(a);
        System.out.println("判断数组是否存在某个元素");
        System.out.println(ArrayUtils.contains(a,4));
        System.out.println("以安全的方式返回数组长度");
        System.out.println(ArrayUtils.getLength(a));
        System.out.println(ArrayUtils.getLength(null));
        System.out.println("判空");
        System.out.println(ArrayUtils.isEmpty(a));
        System.out.println(ArrayUtils.isNotEmpty(a));
        System.out.println("判断某个元素是否存在");
        System.out.println(ArrayUtils.lastIndexOf(a,1));
        System.out.println(ArrayUtils.lastIndexOf(a,1,2));
        System.out.println("移除元素");
        System.out.println(ArrayUtils.toString(ArrayUtils.remove(a,1)));
        System.out.println("数组排序");
        ArrayUtils.shuffle(a);
        System.out.println(ArrayUtils.toString(a));
        System.out.println("打印数组");
        System.out.println(ArrayUtils.toString(a));
    }
}
