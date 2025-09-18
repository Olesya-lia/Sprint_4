package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {

    private WebDriver driver;
   // Локаторы
// Ссылка на главную страницу Самокат
    public static final String SCOOTERURL = "https://qa-scooter.praktikum-services.ru/";
// Ссылка на главную страницу Яндекс
    public static final String YANDEXURL = "https://yandex.ru";

// Кнопка принятия куки
    private By cookiesBtn = By.id("rcc-confirm-button");
// Кнопка Статус заказа
    private By statusBtn = By.className("Header_Link__1TAG7");
// Ввод номера заказа
    private By inputStatus = By.xpath("//input[@class='Input_Input__1iN_Z Header_Input__xIoUq']");
// Кнопка Go
    private By goBtn = By.xpath("//button[@class='Button_Button__ra12g Header_Button__28dPO']");
// Кнопка Заказа в шапке страницы
    private By headerOrderBtn = By.xpath("//div[@class='Header_Nav__AGCXC']/button[text()='Заказать']");
// Кнопка Заказать внизу страницы
    private By bottomOrderBtn = By.xpath("//button[@class ='Button_Button__ra12g Button_Middle__1CSJM']");
// Блок часто задаваемых вопросов
    private By faqSection = By.xpath("//div[@class='Home_FourPart__1uthg']");
// Список вопросов
    private By listOfQuestions = By.xpath("//div[contains(@id, 'accordion__heading-')]");
// Список ответов
    private By listOfAnswer = By.xpath("//div[@class='accordion__panel']/p");
// Логотип Самокат
    private By logoScooter = By.xpath("//a[@class='Header_LogoScooter__3lsAR']");
// Логотип Яндекс
    private By logoYandex = By.xpath("//a[@class='Header_LogoYandex__3TSOI']");


// Конструктор для веб-драйвера
    public MainPage(WebDriver driver) {
        this.driver = driver;
    }
    // Методы

// Открытие главной страницы
    public void openPage() {
        driver.get(SCOOTERURL);
    }

//Клик принятия куки
    public void clickCookiesBtn(){
        driver.findElement(cookiesBtn).click();
    }

// Клик по кнопке Статус заказа
    public void clickStatusBtn() {
        driver.findElement(statusBtn).click();
    }

// Ввод номера заказа
    public void setStatusNumber(String number) {
        driver.findElement(inputStatus).sendKeys(number);
    }

// Клик по кнопке Go
    public void clickGoBtn() {
        driver.findElement(goBtn).click();
    }

// Клик по кнопке Заказа в шапке страницы
    public void clickHeaderOrderBtn() {
        driver.findElement(headerOrderBtn).click();
    }

// Скролл до кнопки заказать и нажать
    public void scrollAndClickBottomOrderBtn() {
        WebElement orderBtn = driver.findElement(bottomOrderBtn);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", orderBtn);
         orderBtn.click();
    }

// Скролл до блока с вопросами
    public void scrollToFaqSection() {
        driver.findElement(faqSection);
        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView();", driver.findElement(faqSection));
    }

// Клик по вопросу
    public void clickAccordionHeader(int index) {
        driver.findElements(listOfQuestions).get(index).click();
    }

// Ждём загрузки текста ответа
    public void waitForLoadItem(int index) {
        new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.visibilityOf(driver.findElements(listOfAnswer).get(index)));
    }

// Получение текст вопроса
    public String getQuestionsText(int index) {
        return driver.findElements(listOfQuestions).get(index).getText();
    }

// Получение текста ответов
    public String getAnswerText(int index) {
        return driver.findElements(listOfAnswer).get(index).getText();
    }

// Клик по логотипу Самокат
    public void clickLogoScooter() {
        driver.findElement(logoScooter).click();
    }

// Получение ссылки с логотипа Самокат
    public String getScooterLink() {
        return driver.findElement(logoScooter).getAttribute("href");
    }

// Клик по логотипу Яндекс
    public void  clickLogoYandex (){
        driver.findElement(logoYandex).click();
    }

// Получение ссылки с логотипа Яндекс
    public String getYandexLink() {
        return driver.findElement(logoYandex).getAttribute("href");
    }

// Переход на главную страницу сайта Яндекс в новом окне
    public boolean yandexLinkOpenedInNewTab() {
        String blank = "_blank";
        String value = driver.findElement(logoYandex).getAttribute("target");
            return blank.equals(value);
    }
}