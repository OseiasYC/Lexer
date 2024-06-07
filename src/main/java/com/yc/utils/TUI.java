package com.yc.utils;

import java.util.Scanner;

public class TUI {
    Scanner sc = new Scanner(System.in);

    private static final String PINK = "\u001B[35m";
    private static final String YELLOW = "\u001B[33m";
    private static final String GREEN = "\u001B[32m";
    private static final String CYAN = "\u001B[36m";
    private static final String RESET = "\u001B[0m";
    
    public void run() {
        System.out.println(
            header()
        );
    }


    public String header() {
        return (CYAN + "COMPONENTES - CÓDIGO DA EQUIPE: " + RESET + "EQ03:\n" +
                PINK + "Harrison Borges dos Santos  " + RESET + " | harrison.borges@ucsal.edu.br  | (71) 99290-4126\n" +
                PINK + "Iago Roque Ribeiro Noaves   " + RESET + " | iago.roque@ucsal.edu.br       | (73) 99934-6222\n" +
                PINK + "Lucas Farias da Silva       " + RESET + " | lucas.farias@ucsal.edu.br     | (71) 99368-8705\n" +
                PINK + "Oseias Lopes da Silva       " + RESET + " | oseias.silva@ucsal.edu.br     | (74) 99118-0551");
    }
}
