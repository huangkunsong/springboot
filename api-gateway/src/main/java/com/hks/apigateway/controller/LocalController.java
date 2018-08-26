package com.hks.apigateway.controller;

import com.hks.apigateway.common.ApplicationException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/local")
public class LocalController {

    @RequestMapping(path="/bb", method = RequestMethod.GET)
    public List aa() {
        throw new ApplicationException(403, "aaa","报错了");
        /*return Arrays.asList(new String[]{"aaa", "bbb"});*/
    }
}
