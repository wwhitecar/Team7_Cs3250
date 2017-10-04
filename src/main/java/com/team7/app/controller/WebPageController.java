package com.team7.app.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebPageController {

	// inject via application.properties
	@Value("${app.welcome.message}")
	private String MESSAGE = "";

	@Value("${app.welcome.title}")
	private String TITLE = "";

	@Value("${app.welcome.message2}")
	private String MESSAGE2 = "";


	@RequestMapping("/welcome")
	public String welcome(Map<String, Object> model) {
		model.put("title", TITLE);
		model.put("message", MESSAGE);
		model.put("message2", MESSAGE2);
		return "welcome";
	}
	
	@RequestMapping("/create")
	public String create(Map<String, Object> model) {
		model.put("title", TITLE);
		return "create";
	}
	
	@RequestMapping("/courseCreate")
	public String courseCreate(Map<String, Object> model) {
		model.put("title", TITLE);
		return "courseCreate";
	}
	
	@RequestMapping("/courseUpdate")
	public String courseUpdate(Map<String, Object> model) {
		model.put("title", TITLE);
		return "courseUpdate";
	}
	
	@RequestMapping("/courseDelete")
	public String courseDelete(Map<String, Object> model) {
		model.put("title", TITLE);
		return "courseDelete";
	}
	
	@RequestMapping("/courseRead")
	public String courseRead(Map<String, Object> model) {
		model.put("title", TITLE);
		return "courseRead";
	}
	
	@RequestMapping("/delete")
	public String delete(Map<String, Object> model) {
		model.put("title", TITLE);
		return "delete";
	}
	
	@RequestMapping("/")
	public String index(Map<String, Object> model) {
		model.put("title", TITLE);
		return "index";
	}
	
	@RequestMapping("/professorCreate")
	public String professorCreate(Map<String, Object> model) {
		model.put("title", TITLE);
		return "professorCreate";
	}
	
	@RequestMapping("/professorDelete")
	public String professorDelete(Map<String, Object> model) {
		model.put("title", TITLE);
		return "professorDelete";
	}
	
	@RequestMapping("/professorRead")
	public String professorRead(Map<String, Object> model) {
		model.put("title", TITLE);
		return "professorRead";
	}
	
	@RequestMapping("/professorUpdate")
	public String professorUpdate(Map<String, Object> model) {
		model.put("title", TITLE);
		return "professorUpdate";
	}
	
	@RequestMapping("/read")
	public String read(Map<String, Object> model) {
		model.put("title", TITLE);
		return "read";
	}
	
	@RequestMapping("/update")
	public String update(Map<String, Object> model) {
		model.put("title", TITLE);
		return "update";
	}

	// test 5xx errors
	@RequestMapping("/5xx")
	public String ServiceUnavailable() {
		throw new RuntimeException("ABC");
	}

}