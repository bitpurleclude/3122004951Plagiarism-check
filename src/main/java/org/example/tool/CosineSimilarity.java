package org.example.tool;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class CosineSimilarity {
    public static void getCosineSimilarity(String path1, String path2) throws IOException {
        String paper1 = new String(Files.readAllBytes(Paths.get(path1)));
        String paper2 = new String(Files.readAllBytes(Paths.get(path2)));
        double similarity = calculateCosineSimilarity(paper1, paper2);
        System.out.printf("The Cosine similarity score is: %.2f%%\n", similarity * 100);
    }
    public static double calculateCosineSimilarity(String text1, String text2) {
        // 将文本转换为词频向量
        Map<String, Integer> vector1 = textToVector(text1);
        Map<String, Integer> vector2 = textToVector(text2);

        // 计算分子：向量的点积
        double dotProduct = 0;
        for (String key : vector1.keySet()) {
            if (vector2.containsKey(key)) {
                dotProduct += vector1.get(key) * vector2.get(key);
            }
        }

        // 计算分母：两个向量的模
        double magnitude1 = 0;
        double magnitude2 = 0;
        for (Integer value : vector1.values()) {
            magnitude1 += Math.pow(value, 2);
        }
        for (Integer value : vector2.values()) {
            magnitude2 += Math.pow(value, 2);
        }
        magnitude1 = Math.sqrt(magnitude1);
        magnitude2 = Math.sqrt(magnitude2);

        // 计算余弦相似度
        return dotProduct / (magnitude1 * magnitude2);
    }

    private static Map<String, Integer> textToVector(String text) {
        Map<String, Integer> vector = new HashMap<>();
        String[] words = text.split("\\s+");
        for (String word : words) {
            vector.put(word, vector.getOrDefault(word, 0) + 1);
        }
        return vector;
    }

}
