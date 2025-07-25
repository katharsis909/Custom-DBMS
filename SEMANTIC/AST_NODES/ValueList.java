package SEMANTIC.AST_NODES;

import STRUCTURE.DBMSDataType;
import STRUCTURE.DBMSException;

import java.util.List;

public class ValueList {
    public List<Value> values;

    public List<DBMSDataType> evaluate() throws DBMSException {
        List<DBMSDataType> result = new java.util.ArrayList<>();
        for (Value v : values) {
            result.add(v.evaluate());
        }
        return result;
    }

}
