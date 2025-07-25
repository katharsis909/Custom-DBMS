package SEMANTIC.AST_NODES;

import SEMANTIC.AST_NODES.LEAF_NODES.Identifier;
import STRUCTURE.Catalog;
import STRUCTURE.DBMSDataType;
import STRUCTURE.DBMSException;
import STRUCTURE.Table;
import STRUCTURE.Record;

import java.util.ArrayList;
import java.util.List;

public class SelectStatement extends Statement {
    public SelectedColumnList selectedColumnList;
    public Identifier tableName;
    public WhereClause whereClause; // can be null

    public void evaluate(Catalog db) throws DBMSException {
        Table table = db.getTable(tableName.name);
        //FROM is executed before
        List<Record> allRecords = table.getRecordList();
        //l - use paging!

        List<Record> filtered = new ArrayList<>();
        //validated records to be returned
        for (Record r : allRecords)
        {
            if (whereClause == null || whereClause.evaluate(r))
            //First use Where; above also checked for "Where not present"
            {
                filtered.add(r);
            }
        }

        List<List<DBMSDataType>> result = new ArrayList<>();
//      Better make List<DBMSDataType> another object
        for (Record r : filtered) {
            //Second, from the validated records, now select specific columns
            //No need to pass information of which columns to select, all info in the below nodes
            //Crazy design pattern!
            result.add(selectedColumnList.evaluate(r,table));
        }

        System.out.println();

        printResult(result, selectedColumnList);
        //error - What happens if * used?

        //return result;
    }

    private void printResult(List<List<DBMSDataType>> rows, SelectedColumnList selectedColumnList) {
        System.out.print("Columns: ");
        for (int i = 0; i < selectedColumnList.columns.size(); i++) {
            System.out.print(selectedColumnList.columns.get(i).columnName.name);
            if (i < selectedColumnList.columns.size() - 1) System.out.print(", ");
        }
        System.out.println();

        for (List<DBMSDataType> row : rows) {
            System.out.print("Record: ");
            for (int i = 0; i < row.size(); i++) {
                System.out.print(row.get(i));
                if (i < row.size() - 1) System.out.print(", ");
            }
            System.out.println();
        }
    }

}
