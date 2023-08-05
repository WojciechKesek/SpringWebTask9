package com.example.springwebtask9.dto;

import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Builder
@RequiredArgsConstructor
public class FileDataDto {
    private String fileName;
    private String extension;
    private Integer sizeInKb;
    private String content;
}
