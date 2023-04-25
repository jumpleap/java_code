package contactplus;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public @SuppressWarnings({"all"})
class ModifyContactDialog extends JDialog implements ActionListener {
    //组件
    private JLabel nameLabel, phoneLabel, addressLabel, birthdayLabel, emailLabel;
    private JTextField nameField, phoneField, addressField, birthdayField, emailField;
    private JButton modifyButton, cancelButton;
    private Contact contact;

    public ModifyContactDialog(JFrame parent, Contact contact) {
        super(parent, "修改联系人", true);
        setBounds(500, 400,300,200);
        setLayout(new GridLayout(6, 2));

        nameLabel = new JLabel("姓名:");
        nameField = new JTextField(contact.getName());
        phoneLabel = new JLabel("电话:");
        phoneField = new JTextField(contact.getPhone());
        addressLabel = new JLabel("地址:");
        addressField = new JTextField(contact.getAddress());
        birthdayLabel = new JLabel("生日:");
        birthdayField = new JTextField(contact.getBirthday());
        emailLabel = new JLabel("邮箱:");
        emailField = new JTextField(contact.getEmail());

        modifyButton = new JButton("Modify");
        cancelButton = new JButton("Cancel");
        modifyButton.addActionListener(this);
        cancelButton.addActionListener(this);

        //添加组件
        add(nameLabel);
        add(nameField);
        add(phoneLabel);
        add(phoneField);
        add(addressLabel);
        add(addressField);
        add(birthdayLabel);
        add(birthdayField);
        add(emailLabel);
        add(emailField);
        add(modifyButton);
        add(cancelButton);

        this.contact = contact;
    }

    public Contact getContact() {
        return contact;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        //获取文本框中的内容
        if (source == modifyButton) {
            String name = nameField.getText();
            String phone = phoneField.getText();
            String address = addressField.getText();
            String birthday = birthdayField.getText();
            String email = emailField.getText();
            //添加到联系人中
            contact.setName(name);
            contact.setPhone(phone);
            contact.setAddress(address);
            contact.setBirthday(birthday);
            contact.setEmail(email);
            dispose();
        } else if (source == cancelButton) {
            dispose();
        }
    }
}