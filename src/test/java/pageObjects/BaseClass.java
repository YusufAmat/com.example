package pageObjects;

import driver.Browsers;
import driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.PropertyReader;

public class BaseClass {

    protected WebDriver driver;
    protected WebDriverWait wait;


    {
        driver = Driver.getDriver();
        wait = Driver.getWait();
    }

    public void click(By locator){
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        click(element);
    }


    public void click(WebElement element){
        wait.until(driver1 -> {
            try {
                element.click();
                return true;
            }catch (Exception e1){
                try {
                    new Actions(driver1).moveToElement(element).click().perform();
                    return true;
                }catch (Exception e2){
                    try {
                        ((JavascriptExecutor) driver1).executeScript("arguments[0].click()", element);
                        return true;
                    }catch (Exception e3){
                        return false;
                    }
                }
            }
        });

    }

    public void sendKeys(By locator, String text){
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        sendKeys(element, text);
    }

    public void sendKeys(WebElement element, String text){
        wait.until(driver1 -> {
            try {
                element.clear();
                element.sendKeys(text);
                return true;
            }catch (Exception e1){
                try {
                    element.clear();
                    new Actions(driver1).moveToElement(element).sendKeys(text).perform();
                    return true;
                }catch (Exception e2){
                    try {
                        element.clear();
                        ((JavascriptExecutor) driver1).executeScript("arguments[0].value='" + text + "'", element);
                        return true;
                    }catch (Exception e3){
                        return false;
                    }
                }
            }
        });
    }

    public void hoverOverByAction(WebElement element) {
        new Actions(driver)
                .moveToElement(element)
                .pause(500)
                .build()
                .perform();
    }

    public void hoverOverByAction(By locator) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        hoverOverByAction(element);
    }

    public void scrollToElement (WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", element);
    }

    public void scrollToElement (By locator){
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        scrollToElement(element);
    }

    public void assertChangeColor(WebElement element, String color) {
        String bgColorRGB = element.getCssValue("color");
        String bgColorHex = Color.fromString(bgColorRGB).asHex();
        Assert.assertEquals(bgColorHex, color);
    }

    public void assertChangeColor(By locator, String color) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        assertChangeColor(element, color);
    }

    public void waitForVisibility(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForVisibility(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void waitForInvisibility(WebElement element) {
        wait.until(ExpectedConditions.invisibilityOf(element));
    }
}
