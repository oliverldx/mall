package test.code.generator.utils;

import cn.hutool.json.JSON;
import cn.hutool.json.JSONArray;
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
        tableSb.append(table.getTableName()).append(" as ").append(table.getTableName());

        for(String k : parentTables.keySet()) {
            Table parentTable = parentTables.get(k);
            String fkName = table.getCols().values().stream().filter(Column::isFkFlag).findFirst().get().getName();
            tableSb.append(" LEFT JOIN ")
                    .append(parentTable.getTableName()).append(" as ").append(parentTable.getTableName())
                    .append(" ON ").append(table.getTableName()).append(".").append(fkName)
                    .append(" = ").append(parentTable.getTableName()).append(".").append(fkName);
        }

        sb.append("SELECT ");
        StringJoiner selectJoiner = new StringJoiner(",");
        for (Column col : collect) {
            if(StringUtils.isBlank(col.getDescription())) {
                selectJoiner.add(col.getName());
            }else {
                JSONArray jsonArray = new JSONArray(col.getDescription());
                for (int i = 0; i < jsonArray.size(); i++) {
                    JSON json = (JSON)jsonArray.get(i);
                    String dataName = json.getByPath("dataName", String.class);
                    String alias = json.getByPath("alias", String.class);
                    if (StringUtils.isNotBlank(dataName) && StringUtils.isNotBlank(alias)) {
                        selectJoiner.add(dataName + " " + alias);
                    }
                }
            }
        }
        sb.append(selectJoiner.toString()).append("\\n");
        sb.append(" FROM ");
        sb.append(tableSb.toString());

        return sb.toString();
    }
}
