package test.code.generator.task;

import cn.hutool.core.collection.CollectionUtil;
import freemarker.template.TemplateException;
import test.pdm.entity.Model;
import test.pdm.entity.Table;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public abstract class AbstractTask {

    public List<Table> getTables(Model model) {
        Map<String, Table> tabs = model.getTables();
        List<String> convertTabs = CollectionUtil.newArrayList();
        List<Table> tableList = tabs.values().stream().filter(t -> {
            if(convertTabs.isEmpty()) {
                return true;
            }else {
                return convertTabs.contains(t.getTableCode());
            }
        }).collect(Collectors.toList());
        if(tableList.isEmpty()) {
            System.out.println("找不到该表数据，请确认");
            return null;
        }
        return tableList;

    }

    public  abstract void run(Model model) throws IOException, TemplateException;
}
