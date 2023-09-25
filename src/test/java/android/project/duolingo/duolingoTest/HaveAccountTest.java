package android.project.duolingo.duolingoTest;

import android.project.duolingo.MyExtension;
import android.project.duolingo.pages.HaveAccountPage;
import io.qameta.allure.Step;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;

import java.net.MalformedURLException;


@ExtendWith(MyExtension.class)
public class HaveAccountTest extends BaseTest{
    private HaveAccountPage haveAccountPage;
    @BeforeEach
    @Override
    @Step("Настройка пакетов и запуск эмулятора")
    public void setUp() throws MalformedURLException {
        super.setUp();
        haveAccountPage = new HaveAccountPage(getDriver());
    }

}
