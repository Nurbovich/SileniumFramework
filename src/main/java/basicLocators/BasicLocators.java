package basicLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BasicLocators {

    @Test
    public void findIdTest(){

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/text-box");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement fullNameInputField = driver.findElement(By.id("userName"));
        fullNameInputField.sendKeys("Nurba");

        WebElement emailInputField = driver.findElement(By.id("userEmail"));
        emailInputField.sendKeys("ankanatbekovich@gmail.com");

        WebElement currentAddressInputField = driver.findElement(By.id("currentAddress"));
        currentAddressInputField.sendKeys("Bishkek");

        WebElement permanentAddressInputField = driver.findElement(By.id("permanentAddress"));
        permanentAddressInputField.sendKeys("Baytik");

        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();

        String expectedNameResult = "Name:Nurba";
        WebElement actualName = driver.findElement(By.id("name"));
        Assertions.assertEquals(expectedNameResult, actualName.getText());

        String expectedEmailResult = "Email:ankanatbekovich@gmail.com";
        WebElement actualEmail = driver.findElement(By.id("email"));
        Assertions.assertEquals(expectedEmailResult, actualEmail.getText());

        String expectedCurrentAddressResult = "Current Address :Bishkek";
        WebElement actualCurrentAddress = driver.findElement(By.xpath("//*[@id='output']/div/p[3]"));
        System.out.println(actualCurrentAddress.getText());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assertions.assertEquals(expectedCurrentAddressResult, actualCurrentAddress.getText());

        String expectedPermanentAddress = "Permananet Address :Baytik";
        WebElement actualPermanentAddress = driver.findElement(By.xpath("//*[@id='output']/div/p[4]"));
        Assertions.assertEquals(expectedPermanentAddress, actualPermanentAddress.getText());

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.close();
    }

    @Test
    public void findByLinkText(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://www.google.com");

        WebElement gmailLink = driver.findElement(By.linkText("Почта"));
        gmailLink.click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.close();

    }
    @Test
    public void findByClass(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/text-box");

        WebElement iFeelLucky = driver.findElement(By.className("main-header"));
        System.out.println(iFeelLucky.getText());

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.close();


    }
    @Test
    public void findByTagName(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/text-box");

    }
}
