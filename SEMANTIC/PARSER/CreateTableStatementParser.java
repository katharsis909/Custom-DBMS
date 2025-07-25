package SEMANTIC.PARSER;

import SEMANTIC.AST_NODES.CreateTableStatement;
import SEMANTIC.AST_NODES.ColumnDefinitionList;
import SEMANTIC.AST_NODES.LEAF_NODES.Identifier;
import SEMANTIC.PARSER.LEAF.IdentifierParser;
import SEMANTIC.PARSER.util.ParserContext;
import SEMANTIC.PARSER.Exception.ParseException;
import LEXICAL.TokenType;

public class CreateTableStatementParser {
    public static CreateTableStatement parse(ParserContext ctx) throws ParseException {
        // Expect: CREATE TABLE
        if (ctx.current().type != TokenType.CREATE)
            throw new ParseException("Expected 'CREATE' at start of CREATE TABLE statement");
        ctx.advance();

        if (ctx.current().type != TokenType.TABLE)
            throw new ParseException("Expected 'TABLE' after 'CREATE'");
        ctx.advance();

        // Parse table name
        Identifier tableName = IdentifierParser.parse(ctx);

        // Expect "("
        if (ctx.current().type != TokenType.LPAREN)
            throw new ParseException("Expected '(' after table name");
        ctx.advance();

        // Parse column columnList
        ColumnDefinitionList columns = ColumnDefinitionListParser.parse(ctx);

        // Expect ")"
        if (ctx.current().type != TokenType.RPAREN)
            throw new ParseException("Expected ')' after column columnList");
        ctx.advance();

        // Construct AST
        CreateTableStatement stmt = new CreateTableStatement();
        stmt.tableName = tableName;
        stmt.columns = columns;
        return stmt;
    }
}
