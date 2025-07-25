package SEMANTIC.AST_NODES;

public class DataType
{
    public String dataType;//can only be "INT" or "STRING"

    //evaluate here?
    //return string or DBMSDataType
    //if this DataType exists, why DBMSDataType

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }
}
