package com.PaymentApi.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {

	@GetMapping(value = {"/","/index"})
	public String indexPage() {
		return "index";
	}
	
}
