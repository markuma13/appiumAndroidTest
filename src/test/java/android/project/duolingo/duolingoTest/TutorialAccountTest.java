package android.project.duolingo.duolingoTest;

import android.project.duolingo.MyExtension;
import android.project.duolingo.pages.TutorialOnePages.GetTitleTutorialPages;
import android.project.duolingo.pages.TutorialOnePages.TutorialAccountOneStepPage;
import android.project.duolingo.pages.TutorialAccountTwoStepPage;
import io.qameta.allure.Step;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.net.MalformedURLException;

@ExtendWith(MyExtension.class)
public class TutorialAccountTest extends BaseTest {
    private TutorialAccountOneStepPage tutorialAccountOneStepPage;
    private TutorialAccountTwoStepPage tutorialAccountTwoStepPage;
    private GetTitleTutorialPages getTitleTutorialPages;

    @BeforeEach
    @Override
    @Step("Настройка пакетов и запуск эмулятора")
    public void setUp() throws MalformedURLException {
        super.setUp();
        tutorialAccountOneStepPage = new TutorialAccountOneStepPage(getDriver());
        tutorialAccountTwoStepPage = new TutorialAccountTwoStepPage(getDriver());
        getTitleTutorialPages = new GetTitleTutorialPages(getDriver());
    }

    @Test
    @DisplayName("Проверка наличия текста при открытие приложения")
    public void checkGetTextOpenApp() {
        WebElement element = getTitleTutorialPages.getTitleTextGreetings();
        String expectedText = "Учите языки бесплатно, весело и эффективно!";
        assertEquals(expectedText, getTitleTutorialPages.getTextFromElement(element), "Ожидаемый текст не найден на странице");
    }

    @Test
    @DisplayName("Проверка активности кнопок Начать и У меня уже есть акаунт")
    public void checkActivitiBegin() {
        assertTrue(tutorialAccountOneStepPage.checkButtonBegin(), "Кнопка Начать не активна");
        assertTrue(tutorialAccountOneStepPage.checkButtonAlreadyAccount(), "Кнопка У меня уже есть акаунт не активна");
    }


}
