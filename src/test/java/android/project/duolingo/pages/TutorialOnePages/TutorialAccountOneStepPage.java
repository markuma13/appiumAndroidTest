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
    @AndroidFindBy(id = "com.duolingo:id/continueButton")
    private WebElement buttonContinue;
    @AndroidFindBy(id = "com.duolingo:id/back")
    private WebElement buttonBack;

    public boolean checkButtonBegin() {
        LOG.info("Проверка активности кнопки Начать");
        return buttonBegin.isEnabled();
    }
    public void clickButtonBegin() {
        LOG.info("Клик на кнопу начать");
        buttonBegin.click();
    }
    public void clickButtonContinue() {
        LOG.info("Клик на кнопу продолжить");
        buttonContinue.click();
    }
    public void clickButtonBack(){
        LOG.info("Клик на кнопку назад");
        buttonBack.click();
    }


}