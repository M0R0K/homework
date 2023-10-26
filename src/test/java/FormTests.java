import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import java.io.File;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class FormTests {

        @BeforeAll
        static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        }

        @Test
        void fillFormTest() {
        open("/automation-practice-form");

        //заполнение полей
        $("#firstName").setValue("Konstantin");
        $("#lastName").setValue("Ponomarenko");
        $("#userEmail").setValue("testqa@mailinator.com");
        $("[for='gender-radio-1']").click();
        $("#userNumber").setValue("7999999999");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").click();
        $(byValue("11")).click();
        $(".react-datepicker__year-select").click();
        $(byValue("1994")).click();
        $(".react-datepicker__day--030").click();
        $("#subjectsContainer").click();
        $("#subjectsInput").val("Physics").pressEnter();
        $("[for='hobbies-checkbox-1']").click();
        $("[for='hobbies-checkbox-2']").click();
        $("[for='hobbies-checkbox-3']").click();
        $("#uploadPicture").uploadFile(new File("src/test/data/picture.png"));
        $("#currentAddress").setValue("Some address");
        $("#state").scrollTo();
        $("#state").click();
        $("#react-select-3-input").val("Haryana").pressEnter();
        $("#city").click();
        $("#react-select-4-input").val("Karnal").pressEnter().pressTab().pressEnter();

        //Проверка значений
        $x("//td[text()='Student Name']/following::td[text()='Konstantin Ponomarenko']").shouldBe(visible);
        $x("//td[text()='Student Email']/following::td[text()='testqa@mailinator.com']").shouldBe(visible);
        $x("//td[text()='Gender']/following::td[text()='Male']").shouldBe(visible);
        $x("//td[text()='Mobile']/following::td[text()='7999999999']").shouldBe(visible);
        $x("//td[text()='Date of Birth']/following::td[text()='30 November,1994']").shouldBe(visible);
        $x("//td[text()='Subjects']/following::td[text()='Physics']").shouldBe(visible);
        $x("//td[text()='Hobbies']/following::td[text()='Sports, Reading, Music']").shouldBe(visible);
        $x("//td[text()='Picture']/following::td[text()='picture.png']").shouldBe(visible);
        $x("//td[text()='Address']/following::td[text()='Some address']").shouldBe(visible);
        $x("//td[text()='State and City']/following::td[text()='Haryana Karnal']").shouldBe(visible);
        }
        }