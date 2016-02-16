/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rpt_liquid;

import POS.Main;
import POS.Main.MyDB;
import POS.advance_payment.S1_guest_advance_payment.to_guest_advance_payment;
import POS.utl.DateType;
import POS.utl.MyConnection1;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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
public class Srpt_history_advance_payments {

    public final List<field> fields;

    public Srpt_history_advance_payments() {
        this.fields = new ArrayList();
    }

    public Srpt_history_advance_payments(List<field> fields) {
        this.fields = fields;
    }

    public List<field> getFields() {
        return fields;
    }

    public static class field {

        String date_added;
        double php_cash;
        double php_bank;
        double usd_cash;
        double usd_bank;
        String bank;
        String approval_code;
        double credit_card;
        String guest;
        double credit_card_rate;
        public field() {
        }

        public field(String date_added, double php_cash, double php_bank, double usd_cash, double usd_bank, String bank, String approval_code, double credit_card
                , String guest,double credit_card_rate) {
            this.date_added = date_added;
            this.php_cash = php_cash;
            this.php_bank = php_bank;
            this.usd_cash = usd_cash;
            this.usd_bank = usd_bank;
            this.bank = bank;
            this.approval_code = approval_code;
            this.credit_card = credit_card;
            this.guest = guest;
            this.credit_card_rate=credit_card_rate;
        }

        public double getCredit_card_rate() {
            return credit_card_rate;
        }

        public void setCredit_card_rate(double credit_card_rate) {
            this.credit_card_rate = credit_card_rate;
        }
        
        public String getGuest() {
            return guest;
        }

        public void setGuest(String guest) {
            this.guest = guest;
        }

        public String getApproval_code() {
            return approval_code;
        }

        public void setApproval_code(String approval_code) {
            this.approval_code = approval_code;
        }

        public String getBank() {
            return bank;
        }

        public void setBank(String bank) {
            this.bank = bank;
        }

        public double getCredit_card() {
            return credit_card;
        }

        public void setCredit_card(double credit_card) {
            this.credit_card = credit_card;
        }

        public String getDate_added() {
            return date_added;
        }

        public void setDate_added(String date_added) {
            this.date_added = date_added;
        }

        public double getPhp_bank() {
            return php_bank;
        }

        public void setPhp_bank(double php_bank) {
            this.php_bank = php_bank;
        }

        public double getPhp_cash() {
            return php_cash;
        }

        public void setPhp_cash(double php_cash) {
            this.php_cash = php_cash;
        }

        public double getUsd_bank() {
            return usd_bank;
        }

        public void setUsd_bank(double usd_bank) {
            this.usd_bank = usd_bank;
        }

        public double getUsd_cash() {
            return usd_cash;
        }

        public void setUsd_cash(double usd_cash) {
            this.usd_cash = usd_cash;
        }
    }

    public static void main(String[] args) {

        List<Srpt_history_advance_payments.field> fields = new ArrayList();
        for (int i = 0; i < 10; i++) {
            String date_added = "date";
            double php_cash = i + 1;
            double php_bank = i + 2;
            double usd_cash = i + 3;
            double usd_bank = i + 1;
            String bank = "";
            String approval_code = "";
            double credit_card = 0;
            double credit_card_rate=0;
            Srpt_history_advance_payments.field to = new field(date_added, php_cash, php_bank, usd_cash, usd_bank, bank, approval_code, credit_card, "",credit_card_rate);
            fields.add(to);
        }

        Srpt_history_advance_payments rpt = new Srpt_history_advance_payments();
        rpt.fields.addAll(fields);

        JRViewer viewer = get_viewer(rpt);
        JFrame f = Application.launchMainFrame3(viewer, "Sample", true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public static JasperReport compileJasper() {
        try {
            String jrxml = "rpt_history_advance_payments.jrxml";
            InputStream is = Srpt_history_advance_payments.class.
                    getResourceAsStream(jrxml);
            JasperReport jasper = JasperCompileManager.compileReport(is);

            return jasper;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static List<Srpt_history_advance_payments.field> get_expenses(String users, String dfrom, String dto, String category_name1, String vat1) {
        try {
            Connection conn = MyConnection1.connect();
            List<Srpt_history_advance_payments.field> advance_payments = new ArrayList();
            String s5 = "select "
                    + "date_added"
                    + ",amount_paid"
                    + ",usd"
                    + ",peso_on_bank"
                    + ",usd_on_bank"
                    + ",bank"
                    + ",approval_code"
                    + ",credit_amount"
                    + ",credit_rate"
                    + " from " + Main.MyDB.getNames() + ".guest_advance_payment where "
                    + "Date(date_added) between '" + dfrom + "' and '" + dto + "' "
                    + "and user_name like '%" + users + "%' "
                    //                    + "order by category_name asc"
                    + " ";

            Statement stmt5 = conn.createStatement();
            ResultSet rs5 = stmt5.executeQuery(s5);
            while (rs5.next()) {
                String date_added = rs5.getString(1);
                double php_cash = rs5.getDouble(2);
                double php_bank = rs5.getDouble(3);
                double usd_cash = rs5.getDouble(4);
                double usd_bank = rs5.getDouble(5);
                String bank = rs5.getString(6);
                String approval_code = rs5.getString(7);
                double credit_card = rs5.getDouble(8);
                double credit_rate=rs5.getDouble(9);
                Srpt_history_advance_payments.field to = new field(date_added, php_cash, php_bank, usd_cash, usd_bank, bank, approval_code, credit_card, "",credit_rate);
//                System.out.println(amount);
                advance_payments.add(to);
            }

            return advance_payments;
        } catch (SQLException e) {
            MyConnection1.close();
            throw new RuntimeException(e);
        } finally {
            MyConnection1.close();
        }
    }

    public static List<Srpt_history_advance_payments.field> ret_data(String room_guest_ids1) {
        List<Srpt_history_advance_payments.field> datas = new ArrayList();

        try {
            Connection conn = MyConnection1.connect();
            String s0 = "select "
                    + "id"
                    + ",room_id"
                    + ",guest_name"
                    + ",guest_id"
                    + ",date_added"
                    + ",amount_paid"
                    + ",status"
                    + ",user_name"
                    + ",peso_on_bank"
                    + ",room_guest_id"
                      + ",usd"
                    + ",usd_on_bank"
                    + ",is_peso_on_bank"
                    + ",is_usd_on_bank"
                    + ",bank_no"
                    + ",bank"
                    + ",card_type"
                    + ",card_holder"
                    + ",card_no"
                    + ",approval_code"
                    + ",credit_amount"
                    + ",credit_addtl"
                    + ",credit_rate"
                    + " from " + MyDB.getNames() + ".guest_advance_payment where "
                    + " room_guest_id ='" +room_guest_ids1+ "' "
                    + " ";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String room_id = rs.getString(2);
                String guest_name = rs.getString(3);
                String guest_id = rs.getString(4);
                String date_added = DateType.convert_slash(rs.getString(5));
                double amount_paid = rs.getDouble(6);
                int status = rs.getInt(7);
                String user_name = rs.getString(8);
                double usd = rs.getDouble(9);
                int room_guest_id = rs.getInt(10);
                double peso_on_bank = rs.getDouble(11);
                double usd_on_bank = rs.getDouble(12);
                int is_peso_on_bank = rs.getInt(13);
                int is_usd_on_bank = rs.getInt(14);
                String bank_no = rs.getString(15);
                String bank = rs.getString(16);
                String card_type = rs.getString(17);
                String card_holder = rs.getString(18);
                String card_no = rs.getString(19);
                String approval_code = rs.getString(20);
                double credit_amount = rs.getDouble(21);
                double credit_addtl = rs.getDouble(22);
                double credit_rate = rs.getDouble(23);
              Srpt_history_advance_payments.field to2 = new Srpt_history_advance_payments.field(date_added
                      , amount_paid, usd, peso_on_bank, usd_on_bank, bank, approval_code, credit_amount, "",credit_rate);
              datas.add(to2);
            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection1.close();
        }
    }

    public static JRViewer get_viewer(Srpt_history_advance_payments to) {

        return JasperUtil.getJasperViewer(
                compileJasper(),
                JasperUtil.setParameter(to),
                JasperUtil.makeDatasource(to.fields));
    }
}
