/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.assignment_2.TrainerData.model;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
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
@Table(name = "trainers")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Trainers.findAll", query = "SELECT t FROM Trainers t"),
    @NamedQuery(name = "Trainers.findByTrainerKey", query = "SELECT t FROM Trainers t WHERE t.trainerKey = :trainerKey"),
    @NamedQuery(name = "Trainers.findByTrnFirstName", query = "SELECT t FROM Trainers t WHERE t.trnFirstName = :trnFirstName"),
    @NamedQuery(name = "Trainers.findByTrnLastName", query = "SELECT t FROM Trainers t WHERE t.trnLastName = :trnLastName")})
public class Trainers implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "trainerKey")
    private Integer trainerKey;
    @Column(name = "trnFirstName")
    private String trnFirstName;
    @Column(name = "trnLastName")
    private String trnLastName;
    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.REFRESH})
    @JoinTable(name = "trainers_has_subjects", joinColumns = {
        @JoinColumn(name = "ths_trainerKey", referencedColumnName = "trainerKey")}, inverseJoinColumns = {
        @JoinColumn(name = "ths_subjectKey", referencedColumnName = "subjectKey")})
    private Set<Subjects> subjectsSet;

    public Trainers() {
    }

    public Trainers(Integer trainerKey) {
        this.trainerKey = trainerKey;
    }

    public Integer getTrainerKey() {
        return trainerKey;
    }

    public void setTrainerKey(Integer trainerKey) {
        this.trainerKey = trainerKey;
    }

    public String getTrnFirstName() {
        return trnFirstName;
    }

    public void setTrnFirstName(String trnFirstName) {
        this.trnFirstName = trnFirstName;
    }

    public String getTrnLastName() {
        return trnLastName;
    }

    public void setTrnLastName(String trnLastName) {
        this.trnLastName = trnLastName;
    }

    @XmlTransient
    public Set<Subjects> getSubjectsSet() {
        return subjectsSet;
    }

    public void setSubjectsSet(Set<Subjects> subjectsSet) {
        this.subjectsSet = subjectsSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (trainerKey != null ? trainerKey.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Trainers)) {
            return false;
        }
        Trainers other = (Trainers) object;
        if ((this.trainerKey == null && other.trainerKey != null) || (this.trainerKey != null && !this.trainerKey.equals(other.trainerKey))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.assignment_2.TrainerData.model.Trainers[ trainerKey=" + trainerKey + " ]";
    }

}
