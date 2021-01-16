package qa_guru_3_15;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.aeonbits.owner.ConfigFactory;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class CarbonspaceTest {
    //Авторизация и открытие главной страницы
    @Test
    @DisplayName("Авторизация и открытие главной страницы")
    public void authorizationTest() {
        ErnestHemingway config = ConfigFactory.newInstance().create(ErnestHemingway.class);

        String userLogin = config.userLogin(),
               userPassword = config.userPassword();
        open("https://my.carbonspace.tech/");
        $("input[placeholder='Login']").val(userLogin);
        $("input[placeholder='Password']").val(userPassword);
        $(".ant-btn.ant-btn-primary").click();


    }
    //Главное меню
    /*@Test
    @DisplayName("Главное меню")
    void mainMenuTest() {
        open("https://my.carbonspace.tech/");
        $$(".ui large top fixed menu").byText("Carbon Profile").click;

    }*/

    //Выбор периода времени в фильтре CarbonMap
    //Маштабирование и определение текущей координаты на CarbonMap
    //Аналитика с выбором параметров в Carbon Analytics
    //Выбор сегментов в Carbon Profile
    //Личный кабинет: изменение пароля/выход


}
