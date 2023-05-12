package com.miporftolio.ArgProg.service;

import com.miporftolio.ArgProg.model.Education;
import com.miporftolio.ArgProg.repository.EducationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EducationService {

    @Autowired
    private EducationRepository educationRepository;

    public List<Education> findAll() {
        return educationRepository.findAll();
    }

    public Education saveOrUpdate(Education education) {
        return educationRepository.save(education);
    }

    public Optional<Education> findById(Long id) {
        return educationRepository.findById(id);
    }

    public void deleteById(Long id) {
        educationRepository.deleteById(id);
    }
}
