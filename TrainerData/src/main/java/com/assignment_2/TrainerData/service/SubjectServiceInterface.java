/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.assignment_2.TrainerData.service;

import com.assignment_2.TrainerData.model.Subjects;
import java.util.List;
import java.util.Set;

/**
 *
 * @author georg
 */
public interface SubjectServiceInterface {
    public List<Subjects> getAllSubjects();
    public List<Subjects> getAllSubjects(List<Integer> subKeys);
}
