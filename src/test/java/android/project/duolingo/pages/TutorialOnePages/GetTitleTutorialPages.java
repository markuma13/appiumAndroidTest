package android.project.duolingo.pages.TutorialOnePages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GetTitleTutorialPages {
    public GetTitleTutorialPages(AndroidDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public final Logger LOG = LoggerFactory.getLogger(TutorialAccountOneStepPage.class);

    @AndroidFindBy(id = "com.duolingo:id/introFlowText")
    private WebElement getTextGreetings;
    @AndroidFindBy(id = "com.duolingo:id/titleTop")
    private WebElement titleTopTextTutorial;
    @AndroidFindBy(id = "com.duolingo:id/title")
    private WebElement titleTextTutorialChoiceLanguage;

    public String getTextFromElement(WebElement element) {
        String value = element.getText();
        LOG.info("Получение текста из элемента: " + element);
        return value;
    }

    public WebElement getTitleTextGreetings() {return getTextGreetings;}
    public WebElement getTitleTopTextTutorial() {return titleTopTextTutorial;}
    public WebElement getTitleTextTutorialChoiceLanguage(){return titleTextTutorialChoiceLanguage;}
}
