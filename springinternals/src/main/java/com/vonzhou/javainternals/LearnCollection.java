package com.vonzhou.javainternals;

import java.util.*;

/**
 *
 * Created by vonzhou on 16/4/3.
 */
public class LearnCollection {
    public static void main(String[] args){

    }

    /**
     * 高清ArrayList, LinkedList, Vector的区别
     */
    public static void diff(){
        List list = new ArrayList();
        list.add(new Date());
        list.add("vonzhou");
        System.out.println(list);

        List list2 = new LinkedList();


        List list3 = new Vector();
    }
}


