package com.example.demo;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileConverter {
    public static void main(String[] args) {
        String sourceDirectory = "E:\\IdeaProjects\\LingXing\\ak-spring-cloud.git";
        String destinationDirectory = "E:\\IdeaProjects\\LingXing\\ak-spring-cloud";

        replace(sourceDirectory, destinationDirectory);
    }

    private static void replace(String sourceDirectory, String destinationDirectory) {
        File sourceDir = new File(sourceDirectory);
       // File[] sqlFiles = sourceDir.listFiles((dir, name) -> name.endsWith(".sql"));
        File[] sqlFiles = sourceDir.listFiles();

        if (sqlFiles != null) {
            for (File sqlFile : sqlFiles) {
                if(sqlFile.isDirectory()){
                    System.out.println(sqlFile.getAbsolutePath()+"===>>"+sqlFile.getAbsolutePath().replace("ak-spring-cloud.git","ak-spring-cloud"));
                    File file = new File(sqlFile.getAbsolutePath().replace("ak-spring-cloud.git", "ak-spring-cloud"));
                    if(!file.exists()){
                        file.mkdirs();
                    }
                    replace(sqlFile.getAbsolutePath(),sqlFile.getAbsolutePath().replace("ak-spring-cloud.git","ak-spring-cloud"));
                    continue;
                }
                if(!sqlFile.getName().endsWith("sql")){
                    System.out.println(sqlFile.getName() +" not endsWith sql");
                    continue;
                }
                String fileName = sqlFile.getName();
                String javaFileName = fileName.replace(".sql", "");

                File destinationFile = new File(destinationDirectory + File.separator + javaFileName);

                try (FileReader reader = new FileReader(sqlFile);
                     FileWriter writer = new FileWriter(destinationFile)) {

                    int character;
                    while ((character = reader.read()) != -1) {
                        writer.write(character);
                    }
                    System.out.println("Converted " + fileName + " to " + javaFileName);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


}
