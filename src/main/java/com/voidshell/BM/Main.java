package com.voidshell.BM;

import java.io.UnsupportedEncodingException;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        String s = "12";
        System.out.println(12);

        String str  ="nihao 你好 喬亂";
        str = str.replace("nihao","buhao");
// 字符串转化成 byte 数组
        //str.value
        byte[] bytes = new byte[0];
        try {
            bytes = str.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
// byte 数组转化成字符串
        String s2 = new String(bytes);
        System.out.println(s2);

//        Random r = new Random();
//        for (int i = 0; i < 6; i++) {
//            int num = r.nextInt(9); // 生成[0,9]区间的整数
//            System.out.print(num);
//        }
//        int num = 10;
//        int limit = 20;
//        Random r = new Random();
//        List<Integer> list = new ArrayList();
//        Set<Integer> set = new HashSet<Integer>();
//
//        while(set.size()<10){
//            set.add(r.nextInt(20));
//        }
//
////        for (int i = 0; i < num; i++) {
////            list.add(r.nextInt(20));
////        }
//        set.forEach(s->{
//            System.out.println(s);
//        });
    }
}
