package niclaspreter;

public class Lexem {
    LexemType type;
    int line;
    int column;
    String data;

    public Lexem(LexemType type, int line, int column, String data) {
        this.type = type;
        this.line = line;
        this.column = column;
        this.data = data;
    }

    @Override
    public String toString() {
        String dataStr = data.length() > 0 ? ", '" + data + '\'' : "";
        return "Lexem{" +
                type.name() +
                ", " + line +":"+ column +
                 dataStr +
                '}';
    }
}
