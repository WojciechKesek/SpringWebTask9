package com.example.springwebtask9.service;

import com.example.springwebtask9.entity.FileData;
import com.example.springwebtask9.exception.SdaException;
import com.example.springwebtask9.repository.FileDataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class FileDataService {
    private final FileDataRepository fileDataRepository;

    public List<FileData> getAllData(){
        return fileDataRepository.findAll();
    }

    public FileData getData(UUID id){
        return fileDataRepository.findById(id).orElseThrow(()-> new SdaException("Cant find file data"));
    }
    public String createData(FileData fileData){
        fileDataRepository.save(fileData);
        return "File data created successfully";
    }

    public String updateData(UUID id, FileData data){
        FileData existData = fileDataRepository.findById(id).orElseThrow(() -> new SdaException("Cant find file data to modify"));
        existData.setContent(data.getContent());
        existData.setFileName(data.getFileName());
        existData.setExtension(data.getExtension());
        existData.setSizeInKb(data.getSizeInKb());
        fileDataRepository.save(existData);
        return "File data updated successfully";
    }

    public void deleteData(UUID id){
        fileDataRepository.delete(fileDataRepository.findById(id).orElseThrow(() -> new SdaException("Cant delete file data")));
    }

}
