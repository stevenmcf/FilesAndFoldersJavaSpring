package com.codeclan.example.FilesAndFolders.components;

import com.codeclan.example.FilesAndFolders.models.File;
import com.codeclan.example.FilesAndFolders.models.Folder;
import com.codeclan.example.FilesAndFolders.models.User;
import com.codeclan.example.FilesAndFolders.repositories.FileRepository;
import com.codeclan.example.FilesAndFolders.repositories.FolderRepository;
import com.codeclan.example.FilesAndFolders.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;



@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    FolderRepository folderRepository;

    @Autowired
    FileRepository fileRepository;

    @Autowired
    UserRepository userRepository;

    public DataLoader(){
    }


    public void run(ApplicationArguments args){
        User user1 = new User("Json Jsonson");
        userRepository.save(user1);
        User user2 = new User("Graham Grahamson");
        userRepository.save(user2);

        Folder project1 = new Folder ("VUE", user1);
        folderRepository.save(project1);

        Folder project2 = new Folder ("REACT", user1);
        folderRepository.save(project2);

        File api1 = new File("api1", "JSON", 600.5, project1 );
        fileRepository.save(api1);
        File api2 = new File("api2", "xml", 980.01, project1 );
        fileRepository.save(api2);
        File api3 = new File("api3", "JSON", 250, project2 );
        fileRepository.save(api3);

        user1.addFolders(project1);
        user2.addFolders(project2);
        user2.addFolders(project1);

        project1.addFile(api1);
        project1.addFile(api2);
        project2.addFile(api3);


    }
}
