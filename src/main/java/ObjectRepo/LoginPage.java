package ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    // ============================================================
    // CONSTRUCTOR
    // ============================================================

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }


    // ============================================================
    // LOGIN PAGE WEBELEMENTS
    // ============================================================

    @FindBy(id = "Email")
    private WebElement emailField;

    @FindBy(id = "Password")
    private WebElement passwordField;

    @FindBy(id = "RememberMe")
    private WebElement rememberMeCheckbox;

    @FindBy(linkText = "Forgot password?")
    private WebElement forgotPasswordLink;

    @FindBy(css = "input.login-button")
    private WebElement loginButton;


    // ============================================================
    // LOGIN VALIDATION MESSAGES
    // ============================================================

    @FindBy(xpath = "//div[@class='validation-summary-errors']/span")
    private WebElement loginErrorSummary;

    @FindBy(xpath = "//div[@class='validation-summary-errors']/ul/li")
    private WebElement loginErrorDetail;

    @FindBy(xpath = "//span[@data-valmsg-for='Email']/child::span")
    private WebElement emailErrorMessage;

    @FindBy(xpath = "//h1[text()='Password recovery']")
    private WebElement passwordRecoveryTitle;


    // ============================================================
    // FIELD VERIFICATION METHODS
    // ============================================================

    public boolean isEmailFieldDisplayed() {
        return emailField.isDisplayed();
    }

    public boolean isPasswordFieldDisplayed() {
        return passwordField.isDisplayed();
    }

    public boolean isRememberMeDisplayed() {
        return rememberMeCheckbox.isDisplayed();
    }

    public boolean isForgotPasswordDisplayed() {
        return forgotPasswordLink.isDisplayed();
    }

    public boolean isLoginButtonDisplayed() {
        return loginButton.isDisplayed();
    }

    public boolean isRememberMeSelected() {
        return rememberMeCheckbox.isSelected();
    }


    // ============================================================
    // LOGIN FIELD METHODS
    // ============================================================

    public void enterEmail(String email) {
        emailField.sendKeys(email);
    }

    public void enterPassword(String password) {
        passwordField.sendKeys(password);
    }


    // ============================================================
    // REMEMBER ME METHODS
    // ============================================================

    public void selectRememberMe() {
        if (!rememberMeCheckbox.isSelected()) {
            rememberMeCheckbox.click();
        }
    }

    public void deselectRememberMe() {
        if (rememberMeCheckbox.isSelected()) {
            rememberMeCheckbox.click();
        }
    }


    // ============================================================
    // LOGIN ACTION METHODS
    // ============================================================

    public void clickForgotPassword() {
        forgotPasswordLink.click();
    }

    public void clickLogin() {
        loginButton.click();
    }


    // ============================================================
    // LOGIN VALIDATION MESSAGE METHODS
    // ============================================================

    public String getLoginErrorSummary() {
        return loginErrorSummary.getText();
    }

    public String getLoginErrorDetail() {
        return loginErrorDetail.getText();
    }

    public String getEmailErrorMessage() {
        return emailErrorMessage.getText();
    }


    // ============================================================
    // PASSWORD RECOVERY METHODS
    // ============================================================

    public String getPasswordRecoveryTitle() {
        return passwordRecoveryTitle.getText();
    }


    // ============================================================
    // COMPLETE LOGIN METHOD
    // ============================================================

    public void login(String email, String password) {

        emailField.sendKeys(email);
        passwordField.sendKeys(password);
        loginButton.click();
    }
}