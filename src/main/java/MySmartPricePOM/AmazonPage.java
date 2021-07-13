package MySmartPricePOM;

import ReusableLibrary.AbstractClass;
import ReusableLibrary.ReusableActions;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonPage extends AbstractClass {
    ExtentTest logger;
    public AmazonPage(WebDriver driver){
        PageFactory.initElements(driver,this);
        this.logger = AbstractClass.logger;
    }
    @FindBy(xpath = "(//span[contains(@class,'a-color-price')])[2]")
    WebElement AmazonPriceValue;
    public String AmazonPriceValueMethod() throws InterruptedException {
        return ReusableActions.captureText(driver,AmazonPriceValue,0,logger,"Amazon Price = ");
    }
}
