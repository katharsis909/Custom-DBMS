package SEMANTIC.AST_NODES;

import STRUCTURE.DBMSException;
import STRUCTURE.Record;

import java.util.List;

public class ConditionList {
    public List<UnaryCondition> conditions;

    public ConditionList(List<UnaryCondition> conditions) {
        this.conditions = conditions;
    }

    public List<UnaryCondition> getConditions() {
        return conditions;
    }

    /*
    evaluate shall need a Record/row
    evaluate should return boolean for all
     */
    public boolean evaluate(Record record) throws DBMSException
    //record sent from above;(by "FROM {table_name}" in SELECT)
    {
        for (UnaryCondition condition : conditions) {
            if (!condition.evaluate(record)) {
                return false; // short-circuit on first failure (AND logic)
            }
        }
        return true;
    }
}
