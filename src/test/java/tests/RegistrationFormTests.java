package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;


public class RegistrationFormTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void fillFormTest() {


        registrationPage.openPage()
                .setFirstName("Konstantin")
                .setLastName("Ponomarenko")
                .setEmail("konstantin@mailinator.com")
                .setGender("Other")
                .setUserNumber("79999999999")
                .setDateOfBirth("30", "November", "1994")
                .setSubjects("Maths")
                .setHobbie("Sports")
                .downloadImage("picture.png")
                .setAddress("Some address")
                .choiceStateAndCity("Haryana", "Karnal")
                .sendForm()
                .checkResult("Student Name", "Konstantin Ponomarenko")
                .checkResult("Student Email", "konstantin@mailinator.com")
                .checkResult("Gender", "Other")
                .checkResult("Mobile", "7999999999")
                .checkResult("Date of Birth", "30 November,1994")
                .checkResult("Subjects", "Maths")
                .checkResult("Hobbies", "Sports")
                .checkResult("Picture", "picture.png")
                .checkResult("Address", "Some address")
                .checkResult("State and City", "Haryana Karnal");

    }

    @Test
    void inputMinimumData() {
        registrationPage.openPage()
                .setFirstName("Kostya")
                .setLastName("Ponomarenko")
                .setGender("Male")
                .setUserNumber("7999999999")
                .sendForm()
                .checkResult("Student Name", "Kostya Ponomarenko")
                .checkResult("Gender", "Male")
                .checkResult("Mobile", "7999999999");

    }


    @Test
    void negativeScenario() {
        registrationPage.openPage()
                .sendForm()
                .checkTableHidden();

    }
}


