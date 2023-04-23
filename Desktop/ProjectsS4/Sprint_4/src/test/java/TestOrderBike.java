import PageObject.OrderBikePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.junit.Test;

public class TestOrderBike {

    @Test
    public void checkOrderBikeSet1() {

        WebDriver driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");

        OrderBikePage orderBike = new OrderBikePage(driver);

        orderBike.clickCookeis();
        orderBike.clickHeaderOrder();
        orderBike.fillOrderFormSet1("Сергей", "Кисленко", "Санкт-Петербург ул. Яхтенная", "89991234532");
        orderBike.clickNextBtn();
        orderBike.fillAboutRentFormSet1("первый комментарий");
        orderBike.clickLastStepOrder();
        orderBike.clickYes();
        orderBike.checkTextOnWindowAfterOrder();

        driver.quit();

    }

    @Test
    public void checkOrderBikeSet2() {

        WebDriver driver = new FirefoxDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");

        OrderBikePage orderBike = new OrderBikePage(driver);

        orderBike.clickCookeis();
        orderBike.clickFooterOrder();
        orderBike.fillOrderFormSet1("Анастасия", "Кисленко", "Санкт-Петербург ул. Яхтенная", "89111234538");
        orderBike.clickNextBtn();
        orderBike.fillAboutRentFormSet2("второй комментарий");
        orderBike.clickLastStepOrder();
        orderBike.clickYes();
        orderBike.checkTextOnWindowAfterOrder();

        driver.quit();

    }

}
