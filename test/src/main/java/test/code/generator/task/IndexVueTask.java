package test.code.generator.task;

import cn.hutool.core.collection.CollectionUtil;
import com.google.common.base.CaseFormat;
import freemarker.template.TemplateException;
import org.apache.commons.lang3.StringUtils;
import test.code.generator.utils.FileUtil;
import test.code.generator.utils.FreemarkerConfigUtil;
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

public class IndexVueTask {

    public static void main(String[] args) throws IOException {
        Map<String, Object> controllerData = new HashMap<>();
        try {
            controllerData.put("template",true);
            controllerData.put("script",true);
            controllerData.put("style",true);
            Pdm2MdUtil pp = new Pdm2MdUtil();
            String pdfFile = "D:\\git\\mall\\document\\pdm\\training_school.pdm";
            Model model = pp.getModel(pdfFile);
            List<Table> tabs = model.getTables();
            List<String> convertTabs = CollectionUtil.newArrayList();
            List<Table> tableList = tabs.stream().filter(t -> {
                if(convertTabs.isEmpty()) {
                    return true;
                }else {
                    return convertTabs.contains(t.getTableCode());
                }
            }).collect(Collectors.toList());
            if(tableList.isEmpty()) {
                System.out.println("找不到该表数据，请确认");
                return;
            }
            Table table = tableList.get(0);
            List<Column> cols = table.getCols();
            // label 和 labelIndex 同时存在 并且根据 labelIndex 排序, 字段名从LOWER_UNDERSCORE转为LOWER_CAMEL
            cols = cols.stream().filter(col -> StringUtils.isNotBlank(col.getLabel()) && col.getLabelIndex() != null).sorted(Comparator.comparing(Column::getLabelIndex)).map(c -> {
                c.setName(CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, c.getName()));
                c.setCode(CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, c.getCode()));
                return c;
            }).collect(Collectors.toList());
            controllerData.put("columns", cols);
            String templateString = FileUtil.getTemplateString(FreemarkerConfigUtil.TYPE_INDEX_VUE, controllerData);
            System.out.println("****************************************************************** index vue template begin*************************");
            System.out.println(templateString);
            System.out.println("****************************************************************** index vue template end*************************");
        } catch (TemplateException e) {
            e.printStackTrace();
        }
    }



}
