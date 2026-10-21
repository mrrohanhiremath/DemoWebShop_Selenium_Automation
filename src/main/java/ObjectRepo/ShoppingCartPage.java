package ObjectRepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ShoppingCartPage {

    private WebDriver driver;

    // ============================================================
    // CONSTRUCTOR
    // ============================================================

    public ShoppingCartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    // ============================================================
    // SHOPPING CART ELEMENTS
    // ============================================================

    @FindBy(css = "table.cart")
    private WebElement cartTable;

    @FindBy(xpath = "//ul[@class=\"shipping-results\"]")
    private WebElement shippingdetails;

    @FindBy(css = "input[name='removefromcart']")
    private WebElement removeProductCheckbox;

    @FindBy(css = "a.product-name")
    private WebElement productName;

    @FindBy(css = "span.product-unit-price")
    private WebElement productUnitPrice;

    @FindBy(css = "input.qty-input")
    private WebElement quantityField;

    @FindBy(css = "span.product-subtotal")
    private WebElement productSubtotal;

    @FindBy(css = "span.cart-qty")
    private WebElement cartQuantity;


    // ============================================================
    // CART BUTTONS
    // ============================================================

    @FindBy(css = "input.update-cart-button")
    private WebElement updateCartButton;

    @FindBy(css = "input.continue-shopping-button")
    private WebElement continueShoppingButton;


    // ============================================================
    // DISCOUNT COUPON
    // ============================================================

    @FindBy(css = "input.discount-coupon-code")
    private WebElement discountCouponField;

    @FindBy(css = "input.apply-discount-coupon-code-button")
    private WebElement applyCouponButton;


    // ============================================================
    // GIFT CARD
    // ============================================================

    @FindBy(css = "input.gift-card-coupon-code")
    private WebElement giftCardCodeField;

    @FindBy(css = "input.apply-gift-card-coupon-code-button")
    private WebElement addGiftCardButton;


    // ============================================================
    // SHIPPING
    // ============================================================

    @FindBy(id = "CountryId")
    private WebElement countryDropdown;

    @FindBy(id = "StateProvinceId")
    private WebElement stateDropdown;

    @FindBy(id = "ZipPostalCode")
    private WebElement zipCodeField;

    @FindBy(css = "input.estimate-shipping-button")
    private WebElement estimateShippingButton;

    @FindBy(xpath = "//ul[@class=\"shipping-results\"]")
    private WebElement shippingDetails;


    // ============================================================
    // CHECKOUT
    // ============================================================

    @FindBy(css = "span.product-price.order-total strong")
    private WebElement orderTotal;

    @FindBy(id = "termsofservice")
    private WebElement termsOfServiceCheckbox;

    @FindBy(id = "checkout")
    private WebElement checkoutButton;
    
    public boolean isCartEmpty() {

        return driver.findElements(
                By.cssSelector("input[name='removefromcart']")
        ).isEmpty();
    }


    // ============================================================
    // CART VERIFICATION
    // ============================================================

    public boolean isCartDisplayed() {

        try {
            return cartTable.isDisplayed();

        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }

    public boolean isShippingDetailsDisplayed() {

        try {
            return shippingDetails.isDisplayed();

        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }

    public String getCartQuantity() {
        return cartQuantity.getText();
    }

    public boolean isProductDisplayed(String expectedProductName) {

        String productName = expectedProductName.trim();

        String xpath =
                "//table[contains(@class,'cart')]" +
                "//a[contains(@class,'product-name')" +
                " and normalize-space()=\"" + productName + "\"]";

        return !driver.findElements(By.xpath(xpath)).isEmpty();
    }


    // ============================================================
    // PRODUCT DETAILS
    // ============================================================

    public String getProductName() {
        return productName.getText();
    }

    public String getProductUnitPrice() {
        return productUnitPrice.getText();
    }

    public String getProductSubtotal() {
        return productSubtotal.getText();
    }


    // ============================================================
    // QUANTITY
    // ============================================================

    public String getQuantity() {
        return quantityField.getAttribute("value");
    }

    public String getQuantity(String expectedProductName) {

        String productName = expectedProductName.trim();

        String xpath =
                "//table[contains(@class,'cart')]//tr["
                + ".//a[contains(@class,'product-name')"
                + " and normalize-space()=\"" + productName + "\"]"
                + "]";

        WebElement productRow =
                driver.findElement(By.xpath(xpath));

        return productRow
                .findElement(By.cssSelector("input.qty-input"))
                .getAttribute("value");
    }

    public void enterQuantity(String quantity) {

        quantityField.clear();
        quantityField.sendKeys(quantity);
    }


    // ============================================================
    // REMOVE PRODUCT
    // ============================================================

    public void selectRemoveProduct() {

        if (!removeProductCheckbox.isSelected()) {
            removeProductCheckbox.click();
        }
    }

    public void removeProduct(String expectedProductName) {

        String productName = expectedProductName.trim();

        String xpath =
                "//table[contains(@class,'cart')]//tr["
                + ".//a[contains(@class,'product-name')"
                + " and normalize-space()=\"" + productName + "\"]"
                + "]";

        WebElement productRow =
                driver.findElement(By.xpath(xpath));

        WebElement removeCheckbox =
                productRow.findElement(
                        By.name("removefromcart")
                );

        if (!removeCheckbox.isSelected()) {
            removeCheckbox.click();
        }

        updateCartButton.click();
    }


    // ============================================================
    // CART ACTIONS
    // ============================================================

    public void clickUpdateCart() {
        updateCartButton.click();
    }

    public void clickContinueShopping() {
        continueShoppingButton.click();
    }


    // ============================================================
    // DISCOUNT COUPON ACTIONS
    // ============================================================

    public void enterDiscountCoupon(String couponCode) {

        discountCouponField.clear();
        discountCouponField.sendKeys(couponCode);
    }

    public void clickApplyCoupon() {
        applyCouponButton.click();
    }


    // ============================================================
    // GIFT CARD ACTIONS
    // ============================================================

    public void enterGiftCardCode(String giftCardCode) {

        giftCardCodeField.clear();
        giftCardCodeField.sendKeys(giftCardCode);
    }

    public void clickAddGiftCard() {
        addGiftCardButton.click();
    }


    // ============================================================
    // SHIPPING ACTIONS
    // ============================================================

    public void selectCountry(String country) {

        Select select =
                new Select(countryDropdown);

        select.selectByVisibleText(country);
    }

    public void selectState(String state) {

        Select select =
                new Select(stateDropdown);

        select.selectByVisibleText(state);
    }

    public void enterZipCode(String zipCode) {

        zipCodeField.clear();
        zipCodeField.sendKeys(zipCode);
    }

    public void clickEstimateShipping() {
        estimateShippingButton.click();
    }


    // ============================================================
    // CHECKOUT ACTIONS
    // ============================================================

    public String getOrderTotal() {
        return orderTotal.getText();
    }

    public void selectTermsOfService() {

        if (!termsOfServiceCheckbox.isSelected()) {
            termsOfServiceCheckbox.click();
        }
    }

    public void deselectTermsOfService() {

        if (termsOfServiceCheckbox.isSelected()) {
            termsOfServiceCheckbox.click();
        }
    }

    public boolean isTermsOfServiceSelected() {
        return termsOfServiceCheckbox.isSelected();
    }

    public void clickCheckout() {
        checkoutButton.click();
    }
}