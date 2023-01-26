package advancedMousInteractions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class PracticeActions {

    WebDriver driver;
    Actions actions;

    @BeforeEach
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/buttons");
        actions = new Actions(driver);

    }

    @Test
    public void testDoubleClick() throws InterruptedException {

        WebElement doubleClickButton = driver.findElement(By.id("doubleClickBtn"));
        actions.doubleClick(doubleClickButton).perform();

        WebElement doubleClickMessage = driver.findElement(By.id("doubleClickMessage"));

        Assertions.assertTrue(doubleClickMessage.getText().contains("You have done a double click"));
        Thread.sleep(5000);
    }

    @Test
    public void testRightClick() throws InterruptedException {

        WebElement rightClickBtn = driver.findElement(By.id("rightClickBtn"));
        actions.contextClick(rightClickBtn).perform();

        WebElement rightClickMessage = driver.findElement(By.id("rightClickMessage"));

        Assertions.assertTrue(rightClickMessage.getText().contains("You have done a right click"));
        Thread.sleep(5000);
    }
    @Test
    public void testSimpleClick() throws InterruptedException {
        WebElement simpleClick = driver.findElement(By.xpath("//button[text() = 'Click Me']"));
        actions.click(simpleClick).perform();
        Thread.sleep(5000);
    }
    @AfterEach
    public void closeBrowser(){
        driver.close();
    }

}
