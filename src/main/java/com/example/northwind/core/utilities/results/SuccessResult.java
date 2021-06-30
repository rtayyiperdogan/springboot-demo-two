package com.example.northwind.core.utilities.results;

/**
 * @author : Recep Tayyip Erdogan
 * @since : 23-Jun-21, Wed
 **/
public class SuccessResult extends Result {
    public SuccessResult(){
        super(true);
    }
    public SuccessResult(String message){
        super(true,message);
    }
}
