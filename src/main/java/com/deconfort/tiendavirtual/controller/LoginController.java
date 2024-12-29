package com.deconfort.tiendavirtual.controller;

import jakarta.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class LoginController {


    @GetMapping("/login")
    public String verLogin(){
        return "login";
    }

    @PostMapping("/login")
    public ModelAndView verLogin(HttpSession session,
                                 @RequestParam("username") String username,
                                 @RequestParam("password") String password) {


        if (username.equals("josepsito") && password.equals("123456")) {
            session.setAttribute("user", username);
            return new ModelAndView("principal","user",session.getAttribute("user"));
        }

        ModelAndView modelAndView = new ModelAndView("login");
        modelAndView.addObject("error", "Datos Incorrectos");
        return modelAndView;
    }

}