/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.bank;

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
public class S1_bank {

    public static class to_bank {

        public final int id;
        public final String bank_name;

        public to_bank(int id, String bank_name) {
            this.id = id;
            this.bank_name = bank_name;
        }
    }

    public static void add_bank(to_bank to_bank) {
        try {
            Connection conn = MyConnection1.connect();
            String s0 = "insert into " + MyDB.getNames() + ".bank("
                    + "bank_name"
                    + ")values("
                    + ":bank_name"
                    + ")";

            s0 = SqlStringUtil.parse(s0).
                    setString("bank_name", to_bank.bank_name).
                    ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_bank.class, "Successfully Added");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection1.close();
        }
    }

    public static void edit_bank(to_bank to_bank) {
        try {
            Connection conn = MyConnection1.connect();
            String s0 = "update " + MyDB.getNames() + ".bank set "
                    + "bank_name= '" + to_bank.bank_name + "'"
                    + "where "
                    + " id ='" + to_bank.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_bank.class, "Successfully Updated");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection1.close();
        }
    }

    public static void delete_bank(to_bank to_bank) {
        try {
            Connection conn = MyConnection1.connect();
            String s0 = "delete from " + MyDB.getNames() + ".bank where "
                    + " id ='" + to_bank.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_bank.class, "Successfully Deleted");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection1.close();
        }
    }

    public static List<to_bank> ret_data(String search) {
        List<to_bank> datas = new ArrayList();

        try {
            Connection conn = MyConnection1.connect();
            String s0 = "select "
                    + "id"
                    + ",bank_name"
                    + " from " + MyDB.getNames() + ".bank where "
                    + " bank_name like'%" + search + "%' "
                    + " ";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String bank_name = rs.getString(2);

                to_bank to = new to_bank(id, bank_name);
                datas.add(to);
            }
            return datas;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection1.close();
        }
    }

    public static List<String> ret_cb_data() {
        List<String> datas = new ArrayList();

        datas.add("ALL");
        try {
            Connection conn = MyConnection1.connect();
            String s0 = "select bank_name from " + MyDB.getNames() + ".bank";
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
}
