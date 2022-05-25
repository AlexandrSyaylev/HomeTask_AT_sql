package ru.netology;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class AppDeadLineTest {
    public class LoginPage {
        public void login(String login, String password) {
            $("input[name='login']").setValue(login);
            $("input[name='password']").setValue(password);
            $("button[data-test-id='action-login']").click();
            //$(withText("Продолжить")).click();
        }
    }

    @BeforeEach
    void setup() {
        open("http://localhost:9999");
    }

    @Test
    public void shouldSuccessLogin() {
        new LoginPage().login("vasya","password");
        $(withText("Ошибка!")).shouldBe(visible, Duration.ofSeconds(5));
        /* data-test-id='error-notification' Ошибка!
            Пароль указан неверно!
                Второй раз Ошибка! Ошибка!*/
       /* verification page notification__content Неверно указан код! Попробуйте ещё раз.*/
        /*dashbord Личный кабинет*/

        /*getUserId(vasya), getCodeThruId(getUserId(vasya))*/
    }



}
