package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P01_Login {
    //Todo declare web driver
    WebDriver driver;

    //Todo constructor
    public P01_Login(WebDriver driver) {
        this.driver = driver;
    }

    //Todo define Locators
    private final By userName = By.xpath("//input[@id='user-name']");
    private final By password = By.xpath("//input[@id='password']");
    private final By loginButton = By.xpath("//input[@id='login-button']");

    //Todo define Methods
    public P01_Login insertUserName(String email) {
        driver.findElement(this.userName).sendKeys(email);
        return this;
    }

    public P01_Login insertPassword(String password) {
        driver.findElement(this.password).sendKeys(password);
        return this;
    }

    public P01_Login clickLoginButton() {
        driver.findElement(this.loginButton).click();
        return this;
    }

}


