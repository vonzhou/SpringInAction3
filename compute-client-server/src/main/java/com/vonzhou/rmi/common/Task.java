package com.vonzhou.rmi.common;

/**
 * Created by vonzhou on 16/4/23.
 */
public interface Task<T> {
    T execute();
}
