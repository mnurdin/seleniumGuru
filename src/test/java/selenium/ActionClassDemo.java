package selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;

public class ActionClassDemo {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://demoqa.com/droppable");

        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droppable"));

        Actions builder = new Actions(driver);
//        builder.dragAndDrop(source,target).perform();

        builder.moveToElement(source)
                .clickAndHold(source)
                .moveToElement(target)
                .release(target)
                .build().perform();
//        driver.quit();
    }

    private static void multipleActions(WebDriver driver) {
        driver.get("https://www.facebook.com/");

        WebElement txtUsername = driver.findElement(By.id("email"));

        Actions actions = new Actions(driver);

        Action multipleActions = actions.moveToElement(txtUsername)
                        .click()
                        .keyDown(txtUsername, Keys.SHIFT)
                        .sendKeys("hello")
                        .keyUp(txtUsername,Keys.SHIFT)
                        .doubleClick(txtUsername)
                        .build();
        multipleActions.perform();
    }

    private static void hoverOverExample(WebDriver driver) {
        driver.get("https://demoqa.com/tool-tips");

        WebElement toolTipBtn = driver.findElement(By.id("toolTipButton"));

        Actions builder = new Actions(driver);

        Action tooltip = builder.moveToElement(toolTipBtn).build();

        String bg_color = toolTipBtn.getCssValue("background-color");
        System.out.println("Before hover over "+ bg_color);
        System.out.println(Color.fromString(bg_color).asHex());

        tooltip.perform();

        bg_color = toolTipBtn.getCssValue("background-color");
        System.out.println("After hover over "+ bg_color);
        System.out.println(Color.fromString(bg_color).asHex());
    }

}
