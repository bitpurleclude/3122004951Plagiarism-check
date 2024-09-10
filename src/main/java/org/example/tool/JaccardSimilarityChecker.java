package org.example.tool;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class JaccardSimilarityChecker {



    public static double calculateJaccardSimilarity(String text1, String text2) {
        Set<String> words1 = preprocessText(text1);
        Set<String> words2 = preprocessText(text2);

        Set<String> intersection = new HashSet<>(words1);
        intersection.retainAll(words2);

        Set<String> union = new HashSet<>(words1);
        union.addAll(words2);

        return (double) intersection.size() / union.size();
    }

    private static Set<String> preprocessText(String text) {
        // 使用正则表达式去除标点符号和空格，并将文本转换为小写
        return Arrays.stream(text.toLowerCase().replaceAll("[\\pP\\p{Punct}\\s]", "").split(""))
                .collect(Collectors.toSet());
    }

    public static void getJaccardSimilarity(String path1, String path2) throws IOException {
        String paper1 = new String(Files.readAllBytes(Paths.get(path1)));
        String paper2 = new String(Files.readAllBytes(Paths.get(path2)));
        double similarity = calculateJaccardSimilarity(paper1, paper2);
        System.out.printf("The Jaccard similarity score is: %.2f%%\n", similarity * 100);
    }
}