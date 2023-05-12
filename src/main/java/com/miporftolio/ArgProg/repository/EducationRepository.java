package com.miporftolio.ArgProg.repository;

import com.miporftolio.ArgProg.model.Education;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EducationRepository extends JpaRepository<Education, Long> {
  }
