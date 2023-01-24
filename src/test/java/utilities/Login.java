package utilities;

import org.openqa.selenium.WebElement;

import java.util.List;

public class Login {

    public static void login(List<WebElement> inputs, String[] credentials, WebElement loginButton){
        for (int i = 0; i < inputs.size(); i++) {
            inputs.get(i).sendKeys(credentials[i]);
        }
        loginButton.click();
    }
}
