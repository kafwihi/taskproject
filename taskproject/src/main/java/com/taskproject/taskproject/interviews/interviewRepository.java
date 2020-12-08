package com.taskproject.taskproject.interviews;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
  
import java.util.Optional;
//import org.springframework.data.repository.Query;
import java.util.List;

import com.taskproject.taskproject.interviews.bookModel;
import javax.transaction.Status;

@Repository
public interface interviewRepository extends JpaRepository<bookModel, Long> {
    //bookModel findById(Long interview_id);
   // @Query("SELECT interview_id FROM interviews e WHERE e.applicant_username = ?1 and e.career_jobname = ?2")
  //bookModel findBookModelByApplicantModelAndJobModel(String applicant, String jobname);
//Page<bookModel> findByApplicantModelAndJobModel(        
 //   String applicant,String career, Pageable pageable);
	
    
}
