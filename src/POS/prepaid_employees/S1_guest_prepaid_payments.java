/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.prepaid_employees;

import POS.Main.MyDB;
import POS.utl.MyConnection1;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import mijzcx.synapse.desk.utils.Lg;
import mijzcx.synapse.desk.utils.SqlStringUtil;

/**
 *
 * @author Maytopacka
 */
public class S1_guest_prepaid_payments {

    public static class to_guest_prepaid_payments {

        public final int id;
        public final String guest_id;
        public final String guest_name;
        public final double paid;
        public final String date_added;
        public final String user_name;

        public to_guest_prepaid_payments(int id, String guest_id, String guest_name, double paid, String date_added, String user_name) {
            this.id = id;
            this.guest_id = guest_id;
            this.guest_name = guest_name;
            this.paid = paid;
            this.date_added = date_added;
            this.user_name = user_name;
        }
    }

    public static void add_guest_prepaid_payments(to_guest_prepaid_payments to_guest_prepaid_payments) {
        try {
            Connection conn = MyConnection1.connect();
            String s0 = "insert into " + MyDB.getNames() + ".guest_prepaid_payments("
                    + "guest_id"
                    + ",guest_name"
                    + ",paid"
                    + ",date_added"
                    + ",user_name"
                    + ")values("
                    + ":guest_id"
                    + ",:guest_name"
                    + ",:paid"
                    + ",:date_added"
                    + ",:user_name"
                    + ")";

            s0 = SqlStringUtil.parse(s0).
                    setString("guest_id", to_guest_prepaid_payments.guest_id).
                    setString("guest_name", to_guest_prepaid_payments.guest_name).
                    setNumber("paid", to_guest_prepaid_payments.paid).
                    setString("date_added", to_guest_prepaid_payments.date_added).
                    setString("user_name", to_guest_prepaid_payments.user_name).
                    ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_guest_prepaid_payments.class, "Successfully Added");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection1.close();
        }
    }

    public static void edit_guest_prepaid_payments(to_guest_prepaid_payments to_guest_prepaid_payments) {
        try {
            Connection conn = MyConnection1.connect();
            String s0 = "update " + MyDB.getNames() + ".guest_prepaid_payments set "
                    + "guest_id= '" + to_guest_prepaid_payments.guest_id + "'"
                    + ",guest_name= '" + to_guest_prepaid_payments.guest_name + "'"
                    + ",paid= '" + to_guest_prepaid_payments.paid + "'"
//                    + ",date_added= '" + to_guest_prepaid_payments.date_added + "'"
//                    + ",user_name= '" + to_guest_prepaid_payments.user_name + "'"
                    + "where "
                    + " id ='" + to_guest_prepaid_payments.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_guest_prepaid_payments.class, "Successfully Updated");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection1.close();
        }
    }

    public static void delete_guest_prepaid_payments(to_guest_prepaid_payments to_guest_prepaid_payments) {
        try {
            Connection conn = MyConnection1.connect();
            String s0 = "delete from " + MyDB.getNames() + ".guest_prepaid_payments where "
                    + " id ='" + to_guest_prepaid_payments.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_guest_prepaid_payments.class, "Successfully Deleted");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection1.close();
        }
    }

    public static List<to_guest_prepaid_payments> ret_data(String guest_ids) {
        List<to_guest_prepaid_payments> datas = new ArrayList();

        try {
            Connection conn = MyConnection1.connect();
            String s0 = "select "
                    + "id"
                    + ",guest_id"
                    + ",guest_name"
                    + ",paid"
                    + ",date_added"
                    + ",user_name"
                    + " from " + MyDB.getNames() + ".guest_prepaid_payments where "
                    + " guest_id ='" + guest_ids + "' order by date_added desc"
                    + " ";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String guest_id = rs.getString(2);
                String guest_name = rs.getString(3);
                double paid = rs.getDouble(4);
                String date_added = rs.getString(5);
                String user_name = rs.getString(6);

                to_guest_prepaid_payments to = new to_guest_prepaid_payments(id, guest_id, guest_name, paid, date_added, user_name);
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
