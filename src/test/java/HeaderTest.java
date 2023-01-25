import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.teststackoverflow.Header;
import org.teststackoverflow.SignUp;

import java.util.concurrent.TimeUnit;

public class HeaderTest {

    private WebDriver driver;
    private Header header;

    @BeforeEach
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\maksy\\Kate\\JavaProjects\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://stackoverflow.com/");
        header = PageFactory.initElements(driver, Header.class);
    }

    @Test
    public void urlNegativeTest(){
        SignUp signUp = header.clickSignUpButton();
        String url = driver.getCurrentUrl();
        Assertions.assertNotEquals("https://stackoverflow.com/users/signup?ssrc=head&returnurl=https%3a%2f%2fstackoverflow.com%", url);
    }

    @Test
    public void urlPositiveTest(){
        SignUp signUp = header.clickSignUpButton();
        String url = driver.getCurrentUrl();
        Assertions.assertEquals("https://stackoverflow.com/users/signup?ssrc=head&returnurl=https%3a%2f%2fstackoverflow.com%2f", url);
    }

    @AfterEach
    public void tearDown(){
        driver.quit();
    }

}
