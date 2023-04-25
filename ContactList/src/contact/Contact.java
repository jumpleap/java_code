package contact;

public class Contact {
    //成员变量
    private String name;//姓名
    private String age;//年龄
    private String phone;//电话
    private String address;//地址
    private String birthday;//生日
    private String email;//邮箱

    //有参构造器
    public Contact(String name, String age, String phone, String address, String birthday, String email) {
        this.name = name;
        this.age = age;
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

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
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
}

