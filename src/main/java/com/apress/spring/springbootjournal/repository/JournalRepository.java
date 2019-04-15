package com.apress.spring.springbootjournal.repository;

import com.apress.spring.springbootjournal.domain.Journal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JournalRepository extends JpaRepository<Journal,Long> {
}
