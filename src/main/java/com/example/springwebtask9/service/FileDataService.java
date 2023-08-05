package com.example.springwebtask9.service;

import com.example.springwebtask9.dto.FileDataDto;
import com.example.springwebtask9.dto.FileDataList;
import com.example.springwebtask9.mappers.FileDataListMapper;
import com.example.springwebtask9.model.FileData;
import com.example.springwebtask9.exception.SdaException;
import com.example.springwebtask9.repository.FileDataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FileDataService {
    private final FileDataRepository fileDataRepository;

    public FileDataList getAllData(){
        List<FileData> filesData = fileDataRepository.findAll();
        List<FileDataDto> filesDataDtos =  filesData.stream().map(FileDataListMapper::map)
                .collect(Collectors.toList());
        return new FileDataList(filesDataDtos);
    }

    public FileData getData(UUID id){
        return fileDataRepository.findById(id).orElseThrow(()-> new SdaException("Cant find file data"));
    }
    public String createData(FileDataDto dataDto){
        FileData fileData = FileData
                .builder()
                .fileName(dataDto.getFileName())
                .content(dataDto.getContent())
                .extension(dataDto.getExtension())
                .sizeInKb(dataDto.getSizeInKb())
                .build();
                fileDataRepository.save(fileData);
        return "File data created successfully";
    }

    public String updateData(UUID id, FileDataDto dataDto){
        FileData existData = fileDataRepository.findById(id).orElseThrow(() -> new SdaException("Cant find file data to modify"));
        existData.setContent(dataDto.getContent());
        existData.setFileName(dataDto.getFileName());
        existData.setExtension(dataDto.getExtension());
        existData.setSizeInKb(dataDto.getSizeInKb());
        fileDataRepository.save(existData);
        return "File data updated successfully";
    }

    public void deleteData(UUID id){
        fileDataRepository.delete(fileDataRepository.findById(id).orElseThrow(() -> new SdaException("Cant delete file data")));
    }

}
