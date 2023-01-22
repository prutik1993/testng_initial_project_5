package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class TechGlobalLoginFormPage {

    public TechGlobalLoginFormPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "success_lgn")
    public WebElement messageAfterSuccessfulLogin;
    @FindBy(id = "logout")
    public WebElement logoutButton;

}
