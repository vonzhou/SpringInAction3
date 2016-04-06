package com.vonzhou.javainternals;

/**
 * Created by vonzhou on 16/4/3.
 */
public class InterfaceExtendTest implements InterfaceB{
    public void func() {
        //
    }
}


interface InterfaceA{
    void func();
}

interface InterfaceB extends InterfaceA{

}