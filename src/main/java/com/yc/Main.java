package com.yc;

import com.yc.lexer.Lexer;
import com.yc.parser.Parser;
import com.yc.utils.TUI;

public class Main {
    public static void main(String[] args) throws NoSuchFieldException, SecurityException {
        // TUI tui = new TUI();
        // tui.run();

        Lexer lexer = new Lexer(new StringBuilder("cadei@@@a"));

        lexer.test();
    }
}