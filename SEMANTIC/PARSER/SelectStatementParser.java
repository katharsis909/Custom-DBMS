package SEMANTIC.PARSER;

import SEMANTIC.AST_NODES.SelectStatement;
import SEMANTIC.AST_NODES.SelectedColumnList;
import SEMANTIC.AST_NODES.WhereClause;
import SEMANTIC.AST_NODES.LEAF_NODES.Identifier;

import SEMANTIC.PARSER.LEAF.IdentifierParser;
import SEMANTIC.PARSER.util.ParserContext;
import SEMANTIC.PARSER.Exception.ParseException;

import LEXICAL.TokenType;

public class SelectStatementParser {
    public static SelectStatement parse(ParserContext ctx) throws ParseException {
        if (ctx.current().type != TokenType.SELECT) {
            throw new ParseException("Expected SELECT, found: " + ctx.current().getLexeme());
        }
        ctx.advance(); // consume "SELECT"

        SelectedColumnList selectedColumns = SelectedColumnListParser.parse(ctx);

        if (ctx.current().type != TokenType.FROM) {
            throw new ParseException("Expected FROM, found: " + ctx.current().getLexeme());
        }
        ctx.advance(); // consume "FROM"

        Identifier tableName = IdentifierParser.parse(ctx);

        WhereClause whereClause = null;
        if (ctx.current().type == TokenType.WHERE) {
            whereClause = WhereClauseParser.parse(ctx);
        }

        SelectStatement stmt = new SelectStatement();
        stmt.selectedColumnList = selectedColumns;
        stmt.tableName = tableName;
        stmt.whereClause = whereClause;

        return stmt;
    }
}
