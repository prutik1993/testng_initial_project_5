package scripts;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.TechGlobalFrontendTestingHomePage;
import pages.TechGlobalLoginFormCardPage;
import pages.TechGlobalLoginFormPage;
import utilities.TestData;

public class TechGlobalLoginFormTest extends TechGlobalBase{

    @BeforeMethod
    public void setPage(){
        techGlobalFrontendTestingHomePage = new TechGlobalFrontendTestingHomePage();
        techGlobalFrontendTestingHomePage.getFrontendTestingPage();
        techGlobalFrontendTestingHomePage.clickOnCard(15);
        techGlobalLoginFormCardPage = new TechGlobalLoginFormCardPage();
        techGlobalLoginFormPage = new TechGlobalLoginFormPage();
    }

    /*
    Test Case 2: Validate TechGlobal Login Form card valid login
    Given user is on https://techglobal-training.netlify.app/
    When user clicks on "Practices" dropdown in the header
    And user select the "Frontend Testing" option
    And user clicks on the "Login Form" card
    And user enters username as “TechGlobal” and password as “Test1234”
    And user clicks on “LOGIN” button
    Then user should see “You are logged in” message
    And user should see “LOGOUT” button
     */

    @Test(priority = 2, description = "Validate TechGlobal Login Form card valid login")
    public void validateLoginWithValidCredentials() {

        // User enters valid credentials
        for (int i = 0; i < techGlobalLoginFormCardPage.inputs.size(); i++) {
            techGlobalLoginFormCardPage.inputs.get(i).sendKeys(TestData.validCredentials[i]);
        }
        // User clicks on the Login button
        techGlobalLoginFormCardPage.loginButton.click();
        // Validating that "You are logged in" message is visible
        Assert.assertTrue(techGlobalLoginFormPage.messageAfterSuccessfulLogin.isDisplayed());
        Assert.assertEquals(techGlobalLoginFormPage.messageAfterSuccessfulLogin.getText(),
                TestData.massageAfterSuccessfulLogin);
        // Validating that user is able to see logout button
        Assert.assertTrue(techGlobalLoginFormPage.logoutButton.isDisplayed());
        Assert.assertTrue(techGlobalLoginFormPage.logoutButton.isEnabled());
    }

    /*
    Test Case 3: Validate TechGlobal Login Form card valid login and then logout
    Given user is on https://techglobal-training.netlify.app/
    When user clicks on "Practices" dropdown in the header
    And user select the "Frontend Testing" option
    And user clicks on the "Login Form" card
    And user enters username as “TechGlobal” and password as “Test1234”
    And user clicks on “LOGIN” button
    And user clicks on “LOGOUT” button
    Then user should be navigated back to Login Form
     */

    @Test(priority = 3, description = "Validate TechGlobal Login Form card valid login and then logout")
    public void validateLoginWithValidCredentialsAndThanLogout(){
        // User enters valid credentials
        for (int i = 0; i < techGlobalLoginFormCardPage.inputs.size(); i++) {
            techGlobalLoginFormCardPage.inputs.get(i).sendKeys(TestData.validCredentials[i]);
        }
        // User clicks on the Login button
        techGlobalLoginFormCardPage.loginButton.click();
        // User clicks on the Logout button
        techGlobalLoginFormPage.logoutButton.click();
        // Validating that user navigating back to the Login Form
        Assert.assertEquals(driver.getCurrentUrl(), TestData.loginFormURL);
    }
}
