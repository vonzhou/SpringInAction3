package com.vonzhou.spitter.controller;

import static org.springframework.web.bind.annotation.RequestMethod.*;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//@Controller
@RequestMapping("/login")
public class LoginController {
  @RequestMapping(method=GET)
  public String showLoginForm() {
    return "login2";
  }
}
