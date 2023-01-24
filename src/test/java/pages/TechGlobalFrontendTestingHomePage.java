package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class TechGlobalFrontendTestingHomePage extends TechGlobalBasePage{

    public TechGlobalFrontendTestingHomePage(){
        super();
    }

    @FindBy(css = "div[id^='card']")
    public List<WebElement> cards;

    public void getFrontendTestingPage(){
        headerDropdown.click();
        headerDropdownOptions.get(0).click();
    }

    public void clickOnCard(int index){
        cards.get(index).click();
    }


}
