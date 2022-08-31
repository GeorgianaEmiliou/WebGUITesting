package ge.sparta.com.pom.cucumber;

import ge.sparta.com.pom.POMUtils;
import ge.sparta.com.pom.pages.HNCommentsPage;
import ge.sparta.com.pom.pages.HNHomePage;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MyStepdefs {

    private static WebDriver driver;
    private static HNHomePage homePage;
    private static HNCommentsPage commentsPage;

    //Before, After, BeforeAll, AfterAll

    @Before
    static void setup(){
    }

    @Given("I am on the homepage")
    public void iAmOnTheHomePage(){
        POMUtils.setDriverLocation("src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        homePage = new HNHomePage(driver);
        homePage.goToHomepage();
    }

    @When("I click on the comments link")
    public void iClickOnTheCommentsLink(){
        commentsPage = homePage.goToCommentsPage();
    }

    @Then("I will go to the comments page")
    public void iWillGoToTheCommentsPage() {
        Assertions.assertEquals("https://news.ycombinator.com/newcomments", homePage.goToHomepage().goToCommentsPage().getUrl());
    }


    @Given("I am on the {string}")
    public void iAmOnThe(String arg0) {
    }

    @When("I click on the {string} link")
    public void iClickOnTheLink(String arg0) {
    }

    @Then("I will go to the {string} page")
    public void iWillGoToThePage(String arg0) {
    }

    @When("I click on the past link")
    public void iClickOnThePastLink() {
    }

    @Then("I can see yesterday's date")
    public void iCanSeeYesterdaySDate() {
    }

    @Then("I will go to the past page")
    public void iWillGoToThePastPage() {
    }
}
