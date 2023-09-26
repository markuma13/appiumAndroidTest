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

    public boolean checkButtonAlreadyAccount() {
        LOG.info("Проверка активности кнопки У меня уже есть акаунт");
        return buttonAlreadyAccount.isEnabled();
    }


}
