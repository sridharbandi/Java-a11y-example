package io.github.sridharbandi;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import io.github.sridharbandi.modal.htmlcs.Issues;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

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
    public void stockTest() {
        driver.get("https://www.istockphoto.com/");
    }
}