package test.code.generator;

public enum FileTypeEnum {

    ENTITY(0,"entity"),
    DAO(1,"dao"),
    SERVICE_IMPL(2,"service"),
    CONTROLLER(3,"controller"),
    INDEX_VUE(6,"index_vue"),
    ADD_VUE(10,"add_vue"),
    UPDATE_VUE(11,"update_vue"),
    DAO_XML(7,"dao_xml"),
    QUERY_PARAM(8,"query_param"),
    API_JS(9,"api_js"),
    COMPONENT_DETAIL_VUE(12,"component_detail");

    private int value;
    private String name;

    private FileTypeEnum(int value, String name) {
        this.value = value;
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public String getName() {
        return name;
    }

    public static FileTypeEnum getFileTypeEnum(int type) {
        FileTypeEnum[] values = FileTypeEnum.values();
        for (FileTypeEnum e : values) {
            if (e.getValue() == type) {
                return e;
            }
        }
        return null;
    }

    public static String getNameByType(int type) {
        FileTypeEnum[] values = FileTypeEnum.values();
        for (FileTypeEnum e : values) {
            if (e.getValue() == type) {
                return e.getName();
            }
        }
        return null;
    }


}
