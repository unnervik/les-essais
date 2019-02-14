import java.util.HashMap;

public class ParsyBaseVisitorImpl extends ParsyBaseVisitor<Integer> {
    private HashMap<String, Double> variables = new HashMap<String, Double>();

    @Override
    public Integer visitProgram(ParsyParser.ProgramContext ctx) {
        System.out.println("Found program");

        return super.visitProgram(ctx);
    }

    @Override
    public Integer visitStatement(ParsyParser.StatementContext ctx) {
        System.out.println("Found Statement");

        return super.visitStatement(ctx);
    }

    @Override
    public Integer visitVarStatement(ParsyParser.VarStatementContext ctx) {
        System.out.println("Found VarStatement: " + ctx.IDENTIFIER().toString());

        return super.visitVarStatement(ctx);
    }

    @Override
    public Integer visitExpr(ParsyParser.ExprContext ctx) {
        System.out.println("Found Expr, child count: " + ctx.getChildCount());


        return super.visitExpr(ctx);
    }

    @Override
    public Integer visitMultiplyDivideMath(ParsyParser.MultiplyDivideMathContext ctx) {
        System.out.println("Found MultiplyDivideMath");

        return super.visitMultiplyDivideMath(ctx);
    }

    @Override
    public Integer visitDivideMath(ParsyParser.DivideMathContext ctx) {
        System.out.println("Found DivideMath");

        return super.visitDivideMath(ctx);
    }

    @Override
    public Integer visitMultiplyMath(ParsyParser.MultiplyMathContext ctx) {
        System.out.println("Found MultiplyMath");

        return super.visitMultiplyMath(ctx);
    }

    @Override
    public Integer visitMathAtom(ParsyParser.MathAtomContext ctx) {
        System.out.println("Found MathAtom");

        return super.visitMathAtom(ctx);
    }

    @Override
    public Integer visitNumber(ParsyParser.NumberContext ctx) {
        System.out.println("Found Number");

        return super.visitNumber(ctx);
    }
}
