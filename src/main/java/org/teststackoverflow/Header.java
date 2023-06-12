package org.teststackoverflow;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Header {

    private WebDriver driver;

    @FindBy(xpath = "//div[@class='s-topbar--container']/a[@aria-controls='left-sidebar']")
    private WebElement burgerButton;
    @FindBy(xpath = "//div[@class='s-topbar--container']/a[@class='s-topbar--logo js-gps-track']")
    private WebElement logoButton;
    @FindBy(xpath = "//input[@class='s-input s-input__search js-search-field ']")
    private WebElement searchField;
    @FindBy(xpath = "//nav[@class='h100 ml-auto overflow-x-auto pr12']//a[@class='s-topbar--item s-topbar--item__unset s-btn s-btn__filled ws-nowrap js-gps-track']")
    private WebElement logInButton;
    @FindBy(xpath = "//nav[@class='h100 ml-auto overflow-x-auto pr12']//a[@class='s-topbar--item s-topbar--item__unset ml4 s-btn s-btn__primary ws-nowrap']")
    private WebElement signUpButton;

    public Header(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public SignUp clickSignUpButton() {
        signUpButton.click();
        return new SignUp(driver);
    }

    public LogIn clickLogInButton() {
        logInButton.click();
        return new LogIn(driver);
    }

    public Header expandMenu() {
        burgerButton.click();
        return this;
    }

    public Header fillInSearchFieldAndPressEnterKey(String searchQuery) {
        searchField.sendKeys(searchQuery);
        searchField.sendKeys(Keys.ENTER);
        return new Header(driver);
    }

    public Header clickLogo() {
        logoButton.click();
        return new Header(driver);
    }
}