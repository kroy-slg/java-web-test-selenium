package kt;

import base.TestGroups;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.BasePage;
import utils.DriverManager;

public class LoginFeatureTest {
    WebDriver driver;
    private BasePage basePage;

    @BeforeClass
    public void beforeClass() {
        basePage = new BasePage(DriverManager.getDriver());
        basePage.beforeSuite();
    }

    @Test(testName = "test to check login functionality", groups = {TestGroups.SHAKEOUT}, priority = 2)
    public void loginTest() {
        basePage.loginApp();
        System.out.println("Login successfully");
    }

    @AfterClass
    public void afterClass() {
        basePage.afterSuite();
        if (driver != null) {
            driver.quit();
        }
    }
}
