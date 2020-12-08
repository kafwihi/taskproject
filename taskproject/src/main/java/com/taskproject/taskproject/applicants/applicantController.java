package com.taskproject.taskproject.applicants;

import java.util.TreeSet;
import java.util.List;
import java.util.ArrayList;
import com.taskproject.taskproject.applicants.applicantModel;
import com.taskproject.taskproject.interviews.bookModel;
import com.taskproject.taskproject.interviews.interviewNotFoundException;
import com.taskproject.taskproject.jobs.jobRepository;
import com.taskproject.taskproject.jobs.jobModel;
import com.taskproject.taskproject.jobs.jobNotFoundException;
//import com.example.demo.interviews.interviewNotFoundException;
import com.taskproject.taskproject.interviews.interviewRepository;
import javax.transaction.Status;
//import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
@RequestMapping("/applicants")
public class applicantController {
    @Autowired
    applicantRepository studentRepository;
    
    @Autowired
    jobRepository jRepository;
    @Autowired
    interviewRepository applyRep;
   
    @PostMapping("/{username}/apply/{jobname}")
    public bookModel applyBookModel(@PathVariable (value = "username") String username,
    @PathVariable (value = "jobname") String jobname,
                                  @RequestBody bookModel myapplication) throws applicantNotFoundException{
                               bookModel newbook = new bookModel();
                              // newbook.setApplicantModel(name);
                                    applicantModel student = studentRepository.findById(username).orElseThrow(() -> new applicantNotFoundException("Student " + username + " not found"));
                                    jobModel job = jRepository.findById(jobname).orElseThrow(() -> new applicantNotFoundException("Student " + username + " not found"));
                                   
                                    newbook.setApplicantModel(student); 
                                    newbook.setJobModel(job); 
  
                                //return newbook;  
                              return applyRep.save(newbook);        
                              
                                }
      
                                
    /*@GetMapping("/{username}/and/{jobname}")
    public bookModel getBookModel(@PathVariable (value = "username") String username,
    @PathVariable (value = "jobname") String jobname
                                  ) throws interviewNotFoundException{
                                    bookModel book = applyRep.findBookModelByApplicantModelAndJobModel(username,jobname).orElseThrow(() -> new applicantNotFoundException("Student " + username + " not found"));
                                   
             //return applyRep.findBookModelByApplicantModelAndJobModel(username,jobname).orElseThrow(() -> new interviewNotFoundException(username,jobname));
                  
                                   return book;         
                              
                                }*/
                                @GetMapping("/find")
                                public List<bookModel> findByApplicantModelAndJobModel() {
                                   //String level = student.getLevel();
                       
                                           return applyRep.findAll();
                                  
                                }
                       
    // Get All Students in the school
        @GetMapping("/all")
        public List<applicantModel> viewAll() {
            return studentRepository.findAll();
        }

    // Create a new student
         @PostMapping("/register")
        public Boolean admitStudent(@RequestBody applicantModel student) throws NoSuchAlgorithmException {
            String username = student.getUsername();
            if (studentRepository.existsByUsername(username)){

                return false;//throw new ValidationException("Student already existed");

            }
            studentRepository.save(student);
            return true;
        }
        /*
        @GetMapping("/{username}/and/{jobname}")
        public bookModel getBookModel(
            @PathVariable(value = "username") String username,
            @PathVariable(value = "jobname") String jobname)throws interviewNotFoundException {
            return applyRep.findBookModelByUsernameAndJobname(username,jobname)
                    .orElseThrow(() -> new interviewNotFoundException(username,jobname));
        }*/
    // Get a Single student
  
        @GetMapping("/search/{username}")
        public applicantModel getApplicantById(@PathVariable(value = "username") String username) throws applicantNotFoundException {
            return studentRepository.findById(username)
                    .orElseThrow(() -> new applicantNotFoundException(username));
        }

         // Get a Single student

    // Update a student
       @PutMapping("/update/{username}")
        public applicantModel updateStudent(@PathVariable(value = "username") String username,
                                @RequestBody applicantModel studentDetails) throws applicantNotFoundException {
                                applicantModel student = studentRepository.findById(username).orElseThrow(() -> new applicantNotFoundException("Applicant " + username + " not found"));

           student.setFirstname(studentDetails.getFirstname());
            student.setLastname(studentDetails.getLastname());
            applicantModel updateStudent = studentRepository.save(student);
     return studentRepository.save(updateStudent);
                               }


    // Delete a Note
        @DeleteMapping("/delete/{username}")
        public ResponseEntity<?> deleteStudent(@PathVariable(value = "username") String username) throws applicantNotFoundException {
            applicantModel student = studentRepository.findById(username)
                    .orElseThrow(() -> new applicantNotFoundException(username));

    studentRepository.delete(student);

    return ResponseEntity.ok().build();
        }


        @DeleteMapping("/posts/{postId}")
        public ResponseEntity<?> deletePost(@PathVariable(value = "username") String username)
            throws applicantNotFoundException {
            return studentRepository.findById(username).map(student -> {
                studentRepository.delete(student);
                return ResponseEntity.ok().build();
            }).orElseThrow(() -> new applicantNotFoundException("PostId " + username + " not found"));
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