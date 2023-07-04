package com.example.demo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.builder.CustomFile;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CodeGenerator {

    public static void generator(CodeGeneratorConfig config) {

        FastAutoGenerator mpg = FastAutoGenerator.create(config.getDbUrl(), config.getDbUser(), config.getDbPassword());

        mpg.globalConfig(builder -> {
                    builder.author("mazh")
                            .disableOpenDir()
                            .dateType(DateType.ONLY_DATE)
                            .outputDir(config.getOutput())
                            // .enableSwagger()
                            .commentDate("yyyy-MM-dd")
                            .build();
                }).packageConfig(builder -> {
                    builder.entity("entity")
                            .controller("controller")
                            .service("service")
                            .serviceImpl("service.impl")
                            .mapper("mapper")
                            .xml("mapper")
                            .moduleName(config.getModuleName())
                            .parent(config.getBasePackage())
                            .pathInfo(config.getPathInfo())
                            .build();
                }).strategyConfig(builder -> {
                    // 配置要生成代码的表
                    StrategyConfig strategyConfig = builder.addTablePrefix("t_")
                            .addInclude(config.getTableNameList().split(","))
                            .build();

                    // Entity 策略配置
                    strategyConfig.entityBuilder()
                            .enableFileOverride()
                            .enableRemoveIsPrefix()
                            .enableLombok()
                            .enableTableFieldAnnotation()
                            .idType(IdType.AUTO)
                            .build();

                    // controller
                    strategyConfig.controllerBuilder()
                            .enableFileOverride()
                            .enableRestStyle()
                            .formatFileName("%sController")
                            .build();

                    // service
                    strategyConfig.serviceBuilder()
                            .enableFileOverride()
                            .formatServiceFileName("%sService")
                            .formatServiceImplFileName("%sServiceImpl")
                            .build();

                    // mapper
                    strategyConfig.mapperBuilder()
                            .enableFileOverride()
                            .formatMapperFileName("%sMapper")
                            .formatXmlFileName("%sMapper")
                            .build();
                }).injectionConfig(consumer -> {
                    List<CustomFile> customFiles = new ArrayList<>();
                    Map<String, Object> customMap = new HashMap<>();
                    // request param  DTO
                    CustomFile requestFile = new CustomFile.Builder()
                            .enableFileOverride()
                            .packageName("request")
                            .templatePath("/templates/entityDTO.java.ftl")
                            .fileName("DTO.java")
                            .build();
                    customFiles.add(requestFile);
                    customMap.put("reqFilePath",config.getBasePackage() +  StringPool.DOT + (StringUtils.isBlank(config.getModuleName())?"": config.getModuleName()+ StringPool.DOT)+ requestFile.getPackageName());

                    // response  VO
                    CustomFile responseFile = new CustomFile.Builder()
                            .enableFileOverride()
                            .packageName("response")
                            .templatePath("/templates/entityVO.java.ftl")
                            .fileName("VO.java")
                            .build();
                    customFiles.add(responseFile);
                    customMap.put("respFilePath",config.getBasePackage() +  StringPool.DOT + (StringUtils.isBlank(config.getModuleName())?"": config.getModuleName()+ StringPool.DOT)+ responseFile.getPackageName());

                    // 配置自定义文件
                    consumer.customFile(customFiles).customMap(customMap);
                }).templateConfig(builder -> {
                    // 增强自定义代码
                    if(config.isEnhancer()){
                        builder//.disable(TemplateType.CONTROLLER)
                                .controller("/templates/custom-controller.java")
                                .service("/templates/custom-service.java")
                                .serviceImpl("/templates/custom-serviceImpl.java")
                                .build();
                    }
                })
                .templateEngine(new FreemarkerTemplateEngine())
                .execute();

    }

}
