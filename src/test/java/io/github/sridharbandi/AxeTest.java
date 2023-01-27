package io.github.sridharbandi;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
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
public class AxeTest {

    private WebDriver driver;
    private static AxeRunner axeRunner;

    @BeforeEach
    public void beforeTest() {
        ChromeDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
        driver.manage().window().fullscreen();
        axeRunner = new AxeRunner(driver);

    }

    @AfterEach
    public void tearDown() throws IOException {
        axeRunner.execute();
        driver.quit();
    }

    @AfterAll
    public static void generateReport() throws IOException {
        axeRunner.generateHtmlReport();
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