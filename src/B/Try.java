/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package B;
import java.awt.Label;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import jxl.Workbook;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Try extends javax.swing.JFrame {

    /**
     * Creates new form Try
     */ConnectDB c=new ConnectDB();
        Bill b=new Bill();
   public Connection conn;
     public ResultSet rs=null;
    PreparedStatement pst=null;
    
   
    
    public Try() {
        initComponents();
        conn=c.getConn();
        
     }
    
    
   
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pp1 = new javax.swing.JPopupMenu();
        m1 = new javax.swing.JMenuItem();
        jScrollPane2 = new javax.swing.JScrollPane();
        l1 = new javax.swing.JList<>();
        t3 = new javax.swing.JTextField();
        t1 = new javax.swing.JTextField();
        t2 = new javax.swing.JTextField();
        b1 = new javax.swing.JButton();

        m1.setText("set Item");
        m1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m1ActionPerformed(evt);
            }
        });
        pp1.add(m1);

        l1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(l1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(660, 467));
        getContentPane().setLayout(null);
        getContentPane().add(t3);
        t3.setBounds(110, 170, 190, 30);
        getContentPane().add(t1);
        t1.setBounds(110, 70, 190, 30);

        t2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t2ActionPerformed(evt);
            }
        });
        getContentPane().add(t2);
        t2.setBounds(110, 120, 190, 30);

        b1.setText("jButton1");
        b1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b1ActionPerformed(evt);
            }
        });
        getContentPane().add(b1);
        b1.setBounds(160, 220, 110, 23);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void m1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m1ActionPerformed
       
   

        // TODO add your handling code here:
    }//GEN-LAST:event_m1ActionPerformed

    private void t2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t2ActionPerformed

    private void b1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b1ActionPerformed
  
//        File f =new File("C:\\Users\\LENOVO\\Documents\\Book2.xlsx");
//        int i=0;
//      
//      XSSFWorkbook myexcel =new XSSFWorkbook();
//      XSSFSheet sheet1= myexcel.createSheet("Report Info");
//       XSSFRow row=sheet1.createRow(i);
//       XSSFCell cell;
//       
//       cell=row.createCell(i);
//       cell.setCellValue(t1.getText().toString());
//       
//       FileOutputStream out;
//         try {
//             out =new FileOutputStream(new File("C:\\Users\\LENOVO\\Documents\\Book2.xlsx"));
//             myexcel.write(out);
//             out.close();
//             JOptionPane.showMessageDialog(null,"ok");
//             i++;
//         } catch (FileNotFoundException ex) {
//             Logger.getLogger(Try.class.getName()).log(Level.SEVERE, null, ex);
//         } catch (IOException ex) {
//             Logger.getLogger(Try.class.getName()).log(Level.SEVERE, null, ex);
//         }
//      
        
        
        
    }//GEN-LAST:event_b1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */


        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Try().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton b1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList<String> l1;
    private javax.swing.JMenuItem m1;
    private javax.swing.JPopupMenu pp1;
    private javax.swing.JTextField t1;
    private javax.swing.JTextField t2;
    private javax.swing.JTextField t3;
    // End of variables declaration//GEN-END:variables
}
