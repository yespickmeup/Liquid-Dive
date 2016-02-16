/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import POS.utl.DateType;
import java.text.ParseException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author u2
 */
public class aw {

    public static void main2(String[] args) {

//        Thread t = new Thread(new Runnable() {
//
//            @Override
//            public void run() {
//
//                while (true) {
//                    Sleeper.sleep(5000);
//                    System.out.println("hello");
//                }
//            }
//        });
//
//        t.start();
//        
//        t = new Thread(new Runnable() {
//
//            @Override
//            public void run() {
//
//                while (true) {
//                    Sleeper.sleep(2000);
//                    System.out.println("hello2");
//                }
//            }
//        });
//
//        t.start();
//        
//        System.out.println("start");
    }
    public static void main(String[] args) {
        Date d=new Date();
        try {
            d=DateType.datetime.parse("2013-04-15 03:31:45");
        } catch (ParseException ex) {
            Logger.getLogger(aw.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
        String date=(DateType.datetime2.format(new Date()));
         System.out.println(date);
    }
}
