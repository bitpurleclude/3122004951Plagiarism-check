package org.example;

import org.example.tool.CosineSimilarity;
import org.example.tool.StringUtils;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        if (args.length != 3) {
            System.err.println("Usage: java -jar main.jar <path1> <path2> <outputPath>");
            throw new IllegalArgumentException("Invalid number of arguments");
        }

        String path1 = args[0];
        String path2 = args[1];
        String outputPath = args[2];

        double v = StringUtils.calculateSimilarity(path1, path2);
        //写入文件
        StringUtils.writeToFile(outputPath, v);
    }

}