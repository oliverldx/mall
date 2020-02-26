import lombok.Data;

@Data
public class Column {

    private String defaultValue;
    private String name;
    private String type;
    private String code;
    private String comment;
    private Integer length;
    private Boolean pkFlag;


}
