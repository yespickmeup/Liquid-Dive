/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rpt_liquid;

import POS.Main.MyDB;
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
public class Srpt_cash_float {

    public final List<field> fields;

    public Srpt_cash_float() {
        this.fields = new ArrayList();
    }

    public static class field {

        String cash_float_date;
        String my_date;
        String cashier_name;
        String cashin_time;
        double cashin_peso;
        double cashin_dollar;
        double cashin_cc;
        String cashout_time;
        double cashout_peso;
        double cashout_dollar;
        double cashout_credit;
        double acc_peso;
        double acc_dollar;
        double acc_credit;
        String signature;
        double addtl_cashin;
        double cashout;
        double expenses;
        double sales_peso;
        double gross_sales;
        String peso_remarks;
        String dollar_remarks;
        String credit_remarks;
        double advance_payment;

        public field() {
        }

        public field(String cash_float_date, String my_date, String cashier_name, String cashin_time, double cashin_peso, double cashin_dollar, double cashin_cc, String cashout_time, double cashout_peso, double cashout_dollar, double cashout_credit, double acc_peso, double acc_dollar, double acc_credit, String signature, double addtl_cashin, double cashout, double expenses, double sales_peso, double gross_sales, String peso_remarks, String dollar_remarks, String credit_remarks, double advance_payment) {
            this.cash_float_date = cash_float_date;
            this.my_date = my_date;
            this.cashier_name = cashier_name;
            this.cashin_time = cashin_time;
            this.cashin_peso = cashin_peso;
            this.cashin_dollar = cashin_dollar;
            this.cashin_cc = cashin_cc;
            this.cashout_time = cashout_time;
            this.cashout_peso = cashout_peso;
            this.cashout_dollar = cashout_dollar;
            this.cashout_credit = cashout_credit;
            this.acc_peso = acc_peso;
            this.acc_dollar = acc_dollar;
            this.acc_credit = acc_credit;
            this.signature = signature;
            this.addtl_cashin = addtl_cashin;
            this.cashout = cashout;
            this.expenses = expenses;
            this.sales_peso = sales_peso;
            this.gross_sales = gross_sales;
            this.peso_remarks = peso_remarks;
            this.dollar_remarks = dollar_remarks;
            this.credit_remarks = credit_remarks;
            this.advance_payment = advance_payment;
        }

        public double getAcc_credit() {
            return acc_credit;
        }

        public void setAcc_credit(double acc_credit) {
            this.acc_credit = acc_credit;
        }

        public double getAcc_dollar() {
            return acc_dollar;
        }

        public void setAcc_dollar(double acc_dollar) {
            this.acc_dollar = acc_dollar;
        }

        public double getAcc_peso() {
            return acc_peso;
        }

        public void setAcc_peso(double acc_peso) {
            this.acc_peso = acc_peso;
        }

        public double getAddtl_cashin() {
            return addtl_cashin;
        }

        public void setAddtl_cashin(double addtl_cashin) {
            this.addtl_cashin = addtl_cashin;
        }

        public String getCash_float_date() {
            return cash_float_date;
        }

        public void setCash_float_date(String cash_float_date) {
            this.cash_float_date = cash_float_date;
        }

        public String getCashier_name() {
            return cashier_name;
        }

        public void setCashier_name(String cashier_name) {
            this.cashier_name = cashier_name;
        }

        public double getCashin_cc() {
            return cashin_cc;
        }

        public void setCashin_cc(double cashin_cc) {
            this.cashin_cc = cashin_cc;
        }

        public double getCashin_dollar() {
            return cashin_dollar;
        }

        public void setCashin_dollar(double cashin_dollar) {
            this.cashin_dollar = cashin_dollar;
        }

        public double getCashin_peso() {
            return cashin_peso;
        }

        public void setCashin_peso(double cashin_peso) {
            this.cashin_peso = cashin_peso;
        }

        public String getCashin_time() {
            return cashin_time;
        }

        public void setCashin_time(String cashin_time) {
            this.cashin_time = cashin_time;
        }

        public double getCashout() {
            return cashout;
        }

        public void setCashout(double cashout) {
            this.cashout = cashout;
        }

        public double getCashout_credit() {
            return cashout_credit;
        }

        public void setCashout_credit(double cashout_credit) {
            this.cashout_credit = cashout_credit;
        }

        public double getCashout_dollar() {
            return cashout_dollar;
        }

        public void setCashout_dollar(double cashout_dollar) {
            this.cashout_dollar = cashout_dollar;
        }

        public double getCashout_peso() {
            return cashout_peso;
        }

        public void setCashout_peso(double cashout_peso) {
            this.cashout_peso = cashout_peso;
        }

        public String getCashout_time() {
            return cashout_time;
        }

        public void setCashout_time(String cashout_time) {
            this.cashout_time = cashout_time;
        }

        public String getCredit_remarks() {
            return credit_remarks;
        }

        public void setCredit_remarks(String credit_remarks) {
            this.credit_remarks = credit_remarks;
        }

        public String getDollar_remarks() {
            return dollar_remarks;
        }

        public void setDollar_remarks(String dollar_remarks) {
            this.dollar_remarks = dollar_remarks;
        }

        public double getExpenses() {
            return expenses;
        }

        public void setExpenses(double expenses) {
            this.expenses = expenses;
        }

        public double getGross_sales() {
            return gross_sales;
        }

        public void setGross_sales(double gross_sales) {
            this.gross_sales = gross_sales;
        }

        public String getMy_date() {
            return my_date;
        }

        public void setMy_date(String my_date) {
            this.my_date = my_date;
        }

        public String getPeso_remarks() {
            return peso_remarks;
        }

        public void setPeso_remarks(String peso_remarks) {
            this.peso_remarks = peso_remarks;
        }

        public double getSales_peso() {
            return sales_peso;
        }

        public void setSales_peso(double sales_peso) {
            this.sales_peso = sales_peso;
        }

        public String getSignature() {
            return signature;
        }

        public void setSignature(String signature) {
            this.signature = signature;
        }

        public double getAdvance_payment() {
            return advance_payment;
        }

        public void setAdvance_payment(double advance_payment) {
            this.advance_payment = advance_payment;
        }
    }

    public static void main(String[] args) {

//        Main.MyDB.setNames("db_pos_restaurant");
        List<Srpt_cash_float.field> fields = ret_data("", new ArrayList(), "");

        Srpt_cash_float rpt = new Srpt_cash_float();
        rpt.fields.addAll(fields);

        JRViewer viewer = get_viewer(rpt);
        JFrame f = Application.launchMainFrame3(viewer, "Sample", true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public static JasperReport compileJasper() {
        try {
            String jrxml = "rpt_cash_float.jrxml";
            InputStream is = Srpt_cash_float.class.getResourceAsStream(jrxml);
            JasperReport jasper = JasperCompileManager.compileReport(is);
            return jasper;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static JRViewer get_viewer(Srpt_cash_float to) {
        return JasperUtil.getJasperViewer(
                compileJasper(),
                JasperUtil.setParameter(to),
                JasperUtil.makeDatasource(to.fields));
    }

    public static List<Srpt_cash_float.field> ret_data(String search, List<String> dates, String date_interval) {
        List<Srpt_cash_float.field> datas = new ArrayList();

        String date = DateType.sf.format(new Date());
        String text_date = DateType.day_1.format(new Date());
        String cash_float_date = "Cash Float " + date_interval;


        try {
            Connection conn = MyConnection1.connect();
            for (String s : dates) {

                String s0 = "";
                if (to_users.user_level1.equals("1")) {
                    s0 = "select "
                            + "user_name"
                            + ",cash_in"
                            + ",cash_out"
                            + ",addtl_cash"
                            + ",credit"
                            + ",cashier_session_id"
                            + " from " + MyDB.getNames() + ".cash_drawer where "
                            + " Date(date_added) ='" + s + "' "
                            + " ";
                } else {
                    s0 = "select "
                            + "user_name"
                            + ",cash_in"
                            + ",cash_out"
                            + ",addtl_cash"
                            + ",credit"
                            + ",cashier_session_id"
                            + " from " + MyDB.getNames() + ".cash_drawer where "
                            + " Date(date_added) ='" + s + "' and user_name like '" + to_users.
                            ret_user(to_users.username1) + "' "
                            + " ";

                }

                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(s0);
                while (rs.next()) {
                    String user_name = rs.getString(1);
                    double cash_in = rs.getDouble(2);
                    double cash_out = rs.getDouble(3);
                    double dollar = rs.getDouble(4);
                    double credit = rs.getDouble(5);
                    String cashier_session_id = rs.getString(6);
                    String login_time = "";
                    String logout_time = "";
                    String s2 = "select ifnull(login_time,''),ifnull(logout_time,'') from " + MyDB.
                            getNames() + ".cashier_sessions where id='" + cashier_session_id + "'";

                    Statement stmt2 = conn.createStatement();
                    ResultSet rs2 = stmt2.executeQuery(s2);
                    if (rs2.next()) {
                        login_time = rs2.getString(1);
                        logout_time = rs2.getString(2);
                    }
                    Date log = new Date();
                    log = DateType.datetime.parse(login_time);
                    login_time = DateType.time2.format(log);

                    Date out = new Date();
                    if (!logout_time.isEmpty()) {
                        out = DateType.datetime.parse(logout_time);
                        logout_time = DateType.time2.format(out);
                    }

                    S1_my_sales.to_details t = S1_my_sales.ret_cash_in(user_name, date, date);
                    S1_my_sales.to_sales t1 = S1_my_sales.ret_sales(user_name, date, date, cashier_session_id);
//                user_name=
//                System.out.println(cashier_session_id + " ------" + t1.peso);
                    String my_date = s;
                    String cashier_name = to_users.ret_data(user_name);
                    String cashin_time = login_time;
                    double cashin_peso = cash_in;
                    double cashin_dollar = 0;
                    double cashin_cc = 0;
                    String cashout_time = "10:00am";
                    double cashout_peso = cash_out;
                    double cashout_dollar = dollar;
                    double cashout_credit = credit;
                    double acc_peso = t1.peso;
                    acc_peso = (t1.peso + cashin_peso + t.addtl_cashins + t.advance_payment) - (t.expenses + t.cashout);
                    double acc_dollar = t1.dollar;
                    double acc_credit = t1.credit;
                    String signature = "UNDER";
                    double addtl_cashin = t.addtl_cashins;
                    double cashout = t.cashout;
                    double expenses = t.expenses;
                    double sales_peso = t1.peso;
                    double gross_sales = 0;
                    String peso_remarks = "UNDER";
                    if (acc_peso == cashout_peso) {
                        peso_remarks = "OK";
                    }
                    if (acc_peso < cashout_peso) {
                        peso_remarks = "OVER";
                    }
                    String dollar_remarks = "UNDER";
                    if (acc_dollar == cashout_dollar) {
                        dollar_remarks = "OK";
                    }
                    if (acc_dollar < cashout_dollar) {
                        dollar_remarks = "OVER";
                    }
                    String credit_remarks = "UNDER";
                    if (acc_credit == cashout_credit) {
                        credit_remarks = "OK";
                    }

                    if (acc_credit < cashout_credit) {
                        credit_remarks = "OVER";
                    }
                    Srpt_cash_float.field to = new field(cash_float_date, my_date, cashier_name, cashin_time
                            , cashin_peso, cashin_dollar, cashin_cc, cashout_time, cashout_peso
                            , cashout_dollar, cashout_credit, acc_peso, acc_dollar, acc_credit
                            , signature, addtl_cashin, cashout, expenses, sales_peso, gross_sales
                            , peso_remarks, dollar_remarks, credit_remarks, t.advance_payment);
                    datas.add(to);
                }
            }
            return datas;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection1.close();
        }
    }
}
