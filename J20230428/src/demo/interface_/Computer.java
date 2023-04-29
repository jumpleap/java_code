package demo.interface_;

public class Computer implements USB {

    @Override
    public void openDevice() {
        System.out.println("打开电脑~");
    }

    @Override
    public void closeDevice() {
        System.out.println("关闭电脑~");
    }
}
