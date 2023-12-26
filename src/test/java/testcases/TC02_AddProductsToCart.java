package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class TC02_AddProductsToCart extends TestBase {
    String userName="standard_user";
    String password="secret_sauce";
    String firstName=faker.name().firstName();
    String lastname=faker.name().lastName();
    String zipCode=faker.address().zipCode();
    int  noOfProducts=3;

    @Test(priority = 1, description = "Add All products to Shopping Cart and check invoice total price")
    public void checkInvoiceTotalPrice_P() throws InterruptedException {
        new P01_Login(driver).insertUserName(userName).insertPassword(password).clickLoginButton();
        new P02_Products(driver).clickOnAddToCartForItem1().clickOnAddToCartForItem2().clickOnAddToCartForItem3();
        new P02_Products(driver).clickOnAddToCartForItem4().clickOnAddToCartForItem5().clickOnAddToCartForItem6().clickOnShoppingCartIcon();
        Thread.sleep(3000);
        new P03_Cart(driver).clickOnCheckOutButton();
        new P04_CheckOutStepOne(driver).insertFirstname(firstName).insertLastName(lastname).insertZipCode(zipCode).clickContinueButton();
        Thread.sleep(3000);
        Assert.assertEquals(new P02_Products(driver).sumOfTotalPrice(),new P05_CheckOutStepTwo(driver).getInvoiceTotalItemPrice());
        new P05_CheckOutStepTwo(driver).clickOnFinishButton();
        Thread.sleep(3000);
    }


   /* @Test(priority = 1, description = "Add random products to Shopping Cart and check invoice total price after remove an Item")
    public void checkInvoiceTotalPriceAfterRemoveAnItem_P() throws InterruptedException {
        new P01_Login(driver).insertUserName(userName).insertPassword(password).clickLoginButton();
        new P02_Products(driver).addRandomProductToCart(noOfProducts).clickOnShoppingCartIcon();
        Thread.sleep(3000);
        new P03_Cart(driver).clickOnCheckOutButton();
        new P04_CheckOutStepOne(driver).insertFirstname(firstName).insertLastName(lastname).insertZipCode(zipCode).clickContinueButton();
        Thread.sleep(3000);
        Assert.assertEquals(new P02_Products(driver).priceOfRandomProducts,new P05_CheckOutStepTwo(driver).getInvoiceTotalItemPrice());
        driver.navigate().back();
        driver.navigate().back();
        new P03_Cart(driver).removeItemFromCart();
        driver.navigate().refresh();
        new P04_CheckOutStepOne(driver).insertFirstname(firstName).insertLastName(lastname).insertZipCode(zipCode).clickContinueButton();
        new P05_CheckOutStepTwo(driver).clickOnFinishButton();
        Assert.assertEquals((new P02_Products(driver).priceOfRandomProducts-new P03_Cart(driver).removedPrice),new P05_CheckOutStepTwo(driver).getInvoiceTotalItemPrice());
        //new P02_Products(driver).
        Thread.sleep(3000);
    }

    */
    }
