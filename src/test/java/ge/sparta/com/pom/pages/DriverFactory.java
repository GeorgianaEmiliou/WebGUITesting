package ge.sparta.com.pom.pages;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
    private static FirefoxDriver firefoxDriver;
    private static ChromeDriver chromeDriver;

    public static WebDriver getDriver(DriverOptions driverOptions){
        if(driverOptions.equals(DriverOptions.FIREFOX_IPHONE10)){
            firefoxDriver.manage().window().setSize(new Dimension(365, 812));
            return firefoxDriver;
        }
        else if(driverOptions.equals(DriverOptions.CHROME)){
            chromeDriver = new ChromeDriver();
            return chromeDriver;
        }
        else if(driverOptions.equals(DriverOptions.FIREFOX)){
            firefoxDriver = new FirefoxDriver();
            return firefoxDriver;
        }


        return null;
    }
}
