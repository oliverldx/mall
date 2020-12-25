package test.pdm.utils;

import cn.hutool.core.collection.CollectionUtil;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import test.pdm.entity.*;

import javax.swing.text.BadLocationException;
import javax.swing.text.rtf.RTFEditorKit;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Pdm2MdUtil {

    public static final String SQL_MARKDOWN_TABLE_HEADER="|字段名|字段码|字段类型|长度|默认值|字段描述|是否主键|";
    /*
    | 左对齐 | 右对齐 | 居中对齐 |
    | :-----| ----: | :----: |
    | 单元格 | 单元格 | 单元格 |
    | 单元格 | 单元格 | 单元格 |
    */
    public static final String SQL_MARKDOWN_TABLE_HEADER_ALIGN="|----|----|----|----|----|----|----|";
    private final String tableString = "|";
    private String brString;

    public Map<String,Table> parsePDM_VO(String filePath) {
        File f = new File(filePath);
        SAXReader sr = new SAXReader();
        Document doc = null;
        try {
            doc = sr.read(f);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        Map<String,Table> voS = getTables(doc);
        return voS;
    }

    public Model getModel(String filePath) {
        Model model = new Model();
        File f = new File(filePath);
        SAXReader sr = new SAXReader();
        Document doc = null;
        try {
            doc = sr.read(f);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        Map<String, Table> voS = getTables(doc);
        Map<String,Reference> references = getReferences(doc);
        model.setTables(voS);
        model.setReferences(references);
        proccessFkRef(model);
        return model;
    }

    private void proccessFkRef(Model model) {
        Map<String,Table> tables = model.getTables();
        Map<String,Reference> references = model.getReferences();
        Set<String> referenceKeys = references.keySet();
        for(String k1 : referenceKeys) {
            Reference r = references.get(k1);
            Table parentTable = tables.get(r.getParentTableId());
            Table childTable = tables.get(r.getChildTableId());
            if(parentTable == null || childTable == null) {
                continue;
            }
            Column columnP = parentTable.getCols().get(r.getParentColId());
            Column columnC = childTable.getCols().get(r.getChildColId());
            columnC.setFkFlag(true);
            columnC.setFkColumnId(columnP.getId());
            columnC.setFkColumnName(columnP.getName());
            columnC.setFkTable(parentTable);

            childTable.addParentTables(parentTable);
        }
    }




    private Map<String,Reference> getReferences(Document doc) {
        Map<String,Reference> references = new LinkedHashMap<>();
        Reference ref = null;
        Iterator itr = doc.selectNodes("//c:References//o:Reference").iterator();
        while (itr.hasNext()) {
            ref = new Reference();
            Element e_ref = (Element) itr.next();
            ref.setId(e_ref.attributeValue("Id"));
            ref.setName(e_ref.elementTextTrim("Name"));
            ref.setCode(e_ref.elementTextTrim("Code"));
            ref.setParentTableId(e_ref.element("ParentTable").element("Table").attributeValue("Ref"));
            ref.setChildTableId(e_ref.element("ChildTable").element("Table").attributeValue("Ref"));
            ref.setPatentKey(e_ref.element("ParentKey").element("Key").attributeValue("Ref"));
            Element element = e_ref.element("Joins").element("ReferenceJoin");
            ref.setParentColId(element.element("Object1").element("Column").attributeValue("Ref"));
            ref.setChildColId(element.element("Object2").element("Column").attributeValue("Ref"));
            references.put(ref.getId(),ref);
        }
        return references;
    }

    private Map<String,Table> getTables(Document doc) {

        Map<String,Table> voS = new LinkedHashMap<>();
        Table vo = null;
        Iterator itr = doc.selectNodes("//c:Tables//o:Table").iterator();
        while (itr.hasNext()) {
            vo = new Table();
            Element e_table = (Element) itr.next();
            vo.setId(e_table.attributeValue("Id"));
            vo.setTableName(e_table.elementTextTrim("Name"));
            vo.setTableCode(e_table.elementTextTrim("Code"));
            vo.setComment(e_table.elementTextTrim("Comment"));
            Map<String, Column> columns = getColumns(vo, e_table);
            Map<String, Key> keys = getKeys(vo, e_table);
            vo.setCols(columns);
            vo.setKeys(keys);
            voS.put(vo.getId(), vo);
        }
        return voS;
    }

    private Map<String,Key> getKeys(Table vo, Element e_table) {
        Map<String,Key> keys = new LinkedHashMap<>();
        Iterator itr1 = e_table.element("Keys").elements("Key").iterator();
        while (itr1.hasNext()) {
            Key key = new Key();
            Element e_key = (Element) itr1.next();
            key.setId(e_key.attributeValue("Id"));
            key.setColId(e_key.element("Key.Columns").element("Column").attributeValue("Ref"));
            keys.put(key.getId(),key);
        }
        return keys;
    }

    private Map<String,Column> getColumns(Table vo, Element e_table) {
        Map<String,Column> list = new LinkedHashMap<>();
        Column col = null;
        Iterator itr1 = e_table.element("Columns").elements("Column").iterator();
        while (itr1.hasNext()) {
            try {

                col = new Column();
                Element e_col = (Element) itr1.next();
                String pkID = e_col.attributeValue("Id");
                col.setId(pkID);
                col.setDefaultValue(e_col.elementTextTrim("DefaultValue"));
                col.setName(e_col.elementTextTrim("Name"));
                if(e_col.elementTextTrim("DataType").indexOf("(") >0){
                    col.setType(e_col.elementTextTrim("DataType").substring(0, e_col.elementTextTrim("DataType").indexOf("(")));
                }else {
                    col.setType(e_col.elementTextTrim("DataType"));
                }
                col.setCode(e_col.elementTextTrim("Code"));
                col.setComment(e_col.elementTextTrim("Comment"));
                String physicalOptions = e_col.elementTextTrim("PhysicalOptions");
                col.setLabel(physicalOptions);
                String description = getDescription(e_col.elementTextTrim("Description"));
                col.setDescription(description);
                col.setLabelIndex(NumberUtils.createInteger(e_col.elementTextTrim("Unit")));
                col.setLength(e_col.elementTextTrim("Length") == null ? null : Integer.parseInt(e_col.elementTextTrim("Length")));
                if(e_table.element("Keys")!=null){
                    String keys_key_id = e_table.element("Keys").element("Key").attributeValue("Id");
                    String keys_column_ref = e_table.element("Keys").element("Key").element("Key.Columns")
                            .element("Column").attributeValue("Ref");
                    String keys_primarykey_ref_id = e_table.element("PrimaryKey").element("Key").attributeValue("Ref");

                    if (keys_primarykey_ref_id.equals(keys_key_id) && keys_column_ref.equals(pkID)) {
                        col.setPkFlag(true);
                        vo.setPkField(col.getCode());
                    }
                }
                list.put(col.getId(),col);
            } catch (Exception ex) {
                // col.setType(e_col.elementTextTrim("DataType"));
                System.out.println("+++++++++有错误++++" );
                ex.printStackTrace();
            }
        }
        return list;
    }

    private String getDescription(String description) throws IOException, BadLocationException {
        if(StringUtils.isBlank(description)) {
            return null;
        }
        RTFEditorKit rtfParser = new RTFEditorKit();
        javax.swing.text.Document defaultDocument = rtfParser.createDefaultDocument();
        ByteArrayInputStream in = new ByteArrayInputStream(description.getBytes());
        rtfParser.read(in, defaultDocument, 0);
        String text = defaultDocument.getText(0, defaultDocument.getLength());
        in.close();
        return text;
    }

    public static void main(String[] args) {
        Pdm2MdUtil pp = new Pdm2MdUtil();
        Map<String,Table> tabs = pp.parsePDM_VO("D:\\git\\mall\\document\\pdm\\mall.pdm");
        pp.genIndexPage(CollectionUtil.newArrayList(tabs.values()));
        pp.genTablePages(CollectionUtil.newArrayList(tabs.values()));
    }


    public String genIndexPage(List<Table> tables) {
        StringBuffer sb = new StringBuffer();
        brString = "\r\n";
        String tableList = (String) tables.stream().map(table -> "##### [" + table.getTableName()+","+table.getComment() + "](#"+table.getTableName()+")").collect(Collectors.joining(brString));
        sb.append(tableList).append("\r\n");
        tables.stream().forEach(table -> getMarkdownTableHeader(table,sb));
        try {
            FileUtils.writeStringToFile(new File("document/pdm2md/atableList.md"),sb.toString(), "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return tableList;
    }



    public void getMarkdownTableHeader(Table table, StringBuffer sb) {
//        Arrays.stream(table.).
        sb.append(brString).append("##### " + table.getTableName()).append(brString).append("##### " + table.getComment()).append(brString).append(SQL_MARKDOWN_TABLE_HEADER).append(brString).append(SQL_MARKDOWN_TABLE_HEADER_ALIGN).append(brString);
        table.getCols().values().stream().forEach(column -> {
            sb.append(tableString).append(column.getName()).append(tableString)
                    .append(Optional.ofNullable(column.getCode()).orElse("")).append(tableString)
                    .append(Optional.ofNullable(column.getType()).orElse("")).append(tableString)
                    .append(column.getLength() == null ? "":column.getLength()).append(tableString)
                    .append(Optional.ofNullable(column.getDefaultValue()).orElse("")).append(tableString)
                    .append(Optional.ofNullable(column.getComment()).orElse("")).append(tableString)
                    .append(column.isPkFlag()?"Y":"").append(tableString).append(brString);
        });
    }

    public void genTablePages(List<Table> tables) {
        tables.stream().forEach(table -> {
            StringBuffer sb = new StringBuffer();
            getMarkdownTableHeader(table,sb);
            try {
                FileUtils.writeStringToFile(new File("document/pdm2md/"+table.getTableName()+ (StringUtils.isEmpty(table.getComment())?"":("——"+table.getComment()))+".md"),sb.toString(), "UTF-8");
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}
