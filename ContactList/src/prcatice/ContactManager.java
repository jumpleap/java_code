package prcatice;

import java.util.*;


@SuppressWarnings({"all"})
public class ContactManager{

    Scanner scanner = new Scanner(System.in);
    //建立集合类型
    ArrayList<Contact> arrayList = new ArrayList<>();
    //重要联系人
    ArrayList<Contact> importantContact = new ArrayList<>();

    /**
     * 主菜单功能
     */
    public void functionMenu() {
        int choice = 0;
        //初始化通讯录
        initContact();

        do {
            menu();//显示可用功能菜单
            System.out.print("请输入你的选择:");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    //显示所有联系人信息
                    showContact();
                    break;
                case 2:
                    //添加联系人信息
                    addContact();
                    break;
                case 3:
                    //删除联系人信息
                    deleteContact();
                    break;
                case 4:
                    //修改联系人信息
                    modifyContact();
                    break;
                case 5:
                    //查找联系人信息
                    searchMenu();
                    break;
                case 6:
                    //排序联系人信息
                    sortMenu();
                    break;
                case 7:
                    //重要联系人信息
                    importantPeople();
                    //输出重要联系人列表
                    System.out.println("重要联系人信息如下：");
                    for (Contact contact : importantContact) {
                        System.out.println(contact);
                    }
                    break;
                case 8:
                    //给联系人发信息
                    sendMessageContact();
                    break;
                case 0:
                    System.out.println("退出通讯录~");
                    scanner.close();//关闭输入资源
                    break;
                default:
                    System.out.println("你输入的选择有误，请重新选择~");
            }
        } while (choice != 0);
    }

    /**
     * 初始化通讯录
     */
    public void initContact() {
        arrayList.add(new Contact("小王", "12", "123456", "北京", "8月12日", "9613.qq.com"));
        arrayList.add(new Contact("小明", "18", "367545", "上海", "6月13日", "7896686.qq.com"));
    }


    /**
     * 功能选择菜单
     */
    public void menu() {
        System.out.println("************************************");
        System.out.println("*********  1.显示联系人信息   *********");
        System.out.println("*********  2.添加联系人信息   *********");
        System.out.println("*********  3.删除联系人信息   *********");
        System.out.println("*********  4.修改联系人信息   *********");
        System.out.println("*********  5.查找联系人信息   *********");
        System.out.println("*********  6.排序联系人信息   *********");
        System.out.println("*********  7.重要联系人信息   *********");
        System.out.println("*********  8.给联系人发信息   *********");
        System.out.println("*********   0.退出通讯录     *********");
        System.out.println("************************************");
    }

    /**
     * 添加联系人
     */
    public boolean addContact() {
        System.out.println("请输入联系人姓名：");
        String name = scanner.next();

        System.out.println("请输入联系人年龄：");
        String age = scanner.nextLine();

        System.out.println("请输入联系人电话：");
        String tele = scanner.next();

        System.out.println("请输入联系人地址：");
        String address = scanner.next();

        System.out.println("请输入联系人生日：");
        String birthday = scanner.next();

        System.out.println("请输入联系人邮箱：");
        String email = scanner.next();

        //使用contact类接收这些信息
        Contact contact = new Contact(name, age, tele, address, birthday, email);
        arrayList.add(contact);//添加到集合中
        System.out.println("添加成功");
        return true;
    }

    /**
     * 删除联系人
     */
    public boolean deleteContact() {
        System.out.println("请输入你想要删除的联系人姓名：");
        String name = scanner.next();
        int index = searchName(name);
        if (index == -1) {
            System.out.println("没有此联系人~");
            return false;
        }
        arrayList.remove(index);
        System.out.println("删除成功~");
        return true;
    }

    public int searchName(String name) {
        //获取到和name名字相同的下标
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i).getName().equals(name)) {
                return i;
            }
        }
        return -1;//没有该下标
    }

    /**
     * 修改联系人
     */
    public boolean modifyContact() {
        System.out.println("请输入你要修改的联系人姓名：");
        String name = scanner.next();

        int index = searchName(name);
        if (index == -1) {
            System.out.println("没有此联系人~");
            return false;
        }
        System.out.println("请输入你想修改的姓名：");
        String modifyName = scanner.nextLine();
        arrayList.get(index).setName(modifyName);

        System.out.println("请输入你想修改的年龄：");
        String modifyAge = scanner.nextLine();
        arrayList.get(index).setAge(modifyAge);

        System.out.println("请输入你想修改的电话：");
        String modifyTele = scanner.nextLine();
        arrayList.get(index).setTele(modifyTele);

        System.out.println("请输入你想修改的地址：");
        String modifyAddress = scanner.nextLine();
        arrayList.get(index).setAddress(modifyAddress);

        System.out.println("请输入你想修改的生日：");
        String modifyBirthday = scanner.nextLine();
        arrayList.get(index).setBirthday(modifyBirthday);

        System.out.println("请输入你想修改的邮箱：");
        String modifyEmail = scanner.nextLine();
        arrayList.get(index).setEmail(modifyEmail);
        return true;
    }

    /**
     * 查找联系人：名字查找、年龄查找、住址查找、生日查找
     */
    public void searchMenu() {
        int opt = 0;
        do {
            System.out.println("*******************************");
            System.out.println("******     1.按名字查找    ******");
            System.out.println("******     2.按年龄查找    ******");
            System.out.println("******     3.按住址查找    ******");
            System.out.println("******     4.按生日查找    ******");
            System.out.println("******     0.退出查找     ******");
            System.out.println("*******************************");

            System.out.println("请输入你想要按照那种规则进行查找：");
            opt = scanner.nextInt();
            int index = -1;//下标
            int flag = 0;//标记类型

            switch (opt) {
                case 1:
                    //按名字查找
                    System.out.println("请输入要查找的名字：");
                    String name = scanner.next();
                    flag = 1;
                    index = search(name, flag);
                    break;
                case 2:
                    //按年龄查找
                    System.out.println("请输入要查找的年龄：");
                    int age = scanner.nextInt();
                    index = search(age);
                    break;
                case 3:
                    //按住址查找
                    System.out.println("请输入要查找的住址：");
                    String address = scanner.next();
                    flag = 2;
                    index = search(address, flag);
                    break;
                case 4:
                    //按生日查找
                    System.out.println("请输入要查找的生日：");
                    String birthday = scanner.next();
                    flag = 3;
                    index = search(birthday, flag);
                    break;
                case 0:
                    System.out.println("退出查找~");
                    return;
                default:
                    ;
            }

            //判断查找是否成功
            if (index == -1) {
                System.out.println("无此人信息,请重新查找~");
            } else {
                System.out.println(arrayList.get(index));
            }

        } while (opt != 0);
    }

    /**
     * 按名字、住址、生日查找
     */
    public int search(String thing, int flag) {
        if (flag == 1) {//flag为1则按名字查找
            for (int i = 0; i < arrayList.size(); i++) {
                if (arrayList.get(i).getName().equals(thing)) {
                    return i;//找到了
                }
            }
            return -1;//没有找到
        } else if (flag == 2) {//flag为2则按住址查找
            for (int i = 0; i < arrayList.size(); i++) {
                if (arrayList.get(i).getAddress().equals(thing)) {
                    return i;//找到了
                }
            }
            return -1;//没有找到
        } else {//flag为其他则按生日查找
            for (int i = 0; i < arrayList.size(); i++) {
                if (arrayList.get(i).getBirthday().equals(thing)) {
                    return i;//找到了
                }
            }
            return -1;//没有找到
        }
    }


    /**
     * 按年龄查找
     */
    public int search(int age) {
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i).getAge().equals(age)) {
                return i;
            }
        }
        return -1;
    }


    /**
     * 联系人排序：名字排序、年龄排序、住址排序
     */
    public void sortMenu() {
        int opt = 0;
        do {
            System.out.println("*******************************");
            System.out.println("******     1.按名字排序    ******");
            System.out.println("******     2.按年龄排序    ******");
            System.out.println("******     3.按住址排序    ******");
            System.out.println("******     0.退出查找     ******");
            System.out.println("*******************************");

            System.out.println("请输入你想要按照那种规则进行排序：");
            opt = scanner.nextInt();
            int index = -1;//下标
            int flag = 0;//标记类型

            switch (opt) {
                case 1:
                    //按名字排序
                    Collections.sort(arrayList, new Comparator<Contact>() {
                        @Override
                        public int compare(Contact o1, Contact o2) {
                            return o1.getName().compareTo(o2.getName());
                            //o1:abcd
                            //o2:bcdf
                        }
                    });
                    break;
                case 2:
                    //按年龄排序
                    Collections.sort(arrayList, new Comparator<Contact>() {
                        @Override
                        public int compare(Contact o1, Contact o2) {
                            return o1.getAge().compareTo(o2.getAge());
                        }
                    });
                    break;
                case 3:
                    //按住址排序
                    Collections.sort(arrayList, new Comparator<Contact>() {
                        @Override
                        public int compare(Contact o1, Contact o2) {
                            return o1.getAddress().compareTo(o2.getAddress());
                        }
                    });
                    break;
                case 0:
                    System.out.println("退出排序~");
                    return;
                default:
                    ;
            }
            System.out.println("排序成功~");
            showContact();//打印排序后的内容
        } while (opt != 0);
    }

    /**
     * 重要联系人设置（置顶）
     */
    public boolean importantPeople() {
        System.out.println("请输入你想要设置的重要联系人姓名：");
        String name = scanner.next();

        int index = searchName(name);
        if (index == -1) {
            System.out.println("无此人信息~请你检查后再添加哦~");
            return false;
        }
        //添加重要联系人
        importantContact.add(arrayList.get(index));
        System.out.println("添加成功~");
        return true;
    }

    /**
     * 给联系人发送信息
     */
    public boolean sendMessageContact() {
        System.out.println("请你输入你发送信息的联系人姓名：");
        String name = scanner.next();
        int index = searchName(name);

        if (index == -1) {
            System.out.println("无此联系人~");
            return false;
        }
        System.out.println("请输入你要发送的信息：");
        String messsage = scanner.next();
        System.out.println("发送成功~");
        return true;
    }

    /**
     * 显示所有联系人信息
     */
    public void showContact() {
        System.out.println("通讯录中的信息如下：");
        System.out.printf("%-10s %-10d %-10s %-10s %-10s %-10s\n", "姓名", "年龄", "电话", "地址", "生日", "邮箱");
        for (Contact contact : arrayList) {
            System.out.printf("%-10s %-10d %-10s %-10s %-10s %-10s\n", contact.getName(), contact.getAge(), contact.getTele(),
                    contact.getAddress(), contact.getBirthday(), contact.getEmail());
        }
    }
}