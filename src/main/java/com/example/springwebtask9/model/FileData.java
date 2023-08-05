package com.example.springwebtask9.model;

import lombok.Data;

import javax.persistence.*;
import java.util.UUID;

@Data
@Entity
@Table(name = "files_data")
public class FileData {
    @Id
    @GeneratedValue
    @Column(columnDefinition = "uuid")
    private UUID id;
    private String fileName;
    private String extension;
    private Integer sizeInKb;
    private String content;

}
