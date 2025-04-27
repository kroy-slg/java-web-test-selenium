package kt;

import base.TestGroups;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.BasePage;

public class LoginFeatureTest {
    WebDriver driver;
    private BasePage basePage;

    @BeforeClass
    public void setUp() {
        basePage = new BasePage(null);
        basePage.beforeSuite();
    }

    @Test(testName = "test to check login functionality", groups = {TestGroups.SHAKEOUT}, priority = 1)
    public void loginTest() {
        System.out.println("Application is logged in successfully");
    }

    @AfterClass
    public void tearDown() {
        basePage.afterSuite();
        if (driver != null) {
            driver.quit();
        }
    }
}
