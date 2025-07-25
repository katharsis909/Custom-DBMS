package Converter;

import SEMANTIC.AST_NODES.ColumnDefinition;
import SEMANTIC.AST_NODES.CreateTableStatement;
import STRUCTURE.Column;
import STRUCTURE.Table;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static Column toColumn(ColumnDefinition columnDefinition)
    {
        //return new Column(columnDefinition.getColumnName(),columnDefinition.getColumnType());
        String columnName = columnDefinition.getColumnName().getName();
        String columnType = columnDefinition.getDataType().getDataType();
        return  new Column(columnName, columnType);
    }

    public static List<Column> toColumnList(List<ColumnDefinition> columnDefs) {
        return columnDefs.stream()
                .map(Main::toColumn)
                .collect(Collectors.toList());
    }

    public static Table toTable(CreateTableStatement stmt) {
        Table table = new Table();
        table.setTable_name(stmt.tableName.getName());
        table.setColumnList(toColumnList(stmt.columns.columnList));
        //stmt.columns give Object which "contains" list of columns defined as - columnList
        table.setRecordList(new ArrayList<>());
        return table;
    }
}
