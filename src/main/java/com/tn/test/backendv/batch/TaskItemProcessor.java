//package com.tn.test.backendv.batch;
//
//import com.tn.test.backendv.model.ClassCsv;
//import com.tn.test.backendv.model.Task;
//import com.tn.test.backendv.model.TaskStatus;
//import org.springframework.batch.item.ItemProcessor;
//import org.springframework.stereotype.Component;
//
//@Component
//public class TaskItemProcessor implements ItemProcessor<ClassCsv, ClassCsv> {
//    @Override
//    public ClassCsv process(ClassCsv item) throws Exception {
//        // Appliquer une logique de traitement si nécessaire
//        item.setDescription(item.getDescription().toUpperCase()); // Exemple : convertir la description en majuscules
//        return item;
//    }
//}
