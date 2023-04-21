import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import org.teststackoverflow.Header;

import java.time.Duration;

public class BaseClass {
    protected WebDriver driver;
    protected Header header;

    @BeforeEach
    public void setUp(){
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get("https://stackoverflow.com/");
        header = PageFactory.initElements(driver, Header.class);
    }

    @AfterEach
    public void tearDown(){
        driver.quit();
    }
}
