package com.ContorllerTest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Think on 2017/7/25.
 */
@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String HelloWord() {
        return " hello ,this is a Springboot Maven demo";
    }
}