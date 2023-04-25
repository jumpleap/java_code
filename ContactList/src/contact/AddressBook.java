package contact;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
@SuppressWarnings({"all"})

public class AddressBook extends JFrame {
    //创建表格
    private DefaultTableModel tableModel;
    private JTable table;

    //可添加的信息
    private JTextField nameField;
    private JTextField ageField;
    private JTextField phoneField;
    private JTextField addressField;
    private JTextField birthdayField;
    private JTextField emailField;

    //按钮
    private JButton addButton;//增加按钮
    private JButton editButton;//修改按钮
    private JButton deleteButton;//删除按钮
    private JButton searchButton;//查找按钮
    private JButton sortButton;//排序按钮

    private List<Contact> contacts = new ArrayList<>();

    public AddressBook() {
        // 设置窗口标题
        setTitle("通讯录");
        // 设置窗口大小和位置
        setSize(1500, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 创建通讯录表格
        tableModel = new DefaultTableModel(new Object[] { "姓名", "年龄", "电话", "住址","生日","邮箱" }, 0);
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        // 创建添加、编辑、删除按钮和输入框
        nameField = new JTextField(10);
        ageField = new JTextField(10);
        phoneField = new JTextField(10);
        addressField = new JTextField(10);
        birthdayField = new JTextField(10);
        emailField = new JTextField(10);

        addButton = new JButton("增加");
        deleteButton = new JButton("删除");
        searchButton = new JButton("查找");
        editButton = new JButton("修改");
        sortButton = new JButton("排序");

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(new JLabel("姓名:"));
        buttonPanel.add(nameField);
        buttonPanel.add(new JLabel("年龄:"));
        buttonPanel.add(ageField);
        buttonPanel.add(new JLabel("电话:"));
        buttonPanel.add(phoneField);
        buttonPanel.add(new JLabel("住址:"));
        buttonPanel.add(addressField);
        buttonPanel.add(new JLabel("生日:"));
        buttonPanel.add(birthdayField);
        buttonPanel.add(new JLabel("邮箱:"));
        buttonPanel.add(emailField);

        //添加按钮：增删查改排序
        buttonPanel.add(addButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(searchButton);
        buttonPanel.add(editButton);
        buttonPanel.add(sortButton);
        //添加到窗口去
        add(buttonPanel, BorderLayout.SOUTH);

        init();//初始化表格

        // 绑定按钮的事件处理器
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addContact();
            }
        });
        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editContact();
            }
        });
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteContact();
            }
        });

    }

    /**
     * 初始化表格
     */
    private void init() {
        String name = "jack";
        String age = "18";
        String phone = "1763565365";
        String address = "北京";
        String birthday = "12月12日";
        String email = "1636764.qq.com";
        Contact contact = new Contact(name,age,phone,address,birthday,email);
        contacts.add(contact);


        //添加到表格中
        tableModel.addRow(new Object[] { contact.getName(), contact.getAge(), contact.getPhone(),
                contact.getAddress(),contact.getBirthday(),contact.getEmail()});
    }

    /**
     * 添加联系人信息
     */
    private void addContact() {
        //添加信息
        String name = nameField.getText();
        String age = ageField.getText();
        String phone = phoneField.getText();
        String address = addressField.getText();
        String birthday = birthdayField.getText();
        String email = emailField.getText();

        if(name.isEmpty() || age.isEmpty() || phone.isEmpty() || address.isEmpty()
                || birthday.isEmpty() || email.isEmpty()) {
            // 如果有空白，弹出错误提示框
            JOptionPane.showMessageDialog(this, "请添加正确联系人的信息~.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        Contact contact = new Contact(name,age,phone,address,birthday,email);
        contacts.add(contact);

        //添加到表格中
        tableModel.addRow(new Object[] { contact.getName(), contact.getAge(), contact.getPhone(),
                contact.getAddress(),contact.getBirthday(),contact.getEmail()});
    }

    /**
     * 删除联系人
     */
    private void deleteContact() {
        //选中对应的行号进行删除
        int rowIndex = table.getSelectedRow();
        if (rowIndex >= 0) {
            contacts.remove(rowIndex);
            tableModel.removeRow(rowIndex);
        }
    }

    // 编辑联系人
    private void editContact() {
        int rowIndex = table.getSelectedRow();
        if (rowIndex >= 0) {
            Contact contact = contacts.get(rowIndex);
            String name = nameField.getText();
            String phone = phoneField.getText();
            String email = emailField.getText();
            contact.setName(name);
            contact.setPhone(phone);
            contact.setEmail(email);
            tableModel.setValueAt(name, rowIndex, 0);
            tableModel.setValueAt(phone, rowIndex, 1);
            tableModel.setValueAt(email, rowIndex, 2);
        }
    }
}