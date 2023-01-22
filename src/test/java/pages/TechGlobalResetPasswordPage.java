package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import utilities.Driver;

public class TechGlobalResetPasswordPage extends TechGlobalBasePage{

    public TechGlobalResetPasswordPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "sub_heading")
    public WebElement resetPasswordText;
    @FindBy(css = ".ForgotPassword_content__EYXVx label")
    public WebElement heading2;
    @FindBy(id = "email")
    public WebElement emailBox;
    @FindBy(id = "submit")
    public WebElement submitButton;
}
