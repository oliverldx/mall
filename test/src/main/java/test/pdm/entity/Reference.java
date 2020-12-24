package test.pdm.entity;

import lombok.Data;

/**
 *
 */
@Data
public class Reference {
    private String id;
    private String name;
    private String code;
    private String parentTableId;
    private String childTableId;
    private String patentKey;

}
