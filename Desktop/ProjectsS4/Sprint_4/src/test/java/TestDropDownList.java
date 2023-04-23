import PageObject.DropDownListPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.junit.Test;

public class TestDropDownList {


    @Test
    public void checkDropDownList() {


        WebDriver driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");

        DropDownListPage dropDownList = new DropDownListPage(driver);
        dropDownList.clickAcceptCookeis();
        dropDownList.scroll();

        // Проверка текста в вопросе: "Сколько это стоит? И как оплатить?"
        dropDownList.clickHowMuch();
        dropDownList.checkTextHowMuchBtn();

        // Проверка текста в вопросе: "Хочу сразу несколько самокатов! Так можно?"
        dropDownList.clickWannaSomeBikes();
        dropDownList.checkTextWannaSomeBikesBtn();

        // Проверка текста в вопросе: "Как рассчитывается время аренды?""
        dropDownList.clickHowTimeCalculated();
        dropDownList.checkTextHowTimeCalculatedBtn();

        // Проверка текста в вопросе: "Можно ли заказать самокат прямо на сегодня?"
        dropDownList.clickOrderToday();
        dropDownList.checkTextOrderTodayBtn();

        // Проверка текста в вопросе: "Можно ли продлить заказ или вернуть самокат раньше?"
        dropDownList.clickGiveBackBike();
        dropDownList.checkTextGiveBackBikeBtn();

        // Проверка текста в вопросе: "Вы привозите зарядку вместе с самокатом?"
        dropDownList.clickChargeForBike();
        dropDownList.checkTextChargeForBikeBtn();

        // Проверка текста в вопросе: "Можно ли отменить заказ?"
        dropDownList.clickCancelOrder();
        dropDownList.checkTextCancelOrderBtn();

        // Проверка текста в вопросе: "Я живу за МКАДом, привезёте?"
        dropDownList.clickNotIntoMkad();
        dropDownList.checkTextNotIntoMkadBtn();

        driver.quit();

    }

}
