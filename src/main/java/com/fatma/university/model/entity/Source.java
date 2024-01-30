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
public class Source extends Person {
    @OneToMany(mappedBy = "source",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Event> events;
    @ManyToOne
    private Department department;
}
