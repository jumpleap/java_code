package solution;

import java.util.*;
import java.sql.*;

public class Package {
    public static void main(String[] args) {
        //Date date = new Date();
        //错误，不知道Date是sql包下的Date类还是util包下的Date类
        //说明这个是java.util包下的Date类：全类名
        java.util.Date date = new java.util.Date();
    }
}
