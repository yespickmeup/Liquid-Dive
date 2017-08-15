/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.to;

import POS.Main;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import POS.utl.MyConnection1;

/**
 *
 * @author u2
 */
public class to_users {

    public static String username1;
    public static String user_level1;
    public static String user_screen_name;
    public to_users(String username, String user_level) {
        username1 = username;
        user_level1 = user_level;
    }

    public static String getUser_screen_name() {
        return user_screen_name;
    }

    public static void setUser_screen_name(String user_screen_name) {
        to_users.user_screen_name = user_screen_name;
    }
    
    public String getUser_level() {
        return user_level1;
    }

    public String getUsername() {
        return username1;
    }

    @Override
    public String toString() {
        return "to_users{" + "username=" + username1 + ", user_level=" + user_level1 + '}';
    }

    public static String get_lvl() {
        return username1;
    }

    public static String get_user() {
        return username1;
    }

    public static void setUser_level1(String user_level1) {
        to_users.user_level1 = user_level1;
    }

    public static void setUsername1(String username1) {
        to_users.username1 = username1;
    }

    public static class u {

        public final String username;
        public final String user_level;
        public final String name;
        public int check_in;
        public int check_out;
        public final int voider;
        public final String password;
        public int inventory;

        public u(String username, String user_level, String name, int check_in, int check_out, int voider, String password, int inventory) {
            this.username = username;
            this.user_level = user_level;
            this.name = name;
            this.check_in = check_in;
            this.check_out = check_out;
            this.voider = voider;
            this.password = password;
            this.inventory = inventory;
        }

        public String getPassword() {
            return password;
        }

        public String getName() {
            return name;
        }

        public String getUser_level() {
            return user_level;
        }

        public String getUsername() {
            return username;
        }

        public int getVoider() {
            return voider;
        }

        public int getCheck_in() {
            return check_in;
        }

        public void setCheck_in(int check_in) {
            this.check_in = check_in;
        }

        public int getCheck_out() {
            return check_out;
        }

        public void setCheck_out(int check_out) {
            this.check_out = check_out;
        }

        public int getInventory() {
            return inventory;
        }

        public void setInventory(int inventory) {
            this.inventory = inventory;
        }
    }
    public static int check_ins = 0;
    public static int check_outs = 0;
    public static int inventorys = 0;

    public static void set_check_ins(int check_in) {
        check_ins = check_in;
    }

    public static void set_check_outs(int check_out) {
        check_outs = check_out;
    }

    public static void set_inventory(int inventory) {
        inventorys = inventory;
    }

    public static int get_check_ins() {
        return check_ins;
    }

    public static int get_check_outs() {
        return check_outs;
    }

    public static int get_inventory() {
        return inventorys;
    }

    public static String ret_data(String user_name) {
        String name = "";

        try {
            Connection conn = MyConnection1.connect();
            String s0 = "select "
                    + "user_code"
                    + " from " + Main.MyDB.getNames() + ".users where "
                    + " user_name ='" + user_name + "' "
                    + " ";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            if (rs.next()) {
                name = rs.getString(1);
            }
            return name;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection1.close();
        }
    }

    public static String ret_user(String user_name) {
        String name = "";

        try {
            Connection conn = MyConnection1.connect();
            String s0 = "select "
                    + "user_name"
                    + " from " + Main.MyDB.getNames() + ".users where "
                    + " user_code ='" + user_name + "' "
                    + " ";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            if (rs.next()) {
                name = rs.getString(1);
            }
            return name;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection1.close();
        }
    }
}
