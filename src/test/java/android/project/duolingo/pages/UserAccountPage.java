package android.project.duolingo.pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.time.Duration;
//import io.appium.java_client.Duration;


public class UserAccountPage {
    public UserAccountPage(AndroidDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    private final Logger LOG = LoggerFactory.getLogger(UserAccountPage.class);
    private static AndroidDriver driver;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Profile Tab\"]/android.widget.ImageView")
    private WebElement profileTabButton;
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Learn Tab\"]/android.widget.ImageView")
    private WebElement LearnTabButton;
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Leagues Tab\"]/android.widget.ImageView")
    private WebElement LeaguesTabButton;
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Goals Tab\"]/android.widget.ImageView")
    private WebElement GoalsTabButton;
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"News Tab\"]/android.widget.ImageView")
    private WebElement NewsTabButton;
    @AndroidFindBy(id = "com.duolingo:id/primaryButton")
    private WebElement primaryButtonAvatar;
    @AndroidFindBy(id = "com.duolingo:id/secondaryButton")
    private WebElement secondaryButtonAvatar;
    @AndroidFindBy(id = "com.duolingo:id/username")
    private WebElement usernameTextAccount;


    public void clickProfileButton(AndroidDriver driver, Duration timeout) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            wait.until(ExpectedConditions.elementToBeClickable(profileTabButton));
            LOG.info("Клик на кнопку профиля в сервисе");
            profileTabButton.click();
        } catch (Exception e) {
            LOG.error("Не удалось выполнить клик на кнопке профиля. Ошибка: " + e.getMessage());
        }
    }

    public void clickSecondaryButtonAvatar() {
        LOG.info("Клик на кнопку Напомнить позже при создании аватара");
        secondaryButtonAvatar.click();
    }

    public String checkUsernameTextAccount() {
        LOG.info("Проверка наличия idAccount");
        String valueUsername = usernameTextAccount.getText();
        LOG.info("Получен idAccount: \"" + valueUsername + "\"");
        return valueUsername;
    }

    public boolean checkIsEnabledButton(AndroidDriver driver, WebElement element, String elementName, Duration timeout) {
        LOG.info("Ожидание элемента " + elementName + " и проверка активности кнопки " + elementName);
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            wait.until(ExpectedConditions.elementToBeClickable(element));
        } catch (Exception e) {
            LOG.error("Не удалось выполнить проверку активности кнопки " + elementName + ". Ошибка: " + e.getMessage());
        }
        return element.isEnabled();
    }

    public WebElement getLeaguesTabButton() {
        return LearnTabButton;
    }
    public void clickTabButtonLeaguesTab(){
        LeaguesTabButton.click();
    }




}
