//package com.tn.test.backendv.config;
//
//import com.tn.test.backendv.batch.TaskItemProcessor;
//import com.tn.test.backendv.batch.TaskItemWriter;
//import com.tn.test.backendv.model.ClassCsv;
//import org.springframework.batch.core.Job;
//import org.springframework.batch.core.Step;
//import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
//import org.springframework.batch.core.job.builder.JobBuilder;
//import org.springframework.batch.core.launch.support.RunIdIncrementer;
//import org.springframework.batch.core.repository.JobRepository;
//import org.springframework.batch.core.repository.support.JobRepositoryFactoryBean;
//import org.springframework.batch.core.step.builder.StepBuilder;
//import org.springframework.batch.item.ItemProcessor;
//import org.springframework.batch.item.ItemReader;
//import org.springframework.batch.item.ItemWriter;
//import org.springframework.batch.item.database.JpaItemWriter;
//import org.springframework.batch.item.file.FlatFileItemReader;
//import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
//import org.springframework.batch.item.file.mapping.DefaultLineMapper;
//import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.io.ClassPathResource;
//import org.springframework.transaction.PlatformTransactionManager;
//
//@Configuration
//@EnableBatchProcessing
//public class BatchConfig {
//
//    @Bean
//    public Job importUserJob(JobRepository jobRepository, Step step1, Step step2) {
//        return new JobBuilder("importCsvJob", jobRepository)
//                .incrementer(new RunIdIncrementer())
//                .start(step2)
//                .build();
//    }
//
//    @Bean
//    public Step step2(JobRepository jobRepository, PlatformTransactionManager transactionManager,
//                      FlatFileItemReader<ClassCsv> reader, TaskItemProcessor processor, JpaItemWriter<ClassCsv> writer) {
//        return new StepBuilder("step2", jobRepository)
//                .<ClassCsv, ClassCsv>chunk(10, transactionManager)
//                .reader(reader)
//                .processor(processor)
//                .writer(writer)
//                .build();
//    }
//
//
//
//}