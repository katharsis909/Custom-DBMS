package SEMANTIC.AST_NODES;

import SEMANTIC.AST_NODES.LEAF_NODES.Identifier;
import STRUCTURE.Column;

public class ColumnDefinition {
    public Identifier columnName;
    public DataType dataType; // "INT" or "STRING"

    public Identifier getColumnName() {
        return columnName;
    }

    public void setColumnName(Identifier columnName) {
        this.columnName = columnName;
    }

    public DataType getDataType() {
        return dataType;
    }

    public void setDataType(DataType dataType) {
        this.dataType = dataType;
    }
    public String getColumnDataType() {
        return dataType.getDataType();
    }

    public ColumnDefinition evaluate() {
        return this;
        //doing time waste
    }
}
