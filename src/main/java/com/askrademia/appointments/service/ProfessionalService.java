package com.askrademia.appointments.service;

import com.askrademia.appointments.model.Professional;
import com.askrademia.appointments.repository.ProfessionalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfessionalService {

    @Autowired
    private ProfessionalRepository professionalRepository;

    public List<Professional> findAll() {
        return professionalRepository.findAll();
    }

    public Optional<Professional> findById(Long id) {
        return professionalRepository.findById(id);
    }

    public Professional save(Professional professional) {
        return professionalRepository.save(professional);
    }

    public void deleteById(Long id) {
        professionalRepository.deleteById(id);
    }
}
