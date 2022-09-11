package com.devrodrigues.datasource;

import com.devrodrigues.repository.FilePort;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

@Component
public class FilePortImpl implements FilePort {
    private static final String EXPORT_DIRECTORY = "/tmp";

    @Override
    public Path export(String content, String name) {
        Path filePath = Paths.get(EXPORT_DIRECTORY, name);
        try {
            return Files.write(filePath, content.getBytes(), StandardOpenOption.CREATE);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
