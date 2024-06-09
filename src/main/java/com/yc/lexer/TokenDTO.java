package com.yc.lexer;

import lombok.Data;

@Data
public class TokenDTO {

    public TokenDTO(String lexame, String code, int line, int iSymbolTable, int numChar) {
        this.lexame = lexame;
        this.code = code;
        this.line = line;
        this.iSymbolTable = iSymbolTable;
        this.numChar = numChar;
        setNumCharTrunc(numChar);

        if (numChar > 30) {
            setNumCharTrunc(30);
            setLexame(lexame.substring(0, 30));
        }
    }

    private String lexame;

    private String code;

    private int line;

    private int iSymbolTable;

    private int numChar;

    private int numCharTrunc;

}
