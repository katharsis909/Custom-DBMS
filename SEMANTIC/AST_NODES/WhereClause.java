package SEMANTIC.AST_NODES;

import STRUCTURE.DBMSException;
import STRUCTURE.Record;

import java.util.List;

public class WhereClause
{
    public ConditionList conditions;

    public boolean evaluate(Record record) throws DBMSException
    //record sent from above;(by "FROM {table_name}" in SELECT)
    {
        return conditions.evaluate(record);
    }
}
