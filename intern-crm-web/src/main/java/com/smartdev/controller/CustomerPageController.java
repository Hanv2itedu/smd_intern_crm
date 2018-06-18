package com.smartdev.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CustomerPageController {
    @RequestMapping(value = "/addcustomer",method = RequestMethod.GET)
    public String addCustomer(){
        return "addcustomer";
    }
}
