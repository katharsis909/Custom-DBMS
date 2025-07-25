package SEMANTIC.PARSER;

import SEMANTIC.AST_NODES.SelectedColumnList;
import SEMANTIC.AST_NODES.ColumnMention;
import SEMANTIC.PARSER.util.ParserContext;
import SEMANTIC.PARSER.Exception.ParseException;
import LEXICAL.TokenType;

import java.util.ArrayList;

public class SelectedColumnListParser {
    public static SelectedColumnList parse(ParserContext ctx) throws ParseException {
        SelectedColumnList scl = new SelectedColumnList();

        if (ctx.current().type == TokenType.STAR) {
            scl.isSelectAll = true;
            scl.columns = null;
            ctx.advance(); // Consume '*'
        } else {
            scl.isSelectAll = false;
            scl.columns = new ArrayList<>();

            ColumnMention col = ColumnMentionParser.parse(ctx);
            scl.columns.add(col);

            while (ctx.current().type == TokenType.COMMA) {
                ctx.advance(); // Skip ','
                ColumnMention nextCol = ColumnMentionParser.parse(ctx);
                scl.columns.add(nextCol);
            }
        }

        return scl;
    }
}
