package test.code.generator.utils;

import com.google.common.base.CaseFormat;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import test.code.generator.FileTypeEnum;
import test.code.generator.ProjectFilePathEnum;

import java.io.*;

/**
 * @author GreedyStar
 * @since 2018/4/19
 */
public class FileUtil {

    public static final String SEPERATE_LINE = "\r\n";
    public static final String TAB = "\t";

    /**
     * @param type     使用模板类型
     * @param data     填充数据
     * @param filePath 输出文件
     * @param fileName 文件名
     * @throws IOException       文件读写异常
     * @throws TemplateException 模板异常
     */
    public static void generateToJava(int type, Object data, String filePath, String fileName) throws IOException, TemplateException {
        String path = filePath + fileName; // 待生成的代码文件路径
        // 已存在的文件不予覆盖
        File file = new File(path);
        if (file.exists() && !ConfigUtil.getConfiguration().isFileOverride()) {
            path += ".generated";
            System.err.printf("%s already exit. Generating %s \n", fileName, path);
        } else {
            System.out.printf("Generating %s \n", path);
        }
        // 代码生成路径目录不存在则自动创建
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        Template tpl = getTemplate(type); // 获取模板文件
        // 填充数据
        StringWriter writer = new StringWriter();
        tpl.process(data, writer);
        writer.flush();
        // 写入文件
        FileOutputStream fos = new FileOutputStream(path);
        OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
        BufferedWriter bw = new BufferedWriter(osw, 1024);
        tpl.process(data, bw);
        writer.close();
        bw.close();
    }

    public static String getTemplateString(int type, Object data) throws IOException, TemplateException{
        Template tpl = getTemplate(type); // 获取模板文件
        StringWriter writer = new StringWriter();
        tpl.process(data, writer);
        String s = writer.toString();
        writer.flush();
        writer.close();
        return s;
    }

    /**
     * 获取模板
     *
     * @param type 模板类型
     * @return
     * @throws IOException
     */
    private static Template getTemplate(int type) throws IOException {
        return FreemarkerConfigUtil.getInstance().getTemplate(FileTypeEnum.getNameByType(type) +".ftl");
    }

    public static String getFilePath(int type,String tableName) {
        FileTypeEnum fileTypeEnum = FileTypeEnum.getFileTypeEnum(type);
        String fileName = "";
        String tableNameConvert = CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL, tableName);
        String subName = StringUtils.substringAfter(tableName, "_");
        String subNameConvert = CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, subName);
        switch (fileTypeEnum) {
            case ENTITY:
                fileName = tableNameConvert + ".java";
                break;
            case SERVICE_IMPL:
                fileName = tableNameConvert + "ServiceImpl.java";
                break;
            case CONTROLLER:
                fileName = tableNameConvert + "Controller.java";
                break;
            case QUERY_PARAM:
                fileName = tableNameConvert + "QueryParam.java";
                break;
            case DAO:
                fileName = tableNameConvert + "Dao.java";
                break;
            case INDEX_VUE:
                fileName = "index.vue";
                break;
            case ADD_VUE:
                fileName = "add.vue";
                break;
            case UPDATE_VUE:
                fileName = "update.vue";
                break;
            case DAO_XML:
                fileName = tableNameConvert + ".xml";
                break;
            case API_JS:
                fileName = subNameConvert + ".js";
                break;
            case COMPONENT_DETAIL_VUE:
                fileName = subNameConvert + "Detail.vue";
                break;
            case ONE2ONE_CONTROLLER:
                fileName = "one2one/" + tableNameConvert + "Controller.java";
                break;
            case ONE2ONE_DAO:
                fileName = "one2one/" + tableNameConvert + "Dao.java";
                break;
            case ONE2ONE_DAO_XML:
                fileName = "one2one/" + tableNameConvert + ".xml";
                break;
            case ONE2ONE_COMPONENT_DETAIL_VUE:
                fileName = "one2one/" + subNameConvert + ".vue";
                break;
            case ONE2ONE_API_JS:
                fileName = "one2one/" + subNameConvert + ".js";
                break;
            case ONE2MANY_CONTROLLER:
                fileName = "one2many/" + tableNameConvert + "Controller.java";
                break;
            case ONE2MANY_DAO:
                fileName = "one2many/" + tableNameConvert + "Dao.java";
                break;
            case ONE2MANY_DAO_XML:
                fileName = "one2many/" + tableNameConvert + ".xml";
                break;
            case ONE2MANY_INDEX_VUE:
                fileName = "one2many/" + subNameConvert + ".vue";
                break;
            case ONE2MANY_API_JS:
                fileName = "one2many/" + subNameConvert + ".js";
                break;
            case ONE2MANY_QUERY_PARAM:
                fileName = "one2many/" + tableNameConvert + "QueryParam.java";
                break;
            default :
                fileName = "null.java";
                break;
        }

        String filePath = ConfigUtil.getConfiguration().getPath().getGenerated() + File.separator + tableName + File.separator + fileName;
        return filePath;
    }

    /**
     * 获取项目主目录
     *
     * @return 项目根路径
     */
    private static String getBasicProjectPath() {
        StringBuilder sb = new StringBuilder();
        String path = FileUtil.class.getResource("/").getPath().replace("/", File.separator);
        if (path.contains("target")) {
            sb.append(path, 0, path.indexOf("target"));
        } else if (path.contains("build")) {
            sb.append(path, 0, path.indexOf("build"));
        }
        sb.append("src").append(File.separator).append("main").append(File.separator);
        return sb.toString();
    }

    public static String getMoveFilePath(int projectType, int fileType) {
        String projectBasePath = ProjectFilePathEnum.getPathByType(projectType);
        FileTypeEnum fileTypeEnum = FileTypeEnum.getFileTypeEnum(fileType);
        String fileTypePath = "";
        switch (fileTypeEnum) {
            case CONTROLLER:
                fileTypePath = "src/main/java/com/macro/mall/controller";
                break;
            case QUERY_PARAM:
                fileTypePath = "src/main/java/com/macro/mall/dto";
                break;
            case DAO:
                fileTypePath = "src/main/java/com/macro/mall/dao";
                break;
            case INDEX_VUE:
            case ADD_VUE:
            case UPDATE_VUE:
                fileTypePath = "src/views";
                break;
            case DAO_XML:
                fileTypePath = "src/main/resources/dao";
                break;
            case API_JS:
                fileTypePath = "src/api";
                break;
            case COMPONENT_DETAIL_VUE:
                fileTypePath = "src/views";
                break;
            case ONE2ONE_CONTROLLER:
                fileTypePath = "src/main/java/com/macro/mall/controller";
                break;
            case ONE2ONE_DAO:
                fileTypePath = "src/main/java/com/macro/mall/dao";
                break;
            case ONE2ONE_DAO_XML:
                fileTypePath = "src/main/resources/dao";
                break;
            case ONE2ONE_COMPONENT_DETAIL_VUE:
                fileTypePath = "src/views";
                break;
            case ONE2ONE_API_JS:
                fileTypePath = "src/api";
                break;
            case ONE2MANY_CONTROLLER:
                fileTypePath = "src/main/java/com/macro/mall/controller";
                break;
            case ONE2MANY_DAO:
                fileTypePath = "src/main/java/com/macro/mall/dao";
                break;
            case ONE2MANY_DAO_XML:
                fileTypePath = "src/main/resources/dao";
                break;
            case ONE2MANY_INDEX_VUE:
                fileTypePath = "src/views";
                break;
            case ONE2MANY_API_JS:
                fileTypePath = "src/api";
                break;
            default :
                fileTypePath = "";
                break;
        }
        String filePath = projectBasePath + File.separator + fileTypePath;
        return filePath;
    }

    /**
     * 获取源码路径
     *
     * @return 源码路径
     */
    public static String getSourcePath(String projectName) {
        StringBuilder sb = new StringBuilder();
        sb.append(getBasicProjectPath()).append("java").append(File.separator);
        return sb.toString();
    }

    /**
     * 获取资源文件路径
     *
     * @return 资源路径
     */
    public static String getResourcePath(String projectName) {
        StringBuilder sb = new StringBuilder();
        sb.append(getBasicProjectPath()).append("resources").append(File.separator);
        return sb.toString();
    }

    public static String generateFile(int type,String tableName, String templateString) {
        try {
            String filePath = getFilePath(type, tableName);
            FileUtils.writeStringToFile(new File(filePath),templateString);
            return filePath;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(getResourcePath(""));
        System.out.println(getSourcePath(""));
    }

}
