package utilities;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class ValidateLogin {
    public static void validateLogin(List<WebElement> elements, String[] credentials, WebElement submitButton,
                                     WebElement errorMessage, String errorMessageText){
        // User enters invalid username and valid password
        for (int i = 0; i < elements.size(); i++) {
            elements.get(i).sendKeys(credentials[i]);
        }
        submitButton.click();
        Assert.assertTrue(errorMessage.isDisplayed());
        Assert.assertEquals(errorMessage.getText(), errorMessageText);
    }
}
