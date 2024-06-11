package com.yc.lexer;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class SymbolTableData {

    public SymbolTableData(int entry, String code, String lexeme, int numChar, String type,
            List<Integer> lines) {
        this.entry = entry;
        this.code = code;
        this.lexeme = lexeme;
        this.numChar = numChar;
        this.type = type;
        this.lines = lines;

        setNumCharTrunc(numChar);

        if (numChar > 30) {
            setNumCharTrunc(30);
            setLexeme(lexeme.substring(0, 30));
        }
    }

    private int entry;

    private String code;

    private String lexeme;

    private int numChar;

    private int numCharTrunc;

    private String type;

    private List<Integer> lines = new ArrayList<>();

}
