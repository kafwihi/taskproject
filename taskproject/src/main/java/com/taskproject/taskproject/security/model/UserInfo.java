package com.taskproject.taskproject.security.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity

@Table(name = "users")
public class UserInfo {

    @Id
    private String username;
    private String previlage;/**user can be user1,user2,user3 */

    private String permission;/**permission can be granted or denied */

    private String password;


    public UserInfo() {
    }

    public UserInfo(String userid,String password , String permission,String previlage) {
        this.username = userid;
        this.previlage = previlage;
        this.permission = permission;
        this.password = password;
    }
    /**
     * @return String return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return String return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

}
