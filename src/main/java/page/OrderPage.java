package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OrderPage {

    private WebDriver driver;

    //Локаторы
// Изображение при отсутствии заказа с неправильным номером
    private final By errorImgText = By.xpath("//div[@class='Track_NotFound__6oaoY']// img[@alt='Not found']");
// Окно с сообщением об успешном заказе
    private final By messageNewOrder = By.xpath("//div[@class='Order_ModalHeader__3FDaJ' and contains(text(),'Заказ оформлен')]");

    // Конструктор для веб-драйвера
    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }

// Появление изображения при отсутствии заказа с неправильным номером
    public WebElement getErrorImg() {
        WebElement errorImg = driver.findElement(errorImgText);
        new WebDriverWait(driver, Duration.ofSeconds(6)) // добавила ожидание без него тест через раз падал
                .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(errorImgText));
        return errorImg;
    }

// Получения всплывающего окна заказ оформлен
   public boolean getNewOrderWindow() {
           return driver.findElement(messageNewOrder).isDisplayed();
   }

// Сравнения текста сообщения об успешном заказе
    public String getMessageNewOrder() {
        new WebDriverWait(driver, Duration.ofSeconds(6)) // добавила ожидание без него тест через раз падал
                .until(ExpectedConditions.visibilityOfElementLocated(messageNewOrder));
        return driver.findElement(messageNewOrder).getText();
    }
}