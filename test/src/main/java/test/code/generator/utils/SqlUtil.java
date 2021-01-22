package test.code.generator.utils;

import cn.hutool.json.JSON;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import com.google.common.base.CaseFormat;
import org.apache.commons.lang3.StringUtils;
import test.pdm.entity.Column;
import test.pdm.entity.Table;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;
import java.util.stream.Collectors;

public class SqlUtil {

    public static String genSql(Table table) {
        Map<String, Column> cols = table.getCols();
        List<Column> collect = cols.values().stream()
                .filter(col -> StringUtils.isNotBlank(col.getLabel()) && col.getLabelIndex() != null)
                .sorted(Comparator.comparing(Column::getLabelIndex))
                .collect(Collectors.toList());

        return genSql(table, collect);
    }

    private static String genSql(Table table, List<Column> collect) {
        StringBuilder sb = new StringBuilder();
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
                JSONObject jsonObject = new JSONObject(col.getDescription()).getJSONObject(col.getName());
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

        StringJoiner whereJoiner = new StringJoiner(" and ");
        for (Column col : collect) {
            if(StringUtils.isBlank(col.getDescription())) {
                continue;
            }
            JSONObject jsonObject = new JSONObject(col.getDescription()).getJSONObject(col.getName());
            String type = jsonObject.getStr("type");
            if ("sql_where".equals(type)) {
                String colName = CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, col.getName());
                whereJoiner.add(table.getTableName() + "." + col.getName() + "=#{queryParam."+colName+"}");
            }
        }

        if(whereJoiner.length() > 0 ) {
            sb.append("\n\twhere \n");
            sb.append("\t\t"+whereJoiner.toString());
        }


        return sb.toString();
    }

    public static String genOne2OneSql(Table table) {
        StringBuilder sb = new StringBuilder();
        String sql = "SELECT *\n" +
                "\t FROM "+table.getTableName()+" as "+table.getTableName()+" where "+table.getTableName()+"."+table.getOne2oneColName()+" = #{"+ CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, StringUtils.substringAfter(table.getOne2oneColName(),"_"))+"}";

        return sql;
    }


    public static String genOne2ManySql(Table table) {
        Map<String, Column> cols = table.getCols();
        List<Column> collect = cols.values().stream()
                .filter(col -> StringUtils.isNotBlank(col.getLabel()))
                .collect(Collectors.toList());

        return genSql(table, collect);
    }
}
