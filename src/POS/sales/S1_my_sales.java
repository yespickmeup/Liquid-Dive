/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.sales;

import POS.Main.MyDB;
import POS.to.to_users;
import POS.utl.DateType;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import POS.utl.MyConnection1;
import java.sql.SQLException;

/**
 *
 * @author i1
 */
public class S1_my_sales {

    public static class to_receipts {

        public final int id;
        public final int cashier_session_id;
        public final double tendered;
        public final String or_number;
        public final int receipt_status;
        public final String receipt_date;
        public final double discount;
        public final double credit;
        public final String approval_code;
        public final String member_id;
        public final String is_payed;
        public final double dollar;
        public final double peso;
        public final double bank_php;
        public final double bank_usd;
        public final String guest_names;
        public final String room_guest_ids;
        public final String table_id;
        public final String table_name;
        public final double credit_card;

        public to_receipts(int id, int cashier_session_id, double tendered, String or_number, int receipt_status, String receipt_date, double discount, double credit, String approval_code, String member_id, String is_payed, double dollar, double peso, double bank_php, double bank_usd, String guest_names, String room_guest_ids, String table_id, String table_name, double credit_card) {
            this.id = id;
            this.cashier_session_id = cashier_session_id;
            this.tendered = tendered;
            this.or_number = or_number;
            this.receipt_status = receipt_status;
            this.receipt_date = receipt_date;
            this.discount = discount;
            this.credit = credit;
            this.approval_code = approval_code;
            this.member_id = member_id;
            this.is_payed = is_payed;
            this.dollar = dollar;
            this.peso = peso;
            this.bank_php = bank_php;
            this.bank_usd = bank_usd;
            this.guest_names = guest_names;
            this.room_guest_ids = room_guest_ids;
            this.table_id = table_id;
            this.table_name = table_name;
            this.credit_card = credit_card;
        }
    }

    public static class to_details {

        public final double cashin;
        public final double expenses;
        public final double cashout;
        public final double addtl_cashins;
        public final double advance_payment;
        public final double advance_payment_usd;
        public final double outside_cash;
        public final double cc_reflenishment;
        public final double bank_php;
        public final double bank_usd;

        public to_details(double cashin, double expenses, double cashout, double addtl_cashins, double advance_payment, double advance_payment_usd, double outside_cash, double cc_reflenishment, double bank_php, double bank_usd) {
            this.cashin = cashin;
            this.expenses = expenses;
            this.cashout = cashout;
            this.addtl_cashins = addtl_cashins;
            this.advance_payment = advance_payment;
            this.advance_payment_usd = advance_payment_usd;
            this.outside_cash = outside_cash;
            this.cc_reflenishment = cc_reflenishment;
            this.bank_php = bank_php;
            this.bank_usd = bank_usd;
        }
    }

    public static class to_sales {

        public final double peso;
        public final double dollar;
        public final double credit;

        public to_sales(double peso, double dollar, double credit) {
            this.peso = peso;
            this.dollar = dollar;
            this.credit = credit;
        }
    }

    public static class to_receipt_items {

        public final int id;
        public final String receipt_id;
        public final String product_name;
        public final double unit_price;
        public final double qty;
        public final String type_name;
        public final String cat_name;
        public final String description;

        public to_receipt_items(int id, String receipt_id, String product_name, double unit_price, double qty, String type_name, String cat_name, String description) {
            this.id = id;
            this.receipt_id = receipt_id;
            this.product_name = product_name;
            this.unit_price = unit_price;
            this.qty = qty;
            this.type_name = type_name;
            this.cat_name = cat_name;
            this.description = description;
        }
    }

    public static List<to_receipts> ret_data(String session_id, String date_from, String date_to, String user_name) {
        List<to_receipts> datas = new ArrayList();

        try {
            Connection conn = MyConnection1.connect();
            String s0 = "select "
                    + "id"
                    + ",cashier_session_id"
                    + ",tendered"
                    + ",or_number"
                    + ",receipt_status"
                    + ",receipt_date"
                    + ",discount"
                    + ",credit"
                    + ",approval_code"
                    + ",member_id"
                    + ",is_payed"
                    + ",dollar"
                    + ",credit_dollar"
                    + ",peso"
                    + ",bank_php"
                    + ",bank_usd"
                    + ",guest_names"
                    + ",room_guest_ids"
                    + ",table_id"
                    + ",table_name"
                    + ",credit_card"
                    + " from " + MyDB.getNames() + ".receipts where "
                    + " Date(receipt_date) between '" + date_from + "' and '" + date_to + "' "
                    + "and user_name like '%" + user_name + "%'"
                    + " ";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                int cashier_session_id = rs.getInt(2);
                double tendered = rs.getDouble(3);
                String or_number = rs.getString(4);
                int receipt_status = rs.getInt(5);
                Date d = new Date();
                String receipt_date = rs.getString(6);
                d = DateType.datetime.parse(receipt_date);

                receipt_date = DateType.time.format(d);
                double discount = rs.getDouble(7);
                double credit = rs.getDouble(8);

                String approval_code = rs.getString(9);
                String member_id = rs.getString(10);
                String is_payed = rs.getString(11);
                double dollar = rs.getDouble(12);
                double credit_dollar = rs.getDouble(13);
                double peso = rs.getDouble(14);
                double bank_php = rs.getDouble(15);
                double bank_usd = rs.getDouble(16);
//                credit += credit_dollar;
                String guest_names = rs.getString(17);
                String room_guest_ids = rs.getString(18);
                String table_id = rs.getString(19);
                String table_name = rs.getString(20);
                double credit_card = rs.getDouble(21);
                to_receipts to = new to_receipts(id, cashier_session_id, tendered, or_number, receipt_status, receipt_date, discount, credit, approval_code, member_id, is_payed, dollar, peso, bank_php, bank_usd, guest_names, room_guest_ids, table_id, table_name, credit_card);
                datas.add(to);
            }
            return datas;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection1.close();
        }
    }

    public static List<to_receipts> ret_data_date(String date_from, String date_to) {
        List<to_receipts> datas = new ArrayList();

        String user_name = to_users.ret_user(to_users.username1);
        try {
            Connection conn = MyConnection1.connect();
            String s0 = "select "
                    + "id"
                    + ",cashier_session_id"
                    + ",tendered"
                    + ",or_number"
                    + ",receipt_status"
                    + ",receipt_date"
                    + ",discount"
                    + ",credit"
                    + ",approval_code"
                    + ",member_id"
                    + ",is_payed"
                    + ",dollar"
                    + ",credit_dollar"
                    + ",peso"
                    + ",bank_php"
                    + ",bank_usd"
                    + ",guest_names"
                    + ",room_guest_ids"
                    + ",table_id"
                    + ",table_name"
                    + ",credit_card"
                    + " from " + MyDB.getNames() + ".receipts where "
                    + " user_name ='" + user_name + "' and Date(receipt_date) between '" + date_from + "' and '" + date_to + "'"
                    + " ";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                int cashier_session_id = rs.getInt(2);
                double tendered = rs.getDouble(3);
                String or_number = rs.getString(4);
                int receipt_status = rs.getInt(5);
                Date d = new Date();
                String receipt_date = rs.getString(6);
                d = DateType.datetime.parse(receipt_date);

                receipt_date = DateType.time.format(d);
                double discount = rs.getDouble(7);
                double credit = rs.getDouble(8);

                String approval_code = rs.getString(9);
                String member_id = rs.getString(10);
                String is_payed = rs.getString(11);
                double dollar = rs.getDouble(12);
                double credit_dollar = rs.getDouble(13);
                double peso = rs.getDouble(14);
                double bank_php = rs.getDouble(15);
                double bank_usd = rs.getDouble(16);
//                credit += credit_dollar;
                String guest_names = rs.getString(17);
                String room_guest_ids = rs.getString(18);
                String table_id = rs.getString(19);
                String table_name = rs.getString(20);
                double credit_card = rs.getDouble(21);
                to_receipts to = new to_receipts(id, cashier_session_id, tendered, or_number, receipt_status, receipt_date, discount, credit, approval_code, member_id, is_payed, dollar, peso, bank_php, bank_usd, guest_names, room_guest_ids, table_id, table_name, credit_card);
                datas.add(to);
            }
            return datas;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection1.close();
        }
    }

    public static List<to_receipt_items> ret_items(String receipt_no) {
        List<to_receipt_items> datas = new ArrayList();
        try {
            Connection conn = MyConnection1.connect();
            String s0 = "select "
                    + "id"
                    + ",receipt_id"
                    + ",product_name"
                    + ",unit_price"
                    + ",qty"
                    + ",type_name"
                    + ",cat_name"
                    + ",description"
                    + " from " + MyDB.getNames() + ".receipt_items where "
                    + " receipt_id ='" + receipt_no + "' "
                    + " ";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String receipt_id = rs.getString(2);
                String product_name = rs.getString(3);
                double unit_price = rs.getDouble(4);
                double qty = rs.getDouble(5);
                String type_name = rs.getString(6);
                String cat_name = rs.getString(7);
                String description = rs.getString(8);
                to_receipt_items to = new to_receipt_items(id, receipt_id, product_name, unit_price, qty, type_name, cat_name, description);
                datas.add(to);
            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection1.close();
        }
    }

    public static to_details ret_cash_in(String user_names, String date_from, String date_to) {
//        double cashin = 0;
        to_details to = new to_details(0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        double cashin = 0;
        double expenses = 0;
        double cashout = 0;
        double addtl_cashins = 0;
        double advance_payment = 0;
        double advance_payment_usd = 0;
        double bank_php = 0;
        double bank_usd = 0;
        try {
            Connection conn = MyConnection1.connect();
            String s0 = "select "
                    + "sum(cash_in)"
                    + " from " + MyDB.getNames() + ".cash_drawer where "
                    + " Date(date_added) between '" + date_from + "' and '" + date_to + "' and user_name like '%" + user_names + "%' "
                    + " ";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            if (rs.next()) {
                cashin = rs.getDouble(1);
            }
//            return cashin;

            String s2 = "select "
                    + "sum(amount)"
                    + " from " + MyDB.getNames() + ".expenses where "
                    + " Date(date_added) between '" + date_from + "' and '" + date_to + "' and user_name like '%" + user_names + "%' "
                    + " ";

            Statement stmt2 = conn.createStatement();
            ResultSet rs2 = stmt2.executeQuery(s2);
            if (rs2.next()) {
                expenses = rs2.getDouble(1);
            }

            String s3 = "select "
                    + "sum(amount)"
                    + " from " + MyDB.getNames() + ".cashouts where "
                    + " Date(date_added) between '" + date_from + "' and '" + date_to + "'  and user_name like '%" + user_names + "%'"
                    + " ";

            Statement stmt3 = conn.createStatement();
            ResultSet rs3 = stmt3.executeQuery(s3);
            if (rs3.next()) {
                cashout = rs3.getDouble(1);
            }

            String s4 = "select "
                    + "sum(amount)"
                    + " from " + MyDB.getNames() + ".addt_cashins where "
                    + " Date(date_added) between '" + date_from + "' and '" + date_to + "' and user_name like '%" + user_names + "%'"
                    + " ";

            Statement stmt4 = conn.createStatement();
            ResultSet rs4 = stmt4.executeQuery(s4);
            if (rs4.next()) {
                addtl_cashins = rs4.getDouble(1);
            }

            String s5 = "select "
                    + "sum(amount_paid)"
                    + ",sum(peso_on_bank)"
                    + ",sum(usd_on_bank)"
                    + " from " + MyDB.getNames() + ".guest_advance_payment where "
                    + " Date(date_added) between '" + date_from + "' and '" + date_to + "' and user_name like '%" + user_names + "%'"
                    + " ";
            Statement stmt5 = conn.createStatement();
            ResultSet rs5 = stmt5.executeQuery(s5);
            if (rs5.next()) {
                advance_payment = rs5.getDouble(1);
                bank_php = rs5.getDouble(2);
                bank_usd = rs5.getDouble(3);
            }

            String s6 = "select "
                    + "sum(usd)"
                    + " from " + MyDB.getNames() + ".guest_advance_payment where "
                    + " Date(date_added) between '" + date_from + "' and '" + date_to + "' and user_name like '%" + user_names + "%'"
                    + " ";
            Statement stmt6 = conn.createStatement();
            ResultSet rs6 = stmt6.executeQuery(s6);
            if (rs6.next()) {
                advance_payment_usd = rs6.getDouble(1);
            }

            String s7 = "select "
                    + "sum(amount)"
                    + " from " + MyDB.getNames() + ".outside_cashs where "
                    + " Date(date_added) between '" + date_from + "' and '" + date_to + "'"
                    + " ";
            double outside_cash = 0;
            Statement stmt7 = conn.createStatement();
            ResultSet rs7 = stmt7.executeQuery(s7);
            if (rs7.next()) {
                outside_cash = rs7.getDouble(1);
            }
            String s8 = "select "
                    + "sum(amount)"
                    + " from " + MyDB.getNames() + ".credit_card_ins where "
                    + " Date(date_added) between '" + date_from + "' and '" + date_to + "'"
                    + " ";
            double cc_reflenishment = 0;
            Statement stmt8 = conn.createStatement();
            ResultSet rs8 = stmt8.executeQuery(s8);
            if (rs8.next()) {
                cc_reflenishment = rs8.getDouble(1);
            }

//            String s10 = "select "
//                    + "sum(bank_php)"
//                    + " from " + MyDB.getNames() + ".receipts where "
//                    + " Date(receipt_date) between '" + date_from + "' and '" + date_to + "' and user_name like '%" + user_names + "%'"
//                    + " ";
//            Statement stmt10 = conn.createStatement();
//            ResultSet rs10 = stmt10.executeQuery(s10);
//            if (rs10.next()) {
//                bank_php = rs10.getDouble(1);
//            }
//
//            String s11 = "select "
//                    + "sum(bank_usd)"
//                    + " from " + MyDB.getNames() + ".receipts where "
//                    + " Date(receipt_date) between '" + date_from + "' and '" + date_to + "' and user_name like '%" + user_names + "%'"
//                    + " ";
//            Statement stmt11 = conn.createStatement();
//            ResultSet rs11 = stmt11.executeQuery(s11);
//            if (rs11.next()) {
//                bank_usd = rs11.getDouble(1);
//            }

            to = new to_details(cashin, expenses, cashout, addtl_cashins, advance_payment, advance_payment_usd, outside_cash, cc_reflenishment, bank_php, bank_usd);

        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection1.close();
        }
        return to;
    }

    public static to_sales ret_sales(String user_names, String date_from, String date_to, String cashier_session_id) {
//        double cashin = 0;
        to_sales to = new to_sales(0, 0, 0);
        double peso = 0;
        double dollar = 0;
        double credit = 0;
//        double addtl_cashins = 0;
        try {
            Connection conn = MyConnection1.connect();
            String s0 = "select "
                    + "sum(dollar)"
                    + ",sum(credit)"
                    + ",sum(peso)"
                    + " from " + MyDB.getNames() + ".receipts where "
                    + " Date(receipt_date) between '" + date_from + "' and '" + date_to + "' "
                    + " and cashier_session_id ='" + cashier_session_id + "' "
                    + " ";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            if (rs.next()) {
                peso = rs.getDouble(3);
                dollar = rs.getDouble(1);
                credit = rs.getDouble(2);
                System.out.println(peso);
            }
            to = new to_sales(peso, dollar, credit);

        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection1.close();
        }
        return to;
    }

    public static double ret_cash_in_date(String date_from, String date_to) {
        String user_name = to_users.ret_user(to_users.username1);
        double cashin = 0;
        try {
            Connection conn = MyConnection1.connect();
            String s0 = "select "
                    + "sum(cash_in)"
                    + " from " + MyDB.getNames() + ".cash_drawer where "
                    + " Date(date_added) between '" + date_to + "' and '" + date_to + "' and user_name='" + user_name + "' "
                    + " ";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            if (rs.next()) {
                cashin = rs.getDouble(1);
            }
            return cashin;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection1.close();
        }
    }

    public static double ret_expenses(String cashier_session, String date_from, String date_to) {
        double cashin = 0;
        try {
            Connection conn = MyConnection1.connect();
            String s0 = "select "
                    + "sum(amount)"
                    + " from " + MyDB.getNames() + ".expenses where "
                    + " Date(date_added) between '" + date_from + "' and '" + date_to + "' "
                    + " ";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            if (rs.next()) {
                cashin = rs.getDouble(1);
            }
            return cashin;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection1.close();
        }
    }

    public static double ret_expenses_date(String date_from, String date_to) {
        String user_name = to_users.ret_user(to_users.username1);
        double cashin = 0;
        try {
            Connection conn = MyConnection1.connect();
            String s0 = "select "
                    + "sum(amount)"
                    + " from " + MyDB.getNames() + ".expenses where "
                    + " Date(date_added) between '" + date_to + "' and '" + date_to + "' and user_name='" + user_name + "' "
                    + " ";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            if (rs.next()) {
                cashin = rs.getDouble(1);
            }
            return cashin;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection1.close();
        }
    }

    public static double ret_cashout(String cashier_session, String date_from, String date_to) {
        double cashin = 0;
        try {
            Connection conn = MyConnection1.connect();
            String s0 = "select "
                    + "sum(amount)"
                    + " from " + MyDB.getNames() + ".cashouts where "
                    + " Date(date_added) between '" + date_from + "' and '" + date_to + "' "
                    + " ";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            if (rs.next()) {
                cashin = rs.getDouble(1);
            }
            return cashin;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection1.close();
        }
    }

    public static double ret_addtl_cash(String cashier_session, String date_from, String date_to) {
        double cashin = 0;
        try {
            Connection conn = MyConnection1.connect();
            String s0 = "select "
                    + "sum(amount)"
                    + " from " + MyDB.getNames() + ".addt_cashins where "
                    + " Date(date_added) between '" + date_from + "' and '" + date_to + "' "
                    + " ";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            if (rs.next()) {
                cashin = rs.getDouble(1);
            }
            return cashin;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection1.close();
        }
    }

    public static double ret_cashout_date(String date_from, String date_to) {
        double cashin = 0;
        String user_name = to_users.ret_user(to_users.username1);
        try {
            Connection conn = MyConnection1.connect();
            String s0 = "select "
                    + "sum(amount)"
                    + " from " + MyDB.getNames() + ".cashouts where "
                    + " Date(date_added) between '" + date_to + "' and '" + date_to + "' and user_name='" + user_name + "' "
                    + " ";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            if (rs.next()) {
                cashin = rs.getDouble(1);
            }
            return cashin;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection1.close();
        }
    }

    public static void main(String[] args) {
//        Main.MyDB.setNames("db_pos_restaurant");
        System.out.println(ret_cb_data());
    }

    public static List<String> ret_cb_data() {

        String user_level = "";
        if (to_users.user_level1 == null) {
            user_level = "5";
        } else {
            user_level = to_users.user_level1;
        }

//        JOptionPane.showMessageDialog(null, user_level);
        List<String> datas = new ArrayList();
        datas.add("ALL");
        try {
            Connection conn = MyConnection1.connect();
            String s0 = "";
//            if (user_level.equals("5")) {
            s0 = "select user_code from " + MyDB.getNames() + ".users where user_level<>'" + "1" + "'";
//            }
//            } else {
//                s0 = "select user_code from " + MyDB.getNames() + ".users where user_level='" + "6" + "'";
//            }
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                String id = rs.getString(1);
                datas.add(id);
//                System.out.println(id);
            }
//            JOptionPane.showMessageDialog(null, datas.size());
            return datas;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection1.close();
        }
    }

    public static List<String> ret_cb_data2() {

        String user_level = "";
        if (to_users.user_level1 == null) {
            user_level = "5";
        } else {
            user_level = to_users.user_level1;
        }

//        JOptionPane.showMessageDialog(null, user_level);
        List<String> datas = new ArrayList();
        datas.add("ALL");
        try {
            Connection conn = MyConnection1.connect();
            String s0 = "";
//            if (user_level.equals("5")) {
            s0 = "select user_code from " + MyDB.getNames() + ".users where user_level<>'" + "1" + "'";
//            } 
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                String id = rs.getString(1);
                datas.add(id);
//                System.out.println(id);
            }
            return datas;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection1.close();
        }
    }

    public static List<String> ret_cashier() {
        List<String> datas = new ArrayList();
//        datas.add("ALL");
        try {
            Connection conn = MyConnection1.connect();
            String s0 = "select user_code from " + MyDB.getNames() + ".users where user_level='" + "0" + "'";
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
