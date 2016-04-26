package com.vonzhou.spitter.example;

import com.vonzhou.spitter.persistence.Spitter;
import com.vonzhou.spitter.persistence.Spittle;
import com.vonzhou.spitter.service.SpitterService;
import com.vonzhou.spitter.service.SpitterServiceImpl;

import java.util.List;

/**
 * Created by vonzhou on 16/4/25.
 */
public class Main {
    public static void main(String[] args) {
        SpitterService spitterService = new SpitterServiceImpl();
        Spitter spitter = spitterService.getSpitter(12L);
        List<Spittle> spittles =
                spitterService.getSpittlesForSpitter(spitter);
        System.out.println(spittles.size());
    }
}
