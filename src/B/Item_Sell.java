/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package B;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.Timer;
import javax.swing.table.TableModel;
import net.proteanit.sql.DbUtils;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.jdbc.JDBCCategoryDataset;

/**
 *
 * @author LENOVO
 */
public class Item_Sell extends javax.swing.JInternalFrame {
    
    ConnectDB c=new ConnectDB();

    public Connection conn=c.getConn();
     public ResultSet rs=null;
    PreparedStatement pst=null;
    Report r=new Report();
    RateNV rnv=new RateNV();
    Owner_Area oa=new Owner_Area();
    
    
    public Item_Sell() {
       Date1();
        initComponents();
        fetch();
    }

 public  void Date1()
   {
       new Timer(0,new ActionListener(){
           public void actionPerformed(ActionEvent e) {
               
               Date  dt= new Date();
               SimpleDateFormat s= new SimpleDateFormat("dd-MM-yyyy");
               String dtt=s.format(dt);
               t2.setText(dtt);
               }
            
       }).start();
   }
    
 public void fetch()
    {
          try
    {
          Date  date= new Date();
               SimpleDateFormat s= new SimpleDateFormat("dd-MM-yyyy");
               String dt=s.format(date);
       String q="SELECT date, item, quntity\n" +
"	FROM public.\"ItemSell\"  WHERE  date='"+dt+"' ORDER BY date DESC  ;";
        pst=conn.prepareStatement(q);
        rs=pst.executeQuery();
        
        tbl1.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,e);
        }; 
        
         try
    {
          Date  date= new Date();
               SimpleDateFormat s= new SimpleDateFormat("dd-MM-yyyy");
               String dt=s.format(date);
       String q="SELECT count(item)\n" +
"	FROM public.\"ItemSell\" WHERE  date='"+dt+"'   ;";
        pst=conn.prepareStatement(q);
        rs=pst.executeQuery();
        while(rs.next()){
       
         t4.setText(""+rs.getString(1));
        }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,e);
        }; 
        
        
      
        
         
        
        
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        t2 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        b2 = new javax.swing.JButton();
        t3 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        t1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        b3 = new javax.swing.JButton();
        b6 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl1 = new javax.swing.JTable();
        t4 = new javax.swing.JTextField();
        t7 = new javax.swing.JTextField();
        b4 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        getContentPane().setLayout(null);

        jPanel2.setBackground(new java.awt.Color(153, 102, 255));
        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel2.setLayout(null);

        jLabel5.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Menu SheeT:");
        jPanel2.add(jLabel5);
        jLabel5.setBounds(30, 10, 240, 40);

        getContentPane().add(jPanel2);
        jPanel2.setBounds(-10, 0, 880, 60);

        jPanel1.setBackground(new java.awt.Color(153, 153, 255));
        jPanel1.setLayout(null);

        t2.setBackground(new java.awt.Color(204, 255, 255));
        t2.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 11)); // NOI18N
        t2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        t2.setText("Date");
        t2.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0))));
        jPanel1.add(t2);
        t2.setBounds(30, 120, 110, 30);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/B/report1.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        jLabel1.setToolTipText("View Report Chart");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel1MouseEntered(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel1MousePressed(evt);
            }
        });
        jPanel1.add(jLabel1);
        jLabel1.setBounds(670, 360, 50, 40);

        b2.setBackground(new java.awt.Color(153, 102, 255));
        b2.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 14)); // NOI18N
        b2.setForeground(new java.awt.Color(255, 255, 255));
        b2.setText("Delete");
        b2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b2ActionPerformed(evt);
            }
        });
        jPanel1.add(b2);
        b2.setBounds(30, 200, 110, 30);

        t3.setBackground(new java.awt.Color(204, 255, 255));
        t3.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 11)); // NOI18N
        t3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        t3.setText("Total RS.");
        t3.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0))));
        jPanel1.add(t3);
        t3.setBounds(30, 160, 110, 30);

        jLabel6.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 11)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Entries");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(640, 10, 60, 30);

        t1.setBackground(new java.awt.Color(204, 255, 255));
        t1.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 11)); // NOI18N
        t1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        t1.setText("Sr.No");
        t1.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0))));
        t1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                t1KeyTyped(evt);
            }
        });
        jPanel1.add(t1);
        t1.setBounds(30, 80, 110, 30);

        jLabel2.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 18)); // NOI18N
        jLabel2.setText("Total :");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(420, 360, 80, 40);

        b3.setBackground(new java.awt.Color(51, 255, 51));
        b3.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 14)); // NOI18N
        b3.setForeground(new java.awt.Color(255, 255, 255));
        b3.setText("Print");
        b3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b3ActionPerformed(evt);
            }
        });
        jPanel1.add(b3);
        b3.setBounds(30, 240, 110, 30);

        b6.setBackground(new java.awt.Color(153, 102, 255));
        b6.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 10)); // NOI18N
        b6.setForeground(new java.awt.Color(51, 0, 0));
        b6.setText("View ");
        b6.setToolTipText("view Total ");
        b6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b6ActionPerformed(evt);
            }
        });
        jPanel1.add(b6);
        b6.setBounds(330, 370, 70, 30);

        jLabel3.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Show Other Day Earning ");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(28, 370, 130, 30);

        jScrollPane2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 0, 255), 1, true));

        tbl1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        tbl1.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 14)); // NOI18N
        tbl1.setForeground(new java.awt.Color(153, 0, 153));
        tbl1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Sr.No", "Date", "Total Rupees"
            }
        ));
        tbl1.setIntercellSpacing(new java.awt.Dimension(2, 2));
        tbl1.setRowHeight(30);
        tbl1.setShowHorizontalLines(false);
        tbl1.getTableHeader().setResizingAllowed(false);
        tbl1.getTableHeader().setReorderingAllowed(false);
        tbl1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl1);

        jPanel1.add(jScrollPane2);
        jScrollPane2.setBounds(190, 60, 630, 250);

        t4.setBackground(new java.awt.Color(153, 102, 255));
        t4.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 14)); // NOI18N
        t4.setForeground(new java.awt.Color(255, 255, 255));
        t4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        t4.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0))));
        t4.setFocusable(false);
        t4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                t4KeyTyped(evt);
            }
        });
        jPanel1.add(t4);
        t4.setBounds(700, 10, 110, 30);

        t7.setBackground(new java.awt.Color(153, 102, 255));
        t7.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 18)); // NOI18N
        t7.setForeground(new java.awt.Color(255, 255, 255));
        t7.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        t7.setText("0");
        t7.setToolTipText("total Rupees");
        t7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        t7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t7ActionPerformed(evt);
            }
        });
        jPanel1.add(t7);
        t7.setBounds(500, 360, 150, 40);

        b4.setBackground(new java.awt.Color(255, 0, 0));
        b4.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 14)); // NOI18N
        b4.setForeground(new java.awt.Color(255, 255, 255));
        b4.setText("back");
        b4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b4ActionPerformed(evt);
            }
        });
        jPanel1.add(b4);
        b4.setBounds(750, 390, 110, 30);

        jButton1.setBackground(new java.awt.Color(0, 51, 255));
        jButton1.setFont(new java.awt.Font("SimSun", 1, 11)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Reset");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(190, 320, 70, 20);

        jPanel5.setBackground(new java.awt.Color(153, 102, 255));
        jPanel5.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel5.setLayout(null);
        jPanel1.add(jPanel5);
        jPanel5.setBounds(0, 430, 870, 20);

        jButton2.setText("Print Report");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(40, 320, 120, 23);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 60, 870, 450);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        try{
            String dt=t2.getText().toString();
            String query="SELECT cno, date, total\n" +
            "	FROM public.\"Total\" WHERE date='"+dt+"';";
            JDBCCategoryDataset dataset=new JDBCCategoryDataset(c.getConn(),query);

            JFreeChart jc= ChartFactory.createLineChart("Report Chart", "rs", "total", dataset, PlotOrientation.VERTICAL, false, true, true);
            BarRenderer renderer=null;
            CategoryPlot plot=null;
            renderer=new BarRenderer();

            //      DefaultCategoryDataset dod= new DefaultCategoryDataset();
            //        dod.setValue(400,"customer","total");
            //        dod.setValue(300,"c1","t1");
            //
            //        CategoryPlot plot=jc.getCategoryPlot();
            //        plot.setRangeGridlinePaint(Color.pink);
            ChartFrame cf= new ChartFrame("record Report",jc,true);
            cf.setVisible(true);
            cf.setSize(1300,600);
            cf.setLocation(40,70);
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel1MouseClicked

    private void jLabel1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseEntered

    }//GEN-LAST:event_jLabel1MouseEntered

    private void jLabel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MousePressed

    }//GEN-LAST:event_jLabel1MousePressed

    private void b2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b2ActionPerformed
        Bill b=new Bill();

        try{

            String sql=" DELETE  From public.\"Total\"\n" +
            "	WHERE \"cno\"='"+Integer.parseInt(t1.getText())+"' AND date='"+t2.getText().toString()+"'\n" +
            "  AND total='"+Integer.parseInt(t3.getText())+"'	    ;";

            pst=conn.prepareStatement(sql);
            pst.execute();

            JOptionPane.showMessageDialog(null, "Record Deleted");
            fetch();
        }catch(Exception e){JOptionPane.showMessageDialog(null, e);};

        try{

            String sql="INSERT INTO public.\"deleted_Bills\"(\n" +
            "	date, \"time\", bill_no, amount)\n" +
            "	VALUES (?, ?, ?, ?);";

            pst=conn.prepareStatement(sql);
            pst.setString(1,b.ldt.getText().toString());
            pst.setString(2,b.l2.getText().toString());
            pst.setInt(3,Integer.parseInt(t1.getText()));
            pst.setInt(4,Integer.parseInt(t3.getText()));
            pst.execute();

            JOptionPane.showMessageDialog(null, " Added"
                + "");
            fetch();
        }catch(Exception e){JOptionPane.showMessageDialog(null, e);};

        // TODO add your handling code here:
    }//GEN-LAST:event_b2ActionPerformed

    private void t1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t1KeyTyped
        char c=evt.getKeyChar();
        if(!(Character.isDigit(c)) || (c==KeyEvent.VK_ENTER) ||(c==KeyEvent.VK_BACK_SPACE)   ){
            evt.consume();}        // TODO add your handling code here:
    }//GEN-LAST:event_t1KeyTyped

    private void t10FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_t10FocusLost

        // TODO add your handling code here:
    }//GEN-LAST:event_t10FocusLost

    private void b3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b3ActionPerformed

        MessageFormat header=new MessageFormat("Report Print");
        MessageFormat footer=new MessageFormat("Page{0,number,integer}");

        try{
            tbl1.print(JTable.PrintMode.FIT_WIDTH, header, footer);

        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_b3ActionPerformed

    private void b6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b6ActionPerformed
        SimpleDateFormat s= new SimpleDateFormat("dd-MM-yyyy");

        String dtt=s.format(t10.getDate());
        String dt=String.valueOf(dtt);
        t2.setText(dt);

        try{
            billing b=new billing();

            String query="SELECT count(item)\n" +
"	FROM public.\"ItemSell\" WHERE  date='"+dt+"'   ;";
            pst=conn.prepareStatement(query);
            rs=pst.executeQuery();
            if(rs.next()){
                String sum=rs.getString(1);
                t7.setText(sum);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }

        {
            try
            {

                String q="SELECT date, item, quntity\n" +
"	FROM public.\"ItemSell\" WHERE  date='"+dt+"'   ;";
                pst=conn.prepareStatement(q);
                rs=pst.executeQuery();

                tbl1.setModel(DbUtils.resultSetToTableModel(rs));
            }catch(Exception e){JOptionPane.showMessageDialog(null,e);};
        }  // TODO add your handling code here:
    }//GEN-LAST:event_b6ActionPerformed

    private void tbl1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl1MouseClicked
        int i=tbl1.getSelectedRow();
        TableModel model=tbl1.getModel();
        t1.setText(model.getValueAt(i, 0).toString());
        t2.setText(model.getValueAt(i, 1).toString());
        t3.setText(model.getValueAt(i, 2).toString());        // TODO add your handling code here:
        // TODO add your handling code here:
    }//GEN-LAST:event_tbl1MouseClicked

    private void t4KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t4KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_t4KeyTyped

    private void t7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t7ActionPerformed

    private void b4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_b4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        fetch();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
 try{
            Class.forName("org.postgresql.Driver");
            String url="jdbc:postgresql://localhost/Hotel";
            String user="postgres";
            String password="shubhampwr";

            conn=DriverManager.getConnection(url, user, password);
            File f=new File("C:\\Users\\LENOVO\\Documents\\report3.jrxml");
            String report=f.getAbsolutePath();
            JasperReport jr=JasperCompileManager.compileReport(report);
            JasperPrint jp=JasperFillManager.fillReport(jr, null,conn);
            JasperViewer.viewReport(jp);

        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,e);
        }       
        
           
            // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton b2;
    private javax.swing.JButton b3;
    private javax.swing.JButton b4;
    private javax.swing.JButton b6;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField t1;
    private javax.swing.JTextField t2;
    private javax.swing.JTextField t3;
    private javax.swing.JTextField t4;
    private javax.swing.JTextField t7;
    private javax.swing.JTable tbl1;
    // End of variables declaration//GEN-END:variables
}
