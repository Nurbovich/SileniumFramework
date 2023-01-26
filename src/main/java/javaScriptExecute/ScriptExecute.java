package javaScriptExecute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class ScriptExecute {
    WebDriver driver;

    Actions actions;



    @BeforeEach
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        actions = new Actions(driver);
    }

    @Test
            public void test22() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String s = "https://www.amazon.com =  ";
        String scrpt = "windows.location = \' " + s + " \'";
        js.executeScript(scrpt);
        System.out.println("page navigate to: " + driver.getTitle());
        js.executeScript("window.scrollBy(0,5000)", "");
        Thread.sleep(10000);
        WebElement conditionsOfLinks = driver.findElement(By.xpath("//a[text()='Conditions of Use']"));
        js.executeScript("arguments[0].click();", conditionsOfLinks);
        Thread.sleep(5000);
        driver.close();
    }
}
