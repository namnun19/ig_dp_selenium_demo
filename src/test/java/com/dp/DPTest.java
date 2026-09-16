package com.dp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.dp.pages.DPHomePage;
import com.dp.pages.PrivacyPolicyPage;
import java.time.Duration;

public class DPTest {

    private WebDriver driver;
    private DPHomePage homePage;
    private PrivacyPolicyPage privacyPage;

    @BeforeMethod
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        // options.addArguments("--headless"); // Uncomment to run without opening a UI
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        homePage = new DPHomePage(driver);
        privacyPage = new PrivacyPolicyPage(driver);
    }

    @Test
    public void validateDPPrivacyAndExploreLinks() {
        // 1. Navigate to the DP homepage
        homePage.navigateToHomePage();

        // 2. Scroll down to footer section and click on "Privacy Policy"
        homePage.clickPrivacyPolicy();

        // 3. Switch to the newly opened tab
        privacyPage.switchToNewTab();

        // 4. Validate the url opened correctly
        String expectedPrivacyUrl = "privacy.thewaltdisneycompany.com";
        Assert.assertTrue(privacyPage.isUrlValid(expectedPrivacyUrl), "Privacy Policy URL did not match the expected value!");

        // 5. Click on "Explore DP+" from 'Helpful Links' section
        privacyPage.clickExploreDP();

        // 6. Switch to the next new tab and validate the page title
        privacyPage.switchToNewTab();
        Assert.assertTrue(driver.getTitle().contains("Explore Disney+"), "The Explore DP page did not load correctly.");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}