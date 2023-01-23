package scripts;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.TechGlobalFrontendTestingHomePage;
import pages.TechGlobalLoginFormCardPage;
import pages.TechGlobalResetPasswordPage;
import utilities.TestData;

public class TechGlobalResetPasswordTest extends TechGlobalBase{

    @BeforeMethod
    public void setPage(){
        techGlobalFrontendTestingHomePage = new TechGlobalFrontendTestingHomePage();
        techGlobalFrontendTestingHomePage.getFrontendTestingPage();
        techGlobalFrontendTestingHomePage.clickOnCard(15);
        techGlobalLoginFormCardPage = new TechGlobalLoginFormCardPage();
        techGlobalResetPasswordPage = new TechGlobalResetPasswordPage();

        // User clicks on "Forgot password link"
        techGlobalLoginFormCardPage.forgotPasswordLink.click();
    }
    /*
    Test Case 4: Validate TechGlobal Login Form card Forgot Password? Link and Reset Password page
    Given user is on https://techglobal-training.netlify.app/
    When user clicks on "Practices" dropdown in the header
    And user select the "Frontend Testing" option
    And user clicks on the "Login Form" card
    And user clicks on “Forgot Password?” link
    Then user should see “Reset Password” heading1
    And user should see “Enter your email address, and we'll send you a link to reset your password.” message
    And user should see email input box
    And user should see “SUBMIT” button
     */
    @Test(priority = 1, description = "Validate TechGlobal Login Form card Forgot Password? " +
            "Link and Reset Password page")
    public void validateForgotPasswordLink(){
        // Validating that "Reset Password" heading1 is visible
        Assert.assertTrue(techGlobalResetPasswordPage.resetPasswordText.isDisplayed());
        Assert.assertEquals(techGlobalResetPasswordPage.resetPasswordText.getText(), TestData.resetPasswordText);
        //Validate that user is able to see "Enter your email address and we'll send you a link to reset
        //    your password" message
        Assert.assertTrue(techGlobalResetPasswordPage.heading2.isDisplayed());
        Assert.assertEquals(techGlobalResetPasswordPage.heading2.getText(),
                TestData.forgetPasswordMessage);
        // Validate if email box is visible and clickable
        Assert.assertTrue(techGlobalResetPasswordPage.emailBox.isDisplayed());
        Assert.assertTrue(techGlobalResetPasswordPage.emailBox.isEnabled());
        //Validate that submit button is visible and clickable
        Assert.assertTrue(techGlobalResetPasswordPage.submitButton.isDisplayed());
        Assert.assertTrue(techGlobalResetPasswordPage.submitButton.isEnabled());
        Assert.assertEquals(techGlobalResetPasswordPage.submitButton.getText(), TestData.submitButton);
    }
    /*
    Test Case 5: Validate TechGlobal Login Form card Reset Password link
    Given user is on https://techglobal-training.netlify.app/
    When user clicks on "Practices" dropdown in the header
    And user select the "Frontend Testing" option
    And user clicks on the "Login Form" card
    And user clicks on “Forgot Password?” link
    When user enters a valid email to email input box
    And user clicks on “SUBMIT” button
    Then user should see “A link to reset your password has been sent to your email
    address.” message
     */
    @Test(priority = 2, description = "Validate TechGlobal Login Form card Reset Password link")
    public void validateResetPasswordLink(){
        // User enters valid email
        techGlobalResetPasswordPage.emailBox.sendKeys(TestData.validEmail);
        // User clicks on SUBMIT button
        techGlobalResetPasswordPage.submitButton.click();
        // Validating if conformation message is displayed
        Assert.assertTrue(techGlobalResetPasswordPage.conformationMessage.isDisplayed());
        Assert.assertEquals(techGlobalResetPasswordPage.conformationMessage.getText(), TestData.conformationMessage);
    }
}
