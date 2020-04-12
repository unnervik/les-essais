package niclaspreter;

import niclaspreter.lexer.Lexer;

public class Main {
    public static void main(String args[]) {
        String filename;
        if (args.length == 2) {
            filename = args[1];
        } else {
            filename = "/Users/niun/Niclaspreter/data/data1.nic";
        }
        System.out.println("using file: " + filename);

        Lexer lexer = new Lexer(filename);
        lexer.lexFile();
    }
}
