package pageObjects;

import driver.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AddToCart {

    public AddToCart() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(css = "#search input")
    public WebElement eSearchBoxTop;

    @FindBy(css = "#search button")
    public WebElement eSearchButtonTop;

    @FindBy(css = "#product-search")
    public WebElement eSearchContainer;

    @FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
    public WebElement eAlertSuccess;

    @FindBy(xpath = "//div[@id='top-links']//a[contains(.,'Shopping Cart')]")
    public WebElement eMenuShoppingCart;

    @FindBy(xpath = "//button[@data-original-title='Remove']")
    public WebElement eRemoveButton;

    @FindBy(xpath = "(//div//p[contains(text(),'Your shopping cart is empty!')])[2]")
    public WebElement eCartEmptyMessage;

    @FindBy(xpath = "//div[@class='product-thumb']")
    public List<WebElement> lListedProducts;

    @FindBy(xpath = "//div[@id='cart']//button[not(@title)]")
    public WebElement lCartButton;

    @FindBy(css = ".dropdown-menu table")
    public WebElement lCartFirstTable;

    @FindBy(xpath = "//div[@id='top-links']/ul/li/a")
    public List<WebElement> lTopMenu;

    @FindBy(xpath = "//button[@data-original-title='Add to Cart']")
    public List<WebElement> lWishListAddToCart;

    @FindBy(xpath = "//div[@class='table-responsive']//tbody//tr")
    public List<WebElement> lShoppingCartProducts;

}
