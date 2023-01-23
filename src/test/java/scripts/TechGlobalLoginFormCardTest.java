package scripts;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.TechGlobalFrontendTestingHomePage;
import pages.TechGlobalLoginFormCardPage;
import utilities.TestData;
import utilities.ValidateLogin;

public class TechGlobalLoginFormCardTest extends TechGlobalBase{

    @BeforeMethod
    public void setPage(){
        techGlobalFrontendTestingHomePage = new TechGlobalFrontendTestingHomePage();
        techGlobalFrontendTestingHomePage.getFrontendTestingPage();
        techGlobalFrontendTestingHomePage.clickOnCard(15);
        techGlobalLoginFormCardPage = new TechGlobalLoginFormCardPage();
    }
       /*
       Test Case 1: Validate TechGlobal Login Form card
        Given user is on https://techglobal-training.netlify.app/
        When user clicks on "Practices" dropdown in the header
        And user select the "Frontend Testing" option
        And user clicks on the "Login Form" card
        Then user should heading1 as “Login Form”
        And user should see “Please enter your username” label and username input box
        And user should see “Please enter your password” label and password input box
        And user should see “LOGIN” button
        And user should see “Forgot Password?” link
        */
    @Test(priority = 1, description = "Validate TechGlobal Login Form card")
    public void validateLoginFormCard(){

        // Validating  heading1 as "Login Form"
        Assert.assertTrue(techGlobalLoginFormCardPage.header.isDisplayed());
        Assert.assertEquals(techGlobalLoginFormCardPage.header.getText(), TestData.heading);

        // Validating that labels are visible and equals "Please enter your username"
        // and "Please enter your password"
        for (int i = 0; i < techGlobalLoginFormCardPage.labels.size(); i++) {
            Assert.assertTrue(techGlobalLoginFormCardPage.labels.get(i).isDisplayed());
            Assert.assertEquals(techGlobalLoginFormCardPage.labels.get(i).getText(),
                    TestData.labelUsernameAndPassword[i]);
        }

        // Validating that input boxes are visible
        for (int i = 0; i < techGlobalLoginFormCardPage.inputs.size(); i++) {
            Assert.assertTrue(techGlobalLoginFormCardPage.inputs.get(i).isDisplayed());
        }

        //Validating that user is able to see "LOGIN" button and click on it
        Assert.assertTrue(techGlobalLoginFormCardPage.loginButton.isDisplayed());
        Assert.assertTrue(techGlobalLoginFormCardPage.loginButton.isEnabled());

        // Validating that forgot password link is visible, clickable nd text equals "Forgot Password?"
        Assert.assertTrue(techGlobalLoginFormCardPage.forgotPasswordLink.isDisplayed());
        Assert.assertTrue(techGlobalLoginFormCardPage.forgotPasswordLink.isEnabled());
        Assert.assertEquals(techGlobalLoginFormCardPage.forgotPasswordLink.getText(), TestData.forgotPasswordLinkText);
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
        Assert.assertTrue(techGlobalLoginFormCardPage.messageAfterSuccessfulLogin.isDisplayed());
        Assert.assertEquals(techGlobalLoginFormCardPage.messageAfterSuccessfulLogin.getText(),
                TestData.massageAfterSuccessfulLogin);
        // Validating that user is able to see logout button
        Assert.assertTrue(techGlobalLoginFormCardPage.logoutButton.isDisplayed());
        Assert.assertTrue(techGlobalLoginFormCardPage.logoutButton.isEnabled());
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
        techGlobalLoginFormCardPage.logoutButton.click();
        // Validating that user navigating back to the Login Form
        Assert.assertEquals(driver.getCurrentUrl(), TestData.loginFormURL);
    }
       /*
       Test Case 6: Validate TechGlobal Login Form card invalid login with wrong username
       Given user is on https://techglobal-training.netlify.app/
       When user clicks on "Practices" dropdown in the header
       And user select the "Frontend Testing" option
       And user clicks on the "Login Form" card
       And user enters username as “john” and password as “Test1234”
       And user clicks on “LOGIN” button
       Then user should see “Invalid Username entered!” message
        */
    @Test(priority = 4,
            description = "Validate TechGlobal Login Form card invalid login with wrong username")
    public void validateLoginWithWrongUsername(){
        ValidateLogin.validateLogin(techGlobalLoginFormCardPage.inputs,TestData.invalidUsernameValidPassword,
                techGlobalLoginFormCardPage.loginButton,techGlobalLoginFormCardPage.errorMessage,
                TestData.errorInvalidUsernameMessage);

    }
        /*
        Test Case 7: Validate TechGlobal Login Form card invalid login with wrong password
        Given user is on https://techglobal-training.netlify.app/
        When user clicks on "Practices" dropdown in the header
        And user select the "Frontend Testing" option
        And user clicks on the "Login Form" card
        And user enters username as “TechGlobal” and password as “1234”
        And user clicks on “LOGIN” button
        Then user should see “Invalid Password entered!” message
        */
    @Test(priority = 5, description = "Validate TechGlobal Login Form card invalid login with wrong password")
    public void validateLoginWithValidUsernameAndInvalidPassword(){
        ValidateLogin.validateLogin(techGlobalLoginFormCardPage.inputs,TestData.validUsernameInvalidPassword,
                techGlobalLoginFormCardPage.loginButton,techGlobalLoginFormCardPage.errorMessage,
                TestData.errorInvalidPasswordMessage);
    }
        /*
        Test Case 8: Validate TechGlobal Login Form card invalid login with both wrong credentials
        Given user is on https://techglobal-training.netlify.app/
        When user clicks on "Practices" dropdown in the header
        And user select the "Frontend Testing" option
        And user clicks on the "Login Form" card
        And user enters username as “john” and password as “1234”
        And user clicks on “LOGIN” button
        Then user should see “Invalid Username entered!” message
             */
    @Test(priority = 6, description = "Validate TechGlobal Login Form card invalid login with both wrong credentials")
    public void validateLoginWithInvalidCredentials(){
        ValidateLogin.validateLogin(techGlobalLoginFormCardPage.inputs,TestData.invalidCredentials,
                techGlobalLoginFormCardPage.loginButton,techGlobalLoginFormCardPage.errorMessage,
                TestData.errorInvalidUsernameMessage);
    }
}
