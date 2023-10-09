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

    public String getTextFromElement(WebElement element) {
        String value = element.getText();
        LOG.info("Получение текста из элемента: " + element);
        return value;
    }
    public WebElement getTitleTextGreetings() {return getTextGreetings;}
    public WebElement getTitleTopTextTutorial() {return titleTopTextTutorial;}
    public WebElement getTitleTextTutorialChoiceLanguage() {return titleTextTutorialChoiceLanguage;}
    public WebElement getTitleTextForgotPassword() {return titleTextForgotPassword;}

}
