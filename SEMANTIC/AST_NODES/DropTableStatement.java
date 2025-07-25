package SEMANTIC.AST_NODES;

import SEMANTIC.AST_NODES.LEAF_NODES.Identifier;
import STRUCTURE.Catalog;
import STRUCTURE.DBMSException;

public class DropTableStatement extends Statement
{
    public Identifier tableName;

    public void evaluate(Catalog catalog) throws DBMSException {
        String name = tableName.name.toUpperCase();
        //no ambiguities!
        catalog.dropTable(name);
        //System.out.println("Table '" + name + "' dropped successfully.");
        //Log it!
    }
}

