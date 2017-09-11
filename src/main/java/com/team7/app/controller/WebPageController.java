package com.team7.app.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebPageController {

	@RequestMapping("/greeting")
	String home() {return "Hello world!";}

}
