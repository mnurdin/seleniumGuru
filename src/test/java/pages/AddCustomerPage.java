package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class AddCustomerPage {
    WebDriver driver;

    public AddCustomerPage(WebDriver driver) {
        this.driver = driver;
        AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 30);
        PageFactory.initElements(factory, this);
    }

    @FindBy(xpath = "//header/h1")
    WebElement header;

    @FindBy(id = "done")
    WebElement doneRadioBtn;

    @FindBy(id = "pending")
    WebElement pendingRadioBtn;

    @FindBy(id = "fname")
    WebElement firstName;

    @FindBy(id = "lname")
    WebElement lastName;

    @FindBy(id = "email")
    WebElement emailField;

    @FindBy(id = "message")
    WebElement messageTextArea;

    @FindBy(id = "telephoneno")
    WebElement phoneNumberField;

    @FindBy(name = "submit")
    WebElement submitBtn;

    @FindBy(xpath = "//input[@value='Reset']")
    WebElement resetBtn;

    public String getHeader() {
        return header.getText();
    }

    public void fillOutTheForm(String backrgroundCheck, String fname, String lname,
                               String email, String message, String mobileNumber) {
        if (backrgroundCheck.equalsIgnoreCase("done"))
            doneRadioBtn.click();
        else if (backrgroundCheck.equalsIgnoreCase("pending"))
            pendingRadioBtn.click();
        else System.out.println("Please provide valid option!?");

        firstName.sendKeys(fname);
        lastName.sendKeys(lname);
        emailField.sendKeys(email);
        messageTextArea.sendKeys(message);
    }
}
