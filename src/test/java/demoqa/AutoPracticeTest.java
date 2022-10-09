package demoqa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;


public class AutoPracticeTest extends TestBase {
    @BeforeAll
    static void configuration() {
        Configuration.baseUrl = "https://demoqa.com";
        //  Configuration.holdBrowserOpen = true;
        //    Configuration.browserSize = "1720x1440"
    }

    @Test
    void fillFormTest
    open("/automation-practice-form");
    $("#firstName").setValue("Maxim");
    $("#lastName").setValue("Dolgodvorov");
    $("#userEmail").setValue("Maxim@maxim.ru");
    $("#genterWrapper").$(byText("Male")).click();
    $("#userNumber").setValue("1234567890");
    $("#dateOfBirthInput").click();
    $(".react-datepicker__month-select").selectOption("April");
    $(".react-datepicker__year-select").selectOption("1990");
    $(".react-datepicker__day--026").click();
    $("#subjectsInput").setValue("Arts").pressEnter();
    $("hobbies-checkbox-1").click();
    $("#uploadPicture").uploadFromClasspath("pen-test.jpg");
    $("#currentAddress").setValue("Samara");
    $("#react-select-3-input").setValue("NCR").pressEnter();
    $("#react-select-4-input").setValue("Noida").pressEnter();

    $(".modal-header").shouldHave(text("Thanks for submitting the form"));
    $(".table").$(byText("Student Name")).parent().lastChild().shouldHave(text("Maxim Dolgodvorov"));
    $(".table").$(byText("Student Email")).parent().lastChild().shouldHave(text("Maxim@maxim.ru"));
    $(".table").$(byText("Gender")).parent().lastChild().shouldHave(text("Male"));
    $(".table").$(byText("Mobile")).parent().lastChild().shouldHave(text("1234567890"));
    $(".table").$(byText("Date of Birth")).parent().lastChild().shouldHave(text("26 April,1990"));
    $(".table").$(byText("Subjects")).parent().lastChild().shouldHave(text("Arts"));
    $(".table").$(byText("Hobbies")).parent().lastChild().shouldHave(text("Sports"));
    $(".table").$(byText("Picture")).parent().lastChild().shouldHave(text("pen-test.jpg"));
    $(".table").$(byText("Address")).parent().lastChild().shouldHave(text("Samara"));
    $(".table").$(byText("State and City")).parent().lastChild().shouldHave(text("NCR Noida"));

    $("#closeLargeModal").click();


}
}
