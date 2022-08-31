package ge.sparta.com.pom.pages;

import org.openqa.selenium.WebDriver;

public class HNCommentsPage extends CommonUse {

    private WebDriver driver;

    public HNCommentsPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getUrl(){
        return driver.getCurrentUrl();
    }

    @Override
    public HNHomePage goBackToHomepage() {
        return new HNHomePage(driver);
    }
}
