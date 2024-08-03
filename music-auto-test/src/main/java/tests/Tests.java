package tests;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.*;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static java.lang.Thread.sleep;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class Tests extends InitAndEndBrowser {

    // 登录成功测试
    @Order(1)
    @ParameterizedTest
    @CsvSource({"'bit', '123456'"})
    void loginSuccess(String username, String password) throws InterruptedException, IOException {
        // 打开登录页面
        webDriver.get(MUSIC_LOGIN_ADDR);

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
        sleep(2000);

        // 截屏
        File file = ((TakesScreenshot) (webDriver)).getScreenshotAs(OutputType.FILE);
        // 把截屏保存到photo文件中
        FileUtils.copyFile(file, new File("D:\\Java_Code\\java_code\\music-auto-test\\src\\photo\\login.png"));

        // 校验
        // 1.校验是否跳转到音乐列表页
        String currentUrl = webDriver.getCurrentUrl();
        Assertions.assertEquals(MUSIC_LIST_ADDR, currentUrl);

        // 校验文字是否正确
        String title = webDriver.findElement(By.cssSelector("#body > div.container > h3")).getText();
        String expectedTitle = "在线音乐服务器实现";
        Assertions.assertEquals(expectedTitle, title);
    }


    // 播放歌曲成功测试
    @Order(2)
    @Test
    void playMusic() throws InterruptedException, IOException {
        // 打开音乐列表页
        webDriver.get(MUSIC_LIST_ADDR);
        sleep(25000);

        // 选中播放按钮，点击播放
        webDriver.findElement(By.cssSelector("#info > tr:nth-child(1) > td:nth-child(4) > button")).click();
        sleep(2000);

        // 截屏
        File file = ((TakesScreenshot) (webDriver)).getScreenshotAs(OutputType.FILE);
        // 把截屏保存到photo文件中
        FileUtils.copyFile(file, new File("D:\\Java_Code\\java_code\\music-auto-test\\src\\photo\\action.png"));

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


    // 收藏歌曲成功测试
    @Order(3)
    @Test
    void collectionSuccess() throws InterruptedException, IOException {
        // 打开音乐列表页
        webDriver.get(MUSIC_LIST_ADDR);
        sleep(5000);

        // 获取所有的音乐名
        List<WebElement> elements = webDriver.findElements(By.cssSelector("#info > td"));
        // 选中喜欢按钮，并点击
        webDriver.findElement(By.cssSelector("#info > tr:nth-child(1) > td:nth-child(5) > button:nth-child(2)")).click();
        sleep(3000);


        // 接收弹窗
        Alert alert = webDriver.switchTo().alert();
        alert.accept();
        sleep(2000);

        // 截屏
        File file = ((TakesScreenshot) (webDriver)).getScreenshotAs(OutputType.FILE);
        // 把截屏保存到photo文件中
        FileUtils.copyFile(file, new File("D:\\Java_Code\\java_code\\music-auto-test\\src\\photo\\collectionSuccess.png"));

        // 校验
        // 选中喜欢列表按钮，并点击
        webDriver.findElement(By.cssSelector("#body > div.container > div:nth-child(3) > a:nth-child(1)")).click();
        sleep(3000);

        // 获取音乐名
        String musicName = webDriver.findElement(By.cssSelector("#info > tr > td:nth-child(1)")).getText();
        // 判断收藏的音乐列表中的音乐是否存在喜欢列表中
        for (WebElement element : elements) {
            Assertions.assertEquals(element.getText(), musicName);
        }
    }

    // 收藏音乐失败测试
    @Order(4)
    @Test
    void collectionFail() throws InterruptedException, IOException {
        // 打开音乐列表页
        webDriver.get(MUSIC_LIST_ADDR);
        sleep(5000);

        // 获取所有的音乐名
        List<WebElement> elements = webDriver.findElements(By.cssSelector("#info > td"));
        // 选中喜欢按钮，并点击
        webDriver.findElement(By.cssSelector("#info > tr:nth-child(1) > td:nth-child(5) > button:nth-child(2)")).click();
        sleep(3000);

        // 接收弹窗
        Alert alert = webDriver.switchTo().alert();
        alert.accept();
        sleep(2000);

        // 截屏
        File file = ((TakesScreenshot) (webDriver)).getScreenshotAs(OutputType.FILE);
        // 把截屏保存到photo文件中
        FileUtils.copyFile(file, new File("D:\\Java_Code\\java_code\\music-auto-test\\src\\photo\\collectionFail.png"));

        // 校验
        String curUrl = webDriver.getCurrentUrl();
        Assertions.assertEquals(MUSIC_LIST_ADDR, curUrl);
    }

    // 取消收藏测试
    @Order(5)
    @Test
    void cancelCollection() throws InterruptedException, IOException {
        // 打开收藏音乐列表
        webDriver.get(MUSIC_COLLECTION_LIST_ADDR);
        sleep(5000);

        // 选中移除操作，并点击
        webDriver.findElement(By.cssSelector("#info > tr > td:nth-child(4) > button")).click();
        sleep(3000);

        // 接收弹窗
        Alert alert = webDriver.switchTo().alert();
        alert.accept();
        sleep(3000);

        // 截屏
        File file = ((TakesScreenshot) (webDriver)).getScreenshotAs(OutputType.FILE);
        // 把截屏保存到photo文件中
        FileUtils.copyFile(file, new File("D:\\Java_Code\\java_code\\music-auto-test\\src\\photo\\cancelCollection.png"));

        // 校验
        // 检验跳转的 URL 是否跳转正确
        String currentUrl = webDriver.getCurrentUrl();
        Assertions.assertEquals(MUSIC_LIST_ADDR, currentUrl);
    }

    // 测试喜欢列表按钮
    @Order(6)
    @Test
    void collectionList() throws InterruptedException, IOException {
        // 打开音乐列表页
        webDriver.get(MUSIC_LIST_ADDR);
        sleep(3000);

        // 选择喜欢列表按钮，并点击
        webDriver.findElement(By.cssSelector("#body > div.container > div:nth-child(3) > a:nth-child(1)")).click();
        sleep(2000);

        // 截屏
        File file = ((TakesScreenshot) (webDriver)).getScreenshotAs(OutputType.FILE);
        // 把截屏保存到photo文件中
        FileUtils.copyFile(file, new File("D:\\Java_Code\\java_code\\music-auto-test\\src\\photo\\collectionList.png"));

        // 校验
        String curUrl = webDriver.getCurrentUrl();
        Assertions.assertEquals(MUSIC_COLLECTION_LIST_ADDR, curUrl);
    }

    // 测试添加音乐成功测试
    @Order(7)
    @Test
    void uploadMusicSuccess() throws InterruptedException, IOException {
        // 打开音乐首页
        webDriver.get(MUSIC_LIST_ADDR);
        sleep(3000);

        // 选中添加歌曲按钮，并点击
        webDriver.findElement(By.cssSelector("#body > div.container > div:nth-child(3) > a:nth-child(2)")).click();
        sleep(2000);

        // 截屏
        File file = ((TakesScreenshot) (webDriver)).getScreenshotAs(OutputType.FILE);
        // 把截屏保存到photo文件中
        FileUtils.copyFile(file, new File("D:\\Java_Code\\java_code\\music-auto-test\\src\\photo\\clickUpload.png"));

        // 选中文件上传按钮，并上传你要上传的文件
        WebElement uploadDocument = webDriver.findElement(By.cssSelector("body > form > input[type=file]:nth-child(1)"));
        String musicName = "许巍 - 故乡.mp3";
        uploadDocument.sendKeys("D:\\CloudMusic\\" + musicName);
        sleep(2000);

        // 选中歌手名输入框，输入歌手名
        webDriver.findElement(By.cssSelector("body > form > label > input[type=text]")).sendKeys("许巍");
        sleep(2000);

        // 截屏
        File file1 = ((TakesScreenshot) (webDriver)).getScreenshotAs(OutputType.FILE);
        // 把截屏保存到photo文件中
        FileUtils.copyFile(file1, new File("D:\\Java_Code\\java_code\\music-auto-test\\src\\photo\\uploadInfo.png"));

        // 选中上传按钮，并点击上传
        webDriver.findElement(By.cssSelector("body > form > input[type=submit]:nth-child(3)")).click();
        sleep(2000);

        // 截屏
        File file2 = ((TakesScreenshot) (webDriver)).getScreenshotAs(OutputType.FILE);
        // 把截屏保存到photo文件中
        FileUtils.copyFile(file2, new File("D:\\Java_Code\\java_code\\music-auto-test\\src\\photo\\uploadSuccess.png"));

        // 校验
        // 1.判断上传后的网址是否跳转
        String curUrl = webDriver.getCurrentUrl();
        Assertions.assertEquals(MUSIC_LIST_ADDR, curUrl);

        // 2.判断添加的歌曲名，是否存在音乐列表中并可以播放
        List<WebElement> elements = webDriver.findElements(By.cssSelector("#info > td"));
        // 判断歌曲名是否存在音乐列表中
        for (WebElement element : elements) {
            Assertions.assertEquals(musicName, element.getText());
        }
    }


    // 添加音乐失败测试
    @Order(8)
    @Test
    void uploadMusicFail() throws InterruptedException, IOException {
        // 打开音乐首页
        webDriver.get(MUSIC_LIST_ADDR);
        sleep(3000);

        // 选中添加歌曲按钮，并点击
        webDriver.findElement(By.cssSelector("#body > div.container > div:nth-child(3) > a:nth-child(2)")).click();
        sleep(2000);

        // 选中文件上传按钮，并上传你要上传的文件
        WebElement uploadDocument = webDriver.findElement(By.cssSelector("body > form > input[type=file]:nth-child(1)"));
        uploadDocument.sendKeys("D:\\CloudMusic\\许巍 - 故乡.mp3");
        sleep(2000);

        // 选中歌手名输入框，输入歌手名
        webDriver.findElement(By.cssSelector("body > form > label > input[type=text]")).sendKeys("许巍");
        sleep(2000);

        // 选中上传按钮，并点击上传
        webDriver.findElement(By.cssSelector("body > form > input[type=submit]:nth-child(3)")).click();
        sleep(2000);

        // 截屏
        File file = ((TakesScreenshot) (webDriver)).getScreenshotAs(OutputType.FILE);
        // 把截屏保存到photo文件中
        FileUtils.copyFile(file, new File("D:\\Java_Code\\java_code\\music-auto-test\\src\\photo\\uploadFail.png"));

        // 校验
        // 1.判断上传后的网址是否跳转
        String curUrl = webDriver.getCurrentUrl();
        Assertions.assertNotEquals(MUSIC_LIST_ADDR, curUrl);

        // 2.获取错误信息
        String text = webDriver.findElement(By.cssSelector("body > pre")).getText();
        System.out.println("错误信息：" + text);
    }

    // 搜索音乐成功测试
    @Order(9)
    @Test
    void searchMusicSuccess() throws InterruptedException, IOException {
        // 打开音乐列表页
        webDriver.get(MUSIC_LIST_ADDR);
        sleep(3000);

        // 选中搜索输入框，并输入内容“纸短情长”
        webDriver.findElement(By.cssSelector("#exampleInputName2")).sendKeys("纸短情长");
        sleep(3000);

        // 选中查询按钮，进行查询
        webDriver.findElement(By.cssSelector("#submit1")).click();
        sleep(2000);

        // 截屏
        File file = ((TakesScreenshot) (webDriver)).getScreenshotAs(OutputType.FILE);
        // 把截屏保存到photo文件中
        FileUtils.copyFile(file, new File("D:\\Java_Code\\java_code\\music-auto-test\\src\\photo\\searchSuccess.png"));

        // 校验
        // 判断是否存在搜索的内容，存在则说明elements不为空，测试通过
        List<WebElement> elements = webDriver.findElements(By.cssSelector("#info > td"));
        for (WebElement element : elements) {
            Assertions.assertNotNull(element);
        }
    }

    // 搜索音乐成功失败
    @Order(10)
    @Test
    void searchMusicFail() throws InterruptedException, IOException {
        // 打开音乐列表页
        webDriver.get(MUSIC_LIST_ADDR);
        sleep(3000);

        // 选中搜索输入框，并输入内容“过往”
        webDriver.findElement(By.cssSelector("#exampleInputName2")).sendKeys("过往");
        sleep(3000);

        // 选中查询按钮，进行查询
        webDriver.findElement(By.cssSelector("#submit1")).click();
        sleep(2000);

        // 截屏
        File file = ((TakesScreenshot) (webDriver)).getScreenshotAs(OutputType.FILE);
        // 把截屏保存到photo文件中
        FileUtils.copyFile(file, new File("D:\\Java_Code\\java_code\\music-auto-test\\src\\photo\\searchFail.png"));

        // 校验
        // 判断是否存在搜索的内容，不存在则说明elements为空，测试通过
        List<WebElement> elements = webDriver.findElements(By.cssSelector("#info > td"));
        for (WebElement element : elements) {
            Assertions.assertNull(element);
        }
    }

    // 删除成功测试
    @Order(11)
    @Test
    void deleteMusic() throws InterruptedException, IOException {
        // 打开音乐列表页
        webDriver.get(MUSIC_LIST_ADDR);
        sleep(3000);

        // 选中删除按钮，并点击
        // 获取当前的音乐个数
        List<WebElement> preElements = webDriver.findElements(By.cssSelector("#info > tr"));
        webDriver.findElement(By.cssSelector("#info > tr:nth-child(1) > td:nth-child(5) > button:nth-child(1)")).click();
        sleep(3000);

        // 接收弹窗
        Alert alert = webDriver.switchTo().alert();
        alert.accept();

        // 截屏
        File file = ((TakesScreenshot) (webDriver)).getScreenshotAs(OutputType.FILE);
        // 把截屏保存到photo文件中
        FileUtils.copyFile(file, new File("D:\\Java_Code\\java_code\\music-auto-test\\src\\photo\\delete.png"));

        // 获取当前的音乐个数
        List<WebElement> lastElements = webDriver.findElements(By.cssSelector("#info > tr"));

        // 比较两者的长度是否相等，不相等则说明删除成功
        Assertions.assertNotEquals(lastElements.size(), preElements.size());
    }

    // 批量删除音乐成功测试
    @Order(12)
    @Test
    void deleteBatchesMusic() throws InterruptedException, IOException {
        // 打开音乐列表页
        webDriver.get(MUSIC_LIST_ADDR);
        sleep(5000);

        // 选中所有的input标签
        List<WebElement> elements = webDriver.findElements(By.cssSelector("#info > tr > th > input"));
        System.out.println(elements.size());
        // 获取未删除之前的音乐数量
        List<WebElement> preMusicCount = webDriver.findElements(By.cssSelector("#info > tr"));
        sleep(5000);

        // 勾选要删除的歌曲
        for (WebElement element : elements) {
            if (element.getAttribute("type").equals("checkbox")) {
                element.click();
            }
        }
        sleep(5000);

        // 点击批量删除按钮
        webDriver.findElement(By.cssSelector("#delete")).click();
        sleep(3000);

        // 接收窗口
        Alert alert = webDriver.switchTo().alert();
        alert.accept();
        sleep(2000);

        // 截屏
        File file = ((TakesScreenshot) (webDriver)).getScreenshotAs(OutputType.FILE);
        // 把截屏保存到photo文件中
        FileUtils.copyFile(file, new File("D:\\Java_Code\\java_code\\music-auto-test\\src\\photo\\someDelete.png"));

        // 获取删除之后的音乐数量
        List<WebElement> lastMusicCount = webDriver.findElements(By.cssSelector("#info > tr"));

        // 校验，不一样则说明成功
        Assertions.assertNotEquals(preMusicCount.size(), lastMusicCount);
    }

    // 登录失败测试
    @Order(13)
    @ParameterizedTest
    @CsvSource({"'bit', '12345'"})
    void loginFail(String username, String password) throws InterruptedException, IOException {
        // 打开登录页面
        webDriver.get(MUSIC_LOGIN_ADDR);
        sleep(3000);

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

        // 截屏
        File file = ((TakesScreenshot) (webDriver)).getScreenshotAs(OutputType.FILE);
        // 把截屏保存到photo文件中
        FileUtils.copyFile(file, new File("D:\\Java_Code\\java_code\\music-auto-test\\src\\photo\\loginFail.png"));


        // 校验
        // 校验是否回到登录页面
        String currentUrl = webDriver.getCurrentUrl();
        Assertions.assertEquals(MUSIC_LOGIN_ADDR, currentUrl);
    }
}