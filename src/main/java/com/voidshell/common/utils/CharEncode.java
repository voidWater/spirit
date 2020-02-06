package com.voidshell.common.utils;


import org.apache.commons.codec.binary.Base64;

public class CharEncode {
    static Base64 base64 = new Base64();
    //\xF0\x9F\x90\x8C

    public static String base64Encode(String code){
        return new String(base64.encode(code.getBytes()));
    }

    public static String base64Decode(String code){

        return  new String(base64.decode(code.getBytes()));

    }
    public static void main(String[] args) {
        System.out.println(base64Decode("dm9pZHNoZWxs8J+QjA=="));
    }


}
