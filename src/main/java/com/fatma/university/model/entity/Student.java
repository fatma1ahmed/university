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

public class Student extends Person{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String brand;
    private String category;
    @OneToMany(mappedBy = "student",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<StudentComment> studentComments;
    @OneToMany(mappedBy = "student",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<StudentLike> studentLikes;
    @OneToOne
    private College college;
    @OneToOne
    private Department department;



}
