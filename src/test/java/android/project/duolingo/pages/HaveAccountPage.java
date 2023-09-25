package android.project.duolingo.pages;

import android.project.duolingo.pages.TutorialOnePages.TutorialAccountOneStepPage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HaveAccountPage {
    public HaveAccountPage(AndroidDriver driver){PageFactory.initElements(new AppiumFieldDecorator(driver), this);}
    private final Logger LOG = LoggerFactory.getLogger(TutorialAccountOneStepPage.class);


}
