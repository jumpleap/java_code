import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

import static java.lang.Thread.sleep;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class Tests extends InitAndEndBrowser{
//    @Test
    @Order(1)
    @ParameterizedTest
    @CsvSource({"'http://121.37.251.14:9090/register.html', 'admin', '123'"})
    void register(String url, String username, String password) throws InterruptedException {
        // 打开注册网页
        webDriver.get(url);

        // 选中用户名输入“admin"
        webDriver.findElement(By.cssSelector("#username")).sendKeys(username);
        sleep(3000);
        // 选中密码输入"123”
        webDriver.findElement(By.cssSelector("#password")).sendKeys(password);
        sleep(3000);

        // 选中注册按钮，并点击
        webDriver.findElement(By.cssSelector("#submit")).click();
        sleep(3000);

        // 获取alert的弹窗
        Alert alert = webDriver.switchTo().alert();
        alert.accept();

        // 校验
        String currentUrl = webDriver.getCurrentUrl();
        String expectedUrl = "http://121.37.251.14:9090/login.html";

        // 判断是否相等，若不相等则报错
        Assertions.assertEquals(expectedUrl,currentUrl);
    }

    @Order(2)
    @ParameterizedTest
    @CsvSource({"'http://121.37.251.14:9090/login.html', 'zhangsan', '123'"})
    void login(String url, String username, String password) throws InterruptedException {
        // 打开登录页面
        webDriver.get(url);

        // 选中用户名，进行输入
        webDriver.findElement(By.cssSelector("#username")).sendKeys(username);
        sleep(2000);
        // 选中密码进行输入
        webDriver.findElement(By.cssSelector("#password")).sendKeys(password);
        sleep(2000);
        // 选中登录按钮，并点击
        webDriver.findElement(By.cssSelector("#submit")).click();
        sleep(2000);

        // 接受弹窗
        Alert alert = webDriver.switchTo().alert();
        alert.accept();

        // 校验
        // 1.先校验地址是否跳转成功
        String currentUrl = webDriver.getCurrentUrl();
        String expectedUrl = "http://121.37.251.14:9090/client.html";
        Assertions.assertEquals(expectedUrl, currentUrl);

        // 2.校验聊天首页的名字是不是和用户名一致
        String curName = webDriver.findElement(By.cssSelector("body > div.client-container > div > div.left > div.user")).getText();
        Assertions.assertEquals(curName, username);
    }
}
