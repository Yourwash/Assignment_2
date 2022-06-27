/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.assignment_2.TrainerData.model;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author georg
 */
@Entity
@Table(name = "subjects")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Subjects.findAll", query = "SELECT s FROM Subjects s"),
    @NamedQuery(name = "Subjects.findBySubjectKey", query = "SELECT s FROM Subjects s WHERE s.subjectKey = :subjectKey"),
    @NamedQuery(name = "Subjects.findBySubTitle", query = "SELECT s FROM Subjects s WHERE s.subTitle = :subTitle")})
public class Subjects implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "subjectKey")
    private Integer subjectKey;
    @Column(name = "subTitle")
    private String subTitle;  
    @ManyToMany(mappedBy = "subjectsSet")
    private Set<Trainers> trainersSet;

    public Subjects() {
    }

    public Subjects(Integer subjectKey) {
        this.subjectKey = subjectKey;
    }

    public Integer getSubjectKey() {
        return subjectKey;
    }

    public void setSubjectKey(Integer subjectKey) {
        this.subjectKey = subjectKey;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    @XmlTransient
    public Set<Trainers> getTrainersSet() {
        return trainersSet;
    }

    public void setTrainersSet(Set<Trainers> trainersSet) {
        this.trainersSet = trainersSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (subjectKey != null ? subjectKey.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Subjects)) {
            return false;
        }
        Subjects other = (Subjects) object;
        if ((this.subjectKey == null && other.subjectKey != null) || (this.subjectKey != null && !this.subjectKey.equals(other.subjectKey))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.assignment_2.TrainerData.model.Subjects[ subjectKey=" + subjectKey + " ]";
    }
    
}
