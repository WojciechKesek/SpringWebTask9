package com.example.springwebtask9.repository;

import com.example.springwebtask9.model.FileData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface FileDataRepository extends JpaRepository<FileData, UUID> {
}
