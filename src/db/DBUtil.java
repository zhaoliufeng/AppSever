package db;

import java.sql.*;

public class DBUtil {
    public static Connection getDataBaseConnection(){
        String driver="com.mysql.jdbc.Driver";
        String url="jdbc:mysql://120.79.138.74:3306/aliyun_sql";
        String user="root";
        String password="233333";

        //加载驱动程序
        try {
            Class.forName(driver);
            //System.out.println("驱动程序加载成功");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        //链接数据库
        Connection conn=null;
        try {
            conn=DriverManager.getConnection(url, user, password);
            if (!conn.isClosed()) {
                System.out.println("连接数据库成功");
            }
        } catch (SQLException e) {
            System.out.println("链接数据库失败: "+e.getMessage());
        }

        return conn;
    }
}
