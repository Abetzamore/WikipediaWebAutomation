package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.BasePage;

public class ResultPage extends BasePage {

    @FindBy(css = ".mw-page-title-main")
    private WebElement pageTitle;
    @FindBy(css = "[title~=Huso]")
    private WebElement husoTitle;

    public ResultPage(WebDriver webDriver) {
        super(webDriver);
    }

    public boolean isTitleCorrect(String title){
        waitToElementToBeVisible(pageTitle);
        return pageTitle.isDisplayed() && pageTitle.getText().equalsIgnoreCase(title);
    }

    public boolean isTimeZoneCorrect(String country, String timeZone){
        waitToElementToBeVisible(pageTitle);
        return  husoTitle.isDisplayed() && husoTitle.getText().equalsIgnoreCase(timeZone);
    }
}
