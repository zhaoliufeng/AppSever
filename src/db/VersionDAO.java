package db;

import conts.SqlTable;

import java.sql.*;

public class VersionDAO {

    public static int getVersion() {
        int versionCode = 0;
        try {
            Connection conn = DBUtil.getDataBaseConnection();
            Statement statement = conn.createStatement();
            String sql = "select * from " + SqlTable.T_Version;
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                versionCode = rs.getInt("Version_code");
            }
            rs.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return versionCode;
    }

    //获取下载地址
    public static String getUpdateLink() {
        String link = "";
        try {
            Connection conn = DBUtil.getDataBaseConnection();
            Statement statement = conn.createStatement();
            String sql = "select * from " + SqlTable.T_Version;
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                link = rs.getString("Update_link");
            }
            rs.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return link;
    }

    public static boolean updateVersion(int vCode) {
        try {
            Connection conn = DBUtil.getDataBaseConnection();
            String sql = "UPDATE version SET Version_code = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, vCode);
            boolean rs = ps.execute();
            if (rs) {
                return true;
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean updateUpdateLink(String link) {
        try {
            Connection conn = DBUtil.getDataBaseConnection();
            String sql = "UPDATE version SET Update_link = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, link);
            boolean rs = ps.execute();
            if (rs) {
                return true;
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
