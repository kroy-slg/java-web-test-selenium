package pages;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;
import utils.DriverManager;

import java.util.Properties;
import java.io.FileInputStream;
import java.io.IOException;

public class BaseTest {

    protected static Properties config;

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("===== Setting up the Test Suite =====");

        // Load configuration
        config = new Properties();
        try {
            FileInputStream fis = new FileInputStream("src/test/resources/config/config.properties");
            config.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load config file.");
        }

        // Setup WebDriverManager - chrome driver
        DriverManager.getDriver().get(config.getProperty("base.url"));

        // Optional: initialize reporting or logging
        System.out.println("Config loaded: Base URL = " + config.getProperty("base.url"));
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("===== Tearing down the Test Suite =====");
        // Optional: Finalize reports, clean up
    }
}
