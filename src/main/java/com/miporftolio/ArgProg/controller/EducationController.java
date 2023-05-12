package com.miporftolio.ArgProg.controller;

import com.miporftolio.ArgProg.model.Education;
import com.miporftolio.ArgProg.service.EducationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/education")
public class EducationController {

    @Autowired
    private EducationService educationService;

    @GetMapping("/get")
    public ResponseEntity<List<Education>> getAllEducation() {
        List<Education> education = educationService.findAll();
        return ResponseEntity.ok(education);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Education> getEducationById(@PathVariable Long id) {
        Optional<Education> education = educationService.findById(id);
        if (education.isPresent()) {
            return ResponseEntity.ok(education.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Education> createEducation(@RequestBody Education education) {
        Education createdEducation = educationService.saveOrUpdate(education);
        return new ResponseEntity<>(createdEducation, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Education> updateEducation(@PathVariable Long id, @RequestBody Education education) {
        Optional<Education> existingEducation = educationService.findById(id);
        if (existingEducation.isPresent()) {
            education.setId(id);
            Education updatedEducation = educationService.saveOrUpdate(education);
            return ResponseEntity.ok(updatedEducation);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

     @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEducation(@PathVariable Long id) {
        Optional<Education> existingEducation = educationService.findById(id);
        if (existingEducation.isPresent()) {
            educationService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
