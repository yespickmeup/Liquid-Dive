/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.test;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Guinness
 */
public class Group {

    public static void main(String[] args) {
        Map<String, Integer> myMap = new HashMap<String, Integer>();

        String[] products = {"Apple", "Pear", "Banana", "Apple", "Banana"};
        for (int i = 0; i < products.length; i++) {
            String product = products[i];

            if (myMap.containsKey(product)) {
                myMap.put(product, 0);
            } else {
                myMap.put(product, 0);
            }
        }
        for (String product : myMap.keySet()) {
            System.out.println(product + ": " + myMap.get(product));
        }
    }
}
