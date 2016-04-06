package com.vonzhou.javainternals;

/**
 * Created by vonzhou on 16/4/3.
 */
public class MyArrayList {
    private Object[] elementData;
    private int size;


    public MyArrayList(){

    }

    public MyArrayList(int initCapacity){
        if(initCapacity < 0){
            try {
                throw new  Exception();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        elementData = new Object[initCapacity];
    }

    public void add(Object obj){
        // ensure capacity
        if(size == elementData.length){
            Object[] newArray = new Object[size * 2 + 1];
            System.arraycopy(elementData, 0, newArray, 0, elementData.length);
            elementData = newArray;
        }

        elementData[size++] = obj;
    }

    public int size(){
        return size;
    }

    public Object get(int index){
        if( index < 0 || index >= size){
            // Exception
            System.err.println("Index Invalid");
        }

        return elementData[index];
    }






}
