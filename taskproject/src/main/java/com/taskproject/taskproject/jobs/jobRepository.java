package com.taskproject.taskproject.jobs;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

import javax.transaction.Status;

@Repository
public interface jobRepository extends JpaRepository<jobModel, String> {
    Boolean existsByJobname(String jobname);   
    jobModel findByJobname(String jobname);
    //Page<applicantModel> findByLevel(String level, Pageable pageable);
   /* Page<applicantModel> findByLevelAndStream(
        String level, String stream, Pageable pageable);
	Page<applicantModel> findByLevelAndStream(String level, String stream, Status status, Pageable pageable);
*/

}
