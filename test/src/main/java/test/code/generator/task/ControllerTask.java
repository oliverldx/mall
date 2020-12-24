package test.code.generator.task;

import freemarker.template.TemplateException;
import test.pdm.entity.Column;
import test.code.generator.Constant;
import test.code.generator.utils.ConfigUtil;
import test.code.generator.utils.FileUtil;
import test.code.generator.utils.FreemarkerConfigUtil;
import test.code.generator.utils.StringUtil;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author GreedyStar
 * @since 2018/4/20
 */
public class ControllerTask {

    public static void main(String[] args) throws IOException {
        Map<String, Object> controllerData = new HashMap<>();
        try {
            controllerData.put("tableName","TrsCourse");
            controllerData.put("chineseName","课程");
            controllerData.put("subName","course");
            String templateString = FileUtil.getTemplateString(FreemarkerConfigUtil.TYPE_CONTROLLER, controllerData);
            System.out.println("****************************************************************** controller template begin*************************");
            System.out.println(templateString);
            System.out.println("****************************************************************** controller template end*************************");
        } catch (TemplateException e) {
            e.printStackTrace();
        }
    }


    public void run() throws IOException, TemplateException {
        // 构造Controller填充数据
        Map<String, Object> controllerData = new HashMap<>();
        controllerData.put("Configuration", ConfigUtil.getConfiguration());
        String filePath = FileUtil.getSourcePath() + StringUtil.package2Path(ConfigUtil.getConfiguration().getPackageName()) +
                StringUtil.package2Path(ConfigUtil.getConfiguration().getPath().getController());
        String fileName = ConfigUtil.getConfiguration().getName().getController().replace(Constant.PLACEHOLDER, "TODO") + ".java";
        // 生成Controller文件
        FileUtil.generateToJava(FreemarkerConfigUtil.TYPE_CONTROLLER, controllerData, filePath, fileName);
    }

    /**
     * 获取主键列对应的属性类型
     *
     * @param columnInfos
     * @return
     */
    private String getPrimaryKeyType(List<Column> columnInfos) {
        if (!ConfigUtil.getConfiguration().isJpaEnable()) {
            return "Serializable";
        }
        for (Column info : columnInfos) {
            if (info.getPkFlag()) {
                return info.getType();
            }
        }
        return "Serializable";
    }

}
