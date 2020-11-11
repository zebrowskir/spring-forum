package com.rzeb.forum.controller;

import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class ForumErrorController implements ErrorController {

    private static final String PATH = "/error";

    @GetMapping(PATH)
    public ModelAndView error() {
        return new ModelAndView(PATH);
    }

    @GetMapping("/403")
    public ModelAndView error403() {
        return new ModelAndView("/403");
    }

    @Override
    public String getErrorPath() {
        return PATH;
    }
}
