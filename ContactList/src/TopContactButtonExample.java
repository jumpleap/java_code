import contactplus.Contact;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 置顶类
 */
public class TopContactButtonExample extends JFrame {
    private DefaultListModel<Contact> contactsModel;
    private JList<Contact> listContacts;

    public TopContactButtonExample() {
        // 初始化置顶按钮
        JButton btnTopContact = new JButton("置顶");
        btnTopContact.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 获取选中的联系人
                Contact selectedContact = listContacts.getSelectedValue();
                if (selectedContact == null) {
                    return;
                }

                // 将选中的联系人置顶
                contactsModel.removeElement(selectedContact);
                contactsModel.add(0, selectedContact);
                listContacts.setSelectedIndex(0);
            }
        });

        // 添加联系人列表和置顶按钮到窗口
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(new JScrollPane(listContacts), BorderLayout.CENTER);
        panel.add(btnTopContact, BorderLayout.SOUTH);
        getContentPane().add(panel);

        // 设置窗口属性
        setTitle("置顶联系人示例");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TopContactButtonExample().setVisible(true);
            }
        });
    }
}