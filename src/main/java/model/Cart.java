package model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Cart {

    private List<Product> items;

    public Cart() {
        items = new ArrayList<>();
    }

    public void add(Product ci) {
        for (Product product : items) {
            if (ci.getId() == product.getId()) {
                product.setNumber(product.getNumber() + 1);
                return;
            }
        }
        items.add(ci);
    }

    public void remove(int id) {
        for (int i = 0; i < items.size(); i++) {
            Product p = items.get(i);
            if (p.getId() == id) items.remove(p);
        }
//        for (Product product : items) {
//            if (product.getId() == id) {
//                items.remove(product);
//            }
//        }
    }

    public double getAmount() {
        double s = 0;
        for (Product product : items) {
            s += product.getPrice() * product.getNumber();
        }
        return s;
    }

    public List<Product> getItems() {
        return items;
    }

}
