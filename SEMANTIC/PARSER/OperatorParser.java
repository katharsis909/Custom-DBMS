package SEMANTIC.PARSER;

import LEXICAL.Token;
import LEXICAL.TokenType;
import SEMANTIC.PARSER.Exception.ParseException;
import SEMANTIC.AST_NODES.Operator;
import SEMANTIC.PARSER.util.ParserContext;

public class OperatorParser {
    public static Operator parse(ParserContext ctx) throws ParseException {
        Token token = ctx.current();

        if (token.type != TokenType.EQUAL) {
            throw new ParseException("Expected '=' operator, " + token.getPosition());
        }
        //expect function of ctx will print EQUAL instead of =; so do not use

        ctx.advance();
        Operator op = new Operator();
        op.symbol = token.getLexeme();
        return op;
    }
}
