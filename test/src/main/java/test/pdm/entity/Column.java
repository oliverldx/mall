package test.pdm.entity;

import lombok.Data;

@Data
public class Column {

    private String id;
    private String defaultValue;
    private String name;
    private String type;
    private String code;
    private String comment;
    private String label;
    private Integer labelIndex;
    private Integer length;
    private Boolean pkFlag;
    private Boolean fkFlag;
    private String fkColumnName;
    private Table fkTable;


}
