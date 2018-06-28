package com.smartdev.controller.seller;

import com.smartdev.crm.service.CustomerService;
import com.smartdev.crm.service.user.UserService;
import com.smartdev.user.entity.Customer;
import com.smartdev.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/seller")
public class HomePageSellerController {
	@Autowired
	CustomerService customerService;
	@Autowired
	UserService userService;
	@RequestMapping(value = "/list-custom-seller", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView listCustomSeller(Principal principal){
		String username = principal.getName();
		System.out.println("ten"+username);
		User user = userService.findOneUser(username);
		System.out.println(user);
		List<Customer> customers = customerService.findByuserBySeller(user);
		ModelAndView modelAndView = new ModelAndView("list-custom-seller");
		modelAndView.addObject("customers",customers);
		return modelAndView;
	}

}

