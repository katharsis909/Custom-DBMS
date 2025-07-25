package SEMANTIC.AST_NODES;

import STRUCTURE.DBMSDataType;
import STRUCTURE.DBMSException;
import STRUCTURE.Record;
import STRUCTURE.Table;

import java.util.ArrayList;
import java.util.List;

public class SelectedColumnList {
    public List<ColumnMention> columns;
    public boolean isSelectAll; // true if "SELECT *"

    public List<DBMSDataType> evaluate(Record record, Table table) throws DBMSException {
        List<DBMSDataType> values = new ArrayList<>();
        //to be returned

        if (isSelectAll) {
            values = table.getValueFromRecord(record);
            //chose to define this method in table than record
        } else {
            for (ColumnMention col : columns)
            //for all the columns to be selected
            {
                values.add(col.evaluate(record));
                //fetch the values of those columns from the present record
                //names of the columns are present in "AST_NODES-ColumnMention" themselves,
                //names were stored during parsing
            }
        }
        return values;
    }
}
