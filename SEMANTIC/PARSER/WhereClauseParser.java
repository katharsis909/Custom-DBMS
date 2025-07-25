package SEMANTIC.PARSER;

import SEMANTIC.AST_NODES.WhereClause;
import SEMANTIC.AST_NODES.ConditionList;
import SEMANTIC.PARSER.util.ParserContext;
import SEMANTIC.PARSER.Exception.ParseException;
import LEXICAL.TokenType;

public class WhereClauseParser {
    public static WhereClause parse(ParserContext ctx) throws ParseException {
        if (ctx.current().type != TokenType.WHERE) {
            throw new ParseException("Expected WHERE, found: " + ctx.current().getLexeme());
        }

        ctx.advance(); // skip "WHERE"

        ConditionList conditionList = ConditionListParser.parse(ctx);

        WhereClause clause = new WhereClause();
        clause.conditions = conditionList;
        return clause;
    }
}
