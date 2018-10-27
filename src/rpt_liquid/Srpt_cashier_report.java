/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rpt_liquid;

import POS.Main;
import POS.currency.S1_currency;
import POS.receipts.Receipts;
import POS.sales.S1_my_sales;
import POS.to.to_users;
import POS.utl.DateType;
import POS.utl.MyConnection1;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JFrame;
import mijzcx.synapse.desk.utils.Application;
import mijzcx.synapse.desk.utils.JasperUtil;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.swing.JRViewer;

/**
 *
 * @author i1
 */
public class Srpt_cashier_report {

    public final String SUBREPORT_DIR;
    public final List<Srpt_credits.field> rpt_credits;
    public final List<Srpt_expenses.field> rpt_expenses;
    public final List<Srpt_advance_payments.field> rpt_advances;
    public final Date date_from;
    public final Date date_to;
    public final String busi_name;
    public final String my_db;
    public final double dollar;
    public final double tendered;
    public final double discount;
    public final double credit;
    public final double foods;
    public final double beverages;
    public final double expences;
    public final double tot_bev;
    public final double net_total;
    public final String user_name;
    public final List<Srpt_cashiers.field> rpt_cashiers;
    public final double cashin;
    public final double cashout;
    public final double addtl_cashin;
    public final double dollars;
    public final double gross;
    public final double advance_payment;
    public final double advance_payment_usd;
    public final String cashier_name;
    public final double outside_cash;
    public final double cc_reflenishment;
    public final double bank_php;
    public final double bank_usd;
    public final double credit_card;
    public final double dollar_rate;
    public final double total_dollars;
    public Srpt_cashier_report(String SUBREPORT_DIR, List<Srpt_credits.field> rpt_credits, List<Srpt_expenses.field> rpt_expenses, List<Srpt_advance_payments.field> rpt_advances, Date date_from, Date date_to, String busi_name, String my_db, double dollar, double tendered, double discount, double credit, double foods, double beverages, double expences, double tot_bev, double net_total, String user_name, List<Srpt_cashiers.field> rpt_cashiers, double cashin, double cashout, double addtl_cashin, double dollars, double gross, double advance_payment, double advance_payment_usd, String cashier_name, double outside_cash, double cc_reflenishment, double bank_php, double bank_usd, double credit_card, double dollar_rate,double total_dollars) {
        this.SUBREPORT_DIR = SUBREPORT_DIR;
        this.rpt_credits = rpt_credits;
        this.rpt_expenses = rpt_expenses;
        this.rpt_advances = rpt_advances;
        this.date_from = date_from;
        this.date_to = date_to;
        this.busi_name = busi_name;
        this.my_db = my_db;
        this.dollar = dollar;
        this.tendered = tendered;
        this.discount = discount;
        this.credit = credit;
        this.foods = foods;
        this.beverages = beverages;
        this.expences = expences;
        this.tot_bev = tot_bev;
        this.net_total = net_total;
        this.user_name = user_name;
        this.rpt_cashiers = rpt_cashiers;
        this.cashin = cashin;
        this.cashout = cashout;
        this.addtl_cashin = addtl_cashin;
        this.dollars = dollars;
        this.gross = gross;
        this.advance_payment = advance_payment;
        this.advance_payment_usd = advance_payment_usd;
        this.cashier_name = cashier_name;
        this.outside_cash = outside_cash;
        this.cc_reflenishment = cc_reflenishment;
        this.bank_php = bank_php;
        this.bank_usd = bank_usd;
        this.credit_card = credit_card;
        this.dollar_rate = dollar_rate;
        this.total_dollars=total_dollars;
    }

    public static class field {

        String cashier_name;
        double sales;

        public field() {
        }

        public field(String cashier_name, double sales) {
            this.cashier_name = cashier_name;
            this.sales = sales;
        }

        public String getCashier_name() {
            return cashier_name;
        }

        public void setCashier_name(String cashier_name) {
            this.cashier_name = cashier_name;
        }

        public double getSales() {
            return sales;
        }

        public void setSales(double sales) {
            this.sales = sales;
        }
    }

    public static Srpt_cashier_report ret_data_session(String session_id, Date date_from, Date date_to, String busi_name, double dollar, String dfrom, String dto, List<S1_my_sales.to_receipts> receipts, double tendered, double discount, double credit, double expences, String users, double cashin, double cashout, double addtl_cashin, double dollars, double gross, double advance_payment, double advance_payment_usd, double outside_cash, double cc_reflenishment, double bank_php, double bank_usd, double credit_card, double dollar_rate1,double total_dollars) {

        String SUBREPORT_DIR = System.getProperty("img_path", "C:\\Users\\Guinness\\") + "img_templates\\rpt\\";
        Srpt_cashier_report to1 = new Srpt_cashier_report(SUBREPORT_DIR, new ArrayList(), new ArrayList(), new ArrayList(), new Date(), new Date(), "", "", 0, 0, 0, 0, 0, 0, 0, 0, 0, "", new ArrayList(), 0, 0, 0, 0, 0, 0, 0, "", 0, 0, 0, 0, 0, dollar_rate1,total_dollars);
        String user = to_users.username1;
        try {
            Connection conn = MyConnection1.connect();

//            double tendered = 0;
//            double discount = 0;
//            double credit = 0;
            double foods = 0;
            double beverages = 0;
//            double expences = 0;
            double my_dollar = 0;

            for (S1_my_sales.to_receipts t : receipts) {

//                System.out.println("**** " + t.id + " " + t.tendered);
                String s2 = "select "
                        + "qty"
                        + ",unit_price"
                        + ",cat_name"
                        + ",group_id"
                        + " from " + Main.MyDB.getNames() + ".receipt_items where "
                        + " receipt_id ='" + t.id + "' "
                        + " ";
//                Statement stmt2 = conn.createStatement();
//                ResultSet rs2 = stmt2.executeQuery(s2);
//                while (rs2.next()) {
//
//                    double qty = rs2.getDouble(1);
//                    double unit_price = rs2.getDouble(2);
//                    String cat_name = rs2.getString(3);
//                    System.out.println("" + qty * unit_price);
//                    int group_id = rs2.getInt(4);
//                    //                    System.out.println(qty + " * " + unit_price + " = " + (qty * unit_price));
////                    System.out.println(t.or_number + " - "+ qty+ " - "+ unit_price + " "+qty*unit_price);
//                    if (group_id == 1) {
//                        beverages += (qty * unit_price);
//                    } else {
////                        JOptionPane.showMessageDialog(null, qty +" - "+ unit_price);
//                        foods += (qty * unit_price);
//                    }
//
//                }
            }

//            JOptionPane.showMessageDialog(null, session_id);
//            String s3 = "select sum(amount) from " + Main.MyDB.getNames() + ".expenses where  Date(date_added) between '" + dfrom + "' and '" + dto + "'";
//            Statement stmt3 = conn.createStatement();
//            ResultSet rs3 = stmt3.executeQuery(s3);
//            if (rs3.next()) {
//                expences = rs3.getDouble(1);
//            }
            String user_name = "";
            if (to_users.username1 == null) {
                user_name = "Ronald Pascua";
            } else {
                user_name = to_users.ret_data(to_users.username1);
            }

//            System.out.println(tendered + " " + discount + " " + credit + " " + foods + " " + beverages + " " + expences);
           
            double net = ((tendered + discount) - credit) - expences;
           
//            dollar = S1_currency.ret_dollar(DateType.sf.format(new Date()));

//            String SUBREPORT_DIR = System.getProperty("img_path", "C:\\Users\\i1\\") + "img_templates\\rpt\\";s
//            JOptionPane.showMessageDialog(null, SUBREPORT_DIR);
            List<Srpt_credits.field> rpt_credits = new ArrayList();
            String s4 = "select "
                    + "or_no"
                    + ",bank_name"
                    + ",card_holder"
                    + ",card_no"
                    + ",approval_code"
                    + ",amount"
                    + ",dollar_amount"
                    + ",dollar_rate"
                    + " from " + Main.MyDB.getNames() + ".credits where   "
                    + "Date(date_payed) between '" + dfrom + "' and '" + dto + "'"
                    + "and user_name like '%" + users + "%'"
                    + " ";
            Statement stmt4 = conn.createStatement();
            ResultSet rs4 = stmt4.executeQuery(s4);
            while (rs4.next()) {
                String trans_no = rs4.getString(1);
                String card_type = rs4.getString(2);
                String card_holder = rs4.getString(3);
                String card_no = rs4.getString(4);
                String approval_code = rs4.getString(5);
                double amount = rs4.getDouble(6);
                double additional = rs4.getDouble(7);
                double dollar_rate = rs4.getDouble(8);
//                System.out.println(approval_code);

                Srpt_credits.field to = new Srpt_credits.field(trans_no, card_type, card_holder, card_no, approval_code, amount, additional, dollar_rate);
                rpt_credits.add(to);
            }

            List<Srpt_expenses.field> rpt_expenses = new ArrayList();
            String s5 = "select "
                    + "date_added"
                    + ",amount"
                    + ",purpose"
                    + ",category_name"
                    + ",vat"
                    + " from " + Main.MyDB.getNames() + ".expenses where "
                    + "  Date(date_added) between '" + dfrom + "' and '" + dto + "' "
                    + "and user_name like '%" + users + "%' order by category_name asc"
                    + " ";

            Statement stmt5 = conn.createStatement();
            ResultSet rs5 = stmt5.executeQuery(s5);
            while (rs5.next()) {
                Date d = new Date();
                d = DateType.datetime.parse(rs5.getString(1));
                String date_added = DateType.time.format(d);
                double amount = rs5.getDouble(2);
                String purpose = rs5.getString(3);
                String category_name = rs5.getString(4);
                String vat = rs5.getString(5);

                Srpt_expenses.field to = new Srpt_expenses.field(date_added, amount, purpose, category_name, vat);
//                System.out.println(amount);
                rpt_expenses.add(to);
            }

            List<Srpt_advance_payments.field> advance_payments = new ArrayList();
            String s10 = "select "
                    + "date_added"
                    + ",amount_paid"
                    + ",peso_on_bank"
                    + ",usd"
                    + ",usd_on_bank"
                    + ",bank"
                    + ",approval_code"
                    + ",credit_amount"
                    + ",guest_name"
                    + " from " + Main.MyDB.getNames() + ".guest_advance_payment where "
                    + "Date(date_added) between '" + dfrom + "' and '" + dto + "' "
                    + "and user_name like '%" + users + "%' "
                    //                    + "order by category_name asc"
                    + " ";

            Statement stmt10 = conn.createStatement();
            ResultSet rs10 = stmt10.executeQuery(s10);
            while (rs10.next()) {
                String date_added = DateType.convert_jan_1_2013_datetime(rs10.
                        getString(1));
                double php_cash = rs10.getDouble(2);
                double php_bank = rs10.getDouble(3);
                double usd_cash = rs10.getDouble(4);
                double usd_bank = rs10.getDouble(5);
                String bank = rs10.getString(6);
                String approval_code = rs10.getString(7);
                double credit_card1 = rs10.getDouble(8);
                String guest = rs10.getString(9);

                Srpt_advance_payments.field to = new Srpt_advance_payments.field(date_added, php_cash, php_bank, usd_cash, usd_bank, bank, approval_code, credit_card1, guest);
//                System.out.println(amount);
                advance_payments.add(to);
            }

            List<String> datas = S1_my_sales.ret_cashier();
            List<Srpt_cashiers.field> data = new ArrayList();
            for (String s : datas) {
//                System.out.println(s);
//                Srpt_cashier_report.field.
                users = to_users.ret_user(s);
                double am = 0;
                String s6 = "select sum(peso) from " + Main.MyDB.getNames() + ".receipts where Date(receipt_date) between '" + dfrom + "' and '" + dto + "'"
                        + " and user_name like '%" + users + "%'";
                Statement stmt6 = conn.createStatement();
                ResultSet rs6 = stmt6.executeQuery(s6);
                if (rs6.next()) {
                    am = rs6.getDouble(1);
                }
                Srpt_cashiers.field t = new Srpt_cashiers.field(s, am);
                data.add(t);
            }

//            JOptionPane.showMessageDialog(null, dollar);
//            String SUBREPORT_DIR = System.getProperty("img_path", "C:\\Users\\Maytopacka\\") + "img_templates\\rpt\\";
            gross = (credit + discount + tendered + advance_payment + bank_php + credit_card) - expences;
           
           
//            System.out.println("dollars: "+dollars + " ,advance_payment_usd: "+advance_payment_usd+ " , bank_usd: "+bank_usd+ " ,dollar_rate1: "+dollar_rate1);
            
            to1 = new Srpt_cashier_report(SUBREPORT_DIR, rpt_credits, rpt_expenses, advance_payments, date_from, date_to, busi_name, user_name, dollar, tendered, discount, credit, foods, beverages, expences, (foods + beverages), net, user, data, cashin, cashout, addtl_cashin, dollar, gross, advance_payment, advance_payment_usd, to_users.username1, outside_cash, cc_reflenishment, bank_php, bank_usd, credit_card, dollar_rate1,total_dollars);

            return to1;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection1.close();
        }
    }

    public static Srpt_cashier_report ret_data_date(String session_id, Date date_from, Date date_to, String busi_name, double dollar, String dfrom, String dto) {
        Srpt_cashier_report to1 = new Srpt_cashier_report("", new ArrayList(), new ArrayList(), new ArrayList(), new Date(), new Date(), "", "", 0, 0, 0, 0, 0, 0, 0, 0, 0, "", new ArrayList(), 0, 0, 0, 0, 0, 0, 0, "", 0, 0, 0, 0, 0, 0,0);

        String user = to_users.username1;
        String user_name = to_users.ret_user(to_users.username1);

        try {
            Connection conn = MyConnection1.connect();

            double tendered = 0;
            double discount = 0;
            double credit = 0;
            double foods = 0;
            double beverages = 0;
            double expences = 0;
            double my_dollar = 0;

            String s0 = "select "
                    + "(peso)"
                    + ",(discount)"
                    + ",(credit)"
                    + ",or_number"
                    + ",(dollar)"
                    + ",(credit_dollar)"
                    + " from " + Main.MyDB.getNames() + ".receipts where "
                    + " user_name ='" + user_name + "' and Date(receipt_date) between '" + dfrom + "' and '" + dto + "'"
                    + " ";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                tendered += rs.getDouble(1);
                discount += rs.getDouble(2);
                credit += (rs.getDouble(3));
                my_dollar += rs.getDouble(5);
                String receipt_id = rs.getString(4);
                String s2 = "select "
                        + "qty"
                        + ",unit_price"
                        + ",cat_name"
                        + ",group_id"
                        + " from " + Main.MyDB.getNames() + ".receipt_items where "
                        + " receipt_id ='" + receipt_id + "' "
                        + " ";

                Statement stmt2 = conn.createStatement();
                ResultSet rs2 = stmt2.executeQuery(s2);
                while (rs2.next()) {
                    double qty = rs2.getDouble(1);
                    double unit_price = rs2.getDouble(2);
                    String cat_name = rs2.getString(3);
                    int group_id = rs2.getInt(4);
                    //                    System.out.println(qty + " * " + unit_price + " = " + (qty * unit_price));
                    if (group_id == 1) {
                        beverages += (qty * unit_price);
                    } else {
                        foods += (qty * unit_price);
                    }
                }
            }
//            JOptionPane.showMessageDialog(null, session_id);
            String s3 = "select sum(amount) from " + Main.MyDB.getNames() + ".expenses where user_name='" + user_name + "' and Date(date_added) between '" + dfrom + "' and '" + dto + "'";
            Statement stmt3 = conn.createStatement();
            ResultSet rs3 = stmt3.executeQuery(s3);
            if (rs3.next()) {
                expences = rs3.getDouble(1);
            }

//            String user_name = "";
//            if (to_users.username1 == null) {
//                user_name = "Ronald Pascua";
//            } else {
//                user_name = to_users.ret_data(to_users.username1);
//            }
//            System.out.println(tendered + " " + discount + " " + credit + " " + foods + " " + beverages + " " + expences);
            double net = ((tendered + discount) - credit) - expences;
            dollar = S1_currency.ret_dollar(DateType.sf.format(new Date()));

            String SUBREPORT_DIR = System.getProperty("img_path", "C:\\Users\\i1\\") + "img_templates\\rpt\\";
//            JOptionPane.showMessageDialog(null, SUBREPORT_DIR);
            List<Srpt_credits.field> rpt_credits = new ArrayList();
            String s4 = "select "
                    + "or_no"
                    + ",card_type"
                    + ",card_holder"
                    + ",card_no"
                    + ",approval_code"
                    + ",amount"
                    + ",dollar_amount"
                    + ",dollar_rate"
                    + " from " + Main.MyDB.getNames() + ".credits where user_name='" + user_name + "' and Date(date_payed) between '" + dfrom + "' and '" + dto + "'"
                    + " ";
            Statement stmt4 = conn.createStatement();
            ResultSet rs4 = stmt4.executeQuery(s4);
            while (rs4.next()) {
                String trans_no = rs4.getString(1);
                String card_type = rs4.getString(2);
                String card_holder = rs4.getString(3);
                String card_no = rs4.getString(4);
                String approval_code = rs4.getString(5);
                double amount = rs4.getDouble(6);
                double additional = rs4.getDouble(7);
                double dollar_rate = rs4.getDouble(8);
//                System.out.println(approval_code);
                Srpt_credits.field to = new Srpt_credits.field(trans_no, card_type, card_holder, card_no, approval_code, amount, additional, dollar_rate);
                rpt_credits.add(to);
            }

            List<Srpt_expenses.field> rpt_expenses = new ArrayList();

            String s5 = "select "
                    + "date_added"
                    + ",amount"
                    + ",purpose"
                    + ",category_name"
                    + ",vat"
                    + " from " + Main.MyDB.getNames() + ".expenses where "
                    + " user_name ='" + user_name + "' and Date(date_added) between '" + dfrom + "' and '" + dto + "'"
                    + " ";

            Statement stmt5 = conn.createStatement();
            ResultSet rs5 = stmt5.executeQuery(s5);
            while (rs5.next()) {
                Date d = new Date();
                d = DateType.datetime.parse(rs5.getString(1));
                String date_added = DateType.time.format(d);
                double amount = rs5.getDouble(2);
                String purpose = rs5.getString(3);
                String category_name = rs5.getString(4);
                String vat = rs5.getString(5);

                Srpt_expenses.field to = new Srpt_expenses.field(date_added, amount, purpose, category_name, vat);
                System.out.println(amount);
                rpt_expenses.add(to);
            }

            to1 = new Srpt_cashier_report(SUBREPORT_DIR, rpt_credits, rpt_expenses, new ArrayList(), date_from, date_to, busi_name, user_name, my_dollar, tendered, discount, credit, foods, beverages, expences, (foods + beverages), net, user, new ArrayList(), 0, 0, 0, dollar, 0, 0, 0, "", 0, 0, 0, 0, 0, 0,0);
            return to1;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection1.close();
        }
    }

    public static void main(String[] args) {

//        Main.MyDB.setNames("db_pos_restaurant");
        String session_id = "1";
        Date date_from = new Date();
        Date date_to = new Date();
        String busi_name = "";
        double dollar = 0;
        String dfrom = "2013-01-21";
        String dto = "2013-01-21";
        Srpt_cashier_report to1 = new Srpt_cashier_report("", new ArrayList(), new ArrayList(), new ArrayList(), new Date(), new Date(), "", "", 0, 0, 0, 0, 0, 0, 0, 0, 0, "", new ArrayList(), 0, 0, 0, 0, 0, 0, 0, "", 0, 0, 0, 0, 0, 0,0);

        try {
            Connection conn = MyConnection1.connect();

            double tendered = 0;
            double discount = 0;
            double credit = 0;
            double foods = 0;
            double beverages = 0;
            double expences = 0;
            double my_dollar = 0;

            String s0 = "select "
                    + "(peso)"
                    + ",(discount)"
                    + ",(credit)"
                    + ",or_number"
                    + ",(dollar)"
                    + ",(credit_dollar)"
                    + " from " + Main.MyDB.getNames() + ".receipts where "
                    + " cashier_session_id ='" + session_id + "' and Date(receipt_date) between '" + dfrom + "' and '" + dto + "'"
                    + " ";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                tendered += rs.getDouble(1);
                discount += rs.getDouble(2);
                credit += (rs.getDouble(3));
                my_dollar += rs.getDouble(5);
                String receipt_id = rs.getString(4);
                String s2 = "select "
                        + "qty"
                        + ",unit_price"
                        + ",cat_name"
                        + ",group_id"
                        + " from " + Main.MyDB.getNames() + ".receipt_items where "
                        + " receipt_id ='" + receipt_id + "' "
                        + " ";

                Statement stmt2 = conn.createStatement();
                ResultSet rs2 = stmt2.executeQuery(s2);
                while (rs2.next()) {
                    double qty = rs2.getDouble(1);
                    double unit_price = rs2.getDouble(2);
                    String cat_name = rs2.getString(3);
                    int group_id = rs2.getInt(4);
                    //                    System.out.println(qty + " * " + unit_price + " = " + (qty * unit_price));
                    if (group_id == 1) {
                        beverages += (qty * unit_price);
                    } else {
                        foods += (qty * unit_price);
                    }
                }
            }
//            JOptionPane.showMessageDialog(null, session_id);
            String s3 = "select sum(amount) from " + Main.MyDB.getNames() + ".expenses where session_id='" + session_id + "' and Date(date_added) between '" + dfrom + "' and '" + dto + "'";
            Statement stmt3 = conn.createStatement();
            ResultSet rs3 = stmt3.executeQuery(s3);
            if (rs3.next()) {
                expences = rs3.getDouble(1);
            }

            String user_name = "";
            if (to_users.username1 == null) {
                user_name = "Ronald Pascua";
            } else {
                user_name = to_users.ret_data(to_users.username1);
            }

//            System.out.println(tendered + " " + discount + " " + credit + " " + foods + " " + beverages + " " + expences);
            double net = ((tendered + discount) - credit) - expences;
            dollar = S1_currency.ret_dollar(DateType.sf.format(new Date()));

            String SUBREPORT_DIR = System.getProperty("img_path", "C:\\Users\\i1\\") + "img_templates\\rpt\\";
//            JOptionPane.showMessageDialog(null, SUBREPORT_DIR);
            List<Srpt_credits.field> rpt_credits = new ArrayList();
            String s4 = "select "
                    + "or_no"
                    + ",card_type"
                    + ",card_holder"
                    + ",card_no"
                    + ",approval_code"
                    + ",amount"
                    + ",dollar_amount"
                    + ",dollar_rate"
                    + " from " + Main.MyDB.getNames() + ".credits where session_id='" + session_id + "' and Date(date_payed) between '" + dfrom + "' and '" + dto + "'"
                    + " ";
            Statement stmt4 = conn.createStatement();
            ResultSet rs4 = stmt4.executeQuery(s4);
            while (rs4.next()) {
                String trans_no = rs4.getString(1);
                String card_type = rs4.getString(2);
                String card_holder = rs4.getString(3);
                String card_no = rs4.getString(4);
                String approval_code = rs4.getString(5);
                double amount = rs4.getDouble(6);
                double additional = rs4.getDouble(7);
                double dollar_rate = rs4.getDouble(8);
//                System.out.println(approval_code);
                Srpt_credits.field to = new Srpt_credits.field(trans_no, card_type, card_holder, card_no, approval_code, amount, additional, dollar_rate);
                rpt_credits.add(to);
            }

            List<Srpt_expenses.field> rpt_expenses = new ArrayList();
            String s5 = "select "
                    + "date_added"
                    + ",amount"
                    + ",purpose"
                    + ",category_name"
                    + ",vat"
                    + " from " + Main.MyDB.getNames() + ".expenses where "
                    + " session_id ='" + session_id + "' and Date(date_added) between '" + dfrom + "' and '" + dto + "'"
                    + " ";
            Statement stmt5 = conn.createStatement();
            ResultSet rs5 = stmt5.executeQuery(s5);
            while (rs5.next()) {
                Date d = new Date();
                d = DateType.datetime.parse(rs5.getString(1));
                String date_added = DateType.time.format(d);
                double amount = rs5.getDouble(2);
                String purpose = rs5.getString(3);
                String category_name = rs5.getString(4);
                String vat = rs5.getString(5);

                Srpt_expenses.field to = new Srpt_expenses.field(date_added, amount, purpose, category_name, vat);
                System.out.println(amount);
                rpt_expenses.add(to);
            }

            to1 = new Srpt_cashier_report(SUBREPORT_DIR, rpt_credits, rpt_expenses, new ArrayList(), date_from, date_to, busi_name, user_name, my_dollar, tendered, discount, credit, foods, beverages, expences, (foods + beverages), net, "", new ArrayList(), 0, 0, 0, dollar, 0, 0, 0, "", 0, 0, 0, 0, 0, 0,0);
            JRViewer viewer = get_viewer_conn_summary(to1, "rpt_daily_sales_liquid.jrxml");
            JFrame f = Application.launchMainFrame3(viewer, "", true);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection1.close();
        }

    }

    public static JRViewer get_viewer_conn_summary(Srpt_cashier_report to, String rpt_name) {
//        Connection con11 = null;
        try {
//            con11 = MyConnection1.connect();

            return JasperUtil.getJasperViewer(
                    compileJasper(rpt_name),
                    JasperUtil.setParameter(to),
                    JasperUtil.emptyDatasource());
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
        }
    }

    public static JasperReport compileJasper(String rpt_name) {
        try {
            String jrxml = rpt_name;
            InputStream is = Srpt_cashier_report.class.getResourceAsStream(jrxml);
            JasperReport jasper = JasperCompileManager.compileReport(is);
            return jasper;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static Srpt_cashier_report ret_data_session2(String session_id, Date date_from, Date date_to, String busi_name, double dollar, String dfrom,
             String dto, List<Receipts.to_receipts> receipts, double tendered, double discount, double credit, double expences, String users, double cashin, double cashout, double addtl_cashin, double dollars, double gross, double advance_payment, double advance_payment_usd, double outside_cash, double cc_reflenishment, double bank_php, double bank_usd, double credit_card) {

        String SUBREPORT_DIR = System.getProperty("img_path", "C:\\Users\\Guinness\\") + "img_templates\\rpt\\";
        Srpt_cashier_report to1 = new Srpt_cashier_report(SUBREPORT_DIR, new ArrayList(), new ArrayList(), new ArrayList(), new Date(), new Date(), "", "", 0, 0, 0, 0, 0, 0, 0, 0, 0, "", new ArrayList(), 0, 0, 0, 0, 0, 0, 0, "", 0, 0, 0, 0, 0, 0,0);

        String user = to_users.username1;
        try {
            Connection conn = MyConnection1.connect();
            double foods = 0;
            double beverages = 0;

            for (Receipts.to_receipts t : receipts) {
                String s2 = "select "
                        + "qty"
                        + ",unit_price"
                        + ",cat_name"
                        + ",group_id"
                        + " from " + Main.MyDB.getNames() + ".receipt_items where "
                        + " receipt_id ='" + t.id + "' "
                        + " ";
            }

            String user_name = "";
            if (to_users.username1 == null) {
                user_name = "Ronald Pascua";
            } else {
                user_name = to_users.ret_data(to_users.username1);
            }

            double net = ((tendered + discount) - credit) - expences;
            List<Srpt_credits.field> rpt_credits = new ArrayList();
            String s4 = "select "
                    + "or_no"
                    + ",bank_name"
                    + ",card_holder"
                    + ",card_no"
                    + ",approval_code"
                    + ",amount"
                    + ",dollar_amount"
                    + ",dollar_rate"
                    + " from " + Main.MyDB.getNames() + ".credits where   "
                    + "Date(date_payed) between '" + dfrom + "' and '" + dto + "'"
                    + "and user_name like '%" + users + "%'"
                    + " ";
            Statement stmt4 = conn.createStatement();
            ResultSet rs4 = stmt4.executeQuery(s4);
            while (rs4.next()) {
                String trans_no = rs4.getString(1);
                String card_type = rs4.getString(2);
                String card_holder = rs4.getString(3);
                String card_no = rs4.getString(4);
                String approval_code = rs4.getString(5);
                double amount = rs4.getDouble(6);
                double additional = rs4.getDouble(7);
                double dollar_rate = rs4.getDouble(8);
                Srpt_credits.field to = new Srpt_credits.field(trans_no, card_type, card_holder, card_no, approval_code, amount, additional, dollar_rate);
                rpt_credits.add(to);
            }
            List<Srpt_expenses.field> rpt_expenses = new ArrayList();
            String s5 = "select "
                    + "date_added"
                    + ",amount"
                    + ",purpose"
                    + ",category_name"
                    + ",vat"
                    + " from " + Main.MyDB.getNames() + ".expenses where "
                    + "  Date(date_added) between '" + dfrom + "' and '" + dto + "' "
                    + "and user_name like '%" + users + "%' order by category_name asc"
                    + " ";

            Statement stmt5 = conn.createStatement();
            ResultSet rs5 = stmt5.executeQuery(s5);
            while (rs5.next()) {
                Date d = new Date();
                d = DateType.datetime.parse(rs5.getString(1));
                String date_added = DateType.time.format(d);
                double amount = rs5.getDouble(2);
                String purpose = rs5.getString(3);
                String category_name = rs5.getString(4);
                String vat = rs5.getString(5);

                Srpt_expenses.field to = new Srpt_expenses.field(date_added, amount, purpose, category_name, vat);
                rpt_expenses.add(to);
            }

            List<Srpt_advance_payments.field> advance_payments = new ArrayList();
            String s10 = "select "
                    + "date_added"
                    + ",amount_paid"
                    + ",peso_on_bank"
                    + ",usd"
                    + ",usd_on_bank"
                    + ",bank"
                    + ",approval_code"
                    + ",credit_amount"
                    + ",guest_name"
                    + " from " + Main.MyDB.getNames() + ".guest_advance_payment where "
                    + "Date(date_added) between '" + dfrom + "' and '" + dto + "' "
                    + "and user_name like '%" + users + "%' "
                    + " ";

            Statement stmt10 = conn.createStatement();
            ResultSet rs10 = stmt10.executeQuery(s10);
            while (rs10.next()) {
                String date_added = DateType.convert_jan_1_2013_datetime(rs10.
                        getString(1));
                double php_cash = rs10.getDouble(2);
                double php_bank = rs10.getDouble(3);
                double usd_cash = rs10.getDouble(4);
                double usd_bank = rs10.getDouble(5);
                String bank = rs10.getString(6);
                String approval_code = rs10.getString(7);
                double credit_card1 = rs10.getDouble(8);
                String guest = rs10.getString(9);
                Srpt_advance_payments.field to = new Srpt_advance_payments.field(date_added, php_cash, php_bank, usd_cash, usd_bank, bank, approval_code, credit_card1, guest);
                advance_payments.add(to);
            }

            List<String> datas = S1_my_sales.ret_cashier();
            List<Srpt_cashiers.field> data = new ArrayList();
            for (String s : datas) {
                users = to_users.ret_user(s);
                double am = 0;
                String s6 = "select sum(peso) from " + Main.MyDB.getNames() + ".receipts where Date(receipt_date) between '" + dfrom + "' and '" + dto + "'"
                        + " and user_name like '%" + users + "%'";
                Statement stmt6 = conn.createStatement();
                ResultSet rs6 = stmt6.executeQuery(s6);
                if (rs6.next()) {
                    am = rs6.getDouble(1);
                }
                Srpt_cashiers.field t = new Srpt_cashiers.field(s, am);
                data.add(t);
            }
            to1 = new Srpt_cashier_report(SUBREPORT_DIR, rpt_credits, rpt_expenses, advance_payments, date_from, date_to, busi_name, user_name, dollar, tendered, discount, credit, foods, beverages, expences, (foods + beverages), net, user, data, cashin, cashout, addtl_cashin, dollar, gross, advance_payment, advance_payment_usd, to_users.username1, outside_cash, cc_reflenishment, bank_php, bank_usd, credit_card, 0,0);

            System.out.println("SUBREPORT_DIR: " + SUBREPORT_DIR);
            return to1;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection1.close();
        }
    }
}
