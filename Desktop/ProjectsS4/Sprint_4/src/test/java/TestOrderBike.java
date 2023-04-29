import PageObject.OrderBikePage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestOrderBike {

    private WebDriver driver;

    public static Object[][] getTextData() {
        return new Object[][] {
                { "Заказать", "Сергей", "Кисленко", "Санкт-Петербург ул. Яхтенная", "Комсомольская", "+79991234532", "25.06.2023", "сутки", "black", "первый комментарий"},
                { "Заказать в футере", "Анастасия", "Кисленко", "Санкт-Петербург ул. Яхтенная", "Чистые пруды", "+79111234538", "28.06.2023", "четверо суток", "grey", "второй комментарий"},
        };
    }


    @BeforeEach
    public void openUrl() {

        driver = new ChromeDriver();
        OrderBikePage orderBike = new OrderBikePage(driver);
        orderBike.clickCookeis();

    }

    @ParameterizedTest
    @MethodSource("getTextData")
    public void checkOrderBike(String btnName, String name, String lastName, String address, String subwayStation, String phoneNumber, String date, String periodRent, String color, String comment) {

        OrderBikePage orderBike = new OrderBikePage(driver);
        orderBike.clickOrderBtn(btnName);
        orderBike.fillOrderForm(name, lastName, address, subwayStation, phoneNumber, date, periodRent, color, comment);
        orderBike.clickLastStepOrder();
        orderBike.clickYes();
        orderBike.checkTextOnWindowAfterOrder();

    }

    @AfterEach
    public void teardown() {
        // Закрой браузер
        driver.quit();
    }

}
