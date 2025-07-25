package SEMANTIC.PARSER;

import LEXICAL.TokenType;
import SEMANTIC.AST_NODES.DataType;
import SEMANTIC.PARSER.util.ParserContext;
import SEMANTIC.PARSER.Exception.ParseException;

public class DataTypeParser {
    public static DataType parse(ParserContext ctx) throws ParseException {
        TokenType type = ctx.current().type;

        if (type == TokenType.INT || type == TokenType.STRING) {
            DataType dt = new DataType();
            dt.dataType = ctx.current().getLexeme().toUpperCase(); // Ensure uniform capitalization
            ctx.advance();
            return dt;
        } else {
            throw new ParseException("Expected data type INT or STRING but found: " + ctx.current().getLexeme());
        }
    }
}
