package tests;

import data.TestData;
import org.junit.jupiter.api.Test;
import pages.TextBoxPage;

public class TextBoxTests extends TestBase {
    TextBoxPage textBoxPage = new TextBoxPage();
    TestData data = new TestData();

    @Test
    void fillFormTest() {


        textBoxPage.openPage()
                .setName(data.firstName)
                .setEmail(data.email)
                .setCurrentAddress(data.address)
                .setPermanentAddress(data.permanentAddress)
                .submitForm().checkName(data.firstName)
                .checkEmail(data.email)
                .checkCurrentAddress(data.address)
                .checkPermanentAddress(data.permanentAddress);
    }
}
