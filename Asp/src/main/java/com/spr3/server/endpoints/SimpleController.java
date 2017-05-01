package com.spr3.server.endpoints;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spr3.server.service.HelloBO;

@Controller
public class SimpleController {
	
	@Autowired
	private HelloBO helloBO;


	@RequestMapping(value="/hello", method = RequestMethod.GET)
	@ResponseBody
	public String sayHello()
	{
		helloBO.sayHello();
		helloBO.bye();
		return "hello";
	}
}
