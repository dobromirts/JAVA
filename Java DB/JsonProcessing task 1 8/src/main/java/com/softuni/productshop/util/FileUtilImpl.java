package com.softuni.productshop.util;

import java.io.*;

public class FileUtilImpl implements FileUtil {
    @Override
    public String fileContent(String path) throws IOException {
        File file=new File(path);
        BufferedReader bf=new BufferedReader(new InputStreamReader(new FileInputStream(file)));
        StringBuilder sb=new StringBuilder();

        String line;
        while ((line=bf.readLine())!=null){
            sb.append(line).append(System.lineSeparator());
        }
        return sb.toString().trim();
    }
}
