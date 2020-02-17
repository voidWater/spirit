package com.voidshell.common.utils;

import org.apache.commons.lang3.ArchUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.JavaVersion;
import org.apache.commons.lang3.SystemUtils;

public class CommonsExample {
    /**
     *
     * ArrayUtils
     * BooleanUtils
     * ClassPathUtils
     * EnumUtils
     * ObjectUtils
     * RandomUtils
     * StringUtils
     * NumberUtils
     * DateUtils
     * DateFormatUtils
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
        //arrayDemo();

        //systemDemo();


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
