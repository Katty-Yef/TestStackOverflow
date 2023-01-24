package org.teststackoverflow;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import org.apache.commons.io.FileUtils;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Main {

    static WebDriver driver;
//    static WebDriverWait wait = (new WebDriverWait(driver, Duration.ofSeconds(5)));
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\maksy\\Kate\\JavaProjects\\drivers\\chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://stackoverflow.com/");

        Header header = PageFactory.initElements(driver, Header.class);

        header.expandMenu();
        header.clickLogo();
        header.searchSmth("Why do we use C");
        header.clickLogInButton();

        LogIn login = PageFactory.initElements(driver, LogIn.class);

        login.enterEmail("qwertyu");
        login.enterPassword("sdqweqweqweqeqweqweqweqweqweweqweqweqweqweweqeqeqe");
        takeScreenshot("login1");
        login.clearEmail();
        login.clearPassword();
        login.sumbitInvalidCreds("sdvsdvds","sdvsdvsdvsdvsdvsdvsd");
        takeScreenshot("login2");
        login.clickSignUp();

        SignUp signup = PageFactory.initElements(driver, SignUp.class);

        signup.registerWithInvalidCreds("12345567890", "qwerty", "f");
        takeScreenshot("signup");
        signup.clickLogInButton();
    }

    public static void takeScreenshot(String string){

        Date dateNow = new Date();
        SimpleDateFormat format = new SimpleDateFormat("YYYY_MM_DD-hh_mm_ss");
        String fileName = format.format(dateNow) + "-" + string +".png";

        File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshot, new File("C:\\Users\\maksy\\Kate\\JavaProjects\\Screenshots\\" + fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}