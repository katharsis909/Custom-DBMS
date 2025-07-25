package SEMANTIC.AST_NODES;

import SEMANTIC.AST_NODES.LEAF_NODES.Identifier;
import SEMANTIC.AST_NODES.LEAF_NODES.Literal;
import STRUCTURE.DBMSDataType;
import STRUCTURE.DBMSException;
import STRUCTURE.Record;

public class UnaryCondition {
    public Identifier columnName;
    public Operator operator; // only "=" for now
    public Literal value;

    public boolean evaluate(Record record) throws DBMSException {
        DBMSDataType actualValue = record.getValue(columnName.getName());
        // Extract the actual value from the record using the column name
        //hover on Columnname to know the Class of it

        //Record is a hashmap, so returns you the value associated with the columnname

        // Evaluate the literal (returns MyInt or MyString)

        DBMSDataType expectedValue = value.evaluate();
        //Token gets converted to DBMSDataType,     for below evaluation!

        return operator.evaluate(actualValue, expectedValue);
        //Use the operator to evaluate the comparison
    }
}
