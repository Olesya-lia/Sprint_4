import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertTrue;


@RunWith(Enclosed.class)
public class ErrorForAllFieldsTest extends BaseTest {

// Поле Имя
    @RunWith(Parameterized.class)
    public static class ErrorInFieldName extends BaseTest {
        // Объявили параметры теста
        private String name;

        // Создали конструктор для инициализации параметров
        public ErrorInFieldName(String name) {
            this.name = name;
        }

        @Parameterized.Parameters (name = "Неверный ввод имени: {0}")
        public static Object[] setNameData() {
            return new Object[][]{
                    // Невалидные данные для проверки
                    {"Ivan"},// Неверный формат
                    {""}, // Не заполненное поле
                    {"И"}, // Меньше допустимого количества символов
                    {"АлександрАлексан"}, // Превышающие количество допустимых символов
            };
        }

        @Test
        public void errorNameTest() {
            mainPage.clickHeaderOrderBtn(); // Нажатие кнопок Заказать в шапке
            orderPageSteps.setName(name); // Ввод данных в поле имя
            orderPageSteps.clickNextBtn(); // Нажать кнопку далее
            assertTrue("Ошибка не появилась",
                    errorInputFields.getErrorName().isDisplayed()); // Проверяем что ошибка появилась
        }
    }

// Поле Фамилия
    @RunWith(Parameterized.class)
    public static class ErrorInFieldSurame extends BaseTest {
        // Объявили параметры теста
        private static String surname;

        // Создали конструктор для инициализации параметров
        public ErrorInFieldSurame(String surname) {
            this.surname = surname;
        }

        @Parameterized.Parameters (name = "Неверный ввод фамилии: {0}")
        public static Object[] setSurnameData() {
            return new Object[][]{
                    // Невалидные данные
                    {"Ivanov"},// Неверный формат
                    {""}, // Не заполненное поле
                    {"П"}, // Меньше допустимого количества символов
                    {"ПетровПетровПетровПетровПетровПетровПетров"}, // Превышающие количество допустимых символов ОШИБКА НЕ ПОЯВИЛАСЬ
            };
        }

        @Test
        public void errorSurnameTest() {
            mainPage.clickHeaderOrderBtn(); // Нажатие кнопок Заказать в шапке
            orderPageSteps.setSurname(surname); // Ввод данных в поле имя
            orderPageSteps.clickNextBtn(); // Нажать кнопку далее
            assertTrue("Ошибка не появилась",
                    errorInputFields.getErrorSurname().isDisplayed()); // Проверяем что ошибка появилась
        }
    }

// Поле Адрес
    @RunWith(Parameterized.class)
    public static class ErrorInFieldAddress extends BaseTest {
        // Объявили параметры теста
        private static String address;

        // Создали конструктор для инициализации параметров
        public ErrorInFieldAddress(String address) {
            this.address = address;
        }

        @Parameterized.Parameters(name = "Неверный ввод адреса: {0}")
        public static Object[] setAddressData() {
            return new Object[][]{
                    // Невалидные данные
                    {"Lenina 3"},// Неверный формат
                    {""}, // Не заполненное поле ОШИБКА НЕ ПОЯВИЛАСЬ
                    {"П"}, // Меньше допустимого количества символов
                    {"Петровского23Петровского23Петровского23Петровского"}, // Превышающие количество допустимых символов
            };
        }

        @Test
        public void errorAddressTest() {
            mainPage.clickHeaderOrderBtn(); // Нажатие кнопок Заказать в шапке
            orderPageSteps.setAddress(address); // Ввод данных в поле имя
            orderPageSteps.clickNextBtn(); // Нажать кнопку далее
            assertTrue("Ошибка не появилась",
                    errorInputFields.getErrorAddress().isDisplayed()); // Проверяем что ошибка появилась
        }
    }

// Поле Станции Метро
    @RunWith(Parameterized.class)
    public static class ErrorInFieldStationMetro extends BaseTest {
        // Объявили параметры теста
        private static String metro;

        // Создали конструктор для инициализации параметров
        public ErrorInFieldStationMetro(String metro) {
            this.metro = metro;
        }

        @Parameterized.Parameters(name = "Неверный ввод станции метро: {0}")
        public static Object[] setStationMetroData() {
            return new Object[][]{
                    // Невалидные данные
                    {"Луубянка"},// Опечатка
                    {"Метр"}, // Станция не из списка
                    {""}, // Не заполненное поле
            };
        }

        @Test
        public void errorStationMetroTest() {
            mainPage.clickHeaderOrderBtn();// Нажатие кнопок Заказать в шапке

            if (metro.isEmpty()) {
                orderPageSteps.closeMetroStation(); // Если поле пустое, закрыть список
            } else {
                orderPageSteps.selectMetroStation(metro); // Ввод данных в поле имя
            }

            orderPageSteps.clickNextBtn(); // Нажать кнопку далее
            assertTrue("Ошибка не появилась",
                    errorInputFields.getErrorStationMetro().isDisplayed()); // Проверяем что ошибка появилась
        }
    }
// Поле номер Телефона
    @RunWith(Parameterized.class)
    public static class ErrorInFieldPhone extends BaseTest {
        // Объявили параметры теста
        private static String phone;

        // Создали конструктор для инициализации параметров
        public ErrorInFieldPhone(String phone) {
            this.phone = phone;
        }

        @Parameterized.Parameters(name = "Неверный ввод номера телефона: {0}")
        public static Object[] setPhoneData() {
            return new Object[][]{
                    // Невалидные данные
                    {"asdfg"},// Неверный формат
                    {""}, // Не заполненное поле ОШИБКА НЕ ПОЯВИЛАСЬ
                    {"8888888888"}, // Меньше допустимого количества символов (10)
                    {"89993332233456"}, // Превышающие количество допустимых символов
            };
        }

        @Test
        public void errorPhoneTest() {
            mainPage.clickHeaderOrderBtn(); // Нажатие кнопок Заказать в шапке
            orderPageSteps.setNumberPhone(phone); // Ввод данных в поле имя
            orderPageSteps.clickNextBtn(); // Нажать кнопку далее
            assertTrue("Ошибка не появилась",
                    errorInputFields.getErrorPhone().isDisplayed()); // Проверяем что ошибка появилась
        }
    }
}