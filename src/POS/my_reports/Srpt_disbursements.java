/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.my_reports;

import static POS.my_reports.Srpt_sales_category_accomodation.compileJasper;
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
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.swing.JRViewer;
import synsoftech.util.DateType;

/**
 *
 * @author Guinness
 */
public class Srpt_disbursements {

    public final List<field> fields;
    public final String date;
    public final String category;
    public final String type;

    public Srpt_disbursements(String date, String category, String type) {
        this.fields = new ArrayList();
        this.date = date;
        this.category = category;
        this.type = type;
    }

    public static class field {

        String purpose;
        double amount;
        String category;
        String vat;
        String date;

        public field() {
        }

        public field(String purpose, double amount, String category, String vat, String date) {
            this.purpose = purpose;
            this.amount = amount;
            this.category = category;
            this.vat = vat;
            this.date = date;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getPurpose() {
            return purpose;
        }

        public void setPurpose(String purpose) {
            this.purpose = purpose;
        }

        public double getAmount() {
            return amount;
        }

        public void setAmount(double amount) {
            this.amount = amount;
        }

        public String getCategory() {
            return category;
        }

        public void setCategory(String category) {
            this.category = category;
        }

        public String getVat() {
            return vat;
        }

        public void setVat(String vat) {
            this.vat = vat;
        }

    }

    public static JasperReport compileJasper() {
        try {
            String jrxml = "rpt_disbursements.jrxml";
            InputStream is = Srpt_sales_category_accomodation.class.
                    getResourceAsStream(jrxml);
            JasperReport jasper = JasperCompileManager.compileReport(is);

            return jasper;
        } catch (JRException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {

        List<Srpt_disbursements.field> fields = ret_data("");
        String date = "";
        String category = "";
        String type = "";
        Srpt_disbursements rpt = new Srpt_disbursements(date, category, type);
        rpt.fields.addAll(fields);

        JRViewer viewer = Srpt_disbursements.get_viewer(rpt);
        JFrame f = Application.launchMainFrame3(viewer, "Sample", true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public static void pdf_view(Srpt_disbursements to) {

        JasperUtil.pdfViewer(
                JasperUtil.getJasper(Srpt_disbursements.class),
                JasperUtil.setParameter(to),
                JasperUtil.makeDatasource(to.fields));
    }

    public static JRViewer get_viewer(Srpt_disbursements to) {

        return JasperUtil.getJasperViewer(
                compileJasper(),
                JasperUtil.setParameter(to),
                JasperUtil.makeDatasource(to.fields));

    }

    public static List<Srpt_disbursements.field> ret_data(String where) {
        List<Srpt_disbursements.field> datas = new ArrayList();

        try {
            Connection conn = MyConnection1.connect();
            String s0 = "select "
                    + "id"
                    + ",date_added"
                    + ",user_name"
                    + ",amount"
                    + ",purpose"
                    + ",session_id"
                    + ",category_name"
                    + ",vat"
                    + " from db_pos_restaurant.expenses"
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String date_added = rs.getString(2);
                String user_name = rs.getString(3);
                double amount = rs.getDouble(4);
                String purpose = rs.getString(5);
                int session_id = rs.getInt(6);
                String category_name = rs.getString(7);
                String vat = rs.getString(8);

                Srpt_disbursements.field f = new field(purpose.toUpperCase(), amount, category_name.toUpperCase(), vat, DateType.convert_slash_datetime(date_added));
                datas.add(f);

            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection1.close();
        }
    }

    public static List<Srpt_disbursements.field> ret_data_summary(String where) {
        List<Srpt_disbursements.field> datas = new ArrayList();

        try {
            Connection conn = MyConnection1.connect();
            String s0 = "select "
                    + "id"
                    + ",date_added"
                    + ",user_name"
                    + ",sum(amount)"
                    + ",purpose"
                    + ",session_id"
                    + ",category_name"
                    + ",vat"
                    + " from db_pos_restaurant.expenses"
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String date_added = rs.getString(2);
                String user_name = rs.getString(3);
                double amount = rs.getDouble(4);
                String purpose = rs.getString(5);
                int session_id = rs.getInt(6);
                String category_name = rs.getString(7);
                String vat = rs.getString(8);

                Srpt_disbursements.field f = new field(purpose.toUpperCase(), amount, category_name.toUpperCase(), vat, DateType.convert_slash_datetime(date_added));
                datas.add(f);

            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection1.close();
        }
    }
}
