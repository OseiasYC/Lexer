package com.yc.lexer;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LexData {
    private String lexeme;

    private String code;

    private String indexSymbolTable;

    private int line;
}
