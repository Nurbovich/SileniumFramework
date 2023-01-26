package widowHandler;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class testWindow {

    WebDriver driver;

    Actions actions;



    @BeforeEach
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        actions = new Actions(driver);
        driver.navigate().to("https://demoqa.com/browser-windows");
    }
    @Test
    public void newTabTest(){

        String HendleBefore = driver.getWindowHandle();
        driver.findElement(By.xpath("//button[@id='tabButton']")).click();
        for (String Handle : driver.getWindowHandles()){
            driver.switchTo().window(Handle);
        }
        driver.findElement(By.linkText("...")).click();
        driver.switchTo().window(HendleBefore);
    }
    @Test
    public void newTab(){

        driver.navigate().to("https://demoqa.com/browser-windows");
        String pageHanlde = driver.getWindowHandle();
        WebElement newTab = driver.findElement(By.id("tabButton"));
        for (int i = 0; i < 4; i++){
            newTab.click();
            driver.switchTo().window(pageHanlde);
        }

    }
    @Test
    public void newHTML(){
        driver.navigate().to("https://demoqa.com/frames");
        WebElement frame1 =   driver.findElement(By.id("frame1"));
        driver.switchTo().frame(frame1);
        WebElement text = driver.findElement(By.id("sampleHeading"));
        System.out.println(text.getText());
        driver.switchTo().defaultContent();
        driver.switchTo().frame(0);
        System.out.println(driver.findElement(By.id("framesWrapper")).getText());

    }


}
