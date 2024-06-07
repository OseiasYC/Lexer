package com.yc.lexer;

public class TokenDTO {
    String lexame;

    String code;

    int line;

    public TokenDTO(String lexame, String code, int line) {
        this.lexame = lexame;
        this.code = code;
        this.line = line;
    }

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line = line;
    }

    public String getLexame() {
        return lexame;
    }

    public void setLexame(String lexame) {
        this.lexame = lexame;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
