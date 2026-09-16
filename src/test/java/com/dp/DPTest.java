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
import java.util.Set;

public class DPTest {

    private WebDriver driver;
    private DPHomePage homePage;
    private PrivacyPolicyPage privacyPage;

    @BeforeMethod
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        // options.addArguments("--headless");
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
        String originalWindow = driver.getWindowHandle();

        // 2. Click on "Privacy Policy"
        homePage.clickPrivacyPolicy();

        // 3. Switch to the newly opened tab
        switchToNewWindow(originalWindow);

        // 4. Validate the url opened correctly
        String expectedPrivacyUrl = "privacy.thewaltdisneycompany.com";
        Assert.assertTrue(privacyPage.isUrlValid(expectedPrivacyUrl), "Privacy Policy URL did not match the expected value!");

        // 5. Close the Privacy tab and switch back to the main DP page
        driver.close();
        driver.switchTo().window(originalWindow);

        // 6. Click on "Explore DP+" from 'Helpful Links' section
        homePage.clickExploreDP();

        // 7. Switch to the next new tab and validate the page title
        switchToNewWindow(originalWindow);
        Assert.assertTrue(driver.getTitle().contains("Explore Disney+"), "The Explore DP page did not load correctly.");
    }

    // Helper method to handle switching to a newly opened tab
    private void switchToNewWindow(String originalWindow) {
        Set<String> allWindows = driver.getWindowHandles();
        for (String windowHandle : allWindows) {
            if (!windowHandle.equals(originalWindow)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}