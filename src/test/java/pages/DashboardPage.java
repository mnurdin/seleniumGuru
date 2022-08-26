package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocator;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class DashboardPage {

    WebDriver driver;
    public DashboardPage(WebDriver driver) {
        this.driver = driver;
        AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 30);
        PageFactory.initElements(factory,this);
    }

    @FindBy(id = "header")
    WebElement header;

    @FindBy(css = "h3 a[href='addtariffplans.php']")
    WebElement addTariffPlanLink;

    @FindBy(css = "h3 a[href='billing.php']")
    WebElement payBillingLink;

    @FindBy(css = "h3 a[href='assigntariffplantocustomer.php']")
    WebElement addTarifPlanToCustomerLink;

    @FindBy(css = "h3 a[href='addcustomer.php']")
    WebElement addCustomerLink;

    public String getHeader() {
        return header.getText();
    }

    public void goTo(String pageName) {
        switch (pageName) {
            case "Add Customer":
                addCustomerLink.click();
                break;
            default:
                System.out.println("Please provide a valid page name!?");
                break;
        }
    }

}

