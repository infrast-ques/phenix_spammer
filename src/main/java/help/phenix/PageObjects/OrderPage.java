package help.phenix.PageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderPage {

    WebDriver driver;
    @FindBy(xpath = "//div/a[text()=\"Сегодня\"]")
    private WebElement todayButton;

    @FindBy(css = "input#subjectId-selectized")
    private WebElement subjectFiled;
    @FindBy(css = "input#orderTypeId-selectized")
    private WebElement orderTypeField;
    @FindBy(css = "textarea#description")
    private WebElement descriptionField;
    @FindBy(css = "input#title")
    private WebElement titleField;
    @FindBy(xpath = "//div/a[contains(text(), 'Отправить на оценку')]")
    private WebElement submitFormLocator;
    @FindBy(css = "div#step2 input.deadlineDatepicker.flatpickr-input")
    private WebElement calendarClosedLocator;
    @FindBy(css = "div.flatpickr-calendar:nth-of-type(3) span:nth-of-type(35)")
    private WebElement calendarDay40Locator;

    @FindBy(css = "input#orderName")
    private WebElement orderNameField;
    @FindBy(css = "input#orderPhone")
    private WebElement orderPhoneField;
    @FindBy(css = "input#orderEmail")
    private WebElement orderEmailField;
    @FindBy(css = "a#leaveRequest")
    private WebElement leaveRequestButton;


    public OrderPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public OrderPage openPage() {
        driver.get("https://phenix.help/#order");
        return this;
    }

    public OrderPage clickTodayButton() {
        todayButton.click();
        return this;
    }

    public OrderPage fillSubjectField(String subject) {
        subjectFiled.sendKeys(subject);
        subjectFiled.sendKeys(Keys.ENTER);
        return this;
    }

    public OrderPage fillOrderTypeField(String orderType) {
        orderTypeField.sendKeys(orderType);
        orderTypeField.sendKeys(Keys.ENTER);
        return this;
    }

    public OrderPage fillTitleField(String title) {
        titleField.sendKeys(title);
        return this;
    }

    public OrderPage fillDescriptionField(String description) {
        descriptionField.sendKeys(description);
        return this;
    }

    public OrderPage chooseTermOfAccomplish() {
        calendarClosedLocator.click();
        calendarDay40Locator.click();
        return this;
    }

    public OrderPage submitOrderAtFormPage() {
        submitFormLocator.click();
        return this;
    }

    public OrderPage fillNameField(String name) {
        orderNameField.sendKeys(name);
        return this;
    }

    public OrderPage fillPhoneField(String phone) {
        orderPhoneField.sendKeys(phone);
        return this;
    }

    public OrderPage fillEmailField(String email) {
        orderEmailField.sendKeys(email);
        return this;
    }

    public OrderPage leaveRequest() {
        leaveRequestButton.click();
        return this;
    }
}
