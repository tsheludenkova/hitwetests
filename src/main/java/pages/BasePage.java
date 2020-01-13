package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import test.BaseGUITest;

import java.util.function.Function;

public class BasePage extends BaseGUITest {
    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @Override
    public WebDriver getWebDriver() {
        return driver;
    }

    protected final Function<By, ExpectedCondition<WebElement>> VISIBLE = ExpectedConditions::visibilityOfElementLocated;
    protected final Function<By, ExpectedCondition<WebElement>> CLICKABLE = ExpectedConditions::elementToBeClickable;

}
