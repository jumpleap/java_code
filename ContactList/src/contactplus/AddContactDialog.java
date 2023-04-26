package contactplus;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings({"all"})

/**
 * 添加联系人类
 */
public class AddContactDialog extends JDialog implements ActionListener {
    //组件
    private JLabel nameLabel, phoneLabel, addressLabel, birthdayLabel, emailLabel;
    private JTextField nameField, phoneField, addressField, birthdayField, emailField;
    private JButton addButton, cancelButton;
    private Contact contact;

    public AddContactDialog(JFrame parent) {
        super(parent, "添加联系人", true);
        setBounds(500, 400,300,200);
        setLayout(new GridLayout(6,2));

        nameLabel = new JLabel("姓名:");
        nameField = new JTextField();
        phoneLabel = new JLabel("电话:");
        phoneField = new JTextField();
        addressLabel = new JLabel("地址:");
        addressField = new JTextField();
        birthdayLabel = new JLabel("生日:");
        birthdayField = new JTextField();
        emailLabel = new JLabel("邮箱:");
        emailField = new JTextField();

        addButton = new JButton("Add");
        cancelButton = new JButton("Cancel");
        addButton.addActionListener(this);
        cancelButton.addActionListener(this);

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
        add(addButton);
        add(cancelButton);
    }

    public Contact getContact() {
        return contact;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source == addButton) {
            String name = nameField.getText();
            String phone = phoneField.getText();
            String address = addressField.getText();
            String birthday = birthdayField.getText();
            String email = emailField.getText();
            contact = new Contact(name, phone, address, birthday, email);
            dispose();
        } else if (source == cancelButton) {
            dispose();
        }
    }
}