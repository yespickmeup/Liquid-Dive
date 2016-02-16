/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.redo_receipts;

import POS.Main.MyDB;
import POS.utl.MyConnection1;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Maytopacka
 */
public class S1_users {

    public static List<String> ret_cb_data() {
        List<String> datas = new ArrayList();
        datas.add("All");
        try {
            Connection conn = MyConnection1.connect();
            String s0 = "select user_code from " + MyDB.getNames() + ".users where user_level<>'"+"1"+"' order by user_code asc";
            
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                String id = rs.getString(1);
                datas.add(id);
            }
            return datas;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection1.close();
        }
    }
    
     public static String ret_data(String user_code) {
        String user = "";

        try {
            Connection conn = MyConnection1.connect();
            String s0 = "select "
                        + "user_name"
                        + " from " + MyDB.getNames() + ".users where "
                        + " user_code ='" + user_code + "' "
                        + " ";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            if (rs.next()) {
                user = rs.getString(1);
            }
            return user;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection1.close();
        }
    }
}
