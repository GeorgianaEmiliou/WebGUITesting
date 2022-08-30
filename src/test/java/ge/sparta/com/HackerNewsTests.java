package ge.sparta.com;

import org.checkerframework.checker.units.qual.A;
import org.checkerframework.checker.units.qual.C;
import org.checkerframework.checker.units.qual.K;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FilterOutputStream;
import java.time.LocalDate;
import java.util.Set;

public class HackerNewsTests {
    static private WebDriver driver;

    @BeforeAll
    static void setupAll(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @BeforeEach
    void setup(){
        driver.get("https://news.ycombinator.com/");
    }

    @Test
    @DisplayName("Check that we are on the HN homepage")
    void checkThatWeAreOnTheHNHomepage(){
        Assertions.assertEquals("https://news.ycombinator.com/", driver.getCurrentUrl());
    }

    @Test
    @DisplayName("Check that the new link works")
    void checkThatTheNewLinkWorks(){
        driver.findElement(By.linkText("new")).click();
        Assertions.assertEquals("https://news.ycombinator.com/newest", driver.getCurrentUrl());
    }

    @Test
    @DisplayName("Check that the past link works")
    void checkThatThePastLinkWorks(){
        driver.findElement(By.linkText("past")).click();
        Assertions.assertEquals("https://news.ycombinator.com/front", driver.getCurrentUrl());
    }

    @Test
    @DisplayName("Check that the comments link works")
    void checkThatTheCommentsLinkWorks(){
        driver.findElement(By.linkText("comments")).click();
        Assertions.assertEquals("https://news.ycombinator.com/newcomments", driver.getCurrentUrl());
    }

    @Test
    @DisplayName("Check that the ask link works")
    void checkThatTheAskLinkWorks(){
        driver.findElement(By.linkText("ask")).click();
        Assertions.assertEquals("https://news.ycombinator.com/ask", driver.getCurrentUrl());
    }

    @Test
    @DisplayName("Check that the show link works")
    void checkThatTheShowLinkWorks(){
        driver.findElement(By.linkText("show")).click();
        Assertions.assertEquals("https://news.ycombinator.com/show", driver.getCurrentUrl());
    }

    @Test
    @DisplayName("Check that the jobs link works")
    void checkThatTheJobsLinkWorks(){
        driver.findElement(By.linkText("jobs")).click();
        Assertions.assertEquals("https://news.ycombinator.com/jobs", driver.getCurrentUrl());
    }

    @Test
    @DisplayName("Check that the submit link works")
    void checkThatTheSubmitLinkWorks(){
        driver.findElement(By.linkText("submit")).click();
        Assertions.assertEquals("https://news.ycombinator.com/submit", driver.getCurrentUrl());
    }

    @Test
    @DisplayName("Check that we can search using Java as a keyword")
    void checkThatWeCanSearchUsingJavaAsAKeyword(){
        driver.findElement(By.name("q")).sendKeys("Java", Keys.ENTER);
        Assertions.assertEquals("https://hn.algolia.com/?q=Java", driver.getCurrentUrl());
    }

    @Test
    @DisplayName("Check that yesterday's date displays when click on the past link")
    void checkThatYesterdaysDateDisplaysWhenClockOnThePastLink(){
        LocalDate yesterday = LocalDate.now().minusDays(1);
        driver.findElement(By.linkText("past")).click();
        //String date = driver.getTitle().substring(0,10);
        String date = driver.findElement(By.xpath("//*[@id=\"hnmain\"]/tbody/tr[1]/td/table/tbody/tr/td[2]/span/font")).getText();
        Assertions.assertEquals(yesterday.toString(), date);
    }

    @Test
    @DisplayName("Check that last month's date appears when click on go back a month")
    void checkThatLastMonthsDateAppears(){
        LocalDate monthAgo = LocalDate.now().minusMonths(1).minusDays(1);
        System.out.println(monthAgo);
        driver.findElement(By.linkText("past")).click();
        driver.findElement(By.linkText("month")).click();
        String date = driver.findElement(By.xpath("//*[@id=\"hnmain\"]/tbody/tr[1]/td/table/tbody/tr/td[2]/span/font")).getText();
        Assertions.assertEquals(monthAgo.toString(), date);
    }

    @Test
    @DisplayName("Check numbers")
    void checkNumbers(){
        String numberOne = driver.findElement(By.xpath("/html/body/center/table/tbody/tr[3]/td/table/tbody/tr[1]/td[1]/span")).getText();
        numberOne = numberOne.replace(".", "");
        String numberTwo = driver.findElement(By.xpath("/html/body/center/table/tbody/tr[3]/td/table/tbody/tr[4]/td[1]/span")).getText();
        numberTwo = numberTwo.replace(".", "");
        Assertions.assertTrue(Integer.parseInt(numberTwo) > Integer.parseInt(numberOne));
    }

//     @Test
//     @DisplayName("")


    @Test
    @DisplayName("Check we can open a link in a new tab")
    void checkWeOpenALinkInANewTab(){
        String originalTab = driver.getWindowHandle();
        System.out.println(originalTab);
        driver.findElement(By.linkText("new")).sendKeys(Keys.chord(Keys.CONTROL, Keys.ENTER));
        Set<String> handles = driver.getWindowHandles();
        System.out.println(handles);

        for (String tab : handles){
            if(!originalTab.equals(tab)){
                driver.switchTo().window(tab);
                break;
            }
        }

        Assertions.assertNotEquals(driver.getWindowHandle(), originalTab);
        //Assertions.assertEquals("https://news.ycombinator.com/newest", driver.getCurrentUrl());
    }

    @AfterAll
    static void tearDownAll(){
        driver.quit();
    }
}
