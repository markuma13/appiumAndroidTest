package android.project.duolingo.pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TutorialAccountTwoStepPage {
    public TutorialAccountTwoStepPage(AndroidDriver driver){PageFactory.initElements(new AppiumFieldDecorator(driver), this);}
    private final Logger LOG = LoggerFactory.getLogger(TutorialAccountTwoStepPage.class);

}
