package com.example.springexplorationsjava;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Topic {

    @Id
    private String id;
    private String name;
    private String description;

    // must contain default constructor for spring boot
    public Topic() {
//        this(id, name, description);
    }

    public Topic(String id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName() {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
