package MySmartPricePOM;

import ReusableLibrary.AbstractClass;

public class BaseClass extends AbstractClass {

    public static HomePage homePage(){
        return new HomePage(driver);
    }
    public static AmazonPage amazonPage(){
        return new AmazonPage(driver);
    }
}
