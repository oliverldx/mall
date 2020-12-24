package test.pdm.entity;

import lombok.Data;

import java.util.List;

@Data
public class Table {
    private String tableName;
    private String tableCode;
    private String comment;
    private List<Column> cols;
    private List<Key> keys;
    private String pkField;
}
