package niclaspreter.parser;

import niclaspreter.lexer.Lexem;

import java.util.ArrayList;

public class Parser {
    ParseTreeGenerator parseTreeGenerator;

    public Parser(ArrayList<Lexem> lexems) {
        this.parseTreeGenerator = new ParseTreeGenerator(lexems);
    }

    public void parse() {
        parseTreeGenerator.generateParseTree();
    }
}
