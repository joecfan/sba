package com.sfd.payment.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: zhuhui bao
 * @date: 16:23 2019/12/16
 **/
@RestController
@RequestMapping("payment")
public class DemoController {

    @RequestMapping("test")
    public String test() {
        return "test";
    }
}
