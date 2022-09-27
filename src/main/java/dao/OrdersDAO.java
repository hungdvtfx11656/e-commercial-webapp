package dao;

import context.DBContext;
import model.Cart;
import model.Product;

import java.sql.*;
import java.util.List;

public class OrdersDAO {

    /**
     * Insert information of an order(o) into "Orders" table, including list of products
     * in cart(c) and customer information in order(o)
     * @param mail
     * @param address
     * @param discount
     * @param c
     * @throws Exception
     */
    public void insertOrder(String mail, String address, String discount, Cart c) throws Exception {
        String Orders = "insert into Orders(user_mail, order_address, order_discount_code) values (?, ?, ?)";
        String Orders_detail = "insert into Orders_detail values(?, ?, ?, ?)";
        try (
                Connection conn = DBContext.getInstance().getConnection();
                PreparedStatement pstmt_Orders = conn.prepareStatement(Orders, Statement.RETURN_GENERATED_KEYS);
                PreparedStatement pstmt_Orders_detail = conn.prepareStatement(Orders_detail);
                Statement stmt = conn.createStatement();
                ) {
            /*
            Insert into table Orders
             */
            pstmt_Orders.setString(1, mail);
            pstmt_Orders.setString(2, address);
            pstmt_Orders.setString(3, discount);
            /*
            Get order_id
             */
            int affectedRows = pstmt_Orders.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Insert into Orders failed, no row affected.");
            }
            try (ResultSet generatedKeys = pstmt_Orders.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    /*
                    Insert into table Orders_detail
                     */
                    List<Product> lp = c.getItems();
                    for (Product p : lp) {
                        pstmt_Orders_detail.setInt(1, (int) generatedKeys.getLong(1));
                        pstmt_Orders_detail.setInt(2, p.getId());
                        pstmt_Orders_detail.setInt(3, p.getNumber());
                        pstmt_Orders_detail.setFloat(4, p.getPrice());
                        pstmt_Orders_detail.executeUpdate();
                    }
                }
                else {
                    throw new SQLException("Insert into Orders failed, no ID obtained.");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
