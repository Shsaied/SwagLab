package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P05_CheckOutStepTwo {
//Todo declare web driver
    WebDriver driver;

    //Todo constructor
    public  P05_CheckOutStepTwo(WebDriver driver){
        this.driver=driver;
    }

    //Todo define locators
    private final By invoiceTotalItemPrice=By.xpath("//div[@class=\"summary_subtotal_label\"]");
    private final By invoiceTax=By.xpath("//div[@class=\"summary_tax_label\"]");
    private final By invoiceTotal=By.xpath("//div[@class=\"summary_info_label summary_total_label\"]");
    private final By finishButton=By.xpath("//button[@class=\"btn btn_action btn_medium cart_button\"]");

    //todo define methods
public P05_CheckOutStepTwo clickOnFinishButton(){
    driver.findElement(this.finishButton).click();
    return this;
}
public double getInvoiceTotalItemPrice(){

    //get invoice price
    String invoiceTotalPriceText=driver.findElement(this.invoiceTotalItemPrice).getText();
    //trim the dollar sign
    String trimmedInvoiceTotalPriceText=invoiceTotalPriceText.replaceAll("[^0-9.]","");
    //pars the price to double
    double invoiceTotalPriceFinal=Double.parseDouble(trimmedInvoiceTotalPriceText);
    System.out.println("total price in checkout page = " + invoiceTotalPriceFinal);
    return invoiceTotalPriceFinal;
}
    public double getInvoiceTax(){
    //get tax as a text
    String taxText= driver.findElement(this.invoiceTax).getText();
    //trim the dollar sign
     String trimmedTaxText= taxText.replaceAll("[^0-9.]","");
       //pars tax to double
        double tax=Double.parseDouble(trimmedTaxText);
        return tax;
    }
public double getTotalInvoicePrice(){
//get total invoice as a text
    String totalInvoiceText=driver.findElement(this.invoiceTotal).getText();
    //trim the dollar sign
    String trimmedTotalInvoiceText=totalInvoiceText.replaceAll("[^0-9.]","");
    //pars total invoice text to double
    double totalInvoice= Double.parseDouble(trimmedTotalInvoiceText);
    return totalInvoice;
    


}



}
