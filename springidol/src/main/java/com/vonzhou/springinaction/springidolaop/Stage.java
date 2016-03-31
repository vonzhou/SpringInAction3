package com.vonzhou.springinaction.springidolaop;

public class Stage {
    private Stage() {
    }

    // 静态内部类
    private static class StageSingletonHolder {
        static Stage instance = new Stage(); //<co id="co_lazyLoad"/>
    }

    public static Stage getInstance() {
        return StageSingletonHolder.instance; //<co id="co_returnInstance"/>
    }
}
