package practice;

public class Demo {
    public static void main(String[] args) {
        Date date = new Date();//实例化一个对象
        //调用Date类的成员方法
        date.setDate(2002, 12, 2);
        date.printDate();

        //注：一个类可以实例化多个对象
        Date date1 = new Date();
        Date date2 = new Date();

    }
}

class Date {
    public int year;
    public int month;
    public int day;

    //this:谁调用this，this就代表谁
    //public void setDate(Date this, int year, int month, int day) {
    public void setDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    //打印Date时间
    public void printDate() {
        System.out.println("年：" + this.year + "月：" + this.month + "日：" + this.day);
    }
}
