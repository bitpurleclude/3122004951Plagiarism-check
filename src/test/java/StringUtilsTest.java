
import org.example.tool.StringUtils;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class StringUtilsTest {
    String filePath = "C:\\Users\\15517\\OneDrive\\文档\\WeChat Files\\wxid_9ilfjghrc2k622\\FileStorage\\File\\2024-09\\测试文本";
    String fileOrig = "\\orig.txt";
    String fileAdd = "\\orig_0.8_add.txt";
    String fileDel = "\\orig_0.8_del.txt";
    String fileDis1 = "\\orig_0.8_dis_1.txt";
    String fileDis10 = "\\orig_0.8_dis_10.txt";
    String fileDis15 = "\\orig_0.8_dis_15.txt";
    @Test
    // 测试两个相同文件的相似度计算
    public void calculateSimilarityWithIdenticalFiles() throws IOException {
        String path1 = filePath + fileOrig;
        String path2 = filePath + fileOrig;
        StringUtils.calculateSimilarity(path1, path2);
    }

    @Test
    // 测试两个不同文件的相似度计算
    public void calculateSimilarityWithDifferentFiles() throws IOException {
        String path1 = filePath + fileOrig;
        String path2 = filePath + fileAdd;
        StringUtils.calculateSimilarity(path1, path2);
    }

    @Test
    // 测试两个相同字符串的Levenshtein距离
    public void levenshteinDistanceWithIdenticalStrings() {
        assertEquals(0, StringUtils.levenshteinDistance("test", "test"));
    }

    @Test
    // 测试两个空字符串的Levenshtein距离
    public void levenshteinDistanceWithEmptyStrings() {
        assertEquals(1, StringUtils.levenshteinDistance("", ""));
    }

    @Test
    // 测试一个空字符串和一个非空字符串的Levenshtein距离
    public void levenshteinDistanceWithOneEmptyString() {
        assertEquals(4, StringUtils.levenshteinDistance("test", ""));
    }

    @Test
    // 测试两个不同字符串的Levenshtein距离
    public void levenshteinDistanceWithDifferentStrings() {
        assertEquals(3, StringUtils.levenshteinDistance("kitten", "sitting"));
    }

    @Test
    // 测试两个相同字符串的相似度得分
    public void similarityScoreWithIdenticalStrings() {
        assertEquals(1.0, StringUtils.similarityScore("test", "test"), 0.0001);
    }

    @Test
    // 测试一个空字符串和一个非空字符串的相似度得分
    public void similarityScoreWithOneEmptyString() {
        assertEquals(0.0, StringUtils.similarityScore("test", ""), 0.0001);
    }

    @Test
    // 测试两个不同字符串的相似度得分
    public void similarityScoreWithDifferentStrings() {
        assertEquals(0.5714285714285714, StringUtils.similarityScore("kitten", "sitting"), 0.0001);
    }
}