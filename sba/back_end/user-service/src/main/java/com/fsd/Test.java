package com.fsd;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: zhuhui bao
 * @date: 21:10 2019/12/8
 **/
@RestController
@RequestMapping("test")
public class Test {
    @PostMapping("123")
    public void tt() {



    }
}
