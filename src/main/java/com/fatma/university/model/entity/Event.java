package com.fatma.university.model.entity;

import com.fatma.university.model.Enum.BroadCast;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String address;
    private String place;
    private String date;
    private String time;
    private BroadCast isBroadcast;
    private String linkPath;
    private String imagePath;
    @ManyToOne
    private Category category;
    @ManyToOne
    private Source source;
}