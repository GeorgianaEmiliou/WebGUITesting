package ge.sparta.com;

import ge.sparta.com.pom.POMUtils;
import ge.sparta.com.pom.pages.*;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.LocalDate;

public class HackerNewsPOMTests {

    static private WebDriver driver;
    private HNHomePage homePage;
    private HNCommentsPage commentsPage;
    private HNPastPage pastPage;
    private static final String DRIVER_LOCATION = "src/test/resources/chromedriver.exe";

    @BeforeAll
    static void setupAll(){
        POMUtils.setDriverLocation(DRIVER_LOCATION);
    }

    @BeforeEach
    void setup(){
        driver = DriverFactory.getDriver(DriverOptions.CHROME);
        homePage = new HNHomePage(driver); //Homepage gets the driver
    }

    @Test
    @DisplayName("Check that we can go to the comments page")
    void checkThatWeCanGoToTheCommentsPage(){
        Assertions.assertEquals("https://news.ycombinator.com/newcomments", homePage.goToHomepage().goToCommentsPage().getUrl());

        /*String url = homePage.goToHomepage().goToCommentsPage().getUrl();
        Assertions.assertEquals("https://news.ycombinator.com/newcomments", url);

        HNCommentsPage commentsPage = homePage.goToHomepage().goToCommentsPage();
        Assertions.assertEquals("https://news.ycombinator.com/newcomments", commentsPage.getUrl());*/

    }

    @Test
    @DisplayName("Check that we can go to the new page")
    void checkThatWeCanGoToTheNewPage(){
        Assertions.assertEquals("https://news.ycombinator.com/newest", homePage.goToHomepage().goToNewPage().getUrl());
    }

    @Test
    @DisplayName("Check that the pasts page has yesterday's date")
    void checkThatThePastsPageHasYesterdaysDate(){
        String date = homePage.goToPastPage().getDateFromNavBar();
        String yesterdayDate = LocalDate.now().minusDays(1).toString();
        Assertions.assertEquals(yesterdayDate, date);
    }

    @Test
    @DisplayName("Check that the past posts are 30")
    void checkThatThePastPostsAre30(){
        Assertions.assertEquals("30", homePage.goToPastPage().getNumberOfPastPosts());
    }

    @AfterAll
    static void tearDownAll(){
        driver.quit();
    }
}
