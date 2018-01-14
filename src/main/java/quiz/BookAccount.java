package quiz;

import java.util.Scanner;

public class BookAccount {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        //输入书名字
        String book = in.nextLine();
        //不同的书，获取不同的折扣系数
        float account = getAccount(book);
        System.out.println("图书(" + book +")的折扣系数为：" + account);
    }
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
