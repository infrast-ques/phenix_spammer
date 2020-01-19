package help.phenix.mainScript;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Methods {

    public void startTread(int amountOfThreads, String title,String descriptionText) {
        List<MyScriptThread> listOfMyThread = new ArrayList<>();
        List<String> listOfAllSubjects = getSubjectsListAll();
        List<String> listOfSubjects;

        for (int i = 1; i <= amountOfThreads; i++) {
            listOfSubjects = dividingSubjectList(listOfAllSubjects, i, amountOfThreads);
            List<String> listOfOrderTypes = getOrderTypeList();
            MyScriptThread myScriptThread = new MyScriptThread(listOfSubjects, listOfOrderTypes, i, title, descriptionText);
            listOfMyThread.add(myScriptThread);
            myScriptThread.start();
        }

        for (MyScriptThread thread : listOfMyThread) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                System.out.println("Что-то пошло не так =(");
                e.printStackTrace();
            }
        }
    }

    public List<String> getSubjectsListAll() {
        BufferedReader fileReader;
        String path = "subjectsListAll.txt";
        List<String> list = new ArrayList<>();
        try {
            fileReader = new BufferedReader(new FileReader(getClass().getClassLoader().getResource(path).getFile()));
            while (fileReader.ready()) {
                list.add(fileReader.readLine());
            }
            fileReader.close();
        } catch (Exception e) {
            System.out.println("Файл со списком предметов не найден");
            System.out.println(getClass().getClassLoader().getResource(path).getFile());
            return null;
        }
        return list;
    }

    public List<String> dividingSubjectList(List<String> list, int threadNumber, int amountThreads) {

        int endNumberOfStrings = (int) Math.floor(list.size() / amountThreads) * threadNumber;
        int startNumberOfStrings = endNumberOfStrings - (int) Math.floor(list.size() / amountThreads);

        System.out.println(threadNumber + ": " + startNumberOfStrings + " " + endNumberOfStrings);

        List<String> subjectsList = new ArrayList<>();
        for (int i = startNumberOfStrings; i < endNumberOfStrings; i++) {
            subjectsList.add(list.get(i));
        }

        try {
            if (threadNumber == amountThreads) {
                for (int i = endNumberOfStrings; i <= amountThreads; i++) {
                    subjectsList.add(list.get(i));
                }
            }
        } catch (Exception e) {
            System.out.println("Что-то не так с добавлением предметов в последний поток, " +
                    "возможно парочку предметов не было добавлено =)");
            e.printStackTrace();
        }
        return subjectsList;
    }

    public List<String> getOrderTypeList() {
        BufferedReader fileReader;
        List<String> list = new ArrayList<>();
        try {
            fileReader = new BufferedReader(new FileReader(getClass().getClassLoader().getResource("ordersTypeList.txt").getFile()));
            while (fileReader.ready()) {
                list.add(fileReader.readLine());
            }
            fileReader.close();
        } catch (Exception e) {
            System.out.println("Файл с типами работ не найден");
            System.out.println(getClass().getClassLoader().getResource("ordersTypeList.txt").getFile());
            return null;
        }
        return list;
    }
}
