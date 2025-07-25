package SEMANTIC.PARSER;

import SEMANTIC.AST_NODES.InsertIntoStatement;
import SEMANTIC.AST_NODES.LEAF_NODES.Identifier;
import SEMANTIC.AST_NODES.ValueList;
import SEMANTIC.PARSER.LEAF.IdentifierParser;
import SEMANTIC.PARSER.util.ParserContext;
import SEMANTIC.PARSER.Exception.ParseException;
import LEXICAL.TokenType;

public class InsertIntoStatementParser {
    public static InsertIntoStatement parse(ParserContext ctx) throws ParseException {
        if (ctx.current().type != TokenType.INSERT) {
            throw new ParseException("Expected INSERT, found: " + ctx.current().getLexeme());
        }
        ctx.advance(); // INSERT

        if (ctx.current().type != TokenType.INTO) {
            throw new ParseException("Expected INTO, found: " + ctx.current().getLexeme());
        }
        ctx.advance(); // INTO

        Identifier tableName = IdentifierParser.parse(ctx);

        if (ctx.current().type != TokenType.VALUES) {
            throw new ParseException("Expected VALUES, found: " + ctx.current().getLexeme());
        }
        ctx.advance(); // VALUES

        if (ctx.current().type != TokenType.LPAREN) {
            throw new ParseException("Expected (, found: " + ctx.current().getLexeme());
        }
        ctx.advance(); // (

        ValueList valueList = ValueListParser.parse(ctx);

        if (ctx.current().type != TokenType.RPAREN) {
            throw new ParseException("Expected ), found: " + ctx.current().getLexeme());
        }
        ctx.advance(); // )

        InsertIntoStatement stmt = new InsertIntoStatement();
        stmt.tableName = tableName;
        stmt.valueList = valueList;
        return stmt;
    }
}
