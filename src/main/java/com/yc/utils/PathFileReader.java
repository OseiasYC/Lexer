package com.yc.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class PathFileReader {

    String name;

    public String read(String filePath) throws IOException {
        StringBuilder content = new StringBuilder();

        File file = new File(filePath);

        name = file.getName();

        if (filePath.endsWith(".241")) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    content.append(line).append("\n");
                }
            }
            return content.toString();
        }

        return "Caminho ou arquivo inválido.";
    }

    public String getName() {
        return name;
    }

}
