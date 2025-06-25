package com.dacuni.library.content_service.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "novel")
@Data
public class NovelEnt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String author;
    private String synopsis;
    private String status;
    private boolean isDeleted = false;
    // No business logic here (SRP)
}