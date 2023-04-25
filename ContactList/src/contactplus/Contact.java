package contactplus;

@SuppressWarnings({"all"})
public class Contact {
    //成员属性
    private String name;
    private String phone;
    private String address;
    private String birthday;
    private String email;
    private boolean isTop;//置顶

    //构造器
    public Contact(String name, String phone, String address, String birthday, String email) {
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.birthday = birthday;
        this.email = email;
    }

    //getter和setter方法
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    //分组的选择
    public String getGroupKey(String option) {
        if (option.equals("名字")) {
            return name.substring(0, 1).toUpperCase();
        } else if (option.equals("地址")) {
            if (address.startsWith("北京")) {
                return "北京";
            } else if (address.startsWith("上海")) {
                return "上海";
            } else {
                return "其他";
            }
        } else {
            return "";
        }
    }

    /**
     * 置顶设置
     * @return
     */
    public boolean isTop() {
        return isTop;
    }

    public void setTop(boolean isTop) {
        this.isTop = isTop;
    }
}