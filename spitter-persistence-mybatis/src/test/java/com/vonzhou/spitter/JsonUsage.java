package com.vonzhou.spitter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vonzhou.spitter.domain.Spitter;
import com.vonzhou.spitter.domain.Spittle;

import java.util.Date;

/**
 * Created by vonzhou on 16/7/12.
 */
public class JsonUsage {
    public static void main(String[] args) throws Exception{
        ObjectMapper objectMapper = new ObjectMapper();
        Spitter spitter = new Spitter();
        spitter.setId(1L);
        spitter.setUsername("vonzhou");
        spitter.setEmail("123@qq,cin");

        Spittle spittle = new Spittle();
        spittle.setId(1L);
        spittle.setText("Hello World.");
        spittle.setWhen(new Date());

        spittle.setSpitter(spitter);

        String jsonInString = objectMapper.writeValueAsString(spittle);
        System.out.println(jsonInString);
    }
}
