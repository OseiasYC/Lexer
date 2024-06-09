package com.yc.utils;

import java.util.List;
import java.util.Scanner;

import com.yc.lexer.Lexer;
import com.yc.lexer.TokenDTO;

public class TUI {
    Scanner sc = new Scanner(System.in);
    String filePath;

    PathFileReader pathFileReader = new PathFileReader();

    private static final String PINK = "\u001B[35m";
    public static final String RED = "\u001B[31m";
    private static final String YELLOW = "\u001B[33m";
    private static final String GREEN = "\u001B[32m";
    private static final String CYAN = "\u001B[36m";
    private static final String RESET = "\u001B[0m";

    public void run() {
        header();
        input();
        test();
    }

    public void header() {
        System.out.println(CYAN + "COMPONENTES - CÓDIGO DA EQUIPE: " + RESET + "EQ03\n" +
                PINK + "    Harrison Borges dos Santos  " + RESET + " | harrison.borges@ucsal.edu.br  | (71) 99290-4126\n" +
                PINK + "    Iago Roque Ribeiro Noaves   " + RESET + " | iago.roque@ucsal.edu.br       | (73) 99934-6222\n" +
                PINK + "    Lucas Farias da Silva       " + RESET + " | lucas.farias@ucsal.edu.br     | (71) 99368-8705\n" +
                PINK + "    Oseias Lopes da Silva       " + RESET + " | oseias.silva@ucsal.edu.br     | (74) 99118-0551\n" +
                "\nDigite o caminho absoluto do arquivo .241 para análise: ");
    }

    public void input() {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\nInsira um caminho de arquivo .241:");
            filePath = sc.nextLine().toString();

            if (filePath.endsWith(".241")) {
                break;
            } else {
                System.out.println(RED + "Caminho inválido. Tente novamente." + RESET);
            }
        }
        sc.close();
    }

    public void test(){
        Lexer lexer = new Lexer();

        try {
            List<TokenDTO> tokens = lexer.getTokens(pathFileReader.read(filePath));

            for (TokenDTO tokenDTO : tokens) {
                System.out.println(tokenDTO.toString());
            }
        } catch (NoSuchFieldException | SecurityException e) {
            e.printStackTrace();
        }
    }
}
