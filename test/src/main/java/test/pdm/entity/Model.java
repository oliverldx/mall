package test.pdm.entity;

import lombok.Data;

import java.util.List;

@Data
public class Model {
    private String id;
    private String name;
    private String code;
    private List<Table> tables;
    private List<Reference> references;
}
