
import org.example.Main;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertThrows;

public class MainTest {

    @Test
    // 测试使用有效参数调用主方法
    public void mainWithValidArguments() throws IOException {
        String[] args = {
                "C:\\Users\\15517\\OneDrive\\文档\\WeChat Files\\wxid_9ilfjghrc2k622\\FileStorage\\File\\2024-09\\测试文本\\orig.txt",
                "C:\\Users\\15517\\OneDrive\\文档\\WeChat Files\\wxid_9ilfjghrc2k622\\FileStorage\\File\\2024-09\\测试文本\\orig_0.8_add.txt", "C:\\tests\\ans.txt"};
        Main.main(args);
    }

    @Test
    // 测试使用无效参数数量调用主方法
    public void mainWithInvalidNumberOfArguments() {
        String[] args = {"C:\\tests\\org.txt", "C:\\tests\\org_add.txt"};
        assertThrows(IllegalArgumentException.class, () -> Main.main(args));
    }

    @Test
    // 测试使用不存在的输入文件调用主方法
    public void mainWithNonExistentInputFiles() {
        String[] args = {"C:\\tests\\nonexistent1.txt", "C:\\tests\\nonexistent2.txt", "C:\\tests\\ans.txt"};
        assertThrows(IOException.class, () -> Main.main(args));
    }

    @Test
    // 测试使用空输入文件调用主方法
    public void mainWithEmptyInputFiles() throws IOException {
        String[] args = {
                "C:\\Users\\15517\\OneDrive\\文档\\WeChat Files\\wxid_9ilfjghrc2k622\\FileStorage\\File\\2024-09\\测试文本\\empty1.txt",
                "C:\\Users\\15517\\OneDrive\\文档\\WeChat Files\\wxid_9ilfjghrc2k622\\FileStorage\\File\\2024-09\\测试文本\\empty2.txt", "C:\\tests\\ans.txt"};
        Main.main(args);
    }
}