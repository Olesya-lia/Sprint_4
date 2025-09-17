import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class NonExistentOrderNumber extends BaseTest{

    // Объявили параметры теста
    private final String orderNumber;

    // Создали конструктор для инициализации параметров
    public NonExistentOrderNumber(String orderNumber){
        this.orderNumber = orderNumber;
    }

    @Parameterized.Parameters()
    public static Object [] setNumberData(){
        return new Object[][]{
                {"32"},
                {"355"},
                {"2авпр"},
        };
    }

    @Test // Статус заказа при вводе несуществующего номера заказа
    public void errorStatusTest() {
        mainPage.clickStatusBtn(); // Кнопка cтатуc заказа
        mainPage.setStatusNumber(orderNumber);//Поле ввода номер заказа
        mainPage.clickGoBtn(); // Кнопка Go
        assertTrue("Сообщение об ошибки нет",
                orderPage.getErrorImg().isDisplayed());// Проверка результата
    }
}