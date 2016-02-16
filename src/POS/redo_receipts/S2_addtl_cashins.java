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
import mijzcx.synapse.desk.utils.SqlStringUtil;

/**
 *
 * @author Maytopacka
 */
public class S2_addtl_cashins {

    public static class to_addt_cashins {

        public final int id;
        public final String date_added;
        public final String user_name;
        public final double amount;
        public final String purpose;
        public final int session_id;

        public to_addt_cashins(int id, String date_added, String user_name, double amount, String purpose, int session_id) {
            this.id = id;
            this.date_added = date_added;
            this.user_name = user_name;
            this.amount = amount;
            this.purpose = purpose;
            this.session_id = session_id;
        }
    }

    public static void add_addt_cashins(to_addt_cashins to_addt_cashins) {
        try {
            Connection conn = MyConnection1.connect();
            String s0 = "insert into " + MyDB.getNames() + ".addt_cashins("
                    + "date_added"
                    + ",user_name"
                    + ",amount"
                    + ",purpose"
                    + ",session_id"
                    + ")values("
                    + ":date_added"
                    + ",:user_name"
                    + ",:amount"
                    + ",:purpose"
                    + ",:session_id"
                    + ")";

            s0 = SqlStringUtil.parse(s0).
                    setString("date_added", to_addt_cashins.date_added).
                    setString("user_name", to_addt_cashins.user_name).
                    setNumber("amount", to_addt_cashins.amount).
                    setString("purpose", to_addt_cashins.purpose).
                    setNumber("session_id", to_addt_cashins.session_id).
                    ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S2_addtl_cashins.class, "Successfully Added");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection1.close();
        }
    }

    public static void edit_addt_cashins(to_addt_cashins to_addt_cashins) {
        try {
            Connection conn = MyConnection1.connect();
            String s0 = "update " + MyDB.getNames() + ".addt_cashins set "
                    + "date_added= '" + to_addt_cashins.date_added + "'"
                    + ",user_name= '" + to_addt_cashins.user_name + "'"
                    + ",amount= '" + to_addt_cashins.amount + "'"
                    + ",purpose= '" + to_addt_cashins.purpose + "'"
                    + ",session_id= '" + to_addt_cashins.session_id + "'"
                    + "where "
                    + " id ='" + to_addt_cashins.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S2_addtl_cashins.class, "Successfully Updated");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection1.close();
        }
    }

    public static void delete_addt_cashins(to_addt_cashins to_addt_cashins) {
        try {
            Connection conn = MyConnection1.connect();
            String s0 = "delete from " + MyDB.getNames() + ".addt_cashins where "
                    + " id ='" + to_addt_cashins.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S2_addtl_cashins.class, "Successfully Deleted");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection1.close();
        }
    }

    public static List<to_addt_cashins> ret_data(String date_from,String date_to,String user_names) {
        List<to_addt_cashins> datas = new ArrayList();

        try {
            Connection conn = MyConnection1.connect();
            String s0 = "select "
                    + "id"
                    + ",date_added"
                    + ",user_name"
                    + ",amount"
                    + ",purpose"
                    + ",session_id"
                    + " from " + MyDB.getNames() + ".addt_cashins where "
                    + " date(date_added) between '" + date_from + "' and '" + date_to + "' "
                    + " and user_name like'%" + user_names + "%' "
                    + " ";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String date_added = rs.getString(2);
                String user_name = rs.getString(3);
                double amount = rs.getDouble(4);
                String purpose = rs.getString(5);
                int session_id = rs.getInt(6);

                to_addt_cashins to = new to_addt_cashins(id, date_added, user_name, amount, purpose, session_id);
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
