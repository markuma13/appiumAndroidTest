package android.project.duolingo.pages.TutorialOnePages;


import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TutorialAccountOneStepPage {
    public TutorialAccountOneStepPage(AndroidDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public final Logger LOG = LoggerFactory.getLogger(TutorialAccountOneStepPage.class);

    @AndroidFindBy(id = "com.duolingo:id/introFlowNewUserButton")
    private WebElement buttonBegin;
    @AndroidFindBy(id = "com.duolingo:id/introFlowLoginButton")
    private WebElement buttonAlreadyAccount;

    public boolean checkButtonBegin() {
        LOG.info("Проверка активности кнопки Начать");
        return buttonBegin.isEnabled();
    }

    public boolean checkButtonAlreadyAccount() {
        LOG.info("Проверка активности кнопки У меня уже есть акаунт");
        return buttonBegin.isEnabled();
    }

    public void clickButtonBegin() {
        LOG.info("Клик на кнопу начать");
        buttonBegin.click();
    }


}
