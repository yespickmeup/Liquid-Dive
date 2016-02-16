/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rpt_liquid;

import POS.Main;
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
public class Srpt_expenses {

    public final List<field> fields;

    public Srpt_expenses() {
        this.fields = new ArrayList();
    }

    public Srpt_expenses(List<field> fields) {
        this.fields = fields;
    }

    public List<field> getFields() {
        return fields;
    }

    public static class field {

        String date_added;
        double amount;
        String purpose;
        String category_name;
        String vat;

        public field(String date_added, double amount, String purpose, String category_name, String vat) {
            this.date_added = date_added;
            this.amount = amount;
            this.purpose = purpose;
            this.category_name = category_name;
            this.vat = vat;
        }

        public field() {
        }

        public String getCategory_name() {
            return category_name;
        }

        public void setCategory_name(String category_name) {
            this.category_name = category_name;
        }

        public String getVat() {
            return vat;
        }

        public void setVat(String vat) {
            this.vat = vat;
        }

        public double getAmount() {
            return amount;
        }

        public void setAmount(double amount) {
            this.amount = amount;
        }

        public String getPurpose() {
            return purpose;
        }

        public void setPurpose(String purpose) {
            this.purpose = purpose;
        }

        public String getDate_added() {
            return date_added;
        }

        public void setDate_added(String date_added) {
            this.date_added = date_added;
        }
    }

    public static void main(String[] args) {

        List<Srpt_expenses.field> fields = new ArrayList();
        for (int i = 0; i < 20; i++) {
            Srpt_expenses.field s = new field("", i, "purpose", "", "");
            fields.add(s);
        }

        Srpt_expenses rpt = new Srpt_expenses();
        rpt.fields.addAll(fields);

        JRViewer viewer = get_viewer(rpt);
        JFrame f = Application.launchMainFrame3(viewer, "Sample", true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public static JasperReport compileJasper() {
        try {
            String jrxml = "rpt_expenses.jrxml";
            InputStream is = Srpt_expenses.class.getResourceAsStream(jrxml);
            JasperReport jasper = JasperCompileManager.compileReport(is);

            return jasper;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static List<Srpt_expenses.field> get_expenses(String users, String dfrom
            , String dto,String category_name1,String vat1) {
        try {
            Connection conn = MyConnection1.connect();
            List<Srpt_expenses.field> rpt_expenses = new ArrayList();
            String s5 = "select "
                    + "date_added"
                    + ",amount"
                    + ",purpose"
                    + ",category_name"
                    + ",vat"
                    + " from " + Main.MyDB.getNames() + ".expenses where "
                    + "Date(date_added) between '" + dfrom + "' and '" + dto + "' "
                    + "and user_name like '%" + users + "%' "
                    + "and category_name like '%" + category_name1 + "%' "
                    + "and vat like '%" + vat1 + "%' "
                    + "order by category_name asc"
                    + " ";

            Statement stmt5 = conn.createStatement();
            ResultSet rs5 = stmt5.executeQuery(s5);
            while (rs5.next()) {
                Date d = new Date();
                d = DateType.datetime.parse(rs5.getString(1));
                String date_added = DateType.month_date.format(d);
                double amount = rs5.getDouble(2);
                String purpose = rs5.getString(3);
                String category_name = rs5.getString(4);
                String vat = rs5.getString(5);

                Srpt_expenses.field to = new Srpt_expenses.field(date_added, amount, purpose, category_name, vat);
                System.out.println(amount);
                rpt_expenses.add(to);
            }

            return rpt_expenses;
        } catch (Exception e) {
            MyConnection1.close();
            throw new RuntimeException(e);
        } finally {
            MyConnection1.close();
        }
    }

    public static JRViewer get_viewer(Srpt_expenses to) {

        return JasperUtil.getJasperViewer(
                compileJasper(),
                JasperUtil.setParameter(to),
                JasperUtil.makeDatasource(to.fields));
    }
}
