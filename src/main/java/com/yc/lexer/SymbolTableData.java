package com.yc.lexer;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class SymbolTableData {

    public SymbolTableData(int entry, String code, Object lexeme, int numChar,
            List<Integer> lines) {
        this.entry = entry;
        this.code = code;
        this.lexeme = lexeme;
        this.numChar = numChar;
        this.type = identifyType(lexeme);
        this.lines = lines;

        setNumCharTrunc(numChar);

        if (numChar > 30) {
            setNumCharTrunc(30);
            setLexeme(truncate(lexeme));
        }
    }

    private int entry;

    private String code;

    private Object lexeme;

    private int numChar;

    private int numCharTrunc;

    private String type;

    private List<Integer> lines = new ArrayList<>();

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

    public static String identifyType(Object obj) {
        if (obj instanceof String) {
            String str = (String) obj;
            if (str.matches("^\"([a-zA-Z0-9]| |\\$|_|\\.)*\"$")) {
                return "STR";
            } else if (str.matches("^-?\\d+$")) {
                return "INT";
            } else if (str.matches("^-?\\d*\\.\\d+$")) {
                return "PFO";
            } else if (str.matches("^true|false$")) {
                return "BOO";
            } else if (str.length() == 1) {
                return "CHC";
            }
        }
        return "VOI";

    }
}