package com.example.springwebtask9.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;
@Data
@Builder
@AllArgsConstructor
public class FileDataList {
    private List<FileDataDto> fileDataDtoList;
}
