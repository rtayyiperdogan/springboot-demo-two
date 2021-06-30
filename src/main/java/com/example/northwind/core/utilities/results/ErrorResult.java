package com.example.northwind.core.utilities.results;

/**
 * @author : Recep Tayyip Erdogan
 * @since : 23-Jun-21, Wed
 **/
public class ErrorResult extends Result {

    public ErrorResult(){
        super(false);
    }

    public ErrorResult(String message){
        super(false,message);
    }

}
