package SEMANTIC.PARSER;

import SEMANTIC.AST_NODES.Value;
import SEMANTIC.AST_NODES.ValueList;
import SEMANTIC.PARSER.util.ParserContext;
import SEMANTIC.PARSER.Exception.ParseException;
import LEXICAL.TokenType;

import java.util.ArrayList;
import java.util.List;

public class ValueListParser {
    public static ValueList parse(ParserContext ctx) throws ParseException {
        List<Value> values = new ArrayList<>();

        values.add(ValueParser.parse(ctx));

        while (ctx.current().type == TokenType.COMMA) {
            ctx.advance(); // Skip comma
            values.add(ValueParser.parse(ctx));
        }

        ValueList list = new ValueList();
        list.values = values;
        return list;
    }
}
