package csv;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class CSV1 {
    //文件名字
    private static String name = "测试题目.csv";

    public String sayHello() {
        return "hello";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请选择序号： 1.学号排序 2.年龄排序 3.成绩排序");
        int num = scanner.nextInt();
        System.out.println("请选择排序方式： 1.正序 2.倒序");
        int sort = scanner.nextInt();

//        createCSV();
//        writeCSV();
        readCSV(name, num, sort);
    }

    public static void createCSV() {
        Path path = Paths.get(name);
        if (!Files.exists(path)){
            try {
                Files.createFile(path);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void readCSV(String name, int num, int sort) {
        try {
            List<User> list = new ArrayList<>();
            CSVParser parser = new CSVParser(new FileReader(name), CSVFormat.DEFAULT.withHeader());
            for (CSVRecord record : parser){
                User user = new User(record.get("学号"),
                        record.get("姓名"),
                        Integer.parseInt(record.get("年龄")),
                        Double.parseDouble(record.get("成绩")));
                list.add(user);
            }

            createSort(list, num, sort);

            for (User u : list){
                System.out.println(u.getNumber() + ", "+ u.getName() +", "+ u.getAge() +", "+u.getScore());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void createSort(List<User> list, int num, int sort) {
        //正序
        if (num == 1 && sort == 1){
            Collections.sort(list, Comparator.comparing(User::getNumber));
        }else if (num == 2&& sort == 1){
            Collections.sort(list, Comparator.comparing(User::getAge));
        }else if (num == 3&& sort == 1){
            Collections.sort(list, Comparator.comparing(User::getScore));
        }
        //倒序
        if (num == 1 && sort == 2){
            Collections.sort(list, Comparator.comparing(User::getNumber).reversed());
        }else if (num == 2&& sort == 2){
            Collections.sort(list, Comparator.comparing(User::getAge).reversed());
        }else if (num == 3&& sort == 2){
            Collections.sort(list, Comparator.comparing(User::getScore).reversed());
        }
    }

    public static void writeCSV(){
        CSVFormat format = CSVFormat.DEFAULT.withRecordSeparator("\n");
        try {
            CSVPrinter printer = new CSVPrinter(new FileWriter(name), format);
            printer.printRecord("学号","姓名","年龄","成绩");
            List<User> list = new ArrayList<>();
            list.add(new User("1","张三",19,89.1));
            list.add(new User("2","李四",20,85.3));
            list.add(new User("3","王五",17,90));
            list.add(new User("4","赵六",23,93.4));
            for (User user : list){
                printer.printRecord(user.getNumber(),user.getName(),user.getAge(),user.getScore());
            }
            printer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
