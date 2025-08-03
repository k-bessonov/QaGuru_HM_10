package with.allure.tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import model.AttachmentUtils;
import org.junit.jupiter.api.Test;

import java.util.Objects;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.webdriver;
import static io.qameta.allure.Allure.attachment;
import static io.qameta.allure.Allure.step;

public class AttachmentsTest {

    @Test
    public void testLambdaAttachments() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Открываем главную страницу", () -> {
            open("https://github.com");
            attachment("Source", Objects.requireNonNull(webdriver().driver().source()));
        });
    }

    @Test
    public void testAnnotatedAttachments() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        WebSteps steps = new WebSteps();

        steps.openMainPage();
        AttachmentUtils.takeScreenshot();
    }

}