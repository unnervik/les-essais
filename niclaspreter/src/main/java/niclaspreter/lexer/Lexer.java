package niclaspreter.lexer;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by niun on 2020-03-05.
 */
public class Lexer {
    enum LexerStatus {
        SUCCESS,
        FAIL_UNEXPECTED_CHARACTER,

        _UNDEFINED
    };
    private String filename;

    public Lexer(String filename) {
        this.filename = filename;
    }

    public ArrayList<Lexem> lexFile() {
        ArrayList<Lexem> lexems = new ArrayList<>();
        LexerStatus status = LexerStatus._UNDEFINED;

        try (BufferedReader br = new BufferedReader(new FileReader(filename))){
            String line;
            int currentLineNumber = 1;
            while ((line = br.readLine()) != null) {
                status = lexLine(line, currentLineNumber, lexems);
                ++currentLineNumber;
                if (status != LexerStatus.SUCCESS){
                    break;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (status == LexerStatus.SUCCESS) {
                lexems.stream().forEachOrdered(lexem->System.out.println(lexem));
            } else {
                System.err.println("Lexing failed with error: " + status.name());
            }
        }
        return lexems;
    }

    public LexerStatus lexLine(String line, int lineNumber, ArrayList<Lexem> lexems) {
        int lineLen = line.length();
        int curr = 0;
        LexerStatus status = LexerStatus._UNDEFINED;
        while (curr < lineLen && status == LexerStatus._UNDEFINED) {
            //this could be a stream: IntStream.range(0, lineLen).forEachOrdered(curr -> {
            char token = line.charAt(curr);

            if (isWhiteSpace(token)) {
                ++curr;
                continue;
            }

            if (isDigit(token)) {
                int col = curr;
                String number = new String(); //String is immutable so a poor choice long term
                do {
                    number += String.valueOf(token);
                    if (++curr == lineLen) {
                        break;
                    }
                    token = line.charAt(curr);
                    if (isAlpha(token)) { //catch things likr 5h
                        System.err.println("Invalid character at " + lineNumber + ", " + curr + ": " + token);
                        status = LexerStatus.FAIL_UNEXPECTED_CHARACTER;
                        break;
                    }
                } while (isDigit(token));
                lexems.add(new Lexem(LexemType.DIGIT, lineNumber, col, number));
                continue;
            }

            if (isAlpha(token) || token == '_') {
                int col = curr;
                String string = new String();
                do {
                    string += String.valueOf(token);
                    if (++curr == lineLen) {
                        break;
                    }
                    token = line.charAt(curr);
                } while (isAlNum(token) || token == '_');
                lexems.add(new Lexem(LexemType.NAME, lineNumber, col, string));
                continue;
            }

            if (isOperator(token)) {
                LexemType lt = LexemType.UNDEFINED;
                switch(token) {
                    case '+':
                        lt = LexemType.ADD;
                        break;
                    case '-':
                        lt = LexemType.SUB;
                        break;
                    case '*':
                        lt = LexemType.MUL;
                        break;
                    case '/':
                        lt = LexemType.DIV;
                        break;
                    default:
                        System.err.println("Invalid operator at a, b: " + token);
                }
                lexems.add(new Lexem(lt, lineNumber, curr, ""));
                ++curr;
                continue;
            }

            if (token == '=') {
                lexems.add(new Lexem(LexemType.ASSIGNMENT, lineNumber, curr, ""));
                ++curr;
                continue;
            }

            if (isSequencePoint(token)) {
                lexems.add(new Lexem(LexemType.SEQUENCEPOINT, lineNumber, curr, ""));
                ++curr;
                continue;
            }


            //ERROR if not end of line which should be caught by the
            // pattern of increasing curr and continuing everytime we
            // find something. This might be considered a parser error
            // and not a lexer error.
            System.out.println("Unexpected end of line?");
        }
        if (status == LexerStatus._UNDEFINED){
            status = LexerStatus.SUCCESS;
        }
        return status;
    }

    boolean isWhiteSpace(char c) {
        return java.lang.Character.isWhitespace(c);
    }

    boolean isDigit(char c) {
        return java.lang.Character.isDigit(c);
    }

    boolean isAlpha(char c) {
        return java.lang.Character.isAlphabetic(c);
    }

    boolean isAlNum(char c) {
        return isAlpha(c) || isDigit(c);
    }

    boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

    boolean isSequencePoint(char c) {
        return c == ';';
    }

}
