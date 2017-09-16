package com.team7.app.controller;

import com.team7.app.business.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class WebPageController {

	@RequestMapping("/greeting")
	String home() {return "Hello world!";}

    @RequestMapping(value="/createUser", method=RequestMethod.GET)
    public String createUser(@RequestParam("Id")int id, @RequestParam("First Name")String firstName,
                             @RequestParam("Last Name")String lastName) {
        UserDto user = new UserDto();
        UserController uC = new UserController();
        user.setFirstName(firstName);
        user.setId(id);
        user.setLastName(lastName);

        return uC.createUser(user);
    }
}
