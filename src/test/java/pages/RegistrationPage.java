package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.TableComponent;

import static com.codeborne.selenide.Condition.hidden;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class RegistrationPage {
    private SelenideElement firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            genderWrapper = $("#genterWrapper"),
            userNumberInput = $("#userNumber"),
            calendarInput = $("#dateOfBirthInput"),

    subjectsInput = $("#subjectsInput"),
    hobbiesSelector = $("#hobbiesWrapper"),
    uploadPictureInput = $("#uploadPicture"),
    CurrentAddressInput = $("#currentAddress"),
    selectState = $("#react-select-3-input"),
    selectCity = $("#react-select-4-input"),
    buttonSendForm = $("#submit"),

    tableClass = $(".table-responsive");


    CalendarComponent calendarComponent = new CalendarComponent();

    public RegistrationPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        return this;
    }

    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }

    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }

    public RegistrationPage setEmail(String value) {
        userEmailInput.setValue(value);

        return this;
    }

    public RegistrationPage setGender(String value) {
        genderWrapper.$(byText(value)).click();

        return this;
    }

    public RegistrationPage setUserNumber(String value) {
        userNumberInput.setValue(value);

        return this;
    }

    public RegistrationPage setDateOfBirth(String day, String month, String year) {
        calendarInput.click();
        calendarComponent.setDate(day, month, year);

        return this;
    }


    public RegistrationPage setSubjects(String value) {
        subjectsInput.setValue(value).pressEnter();

        return this;
    }

    public RegistrationPage setHobbie(String value) {
        hobbiesSelector.$(byText(value)).click();

        return this;
    }

    public RegistrationPage downloadImage(String classpath) {
        uploadPictureInput.uploadFromClasspath(classpath);

        return this;
    }

    public RegistrationPage setAddress(String address) {
        CurrentAddressInput.sendKeys(address);

        return this;
    }

    public RegistrationPage choiceStateAndCity(String state, String city) {
        selectState.setValue(state).pressEnter();
        selectCity.setValue(city).pressEnter();

        return this;
    }

    public RegistrationPage sendForm() {
        buttonSendForm.click();

        return this;
    }

    public RegistrationPage checkResult(String key, String value) {
        TableComponent.checkResult(key, value);

        return this;
    }

    public RegistrationPage checkTableHidden() {
        tableClass.shouldBe(hidden);

        return this;
    }
}
