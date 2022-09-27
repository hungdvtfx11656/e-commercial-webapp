package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {

    private int orderId;
    private float price;
    private int status;
    private Date orderDate;
    private String address;
    private String phoneNumber;
    private List<ProductOrders> lp;
    private String userMail;
    private Date receivedDate;
    private String discount;

    public Order() {
        lp = new ArrayList<>();
    }

    public Order(int orderId, float price, int status, Date orderDate, String address, String phoneNumber, List<ProductOrders> lp, String userMail, Date receivedDate, String discount) {
        this.orderId = orderId;
        this.price = price;
        this.status = status;
        this.orderDate = orderDate;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.lp = lp;
        this.userMail = userMail;
        this.receivedDate = receivedDate;
        this.discount = discount;
    }

    public Order(int status, String address, String phoneNumber, String userMail, Date receivedDate, String discount) {
        this.status = status;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.userMail = userMail;
        this.receivedDate = receivedDate;
        this.discount = discount;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<ProductOrders> getLp() {
        return lp;
    }

    public void setLp(List<ProductOrders> lp) {
        this.lp = lp;
    }

    public String getUserMail() {
        return userMail;
    }

    public void setUserMail(String userMail) {
        this.userMail = userMail;
    }

    public Date getReceivedDate() {
        return receivedDate;
    }

    public void setReceivedDate(Date receivedDate) {
        this.receivedDate = receivedDate;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

}
