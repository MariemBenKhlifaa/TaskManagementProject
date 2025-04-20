//package com.tn.test.backendv.batch;
//
//import org.springframework.batch.core.Job;
//import org.springframework.batch.core.JobParameters;
//import org.springframework.batch.core.JobParametersBuilder;
//import org.springframework.batch.core.launch.JobLauncher;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//
//import java.time.LocalDateTime;
//
//@Component
//public class JobRunner implements CommandLineRunner {
//
//    @Autowired
//    private JobLauncher jobLauncher;
//
//    @Autowired
//    private Job readCSVFileJob;
//
//    @Override
//    public void run(String... args) throws Exception {
//
//            JobParameters jobParameters = new JobParametersBuilder()
//                    .addString("timestamp", LocalDateTime.now().toString()) // Ajoute un paramètre unique à chaque exécution
//                    .toJobParameters();
//
//            jobLauncher.run(readCSVFileJob, jobParameters);
//        };
//}
