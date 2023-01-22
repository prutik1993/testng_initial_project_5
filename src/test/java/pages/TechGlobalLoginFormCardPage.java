package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utilities.Driver;

import java.util.List;

public class TechGlobalLoginFormCardPage extends TechGlobalBasePage{

    public TechGlobalLoginFormCardPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "main_heading")
    public WebElement header;
    @FindBy(css = ".LoginForm_form__b4o6J label")
    public List<WebElement> labels;
    @FindBy(css = ".LoginForm_form__b4o6J input")
    public List<WebElement> inputs;
    @FindBy(id = "login_btn")
    public WebElement loginButton;
    @FindBy(id = "forgot-password")
    public WebElement forgotPasswordLink;
    @FindBy(id = "success_lgn")
    public WebElement messageAfterSuccessfulLogin;
    @FindBy(id = "logout")
    public WebElement logoutButton;



}