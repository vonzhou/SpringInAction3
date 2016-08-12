package com.vonzhou.simple.controller;

import com.vonzhou.simple.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by vonzhou on 2016/8/12.
 */
@Controller
@RequestMapping("/app")
public class SimpleController {

    @RequestMapping("/hello")
    public ModelAndView hello(@RequestParam("name") String name, ModelAndView modelAndView){
        User user = new User();
        user.setName(name);
        user.setTag("You are great!");

        modelAndView.addObject("user", user);
        modelAndView.setViewName("hello.ftl");
        return modelAndView;
    }
}
