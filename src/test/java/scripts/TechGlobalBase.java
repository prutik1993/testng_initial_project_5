package scripts;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.*;
import utilities.ConfigReader;
import utilities.Driver;

public class TechGlobalBase {
    WebDriver driver;
    TechGlobalBasePage techGlobalBasePage;
    TechGlobalLoginFormCardPage techGlobalLoginFormCardPage;
    TechGlobalFrontendTestingHomePage techGlobalFrontendTestingHomePage;
    TechGlobalResetPasswordPage techGlobalResetPasswordPage;
    TechGlobalLoginFormPage techGlobalLoginFormPage;



    @BeforeMethod
    public void setup(){
     driver = Driver.getDriver();
     driver.get(ConfigReader.getProperty("appURL"));
     techGlobalBasePage = new TechGlobalBasePage();

    }

    @AfterMethod
    public void teardown(){
        Driver.quitDriver();
    }
}
