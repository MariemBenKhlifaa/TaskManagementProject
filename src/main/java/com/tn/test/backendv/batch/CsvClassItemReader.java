//package com.tn.test.backendv.batch;
//import com.tn.test.backendv.model.ClassCsv;
//import org.springframework.batch.item.ItemReader;
//import org.springframework.batch.item.NonTransientResourceException;
//import org.springframework.batch.item.ParseException;
//import org.springframework.batch.item.UnexpectedInputException;
//import org.springframework.batch.item.file.FlatFileItemReader;
//import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
//import org.springframework.batch.item.file.mapping.DefaultLineMapper;
//import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.io.ClassPathResource;
//import org.springframework.core.io.Resource;
//import org.springframework.stereotype.Component;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.ArrayList;
//import java.util.List;
//@Configuration
//public class CsvClassItemReader  {
//    @Bean
//    public FlatFileItemReader<ClassCsv> reader() {
//        FlatFileItemReader<ClassCsv> reader = new FlatFileItemReader<>();
//        reader.setResource(new ClassPathResource("data.csv"));
//        reader.setLinesToSkip(1); // Ignorer l'en-tête
//
//        DefaultLineMapper<ClassCsv> lineMapper = new DefaultLineMapper<>();
//
//        DelimitedLineTokenizer tokenizer = new DelimitedLineTokenizer();
//        tokenizer.setNames("name", "description");
//        lineMapper.setLineTokenizer(tokenizer);
//
//        BeanWrapperFieldSetMapper<ClassCsv> fieldSetMapper = new BeanWrapperFieldSetMapper<>();
//        fieldSetMapper.setTargetType(ClassCsv.class);
//        lineMapper.setFieldSetMapper(fieldSetMapper);
//
//        reader.setLineMapper(lineMapper);
//        return reader;
//    }
//}
