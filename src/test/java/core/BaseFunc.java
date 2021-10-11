package core;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class BaseFunc {
    final WebDriver driver;
    Actions actions;
    private WebDriverWait wait;

    public BaseFunc() {
        System.setProperty("webdriver.chrome.driver", "C:/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    public void goToUrl(String url) {
        if (url.startsWith("http://") || url.startsWith("https://")) {
            driver.get(url);
        } else {
            url = "http://" + url;
        }
        driver.get(url);
    }

    public WebElement findElement(By locator) {
        return driver.findElement(locator);
    }

    public List<WebElement> findElements(By locator) {
        assertFalse(driver.findElements(locator).isEmpty(), "No elements found by this locator");
        return driver.findElements(locator);
    }

    public void waitClick(By locator) {
        wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(locator));
        findElement(locator).click();
    }

    public void switchToTable(By locator) {
        driver.switchTo().frame(findElement(locator));
    }

    public void rightClick(By locator) {
        Actions actions = new Actions(driver);
        WebElement elementLocator = findElement(locator);
        actions.contextClick(elementLocator).perform();
    }

    public void clickOnElementById(int id, By locator) {
        findElements(locator).get(id).click();
    }

    public void clickWithShift(By locator) {
        Actions actions = new Actions(driver);
        WebElement elementLocator = findElement(locator);
        actions.keyDown(Keys.SHIFT).click(elementLocator ).build().perform();
    }

    public void leaveTable() {
        driver.switchTo().defaultContent();
    }

    public void leaveBrowser() {
        driver.quit();
    }
}
