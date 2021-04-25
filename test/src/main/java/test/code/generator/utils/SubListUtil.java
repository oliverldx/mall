package test.code.generator.utils;

import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import com.google.common.base.CaseFormat;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import test.pdm.entity.Column;
import test.pdm.entity.Table;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class SubListUtil {

    public static Optional<Column> getSubListColumn(Table table) {
        Map<String, Column> cols = table.getCols();
        return cols.values().stream()
                .filter(col -> {
                    if (StringUtils.isBlank(col.getDescription())) {
                        return false;
                    }
                    String colName = CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, col.getName());
                    JSONObject jsonObject = new JSONObject(col.getDescription()).getJSONObject(colName);
                    if (jsonObject.containsKey("subList")) {
                        return true;
                    }
                    return false;
                }).findFirst();
    }

    public static void putFtlDataForSubList(Map<String, Object> ftlData,Table table) {
        Optional<Column> subListColumn = SubListUtil.getSubListColumn(table);
        boolean present = subListColumn.isPresent();
        ftlData.put("showSubList", present);
        if (present) {
            Column col = subListColumn.get();
            Table fkTable = col.getFkTable();
            String tableName = fkTable.getTableName();
            String subName = StringUtils.substringAfter(tableName, "_");
            subName = CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL, subName);
            ftlData.put("subListName", subName);
            String colName = CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, col.getName());
            JSONArray subListJsonArray = new JSONObject(col.getDescription()).getJSONObject(colName).getJSONArray("subList");
            List<Map> subListCols = subListJsonArray.stream().sorted(Comparator.comparing(obj -> ((JSONObject) obj).getInt("colIndex"))).map(obj -> (Map) obj).collect(Collectors.toList());
            String s = SqlUtil.genOne2ManySubListSQl(subListCols, table);
            ftlData.put("subListSql", s);

            List<Column> subListColumns = subListCols.stream().map(m -> {
                List<Column> columnList = fkTable.getCols().values().stream().filter(column -> column.getName().equalsIgnoreCase((String) m.get("colName"))).collect(Collectors.toList());
                Column column = new Column();
                Column source = columnList.get(0);
                BeanUtils.copyProperties(source,column);
                column.setName(CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, source.getName()));
                return column;
            }).collect(Collectors.toList());
            ftlData.put("subListColumns", subListColumns);

            Map<String, Column> cols = table.getCols();
            List<Column> columns = cols.values().stream()
                    .filter(Column::isFkFlag).map(c -> {
                        Column column = new Column();
                        BeanUtils.copyProperties(c,column);
                        column.setName(CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, c.getName()));
                        if(StringUtils.isNotBlank(c.getLabel()) && c.getLabelIndex() == null) {
                            column.setCode((String)ftlData.get("fkId"));
                        }else {
                            column.setCode(CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, c.getCode()));
                        }
                        return column;
                    }).collect(Collectors.toList());
            ftlData.put("subColumns", columns);

        }
    }

}
