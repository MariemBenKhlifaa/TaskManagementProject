package com.tn.test.backendv;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
//@EnableBatchProcessing
public class BackendVApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackendVApplication.class, args);
    }

}
