package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasePage {
    WebDriver driver;
    String pageUrl = "https://opensource-demo.orangehrmlive.com/";

    public WebElement userNameFieldSelector = driver.findElement(By.xpath("//*[@id='app']/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/div[2]/input"));
    public WebElement passwordFieldSelector = driver.findElement(By.xpath("//*[@id='app']/div[1]/div/div[1]/div/div[2]/div[2]/form/div[2]/div/div[2]/input"));

    public void enterUserName(){
        userNameFieldSelector.sendKeys("Admin");
    }
    public void enterPassword(){
        passwordFieldSelector.sendKeys("admin123");
    }

    @BeforeClass(alwaysRun = true)
    public void beforeClass() throws InterruptedException {
        driver = new ChromeDriver();
        driver.get(pageUrl);
        Thread.sleep(10000);
        enterUserName();
        Thread.sleep(5000);
        enterPassword();
        Thread.sleep(5000);
    }

    @AfterClass(alwaysRun = true)
    public void afterClass(){
        driver.quit();
    }

}
