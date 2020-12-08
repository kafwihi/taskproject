package com.taskproject.taskproject.interviews;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
//import javax.validation.constraints.NotBlank;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.taskproject.taskproject.applicants.applicantModel;
import com.taskproject.taskproject.jobs.jobModel;
import com.fasterxml.jackson.annotation.JsonIgnore;
//import lyrn.school.school.admission.model.Student;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Table(name = "interviews")
public class bookModel implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "interview_id")
    private long  interview_id;    
     
    @ManyToOne(cascade = CascadeType.ALL)
    //@JoinColumn(name = "username", nullable = false)
    @JsonIgnore
    applicantModel applicant;
  
   @ManyToOne(cascade = CascadeType.ALL)
    //@JoinColumn(name = "jobname", nullable = false)
    @JsonIgnore
    jobModel career;
    
    public bookModel(){
        super();
    }

    public jobModel getJobModel() {
    return career;
    } 

    public void  setJobModel(jobModel career) {
        this.career = career;
    }

    public applicantModel getApplicantModel() {
        return applicant;
    }
    public void  setApplicantModel(applicantModel applicant) {
        this.applicant = applicant;
    }

    public bookModel(applicantModel applicant){

        super();
    this.applicant =applicant;
    }
public bookModel( jobModel career){

        super();
    this.career = career;
    }
    

}