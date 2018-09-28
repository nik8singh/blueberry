package com.mana.spring.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserSuccessController {

	@RequestMapping("/userSuccess.htm")
	public String redirect()
	{
		System.out.println("redirect method");
		return "userSuccess";
	}
}
