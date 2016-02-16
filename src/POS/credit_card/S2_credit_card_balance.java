/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.credit_card;

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
public class S2_credit_card_balance {

    public static class to_credit_card_balance {

        public final int id;
        public final double credit_card_payments;
        public final double actual_balance;

        public to_credit_card_balance(int id, double credit_card_payments, double actual_balance) {
            this.id = id;
            this.credit_card_payments = credit_card_payments;
            this.actual_balance = actual_balance;
        }
    }

    public static void edit_credit_card_payment(double amount) {
        try {
            Connection conn = MyConnection1.connect();
            String s0 = "update " + MyDB.getNames() + ".credit_card_balance set "
                    + "credit_card_payments= '" + amount + "'"
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S2_credit_card_balance.class, "Successfully Updated credit_payments");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection1.close();
        }
    }

    public static void edit_actual_balance(double amount) {
        try {
            Connection conn = MyConnection1.connect();
            String s0 = "update " + MyDB.getNames() + ".credit_card_balance set "
                    + "actual_balance= '" + amount + "'"
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S2_credit_card_balance.class, "Successfully Updated actual balance");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection1.close();
        }
    }

    public static to_credit_card_balance ret_data(String search) {
        to_credit_card_balance to1 = new to_credit_card_balance(-1, 0, 0);

        try {
            Connection conn = MyConnection1.connect();
            String s0 = "select "
                    + "id"
                    + ",credit_card_payments"
                    + ",actual_balance"
                    + " from " + MyDB.getNames() + ".credit_card_balance"
                    + " ";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            if (rs.next()) {
                int id = rs.getInt(1);
                double credit_card_payments = rs.getDouble(2);
                double actual_balance = rs.getDouble(3);

                to1 = new to_credit_card_balance(id, credit_card_payments, actual_balance);
            }
            return to1;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection1.close();
        }
    }
}
