package selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.HashMap;
import java.util.Map;

public class DataTableDemo {

    public static WebDriver driver;

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/webtables");

        Map<String, String> users = new HashMap<>();
        users.put("firstName", "user1");
        users.put("firstName", "user2");
        users.put("firstName", "user3");

        users.put("lastName", "last1");
        users.put("lastName", "last2");
        users.put("lastName", "last3");

        users.put("userEmail", "last1@gmail.com");
        users.put("userEmail", "last2@gmail.com");
        users.put("userEmail", "last3@gmail.com");

        users.put("age", "21");
        users.put("age", "22");
        users.put("age", "23");

        users.put("salary", "100");
        users.put("salary", "300");
        users.put("salary", "500");

        users.put("department", "last1");
        users.put("department", "last2");
        users.put("department", "last3");

        fillOutRegistrationForm(users);

        for (WebElement element : driver.findElements(By.xpath("//div[@class='rt-td'][2]"))) {
            System.out.println(element.getText());
        }

    }

    public static void fillOutRegistrationForm(Map<String, String> users) {

        for (Map.Entry<String, String> entry : users.entrySet()) {
            driver.findElement(By.id("addNewRecordButton")).click();
            driver.findElement(By.id("firstName")).sendKeys(users.get("firstName"));
            driver.findElement(By.id("lastName")).sendKeys(users.get("lastName"));
            driver.findElement(By.id("userEmail")).sendKeys(users.get("userEmail"));
            driver.findElement(By.id("age")).sendKeys(users.get("age"));
            driver.findElement(By.id("salary")).sendKeys(users.get("salary"));
            driver.findElement(By.id("department")).sendKeys(users.get("department"));
            driver.findElement(By.id("submit")).click();
        }
    }

}
