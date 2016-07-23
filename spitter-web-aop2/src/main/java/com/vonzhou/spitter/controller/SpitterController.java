package com.vonzhou.spitter.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.logging.Logger;


/**
 * Created by vonzhou on 16/4/20.
 */
@Controller
@RequestMapping("/spitter")
public class SpitterController {

    private Logger logger = Logger.getLogger("SpitterController.class");


    @RequestMapping(method = RequestMethod.GET, params = "new")
    public String createSpitterProfile(Model model) {

        model.addAttribute("key", "val");

        return "home";
    }


}
