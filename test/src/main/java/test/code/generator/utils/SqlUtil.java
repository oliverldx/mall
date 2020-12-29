package test.code.generator.utils;

import cn.hutool.json.JSON;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import org.apache.commons.lang3.StringUtils;
import test.pdm.entity.Column;
import test.pdm.entity.Table;

import java.util.*;
import java.util.stream.Collectors;

public class SqlUtil {

    public static String genSql(Table table) {
        StringBuilder sb = new StringBuilder();
        Map<String, Column> cols = table.getCols();
        List<Column> collect = cols.values().stream()
                .filter(col -> StringUtils.isNotBlank(col.getLabel()) && col.getLabelIndex() != null)
                .sorted(Comparator.comparing(Column::getLabelIndex))
                .collect(Collectors.toList());

        StringBuilder tableSb = new StringBuilder();
        Map<String, Table> parentTables = table.getParentTables();
        if(parentTables == null) {
            return null;
        }
        tableSb.append(table.getTableName()).append(" as ").append(table.getTableName()).append(FileUtil.SEPERATE_LINE);

        for(String k : parentTables.keySet()) {
            Table parentTable = parentTables.get(k);
            String fkName = table.getCols().values().stream().filter(Column::isFkFlag).findFirst().get().getFkColumnName();
            tableSb.append(FileUtil.TAB).append(" LEFT JOIN ")
                    .append(parentTable.getTableName()).append(" as ").append(parentTable.getTableName())
                    .append(" ON ").append(table.getTableName()).append(".").append(fkName)
                    .append(" = ").append(parentTable.getTableName()).append(".").append(fkName).append(FileUtil.SEPERATE_LINE);
        }

        sb.append("SELECT ");
        StringJoiner selectJoiner = new StringJoiner(",");
        for (Column col : collect) {
            if(StringUtils.isBlank(col.getDescription())) {
                selectJoiner.add(table.getTableName() + "." + col.getName());
            }else {
                JSONObject jsonObject = new JSONObject(col.getDescription());
                String type = jsonObject.getStr("type");
                if("sql".equals(type)) {
                    JSONArray jsonArray = jsonObject.getJSONArray("vals");
                    for (int i = 0; i < jsonArray.size(); i++) {
                        JSON json = (JSON)jsonArray.get(i);
                        String dataName = json.getByPath("dataName", String.class);
                        String alias = json.getByPath("alias", String.class);
                        if (StringUtils.isNotBlank(dataName) && StringUtils.isNotBlank(alias)) {
                            selectJoiner.add(col.getFkTable().getTableName() + "." + dataName + " " + alias);
                        }
                    }
                }

            }
        }
        sb.append(selectJoiner.toString()).append(FileUtil.SEPERATE_LINE);
        sb.append(FileUtil.TAB).append(" FROM ");
        sb.append(tableSb.toString());

        return sb.toString();
    }
}
