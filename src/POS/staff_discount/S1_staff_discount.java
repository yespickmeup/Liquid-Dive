/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.staff_discount;

import POS.Main.MyDB;
import POS.utl.MyConnection1;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import mijzcx.synapse.desk.utils.Lg;

/**
 *
 * @author Maytopacka
 */
public class S1_staff_discount {

    public static class to_staff_discounts {

        public final int id;
        public final double rate;

        public to_staff_discounts(int id, double rate) {
            this.id = id;
            this.rate = rate;
        }
    }

    public static void edit_data(double disc) {
        try {
            Connection conn = MyConnection1.connect();
            String s0 = "update " + MyDB.getNames() + ".staff_discounts set "
                    + "rate= '" + disc + "'"
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_staff_discount.class, "Successfully Updated discount");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection1.close();
        }
    }

    public static double ret_data() {
        double discount = 0;
        try {
            Connection conn = MyConnection1.connect();
            String s0 = "select "
                    + "rate"
                    + " from " + MyDB.getNames() + ".staff_discounts  "
                    + " ";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            if (rs.next()) {
                discount = rs.getDouble(1);
            }
            
            return discount;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection1.close();
        }
    }
}
