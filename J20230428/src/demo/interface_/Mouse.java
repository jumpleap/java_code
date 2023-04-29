package demo.interface_;

public class Mouse implements USB {
    public void openDevice() {
        System.out.println("打开鼠标~");
    }

    public void closeDevice() {
        System.out.println("关闭鼠标");
    }

    public void click() {
        System.out.println("点击鼠标");
    }
}
