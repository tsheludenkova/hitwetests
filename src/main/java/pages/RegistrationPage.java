package pages;

import com.github.javafaker.Faker;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class RegistrationPage extends BasePage{
    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    private By chooseBoysButton = By.xpath("//*[@id=\"slide-01\"]/div/div[2]/a");
    private By chooseBoysBlackHairButton = By.xpath("//*[@id=\"slide-02-m\"]/div/div[1]/a");
    private By chooseBoysLightEyesButton = By.xpath("//*[@id=\"slide-03-m\"]/div/div[2]/a");
    private By chooseBoysUsualShapeButton = By.xpath("//*[@id=\"slide-04-m\"]/div/div[1]/a");

    private By inputName = By.xpath("//*[@id=\"slide-06\"]/form/div[1]/input");
    private By inputEmail = By.xpath("//*[@id=\"slide-06\"]/form/div[2]/input");
    private By inputGender = By.xpath("//*[@id=\"slide-06\"]/form/div[3]/div[1]/select");
    private By femaleGender = By.xpath("//*[@id=\"slide-06\"]/form/div[3]/div[1]/select/option[3]");


    public void clickOnChooseBoysButton() {
        op(chooseBoysButton, CLICKABLE).click();
    }
    public void clickOnChoseBoysBlackHairButton() {
        op(chooseBoysBlackHairButton, CLICKABLE).click();
    }
    public void clickOnChooseBoysLightEyesButton() {
        op(chooseBoysLightEyesButton, CLICKABLE).click();
    }
    public void clickOnChooseBoysUsualShapeButton() {
        op(chooseBoysUsualShapeButton, CLICKABLE).click();
    }

    public String generateRandomName() {
        Faker faker = new Faker();
        String firstName = faker.name().firstName();
        return firstName;
    }

    public void inputNameToRegistrationForm() {
        op(inputName, VISIBLE).sendKeys(generateRandomName());
    }

    public String generateRandomEmail(int length) {
        String allowedChars = "abcdefghijklmnopqrstuvwxyz" + "1234567890" + "_-.";
        String email = RandomStringUtils.random(length, allowedChars) + "@testmail.com";
        return email;
    }
    public void inputEmailToRegistrationForm() {
        op(inputEmail, VISIBLE).sendKeys(generateRandomEmail(8));
    }

    public void inputGenderToRegistrationForm()  {
        op(inputGender, VISIBLE).click();

        Actions builder = new Actions(driver);
        WebElement element = driver.findElement(By.xpath("//*[@id=\"slide-06\"]/form/div[3]/div[1]/select/option[3]"));
        builder.moveToElement(element).build().perform();



    }

}
