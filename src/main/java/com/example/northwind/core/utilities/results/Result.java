package com.example.northwind.core.utilities.results;

/**
 * @author : Recep Tayyip Erdogan
 * @since : 27-May-21, Thu
 **/
public class Result {

    private boolean success;
    private String message;

    public Result(boolean success) {
        this.success = success;
    }

    public Result(boolean success, String message) {
        this(success);
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }
}
