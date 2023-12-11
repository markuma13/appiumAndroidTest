package android.project.duolingo.pages.TutorialOnePages;


import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class TutorialAccountOneStepPage extends BasePage {

    @AndroidFindBy(id = "com.duolingo:id/introFlowNewUserButton")
    private WebElement buttonBegin;
    @AndroidFindBy(id = "com.duolingo:id/continueButton")
    private WebElement buttonContinue;
    @AndroidFindBy(id = "com.duolingo:id/back")
    private WebElement buttonBack;

    public TutorialAccountOneStepPage(AndroidDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public boolean checkButtonBegin() {
        LOG.info("Проверка активности кнопки 'Начать'");
        return buttonBegin.isEnabled();
    }

    public void clickButtonBegin() {
        LOG.info("Клик на кнопку 'Начать'");
        buttonBegin.click();
    }

    public void clickButtonContinue() {
        LOG.info("Клик на кнопку 'Продолжить'");
        buttonContinue.click();
    }

    public void clickButtonBack() {
        LOG.info("Клик на кнопку 'Назад'");
        buttonBack.click();
    }
}
