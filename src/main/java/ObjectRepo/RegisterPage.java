package ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {

    // ============================================================
    // CONSTRUCTOR
    // ============================================================

    public RegisterPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }


    // ============================================================
    // REGISTRATION PAGE WEBELEMENTS
    // ============================================================

    @FindBy(id = "gender-male")
    private WebElement maleRadioButton;

    @FindBy(id = "gender-female")
    private WebElement femaleRadioButton;

    @FindBy(id = "FirstName")
    private WebElement firstNameField;

    @FindBy(id = "LastName")
    private WebElement lastNameField;

    @FindBy(id = "Email")
    private WebElement emailField;

    @FindBy(id = "Password")
    private WebElement passwordField;

    @FindBy(id = "ConfirmPassword")
    private WebElement confirmPasswordField;

    @FindBy(id = "register-button")
    private WebElement registerButton;


    // ============================================================
    // VALIDATION MESSAGE WEBELEMENTS
    // ============================================================

    @FindBy(css = "span[data-valmsg-for='FirstName']")
    private WebElement firstNameErrorMessage;

    @FindBy(css = "span[data-valmsg-for='LastName']")
    private WebElement lastNameErrorMessage;

    @FindBy(css = "span[data-valmsg-for='Email']")
    private WebElement emailErrorMessage;

    @FindBy(css = "span[data-valmsg-for='Password']")
    private WebElement passwordErrorMessage;

    @FindBy(css = "span[data-valmsg-for='ConfirmPassword']")
    private WebElement confirmPasswordErrorMessage;

    @FindBy(css = "div.message-error")
    private WebElement registrationErrorMessage;


    // ============================================================
    // GENDER METHODS
    // ============================================================

    public void selectMale() {
        maleRadioButton.click();
    }

    public void selectFemale() {
        femaleRadioButton.click();
    }


    // ============================================================
    // REGISTRATION FIELD METHODS
    // ============================================================

    public void enterFirstName(String firstName) {
        firstNameField.sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        lastNameField.sendKeys(lastName);
    }

    public void enterEmail(String email) {
        emailField.sendKeys(email);
    }

    public void enterPassword(String password) {
        passwordField.sendKeys(password);
    }

    public void enterConfirmPassword(String confirmPassword) {
        confirmPasswordField.sendKeys(confirmPassword);
    }


    // ============================================================
    // REGISTRATION ACTION METHODS
    // ============================================================

    public void clickRegister() {
        registerButton.click();
    }


    // ============================================================
    // VALIDATION MESSAGE METHODS
    // ============================================================

    public String getRegistrationErrorMessage() {
        return registrationErrorMessage.getText();
    }

    public String getFirstNameErrorMessage() {
        return firstNameErrorMessage.getText();
    }

    public String getLastNameErrorMessage() {
        return lastNameErrorMessage.getText();
    }

    public String getEmailErrorMessage() {
        return emailErrorMessage.getText();
    }

    public String getPasswordErrorMessage() {
        return passwordErrorMessage.getText();
    }

    public String getConfirmPasswordErrorMessage() {
        return confirmPasswordErrorMessage.getText();
    }


    // ============================================================
    // COMPLETE REGISTRATION METHOD
    // ============================================================

    public void registerUser(
            String firstName,
            String lastName,
            String email,
            String password,
            String confirmPassword) {

        firstNameField.sendKeys(firstName);
        lastNameField.sendKeys(lastName);
        emailField.sendKeys(email);
        passwordField.sendKeys(password);
        confirmPasswordField.sendKeys(confirmPassword);

        registerButton.click();
    }
}