package SEMANTIC.AST_NODES;

import SEMANTIC.AST_NODES.LEAF_NODES.Literal;
import STRUCTURE.DBMSDataType;
import STRUCTURE.DBMSException;

public class Value {
    public Literal literal;

    public DBMSDataType evaluate() throws DBMSException {
        return literal.evaluate();
    }
}
