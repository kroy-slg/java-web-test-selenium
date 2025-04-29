package kt;

import base.TestGroups;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.LoginPage;
import utils.DriverManager;

public class InvalidLoginTest {
    WebDriver driver;
    LoginPage loginPage;
    BasePage basePage;

    @BeforeClass
    public void beforeClass() {
//        todo: initialize all page which are used for tc
//        todo: beforeClass
        basePage = new BasePage(DriverManager.getDriver());
        loginPage = new LoginPage(DriverManager.getDriver());
        basePage.beforeClass();
    }

    @BeforeMethod
    public void beforeMethod(){
//        todo: Test Data setup for tc
    }

    @Test(testName = "test to check login functionality with wrong credentials", groups = {TestGroups.SHAKEOUT}, priority = 1)
    public void loginTest() {
//        todo: logic for tc - not completed
        loginPage.loginApp();
        System.out.println("Login successfully");
    }

    @AfterClass
    public void afterClass() {
        basePage.afterClass();
        if (driver != null) {
            driver.quit();
        }
    }
}
