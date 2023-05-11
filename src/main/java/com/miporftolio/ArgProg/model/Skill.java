package com.miporftolio.ArgProg.model;

import jakarta.persistence.*;


@Entity
public class Skill {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String category;
    private String name;

    public Skill(Long id, String category, String name) {
        this.id = id;
        this.category = category;
        this.name = name;
    }

    public Skill() {
    }

   
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
