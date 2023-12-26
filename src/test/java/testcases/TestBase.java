package testcases;

import com.github.javafaker.Faker;
import drivers.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

import static drivers.DriverHolder.setDriver;

public class TestBase {
    WebDriver driver;
    static Faker faker=new Faker();

    @Parameters("browser")
    @BeforeTest
    public void setup(){
        driver = DriverFactory.getNewInstance("");
        setDriver(driver);

        /*
        //Todo call webdriver manager to set the driver
        WebDriverManager.chromedriver().setup();
        //Todo define driver
        driver =new ChromeDriver();

        //Todo set browser
        driver.manage().window().maximize();
        */
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //Todo Call the URL
        driver.get("https://www.saucedemo.com/");

    }

    @AfterTest
    public void close(){
        //Todo close the tab
        driver.close();
        Thread.currentThread().interrupt();
    }


}
