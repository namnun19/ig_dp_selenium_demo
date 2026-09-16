package com.dp.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PrivacyPolicyPage extends BasePage {

    public PrivacyPolicyPage(WebDriver driver) {
        super(driver);
    }

    public boolean isUrlValid(String expectedUrl) {
        wait.until(ExpectedConditions.urlContains(expectedUrl));
        return driver.getCurrentUrl().contains(expectedUrl);
    }
}