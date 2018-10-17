package com.yuqiyu.chapter18.Service;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

@Service
public class Secure {

    @PreAuthorize("hasRole('ADMIN') AND hasRole('DBA')")
    public String s(){
        return "service";
    }

//    @PreAuthorize("hasRole('ADMIN')")
    public String yes(){
        return "service-yes";
    }
}
