package org.example.tool;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class StringUtils {
    public static void calculateSimilarity(String path1, String path2) throws IOException {
        String paper1 = new String(Files.readAllBytes(Paths.get(path1)));
        String paper2 = new String(Files.readAllBytes(Paths.get(path2)));
        double similarity = similarityScore(paper1, paper2);
        System.out.printf("The similarity score is: %.2f%%\n", similarity * 100);
    }

    /**
     * 计算两个字符串之间的编辑距离（Levenshtein距离）。
     *
     * @param s1 第一个字符串
     * @param s2 第二个字符串
     * @return 编辑距离
     */
    public static int levenshteinDistance(String s1, String s2) {
        if (s1 == null || s2 == null) {
            throw new IllegalArgumentException("Strings must not be null");
        }

        int len1 = s1.length() + 1;
        int len2 = s2.length() + 1;

        // 创建一个二维数组保存中间结果
        int[][] distance = new int[len1][len2];

        // 初始化二维数组
        for (int i = 0; i < len1; i++) {
            distance[i][0] = i;
        }
        for (int j = 0; j < len2; j++) {
            distance[0][j] = j;
        }

        // 计算编辑距离
        for (int i = 1; i < len1; i++) {
            for (int j = 1; j < len2; j++) {
                int cost = (s1.charAt(i - 1) == s2.charAt(j - 1)) ? 0 : 1;
                distance[i][j] = Math.min(Math.min(distance[i - 1][j] + 1, distance[i][j - 1] + 1), distance[i - 1][j - 1] + cost);
            }
        }

        // 返回最后一个元素，即两个字符串的编辑距离
        return distance[len1 - 1][len2 - 1];
    }
    public static double similarityScore(String s1, String s2) {
        int distance = levenshteinDistance(s1, s2);
        int maxLength = Math.max(s1.length(), s2.length());
        return 1.0 - (double) distance / maxLength;
    }

}
