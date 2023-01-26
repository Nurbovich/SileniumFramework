package seleniumintro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Demo {


    @Test
    public void testNambaFoodTitle() {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://nambafood.kg/");
        System.out.println(driver.getTitle());

        String expectedTitle = "Namba Food — круглосуточная служба доставки №1 в Бишкеке";
        Assertions.assertEquals(expectedTitle,driver.getTitle());

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.close();
    }

    @Test
    public void testGoogleSearch(){

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://google.com/");
        WebElement searchInputField = driver.findElement(By.name("q"));
        searchInputField.sendKeys("Iphone");
        searchInputField.sendKeys(Keys.ENTER);
        driver.close();
    }

}
