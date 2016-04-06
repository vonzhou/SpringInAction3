package com.vonzhou.example;

/**
 * Created by vonzhou on 16/4/1.
 */
public abstract class GetBeanTest {
    public void showMe(){
        this.getBean().showMe();
    }
    public abstract User getBean();
}
