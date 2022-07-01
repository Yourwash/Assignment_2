/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.assignment_2.TrainerData.controller;

import static com.assignment_2.TrainerData.Utils.KeyGenerator.trainerKeyGenerator;
import com.assignment_2.TrainerData.model.Subjects;
import com.assignment_2.TrainerData.model.Trainers;
import com.assignment_2.TrainerData.service.SubjectServiceInterface;
import com.assignment_2.TrainerData.service.TrainerServiceInterface;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author georg
 */
@Controller
public class TrainerController {

    @Autowired
    SubjectServiceInterface subjectService;
    @Autowired
    TrainerServiceInterface trainerService;

    @PostMapping("/create")
    public String create(@RequestParam("trnFirstName") String fName,
            @RequestParam("trnLastName") String lName,
            @RequestParam("subjectIdSet") List<Integer> subKeys) {
        Trainers t = new Trainers();
        t.setTrainerKey(trainerKeyGenerator()); //Ids are not Auto Incremented due to continuity from last project.
        t.setTrnFirstName(fName);
        t.setTrnLastName(lName);
        Set<Subjects> targetSet = new HashSet<>(subjectService.getAllSubjects((subKeys)));
        t.setSubjectsSet(targetSet);
        trainerService.insertTrainer(t);
        return ("redirect: /");
    }

    @GetMapping("/delete/{key}")
    public String delete(@PathVariable("key") Integer key) {
        trainerService.deleteTrainer(key);
        return ("redirect: /");
    }

    @PostMapping("/update/{key}")
    public String update(@PathVariable("key") Integer key, @RequestParam("trnFirstName") String fName,
            @RequestParam("trnLastName") String lName,
            @RequestParam("subjectIdSet") List<Integer> subKeys) {
        Set<Subjects> targetSet = new HashSet<>(subjectService.getAllSubjects((subKeys)));
        trainerService.updateTrainer(key, fName, lName, targetSet);
        return ("redirect: /");
    }
}
