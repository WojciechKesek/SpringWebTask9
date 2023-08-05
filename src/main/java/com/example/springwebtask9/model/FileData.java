package com.example.springwebtask9.model;

import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.UUID;

@Data
@Entity
@Builder
@RequiredArgsConstructor
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
