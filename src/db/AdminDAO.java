package db;

import bean.Admin;
import conts.SqlTable;

import java.sql.*;

public class AdminDAO {

    //获取用户帐号信息
    public static Admin getAdminInfo(String aName) {
        Admin admin = new Admin();
        try {
            Connection conn = DBUtil.getDataBaseConnection();
            String sql = "select * from "+ SqlTable.T_Admin + " where name = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
//            ps.setString(1, SqlTable.T_Admin);
            ps.setString(1, aName);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                admin.mName = rs.getString("name");
                admin.mPw = rs.getString("password");
            }
            rs.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return admin;
    }
}
