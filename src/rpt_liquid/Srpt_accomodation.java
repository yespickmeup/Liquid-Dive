/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rpt_liquid;

import java.io.InputStream;
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
public class Srpt_accomodation {

    public final List<field> fields;

    public Srpt_accomodation() {
        this.fields = new ArrayList();
    }

    public static class field {

        double qty;
        int nights;
        String description;
        double price;
        double amount;
        String date_stayed;
        String accomodation;
        
        public field(double qty, int nights, String description, double price, double amount, String date_stayed,String accomodation) {
            this.qty = qty;
            this.nights = nights;
            this.description = description;
            this.price = price;
            this.amount = amount;
            this.date_stayed = date_stayed;
            this.accomodation=accomodation;
        }

        public field() {
        }

        public double getAmount() {
            return amount;
        }

        public void setAmount(double amount) {
            this.amount = amount;
        }

        public String getDate_stayed() {
            return date_stayed;
        }

        public void setDate_stayed(String date_stayed) {
            this.date_stayed = date_stayed;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public int getNights() {
            return nights;
        }

        public void setNights(int nights) {
            this.nights = nights;
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

        public String getAccomodation() {
            return accomodation;
        }

        public void setAccomodation(String accomodation) {
            this.accomodation = accomodation;
        }
        
    }

    public static JasperReport compileJasper() {
        try {
            String jrxml = "rpt_accomodation.jrxml";
            InputStream is = Srpt_accomodation.class.getResourceAsStream(jrxml);
            JasperReport jasper = JasperCompileManager.compileReport(is);

            return jasper;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {

        List<Srpt_accomodation.field> fields = new ArrayList();
        for (int i = 0; i < 20; i++) {
            double qty = i;
            int nights = i;
            String description = "desc" + i;
            double price = 100 + i;
            double amount = 200 + i;
            String date_stayed = "(January 1, 2013 - January 5, 2012)";
            Srpt_accomodation.field tbar = new field(qty, nights, description, price, amount, date_stayed,"");
            fields.add(tbar);
        }

        Srpt_accomodation rpt = new Srpt_accomodation();
        rpt.fields.addAll(fields);

        JRViewer viewer = Srpt_accomodation.get_viewer(rpt);
        JFrame f = Application.launchMainFrame3(viewer, "Sample", true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public static void pdf_view(Srpt_accomodation to) {

        JasperUtil.pdfViewer(
                JasperUtil.getJasper(Srpt_accomodation.class),
                JasperUtil.setParameter(to),
                JasperUtil.makeDatasource(to.fields));
    }

    public static JRViewer get_viewer(Srpt_accomodation to) {

        return JasperUtil.getJasperViewer(
                compileJasper(),
                JasperUtil.setParameter(to),
                JasperUtil.makeDatasource(to.fields));

    }
}
