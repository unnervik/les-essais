import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

public class Main {
    public static void main(String[] args) throws Exception {
        CharStream input = CharStreams.fromFileName("data/source1.parsy");
        System.out.println("___\n" + input.toString() + "\n___");

        ParsyLexer lexer = new ParsyLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        ParsyParser parser = new ParsyParser(tokens);
        ParseTree tree = parser.program();

        ParsyBaseVisitorImpl calcVisitor = new ParsyBaseVisitorImpl();
        Integer result = calcVisitor.visit(tree);
        System.out.println("Result: " + result);
    }
}