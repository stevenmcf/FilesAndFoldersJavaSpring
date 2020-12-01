package com.codeclan.example.FilesAndFolders.controllers;

import com.codeclan.example.FilesAndFolders.models.File;
import com.codeclan.example.FilesAndFolders.repositories.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class FileController {

    @Autowired
    FileRepository fileRepository;

//    @GetMapping(value = "/raids")
//    public ResponseEntity<List<Raid>> getAllRaids(){
//        return new ResponseEntity<>(raidRepository.findAll(), HttpStatus.OK);
//    }

    @GetMapping(value="/files")
    public ResponseEntity<List<File>>getAllFiles(){
        return new ResponseEntity<>(fileRepository.findAll(), HttpStatus.OK);
    }

//    @GetMapping(value = "/raids/{id}")
//    public ResponseEntity<Optional<Raid>> getRaid(@PathVariable Long id){
//        return new ResponseEntity<>(raidRepository.findById(id), HttpStatus.OK);
//    }
    @GetMapping(value="files/{id}")
    public ResponseEntity<Optional<File>> getFile(@PathVariable Long id){
        return new ResponseEntity<>(fileRepository.findById(id), HttpStatus.OK);
    }

//    @PostMapping(value = "/raids")
//    public ResponseEntity<Raid> createRaid(@RequestBody Raid raid){
//        Raid newRaid = raidRepository.save(raid);
//        return new ResponseEntity<>(newRaid, HttpStatus.CREATED);
//    }
    @PostMapping(value = "/files")
    public ResponseEntity<File> createFile(@RequestBody File file){
        File newFile = fileRepository.save(file);
        return new ResponseEntity<>(newFile, HttpStatus.CREATED);
    }





}
