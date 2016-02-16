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
import rpt_liquid.Srpt_expenses.field;

/**
 *
 * @author Maytopacka
 */
public class Srpt_expenses_all {

    public final List<Srpt_expenses.field> rpt_expenses;
    public final String SUBREPORT_DIR;
    public final String busi_name;
    public final Date date_from;
    public final Date date_to;

    public Srpt_expenses_all(List<field> rpt_expenses, String SUBREPORT_DIR, String busi_name, Date date_from, Date date_to) {
        this.rpt_expenses = rpt_expenses;
        this.SUBREPORT_DIR = SUBREPORT_DIR;
        this.busi_name = busi_name;
        this.date_from = date_from;
        this.date_to = date_to;
    }

    public String getBusi_name() {
        return busi_name;
    }

    public Date getDate_from() {
        return date_from;
    }

    public Date getDate_to() {
        return date_to;
    }

    public String getSUBREPORT_DIR() {
        return SUBREPORT_DIR;
    }

    public List<field> getRpt_expenses() {
        return rpt_expenses;
    }

    public static void main(String[] args) {
        List<Srpt_expenses.field> fields = new ArrayList();
        for (int i = 0; i < 20; i++) {
            Srpt_expenses.field s = new field("", i, "purpose", "", "");
            fields.add(s);
        }
        String SUBREPORT_DIR = System.getProperty("img_path", "C:\\Users\\Maytopacka\\") + "img_templates\\rpt\\";

        Srpt_expenses_all to = new Srpt_expenses_all(fields, SUBREPORT_DIR,"",new Date(),new Date());

        JRViewer viewer = get_viewer(to);
        JFrame f = Application.launchMainFrame3(viewer, "Sample", true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public static JasperReport compileJasper() {
        try {
            String jrxml = "rpt_expenses_all.jrxml";
            InputStream is = Srpt_expenses_all.class.getResourceAsStream(jrxml);
            JasperReport jasper = JasperCompileManager.compileReport(is);

            return jasper;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static JRViewer get_viewer(Srpt_expenses_all to) {

        return JasperUtil.getJasperViewer(
                compileJasper(),
                JasperUtil.setParameter(to),
                JasperUtil.emptyDatasource());
    }
}
