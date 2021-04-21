package test.code.generator.task;

import com.google.common.base.CaseFormat;
import freemarker.template.TemplateException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import test.code.generator.FileTypeEnum;
import test.code.generator.utils.FileUtil;
import test.code.generator.utils.SqlUtil;
import test.pdm.entity.Column;
import test.pdm.entity.Model;
import test.pdm.entity.Table;
import test.pdm.utils.Pdm2MdUtil;

import java.io.IOException;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DaoTask extends AbstractTask {

    public static void main(String[] args) throws IOException {
        try {
            Pdm2MdUtil pp = new Pdm2MdUtil();
            String pdfFile = "D:\\git\\mall\\document\\pdm\\training_school.pdm";
            Model model = pp.getModel(pdfFile);
            new DaoTask().run(model);
        } catch (TemplateException e) {
            e.printStackTrace();
        }
    }

    public void runTable(Table table) throws IOException, TemplateException {
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
        controllerData.put("tableName",CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL, table.getTableName()));
        controllerData.put("chineseName",table.getComment());
        String subName = StringUtils.substringAfter(table.getTableName(), "_");
        subName = CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, subName);
        controllerData.put("subName", subName);
        controllerData.put("columns", columns);
        controllerData.put("sql", SqlUtil.genSql(table));
        System.out.println(this.getClass().getCanonicalName()+" rendering the " + table.getTableName());
        String templateString = FileUtil.getTemplateString(FileTypeEnum.DAO.getValue(), controllerData);
        FileUtil.generateFile(FileTypeEnum.DAO.getValue(),table.getTableName(),templateString);

        templateString = FileUtil.getTemplateString(FileTypeEnum.DAO_XML.getValue(), controllerData);
        FileUtil.generateFile(FileTypeEnum.DAO_XML.getValue(),table.getTableName(),templateString);

        templateString = FileUtil.getTemplateString(FileTypeEnum.QUERY_PARAM.getValue(), controllerData);
        FileUtil.generateFile(FileTypeEnum.QUERY_PARAM.getValue(),table.getTableName(),templateString);

    }

    @Override
    public void run(Model model) throws IOException, TemplateException {
        List<Table> tableList = getTables(model);
        for (Table table : tableList) {
           runTable(table);
        }
    }

}
