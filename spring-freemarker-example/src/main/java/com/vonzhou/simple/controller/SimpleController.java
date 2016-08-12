package com.vonzhou.simple.controller;

import com.vonzhou.simple.domain.User;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by vonzhou on 2016/8/12.
 */
@Controller
public class SimpleController {
    private Logger logger = Logger.getLogger(SimpleController.class);

    @RequestMapping("/index")
    public void index(HttpServletRequest request, HttpServletResponse response){
        try {
            response.sendRedirect(request.getContextPath() + "/index.html");
        } catch (IOException e) {
            logger.info("redirect error!");
        }
    }
    @RequestMapping("/test")
    public ModelAndView hello(@RequestParam("name") String name, ModelAndView modelAndView){
        User user = new User();
        user.setName(name);
        user.setTag("You are great!");

        modelAndView.addObject("user", user);
        modelAndView.setViewName("hello");
        return modelAndView;
    }
}
