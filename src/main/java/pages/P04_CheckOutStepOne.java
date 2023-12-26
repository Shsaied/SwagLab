package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P04_CheckOutStepOne {
    //Todo declare web driver
    WebDriver driver;

    //Todo constructor
    public  P04_CheckOutStepOne(WebDriver driver){
        this.driver=driver;
    }
    //Todo Locators
    private final By firstNameField=By.xpath("(//input[@class=\"input_error form_input\"])[1]");
    private final By lastNameField=By.xpath("(//input[@class=\"input_error form_input\"])[2]");
    private final By zipCodeField=By.xpath("(//input[@class=\"input_error form_input\"])[3]");
    private final  By continueButton=By.xpath("//input[@type=\"submit\"]");

    //Todo define methods
    public P04_CheckOutStepOne insertFirstname(String firstname){
        driver.findElement(this.firstNameField).sendKeys(firstname);
        return this;
    }
    public P04_CheckOutStepOne insertLastName(String lastName){
        driver.findElement(this.lastNameField).sendKeys(lastName);
        return this;
    }
    public P04_CheckOutStepOne insertZipCode(String zipCode){
        driver.findElement(this.zipCodeField).sendKeys(zipCode);
        return this;
    }
    public P04_CheckOutStepOne clickContinueButton(){
        driver.findElement(this.continueButton).click();
        return this;
    }
}
