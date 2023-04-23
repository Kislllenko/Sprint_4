package PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import static org.hamcrest.CoreMatchers.containsString;
import org.hamcrest.MatcherAssert;

public class OrderBikePage {

    private WebDriver driver;

    // Кнопка 'Самокат'
    private By bikeBtn = By.xpath("//img[@alt='Scooter']");

    // Кнопка 'Подтвердить'
    private By submitBtn = By.xpath("//button[@type='submit']");

    // Кнопка 'Яндекс'
    private By yandexLogoBtn = By.xpath("//img[@alt='Yandex']");

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

    // Выбор станции метро из списка
    private By subwayStationBtn = By.xpath("//input[@placeholder='* Станция метро']/../..//ul[contains(@class,'select')]//*[@data-value='4']");

    // Выбор станции метро из списка (второй набор данных)
    private By subwayStationBtnSet2 = By.xpath("//input[@placeholder='* Станция метро']/../..//ul[contains(@class,'select')]//*[@data-value='6']");

    // Поле 'Телефон' в форме заказа
    private By phoneNumberField = By.xpath("//input[@placeholder='* Телефон: на него позвонит курьер']");

    // Кнопка 'да все привыкли'
    private By cookeisBtn = By.xpath("//button[text() = 'да все привыкли']");

    // Кнопка 'Далее'
    private By nextBtn = By.xpath("//button[text()='Далее']");

    // Поле 'Когда привезти самокат'
    private By whenDeliverBikeBtn = By.xpath("//input[@placeholder='* Когда привезти самокат']");

    // Кнопка выбора даты
    private By dateBtn = By.xpath("//div[@aria-label='Choose среда, 26-е апреля 2023 г.']");

    // Кнопка выбора даты (второй набор данных)
    private By dateBtnSet2 = By.xpath("//div[@aria-label='Choose пятница, 28-е апреля 2023 г.']");

    // Кнопка 'Срок аренды'
    private By periodRentBtn = By.xpath("//div[text()='* Срок аренды']");

    // Кнопка 'сутки'
    private By oneDayBtn = By.xpath("//div[text()='сутки']");

    // Кнопка 'четверо суток'
    private By fourDaysBtn = By.xpath("//div[text()='четверо суток']");

    // Чекбокс 'серая безысходность'
    private By bikeColorCheckbox = By.xpath("//*[text()='серая безысходность']");

    // Чекбокс 'чёрный жемчуг'
    private By bikeColorCheckboxSet2 = By.xpath("//*[text()='чёрный жемчуг']");

    // Поле 'Комментарий для курьера'
    private By commentForDeliverField = By.xpath("//input[@placeholder='Комментарий для курьера']");

    // Кнопка 'Заказать' в форме для заказа
    private By lastStepOrderBtn = By.xpath("//div[contains(@class,'Order_Buttons')]//button[text()='Заказать']");

    // Кнопка 'Да'
    private By yesBtn = By.xpath("//div[@class='Order_Modal__YZ-d3']//button[text()='Да']");

    // Кнопка 'Overlay'
    private By orderOverlayWindow = By.xpath("//div[contains(@class,'Overlay')]");

    // Элемент с текстом 'Заказ оформлен'
    private By textOnWindowAfterOrder = By.xpath("//*[contains(@class,'Order_ModalHeader')]");

    public OrderBikePage(WebDriver driver) {
        this.driver = driver;
    }

    public void scrollToElementOrderBtn() {
        WebElement element = driver.findElement(footerOrderBtn);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
    }

    public void clickYandexLogo() {
        driver.findElement(yandexLogoBtn).click();
    }

    public void clickHeaderOrder() {
        driver.findElement(headerOrderBtn).click();
    }

    public void clickBike() {
        driver.findElement(bikeBtn).click();
    }

    public void clickFooterOrder() {
        driver.findElement(footerOrderBtn).click();
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

    public void fillOrderFormSet1(String name, String lastName, String address, String phoneNumber) {
        driver.findElement(nameField).sendKeys(name);
        driver.findElement(lastNameField).sendKeys(lastName);
        driver.findElement(addressField).sendKeys(address);
        driver.findElement(subwayStationField).click();
        driver.findElement(subwayStationBtn).click();
        driver.findElement(phoneNumberField).sendKeys(phoneNumber);
    }

    public void fillOrderFormSet2(String name, String lastName, String address, String phoneNumber) {
        driver.findElement(nameField).sendKeys(name);
        driver.findElement(lastNameField).sendKeys(lastName);
        driver.findElement(addressField).sendKeys(address);
        driver.findElement(subwayStationField).click();
        driver.findElement(subwayStationBtnSet2).click();
        driver.findElement(phoneNumberField).sendKeys(phoneNumber);
    }

    public void fillAboutRentFormSet1(String comment) {
        driver.findElement(whenDeliverBikeBtn).click();
        driver.findElement(dateBtn).click();
        driver.findElement(periodRentBtn).click();
        driver.findElement(oneDayBtn).click();
        driver.findElement(bikeColorCheckbox).click();
        driver.findElement(commentForDeliverField ).sendKeys(comment);
    }

    public void fillAboutRentFormSet2(String comment) {
        driver.findElement(whenDeliverBikeBtn).click();
        driver.findElement(dateBtnSet2).click();
        driver.findElement(periodRentBtn).click();
        driver.findElement(fourDaysBtn).click();
        driver.findElement(bikeColorCheckboxSet2).click();
        driver.findElement(commentForDeliverField ).sendKeys(comment);
    }

    public void checkTextOnWindowAfterOrder() {
        String actualText = driver.findElement(textOnWindowAfterOrder).getText();
        String expected = "Заказ оформлен";
        MatcherAssert.assertThat(actualText, containsString(expected));
    }
}
