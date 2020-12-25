package test.code.generator.task;

import freemarker.template.TemplateException;
import test.code.generator.FileTypeEnum;
import test.code.generator.ProjectFilePathEnum;
import test.code.generator.utils.FileUtil;
import test.pdm.entity.Model;
import test.pdm.entity.Table;
import test.pdm.utils.Pdm2MdUtil;

import java.io.IOException;
import java.util.List;

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
    public void run(Model model) throws IOException, TemplateException {
        List<Table> tableList = getTables(model);
        String filePath = null;
        String moveFileFolder = null;
        for (Table table : tableList) {

            filePath = FileUtil.getFilePath(FileTypeEnum.CONTROLLER.getValue(), table.getTableName());
            moveFileFolder = FileUtil.getMoveFilePath(ProjectFilePathEnum.ADMIN.getValue(), FileTypeEnum.CONTROLLER.getValue());
            System.out.println(filePath);
            System.out.println(moveFileFolder);
            /*FileUtils.copyFileToDirectory(new File(filePath),new File(moveFileFolder));

            filePath = FileUtil.getFilePath(FileTypeEnum.DAO.getValue(), table.getTableName());
            moveFileFolder = FileUtil.getMoveFilePath(ProjectFilePathEnum.ADMIN.getValue(), FileTypeEnum.DAO.getValue());
            FileUtils.copyFileToDirectory(new File(filePath),new File(moveFileFolder));

            filePath = FileUtil.getFilePath(FileTypeEnum.DAO_XML.getValue(), table.getTableName());
            moveFileFolder = FileUtil.getMoveFilePath(ProjectFilePathEnum.ADMIN.getValue(), FileTypeEnum.DAO_XML.getValue());
            FileUtils.copyFileToDirectory(new File(filePath),new File(moveFileFolder));

            filePath = FileUtil.getFilePath(FileTypeEnum.QUERY_PARAM.getValue(), table.getTableName());
            moveFileFolder = FileUtil.getMoveFilePath(ProjectFilePathEnum.ADMIN.getValue(), FileTypeEnum.QUERY_PARAM.getValue());
            FileUtils.copyFileToDirectory(new File(filePath),new File(moveFileFolder));

            filePath = FileUtil.getFilePath(FileTypeEnum.INDEX_VUE.getValue(), table.getTableName());
            moveFileFolder = FileUtil.getMoveFilePath(ProjectFilePathEnum.ADMIN.getValue(), FileTypeEnum.INDEX_VUE.getValue());
            FileUtils.copyFileToDirectory(new File(filePath),new File(moveFileFolder));

            filePath = FileUtil.getFilePath(FileTypeEnum.API_JS.getValue(), table.getTableName());
            moveFileFolder = FileUtil.getMoveFilePath(ProjectFilePathEnum.ADMIN.getValue(), FileTypeEnum.API_JS.getValue());
            FileUtils.copyFileToDirectory(new File(filePath),new File(moveFileFolder));*/


        }
    }
}
