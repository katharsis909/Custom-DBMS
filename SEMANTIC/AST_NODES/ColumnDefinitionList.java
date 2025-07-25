package SEMANTIC.AST_NODES;

import java.util.List;

public class ColumnDefinitionList {
    public List<ColumnDefinition> columnList;

    public ColumnDefinitionList(List<ColumnDefinition> columnList) {
        this.columnList = columnList;
    }

    public ColumnDefinitionList evaluate() {
        for (int i = 0; i < columnList.size(); i++) {
            columnList.get(i).evaluate();
            //doing pure time waste
        }
        return this;
        //return itself haha!
    }
}
