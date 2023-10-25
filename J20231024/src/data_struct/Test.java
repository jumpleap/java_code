package data_struct;

public class Test {
    public static void main(String[] args) {
        MySingleList mySingleList = new MySingleList();
        /*mySingleList.headInsert(1);
        mySingleList.headInsert(2);
        mySingleList.headInsert(3);*/

        //mySingleList.display();

        mySingleList.tailInsert(1);
        mySingleList.tailInsert(2);
        mySingleList.tailInsert(3);
        mySingleList.tailInsert(4);
        mySingleList.tailInsert(5);
        mySingleList.tailInsert(6);
        mySingleList.display();

        mySingleList.randomInsert(0, 111);
        mySingleList.randomInsert(7, 111);
        mySingleList.randomInsert(3, 111);
        //mySingleList.randomInsert(12, 111);
        mySingleList.display();


        mySingleList.remove(2);
        mySingleList.display();

        mySingleList.removeAllValue(111);
        mySingleList.display();

    }
}
