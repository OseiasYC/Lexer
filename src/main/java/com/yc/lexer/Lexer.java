package com.yc.lexer;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import com.yc.parser.ParserConstants;
import java.io.StringReader;

import com.yc.parser.Parser;
import com.yc.parser.Token;

public class Lexer {

    public List<TokenDTO> getTokens(StringBuilder code) throws NoSuchFieldException, SecurityException {
        Parser parser = new Parser(new StringReader(code.toString()));

        Token token = parser.getNextToken();

        List<TokenDTO> tokens = new ArrayList<>();

        int iSymbleTable = 0;

        while (token.kind != 0) {

            if (getTokenCode(token.kind).startsWith("B")) {
                iSymbleTable++;
            }

            tokens.add(new TokenDTO(token.image, getTokenCode(token.kind), token.beginLine, iSymbleTable, token.toString().length()));
            token = parser.getNextToken();
        }

        return tokens;
    }

    public String getTokenCode(int kind) throws NoSuchFieldException, SecurityException {
        Field[] fields = ParserConstants.class.getDeclaredFields();

        for (Field field : fields) {
            try {
                if (field.getInt(null) == kind) {
                    return field.getName();
                }
            } catch (IllegalAccessException e) {
            }
        }
        throw new NoSuchFieldException("Código da Tabela não encontrado.");
    }

}
