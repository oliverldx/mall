package test.code.generator.task.one2one;

import com.google.common.base.CaseFormat;
import freemarker.template.TemplateException;
import org.apache.commons.lang3.StringUtils;
import test.code.generator.FileTypeEnum;
import test.code.generator.task.AbstractTask;
import test.code.generator.utils.FileUtil;
import test.pdm.entity.Model;
import test.pdm.entity.Table;
import test.pdm.utils.Pdm2MdUtil;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 */
public class ControllerTask extends AbstractTask {

    public static void main(String[] args) throws IOException {
        try {
            Pdm2MdUtil pp = new Pdm2MdUtil();
            String pdfFile = "D:\\git\\mall\\document\\pdm\\training_school.pdm";
            Model model = pp.getModel(pdfFile);
            new ControllerTask().run(model);
        } catch (TemplateException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run(Model model) throws IOException, TemplateException {
        List<Table> tableList = getTables(model);
        for (Table table : tableList) {
            if(StringUtils.isAnyBlank(table.getOne2oneColId(),table.getOne2oneColName())) {
                continue;
            }
            Map<String, Object> controllerData = new HashMap<>();
            controllerData.put("tableName", CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL, table.getTableName()));
            controllerData.put("chineseName",table.getComment());
            String subName = StringUtils.substringAfter(table.getTableName(), "_");
            controllerData.put("subName", subName);
            controllerData.put("urlPathAdd", "/" + subName + "/add");
            controllerData.put("urlPathUpdate", "/" + subName + "/update");
            controllerData.put("urlPathDel", "/" + subName + "/delete");
            controllerData.put("fkId",CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, StringUtils.substringAfter(table.getOne2oneColName(),"_")));
            Map<String, Table> parentTables = table.getParentTables();
            boolean noGenDao = parentTables == null || parentTables.isEmpty();
            if(!noGenDao) {
                controllerData.put("genDao", "true");
            }else {
                controllerData.put("genDao", "");
            }
            String templateString = FileUtil.getTemplateString(FileTypeEnum.ONE2ONE_CONTROLLER.getValue(), controllerData);
            FileUtil.generateFile(FileTypeEnum.ONE2ONE_CONTROLLER.getValue(),table.getTableName(),templateString);
            if(noGenDao) {
                continue;
            }
            new test.code.generator.task.one2one.DaoTask().runTable(table);
        }
    }
}