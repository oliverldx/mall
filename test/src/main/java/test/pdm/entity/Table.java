package test.pdm.entity;

import lombok.Data;

import java.util.LinkedHashMap;
import java.util.Map;

@Data
public class Table {
    private String id;
    private String tableName;
    private String tableCode;
    private String comment;
    private Map<String,Column> cols;
    private Map<String,Key> keys;
    private String pkField;

    private Map<String,Table> parentTables;
    private String one2oneColId;
    private String one2oneColName;
    private String one2ManyColId;
    private String one2ManyColName;



    public void addParentTables(Table table) {
        if (table == null) {
            return;
        }
        if(this.parentTables == null) {
            this.parentTables = new LinkedHashMap<>();
        }
        if(!this.parentTables.containsKey(table.getId())) {
            this.parentTables.put(table.getId(),table);
        }
    }
}
