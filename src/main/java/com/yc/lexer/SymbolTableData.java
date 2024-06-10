package com.yc.lexer;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class SymbolTableData {

    public SymbolTableData(int entry, String code, String lexame, int numChar, String type,
            List<Integer> lines) {
        this.entry = entry;
        this.code = code;
        this.lexame = lexame;
        this.numChar = numChar;
        this.type = type;
        this.lines = lines;

        setNumCharTrunc(numChar);

        if (numChar > 30) {
            setNumCharTrunc(30);
            setLexame(lexame.substring(0, 30));
        }
    }

    private int entry;

    private String code;

    private String lexame;

    private int numChar;

    private int numCharTrunc;

    private String type;

    private List<Integer> lines = new ArrayList<>();

}
