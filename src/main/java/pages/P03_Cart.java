package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P03_Cart {
    //Todo declare web driver
    WebDriver driver;
    public static double  removedPrice;
    //Todo constructor
    public P03_Cart(WebDriver driver){
        this.driver=driver;
    }
    //Todo define locators
    private final By checkoutButton=By.xpath("//button[@class=\"btn btn_action btn_medium checkout_button \"]");
    private final By removeButton=By.id("remove-sauce-labs-backpack");
    private final By productPriceInShoppingCartPage=By.xpath("(//div[@class=\"inventory_item_price\"])[1]");
    //Todo define methods
public P03_Cart clickOnCheckOutButton(){
    driver.findElement(this.checkoutButton).click();
    return this;
}
public P03_Cart removeItemFromCart(){
    driver.findElement(this.removeButton).click();
    String removedItemPriceInText=driver.findElement(this.productPriceInShoppingCartPage).getText().replaceAll("[^0-9.]","");
    double removedItemprice=Double.parseDouble(removedItemPriceInText);
    removedItemprice=removedPrice;
    System.out.println("removed"+ removedPrice);
    return this;

}
public double sumTheTotalitemPriceInCartPageAfterRemoveOneItem(int noOfProducts){
    double SumOfTotalPriceInShoppingCart=0.0;
    for (int i=1; i <=(noOfProducts-1);i++){
        String productPriceText=driver.findElement(By.xpath("(//div[@class=\"inventory_item_price\"])["+i+"]")).getText();
        String trimmedProductPriceText=productPriceText.replaceAll("[^0-9.]","");
        double productPrice=Double.parseDouble(trimmedProductPriceText);
        SumOfTotalPriceInShoppingCart +=productPrice;
        System.out.println("cart" + SumOfTotalPriceInShoppingCart);

    }
    return SumOfTotalPriceInShoppingCart;
}
}
