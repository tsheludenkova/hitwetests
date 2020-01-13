package test;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;


public class BaseGUITest extends BaseTest {

    protected WebDriver driver;

    @Before
    public void openBrowser() {
     //     System.setProperty("webdriver.chrome.driver", "C:\\Users\\Tetiana.Sheludenkova\\IdeaProjects\\automatedtests\\src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1920,1080));
     //   driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.navigate().to("https://hitwe.com/landing/inter2?p=15276");
    }

    @After
    public void closeBrowser() {
        driver.quit();
    }


    public WebDriver getWebDriver() {
        return driver;
    }

    protected WebElement op(By locator, Function<By, ExpectedCondition<WebElement>> condition) {
        return waitFor(condition.apply(locator));
    }

   protected WebElement $(By locator) {
        return waitFor(ExpectedConditions.presenceOfElementLocated(locator));
    }

    protected WebElement $(String css) {
        return $(By.cssSelector(css));
    }

    <T> T waitFor(ExpectedCondition<T> condition, long timeout) {
        return new WebDriverWait(getWebDriver(), timeout).until(condition);
    }

    <T> T waitFor(ExpectedCondition<T> condition) {
        return waitFor(condition, 10l);
    }
}

