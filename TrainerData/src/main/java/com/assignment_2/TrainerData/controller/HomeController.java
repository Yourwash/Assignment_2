package com.assignment_2.TrainerData.controller;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import com.assignment_2.TrainerData.service.SubjectServiceInterface;
import com.assignment_2.TrainerData.service.TrainerServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author georg
 */
@Controller
public class HomeController {
    
@Autowired
TrainerServiceInterface trainerService;
@Autowired
SubjectServiceInterface subjectService;

    @GetMapping("/")
    public String showWelcomePage(ModelMap mm) {
        mm.addAttribute("trainerList",trainerService.getAllTrainers());
        mm.addAttribute("subjectList",subjectService.getAllSubjects());
        return "Home";
    }
}
 