package com.fatma.university.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class College {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    @Column(columnDefinition = "LONGTEXT")
    private String icon;
    @OneToMany(mappedBy = "college", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Department> departments;
    @OneToOne(mappedBy = "college",cascade = CascadeType.ALL)
    @JsonIgnore
    private Student student;
}
