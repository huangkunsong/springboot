package com.hks.apigateway.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/local")
public class LocalController {

    @RequestMapping(path="/bb", method = RequestMethod.GET)
    public String aa() {
        return "aaaa";
    }
}
