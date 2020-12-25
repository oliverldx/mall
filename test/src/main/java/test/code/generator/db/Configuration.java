package test.code.generator.db;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import test.code.generator.Constant;

import java.io.Serializable;

/**
 * Generator 配置类
 *
 * @author GreedyStar
 * @since 2018/9/7
 */
@Data
@Builder
public class Configuration implements Serializable {
    /**
     * 代码作者
     */
    private String author;
    /**
     * 顶级包名
     */
    private String packageName;
    /**
     * 类型转换器全限定类名
     */
    private String convertor;
    /**
     * 启用lombok
     */
    private boolean lombokEnable;
    /**
     * 是否将mybatis的xml映射文件放在源文件目录下
     */
    private boolean mapperUnderSource;
    /**
     * 启用swagger
     */
    private boolean swaggerEnable;
    /**
     * mybatis-plus模式
     */
    private boolean mybatisPlusEnable;
    /**
     * jpa模式
     */
    private boolean jpaEnable;
    /**
     * 文件覆盖
     */
    private boolean fileOverride;
    /**
     * id策略（auto：数据库自增，uuid：生成uuid）
     */
    private IdStrategy idStrategy;
    /**
     * 代码生成路径
     */
    private Path path;
    /**
     * 数据库配置
     */
    private Db db;
    /**
     * 代码文件后缀
     */
    private Name name;


    /**
     * 数据库配置
     */
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Db {
        /**
         * 数据库URL
         */
        private String url;
        /**
         * 数据库用户名
         */
        private String username;
        /**
         * 数据库密码
         */
        private String password;
    }

    /**
     * 代码路径配置
     */
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Path {
        /**
         * Controller代码包路径
         */
        private String controller = "";
        /**
         * Service或ServiceImpl代码包路径
         */
        private String service = "";
        /**
         * Service接口代码包路径
         */
        private String interf = "";
        /**
         * Dao代码包路径
         */
        private String dao = "";
        /**
         * Entity代码包路径
         */
        private String entity = "";
        /**
         * Mapper映射文件路径
         */
        private String mapper = "";
        /**
         * generated文件路径
         */
        @Builder.Default
        private String generated = "D:\\git\\mall\\test\\generated";
    }

    /**
     * 类名配置
     */
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Name {
        /**
         * Controller类的类名，默认为 $sController
         */
        @Builder.Default
        private String controller = Constant.PLACEHOLDER + "Controller";
        /**
         * Service类或ServiceImpl类的类名，默认为$sService或$sServiceImpl
         */
        @Builder.Default
        private String service = Constant.PLACEHOLDER + "Service";
        /**
         * Service接口类的类名，默认为$sService
         */
        @Builder.Default
        private String interf = Constant.PLACEHOLDER + "Service";
        /**
         * Dao类的类名，默认为$sDao
         */
        @Builder.Default
        private String dao = Constant.PLACEHOLDER + "Dao";
        /**
         * Entity类的类名，默认为$s
         */
        @Builder.Default
        private String entity = Constant.PLACEHOLDER;
        /**
         * Mapper映射文件的文件名，默认$sMapper
         */
        @Builder.Default
        private String mapper = Constant.PLACEHOLDER + "Mapper";
    }

}