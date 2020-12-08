package com.example.taskproject.applicants;

import java.util.TreeSet;
import java.util.List;
import java.util.ArrayList;
//import com.example.demo.interviews.interviewNotFoundException;
//import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.security.NoSuchAlgorithmException;
@RestController
@RequestMapping("/home")
public class controller {
   
    @GetMapping("/home")
    public String applyBookModel() {
                             
                              return "hello";        
                              
                                }
      
                                
    }
/**
 * https://www.javaguides.net/2019/08/spring-boot-jpa-hibernate-one-to-one-mapping-example.html
https://www.rbsprogramming.com/articles/jpa-one-to-one-relationship/
https://attacomsian.com/blog/spring-data-jpa-one-to-one-mapping
https://hellokoding.com/jpa-one-to-one-foreign-key-relationship-mapping-example-with-spring-boot-hsql/

    @PostMapping("/{username}/apply/{jobname}")
    public bookModel applyBookModel(@PathVariable (value = "username") String username,
    @PathVariable (value = "jobname") String jobname,
                                  @RequestBody bookModel myapplication) throws applicantNotFoundException{
        return studentRepository.findById(username).map(post -> {
            myapplication.setApplicantModel(post); 
            //myapplication.setApplicantModel(post);  
            jobModel newJob = new jobModel();
            newJob.setJobname(myapplication.getJobModel().toString());
            bookModel newapplication = new bookModel();//myapplication.getApplicantModel(),myapplication.getJobModel());
            newapplication.setApplicantModel(post); 
            
            myapplication.setApplicantModel(post); newapplication.setJobModel(newJob); 
             return applyRep.save(myapplication);
        }).orElseThrow(() -> new applicantNotFoundException("User " + username + " not found"));
    }

   
 */