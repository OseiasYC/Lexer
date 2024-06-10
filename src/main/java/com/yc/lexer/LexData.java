package com.yc.lexer;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LexData {
    private String lexame;

    private String code;

    private int indexSymbolTable;

    private int line;
}
