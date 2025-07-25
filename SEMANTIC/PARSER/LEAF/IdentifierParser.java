package SEMANTIC.PARSER.LEAF;

import LEXICAL.*;
import SEMANTIC.AST_NODES.LEAF_NODES.*;
import SEMANTIC.PARSER.Exception.ParseException;
import SEMANTIC.PARSER.util.*;

public class IdentifierParser 
{
    public static Identifier parse(ParserContext ctx) throws ParseException
    //Identifier bana ke deta hai
    {
        Token token = ctx.expect(TokenType.IDENTIFIER);
        //expect function - may throw exception,
        //else advances to next token automatically!
        //c - Handle exception here; first code whole parser
        Identifier id = new Identifier();
        id.name = token.getLexeme();
        return id;
    }
}
