package com.yc;

import java.io.StringReader;
import java.lang.reflect.Field;

import com.yc.parser.ParseException;
import com.yc.parser.Parser;
import com.yc.parser.ParserConstants;
import com.yc.parser.Token;

public class Main {
    public static void main(String[] args) throws ParseException, NoSuchFieldException {
        String codigo = "logico < <= != ?";

        Parser parser = new Parser(new StringReader(codigo));

        Token token = parser.getNextToken();

        System.out.println("Código analisado: " + codigo + "\n");
        while (token.kind != 0) {
            System.out.println("Código: " + getTableCode(token.kind) + " | Lexema: " + token.image + " | Linha: " + token.beginLine);
            token = parser.getNextToken();
        }
    }

    public static String getTableCode(int kind) throws NoSuchFieldException, SecurityException {
        Field[] fields = ParserConstants.class.getDeclaredFields();

        for (Field field : fields) {
            try {
                if (field.getInt(null) == kind) {
                    return field.getName();
                }
            } catch (IllegalAccessException e){}
        }
        throw new NoSuchFieldException("Código da Tabela não encontrado.");
    }
}