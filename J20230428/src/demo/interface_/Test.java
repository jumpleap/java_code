package demo.interface_;

public class Test {
    public static void main(String[] args) {
        USB usb = new Computer();
        usb.openDevice();

        print(new KeyBoard());
        print(new Mouse());

        usb.closeDevice();
    }

    private static void print(USB usb) {
        usb.openDevice();
        if (usb instanceof KeyBoard) {
            ((KeyBoard) usb).input();
        } else if (usb instanceof Mouse) {
            ((Mouse) usb).click();
        }
        usb.closeDevice();
    }
}
