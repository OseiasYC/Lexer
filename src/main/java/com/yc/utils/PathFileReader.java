package com.yc.utils;

import java.io.File;
import java.io.FileNotFoundException;

import java.util.Scanner;

public class PathFileReader {

    public StringBuilder read(String filePath) {
        StringBuilder content = new StringBuilder();
        File file = new File(filePath);

        // if (!file.getName().endsWith(".241")) {
        //     file.getExtension();
        // }

        try (Scanner fileScanner = new Scanner(file)) {
            System.out.println("\nLeitura do arquivo: \u001B[33m" + file.getName() + "\u001B[0m");
            while (fileScanner.hasNextLine()) {
                content.append(fileScanner.nextLine()).append("\n");
            }

            if (content.length() == 0) {
                System.out.println("\u001B[31mO arquivo está vazio.\u001B[0m");
            }

        } catch (FileNotFoundException e) {
            System.out.println("\u001B[31mArquivo não encontrado.\u001B[0m");
        }
        return content;
    }
}
