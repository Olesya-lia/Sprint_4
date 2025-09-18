package steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static java.time.Duration.ofSeconds;

public class OrderPageSteps {

    private WebDriver driver;

   // Локаторы
// Форма регистрации заказа
    private By orderForm = By.xpath("//div[@class='Order_Content__bmtHS']");
// Поле Имя
    private By fieldName = By.xpath("//input[@placeholder ='* Имя']");
// Поле Фамилия
    private By fieldSurname = By.xpath("//input[@placeholder = '* Фамилия']");
// Поле адреса доставки
    private By fieldAddress = By.xpath("//input[@placeholder='* Адрес: куда привезти заказ']");
// Поле станции метро
    private By fieldChoiceMetro = By.xpath("//input[@placeholder='* Станция метро']");
// Список станций метро
    private By metroStationList = By.xpath(".//div[@class='select-search__select']");
// Поле номер телефона
    private By fieldNumberPhone = By.xpath("//input[@placeholder='* Телефон: на него позвонит курьер']");
// Кнопка Далее
    private By nextBtn = By.xpath("//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");
// Форма "про аренду" самоката
    private By formAboutRent = By.xpath("//div[@class='Order_Content__bmtHS']");
// Поле даты
    private By dateInput = By.xpath("//input[@placeholder='* Когда привезти самокат']");
// Выбор даты из календаря
    private By selectedDate = By.className("react-datepicker__day--selected");
// Поле Срок аренды
    private By fieldTermLease = By.xpath("//div[@class='Dropdown-root']");
// Выпадающий список срок аренды
    private By termSelectionLease = By.xpath("//div[contains(@class, 'Dropdown-option')]");
// Чекбокс "Черный жемчуг"
    private By colorScooterBlack = By.id("black");
// Чекбокс "Серая безысходность"
    private By colorScooterGrey = By.id("grey");
// Поле комментарий
    private By fieldComment = By.xpath("//input[@placeholder='Комментарий для курьера']");
// Кнопка заказать в форме про аренду
    private By toOrderBtn = By.xpath("//button[@class ='Button_Button__ra12g Button_Middle__1CSJM' and text()='Заказать']");
// Кнопка Да, подтвердить заказ
    private By confirmOrderBtn = By.xpath("//button[@class = 'Button_Button__ra12g Button_Middle__1CSJM' and text()='Да']");

    // Конструктор для веб-драйвера
    public OrderPageSteps(WebDriver driver) {
        this.driver = driver;
    }

    // Ждем форму регистрации для аренды самоката
    public void waitForOrderForm() {
        driver.findElement(orderForm);
        new WebDriverWait(driver, ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(orderForm));
    }

// Ввод в поле Имя
    public void setName(String name) {
        driver.findElement(fieldName).sendKeys(name);
    }

// Ввод в поле Фамилия
    public void setSurname(String surname) {
        driver.findElement(fieldSurname).sendKeys(surname);
    }

// Ввод в поле адрес
    public void setAddress(String address) {
        driver.findElement(fieldAddress).sendKeys(address);
    }

// Ожидание для загрузки нужного элемента
    private void waitForElementToLoad(By elementToLoad) {
        new WebDriverWait(driver, Duration.ofSeconds(50))
                .until(ExpectedConditions.visibilityOf(driver.findElement(elementToLoad)));
    }

// Метод для выбора элемента из выпадающего списка
    private void chooseElementFromDropdown(By dropdownLocator, String elementText) {
        List<WebElement> elements = driver.findElements(dropdownLocator);
        for (WebElement element : elements) {
            if (element.getText().equals(elementText)) {
                element.click();
                return;
            }
        }
    }

// Выбор станции метро
    public void selectMetroStation(String metro) {
        driver.findElement(fieldChoiceMetro).sendKeys(metro);
        waitForElementToLoad(fieldChoiceMetro);
        chooseElementFromDropdown(metroStationList, metro);
    }

 // Закрыть список станций метро
    public void closeMetroStation() {
        driver.findElement(fieldChoiceMetro).click();
        driver.findElement(fieldChoiceMetro).click();
    }

// Ввод номер телефона
    public void setNumberPhone(String phone) {
        driver.findElement(fieldNumberPhone).sendKeys(phone);
    }

// Клик по кнопке Далее
    public void clickNextBtn() {
       // new WebDriverWait(driver, ofSeconds(6))
                //.until(ExpectedConditions.elementToBeClickable(nextBtn));
        driver.findElement(nextBtn).click();
    }

// Ждем форму про аренду самоката
    public void getFormAboutRent() {
        driver.findElement(formAboutRent);
        new WebDriverWait(driver, ofSeconds(6))
                .until(ExpectedConditions.visibilityOfElementLocated(formAboutRent));
    }

// Клик по выбранной дате
    private void clickSelectDate() {
        driver.findElement(selectedDate).click();
    }

// Выбор даты доставки
    public void setDateInput(String date) {
        driver.findElement(dateInput).sendKeys(date);
        waitForElementToLoad(selectedDate);
        clickSelectDate();
    }

// Список аренды и клик
    private void clickRentTermChoosing() {
        driver.findElement(termSelectionLease).click();
    }

// Выбор Срок аренды из выпадающего списка с загрузкой элемента
    public void setTermLease(String term) {
        driver.findElement(fieldTermLease).click();
        clickRentTermChoosing();
        chooseElementFromDropdown(fieldTermLease, term);
    }

// Клик выбора черного цвета
    public void clickCheckBoxBlack() {
        driver.findElement(colorScooterBlack).click();
    }

// Клик выбора серого цвета
    public void clickCheckBoxGrey() {
        driver.findElement(colorScooterGrey).click();
    }

// метод выбора цвета
    public void selectColorScooter(String color) {
        if (color.equals("черный жемчуг")) {
            clickCheckBoxBlack();
        } else if (color.equals("серая безысходность")) {
            clickCheckBoxGrey();
        }
    }

// Ввод комментария
    public void setFieldComment(String string) {
        driver.findElement(fieldComment).sendKeys(string);
    }

// Клик по кнопке заказать
    public void clickToOrderBtn() {
        driver.findElement(toOrderBtn).click();
    }

// Клик подтвердить заказ по кнопке да
    public void clickConfirmOrderBtn() {
        driver.findElement(confirmOrderBtn).click();
    }

// Метод оформления заказа
    public void placingAnOrder(String name, String surname, String address, String metro,
                               String phone, String date, String term, String color, String comment) {
        waitForOrderForm();
        setName(name);
        setSurname(surname);
        setAddress(address);
        selectMetroStation(metro);
        setNumberPhone(phone);
        clickNextBtn();

        getFormAboutRent();
        setDateInput(date);
        setTermLease(term);
        selectColorScooter(color);
        setFieldComment(comment);

        clickToOrderBtn();
        clickConfirmOrderBtn();
    }
}