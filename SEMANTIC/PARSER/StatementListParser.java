package SEMANTIC.PARSER;

import SEMANTIC.AST_NODES.Statement;
import SEMANTIC.AST_NODES.StatementList;

import SEMANTIC.PARSER.util.ParserContext;
import SEMANTIC.PARSER.Exception.ParseException;
import LEXICAL.TokenType;
import STRUCTURE.Catalog;

import java.util.ArrayList;
import java.util.List;

public class StatementListParser {
    public static StatementList parse(ParserContext ctx) throws ParseException {
        List<Statement> statements = new ArrayList<>();

        while (ctx.current().type != TokenType.EOF) {
            Statement stmt = StatementParser.parse(ctx);
            statements.add(stmt);

            if (ctx.current().type != TokenType.SEMICOLON) {
                throw new ParseException("Expected ';' after statement, found: " + ctx.current().getLexeme());
            }
            ctx.advance(); // Consume ';'
        }

        return new StatementList(statements);
    }
}
