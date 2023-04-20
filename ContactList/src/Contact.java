@SuppressWarnings({"all"})
public class Contact {
    //成员变量
    private String name;//姓名
    private int age;//年龄
    private String tele;//电话
    private String address;//地址
    private String birthday;//生日
    private String email;//邮箱

    //无参构造器
    public Contact() {
    }

    //有参构造器
    public Contact(String name, int age, String tele, String address, String birthday, String email) {
        this.name = name;
        this.age = age;
        this.tele = tele;
        this.address = address;
        this.birthday = birthday;
        this.email = email;
    }

    //setter和getter方法

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getTele() {
        return tele;
    }

    public void setTele(String tele) {
        this.tele = tele;
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

    //重写toString方法
    public String toString() {
        return this.name + "\t\t" + this.age + "\t\t" + this.tele
                + "\t\t\t\t" + this.address + "\t\t\t\t" + this.birthday + "\t\t" + this.email;
    }
}