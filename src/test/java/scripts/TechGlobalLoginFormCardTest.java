package scripts;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.TechGlobalFrontendTestingHomePage;
import pages.TechGlobalLoginFormCardPage;
import utilities.TestData;

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






}
