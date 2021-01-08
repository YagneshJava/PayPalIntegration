package com.PaymentApi.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentAPIController {

	@GetMapping(value = "/welcome")
	@ResponseBody
	public String getWelcome() {
		return "Done";
	}
	
}
