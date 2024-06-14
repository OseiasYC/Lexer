package com.yc.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.yc.lexer.LexData;
import com.yc.lexer.Lexer;
import com.yc.lexer.SymbolTableData;

public class ReportsGenerator {
    List<LexData> lexData = new ArrayList<>();
    List<SymbolTableData> symbolTableData = new ArrayList<>();
    String folder = "reports/";
    String fileName;

    String header = ("COMPONENTES - CÓDIGO DA EQUIPE: EQ03\n" +
            "    Harrison Borges dos Santos   | harrison.borges@ucsal.edu.br  | (71) 99290-4126\n" +
            "    Iago Roque Ribeiro Novaes    | iago.roque@ucsal.edu.br       | (73) 99934-6222\n" +
            "    Lucas Farias da Silva        | lucas.farias@ucsal.edu.br     | (71) 99368-8705\n" +
            "    Oseias Lopes da Silva        | oseias.silva@ucsal.edu.br     | (74) 99118-0551\n");

    public void generate(String fileName, StringBuilder content) throws NoSuchFieldException, SecurityException {
        Lexer lexer = new Lexer(content);
        new File(folder).mkdir();

        lexData = lexer.getLexData();
        symbolTableData = lexer.getSymbolTableData();

        this.fileName = fileName.substring(0, fileName.lastIndexOf('.'));

        generateSymbolTableReport();
        generateLexReport();
    }

    private void generateLexReport() {
        try {
            BufferedWriter writerLEX = new BufferedWriter(new FileWriter(folder + fileName + ".lex"));

            writerLEX.write(header);
            writerLEX.write("\nRELATÓRIO DA ANÁLISE LÉXICA. Texto fonte analisado: " + fileName + ".241\n");

            for (LexData data : lexData) {
                writerLEX.write(
                        String.format(
                                "------------------------------------------------------------------------------------------\nLexame: %s, Código: %s, Índice na Tabela: %s, Linha: %s\n",
                                data.getLexeme().toUpperCase(), data.getCode(), data.getIndexSymbolTable(), data.getLine()));
            }

            writerLEX.close();

        } catch (IOException e) {
            System.err.println("\u001B[31mOcorreu um erro na geração do .lex. Reinicie o programa.\u001B[0m");
            System.exit(1);
        }
    }

    private void generateSymbolTableReport() {
        try {
            BufferedWriter writerLEX = new BufferedWriter(new FileWriter(folder + fileName + ".tab"));

            writerLEX.write(header);
            writerLEX.write("\nRELATÓRIO DA TABELA DE SÍMBOLOS. Texto fonte analisado: " + fileName + ".241\n");

            for (SymbolTableData data : symbolTableData) {
                writerLEX.write(
                        String.format(
                                "------------------------------------------------------------------------------------------\nEntrada: %s, Código: %s, Lexame: %s,\nQtdCharAntesTrunc: %s, QtdCharDepoisTrunc: %s,\nTipoSimb: %s, Linhas: %s\n",
                                data.getEntry(), data.getCode(), data.getLexeme(), data.getNumChar(),
                                data.getNumCharTrunc(), data.getType(), data.getLines()));
            }

            writerLEX.close();

        } catch (IOException e) {
            System.err.println("\u001B[31mOcorreu um erro na geração do .tab. Reinicie o programa.\u001B[0m");
            System.exit(1);
        }
    }

    public void readLex() {
        read(fileName + ".lex");
    }

    public void readTab() {
        read(fileName + ".tab");
    }

    private void read(String fileName) {
        try (BufferedReader br = new BufferedReader(new FileReader("reports/" + fileName))) {
            String line;
            System.out.println("\n");
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println("\u001B[31mErro na leitura do relatório: " + fileName + ".\u001B[0m");
        }
    }
}