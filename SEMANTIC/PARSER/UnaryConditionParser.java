package SEMANTIC.PARSER;

import SEMANTIC.AST_NODES.UnaryCondition;
import SEMANTIC.AST_NODES.Operator;
import SEMANTIC.AST_NODES.LEAF_NODES.Identifier;
import SEMANTIC.AST_NODES.LEAF_NODES.Literal;

import SEMANTIC.PARSER.Exception.ParseException;
import SEMANTIC.PARSER.LEAF.IdentifierParser;
import SEMANTIC.PARSER.LEAF.LiteralParser;
import SEMANTIC.PARSER.util.ParserContext;

public class UnaryConditionParser {
    public static UnaryCondition parse(ParserContext ctx) throws ParseException {
        //just keep throwing above(exception) for now
        Identifier columnName = IdentifierParser.parse(ctx);
        Operator operator = OperatorParser.parse(ctx);
        Literal value = LiteralParser.parse(ctx);

        UnaryCondition condition = new UnaryCondition();
        condition.columnName = columnName;
        condition.operator = operator;
        condition.value = value;

        return condition;
    }
}
