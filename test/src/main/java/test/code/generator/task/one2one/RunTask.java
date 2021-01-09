package test.code.generator.task.one2one;

import freemarker.template.TemplateException;
import test.pdm.entity.Model;
import test.pdm.utils.Pdm2MdUtil;

import java.io.IOException;

public class RunTask {

    public static void main(String[] args) {
        try {
            Pdm2MdUtil pp = new Pdm2MdUtil();
            String pdfFile = "D:\\git\\mall\\document\\pdm\\training_school.pdm";
            Model model = pp.getModel(pdfFile);
            new ControllerTask().run(model);
            new ComponentVueTask().run(model);
        } catch (TemplateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
