package com.tn.test.backendv.repository;

import org.springframework.batch.item.ItemReader;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassCsv extends JpaRepository<ClassCsv, Long> {
}
