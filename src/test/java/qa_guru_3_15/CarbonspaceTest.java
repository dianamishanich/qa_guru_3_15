package qa_guru_3_15;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.aeonbits.owner.ConfigFactory;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class CarbonspaceTest {
    ErnestHemingway config = ConfigFactory.newInstance().create(ErnestHemingway.class);

    String userLogin = config.userLogin(),
           userPassword = config.userPassword(),
           year = "2016",
           month = "July",
           year0 = "2000",
           year1 = "2016";

    @BeforeAll
    static void setup() {
        Configuration.startMaximized = true;
    }

    @BeforeEach
    public void logIn() {
        open("https://my.carbonspace.tech/");
        $("input[name='username']").val(userLogin);
        $("input[name='password']").val(userPassword);
        $(".ant-btn.ant-btn-primary").click();
    }

    @Test
    @DisplayName("Главное меню и страницы")
    public void authorizationTest() {

        $(byText("Carbon Profile")).click();
        $(".ui.card.page-content").shouldHave(text("Area"));
        $(byText("Carbon Analytics")).click();
        $(".header-title").shouldHave(text("Carbonspace Grünes Herz GmbH"));

    }

    @Test
    @DisplayName("Выбор периода времени в фильтре Carbon Map")
    public void CarbonMapFilterTest(){
    open("https://my.carbonspace.tech/map");
    $(".main_dropdown_year").$(".ui.inline.dropdown").click();
    $(".visible.menu.transition").$(byText(year)).click();
    $(".main_dropdown_month").$(".ui.inline.dropdown").click();
    $(".visible.menu.transition").$(byText(month)).click();
    $(".counts").shouldHave(text("-7.213Mt"));
    }

    @Test
    @DisplayName("Аналитика с выбором параметров в Carbon Analytics")
    public void CarbonAnalyticFilterTest(){
        open("https://my.carbonspace.tech/analytics");
        $(".ui.container.dropdowns").click();
        $(".visible.menu.transition").$(byText(year0)).scrollTo().click();
        $(".ui.container.dropdowns").sibling(1).click();
        $(".visible.menu.transition").$(byText(year1)).scrollTo().click();
        $(".recharts-cartesian-axis-ticks").shouldHave(text(year0), text(year1));
    }

}
