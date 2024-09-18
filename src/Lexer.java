import java.util.LinkedList;
import java.util.List;

public class Lexer {
    private String input;
    private int position;

    public Lexer(String input) {
        this.input = input;
        this.position = 0;
    }

    public Lexer() {
        this.input = "";
        this.position = 0;
    }

    public List<String> tokenize(String line) {
        this.input = line;
        this.position = 0;
        List<String> tokens = new LinkedList<>();
        
        while (position < input.length()) {
            char c = input.charAt(position);
            if (c == '"') {
                String tmp = "";
                position++;
                while (input.charAt(position) != '"' && position < input.length()) {
                    tmp += input.charAt(position);
                    position++;
                }
                position++;
                tokens.add(tmp);
            } else if (Character.isWhitespace(c)) {
                position++;
            } else {
                String tmp = "";
                while (position < input.length() && !Character.isWhitespace(input.charAt(position)) && input.charAt(position) != '"') {
                    tmp += input.charAt(position);
                    position++;
                }
                tokens.add(tmp);
            }
        }
        return tokens;
    }
}


