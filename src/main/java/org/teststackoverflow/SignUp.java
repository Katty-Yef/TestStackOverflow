package org.teststackoverflow;

import org.checkerframework.common.value.qual.IntRangeFromGTENegativeOne;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignUp {

    public SignUp(WebDriver driver) {
        this.driver = driver;
    }

    private WebDriver driver;

    @FindBy(xpath = "//input[@id='display-name']")
    private WebElement displayNameField;
    @FindBy(xpath = "//input[@id='email']")
    private WebElement emailField;
    @FindBy(xpath = "//input[@id='password']")
    private WebElement passwordField;
    @FindBy(xpath = "//div[@id='no-captcha-here']/div/div/iframe")
    private WebElement captcha;
    @FindBy(xpath = "//input[@id='opt-in']")
    private WebElement optinCheckbox;
    @FindBy(xpath = "//button[@id='submit-button']")
    private WebElement signUpButton;
    @FindBy(xpath = "//div[@class='mx-auto ta-center fs-body1 p16 pb0 mb24 w100 wmx3 js-redirects']/a")
    private WebElement logInButton;

    public LogIn clickLogInButton(){
        logInButton.click();
        return new LogIn(driver);
    }

    public SignUp enterUserName(String name){
        displayNameField.sendKeys(name);
        return this;
    }

    public SignUp enterEmail(String email){
        emailField.sendKeys(email);
        return this;
    }

    public SignUp enterPassword(String password){
        passwordField.sendKeys(password);
        return this;
    }

    public SignUp clickCaptcha(){
        captcha.click();
        return this;
    }

    public SignUp selectOptInCheckbox(){
        optinCheckbox.click();
        return this;
    }

    public SignUp submitRegisterFormWithInvalidCreds(String name, String email, String password){
        enterUserName(name);
        enterEmail(email);
        enterPassword(password);
        clickCaptcha();
        selectOptInCheckbox();
        signUpButton.submit();
        return new SignUp(driver);
    }
}