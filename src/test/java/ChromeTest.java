import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxDriverLogLevel;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.slf4j.Logger;

import io.github.bonigarcia.wdm.WebDriverManager;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ChromeTest {
    WebDriver driver;

    @BeforeAll
    static void setupAll(){
        WebDriverManager.chromedriver().setup();
    }
    @BeforeEach
    void setup(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--no-sandbox");
        options.addArguments("--headless");
        driver = new ChromeDriver(options);
    }
    AfterEach
    void teardown(){
        driver.quit();

    }
    @Test shouldTest1()throws InterruptedException{
        driver.get("http:localhost:7777");
        Thread.sleep(6000);
        driver.findElement(By.cssSelector("[data-test-id=name] input")).sendKeys("Nina Werty");
        driver.findElement(By.cssSelector("[data-test-id=phone] input")).sendKeys("+79583749899");
        driver.findElement(By.cssSelector("[data-test-id=agreement] input")).click();
        driver.findElement(By.className("button")).click();
        String expected = "ok";
        String actual = driver.findElement(By.cssSelector("[oh]")).getText().trim();
        assertEquals(expected,actual);
    }
}
