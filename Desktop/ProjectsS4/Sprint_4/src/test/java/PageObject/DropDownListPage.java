package PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DropDownListPage {

    private static String PAGE_URL = "https://qa-scooter.praktikum-services.ru/";
    private WebDriver driver;
    // Кнопка 'Раскрыть список'
    private By accordionBtn = By.xpath("//div[@class='accordion__item']");

    // Кнопка 'Заказать' в футере
    private By footerOrderBtn = By.xpath("//div[contains(@class,'Home_FinishButton')]//button[text()='Заказать']");

    // Кнопка 'да все привыкли'
    private By acceptCookeisBtn = By.xpath("//button[text() = 'да все привыкли']");

    public DropDownListPage(WebDriver driver){

        this.driver = driver;
        driver.get(PAGE_URL);
    }

    public void scroll() {
        WebElement element = driver.findElement(footerOrderBtn);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
    }

    public void clickAcceptCookeis() { driver.findElement(acceptCookeisBtn).click(); }

    public void clickAccordionBtn(int index) {
        driver.findElements(accordionBtn).get(index).click();
    }

    public void checkAccordionTextMatchesExpectedText(int index, String expectedText) {
        String accordionText = driver.findElements(accordionBtn).get(index)
                .findElement(By.xpath(".//div[@class='accordion__panel']/p"))
                .getText();

        assertTrue(accordionText.equals(expectedText));
    }

}
