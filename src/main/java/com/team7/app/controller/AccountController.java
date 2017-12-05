package com.team7.app.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

    @RequestMapping
    public String getStudentAccount(int studentID){
        return "Student Account:" + studentID;
    }

    @RequestMapping
    public String getProfessorAccount(int professorID){
        return "Student Account:" + professorID;
    }

    @RequestMapping
    public String getAdminAccount(int adminID){
        return "Student Account:" + adminID;
    }
}
