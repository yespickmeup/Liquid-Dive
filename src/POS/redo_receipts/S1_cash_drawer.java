/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.redo_receipts;

import POS.Main.MyDB;
import POS.utl.MyConnection1;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import mijzcx.synapse.desk.utils.Lg;

/**
 *
 * @author Maytopacka
 */
public class S1_cash_drawer {

    public static class to_cash_drawer {

        public final int id;
        public final int cashier_session_id;
        public final String user_name;
        public final String date_added;
        public final double cash_in;
        public final double cash_out;
        public final double addtl_cash;
        public final double credit;

        public to_cash_drawer(int id, int cashier_session_id, String user_name, String date_added, double cash_in, double cash_out, double addtl_cash, double credit) {
            this.id = id;
            this.cashier_session_id = cashier_session_id;
            this.user_name = user_name;
            this.date_added = date_added;
            this.cash_in = cash_in;
            this.cash_out = cash_out;
            this.addtl_cash = addtl_cash;
            this.credit = credit;
        }
    }

    public static void edit_cash_drawer(to_cash_drawer to_cash_drawer) {
        try {
            Connection conn = MyConnection1.connect();
            String s0 = "update " + MyDB.getNames() + ".cash_drawer set "
                    + "cashier_session_id= '" + to_cash_drawer.cashier_session_id + "'"
                    + ",user_name= '" + to_cash_drawer.user_name + "'"
                    + ",date_added= '" + to_cash_drawer.date_added + "'"
                    + ",cash_in= '" + to_cash_drawer.cash_in + "'"
                    + ",cash_out= '" + to_cash_drawer.cash_out + "'"
                    + ",addtl_cash= '" + to_cash_drawer.addtl_cash + "'"
                    + ",credit= '" + to_cash_drawer.credit + "'"
                    + "where "
                    + " id ='" + to_cash_drawer.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_cash_drawer.class, "Successfully Updated");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection1.close();
        }
    }

    public static List<to_cash_drawer> ret_data(String date_from, String date_to, String cashier_name) {
        List<to_cash_drawer> datas = new ArrayList();

        try {
            Connection conn = MyConnection1.connect();
            String s0 = "select "
                    + "id"
                    + ",cashier_session_id"
                    + ",user_name"
                    + ",date_added"
                    + ",cash_in"
                    + ",cash_out"
                    + ",addtl_cash"
                    + ",credit"
                    + " from " + MyDB.getNames() + ".cash_drawer "
                    + "where "
                    + " date(date_added) between '" + date_from + "' and '" + date_to + "' "
                    + " and user_name like'%" + cashier_name + "%' order by date_added desc"
                    + " ";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                int cashier_session_id = rs.getInt(2);
                String user_name = rs.getString(3);
                String date_added = rs.getString(4);
                double cash_in = rs.getDouble(5);
                double cash_out = rs.getDouble(6);
                double addtl_cash = rs.getDouble(7);
                double credit = rs.getDouble(8);

                to_cash_drawer to = new to_cash_drawer(id, cashier_session_id, user_name, date_added, cash_in, cash_out, addtl_cash, credit);
                datas.add(to);
            }
            return datas;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection1.close();
        }
    }
}
