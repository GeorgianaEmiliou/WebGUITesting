package ge.sparta.com.pom.pages;

import org.openqa.selenium.WebDriver;

public class HNNewPage {

    private WebDriver driver;

    public HNNewPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getUrl(){
        return driver.getCurrentUrl();
    }
}
