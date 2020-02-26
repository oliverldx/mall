import org.dom4j.*;
import org.dom4j.io.SAXReader;
import org.fusesource.jansi.Ansi;
import org.fusesource.jansi.AnsiConsole;

import java.io.File;
import java.util.ArrayList;
import java.util.List;


/**
 * @author chenjazz
 */
public class MainReader {

    public static void main(String[] args) throws DocumentException {
        System.out.println();
        AnsiConsole.systemInstall();
        if (args.length < 1) {
//            throw new IllegalArgumentException("第一个参数必须是pdm文件路径");
            args = new String[1];
            args[0] = "D:\\git\\mall\\document\\pdm\\mall.pdm";
        }
        String fileName = args[0];
        System.out.println("File  path:" + fileName);

        long start = System.currentTimeMillis();

        SAXReader saxReader = new SAXReader();
        Document document = saxReader.read(new File(fileName));
        Element rootElement = document.getRootElement();


        Namespace oNamespace = new Namespace("o", "object");
        Namespace cNamespace = new Namespace("c", "collection");
        Namespace aNamespace = new Namespace("a", "attribute");

        Element rootObject = rootElement.element(new QName("RootObject", oNamespace));

        Element children = rootObject.element(new QName("Children", cNamespace));
        Element model = children.element(new QName("Model", oNamespace));

        List<Element> tableEles = new ArrayList<>();

        //解析package
        Element packagesEle = model.element(new QName("Packages", cNamespace));
        if (packagesEle != null) {
            List<Element> packageEles = packagesEle.elements(new QName("Package", oNamespace));
            for (Element packageEle : packageEles) {
                Element tablesEle = packageEle.element(new QName("Tables", cNamespace));
                if (tablesEle != null) {
                    tableEles.addAll(tablesEle.elements(new QName("Table", oNamespace)));
                }
            }
        }


        //直接解析table
        Element tablesEle = model.element(new QName("Tables", cNamespace));
        if (tablesEle != null) {
            tableEles.addAll(tablesEle.elements(new QName("Table", oNamespace)));
        }

        System.out.println("Table size:" +tableEles.size());

        System.out.println(Ansi.ansi().fgDefault().a(" "));

        int i = 0;
        for (Element tableElement : tableEles) {
            i++;
            Element name = tableElement.element(new QName("Name", aNamespace));
            Element code = tableElement.element(new QName("Code", aNamespace));
            System.out.println("------>" + "NO." + i + " " + name.getText() + " " + code.getText() + "<-------");

            //解析主键
            Element primaryKeyEle = tableElement.element(new QName("PrimaryKey", cNamespace));
            List<String> pkIds = new ArrayList<>();
            if (primaryKeyEle != null) {
                List<Element> pks = primaryKeyEle.elements(new QName("Key", oNamespace));
                for (Element pk1 : pks) {
                    pkIds.add(pk1.attribute("Ref").getValue());
                }
            }

            Element keysEle = tableElement.element(new QName("Keys", cNamespace));
            List<String> pkColumnIds = new ArrayList<>();
            if (keysEle != null) {
                List<Element> keyEleList = keysEle.elements(new QName("Key", oNamespace));
                for (Element keyEle : keyEleList) {
                    Attribute id = keyEle.attribute("Id");
                    if (pkIds.contains(id.getValue())) {
                        List<Element> list = keyEle.element(new QName("Key.Columns", cNamespace)).elements(new QName("Column", oNamespace));
                        for (Element element : list) {
                            pkColumnIds.add(element.attribute("Ref").getValue());
                        }
                    }
                }
            }

            //解析column
            List<Element> columns = tableElement.element(new QName("Columns", cNamespace)).elements(new QName("Column", oNamespace));
            for (Element columnEle : columns) {
                String columnId = columnEle.attribute("Id").getValue();
                Element cname = columnEle.element(new QName("Name", aNamespace));
                Element ccode = columnEle.element(new QName("Code", aNamespace));
                Element cDataType = columnEle.element(new QName("DataType", aNamespace));
                Element cLength = columnEle.element(new QName("Length", aNamespace));
                Element cComment = columnEle.element(new QName("Comment", aNamespace));
                Element nullable = columnEle.element(new QName("Column.Mandatory", aNamespace));

                System.out.print(getPadString(ccode.getText(), 20));
                System.out.print(getPadString(getTextFromEle(cDataType), 15));
                System.out.print(getPadString(getTextFromEle(cLength), 7));

                if (pkColumnIds.contains(columnId)) {
                    System.out.print("√  ");
                } else {
                    System.out.print("   ");
                }

                if (nullable != null) {
                    System.out.print("M  ");
                } else {
                    System.out.print("   ");
                }

                System.out.print(cname.getText());
                if (cComment != null) {
                    System.out.print("   (" + getTextFromEle(cComment).replace("\n", "  ") + ")");
                }
                System.out.println();
            }
            System.out.println();

        }

        System.out.println("================================");
        System.out.println("Use time:" + ((System.currentTimeMillis() - start) / 1000F) + "s");
        System.out.println();
        System.out.print("说明： ");
        System.out.print("");
        System.out.println("表标题分别为 列代码/类型/长度/是否为主键/是否允许为空/列可读名称及备注");
        System.out.println("      √ 表示主键， M 表示不能为空");
        System.out.println();
    }

    static String getTextFromEle(Element element) {
        if (element == null) {
            return "";
        }
        return element.getText();
    }

    /**
     * @see String#format(String, Object...)
     */
    static String getPadString(String str, int length) {
        int size = str.length();
        if (size < length) {
            str += getBlank(length - size);
            return str;
        } else
            return str + "  ";
    }


    static String getBlank(int length) {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < length; i++) {
            s.append(" ");
        }
        return s.toString();
    }
}
