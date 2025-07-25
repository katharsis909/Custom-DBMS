package SEMANTIC.AST_NODES;

import SEMANTIC.AST_NODES.LEAF_NODES.Identifier;
import STRUCTURE.Catalog;
import STRUCTURE.DBMSDataType;
import STRUCTURE.DBMSException;
import STRUCTURE.Table;

import java.util.List;

//grammar expression needs to be modified too
public class InsertIntoStatement extends Statement {
    public Identifier tableName;
    public ValueList valueList;

    public void evaluate(Catalog catalog) throws DBMSException {
        Table table = catalog.getTable(tableName.name);
        if (table == null) {
            throw new DBMSException("Table not found: " + tableName.name);
        }

        List<DBMSDataType> values = valueList.evaluate();
        table.addRecord(values);
    }
}
