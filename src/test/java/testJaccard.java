import org.example.tool.CosineSimilarity;
import org.junit.Test;

import java.io.IOException;

import static org.example.tool.JaccardSimilarityChecker.getJaccardSimilarity;


public class testJaccard {
    String filePath = "C:\\Users\\15517\\OneDrive\\文档\\WeChat Files\\wxid_9ilfjghrc2k622\\FileStorage\\File\\2024-09\\测试文本";
    String fileOrig = "\\orig.txt";
    String fileAdd = "\\orig_0.8_add.txt";
    String fileDel = "\\orig_0.8_del.txt";
    String fileDis1 = "\\orig_0.8_dis_1.txt";
    String fileDis10 = "\\orig_0.8_dis_10.txt";
    String fileDis15 = "\\orig_0.8_dis_15.txt";

    @Test
    public void testAllFile() throws IOException {
        CosineSimilarity.getCosineSimilarity(filePath + fileOrig, filePath + fileAdd);
        CosineSimilarity.getCosineSimilarity(filePath + fileOrig, filePath + fileDel);
        CosineSimilarity.getCosineSimilarity(filePath + fileOrig, filePath + fileDis1);
        CosineSimilarity.getCosineSimilarity(filePath + fileOrig, filePath + fileDis10);
        CosineSimilarity.getCosineSimilarity(filePath + fileOrig, filePath + fileDis15);
        getJaccardSimilarity(filePath + fileOrig, filePath + fileAdd);
        getJaccardSimilarity(filePath + fileOrig, filePath + fileDel);
        getJaccardSimilarity(filePath + fileOrig, filePath + fileDis1);
        getJaccardSimilarity(filePath + fileOrig, filePath + fileDis10);
        getJaccardSimilarity(filePath + fileOrig, filePath + fileDis15);


    }

}
