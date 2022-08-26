package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.AddCustomerPage;
import pages.DashboardPage;

public class TelecomTest {

    WebDriver driver;
    DashboardPage dashboardPage;
    AddCustomerPage addCustomerPage;

    @BeforeTest
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        dashboardPage = new DashboardPage(driver);
        addCustomerPage = new AddCustomerPage(driver);
        driver.get("https://demo.guru99.com/telecom/index.html");
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testDashboardHeader() {
        String expectedHeader = "Guru99 telecom";
        Assert.assertEquals(dashboardPage.getHeader(), expectedHeader,
                "Dashboard Header does not match!!!");
    }

    @Test
    public void testCustomerPageHeader() {

        String expectedHeader = "Add Customer";
        dashboardPage.goTo("Add Customer");
        Assert.assertEquals(addCustomerPage.getHeader(), expectedHeader,
                "Dashboard Header does not match!!!");
    }
}
