package quiz;

import java.util.Scanner;

public class BookAccount {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        float price = 0.0f;

        System.out.println("请输入书的种类：");
        String book = in.nextLine();
        float account = getAccount(book);
        System.out.println("请输入书的数量：");
        int num = in.nextInt();
        price = account * num;

        System.out.println("书的总价格为：" + price);
    }
    //计算折扣系数
    public static float getAccount(String book){
        float account = 0.0f;
        if (book.equals("新书")){
            account = 1.2f;
        }else if (book.equals("常规图书")){
            account = 1.0f;
        }else if (book.equals("滞销图书")){
            account = 0.6f;
        }
        return account;
    }
}
