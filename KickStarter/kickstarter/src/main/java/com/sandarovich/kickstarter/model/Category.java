package com.sandarovich.kickstarter.model;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "category ")
@NamedQueries({
    @NamedQuery(name = "Category.getAll", query = "SELECT c from Category as c"),
    @NamedQuery(name = "Category.getById", query = "SELECT c from Category as c WHERE c.id = :id")
})
public class Category {
    @Id
    @GeneratedValue
    private long id;
    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "category")
    @Fetch(value = FetchMode.SUBSELECT)
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
