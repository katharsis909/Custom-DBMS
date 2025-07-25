package LEXICAL;

public enum TokenType
{
    // CLAUSE
    CREATE, DROP, SELECT, WHERE, INSERT,

    //DataType
    INT, STRING,

    //Keywords
    TABLE, FROM, INTO, VALUES,

    // Symbols
    COMMA, STAR, LPAREN, RPAREN, EQUAL,SEMICOLON, AND,

    // Literals
    IDENTIFIER, STRING_LITERAL, NUMERIC_LITERAL,

    // Special
    EOF, // End of input
    INVALID // For malformed tokens
}