package com.fatma.university.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private String details;

    @ManyToOne
    private College college;

    @OneToMany(mappedBy = "department",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Source> sources;
    @OneToMany(mappedBy = "department",cascade = CascadeType.ALL)
    private List<Student> students;
}
