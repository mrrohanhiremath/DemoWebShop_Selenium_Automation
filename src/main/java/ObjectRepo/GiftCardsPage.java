package ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class GiftCardsPage {

    // ============================================================
    // CONSTRUCTOR
    // ============================================================

    public GiftCardsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }


    // ============================================================
    // GIFT CARDS CATEGORY PAGE
    // ============================================================

    @FindBy(css = "div.page.category-page h1")
    private WebElement giftCardsPageTitle;

    @FindBy(id = "products-viewmode")
    private WebElement viewModeDropdown;

    @FindBy(id = "products-orderby")
    private WebElement sortByDropdown;

    @FindBy(id = "products-pagesize")
    private WebElement displayPerPageDropdown;


    // ============================================================
    // GIFT CARD PRODUCTS
    // ============================================================

    @FindBy(css = "div.product-item[data-productid='1'] h2.product-title a")
    private WebElement fiveDollarGiftCard;

    @FindBy(css = "div.product-item[data-productid='2'] h2.product-title a")
    private WebElement twentyFiveDollarGiftCard;

    @FindBy(css = "div.product-item[data-productid='3'] h2.product-title a")
    private WebElement fiftyDollarGiftCard;

    @FindBy(css = "div.product-item[data-productid='4'] h2.product-title a")
    private WebElement hundredDollarGiftCard;


    // ============================================================
    // GIFT CARD PRICES
    // ============================================================

    @FindBy(css = "div.product-item[data-productid='1'] span.actual-price")
    private WebElement fiveDollarPrice;

    @FindBy(css = "div.product-item[data-productid='2'] span.actual-price")
    private WebElement twentyFiveDollarPrice;

    @FindBy(css = "div.product-item[data-productid='3'] span.actual-price")
    private WebElement fiftyDollarPrice;

    @FindBy(css = "div.product-item[data-productid='4'] span.actual-price")
    private WebElement hundredDollarPrice;


    // ============================================================
    // CATEGORY PAGE - ADD TO CART BUTTONS
    // ============================================================

    @FindBy(css = "div.product-item[data-productid='1'] input.product-box-add-to-cart-button")
    private WebElement fiveDollarAddToCartButton;

    @FindBy(css = "div.product-item[data-productid='2'] input.product-box-add-to-cart-button")
    private WebElement twentyFiveDollarAddToCartButton;

    @FindBy(css = "div.product-item[data-productid='3'] input.product-box-add-to-cart-button")
    private WebElement fiftyDollarAddToCartButton;

    @FindBy(css = "div.product-item[data-productid='4'] input.product-box-add-to-cart-button")
    private WebElement hundredDollarAddToCartButton;


    // ============================================================
    // $5 VIRTUAL GIFT CARD - PRODUCT DETAIL
    // ============================================================

    @FindBy(id = "giftcard_1_RecipientName")
    private WebElement fiveRecipientName;

    @FindBy(id = "giftcard_1_RecipientEmail")
    private WebElement fiveRecipientEmail;

    @FindBy(id = "giftcard_1_SenderName")
    private WebElement fiveYourName;

    @FindBy(id = "giftcard_1_SenderEmail")
    private WebElement fiveYourEmail;

    @FindBy(id = "giftcard_1_Message")
    private WebElement fiveMessage;

    @FindBy(id = "addtocart_1_EnteredQuantity")
    private WebElement fiveQuantity;

    @FindBy(id = "add-to-cart-button-1")
    private WebElement fiveAddToCart;

    @FindBy(id = "add-to-wishlist-button-1")
    private WebElement fiveAddToWishlist;


    // ============================================================
    // $25 VIRTUAL GIFT CARD - PRODUCT DETAIL
    // ============================================================

    @FindBy(id = "giftcard_2_RecipientName")
    private WebElement twentyFiveRecipientName;

    @FindBy(id = "giftcard_2_RecipientEmail")
    private WebElement twentyFiveRecipientEmail;

    @FindBy(id = "giftcard_2_SenderName")
    private WebElement twentyFiveYourName;

    @FindBy(id = "giftcard_2_SenderEmail")
    private WebElement twentyFiveYourEmail;

    @FindBy(id = "giftcard_2_Message")
    private WebElement twentyFiveMessage;

    @FindBy(id = "addtocart_2_EnteredQuantity")
    private WebElement twentyFiveQuantity;

    @FindBy(id = "add-to-cart-button-2")
    private WebElement twentyFiveAddToCart;

    @FindBy(id = "add-to-wishlist-button-2")
    private WebElement twentyFiveAddToWishlist;


    // ============================================================
    // $50 PHYSICAL GIFT CARD - PRODUCT DETAIL
    // ============================================================

    @FindBy(id = "giftcard_3_RecipientName")
    private WebElement fiftyRecipientName;

    @FindBy(id = "giftcard_3_SenderName")
    private WebElement fiftyYourName;

    @FindBy(id = "giftcard_3_Message")
    private WebElement fiftyMessage;

    @FindBy(id = "addtocart_3_EnteredQuantity")
    private WebElement fiftyQuantity;

    @FindBy(id = "add-to-cart-button-3")
    private WebElement fiftyAddToCart;

    @FindBy(id = "add-to-wishlist-button-3")
    private WebElement fiftyAddToWishlist;


    // ============================================================
    // $100 PHYSICAL GIFT CARD - PRODUCT DETAIL
    // ============================================================

    @FindBy(id = "giftcard_4_RecipientName")
    private WebElement hundredRecipientName;

    @FindBy(id = "giftcard_4_SenderName")
    private WebElement hundredYourName;

    @FindBy(id = "giftcard_4_Message")
    private WebElement hundredMessage;

    @FindBy(id = "addtocart_4_EnteredQuantity")
    private WebElement hundredQuantity;

    @FindBy(id = "add-to-cart-button-4")
    private WebElement hundredAddToCart;

    @FindBy(id = "add-to-wishlist-button-4")
    private WebElement hundredAddToWishlist;


    // ============================================================
    // CATEGORY PAGE METHODS
    // ============================================================

    public String getPageTitle() {
        return giftCardsPageTitle.getText();
    }

    public void selectViewMode(String visibleText) {

        Select select =
                new Select(viewModeDropdown);

        select.selectByVisibleText(visibleText);
    }

    public void selectSortBy(String visibleText) {

        Select select =
                new Select(sortByDropdown);

        select.selectByVisibleText(visibleText);
    }

    public void selectDisplayPerPage(String visibleText) {

        Select select =
                new Select(displayPerPageDropdown);

        select.selectByVisibleText(visibleText);
    }

    public String getSelectedViewMode() {
        Select select = new Select(viewModeDropdown);
        return select.getFirstSelectedOption().getText();
    }
    
    public String getSelectedSortBy() {
        Select select = new Select(sortByDropdown);
        return select.getFirstSelectedOption().getText();
    }
    
    public String getSelectedDisplayPerPage() {
        Select select = new Select(displayPerPageDropdown);
        return select.getFirstSelectedOption().getText();
    }

    // ============================================================
    // PRODUCT NAVIGATION
    // ============================================================

    public void clickFiveDollarGiftCard() {
        fiveDollarGiftCard.click();
    }

    public void clickTwentyFiveDollarGiftCard() {
        twentyFiveDollarGiftCard.click();
    }

    public void clickFiftyDollarGiftCard() {
        fiftyDollarGiftCard.click();
    }

    public void clickHundredDollarGiftCard() {
        hundredDollarGiftCard.click();
    }


    // ============================================================
    // PRICE METHODS
    // ============================================================

    public String getFiveDollarPrice() {
        return fiveDollarPrice.getText();
    }

    public String getTwentyFiveDollarPrice() {
        return twentyFiveDollarPrice.getText();
    }

    public String getFiftyDollarPrice() {
        return fiftyDollarPrice.getText();
    }

    public String getHundredDollarPrice() {
        return hundredDollarPrice.getText();
    }


    // ============================================================
    // CATEGORY PAGE - ADD TO CART
    // ============================================================

    public void addFiveDollarGiftCardToCart() {
        fiveDollarAddToCartButton.click();
    }

    public void addTwentyFiveDollarGiftCardToCart() {
        twentyFiveDollarAddToCartButton.click();
    }

    public void addFiftyDollarGiftCardToCart() {
        fiftyDollarAddToCartButton.click();
    }

    public void addHundredDollarGiftCardToCart() {
        hundredDollarAddToCartButton.click();
    }


    // ============================================================
    // $5 VIRTUAL GIFT CARD METHODS
    // ============================================================

    public void enterFiveRecipientName(String name) {
        fiveRecipientName.sendKeys(name);
    }

    public void enterFiveRecipientEmail(String email) {
        fiveRecipientEmail.sendKeys(email);
    }

    public void enterFiveYourName(String name) {
        fiveYourName.sendKeys(name);
    }

    public void enterFiveYourEmail(String email) {
        fiveYourEmail.sendKeys(email);
    }

    public void enterFiveMessage(String messageText) {
        fiveMessage.sendKeys(messageText);
    }

    public void enterFiveQuantity(String quantity) {
        fiveQuantity.clear();
        fiveQuantity.sendKeys(quantity);
    }

    public void clickFiveAddToCart() {
        fiveAddToCart.click();
    }

    public void clickFiveAddToWishlist() {
        fiveAddToWishlist.click();
    }

    public void fillFiveVirtualGiftCardDetails(
            String recipientName,
            String recipientEmail,
            String yourName,
            String yourEmail,
            String message) {

        fiveRecipientName.sendKeys(recipientName);
        fiveRecipientEmail.sendKeys(recipientEmail);
        fiveYourName.sendKeys(yourName);
        fiveYourEmail.sendKeys(yourEmail);
        fiveMessage.sendKeys(message);
    }


    // ============================================================
    // $25 VIRTUAL GIFT CARD METHODS
    // ============================================================

    public void enterTwentyFiveRecipientName(String name) {
        twentyFiveRecipientName.sendKeys(name);
    }

    public void enterTwentyFiveRecipientEmail(String email) {
        twentyFiveRecipientEmail.sendKeys(email);
    }

    public void enterTwentyFiveYourName(String name) {
        twentyFiveYourName.sendKeys(name);
    }

    public void enterTwentyFiveYourEmail(String email) {
        twentyFiveYourEmail.sendKeys(email);
    }

    public void enterTwentyFiveMessage(String messageText) {
        twentyFiveMessage.sendKeys(messageText);
    }

    public void enterTwentyFiveQuantity(String quantity) {
        twentyFiveQuantity.clear();
        twentyFiveQuantity.sendKeys(quantity);
    }

    public void clickTwentyFiveAddToCart() {
        twentyFiveAddToCart.click();
    }

    public void clickTwentyFiveAddToWishlist() {
        twentyFiveAddToWishlist.click();
    }

    public void fillTwentyFiveVirtualGiftCardDetails(
            String recipientName,
            String recipientEmail,
            String yourName,
            String yourEmail,
            String message) {

        twentyFiveRecipientName.sendKeys(recipientName);
        twentyFiveRecipientEmail.sendKeys(recipientEmail);
        twentyFiveYourName.sendKeys(yourName);
        twentyFiveYourEmail.sendKeys(yourEmail);
        twentyFiveMessage.sendKeys(message);
    }


    // ============================================================
    // $50 PHYSICAL GIFT CARD METHODS
    // ============================================================

    public void enterFiftyRecipientName(String name) {
        fiftyRecipientName.sendKeys(name);
    }

    public void enterFiftyYourName(String name) {
        fiftyYourName.sendKeys(name);
    }

    public void enterFiftyMessage(String messageText) {
        fiftyMessage.sendKeys(messageText);
    }

    public void enterFiftyQuantity(String quantity) {
        fiftyQuantity.clear();
        fiftyQuantity.sendKeys(quantity);
    }

    public void clickFiftyAddToCart() {
        fiftyAddToCart.click();
    }

    public void clickFiftyAddToWishlist() {
        fiftyAddToWishlist.click();
    }

    public void fillFiftyPhysicalGiftCardDetails(
            String recipientName,
            String yourName,
            String message) {

        fiftyRecipientName.sendKeys(recipientName);
        fiftyYourName.sendKeys(yourName);
        fiftyMessage.sendKeys(message);
    }


    // ============================================================
    // $100 PHYSICAL GIFT CARD METHODS
    // ============================================================

    public void enterHundredRecipientName(String name) {
        hundredRecipientName.sendKeys(name);
    }

    public void enterHundredYourName(String name) {
        hundredYourName.sendKeys(name);
    }

    public void enterHundredMessage(String messageText) {
        hundredMessage.sendKeys(messageText);
    }

    public void enterHundredQuantity(String quantity) {
        hundredQuantity.clear();
        hundredQuantity.sendKeys(quantity);
    }

    public void clickHundredAddToCart() {
        hundredAddToCart.click();
    }

    public void clickHundredAddToWishlist() {
        hundredAddToWishlist.click();
    }

    public void fillHundredPhysicalGiftCardDetails(
            String recipientName,
            String yourName,
            String message) {

        hundredRecipientName.sendKeys(recipientName);
        hundredYourName.sendKeys(yourName);
        hundredMessage.sendKeys(message);
    }
}