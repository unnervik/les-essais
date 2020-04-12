package niclaspreter;

import javax.swing.text.html.parser.Parser;
import java.util.ArrayList;

public class ParseTreeGenerator {
    enum ParserStatus {
        SUCCESS,
        NOTHING_TO_PARSE,

        _UNDEFINED
    }
    private ArrayList<Lexem> lexems;

    public ParseTreeGenerator(ArrayList<Lexem> lexems) {
        this.lexems = lexems;
    }

    public ParserStatus parse() {
        ParserStatus parserStatus = ParserStatus._UNDEFINED;
        if (lexems.size() < 1){
            parserStatus = ParserStatus.NOTHING_TO_PARSE;
            return parserStatus;
        }


        return parserStatus;
    }
}
