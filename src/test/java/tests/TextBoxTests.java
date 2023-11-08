package tests;

import org.junit.jupiter.api.Test;
import pages.TextBoxPage;

public class TextBoxTests extends TestBase {
    TextBoxPage textBoxPage = new TextBoxPage();

    @Test
    void fillFormTest() {


        textBoxPage
                .openPage()
                .setName("Kostya")
                .setEmail("test@mailinator.com")
                .setCurrentAddress("Some street 1")
                .setPermanentAddress("Another street 1")
                .submitForm()
                .checkName("Kostya")
                .checkEmail("test@mailinator.com")
                .checkCurrentAddress("Some street 1")
                .checkPermanentAddress("Another street 1");


    }
}
