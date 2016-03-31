package com.vonzhou.springinaction.springidolaop;

import org.aspectj.lang.ProceedingJoinPoint;

public class Audience {
    // 表演之前
    public void takeSeats() { //<co id="co_takeSeats"/>
        System.out.println("The audience is taking their seats.");
    }
    // 表演之前
    public void turnOffCellPhones() { //<co id="co_turnOffCellPhones"/>
        System.out.println("The audience is turning off their cellphones");
    }
    // 表演之后
    public void applaud() { //<co id="co_applaud"/>
        System.out.println("CLAP CLAP CLAP CLAP CLAP");
    }
    // 表演失败之后
    public void demandRefund() { //<co id="co_demandRefund"/>
        System.out.println("Boo! We want our money back!");
    }
}