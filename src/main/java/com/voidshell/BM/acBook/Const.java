package com.voidshell.BM.acBook;

public class Const {
    public static final String CURRENT_USER = "currentUser";

    public enum ResponseCode{
        SUCCESS(0,"SUCCESS"),
        ERROR(1,"ERROR"),
        NEED_LOGIN(10,"NEED_LOGIN");

        private final int code;
        private final String desc;
        ResponseCode(int code,String desc){
            this.code = code;
            this.desc = desc;
        }
        public int getCode(){
            return code;
        }
        public String getDesc(){
            return desc;
        }
    }
    public enum ResponseErrorCode{
        ILLEGAL_ARGUMENT(-2,"ILLEGAL_ARGUMENT"),
        NO_PERMISSION(-3,"NO_PERMISSION");
        private final int code;
        private final String desc;
        ResponseErrorCode(int code,String desc){
            this.code = code;
            this.desc = desc;
        }
        public int getCode(){
            return code;
        }
        public String getDesc(){
            return desc;
        }
    }

    public enum Comm{
        PARAM_DEF(-3,"参数缺失");
        private final Integer code;
        private final String desc;
        Comm(Integer code,String desc){
            this.code = code;
            this.desc = desc;
        }
        public Integer getCode(){
            return code;
        }
        public String getDesc(){
            return desc;
        }
    }

    public enum Item{

    }
}
