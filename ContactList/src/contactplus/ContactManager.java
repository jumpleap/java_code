package contactplus;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

@SuppressWarnings({"all"})
public class ContactManager extends JFrame implements ActionListener {
    //可视化框架必需组件
    private JButton addButton, deleteButton, searchButton, modifyButton, sortButton, groupButton, topButton, loginButton, cancerButton;
    private JLabel nameLabel, ageLabel, addressLabel, birthdayLabel, emailLabel;
    private JTextField nameField, ageField, addressField, birthdayField, emailField;
    private JPanel inputPanel, buttonPanel;
    private JTable table;
    private JScrollPane scrollPane;
    private ArrayList<Contact> contacts;

    /**
     * 构造器
     */
    public ContactManager() {
        setTitle("通讯录");//主框架名
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//关闭方式
        //设置长宽和位置
        setBounds(200, 200, 800, 600);
        setLayout(new BorderLayout());

        // 创建输入面板
        inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(4, 2));

        // 创建按钮面板
        buttonPanel = new JPanel();
        addButton = new JButton("添加联系人");
        deleteButton = new JButton("删除联系人");
        searchButton = new JButton("搜索联系人");
        modifyButton = new JButton("修改联系人");
        sortButton = new JButton("排序联系人");
        groupButton = new JButton("联系人分组");
        topButton = new JButton("置顶联系人");

        //把组件添加到主框架中
        buttonPanel.add(addButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(searchButton);
        buttonPanel.add(modifyButton);
        buttonPanel.add(sortButton);
        buttonPanel.add(groupButton);
        buttonPanel.add(topButton);
        //事件响应
        addButton.addActionListener(this);
        deleteButton.addActionListener(this);
        searchButton.addActionListener(this);
        modifyButton.addActionListener(this);
        sortButton.addActionListener(this);
        groupButton.addActionListener(this);
        topButton.addActionListener(this);

        // 创建表格
        contacts = new ArrayList<>();
        String[] columnNames = {"姓名", "电话", "地址", "生日", "邮箱"};
        Object[][] data = new Object[0][5];
        table = new JTable(data, columnNames);
        scrollPane = new JScrollPane(table);

        // 添加组件
        add(inputPanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);
        add(scrollPane, BorderLayout.SOUTH);

        setVisible(true);//可视化
    }



    /**
     * 匹配按钮所对应的功能
     *
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source == addButton) {
            // 弹出添加联系人窗口
            AddContactDialog dialog = new AddContactDialog(this);
            dialog.setVisible(true);
            Contact contact = dialog.getContact();
            if (contact != null) {
                //判断有没有其中一个内容是空，是空的话输出错误信息
                if (contact.getName().isEmpty() || contact.getPhone().isEmpty() || contact.getAddress().isEmpty()
                        || contact.getBirthday().isEmpty() || contact.getEmail().isEmpty()) {
                    JOptionPane.showMessageDialog(this, "请输入完整的信息~");
                } else {
                    //添加到联系人集合中并更新表格
                    contacts.add(contact);
                    updateTable();
                }
            }
        } else if (source == deleteButton) {
            // 弹出确认删除联系人窗口
            int row = table.getSelectedRow();
            if (row >= 0) {
                //弹出一个确定删除联系人窗口
                int result = JOptionPane.showConfirmDialog(this, "你确定要删除该联系人吗?");
                if (result == JOptionPane.YES_OPTION) {
                    contacts.remove(row);
                    updateTable();//更新表格信息
                }
            } else {
                //没有选择的情况
                JOptionPane.showMessageDialog(this, "请选择你要删除的联系人~");
            }
        } else if (source == searchButton) {
            // 弹出选择查找方式窗口
            String[] options = {"姓名", "电话", "地址", "生日","邮箱"};
            String option = (String) JOptionPane.showInputDialog(this, "Search by:", "搜索联系人",
                    JOptionPane.PLAIN_MESSAGE, null, options, "姓名");
            if (option != null) {
                String keyword = JOptionPane.showInputDialog(this, "请输入你要查找的信息:");
                if (keyword != null) {
                    ArrayList<Contact> result = new ArrayList<>();
                    //循环查找
                    for (Contact contact : contacts) {
                        if (option.equals("姓名") && contact.getName().contains(keyword)) {
                            result.add(contact);
                        } else if (option.equals("电话") && contact.getPhone().contains(keyword)) {
                            result.add(contact);
                        } else if (option.equals("地址") && contact.getAddress().contains(keyword)) {
                            result.add(contact);
                        } else if (option.equals("生日") && contact.getBirthday().contains(keyword)) {
                            result.add(contact);
                        } else if (option.equals("邮箱") && contact.getEmail().contains(keyword)) {
                            result.add(contact);
                        }
                    }

                    //如果是空则找不到
                    if (result.isEmpty()) {
                        JOptionPane.showMessageDialog(this, "没有此联系人~");
                    } else {
                        //显示所有找到的信息
                        showSearchResult(result);
                    }
                }
            }
        } else if (source == modifyButton) {
            // 弹出修改联系人窗口
            int row = table.getSelectedRow();//选中某行
            if (row >= 0) {
                Contact contact = contacts.get(row);//得到当前行
                //把当前行选中的信息放在一个弹窗中进行修改
                ModifyContactDialog dialog = new ModifyContactDialog(this, contact);
                dialog.setVisible(true);//可视化
                //修改
                Contact modifiedContact = dialog.getContact();
                if (modifiedContact != null) {
                    //修改选择的信息
                    contacts.set(row, modifiedContact);
                    updateTable();//更新表格
                }
            } else {
                JOptionPane.showMessageDialog(this, "请选择你要修改的信息~");
            }
        } else if (source == sortButton) {
            // 弹出选择排序方式窗口
            String[] options = {"姓名", "住址", "生日"};
            String option = (String) JOptionPane.showInputDialog(this, "Sort by:", "联系人排序",
                    JOptionPane.PLAIN_MESSAGE, null, options, "名字");
            if (option != null) {
                if (option.equals("姓名")) {
                    Collections.sort(contacts, new Comparator<Contact>() {
                        @Override
                        public int compare(Contact c1, Contact c2) {
                            return c1.getName().compareTo(c2.getName());
                        }
                    });
                } else if (option.equals("住址")) {
                    Collections.sort(contacts, new Comparator<Contact>() {
                        @Override
                        public int compare(Contact c1, Contact c2) {
                            return c1.getAddress().compareTo(c2.getAddress());
                        }
                    });
                } else if (option.equals("生日")) {
                    Collections.sort(contacts, new Comparator<Contact>() {
                        @Override
                        public int compare(Contact c1, Contact c2) {
                            return c1.getBirthday().compareTo(c2.getBirthday());
                        }
                    });
                }
                //更新表格
                updateTable();
            }
        } else if (source == groupButton) {
            // 弹出选择分组方式窗口
            String[] options = {"地址"};
            String option = (String) JOptionPane.showInputDialog(this, "Group by:", "联系人分组",
                    JOptionPane.PLAIN_MESSAGE, null, options, "地址");
            if (option != null) {
                ArrayList<ArrayList<Contact>> groups = new ArrayList<>();
                if (option.equals("地址")) {
                    // 按照地址分组
                    ArrayList<Contact> group1 = new ArrayList<>();
                    ArrayList<Contact> group2 = new ArrayList<>();
                    ArrayList<Contact> group3 = new ArrayList<>();
                    for (Contact contact : contacts) {
                        String address = contact.getAddress();
                        if (address.startsWith("北京")) {
                            group1.add(contact);
                        } else if (address.startsWith("上海")) {
                            group2.add(contact);
                        } else {
                            group3.add(contact);
                        }
                    }
                    if (!group1.isEmpty()) {
                        groups.add(group1);
                    }
                    if (!group2.isEmpty()) {
                        groups.add(group2);
                    }
                    if (!group3.isEmpty()) {
                        groups.add(group3);
                    }
                }
                if (groups.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "没有联系人可分组~");
                } else {
                    showGroupResult(groups, option);
                }
            }
        } else if (source == topButton) {
            // 获取选中的联系人
            int row = table.getSelectedRow();//选中某行
            if (row >= 0) {
                Contact contact = contacts.get(row);//得到当前行
                contacts.remove(row);
                contacts.add(0, contact);
                updateTable();//更新表格
            } else {
                JOptionPane.showMessageDialog(this, "请先选择一个联系人~", "错误", JOptionPane.ERROR_MESSAGE);
            }
        }
    }


    /**
     * 展示分组后的信息
     * @param groups
     * @param option
     */
    private void showGroupResult(ArrayList<ArrayList<Contact>> groups, String option) {
        JFrame frame = new JFrame("分组结果");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setBounds(500, 400,300,200);

        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);

        //分组的信息添加到文本域中
        for (ArrayList<Contact> group : groups) {
            String groupKey = group.get(0).getGroupKey(option);
            textArea.append(groupKey + ":\n");
            for (Contact contact : group) {
                textArea.append("  " + contact.getName() + " (" + contact.getPhone() + ", " + contact.getAddress() + contact.getEmail() +")\n");
            }
            textArea.append("\n");
        }

        //设置文本域
        JScrollPane scrollPane = new JScrollPane(textArea);
        //添加到主框架中
        frame.add(scrollPane);
        frame.setVisible(true);//可视化
    }

    /**
     * 更新表格
     */
    private void updateTable() {
        //更新表格中的信息
        Object[][] data = new Object[contacts.size()][5];
        for (int i = 0; i < contacts.size(); i++) {
            Contact contact = contacts.get(i);
            data[i][0] = contact.getName();
            data[i][1] = contact.getPhone();
            data[i][2] = contact.getAddress();
            data[i][3] = contact.getBirthday();
            data[i][4] = contact.getEmail();
        }
        //表格模型
        table.setModel(new javax.swing.table.DefaultTableModel(data, new String[]{"姓名", "电话", "地址", "生日", "邮箱"}));
    }

    /**
     * 展示搜索到的信息
     *
     * @param result
     */
    private void showSearchResult(ArrayList<Contact> result) {
        Object[][] data = new Object[result.size()][5];
        for (int i = 0; i < result.size(); i++) {
            Contact contact = result.get(i);
            data[i][0] = contact.getName();
            data[i][1] = contact.getPhone();
            data[i][2] = contact.getAddress();
            data[i][3] = contact.getBirthday();
            data[i][4] = contact.getEmail();
        }
        JTable searchTable = new JTable(data, new String[]{"姓名", "电话", "地址", "生日","邮箱"});
        JOptionPane.showMessageDialog(this, new JScrollPane(searchTable), "搜索结果", JOptionPane.PLAIN_MESSAGE);
    }
}