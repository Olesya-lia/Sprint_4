import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import page.MainPage;
import page.OrderPage;
import steps.OrderPageSteps;
import error.ErrorInputFields;


public class BaseTest {

    //Объявили переменные
    WebDriver driver; // для управления браузером
    static MainPage mainPage; // для главной страницы
    OrderPage orderPage; // для страницы заказов
    static OrderPageSteps orderPageSteps; // для шагов оформления заказа
    static ErrorInputFields errorInputFields; // для проверки ошибок в полях формы заказа

    @Before
    public void startUp() {
// выбор браузера на основании переменной, по умолчанию хром
        String browser = System.getProperty("browser", "chrome");
        if (browser.equals("chrome")) {
            startBrowserChrome();
        } else if (browser.equals("firefox")) {
            startBrowserFirefox();
        }
// инициализация
        mainPage = new MainPage(driver);
        orderPage = new OrderPage(driver);
        orderPageSteps = new OrderPageSteps(driver);
        errorInputFields = new ErrorInputFields(driver);
        mainPage.openPage();
        mainPage.clickCookiesBtn();
    }

// методы запуска браузеров
    public void startBrowserChrome(){
        driver = new ChromeDriver();
        WebDriverManager.chromedriver().setup();
    }

    public void startBrowserFirefox(){
        driver = new FirefoxDriver();
        WebDriverManager.firefoxdriver().setup();
    }

    @After
    public void tearDown() {
        // удалить все куки
        driver.manage().deleteAllCookies();
        //закрытие браузера
        driver.quit();
    }
}