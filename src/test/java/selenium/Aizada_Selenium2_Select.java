package selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Aizada_Selenium2_Select {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

       // driver.navigate().to("https://demoqa.com/login");
        driver.get("https://demoqa.com/select-menu");

        //Maximizing window
        driver.manage().window().maximize();

        //Selecting the multi-select element by locating its id
        WebElement multiSelect=driver.findElement(By.id("cars"));

        Select select = new Select(multiSelect);      //a parameter has to be a webElement

        System.out.println("Options from the dropdown  for cars are: ");

        List<WebElement> carOptions=select.getOptions();
        for(WebElement option:carOptions){
            System.out.println(option.getText());
        }

        boolean isMultiSelect= select.isMultiple(); //Verifying that the element is multi-select
        System.out.println("This element is " + isMultiSelect);
        //select by index:
        System.out.println("Opel is selected by index 2");
        select.selectByIndex(2);

        System.out.println("Opel is deselected by index 2");
        select.deselectByIndex(2);

        //select by value:
        System.out.println("Saab is selected by value");
        select.selectByValue("saab");

        //select by visible text:
        System.out.println("Audi is selected by text");
        select.selectByVisibleText("Audi");

        List<WebElement> listOfSelectedElements=select.getAllSelectedOptions();
        select.deselectAll();
        driver.quit();
    }
}
