package kt;

import base.TestGroups;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Test1 {
    WebDriver driver;

    @BeforeClass(alwaysRun = true)
    void setup() throws InterruptedException {
        driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/");
        Thread.sleep(10000);
        WebElement userNameField = driver.findElement(By.xpath("//*[@id='app']/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/div[2]/input"));
        WebElement passwordField = driver.findElement(By.xpath("//*[@id='app']/div[1]/div/div[1]/div/div[2]/div[2]/form/div[2]/div/div[2]/input"));
        WebElement loginButton = driver.findElement(By.xpath("//*[@id='app']/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]"));
        userNameField.sendKeys("Admin");
        Thread.sleep(10000);
        passwordField.sendKeys("admin123");
        Thread.sleep(5000);
        loginButton.click();
        Thread.sleep(5000);
    }

    @Test(testName = "test1", priority = 1, groups = {TestGroups.SMOKE})
    public void test1() {
        System.out.println("test1");
    }

    @Test(testName = "test2", priority = 1, groups = {TestGroups.REGRESSION})
    public void test2() {
        System.out.println("test2");
    }

    @AfterClass(alwaysRun = true)
    public void tearDown(){
        driver.quit();
    }

}
