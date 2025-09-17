import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class LogosTest extends BaseTest{

    @Test // Переход на главную страницу сайта при нажатии на логотип Самокат
    public void logoScooterTest(){
        mainPage.clickHeaderOrderBtn();
        mainPage.clickLogoScooter();
        assertTrue("Ссылка не cработала", mainPage.getScooterLink().contains(mainPage.SCOOTERURL));
    }
    @Test // Открытие в новом окне главной странице Яндекса при нажатии на логотип Яндекс
    public void logoYandexTest(){
        mainPage.clickLogoYandex();
        assertTrue("Ссылки сайта не совпали",
                mainPage.getYandexLink().contains(mainPage.YANDEXURL));
        assertTrue("Сайт не открылся в новом окне",
                mainPage.yandexLinkOpenedInNewTab());
    }
}