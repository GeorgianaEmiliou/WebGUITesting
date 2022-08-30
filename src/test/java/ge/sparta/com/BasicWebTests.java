package ge.sparta.com;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.io.IOException;

public class BasicWebTests {

    private static WebDriver driver;
    private static ChromeDriverService service;
    private static ChromeOptions options;

    @BeforeAll
    static void setUpAll(){
        service = new ChromeDriverService.Builder()
                .usingDriverExecutable(new File("src/test/resources/chromedriver.exe"))
                .usingAnyFreePort()
                .build();

        try {
            service.start();
        } catch (IOException e) {
            e.printStackTrace();
        }

        options = new ChromeOptions();
        options.addArguments("headless");

        driver = new ChromeDriver(service, options);
        driver.get("https://www.bbc.co.uk");
    }

    @Test
    @DisplayName("Check that the title of the URL is correct")
    void checkThatTheTitleIsCorrect(){
        Assertions.assertEquals("BBC - Home", driver.getTitle());
    }

    @Test
    @DisplayName("Check that the URL for the BBC is correct")
    void checkThatTheURLForTheBBCIsCorrect(){
        Assertions.assertEquals("https://www.bbc.co.uk/", driver.getCurrentUrl());
    }

    @AfterEach
    void tearDown(){
        //driver.close(); //closes browser window after each test
    }

    @AfterAll
    static void tearDownAll(){
        service.stop();
        //driver.quit(); //quits the web-driver
    }

}
