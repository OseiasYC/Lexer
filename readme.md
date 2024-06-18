## ⚙️ Lexical Analyzer ⚙️

This project is a sophisticated lexical and syntactic analyzer (lexer & parser) written in Java using JavaCC, with a strong emphasis on testing and report generation.

## 💻 Technologies Used:

- Java
- JavaCC

## 📂 Project Architecture

### src/main/java/com/yc/

Contains the main source code of the project.

- `lexer/`: Implementation of the lexical analyzer (lexer).
    - `LexData.java`: Defines data structures related to the lexing process.
    - `Lexer.java`: Main implementation of the lexer, responsible for dividing the code into tokens.
    - `SymbolTableData.java`: Manages the symbol table, which stores information about variables, functions, etc.

- `parser/`: Implementation of the syntactic analyzer (parser).
    - `ParseException.java`: Defines the exception thrown in case of a syntax error.
    - `Parser.java`: Main implementation of the parser, responsible for analyzing the code structure.
    - `Parser.jj`: Likely the grammar used by JavaCC or a similar tool to generate the parser.
    - `[Other parser-related files]`: `ParserConstants.java`, `ParserTokenManager.java`, `SimpleCharStream.java`, `Token.java`, `TokenMgrError.java`.

- `utils/`: Auxiliary utilities.
    - `PathFileReader.java`: File and directory manipulation.
    - `ReportsGenerator.java`: Report generation, possibly about the code analysis.
    - `TUI.java`: Text User Interface (TUI).
- `Main.java`: Entry point of the application.

## Conclusion

This project is a tool for code analysis with potential applications such as:

* **IDE Development:** Providing features like syntax highlighting, error detection, and autocompletion.
* **Static Code Analysis:** Identifying potential code issues, vulnerabilities, and bad practices.
* **Compilers and Interpreters:** Translating source code into executable code.

## Language Documentation and Specifications:
[2024-1 Compiler Design Specification](https://github.com/OseiasYC/Lexer/blob/main/Project2024-1%20v1.0.pdf)

---
_Build with hate in the ❤ - [MIT](https://github.com/OseiasYC/Lexer/blob/main/LICENSE)._
