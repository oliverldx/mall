package test.pdm.entity;

import lombok.Data;

import java.util.Map;

@Data
public class Model {
    private String id;
    private String name;
    private String code;
    private Map<String,Table> tables;
    private Map<String,Reference> references;
}
