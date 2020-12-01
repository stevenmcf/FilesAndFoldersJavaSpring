package com.codeclan.example.FilesAndFolders.controllers;

import com.codeclan.example.FilesAndFolders.models.Folder;
import com.codeclan.example.FilesAndFolders.repositories.FolderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

public class FolderController {

    @Autowired
    FolderRepository folderRepository;

//    @GetMapping(value = "/ships")
//    public ResponseEntity<List<Ship>> getAllShips() {
//        return new ResponseEntity<>(shipRepository.findAll(), HttpStatus.OK);
//    }

    @GetMapping(value = "/folders")
    public ResponseEntity<List<Folder>> getAllFolders() {
        return new ResponseEntity<>(folderRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/folders/{id}")
    public ResponseEntity<Optional<Folder>> getFolder(@PathVariable Long id){
        return new ResponseEntity<>(folderRepository.findById(id), HttpStatus.OK);
    }

//    @PostMapping(value = "/ships")
//    public ResponseEntity<Ship> createShip(@RequestBody Ship ship){
//        Ship newShip = shipRepository.save(ship);
//        return new ResponseEntity<>(newShip, HttpStatus.CREATED);
//    }

    @PostMapping(value ="/folders")
    public ResponseEntity<Folder>createFolder(@RequestBody Folder folder){
        Folder newFolder = folderRepository.save(folder);
        return new ResponseEntity<>(newFolder, HttpStatus.CREATED);
    }
}
