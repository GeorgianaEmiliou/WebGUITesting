package ge.sparta.com.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HNHomePage { //Modeling the homepage

    private final WebDriver driver; //abstract type - only in homepage
    private By comments = new By.ByLinkText("comments");
    private By pasts = new By.ByLinkText("past");

    private By news = new By.ByLinkText("new");

    public HNHomePage(WebDriver driver){
        this.driver = driver;
        goToHomepage();
    }

    public HNHomePage goToHomepage() {
        driver.get("https://news.ycombinator.com/");
        return this;
    }

    public HNCommentsPage goToCommentsPage(){
        driver.findElement(comments).click();
        return new HNCommentsPage(driver);
    }

    public HNPastPage goToPastPage(){
        driver.findElement(pasts).click();
        return new HNPastPage(driver);
    }

    public HNNewPage goToNewPage(){
        driver.findElement(news).click();
        return new HNNewPage(driver);
    }
}
