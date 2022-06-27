/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.assignment_2.TrainerData.service;

import com.assignment_2.TrainerData.model.Subjects;
import com.assignment_2.TrainerData.repos.SubjectRepo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author georg
 */
@Service
public class SubjectServiceImpl implements SubjectServiceInterface {
    
    @Autowired
    SubjectRepo subjectRepo;

    @Override
    public List<Subjects> getAllSubjects() {
       return(subjectRepo.findAll());
    }

    @Override
    public List<Subjects> getAllSubjects(List<Integer> subKeys) {
        return(subjectRepo.findAllById(subKeys));
    }
    
}
