package help.phenix.mainScript;

import help.phenix.Drivers.SetupDriver;
import help.phenix.Drivers.myChromeDriver;
import help.phenix.PageObjects.OrderPage;
import org.openqa.selenium.WebDriver;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class MyScriptThread extends Thread {
    String name = "Ivan";
    String phone = "+79067008050";
    String email = "hello@gmail.com";
    String title;
    String descriptionText;
    SetupDriver setupDriver = new myChromeDriver();
    WebDriver driver = setupDriver.getWebDriver();
    OrderPage orderPage = new OrderPage(driver);
    int number;

    List<String> listOfSubjects;
    List<String> listOfOrderTypes;

    MyScriptThread(List<String> listOfSubjects, List<String> listOfOrderTypes, int number, String title, String descriptionText) {
        this.listOfSubjects = listOfSubjects;
        this.listOfOrderTypes = listOfOrderTypes;
        this.number = number;
        this.descriptionText = descriptionText;
        this.title = title;
    }

    public void run() {
        try {
            Thread.sleep(1000 * number);
        } catch (InterruptedException e) {
        }
        for (String orderType : listOfOrderTypes) {
            for (String subject : listOfSubjects) {
                try {
                    orderPage
                            .openPage()
                            .clickTodayButton()
                            .fillSubjectField(subject)
                            .fillOrderTypeField(orderType)
                            .fillTitleField(title)
                            .fillDescriptionField(descriptionText)
                            .chooseTermOfAccomplish()
                            .submitOrderAtFormPage()
                            .fillNameField(name)
                            .fillPhoneField(phone)
                            .fillEmailField(getRandomEmail())
                            .leaveRequest();
                    System.gc();
                } catch (Exception e) {
                    System.out.println("Эххх, ошибочка вышла, пропущена отправка заказа для " + subject + " " + orderType);
                }
            }
        }
        setupDriver.tearDownWebDriver(driver);
    }

    private String getRandomEmail() {
        String emailArr[] = email.split("@");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yy.hh.mm");
        String randomEmail = emailArr[0] + simpleDateFormat.format(new Date()) + number + "@" + emailArr[1];
        return randomEmail;
    }
}
