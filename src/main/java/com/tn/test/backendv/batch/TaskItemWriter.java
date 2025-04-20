package com.tn.test.backendv.batch;

import com.tn.test.backendv.model.ClassCsv;
import com.tn.test.backendv.model.Task;
import jakarta.activation.DataSource;
import jakarta.persistence.EntityManagerFactory;
import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.JpaItemWriter;
import org.springframework.batch.item.database.builder.JpaItemWriterBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
//
//@Configuration
//public class TaskItemWriter  {
//    @Bean
//    public JpaItemWriter<ClassCsv> writer(EntityManagerFactory entityManagerFactory) {
//        return new JpaItemWriterBuilder<ClassCsv>()
//                .entityManagerFactory(entityManagerFactory)
//                .build();
//    }
//}
