/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.svc;

import POS.Main.MyDB;
import POS.to.to_users;
import POS.utl.Constants;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import POS.utl.MyConnection1;
import mijzcx.synapse.desk.utils.SqlStringUtil;

/**
 *
 * @author u2
 */
public class S12_retval_user_level {

    //<editor-fold defaultstate="collapsed" desc="get_user_level">
    public static int get_user_level(String username) {

        try {

            String s0 = "select u.user_level,u.check_in,u.check_out,inventory "
                    + "from " + MyDB.getNames() + ".users u "
                    + "where u.user_name= :username ";

            s0 = SqlStringUtil.parse(s0).
                    setString("username", username).
                    ok();

            Connection conn = MyConnection1.connect();

            PreparedStatement pstmt = conn.prepareStatement(s0);
            ResultSet rs = pstmt.executeQuery();

            if (!rs.next()) {
                return Constants.DEFAULT_USER_LEVEL;
            }

            int check_in = rs.getInt(2);
            int check_out = rs.getInt(3);
            int inventory = rs.getInt(4);
            to_users.set_check_ins(check_in);
            to_users.set_check_outs(check_out);
            to_users.set_inventory(inventory);
            System.out.println(to_users.get_check_ins() + " -- " + username + " = " + check_in);
            System.out.println(to_users.get_check_outs() + " -- " + username + " = " + check_out);
            System.out.println(to_users.get_inventory() + " -- " + username + " = " + inventory);
            return rs.getInt("user_level");

        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection1.close();
        }
    }
    //</editor-fold>

    public static void main(String[] args) {
        System.out.println(get_user_level("admin1"));
    }
}
