/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.packages;

import POS.Main.MyDB;
import POS.utl.MyConnection1;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import mijzcx.synapse.desk.utils.FitIn;
import mijzcx.synapse.desk.utils.Lg;
import mijzcx.synapse.desk.utils.ReceiptIncrementor;
import mijzcx.synapse.desk.utils.SqlStringUtil;

/**
 *
 * @author Maytopacka
 */
public class S1_item_packages {

    public static class to_item_packages {

        public final int id;
        public final double range_from;
        public final double range_to;
        public final double rate;
        public final String product_name;
        public final String description;
        public final String is_active;
        public final String package_name;

        public to_item_packages(int id, double range_from, double range_to, double rate, String product_name, String description, String is_active, String package_name) {
            this.id = id;
            this.range_from = range_from;
            this.range_to = range_to;
            this.rate = rate;
            this.product_name = product_name;
            this.description = description;
            this.is_active = is_active;
            this.package_name = package_name;
        }
    }

    public static void add_item_packages(to_item_packages to_item_packages) {
        try {
            Connection conn = MyConnection1.connect();
            String s0 = "insert into " + MyDB.getNames() + ".item_packages("
                    + "range_from"
                    + ",range_to"
                    + ",rate"
                    + ",product_name"
                    + ",description"
                    + ",is_active"
                    + ",package_name"
                    + ")values("
                    + ":range_from"
                    + ",:range_to"
                    + ",:rate"
                    + ",:product_name"
                    + ",:description"
                    + ",:is_active"
                    + ",:package_name"
                    + ")";

            s0 = SqlStringUtil.parse(s0).
                    setNumber("range_from", to_item_packages.range_from).
                    setNumber("range_to", to_item_packages.range_to).
                    setNumber("rate", to_item_packages.rate).
                    setString("product_name", to_item_packages.product_name).
                    setString("description", to_item_packages.description).
                    setString("is_active", to_item_packages.is_active).
                    setString("package_name", to_item_packages.package_name).
                    ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_item_packages.class, "Successfully Added");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection1.close();
        }
    }

    public static void edit_item_packages(to_item_packages to_item_packages) {
        try {
            Connection conn = MyConnection1.connect();
            String s0 = "update " + MyDB.getNames() + ".item_packages set "
                    + "range_from= '" + to_item_packages.range_from + "'"
                    + ",range_to= '" + to_item_packages.range_to + "'"
                    + ",rate= '" + to_item_packages.rate + "'"
                    + ",product_name= '" + to_item_packages.product_name + "'"
                    + ",description= '" + to_item_packages.description + "'"
                    + ",is_active= '" + to_item_packages.is_active + "'"
                    + ",package_name= '" + to_item_packages.package_name + "'"
                    + "where "
                    + " id ='" + to_item_packages.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_item_packages.class, "Successfully Updated");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection1.close();
        }
    }

    public static void delete_item_packages(to_item_packages to_item_packages) {
        try {
            Connection conn = MyConnection1.connect();
            String s0 = "delete from " + MyDB.getNames() + ".item_packages where "
                    + " id ='" + to_item_packages.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_item_packages.class, "Successfully Deleted");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection1.close();
        }
    }

    public static List<to_item_packages> ret_data(String product_names) {
        List<to_item_packages> datas = new ArrayList();

        try {
            Connection conn = MyConnection1.connect();
            String s0 = "select "
                    + "id"
                    + ",range_from"
                    + ",range_to"
                    + ",rate"
                    + ",product_name"
                    + ",description"
                    + ",is_active"
                    + ",package_name"
                    + " from " + MyDB.getNames() + ".item_packages where "
                    + " product_name ='" + product_names + "' "
                    + " ";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                double range_from = rs.getDouble(2);
                double range_to = rs.getDouble(3);
                double rate = rs.getDouble(4);
                String product_name = rs.getString(5);
                String description = rs.getString(6);
                String is_active = rs.getString(7);
                String package_name = rs.getString(8);
                to_item_packages to = new to_item_packages(id, range_from, range_to, rate, product_name, description, is_active, package_name);
                datas.add(to);
            }
            return datas;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection1.close();
        }
    }

    public static void main(String[] args) {
//        Main.MyDB.setNames("db_pos_restaurant");
        List<to_item_packages> packages = ret_data("35");
        int qty = 15;
//        System.out.println(
//                get_rate(1300, packages, qty));
    }

    public static String[] get_rate(double actual_rate, List<to_item_packages> packages, int qty, String description) {
        double rates = actual_rate;
        String[] aw = new String[2];
        aw[0] = "" + actual_rate;
        aw[1] = description;
        for (to_item_packages to : packages) {
            double[] range = new double[FitIn.toInt("" + (to.range_to - to.range_from)) + 1];
            double from = to.range_from;
            for (int i = 0; i < range.length; i++) {
                range[i] = from++;
                int stop = 0;
                if (qty == range[i]) {
                    stop = 1;
                }
                if (stop == 1) {
                    rates = to.rate;
                    aw[0] = "" + rates;
                    aw[1] = to.package_name;
                }
            }
        }
        return aw;
    }

    public static String increment_id() {
        String id = "0";
        try {
            Connection conn = MyConnection1.connect();
            String s0 = "select max(id) from " + MyDB.getNames() + ".item_packages";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            if (rs.next()) {
                id = rs.getString(1);
            }
            id = ReceiptIncrementor.increment(id);
            return id;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection1.close();
        }
    }

    public static void edit_inventory2_stocks_left(String product_name, String is_active) {
        try {
            Connection conn = MyConnection1.connect();
            String s0 = "update " + MyDB.getNames() + ".inventory2_stocks_left set "
                    + "item_package_id= '" + is_active + "'"
                    + "where "
                    + " product_name='" + product_name + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_item_packages.class, "Successfully Updated");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection1.close();
        }
    }
}
