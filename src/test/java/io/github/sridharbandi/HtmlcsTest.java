package io.github.sridharbandi;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.IOException;
import java.time.Duration;

/**
 * A sample test to demonstrate
 */
public class HtmlcsTest {

    private WebDriver driver;
    private static HtmlCsRunner htmlCsRunner;

    @BeforeEach
    public void beforeTest() {
        ChromeDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
        driver.manage().window().fullscreen();
        htmlCsRunner = new HtmlCsRunner(driver);

    }

    @AfterEach
    public void tearDown() throws IOException {
        htmlCsRunner.execute();
        driver.quit();
    }

    @AfterAll
    public static void generateReport() throws IOException {
        htmlCsRunner.generateHtmlReport();
    }

    @Test
    public void googleTest() {
        driver.get("https://www.google.com/");
    }

    @Test
    public void githubTest() {
        driver.get("https://github.com/sridharbandi/Java-a11y/issues/25");
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        String htmlcs = Reader.getInstance().getHTMLCS();
        javascriptExecutor.executeScript(htmlcs);
    }
}