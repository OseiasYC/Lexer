package com.yc.lexer;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.yc.parser.ParserConstants;
import java.io.StringReader;

import com.yc.parser.Parser;
import com.yc.parser.Token;

public class Lexer {

    Parser parser;

    public Lexer(StringBuilder textFont) {
        this.parser = new Parser(new StringReader(textFont.toString()));
    }

    public void test() throws NoSuchFieldException, SecurityException {
        System.out.println("\n" + getSymbolTableData().toString());
    }

    public List<SymbolTableData> getSymbolTableData() throws NoSuchFieldException, SecurityException {
        Map<String, SymbolTableData> symbolTableMap = new HashMap<>();
        int entryCounter = 1;
        
        Token token = parser.getNextToken();
        
        while (token.kind != 0) {
            String lexeme = token.image;
            int lineNumber = token.beginLine;
            
            if (getTokenCode(token.kind).startsWith("C")) {
                SymbolTableData symbolTableData = symbolTableMap.get(lexeme);
                
                if (symbolTableData == null) {
                    List<Integer> lines = new ArrayList<>();
                    lines.add(lineNumber);
                    symbolTableData = new SymbolTableData(entryCounter++, getTokenCode(token.kind), lexeme, lexeme.length(), "TODO", lines);
                    symbolTableMap.put(lexeme, symbolTableData);
                } else {
                    symbolTableData.getLines().add(lineNumber);
                }
            }
            
            token = parser.getNextToken();
        }
        
        return new ArrayList<>(symbolTableMap.values());
    }

    public List<LexData> getLexData() throws NoSuchFieldException, SecurityException {
        List<LexData> lexData = new ArrayList<>();

        Token token = parser.getNextToken();

        while (token.kind != 0) {

            lexData.add(new LexData(token.image, getTokenCode(token.kind), 1, token.beginLine));

            token = parser.getNextToken();
        }

        return lexData;
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
