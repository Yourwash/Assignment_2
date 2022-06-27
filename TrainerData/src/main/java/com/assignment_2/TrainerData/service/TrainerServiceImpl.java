/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.assignment_2.TrainerData.service;

import com.assignment_2.TrainerData.model.Subjects;
import com.assignment_2.TrainerData.model.Trainers;
import com.assignment_2.TrainerData.repos.TrainerRepo;
import java.util.List;
import java.util.Set;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author georg
 */
@Service
public class TrainerServiceImpl implements TrainerServiceInterface {

    @Autowired
    TrainerRepo trainerRepo;

    @Override
    public List<Trainers> getAllTrainers() {
        return (trainerRepo.findAll());
    }

    @Override
    public void insertTrainer(Trainers t) {
        trainerRepo.save(t);
    }

    @Override
    public void deleteTrainer(Integer Key) {
        trainerRepo.delete(trainerRepo.findById(Key).get());
    }

    @Override
    @Transactional
    public void updateTrainer(Integer Key, String fName, String lName, Set<Subjects> sS) {
        Trainers t = trainerRepo.findById(Key).get();
        t.setTrnFirstName(fName);
        t.setTrnLastName(lName);
        t.setSubjectsSet(sS);
    }
}
