package test.code.generator.task.one2many;

import cn.hutool.core.collection.CollectionUtil;
import com.google.common.base.CaseFormat;
import freemarker.template.TemplateException;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import test.code.generator.FileTypeEnum;
import test.code.generator.ProjectFilePathEnum;
import test.code.generator.task.AbstractTask;
import test.code.generator.utils.FileUtil;
import test.code.generator.utils.SubListUtil;
import test.pdm.entity.Column;
import test.pdm.entity.Model;
import test.pdm.entity.Table;
import test.pdm.utils.Pdm2MdUtil;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class MoveFileTask extends AbstractTask {

    public static void main(String[] args) {
        try {
            Pdm2MdUtil pp = new Pdm2MdUtil();
            String pdfFile = "D:\\git\\mall\\document\\pdm\\training_school.pdm";
            Model model = pp.getModel(pdfFile);
            new MoveFileTask().run(model);
        } catch (TemplateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<Table> getTables(Model model) {
        Map<String, Table> tabs = model.getTables();
        List<String> convertTabs = CollectionUtil.newArrayList("trs_school","trs_course","trs_school_activity","trs_source_activity","trs_activity");
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

    @Override
    public void run(Model model) throws IOException, TemplateException {
        List<Table> tableList = getTables(model);
        String filePath = null;
        String moveFileFolder = null;
        for (Table table : tableList) {

            if(StringUtils.isAnyBlank(table.getOne2ManyColId(),table.getOne2ManyColName())) {
                continue;
            }

            Table parentTable = getParentTable(table.getOne2ManyColId(),table);

            filePath = FileUtil.getFilePath(FileTypeEnum.ONE2MANY_CONTROLLER.getValue(), table.getTableName());
            moveFileFolder = FileUtil.getMoveFilePath(ProjectFilePathEnum.ADMIN.getValue(), FileTypeEnum.ONE2MANY_CONTROLLER.getValue());
            FileUtils.copyFileToDirectory(new File(filePath),new File(moveFileFolder));

            Optional<Column> subListColumn = SubListUtil.getSubListColumn(table);
            if(subListColumn.isPresent()) {
                filePath = FileUtil.getFilePath(FileTypeEnum.ONE2MANY_SUBLIST_INDEX_VUE.getValue(), table.getTableName());
                moveFileFolder = FileUtil.getMoveFilePath(ProjectFilePathEnum.ADMIN_WEB.getValue(), FileTypeEnum.ONE2MANY_SUBLIST_INDEX_VUE.getValue());
            }else {
                filePath = FileUtil.getFilePath(FileTypeEnum.ONE2MANY_INDEX_VUE.getValue(), table.getTableName());
                moveFileFolder = FileUtil.getMoveFilePath(ProjectFilePathEnum.ADMIN_WEB.getValue(), FileTypeEnum.ONE2MANY_INDEX_VUE.getValue());
            }
            String subName = StringUtils.substringAfter(parentTable.getTableName(), "_");
            String tableSubName = StringUtils.substringAfter(table.getTableName(), "_");
            if(!StringUtils.containsIgnoreCase(tableSubName, subName)) {
                subName = tableSubName;
            }
            String modelName = StringUtils.substringBefore(parentTable.getTableName(), "_");
            moveFileFolder += File.separator + modelName + File.separator + subName;
            moveFileFolder += File.separator + "components";
            FileUtils.copyFileToDirectory(new File(filePath),new File(moveFileFolder));

            filePath = FileUtil.getFilePath(FileTypeEnum.ONE2MANY_API_JS.getValue(), table.getTableName());
            moveFileFolder = FileUtil.getMoveFilePath(ProjectFilePathEnum.ADMIN_WEB.getValue(), FileTypeEnum.ONE2MANY_API_JS.getValue());

            subName = StringUtils.substringAfter(parentTable.getTableName(), "_");
            if(!StringUtils.containsIgnoreCase(tableSubName, subName)) {
                subName = tableSubName;
            }
            subName = CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL,subName);
            moveFileFolder += File.separator + subName;
            FileUtils.copyFileToDirectory(new File(filePath),new File(moveFileFolder));

            Map<String, Table> parentTables = table.getParentTables();
            if(parentTables == null || parentTables.isEmpty()) {
                continue;
            }

            filePath = FileUtil.getFilePath(FileTypeEnum.ONE2MANY_DAO.getValue(), table.getTableName());
            moveFileFolder = FileUtil.getMoveFilePath(ProjectFilePathEnum.ADMIN.getValue(), FileTypeEnum.ONE2MANY_DAO.getValue());
            FileUtils.copyFileToDirectory(new File(filePath),new File(moveFileFolder));

            filePath = FileUtil.getFilePath(FileTypeEnum.ONE2MANY_DAO_XML.getValue(), table.getTableName());
            moveFileFolder = FileUtil.getMoveFilePath(ProjectFilePathEnum.ADMIN.getValue(), FileTypeEnum.ONE2MANY_DAO_XML.getValue());
            FileUtils.copyFileToDirectory(new File(filePath),new File(moveFileFolder));

            filePath = FileUtil.getFilePath(FileTypeEnum.ONE2MANY_QUERY_PARAM.getValue(), table.getTableName());
            moveFileFolder = FileUtil.getMoveFilePath(ProjectFilePathEnum.ADMIN.getValue(), FileTypeEnum.ONE2MANY_QUERY_PARAM.getValue());
            FileUtils.copyFileToDirectory(new File(filePath),new File(moveFileFolder));

            filePath = FileUtil.getFilePath(FileTypeEnum.ONE2MANY_ENTITY_DTO.getValue(), table.getTableName());
            moveFileFolder = FileUtil.getMoveFilePath(ProjectFilePathEnum.ADMIN.getValue(), FileTypeEnum.ONE2MANY_ENTITY_DTO.getValue());
            FileUtils.copyFileToDirectory(new File(filePath),new File(moveFileFolder));

            if(subListColumn.isPresent()) {
                filePath = FileUtil.getFilePath(FileTypeEnum.ONE2MANY_SUBLIST_QUERY_PARAM.getValue(), table.getTableName());
                moveFileFolder = FileUtil.getMoveFilePath(ProjectFilePathEnum.ADMIN.getValue(), FileTypeEnum.ONE2MANY_SUBLIST_QUERY_PARAM.getValue());
                FileUtils.copyFileToDirectory(new File(filePath),new File(moveFileFolder));
            }

        }
    }
}