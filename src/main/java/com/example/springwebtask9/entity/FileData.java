package com.example.springwebtask9.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

@Data
@Entity
public class FileData {
    @Id
    @GeneratedValue
    private UUID id;
    private String fileName;
    private String extension;
    private Long sizeInKb;
    private String content;

}
