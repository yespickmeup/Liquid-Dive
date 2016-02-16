/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.svc2;

import POS.Main.MyDB;
import POS.to.to_users;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import mijzcx.synapse.desk.utils.Lg;
import POS.utl.MyConnection1;
import javax.swing.JOptionPane;
import mijzcx.synapse.desk.utils.SqlStringUtil;

/**
 *
 * @author u2
 */
public class S14_chech_if_admin {

    //<editor-fold defaultstate="collapsed" desc="do_check_if_adming">
    public static int do_check_if_adming(String name) {
        try {
            String s0 = "select u.user_level,u.check_in,u.check_out,inventory "
                    + "from " + MyDB.getNames() + ".users u "
                    + "where u.user_name = :user_name; ";
            s0 = SqlStringUtil.parse(s0).
                    setString("user_name", name).
                    ok();
            Lg.$.severe(s0);
            Connection conn = MyConnection1.connect();

            PreparedStatement stmt = conn.prepareStatement(s0);
            ResultSet rs = stmt.executeQuery(s0);
            if (!rs.next()) {
                int check_in = rs.getInt(2);
                int check_out = rs.getInt(3);
                int inventory = rs.getInt(4);
//                JOptionPane.showMessageDialog(null, inventory);
                to_users.set_check_ins(check_in);
                to_users.set_check_outs(check_out);
                to_users.set_inventory(inventory);
//                System.out.println(to_users.get_check_ins() + " -- " + name);
//                System.out.println(to_users.get_check_outs() + " -- " + name);
                return 0;
            }
            return rs.getInt("user_level");
        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, "Err" + e);
            throw new RuntimeException(e);
        } finally {
            MyConnection1.close();
        }
    }

    public static int do_check_if_voider(String name) {
        try {
            String s0 = "select u.voider "
                    + "from " + MyDB.getNames() + ".users u "
                    + "where u.user_name = :user_name; ";
            s0 = SqlStringUtil.parse(s0).
                    setString("user_name", name).
                    ok();
            Lg.$.severe(s0);
            Connection conn = MyConnection1.connect();

            PreparedStatement stmt = conn.prepareStatement(s0);
            ResultSet rs = stmt.executeQuery(s0);
            int voider = 0;
            if (rs.next()) {
                voider = rs.getInt(1);
//                int check_out = rs.getInt(3);
//                to_users.set_check_ins(check_in);
//                to_users.set_check_outs(check_out);
//                System.out.println(to_users.get_check_ins() + " -- " + name);
//                System.out.println(to_users.get_check_outs() + " -- " + name);

            }
            return voider;
//            return rs.getInt("user_level");
        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, "Err" + e);
            throw new RuntimeException(e);
        } finally {
            MyConnection1.close();
        }
    }
    //</editor-fold>

    public static void main(String[] args) {
        System.out.println(do_check_if_adming("cashier"));
    }
}
