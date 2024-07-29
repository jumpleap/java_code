import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static java.lang.Thread.sleep;

public class InitAndEndBrowser {
    static WebDriver webDriver;
    // 登录页面
    static final String MUSIC_LOGIN_ADDR = "http://121.37.251.14:8080/login.html";
    // 音乐列表页
    static final String MUSIC_LIST_ADDR = "http://121.37.251.14:8080/list.html";
    // 喜欢列表页
    static final String MUSIC_COLLECTION_LIST_ADDR = "http://121.37.251.14:8080/loveMusic.html";

    @BeforeAll
    static void start() {
        webDriver = new ChromeDriver();
    }

    @AfterAll
    static void end() throws InterruptedException {
        sleep(3000);
        webDriver.quit();
    }
}
