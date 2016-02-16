/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Maytopacka
 */
public class List_group {

    public static class to_sam {

        public String name;
        public double price;

        public to_sam(String name, double price) {
            this.name = name;
            this.price = price;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }
    }

    public static void main(String[] args) {

        List<to_sam> datas = new ArrayList();
    }
}
