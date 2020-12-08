
package com.taskproject.taskproject.security.repository;

import  com.taskproject.taskproject.security.model.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UserInfoRepository extends JpaRepository<UserInfo,String> {

    Boolean existsByUsername(String username);
    UserInfo findByUsername(String username);


}
