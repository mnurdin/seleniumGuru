package selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumDemo {

    public static void main(String[] args) {

        // Driver config
//        System.setProperty("webdriver.chrome.driver", "src/test/java/driver/chromedriver");

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().fullscreen();

        driver.navigate().to("https://www.google.com/");


        driver.findElement(By.name("q")).sendKeys("wooden spoon" + Keys.ENTER);

        String result = driver.findElement(By.id("result-stats")).getText();
        //About 102,000,000 results (0.72 seconds)
        result = result.split(" ")[1];

        System.out.println(result);

        driver.findElement(By.name("q")).clear();

        driver.findElement(By.name("q")).sendKeys("old cars" + Keys.ENTER);

        String secondResult = driver.findElement(By.id("result-stats")).getText();
        //About 2,210,000,000 results (0.80 seconds)
        secondResult = secondResult.split(" ")[1];

        System.out.println(secondResult);

        driver.quit();
    }
}
