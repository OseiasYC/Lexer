package com.yc.utils;

import java.util.Scanner;

import com.yc.Main;

public class TUI {
    // ReportsGenerator reportsGenerator = new ReportsGenerator();
    PathFileReader pathFileReader = new PathFileReader();
    StringBuilder content;
    Scanner sc = new Scanner(System.in);
    String filePath;
    String fileName;

    private static final String PINK = "\u001B[35m";
    public static final String RED = "\u001B[31m";
    private static final String GREEN = "\u001B[32m";
    private static final String CYAN = "\u001B[36m";
    private static final String RESET = "\u001B[0m";

    public void run() {
        System.out.println(CYAN + "COMPONENTES - CÓDIGO DA EQUIPE: " + RESET + "EQ03\n" +
                PINK + "    Harrison Borges dos Santos  " + RESET
                + " | harrison.borges@ucsal.edu.br  | (71) 99290-4126\n" +
                PINK + "    Iago Roque Ribeiro Noaves   " + RESET
                + " | iago.roque@ucsal.edu.br       | (73) 99934-6222\n" +
                PINK + "    Lucas Farias da Silva       " + RESET
                + " | lucas.farias@ucsal.edu.br     | (71) 99368-8705\n" +
                PINK + "    Oseias Lopes da Silva       " + RESET
                + " | oseias.silva@ucsal.edu.br     | (74) 99118-0551");

        body();
    }

    public void body() {

        try {
            do {
                System.out.println(
                        "\nInsira o local ou o caminho absoluto do arquivo para análise - sem aspas.");
                filePath = sc.nextLine();

                content = pathFileReader.read(filePath);
                fileName = pathFileReader.fileName;

            } while (pathFileReader.content.length() == 0);

            //footer();
            sc.close();

        } catch (Exception e) {
            System.out.println(
                    RED + "\nOcorreu um erro inesperado durante a leitura, por favor, tente novamente." + RESET);
            body();
        }
    }

    // public void menu() {
    //     int option = 0;

    //     System.out.println(CYAN + "\nESCOLHA UMA OPÇÃO:\n" + RESET
    //             + "    1- Exibir .TAB\n    2- Exibir .LEX\n    3- Exibir ambos\n    4- Analisar outro texto\n    5- Sair");
    //     option = sc.nextInt();

    //     while (option < 1 || option > 5) {
    //         System.out.println(RED + "\nDigite um número válido:" + RESET);
    //         option = sc.nextInt();
    //         System.out.println("\n");
    //     }

    //     switch (option) {
    //         case 1:
    //             reportsGenerator.readTab();
    //             break;
    //         case 2:
    //             reportsGenerator.readLex();
    //             break;
    //         case 3:
    //             reportsGenerator.readLex();
    //             reportsGenerator.readTab();
    //             break;
    //         case 4:
    //             Main.main(null);
    //             break;
    //         case 5:
    //             System.exit(1);
    //             break;
    //     }
    //     menu();
    // }
    
    // public void footer() {
    //     try {
    //         reportsGenerator.generate(fileName, content);
    //         System.out.println(GREEN + "\nRelatórios gerados com sucesso na pasta \"reports\".\n");
    //         menu();
    //     } catch (NoSuchFieldException | SecurityException e) {
    //         System.out.println(
    //                 RED + "\nOcorreu um erro inesperado nos relatórios, por favor, tente novamente." + RESET);
    //     }
    // }
}
