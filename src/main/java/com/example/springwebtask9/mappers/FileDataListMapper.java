package com.example.springwebtask9.mappers;

import com.example.springwebtask9.dto.FileDataDto;
import com.example.springwebtask9.model.FileData;

public class FileDataListMapper {
    public static FileDataDto map(FileData fileData){
        return FileDataDto.builder()
                .fileName(fileData.getFileName())
                .extension(fileData.getExtension())
                .sizeInKb(fileData.getSizeInKb())
                .content(fileData.getContent())
                .build();
    }
}
