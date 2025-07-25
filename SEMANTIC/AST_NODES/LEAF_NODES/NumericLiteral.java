package SEMANTIC.AST_NODES.LEAF_NODES;

import STRUCTURE.DBMSDataType;
import STRUCTURE.MyInt;

public class NumericLiteral extends Literal
//Evaluates to: A MyInt (your custom DBMSDataType).
{
    public int value;

    public DBMSDataType evaluate() {
        return MyInt.convtoDB_DT(String.valueOf(value));
    }
}
