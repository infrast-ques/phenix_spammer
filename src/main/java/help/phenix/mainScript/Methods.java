package help.phenix.mainScript;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Methods {

    public List<String> getSubjectsList(int fileNumber) {
        BufferedReader fileReader;
        String path = "subjectsList" + fileNumber +".txt";
        List<String> list= new ArrayList<>();
        try {
            fileReader = new BufferedReader(new FileReader(getClass().getClassLoader().getResource(path).getFile()));
            while (fileReader.ready()){
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
    public List<String> getOrderTypeList() {
        BufferedReader fileReader;
        List<String> list= new ArrayList<>();
        try {
            fileReader = new BufferedReader(new FileReader(getClass().getClassLoader().getResource("ordersTypeList.txt").getFile()));
            while (fileReader.ready()){
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
