import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class Practic {

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
    public void textBox() throws InterruptedException {

        driver.get("https://demoqa.com/text-box");

        Thread.sleep(5000);

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

        Thread.sleep(5000);

    }

    @Test
    public void checkBox() throws InterruptedException {

        driver.get("https://demoqa.com/checkbox");

        Thread.sleep(5000);

        WebElement homeClick = driver.findElement(By.xpath("(//button[@aria-label = 'Toggle'])[1]"));
        homeClick.click();

        WebElement downloadsClick = driver.findElement(By.xpath("(//button[@aria-label = 'Toggle'])[4]"));
        downloadsClick.click();

        WebElement excelFileClick = driver.findElement(By.xpath("(//span[@class = 'rct-checkbox'])[6]"));
        excelFileClick.click();

        Thread.sleep(5000);

    }

    @Test
    public void radioButton() throws InterruptedException {
        driver.get("https://demoqa.com/radio-button");

        Thread.sleep(5000);

        WebElement radioCkick = driver.findElement(By.xpath("(//label[@class = 'custom-control-label'])[1]"));
        radioCkick.click();
        Thread.sleep(5000);
    }

    @Test
    public void webTables() throws InterruptedException {
        driver.get("https://demoqa.com/webtables");

        Thread.sleep(5000);

        WebElement addClick = driver.findElement(By.id("addNewRecordButton"));
        addClick.click();

        Thread.sleep(5000);

        WebElement firstName = driver.findElement(By.id("firstName"));
        firstName.sendKeys("Nurba");
        WebElement lastName = driver.findElement(By.id("lastName"));
        lastName.sendKeys("Nurbovich");
        WebElement email = driver.findElement(By.id("userEmail"));
        email.sendKeys("123@mail.ru");
        WebElement age = driver.findElement(By.id("age"));
        age.sendKeys("333");
        WebElement salary = driver.findElement(By.id("salary"));
        salary.sendKeys("2000");
        WebElement department = driver.findElement(By.id("department"));
        department.sendKeys("Admin");
        WebElement submitclick = driver.findElement(By.id("submit"));
        submitclick.click();

        Thread.sleep(5000);
    }
    @Test
    public void testDoubleClick() throws InterruptedException {
        driver.get("https://demoqa.com/buttons");
        Thread.sleep(5000);
        WebElement doubleClickButton = driver.findElement(By.id("doubleClickBtn"));
        actions.doubleClick(doubleClickButton).perform();
        Thread.sleep(5000);
    }
    @Test
    public void testRightClick() throws InterruptedException {

        driver.get("https://demoqa.com/buttons");
        Thread.sleep(5000);

        WebElement rightClickBtn = driver.findElement(By.id("rightClickBtn"));
        actions.contextClick(rightClickBtn).perform();

        Thread.sleep(5000);
    }
    @Test
    public void testSimpleClick() throws InterruptedException {

        driver.get("https://demoqa.com/buttons");
        WebElement simpleClick = driver.findElement(By.xpath("//button[text() = 'Click Me']"));
        actions.click(simpleClick).perform();
        Thread.sleep(5000);
    }
    @Test
    public void links(){
        driver.get("https://demoqa.com/links");
        WebElement home = driver.findElement(By.id("simpleLink"));
        home.click();
    }
    @AfterEach
    public void closeBrowser(){
        driver.close();
    }
}
