package error;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ErrorInputFields {

    private WebDriver driver;

    //Локаторы
// Ошибка для поля Имя
    private final By errorInTheNameField = By.xpath("//div[contains(text(),'Введите корректное имя')]");
// Ошибка для поля Фамилия
    private final By errorInTheSurnameField = By.xpath("//div[contains(text(),'Введите корректную фамилию')]");
// Ошибка для поля Адрес
    private final By errorInTheAddressField = By.xpath("//div[contains(text(),'Введите корректный адрес')]");
// Ошибка для поля Станция метро
    private final By errorInTheStationMetroField = By.xpath("//div[contains(text(),'Выберите станцию')]");
// Ошибка для поля Телефон
    private final By errorInThePhoneField = By.xpath("//div[contains(text(),'Введите корректный номер')]");

// Конструктор для веб-драйвера
    public ErrorInputFields(WebDriver driver) {
        this.driver = driver;
    }
// Методы для проверки появления ошибок

    public WebElement getErrorName(){
        WebElement errorName = driver.findElement(errorInTheNameField);
        return errorName;
    }

    public WebElement getErrorSurname(){
        WebElement errorSurname =driver.findElement(errorInTheSurnameField);
        return errorSurname;
    }

    public WebElement getErrorAddress(){
        WebElement errorAddress = driver.findElement(errorInTheAddressField);
        return errorAddress;
    }

    public WebElement getErrorStationMetro(){
        WebElement errorStationMetro = driver.findElement(errorInTheStationMetroField);
        return errorStationMetro;
    }

    public WebElement getErrorPhone(){
        WebElement errorPhone = driver.findElement(errorInThePhoneField);
        return errorPhone;
    }
}