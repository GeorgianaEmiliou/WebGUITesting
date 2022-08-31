package ge.sparta.com.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class HNPastPage extends CommonUse {

    private WebDriver driver;

    private By pageTop = new By.ByClassName("pagetop");
    private By pastDate = new By.ByTagName("font");
    private By numberOfPastPosts = new By.ByClassName("title");

    public HNPastPage(WebDriver driver) {
        this.driver = driver;
    }

    //Get date from pagetop
    //return string - date
    //return LocalDate - date
    //return boolean - is the date yesterday?
    public String getDateFromNavBar(){
        return driver.findElement(pastDate).getText();
    }

    public String getUrl(){
        return driver.getCurrentUrl();
    }

    @Override
    public HNHomePage goBackToHomepage() {
        return new HNHomePage(driver);
    }

    public String getNumberOfPastPosts(){
        return driver.findElement(numberOfPastPosts).getText();
    }


}
