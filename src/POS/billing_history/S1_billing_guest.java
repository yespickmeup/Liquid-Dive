/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.billing_history;

/**
 *
 * @author Maytopacka
 */
public class S1_billing_guest {

    public static class to_billing_guest {

        public final int id;
        public final String guest_id;
        public final String guest_name;

        public to_billing_guest(int id, String guest_id, String guest_name) {
            this.id = id;
            this.guest_id = guest_id;
            this.guest_name = guest_name;
        }
    }
    
    
}
