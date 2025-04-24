package com.toto.service.impl;



import com.toto.entity.Reb;
import com.toto.repository.RebRepository;
import com.toto.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.stream.Stream;

@Service
public class parseSchedule {
    @Autowired
    private RebRepository rebRepository;
    @Autowired
    private UserRepository userRepository;
    @Scheduled(fixedRate = 500000)
    public void parseFolder(){
        Path logFolder = Paths.get("/home/mehdi/Downloads/alert/test");
        Path parsedDir = Paths.get("/home/mehdi/Downloads/alert/parsed");
        try(Stream<Path> files = Files.walk(logFolder)){
            files.filter(Files::isRegularFile).forEach(path -> {parseFile(path,parsedDir);});
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public void parseFile(Path filePath,Path parsedDir) {
        System.out.println("Parsing reboot log...");

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        try (Stream<String> lines = Files.lines(filePath)) {
            lines.forEach(line -> {
                try {
                    String[] words = line.trim().split("\\s+");
                    if (words.length >= 11 && "A".equals(words[3])) {
                        Reb reb = new Reb();

                        reb.setZoneId(words[0].replace(":", ""));

                        // Parse date and time
                        String scriptExTime = words[1] + " " + words[2];
                        LocalDateTime dateTime = LocalDateTime.parse(scriptExTime, formatter);
                        reb.setPostponedRebootTime(dateTime);

                        reb.setMachine(words[10].replace("'", ""));
                        reb.setStatus("postponed");

                        rebRepository.save(reb);
                    }
                } catch (Exception e) {
                    System.err.println("Failed to process line: " + line);
                    e.printStackTrace();
                }
                try {
                    Path targetPath = parsedDir.resolve(filePath.getFileName());
                    Files.move(filePath, targetPath, StandardCopyOption.REPLACE_EXISTING);
                    System.out.println("Moved parsed file to: " + targetPath);
                } catch (IOException e) {
                    System.err.println("Failed to move file: " + filePath);
                    e.printStackTrace();
                }
            });
        } catch (IOException e) {
            System.err.println("Failed to read log file.");
            e.printStackTrace();
        }
    }
}
