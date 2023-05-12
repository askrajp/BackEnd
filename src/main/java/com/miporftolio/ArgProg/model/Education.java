package com.miporftolio.ArgProg.model;

import jakarta.persistence.*;

@Entity
public class Education {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String courseTitle;
    private String institutionName;
    private String yearsAttended;

    public Education() {
    }
 
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

   
    public String getCourseTitle() {
        return courseTitle;
    }

    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }

    public String getInstitutionName() {
        return institutionName;
    }

    public void setInstitutionName(String institutionName) {
        this.institutionName = institutionName;
    }

    public String getYearsAttended() {
        return yearsAttended;
    }

    public void setYearsAttended(String yearsAttended) {
        this.yearsAttended = yearsAttended;
    }
    
    
}
