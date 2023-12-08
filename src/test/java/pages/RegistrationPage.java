package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.TableComponent;

import static com.codeborne.selenide.Condition.hidden;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;
import static io.qameta.allure.Allure.step;

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
        step("Открываем страницу с формой", () -> {
            open("/automation-practice-form");
            $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
            executeJavaScript("$('#fixedban').remove()");
            executeJavaScript("$('footer').remove()");

        });
        return this;
    }

    public RegistrationPage setFirstName(String value) {

        step("Заполняем имя", () -> {
            firstNameInput.setValue(value);
        });
        return this;
    }

    public RegistrationPage setLastName(String value) {
        step("Заполняем фамилию", () -> {
            lastNameInput.setValue(value);
        });
        return this;
    }

    public RegistrationPage setEmail(String value) {
        step("Заполняем e-mail", () -> {
            userEmailInput.setValue(value);
        });
        return this;
    }

    public RegistrationPage setGender(String value) {
        step("Выбираем пол", () -> {
            genderWrapper.$(byText(value)).click();
        });
        return this;
    }

    public RegistrationPage setUserNumber(String value) {
        step("Заполняем номер телефона", () -> {
            userNumberInput.setValue(value);
        });
        return this;
    }

    public RegistrationPage setDateOfBirth(String day, String month, String year) {
        step("Выбираем дату рождения", () -> {
            calendarInput.click();
            calendarComponent.setDate(day, month, year);
        });
        return this;
    }


    public RegistrationPage setSubjects(String value) {
        step("Заполняем профессию", () -> {
            subjectsInput.setValue(value).pressEnter();
        });
        return this;
    }

    public RegistrationPage setHobbie(String value) {
        step("Заполняем хобби", () -> {
            hobbiesSelector.$(byText(value)).click();
        });
        return this;
    }

    public RegistrationPage downloadImage(String classpath) {
        step("Загружаем фото", () -> {
            uploadPictureInput.uploadFromClasspath(classpath);
        });
        return this;
    }

    public RegistrationPage setAddress(String address) {
        step("Заполняем адрес", () -> {
            CurrentAddressInput.sendKeys(address);
        });
        return this;
    }

    public RegistrationPage choiceStateAndCity(String state, String city) {
        step("Заполняем штат и город", () -> {
            selectState.setValue(state).pressEnter();
            selectCity.setValue(city).pressEnter();
        });
        return this;
    }

    public RegistrationPage sendForm() {
        step("Сохраняем форму", () -> {
            buttonSendForm.click();
        });
        return this;
    }

    public RegistrationPage checkResult(String key, String value) {
        step(key + " в таблице должен содержать значение: "+ value, () -> {
            TableComponent.checkResult(key, value);
        });
        return this;
    }

    public RegistrationPage checkTableHidden() {
        step("Проверяем отсутствие таблицы на странице", () -> {
            tableClass.shouldBe(hidden);
        });
        return this;
    }
}
