package com.devrodrigues.repository;

import java.nio.file.Path;

public interface FilePort {

    Path export(String content, String name);
}
