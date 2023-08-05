package com.example.springwebtask9.controller;

import com.example.springwebtask9.dto.FileDataDto;
import com.example.springwebtask9.dto.FileDataList;
import com.example.springwebtask9.model.FileData;
import com.example.springwebtask9.service.FileDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "/api/files-data")
@RequiredArgsConstructor
public class FileDataController {

    private final FileDataService fileDataService;

    @GetMapping
    public FileDataList data(){
       return fileDataService.getAllData();
    }

    @GetMapping("/{id}")
    public FileData getDataById(@PathVariable UUID id){
        return fileDataService.getData(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String createData(@RequestBody FileDataDto fileDataDto){
        return fileDataService.createData(fileDataDto);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String updateDAta(@PathVariable UUID id, @RequestBody FileDataDto fileDataDto){
        return fileDataService.updateData(id,fileDataDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteData(@PathVariable UUID id){
        fileDataService.deleteData(id);
    }

}
