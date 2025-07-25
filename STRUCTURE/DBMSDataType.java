package STRUCTURE;

public interface DBMSDataType
{
    /*static DBMSDataType convtoDB_DT(String str)
    //d - static cannot be overriden so no idea
    // returns the internal Java representation
    {


    }*/
    String toString();
    // for printing values

    public boolean equals(DBMSDataType other);

    public boolean typeEquals(DBMSDataType other);

    public boolean typeEquals(String columnType);

    public String getType();

    /*
    int dataTypeCode();
    // Returns a unique code for each data type
    boolean valueEquals(DBMSDataType other);
    // Compares values appropriately
    boolean fullyEquals(DBMSDataType other);
    // Compares both type and value
    */


    //l optionally other methods like compareTo for WHERE clause filtering
}
