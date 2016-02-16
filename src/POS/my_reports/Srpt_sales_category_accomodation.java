/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.my_reports;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import mijzcx.synapse.desk.utils.Application;
import mijzcx.synapse.desk.utils.JasperUtil;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.swing.JRViewer;
import rpt_liquid.Srpt_accomodation;

/**
 *
 * @author Maytopacka
 */
public class Srpt_sales_category_accomodation {

    public final List<field> fields;

    public Srpt_sales_category_accomodation() {
        this.fields = new ArrayList();

    }

    public static class field {

        String category_name;
        double total_amount;
        double qty;
        String description;
        double price;
        double amount;

        public field(String category_name, double total_amount, double qty, String description, double price, double amount) {
            this.category_name = category_name;
            this.total_amount = total_amount;
            this.qty = qty;
            this.description = description;
            this.price = price;
            this.amount = amount;
        }

      

        public String getCategory_name() {
            return category_name;
        }

        public void setCategory_name(String category_name) {
            this.category_name = category_name;
        }

        public double getTotal_amount() {
            return total_amount;
        }

        public void setTotal_amount(double total_amount) {
            this.total_amount = total_amount;
        }

        public double getAmount() {
            return amount;
        }

        public void setAmount(double amount) {
            this.amount = amount;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public double getQty() {
            return qty;
        }

        public void setQty(double qty) {
            this.qty = qty;
        }
    }

    public static JasperReport compileJasper() {
        try {
            String jrxml = "rpt_sales_category_accomodation.jrxml";
            InputStream is = Srpt_sales_category_accomodation.class.
                    getResourceAsStream(jrxml);
            JasperReport jasper = JasperCompileManager.compileReport(is);

            return jasper;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {

        List<Srpt_sales_category_accomodation.field> fields = new ArrayList();
        for (int i = 0; i < 20; i++) {
            String category_name="ACCOMODATION";
            double total_amount=1000;
            double qty = 0 + i;
            String description = "desc";
            double price = 100 + i;
            double amount = price * qty;
            Srpt_sales_category_accomodation.field tf = new field(category_name, total_amount,qty, description, price, amount);
            fields.add(tf);
        }
      
        Srpt_sales_category_accomodation rpt = new Srpt_sales_category_accomodation();
        rpt.fields.addAll(fields);

        JRViewer viewer = Srpt_sales_category_accomodation.get_viewer(rpt);
        JFrame f = Application.launchMainFrame3(viewer, "Sample", true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public static void pdf_view(Srpt_sales_category_accomodation to) {

        JasperUtil.pdfViewer(
                JasperUtil.getJasper(Srpt_sales_category_accomodation.class),
                JasperUtil.setParameter(to),
                JasperUtil.makeDatasource(to.fields));
    }

    public static JRViewer get_viewer(Srpt_sales_category_accomodation to) {

        return JasperUtil.getJasperViewer(
                compileJasper(),
                JasperUtil.setParameter(to),
                JasperUtil.makeDatasource(to.fields));

    }
}
