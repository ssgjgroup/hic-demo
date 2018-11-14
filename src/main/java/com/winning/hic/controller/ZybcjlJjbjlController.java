package com.winning.hic.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ZybcjlJjbjlController extends BaseController{

    private final Logger logger = LoggerFactory.getLogger(ZybcjlJjbjlController.class);

    @RequestMapping("/zybcjlJjbjl/index")
    public String index() {


        return "/dataLoad/index";
    }






}
