/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.assignment_2.TrainerData.service;

import com.assignment_2.TrainerData.model.Subjects;
import com.assignment_2.TrainerData.model.Trainers;
import java.util.List;
import java.util.Set;

/**
 *
 * @author georg
 */
public interface TrainerServiceInterface {
    public List<Trainers> getAllTrainers();
    public void insertTrainer(Trainers t);
    public void deleteTrainer(Integer Key);
    public void updateTrainer(Integer Key, String fName, String lName,Set<Subjects> sS);
}
