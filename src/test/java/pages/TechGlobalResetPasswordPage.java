package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TechGlobalResetPasswordPage extends TechGlobalBasePage{

    public TechGlobalResetPasswordPage(){
        super();
    }

    @FindBy(id = "sub_heading")
    public WebElement resetPasswordText;
    @FindBy(css = ".ForgotPassword_content__EYXVx label")
    public WebElement heading2;
    @FindBy(id = "email")
    public WebElement emailBox;
    @FindBy(id = "submit")
    public WebElement submitButton;
    @FindBy(id = "confirmation_message")
    public WebElement conformationMessage;
}
