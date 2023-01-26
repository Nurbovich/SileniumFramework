package advancedLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class XpathDemo {

    WebDriver driver;

    @BeforeEach
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

    }
    @Test
    public void test1() throws InterruptedException {
        driver.get("https://demoqa.com/text-box");
        driver.findElement(By.xpath("//input[@placeholder='Full Name']")).sendKeys("Nurba");
        driver.findElement(By.xpath("//input[@id='userEmail']")).sendKeys("nurba@mail.com");
        driver.findElement(By.xpath("//textarea[@id='currentAddress']")).sendKeys("Bishke");
        driver.findElement(By.xpath("(//textarea[@class='form-control'])[2]")).sendKeys("Baytik");
        driver.findElement(By.xpath("//button[text() = 'Submit']")).click();


        Thread.sleep(5000);
        String nameResul = driver.findElement(By.xpath("//div[@id='output']/div/p[1]")).getText();
        System.out.println(nameResul);
        String currentAdressResult = driver.findElement(By.xpath("/html[1]/body/div[2]/div/div/div[2]/div[2]/div[2]/form/div[6]/div/p[3]")).getText();
        System.out.println(currentAdressResult);
        driver.close();


    }

}
