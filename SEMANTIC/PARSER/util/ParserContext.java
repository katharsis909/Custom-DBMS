package SEMANTIC.PARSER.util;

import LEXICAL.*;
import SEMANTIC.PARSER.Exception.ParseException;

public class ParserContext {
    private final Lexer lexer;
    private Token current;

    public ParserContext(Lexer lexer) {
        this.lexer = lexer;
        this.current = lexer.nextToken();
    }

    public Token current() {
        return current;
    }

    public void advance() {
        current = lexer.nextToken();
    }

    public boolean match(TokenType type) {
        if (current.type == type) {
            advance();
            return true;
        }
        return false;
    }

    public Token expect(TokenType type) throws ParseException
    {
        if (current.type == type) {
            Token tok = current;
            advance();
            return tok;
        } else {
            throw new ParseException("Expected token " + type + " but found " + current.getType() + " at position " + current.getPosition());
        }
    }

    public boolean isAtEnd() {
        return current.type == TokenType.EOF;
    }
}
