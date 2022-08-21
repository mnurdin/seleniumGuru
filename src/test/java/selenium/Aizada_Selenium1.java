package selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Aizada_Selenium1 {

    public static void main(String[] args) {
        String expectedTitle="ToolsQA";

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

       // driver.navigate().to("https://demoqa.com/login");
        driver.get("https://demoqa.com/login");

        //Maximizing window
        driver.manage().window().maximize();

        //Retrieving web page title
        String title = driver.getTitle();  //retuns String

        System.out.println("The page title is : " +title);


        //Validation of Title = Assertion of Title:

        if(expectedTitle.equalsIgnoreCase(title)){
            System.out.println("Title is valid. Test is passed!");
        }else{
            System.out.println("Title does not match expected String. Test Failing!");
        }

        //Locating web element
        //Xpath : Absolute (full path and Relative (shortcut)
        WebElement uName = driver.findElement(By.xpath("//*[@id='userName']"));
        WebElement pswd = driver.findElement(By.xpath("//*[@id='password']"));
        WebElement loginBtn = driver.findElement(By.xpath("//*[@id='login']"));


        //Peforming actions on web elements
        uName.sendKeys("testuser");
        pswd.sendKeys("Password@123");
        loginBtn.click();

        try {

            //Locating web element
            WebElement logoutBtn = driver.findElement(By.xpath("//div[@class='text-right col-md-5 col-sm-12']//button[@id='submit']"));
            //Validating presence of element
            if(logoutBtn.isDisplayed()){

                //Performing action on web element
                logoutBtn.click();
                System.out.println("LogOut Successful!");
            }
        }
        catch (Exception e) {
            System.out.println("Incorrect login....");
        }
        driver.quit();
    }
}
