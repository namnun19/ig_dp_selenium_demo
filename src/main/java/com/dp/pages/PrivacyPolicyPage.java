package com.dp.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.Set;

public class PrivacyPolicyPage extends BasePage {

    @FindBy(xpath = "//a[contains(text(), 'Explore Disney+')]")
    private WebElement exploreDPLink;

    public PrivacyPolicyPage(WebDriver driver) {
        super(driver);
    }

    public void switchToNewTab() {
        String currentHandle = driver.getWindowHandle();
        Set<String> allHandles = driver.getWindowHandles();
        for (String handle : allHandles) {
            if (!handle.equals(currentHandle)) {
                driver.switchTo().window(handle);
                break;
            }
        }
    }

    public boolean isUrlValid(String expectedUrl) {
        wait.until(ExpectedConditions.urlContains(expectedUrl));
        return driver.getCurrentUrl().contains(expectedUrl);
    }

    public void clickExploreDP() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", exploreDPLink);
        wait.until(ExpectedConditions.elementToBeClickable(exploreDPLink));
        exploreDPLink.click();
    }
}