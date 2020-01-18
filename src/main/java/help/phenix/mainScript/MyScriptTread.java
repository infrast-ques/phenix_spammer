package help.phenix.mainScript;

import help.phenix.PageObjects.OrderPage;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class MyScriptTread extends Thread {
    OrderPage orderPage;
    String name = "Ivan";
    String phone = "+79067008050";
    String email = "hello@gmail.com";
    String title = "1";
    String description = "1";
    int number;

    List<String> listOfSubjects;
    List<String> listOfOrderTypes;

    MyScriptTread(List<String> listOfSubjects, List<String> listOfOrderTypes, OrderPage orderPage, int number) {
        this.listOfSubjects = listOfSubjects;
        this.listOfOrderTypes = listOfOrderTypes;
        this.orderPage = orderPage;
        this.number = number;
    }

    public void run() {

            for (String subject : listOfSubjects) {
                for (String orderType : listOfOrderTypes) {
                    try {
                        orderPage
                                .openPage()
                                .clickTodayButton()
                                .fillSubjectField(subject)
                                .fillOrderTypeField(orderType)
                                .fillTitleField(title)
                                .fillDescriptionField(description)
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

    }

    private String getRandomEmail(){
        String emailArr[] = email.split("@");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yy.hh.mm");
        String randomEmail = emailArr[0] + simpleDateFormat.format(new Date()) + number + "@" + emailArr[1];
        return randomEmail;
    }
}
