package com.yc;

import java.io.StringReader;

import com.yc.parser.ParseException;
import com.yc.parser.Parser;
import com.yc.parser.Token;

public class Main {
    public static void main(String[] args) throws ParseException {
        String codigo = "cadeia () \n9";

        Parser lexer = new Parser(new StringReader(codigo));

        Token token = lexer.getNextToken();

        System.out.println("Código analisado: " + codigo + "\n");
        while (token.kind != 0) {
            System.out.println("Código: " + token.kind + " | Lexema: " + token.image + " | Linha: " + token.beginLine);
            token = lexer.getNextToken();
        }
    }
}
