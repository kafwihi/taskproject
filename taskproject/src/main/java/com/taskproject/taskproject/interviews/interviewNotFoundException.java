package com.taskproject.taskproject.interviews;

public class interviewNotFoundException extends Exception {
        private String username;
        public interviewNotFoundException(String username,String jobname) {

                super(String.format("Interview is not found with id : '%s'", username));
                }
        }