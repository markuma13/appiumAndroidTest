package android.project.duolingo.duolingoTest;

import android.project.duolingo.MyExtension;
import android.project.duolingo.pages.HaveAccountPage;
import android.project.duolingo.pages.TutorialOnePages.GetTitleTutorialPages;
import android.project.duolingo.pages.TutorialOnePages.TutorialAccountOneStepPage;
import android.project.duolingo.pages.UserAccountPage;
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
import java.time.Duration;

@ExtendWith(MyExtension.class)
public class TutorialAccountTest extends BaseTest {
    private TutorialAccountOneStepPage tutorialAccountOneStepPage;
    private UserAccountPage userAccountPage;
    private GetTitleTutorialPages getTitleTutorialPages;
    private HaveAccountPage haveAccountPage;

    @BeforeEach
    @Override
    @Step("Настройка пакетов и запуск эмулятора")
    public void setUp() throws MalformedURLException {
        super.setUp();
        tutorialAccountOneStepPage = new TutorialAccountOneStepPage(getDriver());
        userAccountPage = new UserAccountPage(getDriver());
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

    @Test
    @DisplayName("Проверка входа в сервис")
    public void checkServiceLogin(){
        haveAccountPage
                .clickButtonAlreadyAccount()
                .validEmailField()
                .enterPassword()
                .clickSignInButton();
        Duration timeout = Duration.ofSeconds(10);
        userAccountPage.clickProfileButton(getDriver(),timeout);
        userAccountPage.clickSecondaryButtonAvatar();

        String expectedIdAccount = "Android520387";
        assertEquals(expectedIdAccount,userAccountPage.checkUsernameTextAccount(), "Отсуствует или неверный Id Account");
    }


    @Test
    @DisplayName("Проверка меню навигации в сервисе")
    public void checkIsEnableButtonNavigate222() {
        haveAccountPage
                .clickButtonAlreadyAccount()
                .validEmailField()
                .enterPassword()
                .clickSignInButton();
        WebElement leaguesTabButton = userAccountPage.getLeaguesTabButton();
        Duration timeout = Duration.ofSeconds(10);
        boolean isLeaguesTabButtonActive = userAccountPage.checkIsEnabledButton(getDriver(), leaguesTabButton, "Leagues Tab",timeout);
        assertTrue(isLeaguesTabButtonActive, "Кнопка 'Leagues Tab' не активна");
        userAccountPage.clickTabButtonLeaguesTab();
    }

    @Test
    @DisplayName("Проверка активности забыли пароль")
    public void checkIsEnableForgotPassword(){
        haveAccountPage.clickButtonAlreadyAccount();
        WebElement linkTextForgotPassword = haveAccountPage.getForgotPassword();
        Duration timeout = Duration.ofSeconds(4);
        boolean linkTextGetForgotPassword = userAccountPage.checkIsEnabledButton(getDriver(),
                linkTextForgotPassword,"Текст ссылка 'Забыли пароль'", timeout );
        assertTrue(linkTextGetForgotPassword,"Текст ссылка 'Забыли пароль' не активна");
        haveAccountPage.clickLinkTextForgotPassword();
    }
    @ParameterizedTest(name = "#{index} - Проверка ввода на невалидность Email {0}")
    @CsvSource({"%%%|%%%"})
    @DisplayName("Проверка ввода невалидного Email для сброса пароля")
    public void checkInvalidEmailSendForgotPassword(String email){
        checkIsEnableForgotPassword();

        WebElement element = getTitleTutorialPages.getTitleTextForgotPassword();
        String expectedText = "Введите адрес эл. почты, чтобы получить ссылку для сброса пароля.";
        assertEquals(expectedText, getTitleTutorialPages.getTextFromElement(element), "Ожидаемый текст не найден на странице");

        haveAccountPage.FieldEmailForgot(email);
        haveAccountPage.clicksendEmailButtonGetTheLink();

        assertEquals(haveAccountPage.getTextErrorMessage(), "Аккаунта с таким адресом эл. почты на Duolingo не существует.",
                "Неверный текст валидации либо отсуствует");


    }





}
