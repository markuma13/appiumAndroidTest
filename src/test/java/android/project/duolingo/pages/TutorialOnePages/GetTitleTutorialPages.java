package android.project.duolingo.pages.TutorialOnePages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class GetTitleTutorialPages extends BasePage {
    public GetTitleTutorialPages(AndroidDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "com.duolingo:id/introFlowText")
    private WebElement getTextGreetings;
    @AndroidFindBy(id = "com.duolingo:id/titleTop")
    private WebElement titleTopTextTutorial;
    @AndroidFindBy(id = "com.duolingo:id/title")
    private WebElement titleTextTutorialChoiceLanguage;
    @AndroidFindBy(id = "com.duolingo:id/body")
    private WebElement titleTextForgotPassword;

    public String getTitleTextGreetings() {
        LOG.info("Получение текста из элемента");
        return getTextGreetings.getText();
    }

    public String getTitleTopTextTutorial() {
        LOG.info("Получение текста из элемента");
        return titleTopTextTutorial.getText();
    }

    public String getTitleTextTutorialChoiceLanguage() {
        LOG.info("Получение текста из элемента");
        return titleTextTutorialChoiceLanguage.getText();
    }

    public String getTitleTextForgotPassword() {
        LOG.info("Получение текста из элемента");
        return titleTextForgotPassword.getText();
    }

}
