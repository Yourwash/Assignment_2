/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.assignment_2.TrainerData.repos;

import com.assignment_2.TrainerData.model.Subjects;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author georg
 */
@Repository
public interface SubjectRepo extends JpaRepository<Subjects, Integer>{}
