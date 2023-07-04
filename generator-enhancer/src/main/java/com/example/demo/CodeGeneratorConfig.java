package com.example.demo;

import com.baomidou.mybatisplus.generator.config.OutputFile;

import java.util.Map;

public class CodeGeneratorConfig {

    /**
     * 代码生成的目录
     */
    private String output;

    /**
     * jdbc url
     */
    private String dbUrl;

    /**
     * jdbc user
     */
    private String dbUser;

    /**
     * jdbc password
     */
    private String dbPassword;

    /**
     * 代码包. entity 和 mapper 的 java 父包
     */
    private String basePackage;

    /**
     * jdbc 驱动名. 默认 mysql
     */
    private String dbDriverName = "com.mysql.cj.jdbc.Driver";


    /**
     * 生成文件的路径信息
     */
    private Map<OutputFile, String> pathInfo;

    /**
    * 输出即要生成代码的表名,逗号分割
    */
    private String tableNameList;

    /**
    * 模块名称
    */
    private String moduleName = "";

    /**
    * 是否输出增强代码
    */
    private boolean enhancer = true;

    public String getOutput() {
        return output;
    }

    public void setOutput(String output) {
        this.output = output;
    }

    public String getDbUrl() {
        return dbUrl;
    }

    public void setDbUrl(String dbUrl) {
        this.dbUrl = dbUrl;
    }

    public String getDbUser() {
        return dbUser;
    }

    public void setDbUser(String dbUser) {
        this.dbUser = dbUser;
    }

    public String getDbPassword() {
        return dbPassword;
    }

    public void setDbPassword(String dbPassword) {
        this.dbPassword = dbPassword;
    }

    public String getBasePackage() {
        return basePackage;
    }

    public void setBasePackage(String basePackage) {
        this.basePackage = basePackage;
    }

    public String getDbDriverName() {
        return dbDriverName;
    }

    public void setDbDriverName(String dbDriverName) {
        this.dbDriverName = dbDriverName;
    }

    public Map<OutputFile, String> getPathInfo() {
        return pathInfo;
    }

    public void setPathInfo(Map<OutputFile, String> pathInfo) {
        this.pathInfo = pathInfo;
    }

    public String getTableNameList() {
        return tableNameList;
    }

    public void setTableNameList(String tableNameList) {
        this.tableNameList = tableNameList;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public boolean isEnhancer() {
        return enhancer;
    }

    public void setEnhancer(boolean enhancer) {
        this.enhancer = enhancer;
    }
}
