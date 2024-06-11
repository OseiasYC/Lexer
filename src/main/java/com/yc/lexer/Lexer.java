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
    List<Token> tokens;

    public Lexer(StringBuilder textFont) {
        this.parser = new Parser(new StringReader(textFont.toString()));
        this.tokens = new ArrayList<>();
    }

    public List<SymbolTableData> getSymbolTableData() {
        readAllTokens();
        Map<String, SymbolTableData> symbolTableMap = new HashMap<>();
        int entryCounter = 1;

        for (Token token : tokens) {
            String lexeme = token.image;
            int lineNumber = token.beginLine;

            if (getTokenCode(token.kind).startsWith("C")) {
                SymbolTableData symbolTableData = symbolTableMap.get(lexeme);

                if (symbolTableData == null) {
                    List<Integer> lines = new ArrayList<>();
                    lines.add(lineNumber);
                    symbolTableData = new SymbolTableData(entryCounter++, getTokenCode(token.kind), lexeme,
                            lexeme.length(), "TODO", lines);
                    symbolTableMap.put(lexeme, symbolTableData);
                } else {
                    symbolTableData.getLines().add(lineNumber);
                }
            }
        }

        return new ArrayList<>(symbolTableMap.values());
    }

    public List<LexData> getLexData() {
        readAllTokens();
        List<LexData> lexData = new ArrayList<>();
        List<SymbolTableData> symbolTableData;

            symbolTableData = getSymbolTableData();


        for (Token token : tokens) {
            String indexSymbolTable = "NA";

            for (SymbolTableData data : symbolTableData) {
                if (data.getLexeme().equals(token.image)) {
                    int i = 1;
                    indexSymbolTable = Integer.toString(i++);
                    break;
                }
            }

            lexData.add(new LexData(token.image, getTokenCode(token.kind), indexSymbolTable, token.beginLine));

        }

        return lexData;
    }

    public String getTokenCode(int kind) {
        Field[] fields = ParserConstants.class.getDeclaredFields();

        for (Field field : fields) {
            try {
                if (field.getInt(null) == kind) {
                    return field.getName();
                }
            } catch (IllegalAccessException e) {
            }
        }
        return null;
    }

    private void readAllTokens() {
        if (tokens.isEmpty()) {
            Token token = parser.getNextToken();
            while (token.kind != 0) {
                tokens.add(token);
                token = parser.getNextToken();
            }
        }
    }
}
