package test.code.generator.utils;

import cn.hutool.json.JSON;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import com.google.common.base.CaseFormat;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import test.pdm.entity.Column;
import test.pdm.entity.Table;

import java.util.*;
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
            String fkName = table.getCols().values().stream().filter(Column::isFkFlag).filter(column -> column.getFkTable().getId().equals(k)).findFirst().get().getName();
            String pkName = parentTable.getCols().values().stream().filter(Column::isPkFlag).findFirst().get().getName();
            tableSb.append(FileUtil.TAB).append(" LEFT JOIN ")
                    .append(parentTable.getTableName()).append(" as ").append(parentTable.getTableName())
                    .append(" ON ").append(table.getTableName()).append(".").append(fkName)
                    .append(" = ").append(parentTable.getTableName()).append(".").append(pkName).append(FileUtil.SEPERATE_LINE);
        }

        sb.append("SELECT ");
        StringJoiner selectJoiner = new StringJoiner(",");
        for (Column col : collect) {
            if(StringUtils.isBlank(col.getDescription())) {
                selectJoiner.add(table.getTableName() + "." + col.getName());
            }else {
                String colName = CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, col.getName());
                JSONObject jsonObject = new JSONObject(col.getDescription()).getJSONObject(colName);
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
                }else {
                    selectJoiner.add(table.getTableName() + "." + col.getName());
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
            String colName = CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, col.getName());
            JSONObject jsonObject = new JSONObject(col.getDescription()).getJSONObject(colName);
            String type = jsonObject.getStr("type");
            if ("sql_where".equals(type)) {
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

    public static String genOne2ManySubListSQl(List<Map> subListCols,Table table) {
        Optional<Column> colSubList = SubListUtil.getSubListColumn(table);
        Column column = colSubList.get();

        StringBuilder tableSb = new StringBuilder();
        Table fkTable = column.getFkTable();
        Optional<Column> pkColumn = fkTable.getCols().values().stream().filter(col -> col.isPkFlag()).findFirst();
        Column pkCol = pkColumn.get();

        StringJoiner where = new StringJoiner(FileUtil.SEPERATE_LINE);
        where.add(table.getTableName()+"."+pkCol.getName() + " IS NULL");

        StringJoiner select = new StringJoiner(",");
        for(Map m : subListCols) {
            StringBuilder whereConditionStringBuilder = new StringBuilder();
            String colName = (String) m.get("colName");
            select.add(fkTable.getTableName()+"."+colName);
            String to = "queryParam."+CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, colName);
            whereConditionStringBuilder.append(FileUtil.TAB).append("<if test=\""+to+"!=null\">").append(FileUtil.SEPERATE_LINE)
                    .append(FileUtil.TAB).append(" and ").append(fkTable.getTableName()).append(".").append(colName)
                    .append(" = #{").append(to).append("}").append(FileUtil.SEPERATE_LINE).append(FileUtil.TAB).append("</if>");
            where.add(whereConditionStringBuilder.toString());
        }

        String fkName = table.getCols().values().stream().filter(Column::isFkFlag).filter(col -> col.getFkTable().getId().equals(fkTable.getId())).findFirst().get().getName();
        tableSb.append(fkTable.getTableName()).append(" as ").append(fkTable.getTableName()).append(FileUtil.SEPERATE_LINE);
        tableSb.append(FileUtil.TAB).append(" LEFT JOIN ")
                .append(table.getTableName()).append(" as ").append(table.getTableName())
                .append(" ON ").append(fkTable.getTableName()).append(".").append(pkCol.getName())
                .append(" = ").append(table.getTableName()).append(".").append(fkName).append(FileUtil.SEPERATE_LINE);

        StringBuilder sb = new StringBuilder();
        sb.append("SELECT ")
                .append(select.toString()).append(FileUtil.SEPERATE_LINE)
                .append(FileUtil.TAB).append(" FROM ").append(FileUtil.SEPERATE_LINE)
                .append(FileUtil.TAB).append(tableSb.toString()).append(FileUtil.SEPERATE_LINE)
                .append(FileUtil.TAB).append(" WHERE ").append(FileUtil.SEPERATE_LINE)
                .append(FileUtil.TAB).append(where.toString());
        return sb.toString();
    }

    public static List<Column> getAliasColumns(Table table) {
        Map<String, Column> cols = table.getCols();
        List<Column> tableAliasColumns = new ArrayList<>();
        cols.values().stream()
                .filter(col -> {
                    if (StringUtils.isNotBlank(col.getDescription())) {
                        return true;
                    }
                    return false;
                }).forEach(col -> {
                    String colName = CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, col.getName());
                    JSONObject jsonObject = new JSONObject(col.getDescription()).getJSONObject(colName);
                    String type = jsonObject.getStr("type");
                    if("sql".equals(type)) {
                        JSONArray vals = jsonObject.getJSONArray("vals");
                        List<Column> columns = vals.stream().map(json -> {
                            String dataName = ((JSONObject) json).getStr("dataName");
                            String alias = ((JSONObject) json).getStr("alias");
                            String label = ((JSONObject) json).getStr("label");
                            Integer labelIndex = ((JSONObject) json).getInt("labelIndex");
                            Optional<Column> first = col.getFkTable().getCols().values().stream().filter(c -> c.getName().equals(dataName)).findFirst();
                            Column column = new Column();
                            BeanUtils.copyProperties(first.get(), column);
                            column.setName(CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, alias));
                            column.setCode(alias);
                            if(StringUtils.isNotBlank(label)) {
                                column.setLabel(label);
                            }
                            if(labelIndex != null) {
                                column.setLabelIndex(labelIndex);
                            }
                            return column;
                        }).collect(Collectors.toList());
                        tableAliasColumns.addAll(columns);
                    }
                });
        return tableAliasColumns;
    }


}
