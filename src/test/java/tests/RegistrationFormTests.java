package tests;

import data.TestData;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;


public class RegistrationFormTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    TestData data = new TestData();
    String studentNameTableColumn = "Student Name";
    String studentEmailTableColumn = "Student Email";
    String studentGenderTableColumn = "Gender";
    String studentMobileTableColumn = "Mobile";
    String studentBirthTableColumn = "Date of Birth";
    String studentSubjectsTableColumn = "Subjects";
    String studentHobbiesTableColumn = "Hobbies";
    String studentAddressTableColumn = "Address";
    String studentStateCityTableColumn = "State and City";
    String studentPictureTableColumn = "Picture";
    String picturePath = "picture.png";

    @Test
    @Tag("remote-tests")
    void fillFormTest() {
        registrationPage.openPage()
                .setFirstName(data.firstName)
                .setLastName(data.lastName)
                .setEmail(data.email)
                .setGender(data.gender)
                .setUserNumber(data.phoneNumber)
                .setDateOfBirth(data.dayBirth, data.monthBirth, data.yearBirth)
                .setSubjects(data.subjects)
                .setHobbie(data.hobbies)
                .downloadImage(picturePath)
                .setAddress(data.address)
                .choiceStateAndCity(data.state, data.city)
                .sendForm()
                .checkResult(studentNameTableColumn, data.firstName)
                .checkResult(studentNameTableColumn, data.lastName)
                .checkResult(studentEmailTableColumn, data.email)
                .checkResult(studentGenderTableColumn, data.gender)
                .checkResult(studentMobileTableColumn, data.phoneNumber)
                .checkResult(studentBirthTableColumn, data.yearBirth)
                .checkResult(studentBirthTableColumn, data.monthBirth)
                .checkResult(studentBirthTableColumn, data.dayBirth)
                .checkResult(studentSubjectsTableColumn, data.subjects)
                .checkResult(studentHobbiesTableColumn, data.hobbies)
                .checkResult(studentPictureTableColumn, picturePath)
                .checkResult(studentAddressTableColumn, data.address)
                .checkResult(studentStateCityTableColumn, data.state)
                .checkResult(studentStateCityTableColumn, data.city);

    }

    @Test
    @Tag("remote-tests")
    void inputMinimumData() {
        registrationPage.openPage()
                .setFirstName(data.firstName)
                .setLastName(data.lastName)
                .setGender(data.gender)
                .setUserNumber(data.phoneNumber)
                .sendForm()
                .checkResult(studentNameTableColumn, data.firstName)
                .checkResult(studentNameTableColumn, data.lastName)
                .checkResult(studentGenderTableColumn, data.gender)
                .checkResult(studentMobileTableColumn, data.phoneNumber);
    }

    @Test
    @Tag("remote-tests")
    void negativeScenario() {
        registrationPage.openPage()
                .sendForm()
                .checkTableHidden();
    }
}


