// package com.yc.utils;

// import java.io.BufferedReader;
// import java.io.BufferedWriter;
// import java.io.File;
// import java.io.FileReader;
// import java.io.FileWriter;
// import java.io.IOException;
// import java.util.ArrayList;
// import java.util.List;

// import com.yc.lexer.Lexer;

// public class ReportsGenerator {
//     Lexer lexer = new Lexer("TODO");
//     List<TokenDTO> tokens = new ArrayList<>();

//     String folder = "reports/";
//     String fileName;

//     String header = ("COMPONENTES - CÓDIGO DA EQUIPE: EQ03\n" +
//             "    Harrison Borges dos Santos   | harrison.borges@ucsal.edu.br  | (71) 99290-4126\n" +
//             "    Iago Roque Ribeiro Noaves    | iago.roque@ucsal.edu.br       | (73) 99934-6222\n" +
//             "    Lucas Farias da Silva        | lucas.farias@ucsal.edu.br     | (71) 99368-8705\n" +
//             "    Oseias Lopes da Silva        | oseias.silva@ucsal.edu.br     | (74) 99118-0551\n");

//     public void generate(String fileName, StringBuilder content) throws NoSuchFieldException, SecurityException {
//         this.tokens = lexer.readTokens(content);
//         this.fileName = fileName.substring(0, fileName.lastIndexOf('.'));

//         new File(folder).mkdir();

//         generateSymbolTableReport();
//         generateLexReport();
//     }

//     private void generateLexReport() {
//         try {
//             BufferedWriter writerLEX = new BufferedWriter(new FileWriter(folder + fileName + ".lex"));

//             writerLEX.write(header);
//             writerLEX.write("\nRELATÓRIO DA ANÁLISE LÉXICA. Texto fonte analisado: " + fileName + ".241\n");

//             for (TokenDTO token : tokens) {
//                 writerLEX.write(
//                         String.format(
//                                 "------------------------------------------------------------------------------------------\nLexame: %s, Código: %s, Índice na Tabela: %s, Linha: %s\n",
//                                 token.getLexame(), token.getCode(), token.getISymbolTable(), token.getLine()));
//             }

//             writerLEX.close();

//         } catch (IOException e) {
//             System.out.println("\u001B[31mOcorreu um erro na geração do .lex. Reinicie o programa.\u001B[0m");
//             System.exit(1);
//         }
//     }

//     private void generateSymbolTableReport() {
//         try {
//             BufferedWriter writerLEX = new BufferedWriter(new FileWriter(folder + fileName + ".tab"));

//             writerLEX.write(header);
//             writerLEX.write("\nRELATÓRIO DA TABELA DE SÍMBOLOS. Texto fonte analisado: " + fileName + ".241\n");

//             for (TokenDTO token : tokens) {
//                 writerLEX.write(
//                         String.format(
//                                 "------------------------------------------------------------------------------------------\nEntrada: TODO, Código: %s, Lexame: %s,\nQtdCharAntesTrunc: %s, QtdCharDepoisTrunc: %s,\nTipoSimb: TODO, Linhas: {TODO}\n",
//                                 token.getCode(), token.getLexame(), token.getNumChar(), token.getNumCharTrunc()));
//             }

//             writerLEX.close();

//         } catch (IOException e) {
//             System.out.println("\u001B[31mOcorreu um erro na geração do .tab. Reinicie o programa.\u001B[0m");
//             System.exit(1);
//         }
//     }

//     public void readLex() {
//         read(fileName + ".lex");
//     }

//     public void readTab() {
//         read(fileName + ".tab");
//     }

//     private void read(String fileName) {
//         try (BufferedReader br = new BufferedReader(new FileReader("reports/" + fileName))) {
//             String line;
//             while ((line = br.readLine()) != null) {
//                 System.out.println(line);
//             }
//         } catch (IOException e) {
//             System.out.println("\u001B[31mErro na leitura do relatório: " + fileName + ".\u001B[0m");
//         }
//     }
// }