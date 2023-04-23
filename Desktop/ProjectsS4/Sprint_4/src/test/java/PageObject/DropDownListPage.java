package PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import static org.junit.Assert.*;

public class DropDownListPage {

    private WebDriver driver;
    // Кнопка 'Сколько это стоит? И как оплатить?'
    private By howMuchBtn = By.xpath("//*[text() ='Сколько это стоит? И как оплатить?']");

    // Кнопка 'Хочу сразу несколько самокатов! Так можно?'
    private By wannaSomeBikesBtn = By.xpath("//*[text() ='Хочу сразу несколько самокатов! Так можно?']");

    // Кнопка 'Как рассчитывается время аренды?'
    private By howTimeCalculatedBtn = By.xpath("//*[text() ='Как рассчитывается время аренды?']");

    // Кнопка 'Можно ли заказать самокат прямо на сегодня?'
    private By orderTodayBtn = By.xpath("//*[text() ='Можно ли заказать самокат прямо на сегодня?']");

    // Кнопка 'Можно ли продлить заказ или вернуть самокат раньше?'
    private By giveBackBikeBtn = By.xpath("//*[text() ='Можно ли продлить заказ или вернуть самокат раньше?']");

    // Кнопка 'Вы привозите зарядку вместе с самокатом?'
    private By chargeForBikeBtn = By.xpath("//*[text() ='Вы привозите зарядку вместе с самокатом?']");

    // Кнопка 'Можно ли отменить заказ?'
    private By cancelOrderBtn = By.xpath("//*[text() ='Можно ли отменить заказ?']");

    // Кнопка 'Я жизу за МКАДом, привезёте?'
    private By notIntoMkadBtn = By.xpath("//*[text() ='Я жизу за МКАДом, привезёте?']");

    // Кнопка 'да все привыкли'
    private By acceptCookeisBtn = By.xpath("//button[text() = 'да все привыкли']");

    // Текст после клика на кнопку 'Сколько это стоит? И как оплатить?'
    private By textHowMuchBtn = By.xpath("//*[@id='accordion__panel-0']");

    // Текст после клика на кнопку 'Хочу сразу несколько самокатов! Так можно?'
    private By textWannaSomeBikesBtn = By.xpath("//*[@id='accordion__panel-1']");

    // Текст после клика на кнопку 'Как рассчитывается время аренды?'
    private By textHowTimeCalculatedBtn = By.xpath("//*[@id='accordion__panel-2']");

    // Текст после клика на кнопку 'Можно ли заказать самокат прямо на сегодня?'
    private By textOrderTodayBtn = By.xpath("//*[@id='accordion__panel-3']");

    // Текст после клика на кнопку 'Можно ли продлить заказ или вернуть самокат раньше?'
    private By textGiveBackBikeBtn = By.xpath("//*[@id='accordion__panel-4']");

    // Текст после клика на кнопку 'Вы привозите зарядку вместе с самокатом?'
    private By textChargeForBikeBtn = By.xpath("//*[@id='accordion__panel-5']");

    // Текст после клика на кнопку 'Можно ли отменить заказ?'
    private By textCancelOrderBtn = By.xpath("//*[@id='accordion__panel-6']");

    // Текст после клика на кнопку 'Я жизу за МКАДом, привезёте?'
    private By textNotIntoMkadBtn = By.xpath("//*[@id='accordion__panel-7']");

    public DropDownListPage(WebDriver driver){
        this.driver = driver;
    }

    public void scroll() {
        WebElement element = driver.findElement(cancelOrderBtn);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
    }

    public void clickAcceptCookeis() { driver.findElement(acceptCookeisBtn).click(); }

    public void clickHowMuch() {
        driver.findElement(howMuchBtn).click();
    }

    public void clickWannaSomeBikes() {
        driver.findElement(wannaSomeBikesBtn).click();
    }

    public void clickHowTimeCalculated() {
        driver.findElement(howTimeCalculatedBtn).click();
    }

    public void clickOrderToday() {
        driver.findElement(orderTodayBtn).click();
    }

    public void clickGiveBackBike() {
        driver.findElement(giveBackBikeBtn).click();
    }

    public void clickChargeForBike() {
        driver.findElement(chargeForBikeBtn).click();
    }

    public void clickCancelOrder() {
        driver.findElement(cancelOrderBtn).click();
    }

    public void clickNotIntoMkad() {
        driver.findElement(notIntoMkadBtn).click();
    }

    public void checkTextHowMuchBtn() {
        String actualText = driver.findElement(textHowMuchBtn).getText();
        String expected = "Сутки — 400 рублей. Оплата курьеру — наличными или картой.";
        assertEquals("Неверный текст!", expected, actualText);
    }

    public void checkTextWannaSomeBikesBtn() {
        String actualText = driver.findElement(textWannaSomeBikesBtn).getText();
        String expected = "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.";
        assertEquals("Неверный текст!", expected, actualText);
    }

    public void checkTextHowTimeCalculatedBtn() {
        String actualText = driver.findElement(textHowTimeCalculatedBtn).getText();
        String expected = "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.";
        assertEquals("Неверный текст!", expected, actualText);
    }

    public void checkTextOrderTodayBtn() {
        String actualText = driver.findElement(textOrderTodayBtn).getText();
        String expected = "Только начиная с завтрашнего дня. Но скоро станем расторопнее.";
        assertEquals("Неверный текст!", expected, actualText);
    }

    public void checkTextGiveBackBikeBtn() {
        String actualText = driver.findElement(textGiveBackBikeBtn).getText();
        String expected = "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.";
        assertEquals("Неверный текст!", expected, actualText);
    }

    public void checkTextChargeForBikeBtn() {
        String actualText = driver.findElement(textChargeForBikeBtn).getText();
        String expected = "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.";
        assertEquals("Неверный текст!", expected, actualText);
    }

    public void checkTextCancelOrderBtn() {
        String actualText = driver.findElement(textCancelOrderBtn).getText();
        String expected = "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.";
        assertEquals("Неверный текст!", expected, actualText);
    }

    public void checkTextNotIntoMkadBtn() {
        String actualText = driver.findElement(textNotIntoMkadBtn).getText();
        String expected = "Да, обязательно. Всем самокатов! И Москве, и Московской области.";
        assertEquals("Неверный текст!", expected, actualText);
    }


}
