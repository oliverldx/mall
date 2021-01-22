package test.code.generator.task.one2many;

import com.google.common.base.CaseFormat;
import freemarker.template.TemplateException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import test.code.generator.FileTypeEnum;
import test.code.generator.task.AbstractTask;
import test.code.generator.utils.FileUtil;
import test.pdm.entity.Column;
import test.pdm.entity.Model;
import test.pdm.entity.Table;
import test.pdm.utils.Pdm2MdUtil;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;


public class IndexVueTask extends AbstractTask {

    public static void main(String[] args) throws IOException {
        try {
            Pdm2MdUtil pp = new Pdm2MdUtil();
            String pdfFile = "D:\\git\\mall\\document\\pdm\\training_school.pdm";
            Model model = pp.getModel(pdfFile);
            new IndexVueTask().run(model);
        } catch (TemplateException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run(Model model) throws IOException, TemplateException {
        List<Table> tableList = getTables(model);
        for (Table table : tableList) {
            if(StringUtils.isAnyBlank(table.getOne2ManyColId(),table.getOne2ManyColName())) {
                continue;
            }
            Map<String, Column> cols = table.getCols();
            // label 和 labelIndex 同时存在 并且根据 labelIndex 排序, 字段名从LOWER_UNDERSCORE转为LOWER_CAMEL
            List<Column> columns = cols.values().stream().filter(col -> StringUtils.isNotBlank(col.getLabel()) && col.getLabelIndex() != null).sorted(Comparator.comparing(Column::getLabelIndex)).map(c -> {
                Column column = new Column();
                BeanUtils.copyProperties(c,column);
                column.setName(CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, c.getName()));
                column.setCode(CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, c.getCode()));
                return column;
            }).collect(Collectors.toList());

            Map<String, Object> controllerData = new HashMap<>();
            controllerData.put("template",true);
            controllerData.put("script",true);
            controllerData.put("style",true);
            controllerData.put("columns", columns);
            String subName = StringUtils.substringAfter(table.getTableName(), "_");
            subName = CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, subName);
            String modelName = StringUtils.substringBefore(table.getTableName(), "_");
            controllerData.put("subName", subName);
            controllerData.put("urlPathAdd", "/" + subName + "/add");
            controllerData.put("urlPathUpdate", "/" + subName + "/update");
            controllerData.put("urlPathDel", "/" + subName + "/delete");
            controllerData.put("urlPathList", "/" + subName + "/list");
            controllerData.put("urlPathAddVue", "/" + modelName + "/add" + StringUtils.capitalize(subName));
            controllerData.put("urlPathUpdateVue", "/" + modelName + "/update" + StringUtils.capitalize(subName));
            controllerData.put("fkId",CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, StringUtils.substringAfter(table.getOne2ManyColName(),"_")));
            Optional<Table> first = table.getParentTables().values().stream().findFirst();
            Table parentTable = first.get();
            String parentTableSubName = StringUtils.substringAfter(parentTable.getTableName(), "_");
            parentTableSubName = CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL,parentTableSubName);
            controllerData.put("one2manyColName",CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, table.getOne2ManyColName()));
            controllerData.put("parentTableSubName",parentTableSubName);
            System.out.println("rendering the " + table.getTableName());
            String templateString = FileUtil.getTemplateString(FileTypeEnum.ONE2MANY_INDEX_VUE.getValue(), controllerData);
            FileUtil.generateFile(FileTypeEnum.ONE2MANY_INDEX_VUE.getValue(),table.getTableName(),templateString);
            new ApiJsTask().run(model);
        }
    }


}
