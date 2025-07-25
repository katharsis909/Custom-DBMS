package SEMANTIC.AST_NODES;

import STRUCTURE.Catalog;
import STRUCTURE.DBMSException;

public abstract class Statement
//abstract class allows common static or actually default attributes maybe
//maybe this would be needed for - position, metadata, or default print/debug methods
// interview-ask What does it even means to have a non static or static attribute in abstract class,interface
// with context to MultiThreading or SingleThreading

{
    public abstract void evaluate(Catalog catalog) throws DBMSException;
    //cannot make common now; because all return different objects
}
