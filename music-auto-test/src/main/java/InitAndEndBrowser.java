import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static java.lang.Thread.sleep;

public class InitAndEndBrowser {
    static WebDriver webDriver;

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
