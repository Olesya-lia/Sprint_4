import constant.ConstantsFAQAndAnswer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class MainPageFAQTest extends BaseTest {

    // Номера элементов
    private final int numberOfElement;
    // Ожидаемый текст в вопросе
    private final String expectedQuestionText;
    // Ожидаемый текст в ответе
    private final String expectedAnswerText;

    // Конструктор
    public MainPageFAQTest(int numberOfAccordionItem, String expectedQuestionText, String expectedAnswerText) {
        this.numberOfElement = numberOfAccordionItem;
        this.expectedQuestionText = expectedQuestionText;
        this.expectedAnswerText = expectedAnswerText;
    }

    // Параметры подставлены из константы для параметризованного теста, упрощен с помощью цикла
    @Parameterized.Parameters()
    public static Object[][] setTestData() {
        Object[][] data = new Object[8][3]; // создали массив 8 проверок по 3 параметра
        for (int i = 0; i < 8; i++) {
            data[i] = new Object[]{i,
                    ConstantsFAQAndAnswer.EXPECTED_QUESTIONS[i],
                    ConstantsFAQAndAnswer.EXPECTED_ANSWERS[i]
            };
        }
        return data;
    }

    // Сверка текстов в вопросах и ответах
    @Test
    public void checkFAQAndAnswerTextTest () {

        mainPage.scrollToFaqSection();
        mainPage.clickAccordionHeader(numberOfElement);
        mainPage.waitForLoadItem(numberOfElement);

        // Сравниваем тексты вопросов, ошибка в тексте 7-го вопроса
        assertEquals("Ошибка в тексте вопроса " + numberOfElement,
                mainPage.getQuestionsText(numberOfElement),expectedQuestionText);

        // Сравниваем тексты ответов
        assertEquals("Ошибка в тексте ответа " + numberOfElement,
                mainPage.getAnswerText(numberOfElement),expectedAnswerText);
    }
}