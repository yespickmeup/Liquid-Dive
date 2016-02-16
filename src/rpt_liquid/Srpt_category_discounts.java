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
 * @author Maytopacka
 */
public class Srpt_category_discounts {

    public final List<Srpt_category_discounts.field> fields;

    public Srpt_category_discounts() {
        this.fields = new ArrayList();
    }

    public static class field {

        String category;
        double due;
        double disc_percent;
        double disc_amount;
        double sub_total;
        public field() {
        }

        public field(String category, double due, double disc_percent, double disc_amount, double sub_total) {
            this.category = category;
            this.due = due;
            this.disc_percent = disc_percent;
            this.disc_amount = disc_amount;
            this.sub_total = sub_total;
        }

        public String getCategory() {
            return category;
        }

        public void setCategory(String category) {
            this.category = category;
        }

        public double getDisc_amount() {
            return disc_amount;
        }

        public void setDisc_amount(double disc_amount) {
            this.disc_amount = disc_amount;
        }

        public double getDisc_percent() {
            return disc_percent;
        }

        public void setDisc_percent(double disc_percent) {
            this.disc_percent = disc_percent;
        }

        public double getDue() {
            return due;
        }

        public void setDue(double due) {
            this.due = due;
        }

        public double getSub_total() {
            return sub_total;
        }

        public void setSub_total(double sub_total) {
            this.sub_total = sub_total;
        }
    }
    public static JasperReport compileJasper() {
        try {
            String jrxml = "rpt_category_discounts.jrxml";
            InputStream is = Srpt_category_discounts.class.getResourceAsStream(jrxml);
            JasperReport jasper = JasperCompileManager.compileReport(is);

            return jasper;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {

        List<Srpt_category_discounts.field> fields = new ArrayList();
        for (int i = 0; i < 20; i++) {
            String category = "cat " + i;
            double due = 0;
            double disc_percent = i;
            double disc_amount = i * 2;
            double sub_total = 0;
            Srpt_category_discounts.field tbar = new field(category, due, disc_percent, disc_amount, sub_total);
            fields.add(tbar);
        }

        Srpt_category_discounts rpt = new Srpt_category_discounts();
        rpt.fields.addAll(fields);

        JRViewer viewer = Srpt_category_discounts.get_viewer(rpt);
        JFrame f = Application.launchMainFrame3(viewer, "Sample", true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public static void pdf_view(Srpt_category_discounts to) {

        JasperUtil.pdfViewer(
                JasperUtil.getJasper(Srpt_cashiers.class),
                JasperUtil.setParameter(to),
                JasperUtil.makeDatasource(to.fields));
    }

    public static JRViewer get_viewer(Srpt_category_discounts to) {

        return JasperUtil.getJasperViewer(
                compileJasper(),
                JasperUtil.setParameter(to),
                JasperUtil.makeDatasource(to.fields));

    }
}
