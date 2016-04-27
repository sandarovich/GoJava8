package com.sandarovich.kickstarter.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "category ")
public class Category {
    @Id
    @GeneratedValue
    private long id;
    @Column(name = "name")
    private String name;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "categoryid")
    private List<Project> projects;

    public Category() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

}
