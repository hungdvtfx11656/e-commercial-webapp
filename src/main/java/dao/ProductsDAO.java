package dao;

import context.DBContext;
import model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductsDAO {

    Connection conn;
    Statement stmt;
    PreparedStatement pstmt;
    private int noOfRecords;

    private static Connection getConnection() throws SQLException, ClassNotFoundException {
        return DBContext.getInstance().getConnection();
    }

    public int getNoOfRecords() {
        return noOfRecords;
    }

    /**
     * Select products from "Product" table for pagination
     * @param offset maximum number of records to select
     * @param noOfRecords offset from first record on table
     * @param keywords by product name
     * @return
     */
    public List<Product> search(int noOfRecords, int offset, String keywords) {
        String query = "select count(*) over () as row_count, * from Products\n" +
                "where product_name like ? order by product_id\n" +
                "offset " + noOfRecords + " rows fetch next " + offset + " rows only";
        List<Product> lp = new ArrayList<>();
        try {
            conn = getConnection();
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, "%" + keywords + "%");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                this.noOfRecords = rs.getInt(1);
                Product temp = new Product(
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getFloat(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8)
                );
                lp.add(temp);
            }
            rs.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return lp;
    }

    public Product getProduct(String id) {
        Product product = new Product();
        String query = "select top 1 * from Products where product_id = ?";
        try {
            conn = DBContext.getInstance().getConnection();
            pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, Integer.parseInt(id));
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                product.setId(rs.getInt(1));
                product.setName(rs.getString(2));
                product.setDescription(rs.getString(3));
                product.setPrice(rs.getFloat(4));
                product.setSrc(rs.getString(5));
                product.setType(rs.getString(6));
                product.setBrand(rs.getString(7));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return product;
    }

}
