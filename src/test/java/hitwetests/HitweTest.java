package hitwetests;

import org.junit.Test;
import pages.RegistrationPage;
import test.BaseGUITest;

public class HitweTest extends BaseGUITest {

    @Test
    public void registerOfNewUser(){
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.clickOnChooseBoysButton();
        registrationPage.clickOnChoseBoysBlackHairButton();
        registrationPage.clickOnChooseBoysLightEyesButton();
        registrationPage.clickOnChooseBoysUsualShapeButton();

        registrationPage.inputNameToRegistrationForm();
        registrationPage.inputEmailToRegistrationForm();
        registrationPage.inputGenderToRegistrationForm();


    }
}
