/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.rooms;

import POS.Main.MyDB;
import POS.guests.S1_guest;
import POS.guests.S2_guest_charges;
import POS.packages.S1_item_packages;
import POS.staff_discount.S1_staff_discount;
import POS.to.to_users;
import POS.utl.DateType;
import POS.utl.NumberFormat;
import POS_svc4.S2_search;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import mijzcx.synapse.desk.utils.Lg;
import POS.utl.MyConnection1;
import java.sql.SQLException;
import java.util.ArrayList;
import mijzcx.synapse.desk.utils.FitIn;
import mijzcx.synapse.desk.utils.ReceiptIncrementor;
import mijzcx.synapse.desk.utils.SqlStringUtil;

import test.Dlg_check.to_guests;
import test.Dlg_check_liquid;

/**
 *
 * @author Dummy
 */
public class S1_check_in {

    public static class to_customer_tables {

        public final String id;
        public final String table_no;
        public final String date_added;
        public final double amount;
        public final String or_no;
        public final String status;

        public to_customer_tables(String id, String table_no, String date_added, double amount, String or_no, String status) {
            this.id = id;
            this.table_no = table_no;
            this.date_added = date_added;
            this.amount = amount;
            this.or_no = or_no;
            this.status = status;
        }
    }

    public static class to_room_guests {

        public final int id;
        public final int rooom_id;
        public final String guest_id;
        public final String guest_name;
        public final String checkin_date;
        public final String checkout_date;
        public final int status;
        public final double to_pay;
        public final double paid;

        public to_room_guests(int id, int rooom_id, String guest_id, String guest_name, String checkin_date, String checkout_date, int status, double to_pay, double paid) {
            this.id = id;
            this.rooom_id = rooom_id;
            this.guest_id = guest_id;
            this.guest_name = guest_name;
            this.checkin_date = checkin_date;
            this.checkout_date = checkout_date;
            this.status = status;
            this.to_pay = to_pay;
            this.paid = paid;
        }
    }

    public static void check_in(to_customer_tables to, List<S1_guest.to_guests> guest, double room_rate, int mode, List<S2_search.to_items> items) {
        try {
            Connection conn = MyConnection1.connect();
            String checkin_date = DateType.datetime.format(new Date());

            double my_rate = 0;
            if (mode == 1) {
                double plus = 0;
                String s = "select count(id) from " + MyDB.getNames() + ".room_guests where rooom_id='" + to.table_no + "' and status='" + "0" + "'";
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(s);
                if (rs.next()) {
                    plus = rs.getDouble(1);
                }
                my_rate = guest.size() + plus;
            } else {
                my_rate = guest.size();
            }

            double price = 0;
            double price1 = 0;
            if (System.getProperty("version", "resto").
                    equals("resto")) {

                for (S2_search.to_items to1 : items) {
                    String s0 = "insert into " + MyDB.getNames() + ".room_accomodations("
                            + "table_id"
                            + ",table_names"
                            + ",check_in"
                            + ",check_out"
                            + ",status"
                            + ",product_num"
                            + ",description"
                            + ",qty"
                            + ",price"
                            + ")values("
                            + ":table_id"
                            + ",:table_names"
                            + ",:check_in"
                            + ",:check_out"
                            + ",:status"
                            + ",:product_num"
                            + ",:description"
                            + ",:qty"
                            + ",:price"
                            + ")";
                    s0 = SqlStringUtil.parse(s0).
                            setString("table_id", to.table_no).
                            setString("table_names", "").
                            setString("check_in", DateType.datetime.format(new Date())).
                            setString("check_out", DateType.datetime.format(new Date())).
                            setNumber("status", 0).
                            setString("product_num", to1.name).
                            setString("description", to1.desc).
                            setNumber("qty", to1.qty).
                            setNumber("price", to1.price).
                            ok();
                    price += to1.price;
                    PreparedStatement stmt = conn.prepareStatement(s0);
                    stmt.execute();
                    Lg.s(S1_check_in.class, "Successfully Added room accomodation");
                }
                String s5 = "select price from " + MyDB.getNames() + ".room_accomodations where  table_id ='" + to.table_no + "' and status='" + "0" + "'";
                Statement stmt5 = conn.createStatement();
                ResultSet rs5 = stmt5.executeQuery(s5);
                if (rs5.next()) {
                    price1 = rs5.getDouble(1);
                }
                my_rate = price1 / my_rate;
            } else {
                my_rate = room_rate / my_rate;
            }
            for (S1_guest.to_guests to1 : guest) {
                String s0 = "insert into " + MyDB.getNames() + ".room_guests("
                        + "rooom_id"
                        + ",guest_id"
                        + ",guest_name"
                        + ",checkin_date"
                        + ",checkout_date"
                        + ",status"
                        + ",to_pay"
                        + ",paid"
                        + ",room_rate"
                        + ",staff"
                        + ")values("
                        + ":rooom_id"
                        + ",:guest_id"
                        + ",:guest_name"
                        + ",:checkin_date"
                        + ",:checkout_date"
                        + ",:status"
                        + ",:to_pay"
                        + ",:paid"
                        + ",:room_rate"
                        + ",:staff"
                        + ")";

                s0 = SqlStringUtil.parse(s0).
                        setString("rooom_id", to.table_no).
                        setString("guest_id", to1.guest_id).
                        setString("guest_name", (to1.fname + " " + to1.mi + " " + to1.lname)).
                        setString("checkin_date", checkin_date).
                        setString("checkout_date", checkin_date).
                        setNumber("status", 0).
                        setNumber("to_pay", price).
                        setNumber("paid", 0).
                        setNumber("room_rate", room_rate).
                        setNumber("staff", to1.staff).
                        ok();

                PreparedStatement stmt = conn.prepareStatement(s0);
                stmt.execute();
                Lg.s(S1_check_in.class, "Successfully Added");

                int id = 0;;
                String guest_id = "" + to1.guest_id;
                String guest_name = to1.fname + " " + to1.mi + " " + to1.lname;
                String date_added = DateType.datetime.format(new Date());
                double amount = my_rate;
                int status = 0;

                S2_guest_charges.to_guest_charges to_guest_charges = new S2_guest_charges.to_guest_charges(id, guest_id, guest_name, date_added, amount, status);
                String s3 = "update " + MyDB.getNames() + ".guest_charges set "
                        + "amount= '" + NumberFormat.df.format(my_rate) + "'"
                        + "where "
                        + " table_no ='" + to.table_no + "' "
                        + " and Date(date_added) = '" + DateType.sf.format(new Date()) + "' "
                        + " and status ='" + "0" + "' "
                        + " ";

                PreparedStatement stmt3 = conn.prepareStatement(s3);
                stmt3.execute();

                String s2 = "insert into " + MyDB.getNames() + ".guest_charges("
                        + "guest_id"
                        + ",guest_name"
                        + ",date_added"
                        + ",amount"
                        + ",status"
                        + ",table_no"
                        + ")values("
                        + ":guest_id"
                        + ",:guest_name"
                        + ",:date_added"
                        + ",:amount"
                        + ",:status"
                        + ",:table_no"
                        + ")";
                s2 = SqlStringUtil.parse(s2).
                        setString("guest_id", to_guest_charges.guest_id).
                        setString("guest_name", to_guest_charges.guest_name).
                        setString("date_added", to_guest_charges.date_added).
                        setString("amount", NumberFormat.df.format(to_guest_charges.amount)).
                        setNumber("status", to_guest_charges.status).
                        setString("table_no", to.table_no).
                        ok();

                PreparedStatement stmt2 = conn.prepareStatement(s2);
                stmt2.execute();

                Lg.s(S1_check_in.class, "Successfully Added");

            }

            Lg.s(S1_check_in.class, "Successfully Added check in");
        } catch (SQLException e) {
            MyConnection1.close();
            throw new RuntimeException(e);
        } finally {
            MyConnection1.close();
        }
    }

    public static void check_in3(to_customer_tables to, List<S1_guest.to_guests> guest, double room_rate, int mode) {
        try {
            Connection conn = MyConnection1.connect();
            String checkin_date = DateType.datetime.format(new Date());

            double my_rate = 0;
            if (mode == 1) {
                double plus = 0;
                String s = "select count(id) from " + MyDB.getNames() + ".room_guests2 where rooom_id='" + to.table_no + "' and status='" + "0" + "'";
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(s);
                if (rs.next()) {
                    plus = rs.getDouble(1);
                }
                my_rate = guest.size() + plus;
            } else {
                my_rate = guest.size();
            }
            my_rate = room_rate / my_rate;

            for (S1_guest.to_guests to1 : guest) {
                String s0 = "insert into " + MyDB.getNames() + ".room_guests2("
                        + "rooom_id"
                        + ",guest_id"
                        + ",guest_name"
                        + ",checkin_date"
                        + ",checkout_date"
                        + ",status"
                        + ",to_pay"
                        + ",paid"
                        + ",room_rate"
                        + ")values("
                        + ":rooom_id"
                        + ",:guest_id"
                        + ",:guest_name"
                        + ",:checkin_date"
                        + ",:checkout_date"
                        + ",:status"
                        + ",:to_pay"
                        + ",:paid"
                        + ",:room_rate"
                        + ")";

                s0 = SqlStringUtil.parse(s0).
                        setString("rooom_id", to.table_no).
                        setString("guest_id", to1.guest_id).
                        setString("guest_name", (to1.fname + " " + to1.mi + " " + to1.lname)).
                        setString("checkin_date", checkin_date).
                        setString("checkout_date", checkin_date).
                        setNumber("status", 0).
                        setNumber("to_pay", 0).
                        setNumber("paid", 0).
                        setNumber("room_rate", room_rate).
                        ok();

                PreparedStatement stmt = conn.prepareStatement(s0);
                stmt.execute();
                Lg.s(S1_check_in.class, "Successfully Added");

                int id = 0;;
                String guest_id = "" + to1.guest_id;
                String guest_name = to1.fname + " " + to1.mi + " " + to1.lname;
                String date_added = DateType.datetime.format(new Date());
                double amount = my_rate;
                int status = 0;

                S2_guest_charges.to_guest_charges to_guest_charges = new S2_guest_charges.to_guest_charges(id, guest_id, guest_name, date_added, amount, status);
                String s3 = "update " + MyDB.getNames() + ".guest_charges2 set "
                        + "amount= '" + NumberFormat.df.format(to_guest_charges.amount) + "'"
                        + "where "
                        + " table_no ='" + to.table_no + "' "
                        + " and Date(date_added) = '" + DateType.sf.format(new Date()) + "' "
                        + " and status ='" + "0" + "' "
                        + " ";

                PreparedStatement stmt3 = conn.prepareStatement(s3);
                stmt3.execute();

                String s2 = "insert into " + MyDB.getNames() + ".guest_charges2("
                        + "guest_id"
                        + ",guest_name"
                        + ",date_added"
                        + ",amount"
                        + ",status"
                        + ",table_no"
                        + ")values("
                        + ":guest_id"
                        + ",:guest_name"
                        + ",:date_added"
                        + ",:amount"
                        + ",:status"
                        + ",:table_no"
                        + ")";
                s2 = SqlStringUtil.parse(s2).
                        setString("guest_id", to_guest_charges.guest_id).
                        setString("guest_name", to_guest_charges.guest_name).
                        setString("date_added", to_guest_charges.date_added).
                        setString("amount", NumberFormat.df.format(to_guest_charges.amount)).
                        setNumber("status", to_guest_charges.status).
                        setString("table_no", to.table_no).
                        ok();

                PreparedStatement stmt2 = conn.prepareStatement(s2);
                stmt2.execute();

                Lg.s(S1_check_in.class, "Successfully Added");

            }
//            JOptionPane.showMessageDialog(null, "adadad");
            Lg.s(S1_check_in.class, "Successfully Added check in");
        } catch (Exception e) {
            MyConnection1.close();
            throw new RuntimeException(e);
        } finally {
            MyConnection1.close();
        }
    }

    public static String get_table_id(String table_name) {
        String room_id = "";
        try {
            Connection conn = MyConnection1.connect();

            String s3 = "select id from " + MyDB.getNames() + ".tables where table_name='" + table_name + "' ";
            Statement stmt2 = conn.createStatement();
            ResultSet rs2 = stmt2.executeQuery(s3);
            if (rs2.next()) {
                room_id = rs2.getString(1);
            }
            return room_id;
        } catch (Exception e) {
            MyConnection1.close();
            throw new RuntimeException(e);
        } finally {
            MyConnection1.close();
        }
    }

    public static String add_order_rooms(List<S2_search.to_orders> to, String table_no, List<Dlg_check_liquid.to_guests> my_guest, List<S2_search.to_items_status> to_sub, String user_lvl) {
        try {
            String order_no = increment_id();
            double my_amount = 0;
            Connection conn = MyConnection1.connect();
            String room_id = table_no;
            String now = DateType.datetime.format(new Date());
            String now2 = DateType.sf.format(new Date());

            double _disc_rate = S1_staff_discount.ret_data();
            String user_name = "";
            user_name = to_users.ret_user(to_users.username1);

            int guest_no = my_guest.size();
            for (Dlg_check_liquid.to_guests guest : my_guest) {
                System.out.println(guest.id + " : " + guest.name + " guessssstt");
                String id = "";
                for (S2_search.to_orders t : to) {
                    double qty = 0;
                    double discounts = 0;
                    String s2 = "";
                    if (t.cat_id.equals("11")) {
                        s2 = "select qty,id,discount from " + MyDB.getNames() + ".customer_tables_details where product_name='" + t.name + "' and table_no_id='" + guest.table_id + "' "
                                + "and guest_id='" + guest.id + "' and status<>'" + "1" + "' and guest_no ='" + guest_no + "' and Date(date_added)='" + now2 + "'";
                    } else if (t.cat_id.equals("10") || t.cat_id.equals("12")) {
                        s2 = "select qty,id,discount from " + MyDB.getNames() + ".customer_tables_details where product_name='" + t.name + "' and table_no_id='" + guest.table_id + "' "
                                + "and guest_id='" + guest.id + "' and status<>'" + "1" + "' and Date(date_added)='" + now2 + "' ";
                    } else {
                        s2 = "select qty,id,discount from " + MyDB.getNames() + ".customer_tables_details where product_name='" + t.name + "' and table_no_id='" + guest.table_id + "' "
                                + "and guest_id='" + guest.id + "' and status<>'" + "1" + "' ";
                    }
                    Statement stmt1 = conn.createStatement();
                    ResultSet rs = stmt1.executeQuery(s2);
                    if (rs.next()) {
                        qty = rs.getDouble(1);
                        id = rs.getString(2);
                        discounts = rs.getDouble(3);
                    }
//                    JOptionPane.showMessageDialog(null, guest.id  + " :guest id "+t.name + " :barcode "+guest.table_id + " table no id " + qty + " :id");
                    if (qty == 0) {

                        double disc_rate = 0;
                        double discount = t.discount;
                        int count = 0;

                        if (guest.staff == 1 && t.cat_id.equals("10") || guest.staff == 1 && t.cat_id.
                                equals("12")) {
                            disc_rate = _disc_rate / 100;
                            discount = (t.price * t.qty) * disc_rate;
                        }
                        double price = 0;
                        String desc = t.desc;
                        if (!t.cat_id.equals("11")) {
//                            guest_no = 1;
                            price = t.price;
                            if (t.item_package_id == 1) {
                                List<S1_item_packages.to_item_packages> packages = new ArrayList();
                                packages = S1_item_packages.ret_data(t.name);

                                String[] aw = S1_item_packages.get_rate(t.price, packages, FitIn.
                                        toInt("" + t.qty), t.desc);
                                price = FitIn.toDouble(aw[0]);
                                desc = aw[1];
//                                JOptionPane.showMessageDialog(null, t.name + " "+price+ " "+t.qty);
                            }
                            price = price / guest_no;
                        } else {
                            guest_no = my_guest.size();

                            price = t.price / guest_no;
                        }

                        String s0 = "insert into " + MyDB.getNames() + ".customer_tables_details(table_no_id,qty,product_name,description,price"
                                + ",img_path,status"
                                + ",guest_id,guest_name,cat_id,date_added,printing_assembly"
                                + ",disc_name,disc_rate,discount,customer_name,customer_id"
                                + ",customer_address,user_lvl,group_id,nights,guest_no,room_guest_id"
                                + ",user_name,sub_category_name,sub_category_id,category_name,order_no"
                                + ")values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
                        PreparedStatement stmt = conn.prepareStatement(s0);
                        stmt.setString(1, guest.table_guest_ids);
                        stmt.setDouble(2, t.qty);
                        stmt.setString(3, t.name);
                        stmt.setString(4, desc);
                        stmt.setDouble(5, price);
                        stmt.setString(6, t.img_path);
                        stmt.setString(7, "0");
                        stmt.setString(8, guest.id);
                        stmt.setString(9, guest.name);
                        stmt.setString(10, t.cat_id);
                        stmt.setString(11, now);
                        stmt.setInt(12, t.printing_assembly);
                        stmt.setString(13, t.disc_name);
                        stmt.setDouble(14, disc_rate);
                        stmt.setDouble(15, discount);
                        stmt.setString(16, t.customer_name);
                        stmt.setString(17, t.customer_id);
                        stmt.setString(18, t.customer_address);
                        stmt.setString(19, user_lvl);
                        stmt.setInt(20, t.group_id);
                        stmt.setInt(21, 1);
                        stmt.setInt(22, guest_no);
                        stmt.setInt(23, FitIn.toInt(guest.room_guest_ids));
                        stmt.setString(24, user_name);
                        stmt.setString(25, t.sub_category_name);
                        stmt.setString(26, t.sub_category_name);
                        stmt.setString(27, t.category_name);
                        stmt.setString(28, order_no);
                        stmt.execute();
                        my_amount += t.qty * t.price;
                        Lg.s(S1_check_in.class, "Successfully Added");
                        String ctd_id = "-1";
                        String s4 = "select max(id) from " + MyDB.getNames() + ".customer_tables_details";
                        Statement stmt4 = conn.createStatement();
                        ResultSet rs4 = stmt.executeQuery(s4);
                        while (rs4.next()) {
                            ctd_id = rs4.getString(1);
                        }
                        List<S2_search.to_items_status> subs = t.to_sub;
                        for (S2_search.to_items_status to_customer_table_details_assembly : subs) {
                            String s5 = "insert into " + MyDB.getNames() + ".customer_table_details_assembly("
                                    + "ctd_id"
                                    + ",prod_num"
                                    + ",description"
                                    + ",price"
                                    + ",product_qty"
                                    + ",ref_num"
                                    + ",status"
                                    + ",table_no"
                                    + ",is_selected"
                                    + ")values("
                                    + ":ctd_id"
                                    + ",:prod_num"
                                    + ",:description"
                                    + ",:price"
                                    + ",:product_qty"
                                    + ",:ref_num"
                                    + ",:status"
                                    + ",:table_no"
                                    + ",:is_selected"
                                    + ")";

                            s5 = SqlStringUtil.parse(s5).
                                    setString("ctd_id", ctd_id).
                                    setString("prod_num", to_customer_table_details_assembly.name).
                                    setString("description", to_customer_table_details_assembly.desc).
                                    setNumber("price", to_customer_table_details_assembly.price).
                                    setNumber("product_qty", to_customer_table_details_assembly.qty).
                                    setString("ref_num", t.name).
                                    setNumber("status", 0).
                                    setString("table_no", table_no).
                                    setBoolean("is_selected", to_customer_table_details_assembly.status).
                                    ok();
                            PreparedStatement stmt5 = conn.prepareStatement(s5);
                            stmt5.execute();
                            Lg.s(S1_check_in.class, "Successfully Added");
                        }
                    } else {
                        qty += t.qty;
                        double new_qty = qty - t.qty;
                        my_amount += new_qty * t.price;

                        double disc_rate = 0;
                        disc_rate = _disc_rate / 100;
                        double discount = 0;
                        if (guest.staff == 1 && t.cat_id.equals("10") || guest.staff == 1 && t.cat_id.
                                equals("12")) {
                            discount = (t.price * t.qty) * disc_rate;
                            discount += discounts;
                        }
                        String s0 = "";
                        String desc = t.desc;
                        if (t.item_package_id == 0) {
//                             JOptionPane.showMessageDialog(null, "asd");
                            s0 = "update " + MyDB.getNames() + ".customer_tables_details set "
                                    + "qty='" + qty + "',discount='" + discount + "' "
                                    + "where id='" + id + "'  ";
                        } else {
                            List<S1_item_packages.to_item_packages> packages = new ArrayList();
                            packages = S1_item_packages.ret_data(t.name);
                            double price = 0;
                            String[] aw = S1_item_packages.get_rate(t.price, packages, FitIn.
                                    toInt("" + qty), t.desc);
                            desc = aw[1];
                            price = FitIn.toDouble(aw[0]);

                            s0 = "update " + MyDB.getNames() + ".customer_tables_details set qty='" + qty + "'"
                                    + ",discount='" + discount + "',price='" + price + "',description='" + desc + "' "
                                    + "where id='" + id + "'";

                        }
//                        JOptionPane.showMessageDialog(null, "adadad");
                        PreparedStatement stmt = conn.prepareStatement(s0);
                        stmt.execute();
                        Lg.s(S1_check_in.class, "Successfully Updated");
                    }
                }
            }
            return order_no;
        } catch (Exception e) {
            MyConnection1.close();
            throw new RuntimeException(e);
        } finally {
            MyConnection1.close();
        }
    }

    public static void add_data(List<S2_search.to_orders> to1, String table_no, to_guests my_guest, List<S2_search.to_items_status> to_sub) {
        try {
            Connection conn = MyConnection1.connect();
            String now = DateType.datetime.format(new Date());
            for (S2_search.to_orders to : to1) {

                String s0 = "insert into " + MyDB.getNames() + ".customer_tables_details("
                        + "table_no_id"
                        + ",or_no"
                        + ",qty"
                        + ",product_name"
                        + ",description"
                        + ",price"
                        + ",img_path"
                        + ",status"
                        + ",guest_id"
                        + ",guest_name"
                        + ",cat_id"
                        + ",date_added"
                        + ",printing_assembly"
                        + ",disc_name"
                        + ",disc_rate"
                        + ",discount"
                        + ",customer_name"
                        + ",customer_id"
                        + ",customer_address"
                        + ")values("
                        + ":table_no_id"
                        + ",:or_no"
                        + ",:qty"
                        + ",:product_name"
                        + ",:description"
                        + ",:price"
                        + ",:img_path"
                        + ",:status"
                        + ",:guest_id"
                        + ",:guest_name"
                        + ",:cat_id"
                        + ",:date_added"
                        + ",:printing_assembly"
                        + ",:disc_name"
                        + ",:disc_rate"
                        + ",:discount"
                        + ",:customer_name"
                        + ",:customer_id"
                        + ",:customer_address"
                        + ")";

                s0 = SqlStringUtil.parse(s0).
                        setString("table_no_id", table_no).
                        setString("or_no", "").
                        setNumber("qty", to.qty).
                        setString("product_name", to.name).
                        setString("description", to.desc).
                        setNumber("price", to.price).
                        setString("img_path", to.img_path).
                        setNumber("status", 0).
                        setString("guest_id", my_guest.id).
                        setString("guest_name", my_guest.name).
                        setString("cat_id", to.cat_id).
                        setString("date_added", now).
                        setNumber("printing_assembly", to.printing_assembly).
                        setString("disc_name", to.disc_name).
                        setNumber("disc_rate", to.disc_rate).
                        setNumber("discount", to.discount).
                        setString("customer_name", to.customer_name).
                        setString("customer_id", to.customer_id).
                        setString("customer_address", to.customer_address).
                        ok();

                PreparedStatement stmt = conn.prepareStatement(s0);
                stmt.execute();
                Lg.s(S1_check_in.class, "Successfully Added");

                String ctd_id = "-1";
                String s4 = "select max(id) from " + MyDB.getNames() + ".customer_tables_details2";
                ResultSet rs4 = stmt.executeQuery(s4);
                while (rs4.next()) {
                    ctd_id = rs4.getString(1);
                }

                List<S2_search.to_items_status> subs = to.to_sub;
                for (S2_search.to_items_status to_customer_table_details_assembly : subs) {
                    String s5 = "insert into " + MyDB.getNames() + ".customer_table_details_assembly("
                            + "ctd_id"
                            + ",prod_num"
                            + ",description"
                            + ",price"
                            + ",product_qty"
                            + ",ref_num"
                            + ",status"
                            + ",table_no"
                            + ",is_selected"
                            + ")values("
                            + ":ctd_id"
                            + ",:prod_num"
                            + ",:description"
                            + ",:price"
                            + ",:product_qty"
                            + ",:ref_num"
                            + ",:status"
                            + ",:table_no"
                            + ",:is_selected"
                            + ")";

                    s5 = SqlStringUtil.parse(s5).
                            setString("ctd_id", ctd_id).
                            setString("prod_num", to_customer_table_details_assembly.name).
                            setString("description", to_customer_table_details_assembly.desc).
                            setNumber("price", to_customer_table_details_assembly.price).
                            setNumber("product_qty", to_customer_table_details_assembly.qty).
                            setString("ref_num", to.name).
                            setNumber("status", 0).
                            setString("table_no", table_no).
                            setBoolean("is_selected", to_customer_table_details_assembly.status).
                            ok();
                    PreparedStatement stmt5 = conn.prepareStatement(s5);
                    stmt5.execute();
                    Lg.s(S1_check_in.class, "Successfully Added");
                }
                String s5 = "delete from " + MyDB.getNames() + ".customer_tables_details where product_name='" + to.name + "' and status <>'" + "1" + "' and table_no_id='" + table_no + "'";
                PreparedStatement stmt4 = conn.prepareStatement(s5);
                stmt4.execute();
                Lg.s(S1_check_in.class, "Successfully deleted");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection1.close();
        }
    }

    public static void add_order_rooms3(List<S2_search.to_orders> to, String table_no, List<Dlg_check_liquid.to_guests> my_guest, List<S2_search.to_items_status> to_sub) {

        try {
            double my_amount = 0;
            Connection conn = MyConnection1.connect();
            String room_id = table_no;
            String now = DateType.datetime.format(new Date());
            for (Dlg_check_liquid.to_guests guest : my_guest) {
                JOptionPane.showMessageDialog(null, table_no);
                for (S2_search.to_orders t : to) {
                    double qty = 0;
                    String s2 = "select qty from " + MyDB.getNames() + ".customer_tables_details where product_name='" + t.name + "' and table_no_id='" + room_id + "' and guest_id='" + guest.id + "'";
                    Statement stmt1 = conn.createStatement();
                    ResultSet rs = stmt1.executeQuery(s2);
                    if (rs.next()) {
                        qty = rs.getDouble(1);
                    }
                    if (qty == 0) {

                        String s0 = "insert into " + MyDB.getNames() + ".customer_tables_details(table_no_id,qty,product_name,description,price,img_path,status"
                                + ",guest_id,guest_name,cat_id,date_added,printing_assembly,disc_name,disc_rate,discount,customer_name,customer_id,customer_address)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
                        PreparedStatement stmt = conn.prepareStatement(s0);
                        stmt.setString(1, room_id);
                        stmt.setDouble(2, t.qty);
                        stmt.setString(3, t.name);
                        stmt.setString(4, t.desc);
                        stmt.setDouble(5, t.price);
                        stmt.setString(6, t.img_path);
                        stmt.setString(7, "0");
                        stmt.setString(8, guest.id);
                        stmt.setString(9, guest.name);
                        stmt.setString(10, t.cat_id);
                        stmt.setString(11, now);
                        stmt.setInt(12, t.printing_assembly);

                        stmt.setString(13, t.disc_name);
                        stmt.setDouble(14, t.disc_rate);
                        stmt.setDouble(15, t.discount);
                        stmt.setString(16, t.customer_name);
                        stmt.setString(17, t.customer_id);
                        stmt.setString(18, t.customer_address);
                        stmt.execute();
                        stmt.execute();
                        my_amount += t.qty * t.price;
                        Lg.s(S1_check_in.class, "Successfully Added");

                        String ctd_id = "-1";
                        String s4 = "select max(id) from " + MyDB.getNames() + ".customer_tables_details";
                        Statement stmt4 = conn.createStatement();
                        ResultSet rs4 = stmt.executeQuery(s4);
                        while (rs4.next()) {
                            ctd_id = rs4.getString(1);
                        }
                        List<S2_search.to_items_status> subs = t.to_sub;
                        for (S2_search.to_items_status to_customer_table_details_assembly : subs) {
                            String s5 = "insert into " + MyDB.getNames() + ".customer_table_details_assembly("
                                    + "ctd_id"
                                    + ",prod_num"
                                    + ",description"
                                    + ",price"
                                    + ",product_qty"
                                    + ",ref_num"
                                    + ",status"
                                    + ",table_no"
                                    + ",is_selected"
                                    + ")values("
                                    + ":ctd_id"
                                    + ",:prod_num"
                                    + ",:description"
                                    + ",:price"
                                    + ",:product_qty"
                                    + ",:ref_num"
                                    + ",:status"
                                    + ",:table_no"
                                    + ",:is_selected"
                                    + ")";

                            s5 = SqlStringUtil.parse(s5).
                                    setString("ctd_id", ctd_id).
                                    setString("prod_num", to_customer_table_details_assembly.name).
                                    setString("description", to_customer_table_details_assembly.desc).
                                    setNumber("price", to_customer_table_details_assembly.price).
                                    setNumber("product_qty", to_customer_table_details_assembly.qty).
                                    setString("ref_num", t.name).
                                    setNumber("status", 0).
                                    setString("table_no", table_no).
                                    setBoolean("is_selected", to_customer_table_details_assembly.status).
                                    ok();
                            PreparedStatement stmt5 = conn.prepareStatement(s5);
                            stmt5.execute();
                            Lg.s(S1_check_in.class, "Successfully Added");
                        }
                    } else {
                        qty += t.qty;
                        double new_qty = qty - t.qty;
                        my_amount += new_qty * t.price;
                        String s0 = "update " + MyDB.getNames() + ".customer_tables_details set qty='" + qty + "' where product_name='" + t.name + "' and table_no_id='" + room_id + "'";
                        PreparedStatement stmt = conn.prepareStatement(s0);
                        stmt.execute();
                        Lg.s(S1_check_in.class, "Successfully Updated");
                    }
                }
                double to_pay = 0;
                String s2 = "select to_pay from " + MyDB.getNames() + ".room_guests where rooom_id='" + room_id + "' and guest_id='" + guest.id + "' and status='" + "0" + "'";
                Statement stmt1 = conn.createStatement();
                ResultSet rs = stmt1.executeQuery(s2);
                if (rs.next()) {
                    to_pay = rs.getDouble(1);
                }
                to_pay += my_amount;
                String s0 = "update " + MyDB.getNames() + ".room_guests set to_pay='" + to_pay + "' where rooom_id='" + room_id + "' and guest_id='" + guest.id + "' and status='" + "0" + "' ";
                PreparedStatement stmt = conn.prepareStatement(s0);
                stmt.execute();
                Lg.s(S1_check_in.class, "Successfully Updated");
            }
        } catch (Exception e) {
            MyConnection1.close();
            throw new RuntimeException(e);
        } finally {
            MyConnection1.close();
        }
    }

    public static void charge_order_to_romm(List<S2_search.to_orders> to, String table_no, List<S2_search.to_items_status> to_sub, String guest_id, String guest_name, String table_id) {

        try {
            double my_amount = 0;
            Connection conn = MyConnection1.connect();
            String room_id = table_no;
            String now = DateType.datetime.format(new Date());

//                JOptionPane.showMessageDialog(null, guest.name);
            for (S2_search.to_orders t : to) {

                String s0 = "insert into " + MyDB.getNames() + ".customer_tables_details(table_no_id,qty,product_name,description,price,img_path,status"
                        + ",guest_id,guest_name,cat_id,date_added,printing_assembly)values(?,?,?,?,?,?,?,?,?,?,?,?)";
                PreparedStatement stmt = conn.prepareStatement(s0);
                stmt.setString(1, table_id);
                stmt.setDouble(2, t.qty);
                stmt.setString(3, t.name);
                stmt.setString(4, t.desc);
                stmt.setDouble(5, t.price);
                stmt.setString(6, t.img_path);
                stmt.setString(7, "0");
                stmt.setString(8, guest_id);
                stmt.setString(9, guest_name);
                stmt.setString(10, t.cat_id);
                stmt.setString(11, now);
                stmt.setInt(12, t.printing_assembly);
                stmt.execute();
                my_amount += t.qty * t.price;
                Lg.s(S1_check_in.class, "Successfully Added");

                String s6 = "delete from " + MyDB.getNames() + ".customer_tables_details2 where table_no_id='" + room_id + "' and status<> '" + "1" + "' and product_name='" + t.name + "' ";
                PreparedStatement stmt6 = conn.prepareStatement(s6);
                stmt6.execute();

                String ctd_id = "-1";
                String s4 = "select max(id) from " + MyDB.getNames() + ".customer_tables_details";
                ResultSet rs4 = stmt.executeQuery(s4);
                while (rs4.next()) {
                    ctd_id = rs4.getString(1);
                }
                List<S2_search.to_items_status> subs = t.to_sub;
                for (S2_search.to_items_status to_customer_table_details_assembly : subs) {
                    String s5 = "insert into " + MyDB.getNames() + ".customer_table_details_assembly("
                            + "ctd_id"
                            + ",prod_num"
                            + ",description"
                            + ",price"
                            + ",product_qty"
                            + ",ref_num"
                            + ",status"
                            + ",table_no"
                            + ",is_selected"
                            + ")values("
                            + ":ctd_id"
                            + ",:prod_num"
                            + ",:description"
                            + ",:price"
                            + ",:product_qty"
                            + ",:ref_num"
                            + ",:status"
                            + ",:table_no"
                            + ",:is_selected"
                            + ")";

                    s5 = SqlStringUtil.parse(s5).
                            setString("ctd_id", ctd_id).
                            setString("prod_num", to_customer_table_details_assembly.name).
                            setString("description", to_customer_table_details_assembly.desc).
                            setNumber("price", to_customer_table_details_assembly.price).
                            setNumber("product_qty", to_customer_table_details_assembly.qty).
                            setString("ref_num", t.name).
                            setNumber("status", 0).
                            setString("table_no", table_no).
                            setBoolean("is_selected", to_customer_table_details_assembly.status).
                            ok();
                    PreparedStatement stmt5 = conn.prepareStatement(s5);
                    stmt5.execute();
                    Lg.s(S1_check_in.class, "Successfully Added");
                    String s7 = "delete from " + MyDB.getNames() + ".customer_table_details_assembly2 where ctd_id='" + ctd_id + "' and status<> '" + "1" + "' and prod_num='" + t.name + "' ";
                    PreparedStatement stmt7 = conn.prepareStatement(s7);
                    stmt7.execute();
                }

            }

        } catch (Exception e) {
            MyConnection1.close();
            throw new RuntimeException(e);
        } finally {
            MyConnection1.close();
        }
    }

    public static void update_room_order(String table_no) {
        try {
            Connection conn = MyConnection1.connect();
            String id = "0";
//            String s1="select id from "+MyDB.getNames()+".customer_tables where status='" + "0" + "' and table_no='"+table_no+"'";
//            Statement stmt1 = conn.createStatement();
//            ResultSet rs = stmt1.executeQuery(s1);
//            if (rs.next()) {
//               id = rs.getString(1);
//            }

            String s0 = "update " + MyDB.getNames() + ".customer_tables set status='" + "1" + "' where status='" + "0" + "' and id='" + table_no + "' ";
            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();

            String s1 = "update " + MyDB.getNames() + ".customer_tables_details set status='" + "1" + "' where table_no_id='" + table_no + "' ";
            PreparedStatement stmt1 = conn.prepareStatement(s1);
            stmt1.execute();
            Lg.s(S1_check_in.class, "ROOM PAYED");

        } catch (Exception e) {
            MyConnection1.close();
            throw new RuntimeException(e);
        } finally {
            MyConnection1.close();
        }
    }

    public static void main(String[] args) {
        MyDB.setNames("db_pos_restaurant_liquid");
        System.out.println(increment_id());
    }

    public static String increment_id() {
        String id = "000000";
        try {
            Connection conn = MyConnection1.connect();
            String s0 = "select max(id) from " + MyDB.getNames() + ".customer_tables_details";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            if (rs.next()) {
                id = rs.getString(1);
                String s2 = "select order_no from " + MyDB.getNames() + ".customer_tables_details where id='" + id + "'";
                Statement stmt2 = conn.createStatement();
                ResultSet rs2 = stmt2.executeQuery(s2);
                if (rs2.next()) {
                    id = rs2.getString(1);
                }
            }
            if (id == null || id.isEmpty()) {
                id = "000000";
            }
            id = ReceiptIncrementor.increment(id);
            return id;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection1.close();
        }
    }
}
