package kt;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;

public class Test1 {
    WebDriver driver;

    @BeforeClass()
    void setup() {
        driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/");
    }

    @org.testng.annotations.Test
    void LoginApplication() throws InterruptedException {
        Thread.sleep(10000);
        WebElement userField = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/div[2]/input"));
        WebElement passwordField = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[2]/div/div[2]/input"));
        WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]"));
        userField.sendKeys("Admin");
        Thread.sleep(10000);
        passwordField.sendKeys("admin123");
        Thread.sleep(5000);
        loginButton.click();
        Thread.sleep(5000);
    }

    public void tearDown(){
        driver.quit();
    }

}
