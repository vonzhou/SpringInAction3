package com.vonzhou.spitter.common;

/**
 * Created by vonzhou on 16/4/20.
 */
public class ImageUploadException extends RuntimeException {

    public ImageUploadException(String msg){
        super(msg);
    }

    public String getMessage(){
        return super.getMessage();
    }
}
