package PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import static org.hamcrest.CoreMatchers.containsString; // импорт матчера containsString
import org.hamcrest.MatcherAssert;


public class OrderBikePage {

    private static String PAGE_URL = "https://qa-scooter.praktikum-services.ru/";

    private WebDriver driver;

    // Кнопка 'Заказать' в шапке
    private By headerOrderBtn = By.xpath("//button[text()='Статус заказа']/..//button[text()='Заказать']");

    // Кнопка 'Заказать' в футере
    private By footerOrderBtn = By.xpath("//div[contains(@class,'Home_FinishButton')]//button[text()='Заказать']");

    // Поле 'Имя' в форме заказа
    private By nameField = By.xpath("//input[@placeholder='* Имя']");

    // Поле 'Фамилия' в форме заказа
    private By lastNameField = By.xpath("//input[@placeholder='* Фамилия']");

    // Поле 'Адрес' в форме заказа
    private By addressField = By.xpath("//input[@placeholder='* Адрес: куда привезти заказ']");

    // Поле 'Станция метро' в форме заказа
    private By subwayStationField = By.xpath("//input[@placeholder='* Станция метро']");

    // Поле 'Телефон' в форме заказа
    private By phoneNumberField = By.xpath("//input[@placeholder='* Телефон: на него позвонит курьер']");

    // Кнопка 'да все привыкли'
    private By cookeisBtn = By.xpath("//button[text() = 'да все привыкли']");

    // Кнопка 'Далее'
    private By nextBtn = By.xpath("//button[text()='Далее']");

    // Поле 'Когда привезти самокат'
    private By whenDeliverBikeBtn = By.xpath("//input[@placeholder='* Когда привезти самокат']");

    // Кнопка 'Срок аренды'
    private By periodRentBtn = By.xpath("//div[text()='* Срок аренды']");

    // Чекбокс 'серая безысходность'
    private By blackColorInput = By.xpath("//*[text()='серая безысходность']");
    // Чекбокс 'чёрный жемчуг'
    private By greyColorInput = By.xpath("//*[text()='чёрный жемчуг']");

    // Поле 'Комментарий для курьера'
    private By commentForDeliverField = By.xpath("//input[@placeholder='Комментарий для курьера']");

    // Кнопка 'Заказать' в форме для заказа
    private By lastStepOrderBtn = By.xpath("//div[contains(@class,'Order_Buttons')]//button[text()='Заказать']");

    // Кнопка 'Да'
    private By yesBtn = By.xpath("//div[@class='Order_Modal__YZ-d3']//button[text()='Да']");

    // Элемент с текстом 'Заказ оформлен'
    private By textOnWindowAfterOrder = By.xpath("//*[contains(@class,'Order_ModalHeader')]");

    public OrderBikePage(WebDriver driver) {

        this.driver = driver;
        driver.get(PAGE_URL);
    }

    public void clickOrderBtn(String  btnName) {
        if (btnName == "Заказать") {
            driver.findElement(headerOrderBtn).click();
        } else {
            WebElement element = driver.findElement(footerOrderBtn);
            ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
            driver.findElement(footerOrderBtn).click();
        }
    }


    public void clickCookeis() {
        driver.findElement(cookeisBtn).click();
    }

    public void clickNextBtn() {
        driver.findElement(nextBtn).click();
    }

    public void clickLastStepOrder() {
        driver.findElement(lastStepOrderBtn).click();
    }

    public void clickYes() {
        driver.findElement(yesBtn).click();
    }

    public void clickColor(String color) {
        if (color == "black") {
            driver.findElement(blackColorInput).click();
        } else {
            driver.findElement(greyColorInput).click();
        }
    }

    public void clickSubwayStation(String subwayStation) {
        driver.findElement(
                By.xpath(".//div[contains(@class, 'Order_Content')]//div[contains(@class, 'Order_Text') and text()='" + subwayStation + "']")
        ).click();
    }

    public void clickPeriodRent(String period) {
        driver.findElement(By.xpath("//div[contains(@class, 'Dropdown-menu')]//div[text()='" + period + "']")).click();
    }

    public void fillOrderForm(String name, String lastName, String address, String subwayStation, String phoneNumber, String date, String periodRent, String color, String comment) {

        driver.findElement(nameField).sendKeys(name);
        driver.findElement(lastNameField).sendKeys(lastName);
        driver.findElement(addressField).sendKeys(address);
        driver.findElement(subwayStationField).sendKeys(subwayStation);
        clickSubwayStation(subwayStation);
        driver.findElement(phoneNumberField).sendKeys(phoneNumber);
        clickNextBtn();
        driver.findElement(whenDeliverBikeBtn).sendKeys(date);
        clickColor(color);
        driver.findElement(periodRentBtn).click();
        clickPeriodRent(periodRent);
        driver.findElement(commentForDeliverField ).sendKeys(comment);
    }

    public void checkTextOnWindowAfterOrder() {
        String actualText = driver.findElement(textOnWindowAfterOrder).getText();
        String expected = "Заказ оформлен";
        MatcherAssert.assertThat(actualText, containsString(expected));
    }
}
