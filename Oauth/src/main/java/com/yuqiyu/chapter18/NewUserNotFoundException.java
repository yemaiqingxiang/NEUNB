package com.yuqiyu.chapter18;


public class NewUserNotFoundException
        extends RuntimeException
{

    public NewUserNotFoundException(String msg, Throwable t) {
        super(msg, t);
    }

    public NewUserNotFoundException(String msg) {
        super(msg);
    }
}
