package android.project.duolingo.duolingoTest;

import android.project.duolingo.MyExtension;
import android.project.duolingo.pages.HaveAccountPage;
import android.project.duolingo.pages.TutorialOnePages.GetTitleTutorialPages;
import android.project.duolingo.pages.TutorialOnePages.TutorialAccountOneStepPage;
import android.project.duolingo.pages.TutorialAccountTwoStepPage;
import io.qameta.allure.Step;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.net.MalformedURLException;

@ExtendWith(MyExtension.class)
public class TutorialAccountTest extends BaseTest {
    private TutorialAccountOneStepPage tutorialAccountOneStepPage;
    private TutorialAccountTwoStepPage tutorialAccountTwoStepPage;
    private GetTitleTutorialPages getTitleTutorialPages;
    private HaveAccountPage haveAccountPage;

    @BeforeEach
    @Override
    @Step("Настройка пакетов и запуск эмулятора")
    public void setUp() throws MalformedURLException {
        super.setUp();
        tutorialAccountOneStepPage = new TutorialAccountOneStepPage(getDriver());
        tutorialAccountTwoStepPage = new TutorialAccountTwoStepPage(getDriver());
        getTitleTutorialPages = new GetTitleTutorialPages(getDriver());
        haveAccountPage = new HaveAccountPage(getDriver());
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
        assertTrue(haveAccountPage.checkButtonAlreadyAccount(), "Кнопка У меня уже есть акаунт не активна");
    }

    @Test
    @DisplayName("Проверка наличия текста шагов обучения")
    public void checkTutorialGetText(){
        checkGetTextOpenApp();
        tutorialAccountOneStepPage.clickButtonBegin();

        WebElement elementOne = getTitleTutorialPages.getTitleTopTextTutorial();
        String expectedText = "Привет! Я Duo!";
        assertEquals(expectedText, getTitleTutorialPages.getTextFromElement(elementOne));

        tutorialAccountOneStepPage.clickButtonContinue();

        WebElement elementTwo = getTitleTutorialPages.getTitleTopTextTutorial();
        String expectedTextTwo = "Ну что, поехали!";
        assertEquals(expectedTextTwo, getTitleTutorialPages.getTextFromElement(elementTwo));

        tutorialAccountOneStepPage.clickButtonContinue();
        WebElement elementTree = getTitleTutorialPages.getTitleTextTutorialChoiceLanguage();
        String expectedTextTree = "Какой язык вы хотите изучать?";
        assertEquals(expectedTextTree, getTitleTutorialPages.getTextFromElement(elementTree));
    }

    @Test
    @DisplayName("Проверка возвращения на гланый экран после шага в выборе языка")
    public void checkBackStepLanguage(){
        checkTutorialGetText();
        tutorialAccountOneStepPage.clickButtonBack();
        checkGetTextOpenApp();
    }

    @ParameterizedTest(name = "#{index} - Проверка ввода на невалидность Email {0}")
    @CsvSource({"sasdewef", "%%%/%%%", "trrtr@lwerwe.ru"})
    @DisplayName("Проверка ввода невалидного Email на форме авторизации")
    public void checkInvalidEnterEmailAccount(String email){
        checkActivitiBegin();
        haveAccountPage.clickButtonAlreadyAccount();
        haveAccountPage.fillEmailField(email);
        haveAccountPage.enterPassword();
        haveAccountPage.clickSignInButton();

        assertEquals(haveAccountPage.getTextErrorMessage(), "Неверные имя пользователя и пароль",
                "Неверный текст валидации либо отсуствует");
    }







}
