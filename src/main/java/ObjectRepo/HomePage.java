package ObjectRepo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

    private WebDriver driver;
    private WebDriverWait wait;


    // ============================================================
    // CONSTRUCTOR
    // ============================================================

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }


    // ============================================================
    // HOME PAGE WEBELEMENTS
    // ============================================================

    @FindBy(linkText = "Register")
    private WebElement registerLink;

    @FindBy(linkText = "Log in")
    private WebElement loginLink;

    @FindBy(linkText = "Log out")
    private WebElement loginOut;

    @FindBy(linkText = "Shopping cart")
    private WebElement shoppingCartLink;

    @FindBy(linkText = "Wishlist")
    private WebElement wishlistLink;

    @FindBy(linkText = "Gift Cards")
    private WebElement giftCardsLink;

    @FindBy(id = "small-searchterms")
    private WebElement searchBox;

    @FindBy(css = "input[value='Search']")
    private WebElement searchButton;

    @FindBy(xpath = "//input[@value='Continue']")
    private WebElement continueButton;


    // ============================================================
    // NAVIGATION METHODS
    // ============================================================

    public void clickRegister() {
        wait.until(ExpectedConditions.elementToBeClickable(registerLink)).click();
    }

    public void clickLogin() {
        wait.until(ExpectedConditions.elementToBeClickable(loginLink)).click();
    }

    public void clickLoginOut() {
        wait.until(ExpectedConditions.elementToBeClickable(loginOut)).click();
    }

    public void clickShoppingCart() {
        wait.until(ExpectedConditions.elementToBeClickable(shoppingCartLink)).click();
    }

    public void clickWishlist() {
        wait.until(ExpectedConditions.elementToBeClickable(wishlistLink)).click();
    }

    public void clickGiftCards() {
        wait.until(ExpectedConditions.elementToBeClickable(giftCardsLink)).click();
    }

    public void clickContinueButton() {
        wait.until(ExpectedConditions.elementToBeClickable(continueButton)).click();
    }


    // ============================================================
    // SEARCH METHODS
    // ============================================================

    public void enterProductName(String productName) {
        wait.until(ExpectedConditions.visibilityOf(searchBox)).sendKeys(productName);
    }

    public void clickSearch() {
        wait.until(ExpectedConditions.elementToBeClickable(searchButton)).click();
    }

    public void searchProduct(String productName)
            throws InterruptedException {

        wait.until(ExpectedConditions.visibilityOf(searchBox));

        searchBox.clear();
        searchBox.sendKeys(productName);

        Thread.sleep(2000);

        wait.until(ExpectedConditions.elementToBeClickable(searchButton)).click();
    }


    // ============================================================
    // SEARCH RESULT VERIFICATION
    // ============================================================

    public boolean isProductDisplayedInSearchResults(
            String productName) {

        WebElement product =
                driver.findElement(
                        By.xpath(
                                "//h2[@class='product-title']/a[normalize-space()='"
                                + productName
                                + "']"
                        )
                );

        return product.isDisplayed();
    }


    // ============================================================
    // SEARCH RESULT PRODUCT
    // ============================================================

    public void clickSearchedProduct(String productName) {

        wait.until(
                ExpectedConditions.elementToBeClickable(
                        driver.findElement(
                                By.xpath(
                                        "//h2[@class='product-title']/a[normalize-space()='"
                                        + productName
                                        + "']"
                                )
                        )
                )
        ).click();
    }
}