package com.yuqiyu.chapter18.controller;

import com.yuqiyu.chapter18.Service.Secure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/secure")
public class SecureController {
    @Autowired
    Secure secure;

    @RequestMapping(method = RequestMethod.GET)
    public String sayHello() {
        return "Secure Hello!";
    }


    @RequestMapping(method = RequestMethod.POST,value = "/on")
    public String sayHellop(@RequestBody HashMap map) {

        return secure.s();
    }
    @RequestMapping(method = RequestMethod.POST,value = "/yes")
    public String AccesstoAccess() {
        return secure.yes();
    }

}
