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

        Folder tunes = new Folder ("Spotify Downloads", user1);
        folderRepository.save(tunes);

        Folder applications = new Folder ("soundcloud", user1);
        folderRepository.save(applications);

        File music = new File("Deacon Blue Greatest Hits", "mp4", 600.5, tunes );
        fileRepository.save(music);
        File ide = new File("intellij", ".exe", 250, applications );
        fileRepository.save(ide);



    }
}
