import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DialogExample extends JFrame{

    private JButton button;

    public DialogExample() {
        setTitle("弹窗示例");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        button = new JButton("点击弹出窗口");
        button.addActionListener(e -> {
            // 创建一个新的 JDialog 对象
            JDialog dialog = new JDialog(this, "弹出窗口", true);
            dialog.setSize(200, 100);
            dialog.setResizable(false);

            // 向 JDialog 中添加组件
            JPanel dialogPanel = new JPanel();
            JLabel label = new JLabel("这是一个弹出窗口");
            dialogPanel.add(label);
            dialog.getContentPane().add(dialogPanel);

            // 显示 JDialog
            dialog.setVisible(true);
        });
        panel.add(button);
        add(panel);

        setVisible(true);
    }

    public static void main(String[] args) {
        new DialogExample();
    }
}
