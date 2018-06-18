package com.smartdev.controller;

import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller

public class HomePageController {
	@RequestMapping(value="/", method = RequestMethod.GET)
	public String login(){
		return "login";
	}
	@RequestMapping(value="/home", method = RequestMethod.GET)
	public String home(){
		return "home";
	}

	@RequestMapping(value = "/list-custom-manage", method = RequestMethod.GET)
	public String listCustomManage(){
		return "list-custom-manage";
	}

	@RequestMapping(value = "/list-custom-seller", method = RequestMethod.GET)
	public String listCustomSeller(){
		return "list-custom-seller";
	}
}
