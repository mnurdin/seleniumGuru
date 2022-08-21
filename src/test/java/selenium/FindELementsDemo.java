package selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindELementsDemo {

    public static void main(String[] args) {

        String expectedText = "Login Successfully";

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        //https://demo.guru99.com/test/newtours/

        driver.get("https://demo.guru99.com/test/newtours/");
        //name
//        driver.findElement(By.name("userName")).sendKeys("abc123");
        //xpath
//        driver.findElement(By.xpath("//input[@name='userName']")).sendKeys("abc123");
        //css
        driver.findElement(By.cssSelector("input[name='userName']")).sendKeys("abc123");
        //name
//        driver.findElement(By.name("password")).sendKeys("abc123");
        //xpath
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("abc123");

        //name
//        driver.findElement(By.name("submit")).click();
        //xpath
        driver.findElement(By.xpath("//input[@value=\"Submit\"]")).click();

        String actualText = driver.findElement(By.xpath("//h3")).getText();

        System.out.println(expectedText.equals(actualText));
    }
}
