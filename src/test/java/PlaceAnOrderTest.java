import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertTrue;


@RunWith(Parameterized.class)
public class PlaceAnOrderTest extends BaseTest {

    // Объявили параметры теста
    private final String name;
    private final String surname;
    private final String address;
    private final String metro;
    private final String phone;
    private final String date;
    private final String term;
    private final String color;
    private final String comment;
    private final boolean useHeaderBtn;

    // Создали конструктор для инициализации параметров
    public PlaceAnOrderTest(String name, String surname, String address, String metro, String phone,
                            String date, String term, String color, String comment, boolean useHeaderBtn) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.metro = metro;
        this.phone = phone;
        this.date = date;
        this.term = term;
        this.color = color;
        this.comment = comment;
        this.useHeaderBtn = useHeaderBtn;
    }

    @Parameterized.Parameters(name = "Оформление заказа для {0} {1}")
    public static Object[] setOrderData() {
        return new Object[][]{
                {"Иван", "Иванов", "Кутузова, д. 6", "Лубянка", "89889988899",
                        "12.12.2025", "Сутки", "черный жемчуг", "Позвоните за час!", true},
                {"Саня", "Семенов", "Ленина, д. 33", "Красные Ворота", "89776677755",
                        "02.03.26", "Шестеро суток", "серая безысходность", "Пишите, могу не ответить!", false},
                {"Мария", "Шпашкина", "Петровского, д. 1", "Спортивная", "89889933399",
                        "30.08.25", "Двое суток", "черный жемчуг", "Оставьте у двери!", true},
        };
    }

    @Test // Оформление заказа (в хром тест падает)
    public void orderScooterTest() {
        if (useHeaderBtn) { // Нажатие кнопок заказать в шапке или внизу сайта
            mainPage.clickHeaderOrderBtn();
        } else {
            mainPage.scrollAndClickBottomOrderBtn();
        }
        orderPageSteps.placingAnOrder(name, surname, address, metro, phone,date, term, color, comment);
        assertTrue("Окна с информацией о выполненном заказе нет",
                orderPage.getNewOrderWindow()); // Проверили всплывающее окно
        assertTrue("Текст сообщения не соответствует",
               orderPage.getMessageNewOrder().contains("Заказ оформлен"));// Проверили текст этого окна
    }
}