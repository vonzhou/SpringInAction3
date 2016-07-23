package com.vonzhou.learning.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * Created by vonzhou on 16/7/22.
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {


    @RequestMapping(value = "/service")
    public String serveUser(HttpServletRequest request, HttpServletResponse response, Locale locale, ModelMap model) {
        // Do some computation
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // update the model
        model.put("hello", "Some Data");

        return "home";
    }
}
