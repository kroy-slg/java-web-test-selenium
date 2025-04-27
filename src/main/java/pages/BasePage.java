package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import utils.DriverManager;
import java.util.logging.Logger;

public class BasePage {
    protected WebDriver driver;
    protected WebElement pageRefObject;
    LoginPage loginPage;
    String baseUrl = "https://opensource-demo.orangehrmlive.com/";

    private static final Logger logger = Logger.getLogger(BasePage.class.getName());

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    @BeforeSuite
    public void beforeSuite() {
        loginPage = new LoginPage(DriverManager.getDriver());
        DriverManager.getDriver().get(baseUrl);
    }

    @AfterSuite
    public void afterSuite() {
        DriverManager.quitDriver();
    }

    /**
     * Method to login
     */
    public void loginApp(){
        loginPage = new LoginPage(DriverManager.getDriver());
        loginPage.enterUserName();
        loginPage.enterPassword();
        loginPage.clickLogin();
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
