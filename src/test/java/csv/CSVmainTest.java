package csv;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class CSVmainTest {
    List<User> list = new ArrayList<>();
    @Before
    public void setUp() throws Exception{
        list.add(new User("1","张三",19,89.1));
        list.add(new User("2","李四",20,85.3));
        list.add(new User("3","王五",17,90));
        list.add(new User("4","赵六",23,93.4));
    }
    @Test
    public void main() throws Exception {
    }

    @Test
    public void printList() throws Exception {
        new CSVmain().printList(list, "测试排序");
    }

    @Test
    public void createCSV() throws Exception {
        new CSVmain().createCSV();
    }

    @Test
    public void readCSV() throws Exception {
        new CSVmain().readCSV("测试题目.csv", 1, 1);
    }

    @Test
    public void createSort() throws Exception {
        new CSVmain().createSort(list, 1, 1);
    }

    @Test
    public void writeCSV() throws Exception {
        new CSVmain().createCSV();
    }

}