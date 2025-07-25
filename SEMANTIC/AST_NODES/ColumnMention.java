package SEMANTIC.AST_NODES;

import SEMANTIC.AST_NODES.LEAF_NODES.Identifier;
import STRUCTURE.DBMSDataType;
import STRUCTURE.DBMSException;
import STRUCTURE.Record;

public class ColumnMention {
    public Identifier columnName;

    //For SRP, ColumnMention can take selected column list info and then perform sending columns for specific row
    //Select can then perform selection based on WHERE and using ColumnSelectedList
    public DBMSDataType evaluate(Record record) throws DBMSException {
        return record.getValue(columnName.name);
        //time waste, as info already present above
    }
}
