package help.phenix.mainScript;

import help.phenix.Drivers.SetupDriver;
import help.phenix.Drivers.myChromeDriver;
import help.phenix.PageObjects.OrderPage;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class MainClass {

    public static void main(String[] args) {
        Methods methods = new Methods();
        SetupDriver setupDriver1 = new myChromeDriver();
        SetupDriver setupDriver2 = new myChromeDriver();
        SetupDriver setupDriver3 = new myChromeDriver();

        WebDriver driver1 = setupDriver1.getWebDriver();
        WebDriver driver2 = setupDriver2.getWebDriver();
        WebDriver driver3 = setupDriver3.getWebDriver();

        OrderPage orderPage1 = new OrderPage(driver1);
        OrderPage orderPage2 = new OrderPage(driver2);
        OrderPage orderPage3 = new OrderPage(driver3);

        List<String> listOfSubjects1 = methods.getSubjectsList(1);
        List<String> listOfSubjects2 = methods.getSubjectsList(2);
        List<String> listOfSubjects3 = methods.getSubjectsList(3);

        List<String> listOfOrderTypes1 = methods.getOrderTypeList();
        List<String> listOfOrderTypes2 = methods.getOrderTypeList();
        List<String> listOfOrderTypes3 = methods.getOrderTypeList();

        MyScriptTread myScriptTread1 = new MyScriptTread(listOfSubjects1, listOfOrderTypes1, orderPage1,1);
        MyScriptTread myScriptTread2 = new MyScriptTread(listOfSubjects2, listOfOrderTypes2, orderPage2,2);
        MyScriptTread myScriptTread3 = new MyScriptTread(listOfSubjects3, listOfOrderTypes3, orderPage3,3);

        myScriptTread1.start();
        myScriptTread2.start();
        myScriptTread3.start();

        try {
            myScriptTread1.join();
            myScriptTread2.join();
            myScriptTread3.join();
        } catch (InterruptedException e) {
            System.out.println("Что-то пошло не так =(");
            e.printStackTrace();
        }
        setupDriver1.tearDownWebDriver(driver1);
        setupDriver2.tearDownWebDriver(driver2);
        setupDriver3.tearDownWebDriver(driver3);

    }
}
