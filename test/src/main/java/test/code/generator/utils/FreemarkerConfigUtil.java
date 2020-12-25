package test.code.generator.utils;

import freemarker.template.Configuration;

import java.io.File;
import java.io.IOException;
import java.util.Locale;

/**
 * @author GreedyStar
 * @since 2018/4/19
 */
public class FreemarkerConfigUtil {
    /**
     * 模板路径
     */
    private static String path = new File(FreemarkerConfigUtil.class.getClassLoader().getResource("ftls").getFile()).getPath();
    /**
     * freemarker配置
     */
    private static volatile Configuration configuration;

    public static Configuration getInstance() {
        if (null == configuration) {
            synchronized (FreemarkerConfigUtil.class) {
                if (null == configuration) {
                    configuration = new Configuration(Configuration.VERSION_2_3_23);
                    try {
                        if (path.contains("jar")) {
                            configuration.setClassForTemplateLoading(FreemarkerConfigUtil.class, "/ftls");
                        } else {
                            configuration.setDirectoryForTemplateLoading(new File(path));
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    configuration.setEncoding(Locale.CHINA, "utf-8");
                }
            }
        }
        return configuration;
    }
}
