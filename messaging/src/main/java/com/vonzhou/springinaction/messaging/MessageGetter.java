package com.vonzhou.springinaction.messaging;

public class MessageGetter {
    public void echo(Book book){
        System.out.println("Book:" + book.getTitle());
    }
    public void echo(String string) {
        System.out.println("GOT A MESSAGE:  " + string);
    }
}
