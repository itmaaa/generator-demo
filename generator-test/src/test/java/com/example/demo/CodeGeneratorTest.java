package com.example.demo;

import com.baomidou.mybatisplus.generator.config.OutputFile;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

class CodeGeneratorTest {

// main 方法生成的代码位置在根目录下 即 generator-demo/src
// public static void main(String[] args) {

    // test 方法生成的代码位置在模块目录下 即 generator-demo/generator-demo/src
    @Test
    public void generator() {

        CodeGeneratorConfig config = new CodeGeneratorConfig();
        config.setDbUrl("jdbc:mysql://127.0.0.1:3306/test?serverTimezone=Asia/Shanghai&useUnicode=true&characterEncoding=utf-8&zeroDateTimeBehavior=convertToNull&useSSL=false&allowPublicKeyRetrieval=true");
        config.setDbUser("root");
        config.setDbPassword("");
        // 模块名称
        config.setModuleName("user");
        // 生成java代码的表
        config.setTableNameList("sys_user");

        // 上层路径
        String projectPath = System.getProperty("user.dir");
        System.out.println("projectPath = " + projectPath);
        String absolutePath = new File("").getAbsolutePath();
        System.out.println("absolutePath = " + absolutePath);


        // java 放到 src/main/java 下
        String javaCodePath = projectPath + "/src/main/java/";
        System.out.println("javaCodePath = " + javaCodePath);
        config.setOutput(javaCodePath);
        config.setBasePackage("com.example.demo");

        // xml 放到 resources/mapper 下
        String mapperPath = absolutePath + "/src/main/resources/mapper/";
        System.out.println("mapperPath = " + mapperPath);

        Map<OutputFile, String> pathInfo = new HashMap<>();
        pathInfo.put(OutputFile.xml, mapperPath);
        config.setPathInfo(pathInfo);

        // 不增强三层
       // config.setEnhancer(false);

        CodeGenerator.generator(config);

    }
}