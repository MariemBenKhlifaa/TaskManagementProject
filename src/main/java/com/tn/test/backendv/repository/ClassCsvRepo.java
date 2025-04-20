package com.tn.test.backendv.repository;

import com.tn.test.backendv.model.ClassCsv;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassCsvRepo extends JpaRepository<ClassCsv, Long> {
}
