package com.dp.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DPHomePage extends BasePage {

    @FindBy(xpath = "//footer//a[contains(text(), 'Privacy Policy')]")
    private WebElement privacyPolicyLink;

    public DPHomePage(WebDriver driver) {
        super(driver);
    }

    public void navigateToHomePage() {
        driver.get("https://www.disneyplus.com/");
    }

    public void clickPrivacyPolicy() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", privacyPolicyLink);
        wait.until(ExpectedConditions.elementToBeClickable(privacyPolicyLink));
        privacyPolicyLink.click();
    }
}