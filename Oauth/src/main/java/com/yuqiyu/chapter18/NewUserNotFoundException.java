package com.yuqiyu.chapter18;


public class NewUserNotFoundException
        extends RuntimeException
{


    public NewUserNotFoundException(String msg) {

        super(msg);
        System.out.println("f+"+msg);
    }
}
