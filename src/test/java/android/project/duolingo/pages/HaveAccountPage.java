package android.project.duolingo.pages;

import android.project.duolingo.pages.TutorialOnePages.BasePage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;


public class HaveAccountPage extends BasePage {
    @AndroidFindBy(id = "com.duolingo:id/introFlowLoginButton")
    private WebElement buttonAlreadyAccount;
    @AndroidFindBy(id = "com.duolingo:id/loginView")
    private WebElement loginField;
    @AndroidFindBy(id = "com.duolingo:id/passwordView")
    private WebElement passwordField;
    @AndroidFindBy(id = "com.duolingo:id/signinButton")
    private WebElement signInButton;
    @AndroidFindBy(id = "com.duolingo:id/forgotPassword")
    private WebElement forgotPassword;
    @AndroidFindBy(id = "com.duolingo:id/emailInput")
    private WebElement emailFieldForgotPassword;
    @AndroidFindBy(id = "com.duolingo:id/facebookButton")
    private WebElement facebookButton;
    @AndroidFindBy(id = "com.duolingo:id/googleButton")
    private WebElement googleButton;
    @AndroidFindBy(id = "com.duolingo:id/errorMessage")
    private WebElement errorMessage;
    @AndroidFindBy(id = "com.duolingo:id/sendEmailButton")
    private WebElement sendEmailButton;

    public HaveAccountPage(AndroidDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public boolean checkFacebookButton() {
        LOG.info("Проверка активности кнопки регистрации через 'Facebook'");
        return facebookButton.isEnabled();
    }

    public boolean checkGoogleButton() {
        LOG.info("Проверка активности кнопки регистрации через 'Google'");
        return googleButton.isEnabled();
    }

    public boolean checkButtonAlreadyAccount() {
        LOG.info("Проверка активности кнопки 'У меня уже есть акаунт'");
        return buttonAlreadyAccount.isEnabled();
    }

    public WebElement getForgotPassword() {
        return forgotPassword;
    }

    public void clickLinkTextForgotPassword() {
        LOG.info("Клик на кнопку 'Забыли пароль'");
        forgotPassword.click();
    }

    public HaveAccountPage clickButtonAlreadyAccount() {
        LOG.info("Клик на кнопку 'У меня уже есть акаунт'");
        buttonAlreadyAccount.click();
        return this;
    }

    public void clickSignInButton() {
        LOG.info("Клик на кнопку 'Войти'");
        signInButton.click();
    }

    public HaveAccountPage fillEmailField(String email) {
        LOG.info("Ввод email: " + email);
        loginField.sendKeys(email);
        return this;
    }

    public void FieldEmailForgot(String email) {
        LOG.info("Ввод email: " + email);
        emailFieldForgotPassword.sendKeys(email);
    }

    public void clickSendEmailButtonGetTheLink() {
        LOG.info("Клик на кнопку 'Получить ссылку'");
        sendEmailButton.click();
    }

    public HaveAccountPage validEmailField() {
        LOG.info("Ввод валидного email");
        loginField.sendKeys("tytufy@mailto.plus");
        return this;
    }

    public HaveAccountPage enterPassword() {
        LOG.info("Ввод password");
        passwordField.sendKeys("AA890890890");
        return this;
    }

    public String getTextErrorMessage() {
        String valueErrorMessage = errorMessage.getText();
        LOG.info("Получено валидационное сообщения после отправки формы: \"" + valueErrorMessage + "\"");
        return valueErrorMessage;
    }
}
