package com.yc.lexer;

import lombok.Data;

@Data
public class LexData {
    private Object lexeme;

    private String code;

    private String indexSymbolTable;

    private int line;

    

    public LexData(Object lexeme, String code, String indexSymbolTable, int line) {
        this.lexeme = truncate(lexeme);
        this.code = code;
        this.indexSymbolTable = indexSymbolTable;
        this.line = line;
    }

    private Object truncate(Object lexeme) {
        String core = lexeme.toString();
    
        if (lexeme instanceof String) {
            if (core.startsWith("\"") && core.endsWith("\"")) {
                core = core.substring(1, core.length() - 1);
            }
            
            if (core.length() > 30) {
                if (core.charAt(29) == '.') {
                    core = core.substring(0, 29);
                } else {
                    core = core.substring(0, 30);
                }
            }

            if (lexeme.toString().startsWith("\"") && lexeme.toString().endsWith("\"")) {
                core = "\"" + core + "\"";
            }
        }

        return core;
    }
}
