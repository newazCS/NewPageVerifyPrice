package MySmartPricePOM;

import ReusableLibrary.AbstractClass;
import ReusableLibrary.ReusableActions;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends AbstractClass {
    ExtentTest logger;
    public HomePage(WebDriver driver){
        PageFactory.initElements(driver,this);
        this.logger = AbstractClass.logger;
    }


    @FindBy(xpath = "//span[@class ='prdct-dtl__prc-val']")
    WebElement PriceValue;
    public String PriceValueMethod(){
        return ReusableActions.captureText(driver,PriceValue,0,logger,"Price = ");
    }

    @FindBy(xpath = "//div[@class='prc-tbl__btn']")
    WebElement GoToStore;
    public void GoToStoreMethod(){
        ReusableActions.clickOnElement(driver,GoToStore,logger," Go to store");
    }


}
