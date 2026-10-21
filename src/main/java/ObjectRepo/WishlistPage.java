package ObjectRepo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WishlistPage {

    private WebDriver driver;

    // ============================================================
    // CONSTRUCTOR
    // ============================================================

    public WishlistPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // ============================================================
    // WISHLIST TABLE
    // ============================================================

    @FindBy(css = "table.cart")
    private WebElement wishlistTable;

    // ============================================================
    // WISHLIST BUTTONS
    // ============================================================

    @FindBy(css = "input.update-wishlist-button")
    private WebElement updateWishlistButton;

    @FindBy(css = "input.wishlist-add-to-cart-button")
    private WebElement addToCartButton;

    @FindBy(css = "input.email-a-friend-wishlist-button")
    private WebElement emailAFriendButton;

    @FindBy(css = "a.share-link")
    private WebElement wishlistShareLink;

    // ============================================================
    // EMAIL A FRIEND
    // ============================================================

    @FindBy(id = "FriendEmail")
    private WebElement friendEmail;

    @FindBy(id = "YourEmailAddress")
    private WebElement yourEmailAddress;

    @FindBy(id = "PersonalMessage")
    private WebElement personalMessage;

    @FindBy(css = "input.send-email-a-friend-button")
    private WebElement sendEmailButton;

    @FindBy(css = "div.result")
    private WebElement emailSuccessMessage;

    @FindBy(css = "div.email-a-friend-page h1")
    private WebElement emailWishlistHeading;


    // ============================================================
    // WISHLIST PAGE
    // ============================================================

    public boolean isWishlistDisplayed() {
        return wishlistTable.isDisplayed();
    }


    // ============================================================
    // GET PRODUCT ROW
    // ============================================================

    private WebElement getProductRow(String expectedProductName) {

        String productName = expectedProductName.trim();

        String xpath =
                "//table[contains(@class,'cart')]//tr[" +
                ".//td[contains(@class,'product')]//a[" +
                "normalize-space()=\"" + productName + "\"]" +
                "]";

        List<WebElement> rows =
                driver.findElements(By.xpath(xpath));

        if (rows.isEmpty()) {
            throw new IllegalArgumentException(
                    "Product not found in Wishlist: " + productName
            );
        }

        return rows.get(0);
    }


    // ============================================================
    // PRODUCT VERIFICATION
    // ============================================================

    public boolean isProductDisplayed(String expectedProductName) {

        String productName = expectedProductName.trim();

        String xpath =
                "//table[contains(@class,'cart')]" +
                "//td[contains(@class,'product')]//a[" +
                "normalize-space()=\"" + productName + "\"]";

        return !driver.findElements(By.xpath(xpath)).isEmpty();
    }

    public boolean isProductNotDisplayed(String expectedProductName) {
        return !isProductDisplayed(expectedProductName);
    }


    // ============================================================
    // PRODUCT DETAILS
    // ============================================================

    public String getProductName(String expectedProductName) {

        WebElement row = getProductRow(expectedProductName);

        return row.findElement(
                By.cssSelector("td.product a")
        ).getText().trim();
    }

    public String getProductUnitPrice(String expectedProductName) {

        WebElement row = getProductRow(expectedProductName);

        return row.findElement(
                By.cssSelector("span.product-unit-price")
        ).getText().trim();
    }

    public String getProductSubtotal(String expectedProductName) {

        WebElement row = getProductRow(expectedProductName);

        return row.findElement(
                By.cssSelector("span.product-subtotal")
        ).getText().trim();
    }


    // ============================================================
    // QUANTITY
    // ============================================================

    public String getQuantity(String expectedProductName) {

        WebElement row = getProductRow(expectedProductName);

        return row.findElement(
                By.cssSelector("input.qty-input")
        ).getAttribute("value");
    }

    public boolean isQuantityFieldDisplayed(
            String expectedProductName) {

        WebElement row = getProductRow(expectedProductName);

        return row.findElement(
                By.cssSelector("input.qty-input")
        ).isDisplayed();
    }

    public void enterQuantity(
            String expectedProductName,
            String quantity) {

        WebElement row = getProductRow(expectedProductName);

        WebElement quantityField =
                row.findElement(
                        By.cssSelector("input.qty-input")
                );

        quantityField.clear();
        quantityField.sendKeys(quantity);
    }


    // ============================================================
    // PRODUCT SELECTION
    // ============================================================

    public void selectProduct(String expectedProductName) {

        WebElement row = getProductRow(expectedProductName);

        WebElement checkbox =
                row.findElement(By.name("addtocart"));

        if (!checkbox.isSelected()) {
            checkbox.click();
        }
    }

    public void selectRemoveProduct(String expectedProductName) {

        WebElement row = getProductRow(expectedProductName);

        WebElement checkbox =
                row.findElement(By.name("removefromcart"));

        if (!checkbox.isSelected()) {
            checkbox.click();
        }
    }


    // ============================================================
    // WISHLIST ACTIONS
    // ============================================================

    public void clickUpdateWishlist() {
        updateWishlistButton.click();
    }

    public void clickAddToCart() {
        addToCartButton.click();
    }

    public boolean isAddToCartButtonDisplayed() {
        return addToCartButton.isDisplayed();
    }


    // ============================================================
    // EMAIL A FRIEND ACTIONS
    // ============================================================

    public void clickEmailAFriend() {
        emailAFriendButton.click();
    }

    public boolean isFriendEmailFieldDisplayed() {
        return friendEmail.isDisplayed();
    }

    public void enterFriendEmail(String email) {
        friendEmail.clear();
        friendEmail.sendKeys(email);
    }

    public void enterPersonalMessage(String message) {
        personalMessage.clear();
        personalMessage.sendKeys(message);
    }

    public void clickSendEmail() {
        sendEmailButton.click();
    }

    public String getEmailSuccessMessage() {
        return emailSuccessMessage.getText().trim();
    }

    public String getEmailWishlistHeading() {
        return emailWishlistHeading.getText().trim();
    }


    // ============================================================
    // WISHLIST SHARE LINK
    // ============================================================

    public String getWishlistShareLink() {
        return wishlistShareLink.getText().trim();
    }
}