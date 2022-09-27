package dao;

import context.DBContext;
import model.Account;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AccountDAO {

    /**
     * Insert information of an account(a) into "Account" table
     * @param a account with information to insert
     * @throws Exception
     */
    public void insert(Account a) throws Exception {
        String sql = "insert into Account values(?, ?, ?, ?, ?, ?)";
        try (
                Connection conn = DBContext.getInstance().getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql);
        ) {
            pstmt.setString(1, a.getUsr());
            pstmt.setString(2, a.getPwd());
            pstmt.setInt(3, a.getRole());
            pstmt.setString(4, a.getName());
            pstmt.setString(5, a.getAddress());
            pstmt.setString(6, a.getPhone());
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Query and return distinct account from "Account" table by usr and pwd
     * @param usr user email
     * @param pwd user password
     * @return distinct account
     * @throws Exception
     */
    public Account getAccount(String usr, String pwd) throws Exception {
        Account a = new Account();
        String sql = "select top 1 * from Account where user_mail = ? and password = ?";
        try (
                Connection conn = DBContext.getInstance().getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql);
                ) {
            pstmt.setString(1, usr);
            pstmt.setString(2, pwd);
            ResultSet rs = pstmt.executeQuery();
            if (!rs.next()) return null;
            toAccount(rs, a);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return a;
    }

    /**
     * Query and check if usr is exist in "Account" table
     * @param usr user email
     * @return
     * @throws Exception
     */
    public boolean checkUsr(String usr) throws Exception {
        String sql = "select top 1 * from Account where user_mail = ?";
        try (
                Connection conn = DBContext.getInstance().getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql);
        ) {
            pstmt.setString(1, usr);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * Get list information of accounts in "Account" table
     * @return list of Account instances
     * @throws Exception
     */
    public List<Account> getList() throws Exception {
        String sql = "select * from Account";
        List<Account> ls = new ArrayList<>();
        try (
                Connection conn = DBContext.getInstance().getConnection();
                Statement stmt = conn.createStatement();
        ) {
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Account a = new Account();
                toAccount(rs, a);
                ls.add(a);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ls;
    }

    private void toAccount(ResultSet rs, Account a) throws SQLException {
        a.setUsr(rs.getString(1));
        a.setPwd(rs.getString(2));
        a.setRole(rs.getInt(3));
        a.setName(rs.getString(4));
        a.setAddress(rs.getString(5));
        a.setPhone(rs.getString(6));
        a.setCheck(0);
    }

}
