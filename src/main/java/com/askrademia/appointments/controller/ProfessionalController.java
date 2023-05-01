package com.askrademia.appointments.controller;

import com.askrademia.appointments.model.Professional;
import com.askrademia.appointments.service.ProfessionalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/professionals")
public class ProfessionalController {

    @Autowired
    private ProfessionalService professionalService;

    @GetMapping
    public List<Professional> getAllProfessionals() {
        return professionalService.findAll();
    }

    @GetMapping("/{id}")
    public Professional getProfessionalById(@PathVariable Long id) {
        return professionalService.findById(id).orElseThrow(() -> new RuntimeException("Professional not found"));
    }

    @PostMapping
    public Professional createProfessional(@RequestBody Professional professional) {
        return professionalService.save(professional);
    }

    @PutMapping("/{id}")
    public Professional updateProfessional(@PathVariable Long id, @RequestBody Professional updatedProfessional) {
        Professional existingProfessional = professionalService.findById(id).orElseThrow(() -> new RuntimeException("Professional not found"));
        existingProfessional.setName(updatedProfessional.getName());
        existingProfessional.setWorkingHours(updatedProfessional.getWorkingHours());
        return professionalService.save(existingProfessional);
    }

    @DeleteMapping("/{id}")
    public void deleteProfessional(@PathVariable Long id) {
        professionalService.deleteById(id);
    }
}

