import lombok.Data;

import java.util.List;

@Data
public class Table {
    private String tableName;
    private String tableCode;
    private String comment;
    private List<Column> cols;
    private String pkField;
}
