package csv;

import org.junit.Assert;
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
        List<User> expList = new CSVmain().readCSV("测试题目.csv", 1, 1);
        Assert.assertEquals(list.toArray()[0].toString(), expList.toArray()[0].toString());
        Assert.assertEquals(list.toArray()[1].toString(), expList.toArray()[1].toString());
        Assert.assertEquals(list.toArray()[2].toString(), expList.toArray()[2].toString());
        Assert.assertEquals(list.toArray()[3].toString(), expList.toArray()[3].toString());
    }

    @Test
    public void createSort() throws Exception {
        List<User> numList = new ArrayList<>();
        numList.add(list.get(0));
        numList.add(list.get(1));
        numList.add(list.get(2));
        numList.add(list.get(3));

        List<User> numList1 = new ArrayList<>();
        numList1.add(list.get(3));
        numList1.add(list.get(2));
        numList1.add(list.get(1));
        numList1.add(list.get(0));

        new CSVmain().createSort(list, 1,   1);
        Assert.assertArrayEquals(numList.toArray(), list.toArray());

        new CSVmain().createSort(list, 1,   2);
        Assert.assertArrayEquals(numList1.toArray(), list.toArray());
    }

    @Test
    public void writeCSV() throws Exception {
        new CSVmain().createCSV();
    }

}