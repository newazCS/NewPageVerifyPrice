package TestCases;

import MySmartPricePOM.BaseClass;
import ReusableLibrary.AbstractClass;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.IOException;
import java.util.ArrayList;

public class VerifyPrice extends AbstractClass {

    @Test
    public void SmartPhone() throws InterruptedException, IOException {
        driver.get("https://www.mysmartprice.com/mobile/apple-iphone-7-msp10208");

        //Get the price from Home page
        String HomePagePrice = BaseClass.homePage().PriceValueMethod();

        //Click on Go to store button
        BaseClass.homePage().GoToStoreMethod();

        // switch from home tab to amazon tab
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));

        //Wait 5 sec to load amazon website
        Thread.sleep(5000);

        //Get the price from amazon website
        String AmazonPrice =  BaseClass.amazonPage().AmazonPriceValueMethod();

        //Verify the both price

        if(AmazonPrice.equals(HomePagePrice)){
            logger.log(LogStatus.PASS,"Match the price "+ HomePagePrice);
        }
        else {
            logger.log(LogStatus.FAIL,"Miss match the price "+ AmazonPrice);
        }

        //Verify the both price using TestNG
        Assert.assertEquals( AmazonPrice,HomePagePrice);

        // Note: This TC will fail because Home page price and amazon product price are not same (Product is Currently unavailable ).
        //Please look at the HTML report

    }
}
