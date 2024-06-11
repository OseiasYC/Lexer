package com.yc.utils;

import java.io.File;
import java.io.FileNotFoundException;

import java.util.Scanner;

public class PathFileReader {
    public StringBuilder content = new StringBuilder();

    public String fileName;

    public StringBuilder read(String filePath) {
        File file = new File(filePath);

        fileName = file.getName();

        try (Scanner fileScanner = new Scanner(file)) {
            System.out.println("\nTexto fonte analisado: \u001B[33m" + fileName + "\u001B[0m");

            while (fileScanner.hasNextLine()) {
                content.append(fileScanner.nextLine()).append("\n");
            }

            if (content.length() == 0) {
                System.err.println("\u001B[31mO arquivo está vazio. Tente novamente.\u001B[0m");
            }

        } catch (FileNotFoundException e) {
            System.err.println("\u001B[31mArquivo inválido ou não encontrado. Tente novamente.\u001B[0m");
        }
        return content;
    }
}
