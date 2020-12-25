package test.code.generator;

public enum ProjectFilePathEnum {

    ADMIN(0,"D:\\git\\mall\\mall-admin"),
    PORTAL(1,"D:\\git\\mall\\mall-portal"),
    MBG(2,"D:\\git\\mall\\mall-mbg"),
    SEARCH(3,"D:\\git\\mall\\mall-search"),
    SECURITY(6,"D:\\git\\mall\\mall-security"),
    ADMIN_WEB(8,"D:\\git\\mall-admin-web"),
    COMMON(7,"D:\\git\\mall\\mall-common");

    private int value;
    private String path;

    private ProjectFilePathEnum(int value, String path) {
        this.value = value;
        this.path = path;
    }

    public int getValue() {
        return value;
    }

    public String getPath() {
        return path;
    }

    public static ProjectFilePathEnum getFileTypeEnum(int type) {
        ProjectFilePathEnum[] values = ProjectFilePathEnum.values();
        for (ProjectFilePathEnum e : values) {
            if (e.getValue() == type) {
                return e;
            }
        }
        return null;
    }

    public static String getPathByType(int type) {
        ProjectFilePathEnum[] values = ProjectFilePathEnum.values();
        for (ProjectFilePathEnum e : values) {
            if (e.getValue() == type) {
                return e.getPath();
            }
        }
        return null;
    }


}
