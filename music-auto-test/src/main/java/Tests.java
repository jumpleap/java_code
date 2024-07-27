import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

import static java.lang.Thread.sleep;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class Tests extends InitAndEndBrowser{

    // 登录功能测试
    @Order(1)
    @ParameterizedTest
    @CsvSource({"'http://121.37.251.14:8080/login.html', 'bit', '123456'"})
    void login(String url, String username, String password) throws InterruptedException {
        // 打开登录页面
        webDriver.get(url);

        // 选中用户名，输入用户名
        webDriver.findElement(By.cssSelector("#user")).sendKeys(username);
        sleep(2000);
        // 选中密码，输入密码
        webDriver.findElement(By.cssSelector("#password")).sendKeys(password);
        sleep(2000);
        // 选中登录按钮，点击登录按钮
        webDriver.findElement(By.cssSelector("#submit")).click();
        sleep(2000);

        // 接收弹窗
        Alert alert = webDriver.switchTo().alert();
        alert.accept();

        // 校验
        // 1.校验是否跳转到音乐列表页
        String currentUrl = webDriver.getCurrentUrl();
        String expectedUrl = "http://121.37.251.14:8080/list.html";
        Assertions.assertEquals(expectedUrl, currentUrl);

        // 校验文字是否正确
        String title = webDriver.findElement(By.cssSelector("#body > div.container > h3")).getText();
        String expectedTitle = "在线音乐服务器实现";
        Assertions.assertEquals(expectedTitle, title);
    }

    // 播放歌曲功能测试
    @Order(2)
    @Test
    void playMusic() throws InterruptedException {
        // 打开音乐列表页
        webDriver.get("http://121.37.251.14:8080/list.html");
        sleep(20000);

        // 选中播放按钮，点击播放
        webDriver.findElement(By.cssSelector("#info > tr:nth-child(1) > td:nth-child(4) > button")).click();
        sleep(2000);

        // 验证
        // 1.验证当前播放歌曲的名称是否正确
        String playMusicName = webDriver.findElement(By.cssSelector("#body > div:nth-child(2) > div > audio")).getAttribute("src");
        String expectedPlayMusicName = "http://121.37.251.14:8080/music/get?path=%E8%8A%B1%E7%B2%A5%20-%20%E7%BA%B8%E7%9F%AD%E6%83%85%E9%95%BF.mp3";
        Assertions.assertEquals(expectedPlayMusicName, playMusicName);


        // 2.验证播放的状态
        String musicName = webDriver.findElement(By.cssSelector("#body > div:nth-child(2) > div > div > div.big-play-btn")).getAttribute("style");
        String expectedMusicName = "display: none;";

        Assertions.assertEquals(expectedMusicName, musicName);
    }


    // 收藏歌曲
    @Order(3)
    @Test
    void collection() throws InterruptedException {
        // 打开音乐列表页
        webDriver.get("http://121.37.251.14:8080/list.html");
        sleep(5000);

        // 选中喜欢按钮，并点击
        webDriver.findElement(By.cssSelector("#info > tr:nth-child(1) > td:nth-child(5) > button:nth-child(2)")).click();
        sleep(3000);

        // 接收弹窗
        Alert alert = webDriver.switchTo().alert();
        alert.accept();

        // 校验
        // 选中喜欢列表按钮，并点击
        webDriver.findElement(By.cssSelector("#body > div.container > div:nth-child(3) > a:nth-child(1)")).click();
        sleep(3000);

        // 获取音乐名
        String musicName = webDriver.findElement(By.cssSelector("#info > tr > td:nth-child(1)")).getText();
        String expectedName = "花粥 - 纸短情长";
        Assertions.assertEquals(expectedName, musicName);
    }

    // 取消收藏测试
    @Order(4)
    @Test
    void cancelCollection() throws InterruptedException {
        // 打开收藏音乐列表
        webDriver.get("http://121.37.251.14:8080/loveMusic.html");
        sleep(5000);

        // 选中移除操作，并点击
        webDriver.findElement(By.cssSelector("#info > tr > td:nth-child(4) > button")).click();
        sleep(3000);

        // 接收弹窗
        Alert alert = webDriver.switchTo().alert();
        alert.accept();
        sleep(3000);

        // 校验
        // 检验跳转的 URL 是否跳转正确
        String expectedUrl = "http://121.37.251.14:8080/list.html";
        String currentUrl = webDriver.getCurrentUrl();
        Assertions.assertEquals(expectedUrl, currentUrl);
    }


    // 测试添加音乐功能
    @Test
    void uploadMusic() {

    }
}
