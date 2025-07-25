package SEMANTIC.AST_NODES;

import STRUCTURE.DBMSDataType;

public class Operator
{
    public String symbol;

    public boolean evaluate(DBMSDataType left, DBMSDataType right) {
        // Right now, only "=" is supported
            return left.equals(right); // uses DBMSDataType.equals()
    }
}
