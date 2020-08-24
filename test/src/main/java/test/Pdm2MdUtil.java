package test;

import org.apache.commons.io.FileUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.util.StringUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
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

    public List parsePDM_VO(String filePath) {
        List<Table> voS = new ArrayList<Table>();
        Table vo = null;
        Column[] cols = null;
        File f = new File(filePath);
        SAXReader sr = new SAXReader();
        Document doc = null;
        try {
            doc = sr.read(f);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        Iterator itr = doc.selectNodes("//c:Tables//o:Table").iterator();
        while (itr.hasNext()) {
            vo = new Table();
            cols = new Column[] {};
            List<Column> list = new ArrayList<Column>();
            Column col = null;
            Element e_table = (Element) itr.next();
            vo.setTableName(e_table.elementTextTrim("Name"));
            vo.setTableCode(e_table.elementTextTrim("Code"));
            vo.setComment(e_table.elementTextTrim("Comment"));
            Iterator itr1 = e_table.element("Columns").elements("Column").iterator();
            while (itr1.hasNext()) {
                try {

                    col = new Column();
                    Element e_col = (Element) itr1.next();
                    String pkID = e_col.attributeValue("Id");
                    col.setDefaultValue(e_col.elementTextTrim("DefaultValue"));
                    col.setName(e_col.elementTextTrim("Name"));
                    if(e_col.elementTextTrim("DataType").indexOf("(") >0){
                        col.setType(e_col.elementTextTrim("DataType").substring(0, e_col.elementTextTrim("DataType").indexOf("(")));
                    }else {
                        col.setType(e_col.elementTextTrim("DataType"));
                    }
                    col.setCode(e_col.elementTextTrim("Code"));
                    col.setComment(e_col.elementTextTrim("Comment"));
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
                    list.add(col);
                } catch (Exception ex) {
                    // col.setType(e_col.elementTextTrim("DataType"));
                    System.out.println("+++++++++有错误++++" );
                    ex.printStackTrace();
                }
            }
            vo.setCols(list);
            voS.add(vo);
        }
        return voS;
    }

    public static void main(String[] args) {
        Pdm2MdUtil pp = new Pdm2MdUtil();
        List<Table> tabs = pp.parsePDM_VO("D:\\git\\mall\\document\\pdm\\mall.pdm");
        pp.genIndexPage(tabs);
        pp.genTablePages(tabs);
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
        table.getCols().stream().forEach(column -> {
            sb.append(tableString).append(column.getName()).append(tableString)
                    .append(Optional.ofNullable(column.getCode()).orElse("")).append(tableString)
                    .append(Optional.ofNullable(column.getType()).orElse("")).append(tableString)
                    .append(column.getLength() == null ? "":column.getLength()).append(tableString)
                    .append(Optional.ofNullable(column.getDefaultValue()).orElse("")).append(tableString)
                    .append(Optional.ofNullable(column.getComment()).orElse("")).append(tableString)
                    .append(column.getPkFlag() == null?"":"Y").append(tableString).append(brString);
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
