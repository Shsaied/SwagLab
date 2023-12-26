package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class P02_Products {
//Todo declare web driver
    WebDriver driver;
    public static double  priceOfRandomProducts;

    //Todo constructor
    public P02_Products(WebDriver driver){
        this.driver=driver;
    }

//todo Locators
    final private By addToCartButtonForItem1=By.xpath("(//button[@class=\"btn btn_primary btn_small btn_inventory \"])[1]");
    final private By addToCartButtonForItem2=By.xpath("(//button[@class=\"btn btn_primary btn_small btn_inventory \"])[2]");
    final private By addToCartButtonForItem3=By.xpath("(//button[@class=\"btn btn_primary btn_small btn_inventory \"])[3]");
    final private By addToCartButtonForItem4=By.id("add-to-cart-sauce-labs-bike-light");
    final private By addToCartButtonForItem5=By.id("add-to-cart-sauce-labs-fleece-jacket");
    final private By addToCartButtonForItem6=By.id("add-to-cart-test.allthethings()-t-shirt-(red)");
    final private By shoppingCartIcon=By.xpath("//a[@class=\"shopping_cart_link\"]");
    final private By product1Price=By.xpath( "(//div[@class=\"inventory_item_price\"])[1]");
    final private By product2Price=By.xpath( "(//div[@class=\"inventory_item_price\"])[2]");
    final private By product3Price=By.xpath( "(//div[@class=\"inventory_item_price\"])[3]");
    final private By product4Price=By.xpath( "(//div[@class=\"inventory_item_price\"])[4]");
    final private By product5Price=By.xpath( "(//div[@class=\"inventory_item_price\"])[5]");
    final private By product6Price=By.xpath( "(//div[@class=\"inventory_item_price\"])[6]");

    //Todo methods
    public P02_Products clickOnAddToCartForItem1(){
        driver.findElement(this.addToCartButtonForItem1).click();
        return this;
    }
    public P02_Products clickOnAddToCartForItem2(){
        driver.findElement(this.addToCartButtonForItem2).click();
        return this;
    }
    public P02_Products clickOnAddToCartForItem3(){
        driver.findElement(this.addToCartButtonForItem3).click();
        return this;
    }
    public P02_Products clickOnAddToCartForItem4(){
        driver.findElement(this.addToCartButtonForItem4).click();
        return this;
    }
    public P02_Products clickOnAddToCartForItem5(){
        driver.findElement(this.addToCartButtonForItem5).click();
        return this;
    }
    public P02_Products clickOnAddToCartForItem6(){
        driver.findElement(this.addToCartButtonForItem6).click();
        return this;
    }
    /*public P02_Products addRandomProductToCart(int noOfProducts) {
        //declare variable for total price with 0 value
        Double randomTotalPrice = 0.0;
        //loop on price to sum the value and add it to total price variable
        for (int i = 1; i <= chooseRandomProduct(noOfProducts); i++) {
           String addToCart1="(//button[@class=\"btn btn_primary btn_small btn_inventory \"])["+i+"]";
           String productPrice = "(//div[@class=\"inventory_item_price\"])[" + i + "]";
            System.out.println("i value = " +i);
            //click Add to cart
            driver.findElement(By.xpath(addToCart1)).click();
            //get price
            String priceText = driver.findElement(By.xpath(productPrice)).getText();
            //trim the $
            String trimmedPrice=priceText.replace("$","");
            // parse the price to double
            double price = Double.parseDouble(trimmedPrice);
            //add price to the total
            System.out.println("item Price in Product page = " + price);
            randomTotalPrice += price;
            priceOfRandomProducts=randomTotalPrice;
            System.out.println("price of random products = " + priceOfRandomProducts);

        }
        return this;
    }

     */

    public double sumOfTotalPrice() {
        //declare variable for total price with 0 value
        Double totalPrice = 0.0;
        //loop on price to sum the value and add it to total price variable
        for (int i = 1; i <= 6; i++) {
            String productPrice = "(//div[@class=\"inventory_item_price\"])[" + i + "]";

            //get price
            String priceText = driver.findElement(By.xpath(productPrice)).getText();
            //trim the $
            String trimedPrice=priceText.replace("$","");
            // parse the price to double
            double price = Double.parseDouble(trimedPrice);
            //add price to the total
            totalPrice += price;
            //Assert the total price
            System.out.println(totalPrice);
        }
        return totalPrice;
}


public P02_Products clickOnShoppingCartIcon(){
        driver.findElement(this.shoppingCartIcon).click();
        return this;
}
    }

