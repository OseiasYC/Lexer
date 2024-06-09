package com.yc.lexer;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class TokenDTO {

    public TokenDTO(String lexame, String code, int line, int iSymbolTable, int numChar) {
        this.lexame = lexame;
        this.code = code;
        this.line = line;
        this.iSymbolTable = iSymbolTable;
        this.numChar = numChar;

        if (numChar > 30) {
            setNumCharTrunc(30);
            setLexame(lexame.substring(0, 30));
        }
    }

    @Getter
    @Setter
    private String lexame;

    @Getter
    @Setter
    private String code;

    @Getter
    @Setter
    private int line;

    @Getter
    @Setter
    private int iSymbolTable;

    @Getter
    @Setter
    private int numChar;

    @Getter
    private int numCharTrunc;

    private void setNumCharTrunc(int numCharTrunc) {
        this.numCharTrunc = numCharTrunc;
    }

}
