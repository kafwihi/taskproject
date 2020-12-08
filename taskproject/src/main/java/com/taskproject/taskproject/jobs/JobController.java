package com.taskproject.taskproject.jobs;

    import java.util.List;
    import com.taskproject.taskproject.jobs.jobModel;
    import com.taskproject.taskproject.applicants.applicantModel;
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
    @RequestMapping("/jobs")
    public class JobController {
        @Autowired
            jobRepository studentRepository;
        // Get All Students in the school
            @GetMapping("/all")
            public List<jobModel> viewAll() {
                return studentRepository.findAll();
            }
    
        // Create a new student
             @PostMapping("/addjob")
            public Boolean admitStudent(@RequestBody jobModel student) throws NoSuchAlgorithmException {
                String username = student.getJobname();
                //String interview = student.getInterview();
                if (studentRepository.existsByJobname(username)){
    
                    return false;//throw new ValidationException("Student already existed");
    
                }
               /* else  if (dRepository.existsByInterview(interview)){    
                    return false;
                }*/
                studentRepository.save(student);
                return true;
            }
    
        // Update a student
           @PutMapping("/update/{jobname}")
            public jobModel updateStudent(@PathVariable(value = "jobname") String jobname,
                                    @RequestBody jobModel studentDetails) throws jobNotFoundException {
                                        jobModel student = studentRepository.findById(jobname).orElseThrow(() -> new jobNotFoundException("Job " + jobname + " not found"));
    

               student.setDescription(studentDetails.getDescription());
               student.setType(studentDetails.getType());
               
               student.setYears_of_experience(studentDetails.getYears_of_experience());
               student.setEducation_level(studentDetails.getEducation_level());
               student.setStatus(studentDetails.getStatus());
               student.setInterview_date(studentDetails.getInterview_date());
               student.setInterview_start_time(studentDetails.getInterview_start_time());
               student.setInterview_end_time(studentDetails.getInterview_end_time());
               
               jobModel updateStudent = studentRepository.save(student);
         return studentRepository.save(updateStudent);
                                   }
    
    
        // Delete a Note
            @DeleteMapping("/delete/{username}")
            public ResponseEntity<?> deleteStudent(@PathVariable(value = "username") String username) throws jobNotFoundException {
                jobModel student = studentRepository.findById(username)
                        .orElseThrow(() -> new jobNotFoundException(username));
    
        studentRepository.delete(student);
    
        return ResponseEntity.ok().build();
            }
    
    
            @DeleteMapping("/posts/{postId}")
            public ResponseEntity<?> deletePost(@PathVariable(value = "username") String username)
                throws jobNotFoundException {
                return studentRepository.findById(username).map(student -> {
                    studentRepository.delete(student);
                    return ResponseEntity.ok().build();
                }).orElseThrow(() -> new jobNotFoundException("PostId " + username + " not found"));
            }
    }
    /**
     * https://www.javaguides.net/2019/08/spring-boot-jpa-hibernate-one-to-one-mapping-example.html
    https://www.rbsprogramming.com/articles/jpa-one-to-one-relationship/
    https://attacomsian.com/blog/spring-data-jpa-one-to-one-mapping
    https://hellokoding.com/jpa-one-to-one-foreign-key-relationship-mapping-example-with-spring-boot-hsql/
    
     */