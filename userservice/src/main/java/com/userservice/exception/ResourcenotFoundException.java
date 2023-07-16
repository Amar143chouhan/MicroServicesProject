package com.userservice.exception;

public class ResourcenotFoundException extends  RuntimeException
{


    public ResourcenotFoundException()
    {

        super("resource not found on server");
    }


     public  ResourcenotFoundException(String msg){

        super(msg);

     }
}
