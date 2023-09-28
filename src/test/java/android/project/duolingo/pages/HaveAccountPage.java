package android.project.duolingo.pages;

import android.project.duolingo.pages.TutorialOnePages.TutorialAccountOneStepPage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HaveAccountPage {
    public HaveAccountPage(AndroidDriver driver){PageFactory.initElements(new AppiumFieldDecorator(driver), this);}
    private final Logger LOG = LoggerFactory.getLogger(TutorialAccountOneStepPage.class);

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
    @AndroidFindBy(id = "com.duolingo:id/quit")
    private WebElement closingLoginPage;
    @AndroidFindBy(id = "com.duolingo:id/facebookButton")
    private WebElement facebookButton;
    @AndroidFindBy(id = "com.duolingo:id/googleButton")
    private WebElement googleButton;
    @AndroidFindBy(id = "com.duolingo:id/errorMessage")
    private WebElement errorMessage;

    public boolean checkButtonAlreadyAccount() {
        LOG.info("Проверка активности кнопки У меня уже есть акаунт");
        return buttonAlreadyAccount.isEnabled();
    }
    public HaveAccountPage clickButtonAlreadyAccount(){
        LOG.info("Клик на кнопку У меня уже есть акаунт");
        buttonAlreadyAccount.click();
        return this;
    }
    public HaveAccountPage clickSignInButton(){
        LOG.info("Клик на кнопку Войти");
        signInButton.click();
        return this;
    }
    public void fillEmailField(String email){
        LOG.info("Ввод email: " + email);
        loginField.sendKeys(email);
    }
    public HaveAccountPage validEmailField(){
        LOG.info("Ввод валидного email");
        loginField.sendKeys("tytufy@mailto.plus");
        return this;
    }
    public HaveAccountPage enterPassword(){
        LOG.info("Ввод password");
        passwordField.sendKeys("AA890890890");
        return this;
    }
    public String getTextErrorMessage(){
        String valueErrorMessage = errorMessage.getText();
        LOG.info("Получено валидационное сообщения после отправки формы: \"" + valueErrorMessage + "\"");
        return valueErrorMessage;
    }









}
