package SEMANTIC.PARSER;

import SEMANTIC.AST_NODES.ColumnDefinition;
import SEMANTIC.AST_NODES.DataType;
import SEMANTIC.AST_NODES.LEAF_NODES.Identifier;
import SEMANTIC.PARSER.LEAF.IdentifierParser;
import SEMANTIC.PARSER.util.ParserContext;
import SEMANTIC.PARSER.Exception.ParseException;

public class ColumnDefinitionParser {
    public static ColumnDefinition parse(ParserContext ctx) throws ParseException {
        Identifier columnName = IdentifierParser.parse(ctx);
        DataType dataType = DataTypeParser.parse(ctx);

        ColumnDefinition def = new ColumnDefinition();
        def.columnName = columnName;
        def.dataType = dataType;

        return def;
    }
}
