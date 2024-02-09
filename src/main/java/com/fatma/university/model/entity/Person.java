package com.fatma.university.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public class Person {
    private String fullName;
    private  String email;
    private  String password;
    private  String phone;
    private  String imagePath;
}
