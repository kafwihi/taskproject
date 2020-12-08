package com.taskproject.taskproject.jobs;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
//import javax.validation.constraints.NotBlank;

import com.taskproject.taskproject.applicants.applicantModel;
import com.taskproject.taskproject.interviews.bookModel;
import com.fasterxml.jackson.annotation.JsonIgnore;
//import lyrn.school.school.examination.model.StudentEnroll;
//import lyrn.school.school.subjects.model.StudentSubjectEnroll;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import java.util.ArrayList;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "jobs")
public class jobModel implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    private String jobname;
    
    private String description;
    private String type;
    
    private String years_of_experience;
    private String education_level;
    private String status;
    
   // @NotBlank(message = "Date is Mandatory")
    @Column(nullable=false, unique = true)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date interview_date;

    @Column(nullable=false)
    private String interview_start_time;
    private String interview_end_time;


   // @OneToMany(mappedBy = "career")
    //private List<bookModel> jobs;
    //@OneToMany(cascade = CascadeType.ALL)
    //@JoinColumn(name ="jobname_fid",referencedColumnName = "jobname",nullable = false)
    //List<bookModel> jobs = new ArrayList<>();
    public jobModel(){
        super();
    } 
   
    public jobModel(String jobname, String description,String type,
    String years_of_experience, String education_level, String status, 
    Date interview_date,String interview_start_time,String interview_end_time) {
        super();
        this.jobname = jobname;
        this.description = description;
        this.type = type;
        this.years_of_experience=years_of_experience;
        this.education_level = education_level;
        this.status = status;
        this.interview_date = interview_date;
        this.interview_start_time = interview_start_time;
        this.interview_end_time = interview_end_time;
        
    }


    /**
     * @return String return the jobname
     */
    public String getJobname() {
        return jobname;
    }

    /**
     * @param jobname the jobname to set
     */
    public void setJobname(String jobname) {
        this.jobname = jobname;
    }

    /**
     * @return String return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return String return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return String return the years_of_experience
     */
    public String getYears_of_experience() {
        return years_of_experience;
    }

    /**
     * @param years_of_experience the years_of_experience to set
     */
    public void setYears_of_experience(String years_of_experience) {
        this.years_of_experience = years_of_experience;
    }

    /**
     * @return String return the education_level
     */
    public String getEducation_level() {
        return education_level;
    }

    /**
     * @param education_level the education_level to set
     */
    public void setEducation_level(String education_level) {
        this.education_level = education_level;
    }

    /**
     * @return String return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return String return the interview_date
     */
    public Date getInterview_date() {
        return interview_date;
    }

    
    public void setInterview_date(Date interview_date) {
        this.interview_date = interview_date;
    }

    /**
     * @return String return the interview_start_time
     */
    public String getInterview_start_time() {
        return interview_start_time;
    }

    /**
     * @param interview_start_time the interview_start_time to set
     */
    public void setInterview_start_time(String interview_start_time) {
        this.interview_start_time = interview_start_time;
    }

    /**
     * @return String return the interview_end_time
     */
    public String getInterview_end_time() {
        return interview_end_time;
    }

    /**
     * @param interview_end_time the interview_end_time to set
     */
    public void setInterview_end_time(String interview_end_time) {
        this.interview_end_time = interview_end_time;
    }

}