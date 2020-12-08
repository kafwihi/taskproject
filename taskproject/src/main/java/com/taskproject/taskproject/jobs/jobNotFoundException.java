package com.taskproject.taskproject.jobs;

public class jobNotFoundException extends Exception {
        private String jobname;
        public jobNotFoundException(String jobname) {

                super(String.format("Job is not found with id : '%s'", jobname));
                }
        }