package com.taskproject.taskproject.applicants;

import java.io.Serializable;
import javax.persistence.JoinColumn;
import java.util.List;
import java.util.Optional;
import java.util.TreeSet;
import java.util.Set;
import java.util.ArrayList;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
//import javax.validation.constraints.NotBlank;

import com.taskproject.taskproject.interviews.bookModel;
import com.taskproject.taskproject.jobs.jobModel;
import com.fasterxml.jackson.annotation.JsonIgnore;
//import lyrn.school.school.examination.model.StudentEnroll;
//import lyrn.school.school.subjects.model.StudentSubjectEnroll;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

//@MappedSuperclass
@Entity
@Table(name = "applicants")
public class applicantModel implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "username")
    private String username;
    
    private String firstname;
    private String lastname;    

   // @OneToMany(mappedBy = "applicant")
    //@OneToMany(cascade = CascadeType.ALL)
    //@JoinColumn(name ="username_fid",referencedColumnName = "username",nullable = false)
   // private applicantModel applications ;
    
   // TreeSet ts = new TreeSet();
    //bookModel applications;
  
    public applicantModel(){
        super();
    }
   
    public applicantModel(String username, String firstname,
    String lastname) {
        super();
        this.username = username;
        this.firstname = firstname;
        this.lastname=lastname;
    } 
    public String getUsername() {
        return username;
    }

    /**
     * @param nid the nid to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return String return the firstname
     */
    public String getFirstname() {
        return firstname;
    }

    /**
     * @param firstname the firstname to set
     */
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }


    /**
     * @return String return the lastname
     */
    public String getLastname() {
        return lastname;
    }

    /**
     * @param lastname the lastname to set
     */
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

   
}