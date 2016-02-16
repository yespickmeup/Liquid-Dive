/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.sales;

import POS.Main.MyDB;
import POS.utl.MyConnection1;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import mijzcx.synapse.desk.utils.Lg;

/**
 *
 * @author Maytopacka
 */
public class S1_edit_sales {

    public static class to_edit_sales {

        public final double amount_paid;
        public final double usd;
        public final double peso_on_bank;
        public final double usd_on_bank;

        public to_edit_sales(double amount_paid, double usd, double peso_on_bank, double usd_on_bank) {
            this.amount_paid = amount_paid;
            this.usd = usd;
            this.peso_on_bank = peso_on_bank;
            this.usd_on_bank = usd_on_bank;
        }
    }

    public static to_edit_sales ret_data(String room_guest_id) {
        to_edit_sales to1 = new to_edit_sales(0, 0, 0, 0);
        try {
            Connection conn = MyConnection1.connect();
            String s0 = "select "
                    + "amount_paid"
                    + ",usd"
                    + ",peso_on_bank"
                    + ",usd_on_bank"
                    + " from " + MyDB.getNames() + ".guest_advance_payment where "
                    + " room_guest_id ='" + room_guest_id + "' "
                    + " ";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            if (rs.next()) {
                double amount_paid = rs.getDouble(1);
                double usd = rs.getDouble(2);
                double peso_on_bank = rs.getDouble(3);
                double usd_on_bank = rs.getDouble(4);
//                JOptionPane.showMessageDialog(null, usd + " " + room_guest_id);
                to1 = new to_edit_sales(amount_paid, usd, peso_on_bank, usd_on_bank);
            }
            return to1;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection1.close();
        }
    }

    public static void edit_receipts(Dlg_edit_sales.to_edit_sales to_receipts, String room_guest_ids) {
        try {
            Connection conn = MyConnection1.connect();
            String s0 = "update " + MyDB.getNames() + ".receipts set "
                    + "credit= '" + to_receipts.credit + "'"
                    + ",dollar= '" + to_receipts.dollar + "'"
                    + ",peso= '" + to_receipts.peso + "'"
                    + "where "
                    + " room_guest_ids ='" + room_guest_ids + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_edit_sales.class, "Successfully Updated");

            String s2 = "update " + MyDB.getNames() + ".guest_advance_payment set "
                    + "amount_paid= '" + to_receipts.ap_peso_cash + "'"
                    + ",usd= '" + to_receipts.ap_dollar_cash + "'"
                    + ",peso_on_bank= '" + to_receipts.ap_peso_bank + "'"
                    + ",usd_on_bank= '" + to_receipts.ap_peso_bank + "'"
                    + "where "
                    + " room_guest_id ='" + room_guest_ids + "' "
                    + " ";

            PreparedStatement stmt2 = conn.prepareStatement(s2);
            stmt2.execute();
            Lg.s(S1_edit_sales.class, "Successfully Updated");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection1.close();
        }
    }
}
