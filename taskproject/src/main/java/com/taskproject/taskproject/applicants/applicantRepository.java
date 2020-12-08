package com.taskproject.taskproject.applicants;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

import javax.transaction.Status;

@Repository
public interface applicantRepository extends JpaRepository<applicantModel, String> {
    Boolean existsByUsername(String username);
    applicantModel findByUsername(String username);
    //Page<applicantModel> findByLevel(String level, Pageable pageable);
   /* Page<applicantModel> findByLevelAndStream(
        String level, String stream, Pageable pageable);
	Page<applicantModel> findByLevelAndStream(String level, String stream, Status status, Pageable pageable);
*/

}
