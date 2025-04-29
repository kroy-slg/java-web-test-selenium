package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import utils.DriverManager;
import java.util.logging.Logger;

public class BasePage {
    protected WebDriver driver;
    protected WebElement pageRefObject;
    BaseTest baseTest;

    private static final Logger logger = Logger.getLogger(BasePage.class.getName());

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    @BeforeClass
    public void beforeClass() {
        baseTest = new BaseTest();
        baseTest.beforeSuite();
    }

    @AfterClass
    public void afterClass() {
        DriverManager.quitDriver();
    }

    /**
     * Method to verify isValid
     */
    public boolean isValid() {
        WebElement element = pageRefObject;
        try {
            return (element != null && element.isDisplayed());
        } catch (Exception e) {
            logger.severe("Error while checking element validity: " + e.getMessage());
            return false;
        }
    }
}
