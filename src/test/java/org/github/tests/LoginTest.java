package org.github.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class LoginTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "http://demowebshop.tricentis.com";
    }

    @BeforeEach
    void configureBrowser() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Log in as a user with valid credentials")
    void loginTest() {
        step("Open login form", () -> {
            open("/login");
        });
        step("Enter email", () -> {
            $("#Email").setValue("testing@email.ru");

        });
        step("Enter password", () -> {
            $("#Password").setValue("testing");
        });
        step("Click login button", () -> {
            $x("//input[@value='Log in']").click();
        });
    }
}
