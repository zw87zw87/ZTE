package csv;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CSV1 {
    //文件名字
    private static String name = "测试题目.csv";

    public String sayHello() {
        return "hello";
    }

    public static void main(String[] args) {
        Path path = Paths.get(name);
        if (!Files.exists(path)){
            try {
                Files.createFile(path);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        writeCSV();
    }
    public static void writeCSV(){
        CSVFormat format = CSVFormat.DEFAULT.withRecordSeparator("\n");
        try {
            CSVPrinter printer = new CSVPrinter(new FileWriter(name), format);
            printer.printRecord("学号","姓名","年龄","成绩");
            List<User> list = new ArrayList<>();
            list.add(new User("001","张三",19,89.1));
            list.add(new User("002","李四",20,85.3));
            list.add(new User("003","王五",17,90));
            list.add(new User("004","赵六",23,93.4));
            for (User user : list){
                printer.printRecord(user.getNumber(),user.getName(),user.getAge(),user.getScore());
            }
            printer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
