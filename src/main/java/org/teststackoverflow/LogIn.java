package org.teststackoverflow;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogIn {

    private WebDriver driver;

    @FindBy(xpath = "//input[@id='email']")
    private WebElement emailField;
    @FindBy(xpath = "//input[@id='password']")
    private WebElement passwordField;
    @FindBy(xpath = "//button[@id='submit-button']")
    private WebElement logInButton;
    @FindBy(xpath = "//div[@class='mx-auto ta-center fs-body1 p16 pb0 mb24 w100 wmx3']/a")
    private WebElement signUpButton;

    public LogIn(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public LogIn enterEmail(String email) {
        emailField.sendKeys(email);
        return this;
    }

    public LogIn enterPassword(String password) {
        passwordField.sendKeys(password);
        return this;
    }

    public LogIn sumbitLoginFormWithInvalidCreds(String email, String password) {
        enterEmail(email);
        enterPassword(password);
        logInButton.submit();
        return new LogIn(driver);
    }

    public SignUp clickSignUpButton() {
        signUpButton.click();
        return new SignUp(driver);
    }

    public LogIn clearEmailField() {
        emailField.clear();
        return this;
    }

    public LogIn clearPasswordField() {
        passwordField.clear();
        return this;
    }

}