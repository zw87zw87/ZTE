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

public class CSVmain {
    //文件名字
    private static String name = "测试题目.csv";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        System.out.println("请选择序号： 1.学号排序 2.年龄排序 3.成绩排序");
        int num = scanner.nextInt();

        if (num == 1){
            sb.append("学号排序");
        }else if(num == 2){
            sb.append("年龄排序");
        }else if(num == 3){
            sb.append("成绩排序");
        }
        sb.append("_");

        System.out.println("请选择排序方式： 1.正序 2.倒序");
        int sort = scanner.nextInt();

        if (sort == 1){
            sb.append("正序");
        }else if(sort == 2){
            sb.append("倒序");
        }
        sb.append("_");

        //初始化文件
//        createCSV();
        //读取文件内容，并排序
        List<User> list = readCSV(name, num, sort);

        //打印到控制台
        printList(list, sb.toString());
        //打印到文件
        writeCSV(list, sb.toString());
    }

    public static void printList(List<User> list, String exFile) {
        System.out.println(exFile);
        for (User u : list){
            System.out.println(u.getNumber() + ", "+ u.getName() +", "+ u.getAge() +", "+u.getScore());
        }
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
        //初始化文件内容
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

    public static List<User> readCSV(String name, int num, int sort) {
        List<User> list = new ArrayList<>();
        try {
            CSVParser parser = new CSVParser(new FileReader(name), CSVFormat.DEFAULT.withHeader());
            for (CSVRecord record : parser){
                User user = new User(record.get("学号"),
                        record.get("姓名"),
                        Integer.parseInt(record.get("年龄")),
                        Double.parseDouble(record.get("成绩")));
                list.add(user);
            }

            //排序
            createSort(list, num, sort);

//            for (User u : list){
//                System.out.println(u.getNumber() + ", "+ u.getName() +", "+ u.getAge() +", "+u.getScore());
//            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
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

    public static void writeCSV(List<User> list, String exFile){
        CSVFormat format = CSVFormat.DEFAULT.withRecordSeparator("\n");
        try {
            CSVPrinter printer = new CSVPrinter(new FileWriter(exFile + name), format);
            printer.printRecord("学号","姓名","年龄","成绩");
            for (User user : list){
                printer.printRecord(user.getNumber(),user.getName(),user.getAge(),user.getScore());
            }
            printer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
