/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package B;

import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.print.PrinterException;
import java.io.File;
import java.io.FileWriter;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import static jdk.nashorn.internal.objects.NativeObject.keys;
import jxl.Workbook;
import jxl.write.WritableCell;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

/**
 *
 * @author LENOVO
 */
public final class billing extends javax.swing.JFrame {
    ConnectDB c=new ConnectDB();
    public Connection conn=c.getConn();
     public ResultSet rs=null;
    PreparedStatement pst=null;
    Statement smt=null;
    //int a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z=0;
  
    int tot;
    
    
    
    
    public billing() {
        
        initComponents(); getConn();
        tfclose();
        Date1();
        time1();
       fetchcno();
        onload();
        addCombo();
        this.setLocationRelativeTo(null);
        
    }
    public void addCombo(){
        try{
        
        String sql="SELECT menu, rate\n" +
"	FROM public.\"Rate\";";
        pst=conn.prepareStatement(sql);
        rs=pst.executeQuery();
        
        while(rs.next()){
            String menu=rs.getString(1);
            cb3.addItem(menu);
            cb2.addItem(menu);
        }
        }catch(Exception e){
            
        }
        
    }
    
    void fetchcno()
    {
        try{
            String dt=t56.getText();
            String query="SELECT  sum(total)\n" +
"	FROM public.\"Total\" WHERE  date='"+dt+"'   ;";
    pst=conn.prepareStatement(query);
    rs=pst.executeQuery();
    if(rs.next()){
        String sum=rs.getString(1);
        t204.setText(sum);
    }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }

    }
    
    
     void onload()
     {
      tt1.setText("********************************\n"+
                   "*       Hotel Shubham       *\n"+
                   "********************************\n"
                   
                 );
     }
     void time1()
   {
       new Timer(0,new ActionListener(){
           public void actionPerformed(ActionEvent e) {
               
               Date  dt= new Date();
               SimpleDateFormat s= new SimpleDateFormat("dd-MM-yyyy");
               String dtt=s.format(dt);
               t56.setText(dtt);
               }
            
       }).start();
   }
   void Date1()
   {
       new Timer(0,new ActionListener(){
           public void actionPerformed(ActionEvent e) {
               
               Date  dt= new Date();
               SimpleDateFormat s= new SimpleDateFormat("hh:mm:ss a");
               
               l1.setText(s.format(dt));
               }
            
       }).start();
       onload();
   }
   
   public void countCNO()
   {
       
       ConnectDB  c=new ConnectDB();
       try{
    Connection conn=c.getConn();
    Statement st=conn.createStatement();
    String a=t56.getText();
    String query="SELECT cno, date, total\n" +
"	FROM public.\"Total\" where date='"+a+"' ;";
    String date="";
    rs=st.executeQuery(query);
    if(rs != null)
    {
        while(rs.next()){
            date=rs.getString(1);
            
        }
         
        t111.setText(date);
    }
}   catch(Exception e){
    JOptionPane.showMessageDialog(null, e);

}        
   }
   
   
    public void t111()
    {
    tt1.append(""+rb1.getText()+":"+t1.getText()+"\t"+t41.getText()+"\t"+t57.getText()+"\n");
    }

public void t112(){
     tt1.append(""+rb41.getText()+":"+t2.getText()+"\t"+t42.getText()+"\t"+t59.getText()+"\n"); 
    
}
public void t113()
    {
    tt1.append(""+rb2.getText()+":"+t3.getText()+"\t"+t43.getText()+"\t"+t61.getText()+"\n");
    }
  public void t114()
    {
    tt1.append(""+rb3.getText()+":"+t4.getText()+"\t"+t44.getText()+"\t"+t62.getText()+"\n");
    } 
  public void t115()
    {
    tt1.append(""+rb5.getText()+":"+t5.getText()+"\t"+t45.getText()+"\t"+t63.getText()+"\n");
    } 
  
   public void t116()
    {
    tt1.append(""+rb7.getText()+":"+t6.getText()+"\t"+t46.getText()+"\t"+t64.getText()+"\n");
    } 
   public void t117()
    {
    tt1.append(""+rb6.getText()+":"+t9.getText()+"\t"+t60.getText()+"\t"+t65.getText()+"\n");
    } 
   public void t118()
    {
    tt1.append(""+rb16.getText()+":"+t13.getText()+"\t"+t58.getText()+"\t"+t66.getText()+"\n");
    } 
   public void t119()
    {
    tt1.append(""+rb8.getText()+":"+t7.getText()+"\t"+t47.getText()+"\t"+t68.getText()+"\n");
    } 
    public void t120()
    {
    tt1.append(""+rb9.getText()+":"+t8.getText()+"\t"+t48.getText()+"\t"+t69.getText()+"\n");
    } 
     public void t121()
    {
    tt1.append(""+rb10.getText()+":"+t10.getText()+"\t"+t49.getText()+"\t"+t70.getText()+"\n");
    } 
    public void t122()
    {
    tt1.append(""+rb11.getText()+":"+t20.getText()+"\t"+t50.getText()+"\t"+t71.getText()+"\n");
    } 
     public void t123()
    {
    tt1.append(""+rb12.getText()+":"+t12.getText()+"\t"+t51.getText()+"\t"+t72.getText()+"\n");
    } 
    public void t124()
    {
    tt1.append(""+rb13.getText()+":"+t11.getText()+"\t"+t52.getText()+"\t"+t73.getText()+"\n");
    } 
     public void t125()
    {
    tt1.append(""+rb14.getText()+":"+t21.getText()+"\t"+t53.getText()+"\t"+t74.getText()+"\n");
    } 
     
      public void t126()
    {
    tt1.append(""+rb15.getText()+":"+t22.getText()+"\t"+t54.getText()+"\t"+t75.getText()+"\n");
    } 
     /* public void t127()
    {
    tt1.append(""+t113.getText()+":"+t114.getText()+"\t"+t115.getText()+"\t"+t116.getText()+"\n");
    } */
     public void t128()
    {
    tt1.append(""+rb32.getText()+":"+t33.getText()+"\t"+t67.getText()+"\t"+t124.getText()+"\n");
    } 
      public void t129()
    {
    tt1.append(""+rb43.getText()+":"+t34.getText()+"\t"+t112.getText()+"\t"+t125.getText()+"\n");
    } 
       public void t130()
    {
    tt1.append(""+rb33.getText()+":"+t35.getText()+"\t"+t118.getText()+"\t"+t126.getText()+"\n");
    }
        public void t131()
    {
    tt1.append(""+rb34.getText()+":"+t36.getText()+"\t"+t119.getText()+"\t"+t127.getText()+"\n");
    }
        public void t132()
    {
    tt1.append(""+rb35.getText()+":"+t37.getText()+"\t"+t120.getText()+"\t"+t128.getText()+"\n");
    }
        public void t133()
    {
    tt1.append(""+rb36.getText()+":"+t38.getText()+"\t"+t121.getText()+"\t"+t129.getText()+"\n");
    }
        public void t134()
    {
    tt1.append(""+rb37.getText()+":"+t39.getText()+"\t"+t122.getText()+"\t"+t130.getText()+"\n");
    }
        public void t135()
    {
    tt1.append(""+rb38.getText()+":"+t40.getText()+"\t"+t123.getText()+"\t"+t131.getText()+"\n");
    }
        public void t136()
    {
     tt1.append(""+rb8.getText()+":"+t132.getText()+"\t"+t140.getText()+"\t"+t148.getText()+"\n");
    }
         public void t137()
    {
     tt1.append(""+rb9.getText()+":"+t133.getText()+"\t"+t141.getText()+"\t"+t149.getText()+"\n");
    }
          public void t138()
    {
     tt1.append(""+rb10.getText()+":"+t134.getText()+"\t"+t142.getText()+"\t"+t150.getText()+"\n");
    }
           public void t139()
    {
     tt1.append(""+rb11.getText()+":"+t135.getText()+"\t"+t143.getText()+"\t"+t151.getText()+"\n");
    }
            public void t140()
    {
     tt1.append(""+rb12.getText()+":"+t136.getText()+"\t"+t144.getText()+"\t"+t152.getText()+"\n");
    }
             public void t141()
    {
     tt1.append(""+rb13.getText()+":"+t137.getText()+"\t"+t145.getText()+"\t"+t153.getText()+"\n");
    }
              public void t142()
    {
     tt1.append(""+rb14.getText()+":"+t138.getText()+"\t"+t146.getText()+"\t"+t154.getText()+"\n");
    }
               public void t143()
    {
     tt1.append(""+rb15.getText()+":"+t139.getText()+"\t"+t147.getText()+"\t"+t155.getText()+"\n");
    }
        
      
       
      public void clear() {
            rb1.setSelected(false);
           rb41.setSelected(false);
rb2.setSelected(false);     rb3.setSelected(false);
rb5.setSelected(false);     rb6.setSelected(false);
rb7.setSelected(false);     rb16.setSelected(false);
rb8.setSelected(false);     rb9.setSelected(false);
rb10.setSelected(false);    rb11.setSelected(false);
rb12.setSelected(false);    rb13.setSelected(false);
rb14.setSelected(false);    rb15.setSelected(false);
//rb31.setSelected(false);

        

rb32.setSelected(false);     rb40.setSelected(false);
rb43.setSelected(false);     rb39.setSelected(false);
rb33.setSelected(false);     rb44.setSelected(false);
rb34.setSelected(false);     rb45.setSelected(false);
rb35.setSelected(false);     rb46.setSelected(false);
rb36.setSelected(false);    rb47.setSelected(false);
rb37.setSelected(false);    rb48.setSelected(false);
rb38.setSelected(false);    rb49.setSelected(false);


t1.setText("");
t2.setText("");     t117.setText("0");
t3.setText("");     t4.setText("");
t5.setText("");      t6.setText("");
t7.setText("");      t9.setText(""); 
t13.setText("");    t41.setText("");
t42.setText("");    t43.setText("");
t44.setText("");    t45.setText("");
t46.setText("");    t66.setText("0");
t58.setText("");    t59.setText("");
t57.setText("");    t61.setText("");
t62.setText("");    t63.setText("");
t64.setText("");    t65.setText("");
t7.setText("");     t8.setText("");
t10.setText("");    t11.setText("");
t12.setText("");    t20.setText("");
t21.setText("");    t22.setText("");
 cnt1.setText("0");


t47.setText("");
t48.setText("");
t49.setText("");
t50.setText("");
t51.setText("");
t52.setText("");
t53.setText("");
t54.setText("");
t58.setText("");
t57.setText("0");
t59.setText("0");
t60.setText("0");
t61.setText("0");
t62.setText("0");
t63.setText("0");
t64.setText("0");
t65.setText("0");
t68.setText("0");
t69.setText("0");
t70.setText("0");
t71.setText("0");
t72.setText("0");
t73.setText("0");
t74.setText("0");
t75.setText("0");


t33.setText("");     t124.setText("0");
t34.setText("");     t125.setText("0");
t35.setText("");      t126.setText("0");
t36.setText("");      t127.setText("0"); 
t37.setText("");    t128.setText("0");
t38.setText("");    t129.setText("0");
t39.setText("");    t130.setText("0");
t40.setText("");    t131.setText("0");
t67.setText("");    t132.setText("");
t112.setText("");    t133.setText("");
t118.setText("");    t134.setText("");
t119.setText("");    t135.setText("");
t120.setText("");     t136.setText("");
t121.setText("");    t137.setText("");
t122.setText("");    t138.setText("");
t123.setText("");    t139.setText("");

t140.setText("");    t148.setText("0");
t141.setText("");    t149.setText("0");
t142.setText("");    t150.setText("0");
t143.setText("");    t151.setText("0");
t144.setText("");     t152.setText("0");
t145.setText("");    t153.setText("0");
t146.setText("");    t154.setText("0");
t147.setText("");    t155.setText("0");


        }  
       
       
   public void tfclose()
   {
        
       t1.disable();
       t2.disable();
       t3.disable();
       t4.disable();
       t5.disable();
       t6.disable();
       t7.disable();
       
        t33.disable();
       t34.disable();
       t35.disable();
       t36.disable();
       t37.disable();
       t38.disable();
       t39.disable();
       t40.disable();
       
        t132.disable();
       t133.disable();
       t134.disable();
       t135.disable();
       t136.disable();
       t137.disable();
       t138.disable();
       t139.disable();
       
        t148.disable();
       t149.disable();
       t150.disable();
       t151.disable();
       t152.disable();
       t153.disable();
       t154.disable();
       t155.disable();
       
       
         t67.disable();       t112.disable();
       t118.disable();       t119.disable();
       t120.disable();       t121.disable();
       t122.disable();       t123.disable();
        t124.disable();       t125.disable();
        t126.disable();      t127.disable();   
       t129.disable();       t130.disable();
       t131.disable();       t128.disable();
       
         t132.disable();       t140.disable();
       t133.disable();       t141.disable();
       t134.disable();       t142.disable();
       t135.disable();       t143.disable();
        t136.disable();       t144.disable();
        t137.disable();      t145.disable();   
       t138.disable();       t146.disable();
       t139.disable();       t147.disable();
       
       t13.disable();
       t9.disable();
       t8.disable();
       t10.disable();
       t11.disable();
       t12.disable();
       t20.disable();
       t21.disable();
       t22.disable();
        
         t114.disable();
          t115.disable();
          t116.disable();
   }
   
   public Connection getConn(){
        
        try {
            Class.forName("org.postgresql.Driver");
            
        } catch (ClassNotFoundException ex) {}
            
      try {
        String url="jdbc:postgresql://localhost/Hotel";
        String user="postgres";
        String password="shubhampwr";
        
        
            conn=DriverManager.getConnection(url, user, password);
            //JOptionPane.showMessageDialog(null,"connect");
        } catch (SQLException ex) {
            System.out.println(ex);
           
        }
       return conn;
        
  }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrame1 = new javax.swing.JFrame();
        l4 = new javax.swing.JLabel();
        t76 = new javax.swing.JTextField();
        t77 = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        rb4 = new javax.swing.JRadioButton();
        t14 = new javax.swing.JTextField();
        rb42 = new javax.swing.JRadioButton();
        t15 = new javax.swing.JTextField();
        rb17 = new javax.swing.JRadioButton();
        t16 = new javax.swing.JTextField();
        rb18 = new javax.swing.JRadioButton();
        t17 = new javax.swing.JTextField();
        rb19 = new javax.swing.JRadioButton();
        t18 = new javax.swing.JTextField();
        rb20 = new javax.swing.JRadioButton();
        t19 = new javax.swing.JTextField();
        rb21 = new javax.swing.JRadioButton();
        t23 = new javax.swing.JTextField();
        rb22 = new javax.swing.JRadioButton();
        t24 = new javax.swing.JTextField();
        jPanel8 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        rb23 = new javax.swing.JRadioButton();
        t25 = new javax.swing.JTextField();
        rb24 = new javax.swing.JRadioButton();
        t26 = new javax.swing.JTextField();
        rb25 = new javax.swing.JRadioButton();
        t27 = new javax.swing.JTextField();
        rb26 = new javax.swing.JRadioButton();
        t28 = new javax.swing.JTextField();
        rb27 = new javax.swing.JRadioButton();
        t29 = new javax.swing.JTextField();
        rb28 = new javax.swing.JRadioButton();
        t30 = new javax.swing.JTextField();
        rb29 = new javax.swing.JRadioButton();
        t31 = new javax.swing.JTextField();
        rb30 = new javax.swing.JRadioButton();
        t32 = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        t78 = new javax.swing.JTextField();
        t79 = new javax.swing.JTextField();
        t80 = new javax.swing.JTextField();
        t81 = new javax.swing.JTextField();
        t82 = new javax.swing.JTextField();
        t83 = new javax.swing.JTextField();
        t84 = new javax.swing.JTextField();
        t85 = new javax.swing.JTextField();
        jPanel10 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        t86 = new javax.swing.JTextField();
        t87 = new javax.swing.JTextField();
        t88 = new javax.swing.JTextField();
        t89 = new javax.swing.JTextField();
        t90 = new javax.swing.JTextField();
        t91 = new javax.swing.JTextField();
        t92 = new javax.swing.JTextField();
        t93 = new javax.swing.JTextField();
        l5 = new javax.swing.JLabel();
        tt2 = new java.awt.TextArea();
        jPanel11 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        t94 = new javax.swing.JTextField();
        t95 = new javax.swing.JTextField();
        t96 = new javax.swing.JTextField();
        t97 = new javax.swing.JTextField();
        t98 = new javax.swing.JTextField();
        t99 = new javax.swing.JTextField();
        t100 = new javax.swing.JTextField();
        t101 = new javax.swing.JTextField();
        l6 = new javax.swing.JLabel();
        t102 = new javax.swing.JTextField();
        jPanel12 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        t103 = new javax.swing.JTextField();
        t104 = new javax.swing.JTextField();
        t105 = new javax.swing.JTextField();
        t106 = new javax.swing.JTextField();
        t107 = new javax.swing.JTextField();
        t108 = new javax.swing.JTextField();
        t109 = new javax.swing.JTextField();
        t110 = new javax.swing.JTextField();
        jButton10 = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu6 = new javax.swing.JMenu();
        jMenu7 = new javax.swing.JMenu();
        jMenu8 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenu9 = new javax.swing.JMenu();
        jMenu10 = new javax.swing.JMenu();
        popupMenu1 = new java.awt.PopupMenu();
        jPanel27 = new javax.swing.JPanel();
        l0 = new javax.swing.JLabel();
        l1 = new javax.swing.JLabel();
        jInternalFrame1 = new javax.swing.JInternalFrame();
        jPanel29 = new javax.swing.JPanel();
        t56 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tt1 = new javax.swing.JTextArea();
        jLabel21 = new javax.swing.JLabel();
        t111 = new javax.swing.JTextField();
        l12 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel14 = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        rb32 = new javax.swing.JRadioButton();
        t33 = new javax.swing.JTextField();
        rb43 = new javax.swing.JRadioButton();
        t34 = new javax.swing.JTextField();
        rb33 = new javax.swing.JRadioButton();
        t35 = new javax.swing.JTextField();
        rb34 = new javax.swing.JRadioButton();
        t36 = new javax.swing.JTextField();
        rb35 = new javax.swing.JRadioButton();
        t37 = new javax.swing.JTextField();
        rb36 = new javax.swing.JRadioButton();
        t38 = new javax.swing.JTextField();
        rb37 = new javax.swing.JRadioButton();
        t39 = new javax.swing.JTextField();
        rb38 = new javax.swing.JRadioButton();
        t40 = new javax.swing.JTextField();
        jPanel16 = new javax.swing.JPanel();
        t67 = new javax.swing.JTextField();
        t112 = new javax.swing.JTextField();
        t118 = new javax.swing.JTextField();
        t119 = new javax.swing.JTextField();
        t120 = new javax.swing.JTextField();
        t121 = new javax.swing.JTextField();
        t122 = new javax.swing.JTextField();
        t123 = new javax.swing.JTextField();
        jPanel17 = new javax.swing.JPanel();
        t124 = new javax.swing.JTextField();
        t125 = new javax.swing.JTextField();
        t126 = new javax.swing.JTextField();
        t127 = new javax.swing.JTextField();
        t128 = new javax.swing.JTextField();
        t129 = new javax.swing.JTextField();
        t130 = new javax.swing.JTextField();
        t131 = new javax.swing.JTextField();
        jPanel18 = new javax.swing.JPanel();
        rb39 = new javax.swing.JRadioButton();
        t132 = new javax.swing.JTextField();
        rb40 = new javax.swing.JRadioButton();
        t133 = new javax.swing.JTextField();
        rb44 = new javax.swing.JRadioButton();
        t134 = new javax.swing.JTextField();
        rb45 = new javax.swing.JRadioButton();
        t135 = new javax.swing.JTextField();
        rb46 = new javax.swing.JRadioButton();
        t136 = new javax.swing.JTextField();
        rb47 = new javax.swing.JRadioButton();
        t137 = new javax.swing.JTextField();
        rb48 = new javax.swing.JRadioButton();
        t138 = new javax.swing.JTextField();
        rb49 = new javax.swing.JRadioButton();
        t139 = new javax.swing.JTextField();
        jPanel19 = new javax.swing.JPanel();
        t140 = new javax.swing.JTextField();
        t141 = new javax.swing.JTextField();
        t142 = new javax.swing.JTextField();
        t143 = new javax.swing.JTextField();
        t144 = new javax.swing.JTextField();
        t145 = new javax.swing.JTextField();
        t146 = new javax.swing.JTextField();
        t147 = new javax.swing.JTextField();
        jPanel20 = new javax.swing.JPanel();
        t148 = new javax.swing.JTextField();
        t149 = new javax.swing.JTextField();
        t150 = new javax.swing.JTextField();
        t151 = new javax.swing.JTextField();
        t152 = new javax.swing.JTextField();
        t153 = new javax.swing.JTextField();
        t154 = new javax.swing.JTextField();
        t155 = new javax.swing.JTextField();
        jPanel30 = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jPanel31 = new javax.swing.JPanel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        t156 = new javax.swing.JTextField();
        t114 = new javax.swing.JTextField();
        cb2 = new javax.swing.JComboBox<>();
        t115 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        rb8 = new javax.swing.JRadioButton();
        t7 = new javax.swing.JTextField();
        rb9 = new javax.swing.JRadioButton();
        t8 = new javax.swing.JTextField();
        rb10 = new javax.swing.JRadioButton();
        t10 = new javax.swing.JTextField();
        rb11 = new javax.swing.JRadioButton();
        t20 = new javax.swing.JTextField();
        rb12 = new javax.swing.JRadioButton();
        t12 = new javax.swing.JTextField();
        rb13 = new javax.swing.JRadioButton();
        t11 = new javax.swing.JTextField();
        rb14 = new javax.swing.JRadioButton();
        t21 = new javax.swing.JTextField();
        rb15 = new javax.swing.JRadioButton();
        t22 = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        t47 = new javax.swing.JTextField();
        t48 = new javax.swing.JTextField();
        t49 = new javax.swing.JTextField();
        t50 = new javax.swing.JTextField();
        t51 = new javax.swing.JTextField();
        t52 = new javax.swing.JTextField();
        t53 = new javax.swing.JTextField();
        t54 = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        t68 = new javax.swing.JTextField();
        t69 = new javax.swing.JTextField();
        t70 = new javax.swing.JTextField();
        t71 = new javax.swing.JTextField();
        t72 = new javax.swing.JTextField();
        t73 = new javax.swing.JTextField();
        t74 = new javax.swing.JTextField();
        t75 = new javax.swing.JTextField();
        jPanel13 = new javax.swing.JPanel();
        rb16 = new javax.swing.JRadioButton();
        rb6 = new javax.swing.JRadioButton();
        rb7 = new javax.swing.JRadioButton();
        rb5 = new javax.swing.JRadioButton();
        rb3 = new javax.swing.JRadioButton();
        rb2 = new javax.swing.JRadioButton();
        rb41 = new javax.swing.JRadioButton();
        rb1 = new javax.swing.JRadioButton();
        t1 = new javax.swing.JTextField();
        t2 = new javax.swing.JTextField();
        t3 = new javax.swing.JTextField();
        t4 = new javax.swing.JTextField();
        t5 = new javax.swing.JTextField();
        t6 = new javax.swing.JTextField();
        t9 = new javax.swing.JTextField();
        t13 = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        t41 = new javax.swing.JTextField();
        t42 = new javax.swing.JTextField();
        t43 = new javax.swing.JTextField();
        t44 = new javax.swing.JTextField();
        t45 = new javax.swing.JTextField();
        t46 = new javax.swing.JTextField();
        t60 = new javax.swing.JTextField();
        t58 = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        t57 = new javax.swing.JTextField();
        t59 = new javax.swing.JTextField();
        t61 = new javax.swing.JTextField();
        t62 = new javax.swing.JTextField();
        t63 = new javax.swing.JTextField();
        t64 = new javax.swing.JTextField();
        t65 = new javax.swing.JTextField();
        t66 = new javax.swing.JTextField();
        jPanel32 = new javax.swing.JPanel();
        jLabel35 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        cb3 = new javax.swing.JComboBox<>();
        t116 = new javax.swing.JTextField();
        t117 = new javax.swing.JTextField();
        t157 = new javax.swing.JTextField();
        jPanel28 = new javax.swing.JPanel();
        b4 = new javax.swing.JButton();
        l7 = new javax.swing.JLabel();
        cnt1 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        t204 = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();
        jMenu11 = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenu12 = new javax.swing.JMenu();
        jm1 = new javax.swing.JCheckBoxMenuItem();

        jFrame1.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        jFrame1.setBackground(new java.awt.Color(0, 204, 51));
        jFrame1.setMaximizedBounds(new java.awt.Rectangle(50, 50, 50, 50));
        jFrame1.setMinimumSize(new java.awt.Dimension(1300, 800));
        jFrame1.getContentPane().setLayout(null);

        l4.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        l4.setText("Date :");
        jFrame1.getContentPane().add(l4);
        l4.setBounds(740, 10, 50, 30);

        t76.setText("t55");
        t76.setRequestFocusEnabled(false);
        t76.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t76ActionPerformed(evt);
            }
        });
        jFrame1.getContentPane().add(t76);
        t76.setBounds(640, 10, 90, 30);

        t77.setText("t56");
        t77.setRequestFocusEnabled(false);
        jFrame1.getContentPane().add(t77);
        t77.setBounds(800, 10, 120, 30);

        jPanel7.setLayout(new java.awt.GridLayout(9, 2, 1, 5));

        jLabel12.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel12.setText("Quntity");
        jPanel7.add(jLabel12);

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel3.setText("Order....");
        jPanel7.add(jLabel3);

        rb4.setText("चिकन थाळी");
        rb4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rb4MouseClicked(evt);
            }
        });
        rb4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb4ActionPerformed(evt);
            }
        });
        jPanel7.add(rb4);

        t14.setText("t1");
        t14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t14ActionPerformed(evt);
            }
        });
        t14.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                t14KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                t14KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                t14KeyTyped(evt);
            }
        });
        jPanel7.add(t14);

        rb42.setText("स्पेशल चिकन थाळी");
        rb42.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rb42rb1MouseClicked(evt);
            }
        });
        rb42.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb42ActionPerformed(evt);
            }
        });
        jPanel7.add(rb42);

        t15.setText("t2");
        t15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t15ActionPerformed(evt);
            }
        });
        t15.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                t15KeyReleased(evt);
            }
        });
        jPanel7.add(t15);

        rb17.setText("मटन थाळी");
        rb17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rb17rb1MouseClicked(evt);
            }
        });
        rb17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb17ActionPerformed(evt);
            }
        });
        jPanel7.add(rb17);

        t16.setText("t3");
        t16.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                t16KeyReleased(evt);
            }
        });
        jPanel7.add(t16);

        rb18.setText("स्पेशल मटन थाळी");
        rb18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rb18rb1MouseClicked(evt);
            }
        });
        rb18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb18ActionPerformed(evt);
            }
        });
        jPanel7.add(rb18);

        t17.setText("t4");
        t17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t17ActionPerformed(evt);
            }
        });
        t17.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                t17KeyReleased(evt);
            }
        });
        jPanel7.add(t17);

        rb19.setText("चिकन हंडी  हाफ H");
        rb19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rb19rb1MouseClicked(evt);
            }
        });
        rb19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb19ActionPerformed(evt);
            }
        });
        jPanel7.add(rb19);

        t18.setText("t5");
        t18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t18ActionPerformed(evt);
            }
        });
        t18.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                t18KeyReleased(evt);
            }
        });
        jPanel7.add(t18);

        rb20.setText("चिकन हांडी फूल F");
        rb20.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rb20rb1MouseClicked(evt);
            }
        });
        rb20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb20ActionPerformed(evt);
            }
        });
        jPanel7.add(rb20);

        t19.setText("t6");
        t19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t19ActionPerformed(evt);
            }
        });
        t19.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                t19KeyReleased(evt);
            }
        });
        jPanel7.add(t19);

        rb21.setText("मटन हंडी फूल F");
        rb21.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rb21rb1MouseClicked(evt);
            }
        });
        rb21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb21ActionPerformed(evt);
            }
        });
        jPanel7.add(rb21);

        t23.setText("t9");
        t23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t23ActionPerformed(evt);
            }
        });
        t23.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                t23KeyReleased(evt);
            }
        });
        jPanel7.add(t23);

        rb22.setText("मटन हंडी  H");
        rb22.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rb22rb1MouseClicked(evt);
            }
        });
        rb22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb22ActionPerformed(evt);
            }
        });
        jPanel7.add(rb22);

        t24.setText("t13");
        t24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t24ActionPerformed(evt);
            }
        });
        t24.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                t24KeyReleased(evt);
            }
        });
        jPanel7.add(t24);

        jFrame1.getContentPane().add(jPanel7);
        jPanel7.setBounds(0, 55, 230, 290);

        jPanel8.setLayout(new java.awt.GridLayout(9, 2, 10, 5));

        jLabel13.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel13.setText("Extra :");
        jPanel8.add(jLabel13);

        jLabel14.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel14.setText("Quntity");
        jPanel8.add(jLabel14);

        rb23.setText("रोटी");
        rb23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb23ActionPerformed(evt);
            }
        });
        jPanel8.add(rb23);

        t25.setText("t7");
        t25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t25ActionPerformed(evt);
            }
        });
        t25.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                t25KeyReleased(evt);
            }
        });
        jPanel8.add(t25);

        rb24.setText("बटर रोटी");
        rb24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb24ActionPerformed(evt);
            }
        });
        jPanel8.add(rb24);

        t26.setText("t8");
        t26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t26ActionPerformed(evt);
            }
        });
        t26.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                t26KeyReleased(evt);
            }
        });
        jPanel8.add(t26);

        rb25.setText("साधा राईस  फूल");
        rb25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb25ActionPerformed(evt);
            }
        });
        jPanel8.add(rb25);

        t27.setText("t10");
        t27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t27ActionPerformed(evt);
            }
        });
        t27.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                t27KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                t27KeyTyped(evt);
            }
        });
        jPanel8.add(t27);

        rb26.setText("साधा राईस हाफ ");
        rb26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb26ActionPerformed(evt);
            }
        });
        jPanel8.add(rb26);

        t28.setText("t20");
        t28.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                t28KeyReleased(evt);
            }
        });
        jPanel8.add(t28);

        rb27.setText("जिरा राईस  फूल");
        rb27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb27ActionPerformed(evt);
            }
        });
        jPanel8.add(rb27);

        t29.setText("t12");
        t29.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t29ActionPerformed(evt);
            }
        });
        t29.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                t29KeyReleased(evt);
            }
        });
        jPanel8.add(t29);

        rb28.setText("जिरा राईस हाफ");
        rb28.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb28ActionPerformed(evt);
            }
        });
        jPanel8.add(rb28);

        t30.setText("t11");
        t30.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                t30KeyReleased(evt);
            }
        });
        jPanel8.add(t30);

        rb29.setText("पाणी (Bisleri)");
        rb29.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb29ActionPerformed(evt);
            }
        });
        jPanel8.add(rb29);

        t31.setText("t21");
        t31.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t31ActionPerformed(evt);
            }
        });
        t31.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                t31KeyReleased(evt);
            }
        });
        jPanel8.add(t31);

        rb30.setText("Coldrinks ");
        rb30.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb30ActionPerformed(evt);
            }
        });
        jPanel8.add(rb30);

        t32.setText("t22");
        t32.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t32ActionPerformed(evt);
            }
        });
        t32.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                t32KeyReleased(evt);
            }
        });
        jPanel8.add(t32);

        jFrame1.getContentPane().add(jPanel8);
        jPanel8.setBounds(380, 50, 230, 310);

        jButton5.setBackground(new java.awt.Color(153, 255, 0));
        jButton5.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton5.setText("Close");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jFrame1.getContentPane().add(jButton5);
        jButton5.setBounds(560, 460, 120, 40);

        jButton7.setBackground(new java.awt.Color(153, 255, 0));
        jButton7.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton7.setText("OK");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jFrame1.getContentPane().add(jButton7);
        jButton7.setBounds(170, 460, 120, 40);

        jLabel15.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel15.setText("BILL :");
        jFrame1.getContentPane().add(jLabel15);
        jLabel15.setBounds(930, 60, 58, 23);

        jButton8.setBackground(new java.awt.Color(153, 255, 0));
        jButton8.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton8.setText("Change");
        jFrame1.getContentPane().add(jButton8);
        jButton8.setBounds(430, 460, 120, 40);

        jButton9.setBackground(new java.awt.Color(153, 255, 0));
        jButton9.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton9.setText("Print");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        jFrame1.getContentPane().add(jButton9);
        jButton9.setBounds(300, 460, 120, 40);

        jPanel9.setLayout(new java.awt.GridLayout(9, 1, 0, 5));

        jLabel16.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel16.setText("Rate");
        jPanel9.add(jLabel16);

        t78.setText("t41");
        t78.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t78ActionPerformed(evt);
            }
        });
        jPanel9.add(t78);

        t79.setText("t42");
        t79.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t79ActionPerformed(evt);
            }
        });
        jPanel9.add(t79);

        t80.setText("t43");
        jPanel9.add(t80);

        t81.setText("t44");
        jPanel9.add(t81);

        t82.setText("t45");
        t82.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t82ActionPerformed(evt);
            }
        });
        jPanel9.add(t82);

        t83.setText("t46");
        t83.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t83ActionPerformed(evt);
            }
        });
        jPanel9.add(t83);

        t84.setText("t60");
        t84.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t84ActionPerformed(evt);
            }
        });
        jPanel9.add(t84);

        t85.setText("t58");
        t85.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t85ActionPerformed(evt);
            }
        });
        jPanel9.add(t85);

        jFrame1.getContentPane().add(jPanel9);
        jPanel9.setBounds(240, 50, 50, 300);

        jPanel10.setLayout(new java.awt.GridLayout(9, 1, 1, 5));

        jLabel17.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel17.setText("Rate");
        jPanel10.add(jLabel17);

        t86.setText("t47");
        jPanel10.add(t86);

        t87.setText("t48");
        t87.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t87ActionPerformed(evt);
            }
        });
        jPanel10.add(t87);

        t88.setText("t49");
        jPanel10.add(t88);

        t89.setText("t50");
        jPanel10.add(t89);

        t90.setText("t51");
        jPanel10.add(t90);

        t91.setText("t52");
        jPanel10.add(t91);

        t92.setText("t53");
        jPanel10.add(t92);

        t93.setText("t54");
        t93.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t93ActionPerformed(evt);
            }
        });
        jPanel10.add(t93);

        jFrame1.getContentPane().add(jPanel10);
        jPanel10.setBounds(620, 50, 60, 310);

        l5.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        l5.setText("Total :");
        jFrame1.getContentPane().add(l5);
        l5.setBounds(500, 370, 70, 30);
        jFrame1.getContentPane().add(tt2);
        tt2.setBounds(850, 100, 220, 300);

        jPanel11.setLayout(new java.awt.GridLayout(9, 1, 0, 5));

        jLabel18.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel18.setText("Total");
        jPanel11.add(jLabel18);

        t94.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                t94FocusGained(evt);
            }
        });
        t94.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t94ActionPerformed(evt);
            }
        });
        jPanel11.add(t94);

        t95.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t95ActionPerformed(evt);
            }
        });
        jPanel11.add(t95);

        t96.setText("113");
        t96.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t96ActionPerformed(evt);
            }
        });
        jPanel11.add(t96);

        t97.setText("114");
        t97.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t97ActionPerformed(evt);
            }
        });
        jPanel11.add(t97);

        t98.setText("115");
        t98.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t98ActionPerformed(evt);
            }
        });
        jPanel11.add(t98);

        t99.setText("116");
        t99.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t99ActionPerformed(evt);
            }
        });
        jPanel11.add(t99);

        t100.setText("117");
        t100.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t100ActionPerformed(evt);
            }
        });
        jPanel11.add(t100);

        t101.setText("118");
        t101.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t101ActionPerformed(evt);
            }
        });
        jPanel11.add(t101);

        jFrame1.getContentPane().add(jPanel11);
        jPanel11.setBounds(300, 50, 60, 300);

        l6.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        l6.setText("Time:");
        jFrame1.getContentPane().add(l6);
        l6.setBounds(580, 10, 50, 30);

        t102.setEditable(false);
        t102.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        t102.setText("0");
        t102.setRequestFocusEnabled(false);
        t102.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t102ActionPerformed(evt);
            }
        });
        jFrame1.getContentPane().add(t102);
        t102.setBounds(570, 370, 100, 30);

        jPanel12.setLayout(new java.awt.GridLayout(9, 1, 1, 5));

        jLabel19.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel19.setText("Rate");
        jPanel12.add(jLabel19);

        t103.setText("119");
        t103.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t103ActionPerformed(evt);
            }
        });
        jPanel12.add(t103);

        t104.setText("120");
        t104.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t104ActionPerformed(evt);
            }
        });
        jPanel12.add(t104);

        t105.setText("121");
        t105.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t105ActionPerformed(evt);
            }
        });
        jPanel12.add(t105);

        t106.setText("122");
        t106.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t106ActionPerformed(evt);
            }
        });
        jPanel12.add(t106);

        t107.setText("123");
        t107.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t107ActionPerformed(evt);
            }
        });
        jPanel12.add(t107);

        t108.setText("124");
        t108.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t108ActionPerformed(evt);
            }
        });
        jPanel12.add(t108);

        t109.setText("125");
        t109.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t109ActionPerformed(evt);
            }
        });
        jPanel12.add(t109);

        t110.setText("126");
        t110.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t110ActionPerformed(evt);
            }
        });
        jPanel12.add(t110);

        jFrame1.getContentPane().add(jPanel12);
        jPanel12.setBounds(690, 50, 60, 310);

        jButton10.setText("Reset Bill");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        jFrame1.getContentPane().add(jButton10);
        jButton10.setBounds(860, 430, 200, 23);

        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/B/img8.jpg"))); // NOI18N
        jLabel20.setText("jLabel2");
        jFrame1.getContentPane().add(jLabel20);
        jLabel20.setBounds(-90, -50, 1300, 720);

        jMenuBar2.setAlignmentX(1.0F);
        jMenuBar2.setAutoscrolls(true);
        jMenuBar2.setMinimumSize(new java.awt.Dimension(0, 4));

        jMenu6.setText("File");
        jMenu6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jMenuBar2.add(jMenu6);

        jMenu7.setText("Edit");
        jMenuBar2.add(jMenu7);

        jMenu8.setText("Set Rate");
        jMenu8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu8ActionPerformed(evt);
            }
        });

        jMenuItem3.setText("veg");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu8.add(jMenuItem3);

        jMenuItem4.setText("Non-Veg");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu8.add(jMenuItem4);

        jMenuBar2.add(jMenu8);

        jMenu9.setText("Veg");
        jMenuBar2.add(jMenu9);

        jMenu10.setText("Non-veg");
        jMenuBar2.add(jMenu10);

        jFrame1.setJMenuBar(jMenuBar2);

        popupMenu1.setLabel("popupMenu1");
        popupMenu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                popupMenu1ActionPerformed(evt);
            }
        });

        setBackground(new java.awt.Color(0, 204, 51));
        setMaximizedBounds(new java.awt.Rectangle(50, 50, 50, 50));
        setMinimumSize(new java.awt.Dimension(1400, 800));
        getContentPane().setLayout(null);

        jPanel27.setBackground(new java.awt.Color(0, 255, 255));
        jPanel27.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        jPanel27.setLayout(null);

        l0.setFont(new java.awt.Font("Copperplate Gothic Bold", 1, 36)); // NOI18N
        l0.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        l0.setText("Hotel Name");
        jPanel27.add(l0);
        l0.setBounds(310, 0, 660, 70);

        l1.setBackground(new java.awt.Color(255, 204, 204));
        l1.setFont(new java.awt.Font("Copperplate Gothic Bold", 1, 28)); // NOI18N
        l1.setForeground(new java.awt.Color(255, 0, 51));
        l1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        l1.setText("time");
        jPanel27.add(l1);
        l1.setBounds(890, 10, 280, 50);

        jInternalFrame1.setVisible(true);
        jPanel27.add(jInternalFrame1);
        jInternalFrame1.setBounds(50, 10, 22, 34);

        getContentPane().add(jPanel27);
        jPanel27.setBounds(0, 0, 1510, 70);

        jPanel29.setBackground(new java.awt.Color(204, 255, 255));
        jPanel29.setLayout(null);

        t56.setEditable(false);
        t56.setBackground(new java.awt.Color(204, 255, 255));
        t56.setRequestFocusEnabled(false);
        t56.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t56ActionPerformed(evt);
            }
        });
        jPanel29.add(t56);
        t56.setBounds(50, 10, 120, 30);

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/B/bill.png"))); // NOI18N
        jLabel7.setText("BILL :");
        jPanel29.add(jLabel7);
        jLabel7.setBounds(1110, 40, 100, 40);

        jButton6.setFont(new java.awt.Font("SimSun-ExtB", 1, 14)); // NOI18N
        jButton6.setText("Reset Bill");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel29.add(jButton6);
        jButton6.setBounds(1130, 460, 200, 40);

        jScrollPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        tt1.setColumns(20);
        tt1.setRows(5);
        jScrollPane1.setViewportView(tt1);

        jPanel29.add(jScrollPane1);
        jScrollPane1.setBounds(1100, 80, 250, 370);

        jLabel21.setFont(new java.awt.Font("SimSun", 1, 18)); // NOI18N
        jLabel21.setText("Customer No");
        jPanel29.add(jLabel21);
        jLabel21.setBounds(300, 20, 130, 40);

        t111.setEditable(false);
        t111.setBackground(new java.awt.Color(204, 255, 255));
        t111.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 20)); // NOI18N
        t111.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        t111.setText("1");
        t111.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        t111.setRequestFocusEnabled(false);
        t111.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t111ActionPerformed(evt);
            }
        });
        jPanel29.add(t111);
        t111.setBounds(420, 30, 60, 40);

        l12.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        l12.setText("Date :");
        jPanel29.add(l12);
        l12.setBounds(0, 10, 50, 30);

        jTabbedPane1.setBackground(new java.awt.Color(204, 255, 255));
        jTabbedPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTabbedPane1.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);
        jTabbedPane1.setTabPlacement(javax.swing.JTabbedPane.LEFT);
        jTabbedPane1.setAutoscrolls(true);
        jTabbedPane1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N

        jPanel14.setBackground(new java.awt.Color(204, 255, 255));
        jPanel14.setLayout(null);

        jPanel15.setBackground(new java.awt.Color(204, 255, 255));
        jPanel15.setLayout(null);

        rb32.setBackground(new java.awt.Color(204, 255, 255));
        rb32.setText("menu 1");
        rb32.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rb32MouseClicked(evt);
            }
        });
        rb32.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb32ActionPerformed(evt);
            }
        });
        jPanel15.add(rb32);
        rb32.setBounds(10, 10, 114, 35);

        t33.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t33ActionPerformed(evt);
            }
        });
        t33.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                t33KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                t33KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                t33KeyTyped(evt);
            }
        });
        jPanel15.add(t33);
        t33.setBounds(120, 10, 114, 35);

        rb43.setBackground(new java.awt.Color(204, 255, 255));
        rb43.setText("menu 2");
        rb43.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rb43rb1MouseClicked(evt);
            }
        });
        rb43.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb43ActionPerformed(evt);
            }
        });
        jPanel15.add(rb43);
        rb43.setBounds(10, 50, 114, 35);

        t34.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t34ActionPerformed(evt);
            }
        });
        t34.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                t34KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                t34KeyReleased(evt);
            }
        });
        jPanel15.add(t34);
        t34.setBounds(120, 50, 114, 35);

        rb33.setBackground(new java.awt.Color(204, 255, 255));
        rb33.setText("menu 3");
        rb33.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rb33rb1MouseClicked(evt);
            }
        });
        rb33.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb33ActionPerformed(evt);
            }
        });
        jPanel15.add(rb33);
        rb33.setBounds(10, 90, 114, 35);

        t35.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                t35KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                t35KeyReleased(evt);
            }
        });
        jPanel15.add(t35);
        t35.setBounds(120, 90, 114, 35);

        rb34.setBackground(new java.awt.Color(204, 255, 255));
        rb34.setText("menu 4");
        rb34.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rb34rb1MouseClicked(evt);
            }
        });
        rb34.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb34ActionPerformed(evt);
            }
        });
        jPanel15.add(rb34);
        rb34.setBounds(10, 130, 114, 35);

        t36.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t36ActionPerformed(evt);
            }
        });
        t36.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                t36KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                t36KeyReleased(evt);
            }
        });
        jPanel15.add(t36);
        t36.setBounds(120, 130, 114, 35);

        rb35.setBackground(new java.awt.Color(204, 255, 255));
        rb35.setText("menu 5");
        rb35.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rb35rb1MouseClicked(evt);
            }
        });
        rb35.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb35ActionPerformed(evt);
            }
        });
        jPanel15.add(rb35);
        rb35.setBounds(10, 170, 114, 35);

        t37.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t37ActionPerformed(evt);
            }
        });
        t37.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                t37KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                t37KeyReleased(evt);
            }
        });
        jPanel15.add(t37);
        t37.setBounds(120, 170, 114, 35);

        rb36.setBackground(new java.awt.Color(204, 255, 255));
        rb36.setText("menu 6");
        rb36.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rb36rb1MouseClicked(evt);
            }
        });
        rb36.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb36ActionPerformed(evt);
            }
        });
        jPanel15.add(rb36);
        rb36.setBounds(10, 210, 114, 35);

        t38.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t38ActionPerformed(evt);
            }
        });
        t38.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                t38KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                t38KeyReleased(evt);
            }
        });
        jPanel15.add(t38);
        t38.setBounds(120, 210, 114, 35);

        rb37.setBackground(new java.awt.Color(204, 255, 255));
        rb37.setText("menu 7");
        rb37.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rb37rb1MouseClicked(evt);
            }
        });
        rb37.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb37ActionPerformed(evt);
            }
        });
        jPanel15.add(rb37);
        rb37.setBounds(10, 250, 114, 35);

        t39.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t39ActionPerformed(evt);
            }
        });
        t39.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                t39KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                t39KeyReleased(evt);
            }
        });
        jPanel15.add(t39);
        t39.setBounds(120, 250, 114, 35);

        rb38.setBackground(new java.awt.Color(204, 255, 255));
        rb38.setText("menu 8");
        rb38.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rb38rb1MouseClicked(evt);
            }
        });
        rb38.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb38ActionPerformed(evt);
            }
        });
        jPanel15.add(rb38);
        rb38.setBounds(10, 290, 114, 35);

        t40.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t40ActionPerformed(evt);
            }
        });
        t40.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                t40KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                t40KeyReleased(evt);
            }
        });
        jPanel15.add(t40);
        t40.setBounds(124, 290, 110, 35);

        jPanel16.setBackground(new java.awt.Color(204, 255, 255));
        jPanel16.setLayout(new java.awt.GridLayout(8, 1, 0, 5));

        t67.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t67ActionPerformed(evt);
            }
        });
        t67.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                t67KeyReleased(evt);
            }
        });
        jPanel16.add(t67);

        t112.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t112ActionPerformed(evt);
            }
        });
        t112.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                t112KeyReleased(evt);
            }
        });
        jPanel16.add(t112);

        t118.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t118ActionPerformed(evt);
            }
        });
        t118.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                t118KeyReleased(evt);
            }
        });
        jPanel16.add(t118);

        t119.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t119ActionPerformed(evt);
            }
        });
        t119.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                t119KeyReleased(evt);
            }
        });
        jPanel16.add(t119);

        t120.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t120ActionPerformed(evt);
            }
        });
        t120.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                t120KeyReleased(evt);
            }
        });
        jPanel16.add(t120);

        t121.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t121ActionPerformed(evt);
            }
        });
        t121.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                t121KeyReleased(evt);
            }
        });
        jPanel16.add(t121);

        t122.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t122ActionPerformed(evt);
            }
        });
        t122.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                t122KeyReleased(evt);
            }
        });
        jPanel16.add(t122);

        t123.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t123ActionPerformed(evt);
            }
        });
        t123.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                t123KeyReleased(evt);
            }
        });
        jPanel16.add(t123);

        jPanel15.add(jPanel16);
        jPanel16.setBounds(240, 10, 60, 320);

        jPanel17.setBackground(new java.awt.Color(204, 255, 255));
        jPanel17.setLayout(new java.awt.GridLayout(8, 1, 0, 5));

        t124.setFont(new java.awt.Font("SimSun", 1, 14)); // NOI18N
        t124.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        t124.setText("0");
        t124.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        t124.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                t124FocusGained(evt);
            }
        });
        t124.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t124ActionPerformed(evt);
            }
        });
        jPanel17.add(t124);

        t125.setFont(new java.awt.Font("SimSun", 1, 14)); // NOI18N
        t125.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        t125.setText("0");
        t125.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        t125.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t125ActionPerformed(evt);
            }
        });
        jPanel17.add(t125);

        t126.setFont(new java.awt.Font("SimSun", 1, 14)); // NOI18N
        t126.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        t126.setText("0");
        t126.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        t126.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t126ActionPerformed(evt);
            }
        });
        jPanel17.add(t126);

        t127.setFont(new java.awt.Font("SimSun", 1, 14)); // NOI18N
        t127.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        t127.setText("0");
        t127.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        t127.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t127ActionPerformed(evt);
            }
        });
        jPanel17.add(t127);

        t128.setFont(new java.awt.Font("SimSun", 1, 14)); // NOI18N
        t128.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        t128.setText("0");
        t128.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        t128.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t128ActionPerformed(evt);
            }
        });
        jPanel17.add(t128);

        t129.setFont(new java.awt.Font("SimSun", 1, 14)); // NOI18N
        t129.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        t129.setText("0");
        t129.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        t129.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t129ActionPerformed(evt);
            }
        });
        jPanel17.add(t129);

        t130.setFont(new java.awt.Font("SimSun", 1, 14)); // NOI18N
        t130.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        t130.setText("0");
        t130.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        t130.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t130ActionPerformed(evt);
            }
        });
        jPanel17.add(t130);

        t131.setFont(new java.awt.Font("SimSun", 1, 14)); // NOI18N
        t131.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        t131.setText("0");
        t131.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        t131.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t131ActionPerformed(evt);
            }
        });
        jPanel17.add(t131);

        jPanel15.add(jPanel17);
        jPanel17.setBounds(310, 10, 60, 320);

        jPanel14.add(jPanel15);
        jPanel15.setBounds(10, 90, 380, 340);

        jPanel18.setBackground(new java.awt.Color(204, 255, 255));
        jPanel18.setLayout(null);

        rb39.setBackground(new java.awt.Color(204, 255, 255));
        rb39.setText("रोटी");
        rb39.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb39ActionPerformed(evt);
            }
        });
        jPanel18.add(rb39);
        rb39.setBounds(10, 10, 110, 37);

        t132.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t132ActionPerformed(evt);
            }
        });
        t132.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                t132KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                t132KeyReleased(evt);
            }
        });
        jPanel18.add(t132);
        t132.setBounds(130, 10, 110, 37);

        rb40.setBackground(new java.awt.Color(204, 255, 255));
        rb40.setText("बटर रोटी");
        rb40.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb40ActionPerformed(evt);
            }
        });
        jPanel18.add(rb40);
        rb40.setBounds(10, 50, 110, 37);

        t133.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t133ActionPerformed(evt);
            }
        });
        t133.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                t133KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                t133KeyReleased(evt);
            }
        });
        jPanel18.add(t133);
        t133.setBounds(130, 50, 110, 37);

        rb44.setBackground(new java.awt.Color(204, 255, 255));
        rb44.setText("साधा राईस  फूल");
        rb44.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb44ActionPerformed(evt);
            }
        });
        jPanel18.add(rb44);
        rb44.setBounds(10, 90, 110, 37);

        t134.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t134ActionPerformed(evt);
            }
        });
        t134.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                t134KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                t134KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                t134KeyTyped(evt);
            }
        });
        jPanel18.add(t134);
        t134.setBounds(130, 90, 110, 37);

        rb45.setBackground(new java.awt.Color(204, 255, 255));
        rb45.setText("साधा राईस हाफ ");
        rb45.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb45ActionPerformed(evt);
            }
        });
        jPanel18.add(rb45);
        rb45.setBounds(10, 130, 110, 37);

        t135.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                t135KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                t135KeyReleased(evt);
            }
        });
        jPanel18.add(t135);
        t135.setBounds(130, 130, 110, 37);

        rb46.setBackground(new java.awt.Color(204, 255, 255));
        rb46.setText("जिरा राईस  फूल");
        rb46.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb46ActionPerformed(evt);
            }
        });
        jPanel18.add(rb46);
        rb46.setBounds(10, 170, 110, 37);

        t136.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t136ActionPerformed(evt);
            }
        });
        t136.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                t136KeyReleased(evt);
            }
        });
        jPanel18.add(t136);
        t136.setBounds(130, 170, 110, 37);

        rb47.setBackground(new java.awt.Color(204, 255, 255));
        rb47.setText("जिरा राईस हाफ");
        rb47.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb47ActionPerformed(evt);
            }
        });
        jPanel18.add(rb47);
        rb47.setBounds(10, 210, 110, 37);

        t137.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                t137KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                t137KeyReleased(evt);
            }
        });
        jPanel18.add(t137);
        t137.setBounds(130, 210, 110, 37);

        rb48.setBackground(new java.awt.Color(204, 255, 255));
        rb48.setText("पाणी (Bisleri)");
        rb48.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb48ActionPerformed(evt);
            }
        });
        jPanel18.add(rb48);
        rb48.setBounds(10, 250, 110, 37);

        t138.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t138ActionPerformed(evt);
            }
        });
        t138.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                t138KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                t138KeyReleased(evt);
            }
        });
        jPanel18.add(t138);
        t138.setBounds(130, 250, 110, 37);

        rb49.setBackground(new java.awt.Color(204, 255, 255));
        rb49.setText("Coldrinks ");
        rb49.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb49ActionPerformed(evt);
            }
        });
        jPanel18.add(rb49);
        rb49.setBounds(10, 290, 110, 37);

        t139.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t139ActionPerformed(evt);
            }
        });
        t139.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                t139KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                t139KeyReleased(evt);
            }
        });
        jPanel18.add(t139);
        t139.setBounds(130, 290, 110, 37);

        jPanel19.setBackground(new java.awt.Color(204, 255, 255));
        jPanel19.setLayout(new java.awt.GridLayout(8, 1, 1, 5));

        t140.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                t140KeyReleased(evt);
            }
        });
        jPanel19.add(t140);

        t141.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t141ActionPerformed(evt);
            }
        });
        t141.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                t141KeyReleased(evt);
            }
        });
        jPanel19.add(t141);

        t142.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                t142KeyReleased(evt);
            }
        });
        jPanel19.add(t142);

        t143.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                t143KeyReleased(evt);
            }
        });
        jPanel19.add(t143);

        t144.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                t144KeyReleased(evt);
            }
        });
        jPanel19.add(t144);

        t145.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                t145KeyReleased(evt);
            }
        });
        jPanel19.add(t145);

        t146.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                t146KeyReleased(evt);
            }
        });
        jPanel19.add(t146);

        t147.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t147ActionPerformed(evt);
            }
        });
        t147.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                t147KeyReleased(evt);
            }
        });
        jPanel19.add(t147);

        jPanel18.add(jPanel19);
        jPanel19.setBounds(250, 10, 50, 320);

        jPanel20.setBackground(new java.awt.Color(204, 255, 255));
        jPanel20.setLayout(new java.awt.GridLayout(8, 1, 1, 5));

        t148.setFont(new java.awt.Font("SimSun", 1, 14)); // NOI18N
        t148.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        t148.setText("0");
        t148.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        t148.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t148ActionPerformed(evt);
            }
        });
        jPanel20.add(t148);

        t149.setFont(new java.awt.Font("SimSun", 1, 14)); // NOI18N
        t149.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        t149.setText("0");
        t149.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        t149.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t149ActionPerformed(evt);
            }
        });
        jPanel20.add(t149);

        t150.setFont(new java.awt.Font("SimSun", 1, 14)); // NOI18N
        t150.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        t150.setText("0");
        t150.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        t150.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t150ActionPerformed(evt);
            }
        });
        jPanel20.add(t150);

        t151.setFont(new java.awt.Font("SimSun", 1, 14)); // NOI18N
        t151.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        t151.setText("0");
        t151.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        t151.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t151ActionPerformed(evt);
            }
        });
        jPanel20.add(t151);

        t152.setFont(new java.awt.Font("SimSun", 1, 14)); // NOI18N
        t152.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        t152.setText("0");
        t152.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        t152.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t152ActionPerformed(evt);
            }
        });
        jPanel20.add(t152);

        t153.setFont(new java.awt.Font("SimSun", 1, 14)); // NOI18N
        t153.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        t153.setText("0");
        t153.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        t153.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t153ActionPerformed(evt);
            }
        });
        jPanel20.add(t153);

        t154.setFont(new java.awt.Font("SimSun", 1, 14)); // NOI18N
        t154.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        t154.setText("0");
        t154.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        t154.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t154ActionPerformed(evt);
            }
        });
        jPanel20.add(t154);

        t155.setFont(new java.awt.Font("SimSun", 1, 14)); // NOI18N
        t155.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        t155.setText("0");
        t155.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        t155.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t155ActionPerformed(evt);
            }
        });
        jPanel20.add(t155);

        jPanel18.add(jPanel20);
        jPanel20.setBounds(310, 10, 70, 320);

        jPanel14.add(jPanel18);
        jPanel18.setBounds(460, 100, 410, 340);

        jPanel30.setBackground(new java.awt.Color(204, 204, 255));
        jPanel30.setLayout(null);

        jLabel29.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel29.setText("Extra :");
        jPanel30.add(jLabel29);
        jLabel29.setBounds(500, 20, 110, 37);

        jLabel30.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel30.setText("Quntity");
        jPanel30.add(jLabel30);
        jLabel30.setBounds(620, 20, 110, 37);

        jLabel31.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel31.setText("Rate");
        jPanel30.add(jLabel31);
        jLabel31.setBounds(730, 20, 50, 37);

        jLabel32.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel32.setText("Extra :");
        jPanel30.add(jLabel32);
        jLabel32.setBounds(10, 0, 110, 20);

        jLabel33.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel33.setText("Quntity");
        jPanel30.add(jLabel33);
        jLabel33.setBounds(130, 0, 110, 20);

        jLabel34.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel34.setText("Rate");
        jPanel30.add(jLabel34);
        jLabel34.setBounds(240, 0, 50, 20);

        jLabel28.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel28.setText("RS");
        jPanel30.add(jLabel28);
        jLabel28.setBounds(340, 0, 40, 20);

        jPanel14.add(jPanel30);
        jPanel30.setBounds(10, 10, 390, 30);

        jPanel31.setBackground(new java.awt.Color(204, 204, 255));
        jPanel31.setLayout(null);

        jLabel36.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel36.setText("Extra :");
        jPanel31.add(jLabel36);
        jLabel36.setBounds(500, 20, 110, 37);

        jLabel37.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel37.setText("Quntity");
        jPanel31.add(jLabel37);
        jLabel37.setBounds(620, 20, 110, 37);

        jLabel38.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel38.setText("Rate");
        jPanel31.add(jLabel38);
        jLabel38.setBounds(730, 20, 50, 37);

        jLabel39.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel39.setText("Extra :");
        jPanel31.add(jLabel39);
        jLabel39.setBounds(10, 0, 110, 20);

        jLabel40.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel40.setText("Quntity");
        jPanel31.add(jLabel40);
        jLabel40.setBounds(130, 0, 110, 20);

        jLabel41.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel41.setText("Rate");
        jPanel31.add(jLabel41);
        jLabel41.setBounds(240, 0, 50, 20);

        jLabel42.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel42.setText("RS");
        jPanel31.add(jLabel42);
        jLabel42.setBounds(340, 0, 40, 20);

        jPanel14.add(jPanel31);
        jPanel31.setBounds(480, 10, 390, 30);

        t156.setFont(new java.awt.Font("SimSun", 1, 14)); // NOI18N
        t156.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        t156.setText("0");
        t156.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        t156.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                t156FocusGained(evt);
            }
        });
        t156.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t156ActionPerformed(evt);
            }
        });
        jPanel14.add(t156);
        t156.setBounds(320, 50, 60, 30);

        t114.setBackground(new java.awt.Color(153, 255, 255));
        t114.setFont(new java.awt.Font("Copperplate Gothic Bold", 1, 14)); // NOI18N
        t114.setForeground(new java.awt.Color(153, 0, 153));
        t114.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        t114.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        t114.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t114ActionPerformed(evt);
            }
        });
        jPanel14.add(t114);
        t114.setBounds(250, 50, 60, 32);

        cb2.setBackground(new java.awt.Color(153, 255, 255));
        cb2.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 14)); // NOI18N
        cb2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cb2MouseClicked(evt);
            }
        });
        cb2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb2ActionPerformed(evt);
            }
        });
        cb2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cb2KeyPressed(evt);
            }
        });
        jPanel14.add(cb2);
        cb2.setBounds(10, 50, 130, 30);

        t115.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t115ActionPerformed(evt);
            }
        });
        t115.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                t115KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                t115KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                t115KeyTyped(evt);
            }
        });
        jPanel14.add(t115);
        t115.setBounds(154, 50, 90, 30);

        jTabbedPane1.addTab("Veg", jPanel14);

        jPanel1.setBackground(new java.awt.Color(204, 255, 255));
        jPanel1.setLayout(null);

        jPanel2.setBackground(new java.awt.Color(204, 255, 255));
        jPanel2.setLayout(null);

        rb8.setBackground(new java.awt.Color(204, 255, 255));
        rb8.setText("रोटी");
        rb8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb8ActionPerformed(evt);
            }
        });
        jPanel2.add(rb8);
        rb8.setBounds(0, 17, 110, 40);

        t7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t7ActionPerformed(evt);
            }
        });
        t7.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                t7KeyReleased(evt);
            }
        });
        jPanel2.add(t7);
        t7.setBounds(110, 20, 110, 40);

        rb9.setBackground(new java.awt.Color(204, 255, 255));
        rb9.setText("बटर रोटी");
        rb9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb9ActionPerformed(evt);
            }
        });
        jPanel2.add(rb9);
        rb9.setBounds(0, 57, 110, 40);

        t8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t8ActionPerformed(evt);
            }
        });
        t8.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                t8KeyReleased(evt);
            }
        });
        jPanel2.add(t8);
        t8.setBounds(110, 60, 110, 40);

        rb10.setBackground(new java.awt.Color(204, 255, 255));
        rb10.setText("साधा राईस  फूल");
        rb10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb10ActionPerformed(evt);
            }
        });
        jPanel2.add(rb10);
        rb10.setBounds(0, 97, 110, 40);

        t10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t10ActionPerformed(evt);
            }
        });
        t10.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                t10KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                t10KeyTyped(evt);
            }
        });
        jPanel2.add(t10);
        t10.setBounds(110, 100, 110, 40);

        rb11.setBackground(new java.awt.Color(204, 255, 255));
        rb11.setText("साधा राईस हाफ ");
        rb11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb11ActionPerformed(evt);
            }
        });
        jPanel2.add(rb11);
        rb11.setBounds(0, 137, 110, 40);

        t20.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                t20KeyReleased(evt);
            }
        });
        jPanel2.add(t20);
        t20.setBounds(110, 140, 110, 40);

        rb12.setBackground(new java.awt.Color(204, 255, 255));
        rb12.setText("जिरा राईस  फूल");
        rb12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb12ActionPerformed(evt);
            }
        });
        jPanel2.add(rb12);
        rb12.setBounds(0, 177, 110, 40);

        t12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t12ActionPerformed(evt);
            }
        });
        t12.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                t12KeyReleased(evt);
            }
        });
        jPanel2.add(t12);
        t12.setBounds(110, 180, 110, 40);

        rb13.setBackground(new java.awt.Color(204, 255, 255));
        rb13.setText("जिरा राईस हाफ");
        rb13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb13ActionPerformed(evt);
            }
        });
        jPanel2.add(rb13);
        rb13.setBounds(0, 220, 110, 40);

        t11.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                t11KeyReleased(evt);
            }
        });
        jPanel2.add(t11);
        t11.setBounds(110, 220, 110, 40);

        rb14.setBackground(new java.awt.Color(204, 255, 255));
        rb14.setText("पाणी (Bisleri)");
        rb14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb14ActionPerformed(evt);
            }
        });
        jPanel2.add(rb14);
        rb14.setBounds(0, 267, 110, 40);

        t21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t21ActionPerformed(evt);
            }
        });
        t21.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                t21KeyReleased(evt);
            }
        });
        jPanel2.add(t21);
        t21.setBounds(110, 260, 110, 40);

        rb15.setBackground(new java.awt.Color(204, 255, 255));
        rb15.setText("Coldrinks ");
        rb15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb15ActionPerformed(evt);
            }
        });
        jPanel2.add(rb15);
        rb15.setBounds(0, 307, 110, 40);

        t22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t22ActionPerformed(evt);
            }
        });
        t22.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                t22KeyReleased(evt);
            }
        });
        jPanel2.add(t22);
        t22.setBounds(110, 300, 110, 40);

        jPanel3.setBackground(new java.awt.Color(204, 255, 255));
        jPanel3.setLayout(null);

        t47.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t47ActionPerformed(evt);
            }
        });
        jPanel3.add(t47);
        t47.setBounds(0, 20, 50, 40);

        t48.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t48ActionPerformed(evt);
            }
        });
        jPanel3.add(t48);
        t48.setBounds(0, 60, 50, 40);
        jPanel3.add(t49);
        t49.setBounds(0, 100, 50, 40);
        jPanel3.add(t50);
        t50.setBounds(0, 140, 50, 40);
        jPanel3.add(t51);
        t51.setBounds(0, 180, 50, 40);
        jPanel3.add(t52);
        t52.setBounds(0, 220, 50, 40);
        jPanel3.add(t53);
        t53.setBounds(0, 260, 50, 40);

        t54.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t54ActionPerformed(evt);
            }
        });
        jPanel3.add(t54);
        t54.setBounds(0, 300, 50, 40);

        jPanel2.add(jPanel3);
        jPanel3.setBounds(230, 0, 50, 340);

        jPanel5.setBackground(new java.awt.Color(204, 255, 255));
        jPanel5.setLayout(null);

        t68.setFont(new java.awt.Font("SimSun", 1, 14)); // NOI18N
        t68.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        t68.setText("0");
        t68.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        t68.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t68ActionPerformed(evt);
            }
        });
        jPanel5.add(t68);
        t68.setBounds(0, 10, 80, 40);

        t69.setFont(new java.awt.Font("SimSun", 1, 14)); // NOI18N
        t69.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        t69.setText("0");
        t69.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        t69.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t69ActionPerformed(evt);
            }
        });
        jPanel5.add(t69);
        t69.setBounds(0, 50, 80, 40);

        t70.setFont(new java.awt.Font("SimSun", 1, 14)); // NOI18N
        t70.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        t70.setText("0");
        t70.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        t70.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t70ActionPerformed(evt);
            }
        });
        jPanel5.add(t70);
        t70.setBounds(0, 90, 80, 40);

        t71.setFont(new java.awt.Font("SimSun", 1, 14)); // NOI18N
        t71.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        t71.setText("0");
        t71.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        t71.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t71ActionPerformed(evt);
            }
        });
        jPanel5.add(t71);
        t71.setBounds(0, 130, 80, 40);

        t72.setFont(new java.awt.Font("SimSun", 1, 14)); // NOI18N
        t72.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        t72.setText("0");
        t72.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        t72.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t72ActionPerformed(evt);
            }
        });
        jPanel5.add(t72);
        t72.setBounds(0, 170, 80, 40);

        t73.setFont(new java.awt.Font("SimSun", 1, 14)); // NOI18N
        t73.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        t73.setText("0");
        t73.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        t73.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t73ActionPerformed(evt);
            }
        });
        jPanel5.add(t73);
        t73.setBounds(0, 210, 80, 40);

        t74.setFont(new java.awt.Font("SimSun", 1, 14)); // NOI18N
        t74.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        t74.setText("0");
        t74.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        t74.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t74ActionPerformed(evt);
            }
        });
        jPanel5.add(t74);
        t74.setBounds(0, 250, 80, 40);

        t75.setFont(new java.awt.Font("SimSun", 1, 14)); // NOI18N
        t75.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        t75.setText("0");
        t75.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        t75.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t75ActionPerformed(evt);
            }
        });
        jPanel5.add(t75);
        t75.setBounds(0, 290, 80, 40);

        jPanel2.add(jPanel5);
        jPanel5.setBounds(300, 10, 90, 330);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(410, 100, 450, 350);

        jPanel13.setBackground(new java.awt.Color(204, 255, 255));
        jPanel13.setLayout(null);

        rb16.setBackground(new java.awt.Color(204, 255, 255));
        rb16.setText("मटन हंडी  H");
        rb16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rb1MouseClicked(evt);
            }
        });
        rb16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb16ActionPerformed(evt);
            }
        });
        jPanel13.add(rb16);
        rb16.setBounds(10, 290, 114, 30);

        rb6.setBackground(new java.awt.Color(204, 255, 255));
        rb6.setText("मटन हंडी फूल F");
        rb6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rb1MouseClicked(evt);
            }
        });
        rb6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb6ActionPerformed(evt);
            }
        });
        jPanel13.add(rb6);
        rb6.setBounds(10, 250, 114, 30);

        rb7.setBackground(new java.awt.Color(204, 255, 255));
        rb7.setText("चिकन हांडी फूल F");
        rb7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rb1MouseClicked(evt);
            }
        });
        rb7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb7ActionPerformed(evt);
            }
        });
        jPanel13.add(rb7);
        rb7.setBounds(10, 210, 114, 30);

        rb5.setBackground(new java.awt.Color(204, 255, 255));
        rb5.setText("चिकन हंडी  हाफ H");
        rb5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rb1MouseClicked(evt);
            }
        });
        rb5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb5ActionPerformed(evt);
            }
        });
        jPanel13.add(rb5);
        rb5.setBounds(10, 170, 114, 30);

        rb3.setBackground(new java.awt.Color(204, 255, 255));
        rb3.setText("स्पेशल मटन थाळी");
        rb3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rb1MouseClicked(evt);
            }
        });
        rb3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb3ActionPerformed(evt);
            }
        });
        jPanel13.add(rb3);
        rb3.setBounds(10, 130, 114, 30);

        rb2.setBackground(new java.awt.Color(204, 255, 255));
        rb2.setText("मटन थाळी");
        rb2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rb1MouseClicked(evt);
            }
        });
        rb2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb2ActionPerformed(evt);
            }
        });
        jPanel13.add(rb2);
        rb2.setBounds(10, 90, 114, 30);

        rb41.setBackground(new java.awt.Color(204, 255, 255));
        rb41.setText("स्पेशल चिकन थाळी");
        rb41.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rb1MouseClicked(evt);
            }
        });
        rb41.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb41ActionPerformed(evt);
            }
        });
        jPanel13.add(rb41);
        rb41.setBounds(10, 50, 114, 30);

        rb1.setBackground(new java.awt.Color(204, 255, 255));
        rb1.setText("चिकन थाळी");
        rb1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rb1MouseClicked(evt);
            }
        });
        rb1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb1ActionPerformed(evt);
            }
        });
        jPanel13.add(rb1);
        rb1.setBounds(10, 10, 114, 30);

        t1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t1ActionPerformed(evt);
            }
        });
        t1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                t1KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                t1KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                t1KeyTyped(evt);
            }
        });
        jPanel13.add(t1);
        t1.setBounds(120, 10, 114, 40);

        t2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t2ActionPerformed(evt);
            }
        });
        t2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                t2KeyReleased(evt);
            }
        });
        jPanel13.add(t2);
        t2.setBounds(120, 50, 114, 40);

        t3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                t3KeyReleased(evt);
            }
        });
        jPanel13.add(t3);
        t3.setBounds(120, 90, 114, 40);

        t4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t4ActionPerformed(evt);
            }
        });
        t4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                t4KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                t4KeyReleased(evt);
            }
        });
        jPanel13.add(t4);
        t4.setBounds(120, 130, 114, 40);

        t5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t5ActionPerformed(evt);
            }
        });
        t5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                t5KeyReleased(evt);
            }
        });
        jPanel13.add(t5);
        t5.setBounds(120, 170, 114, 40);

        t6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t6ActionPerformed(evt);
            }
        });
        t6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                t6KeyReleased(evt);
            }
        });
        jPanel13.add(t6);
        t6.setBounds(120, 210, 114, 40);

        t9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t9ActionPerformed(evt);
            }
        });
        t9.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                t9KeyReleased(evt);
            }
        });
        jPanel13.add(t9);
        t9.setBounds(120, 250, 114, 40);

        t13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t13ActionPerformed(evt);
            }
        });
        t13.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                t13KeyReleased(evt);
            }
        });
        jPanel13.add(t13);
        t13.setBounds(120, 290, 114, 40);

        jPanel4.setBackground(new java.awt.Color(204, 255, 255));
        jPanel4.setLayout(null);

        t41.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t41ActionPerformed(evt);
            }
        });
        jPanel4.add(t41);
        t41.setBounds(0, 11, 50, 40);

        t42.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t42ActionPerformed(evt);
            }
        });
        jPanel4.add(t42);
        t42.setBounds(0, 50, 50, 40);

        t43.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t43ActionPerformed(evt);
            }
        });
        jPanel4.add(t43);
        t43.setBounds(0, 89, 50, 40);

        t44.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t44ActionPerformed(evt);
            }
        });
        jPanel4.add(t44);
        t44.setBounds(0, 130, 50, 40);

        t45.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t45ActionPerformed(evt);
            }
        });
        jPanel4.add(t45);
        t45.setBounds(0, 170, 50, 40);

        t46.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t46ActionPerformed(evt);
            }
        });
        jPanel4.add(t46);
        t46.setBounds(0, 210, 50, 40);

        t60.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t60ActionPerformed(evt);
            }
        });
        jPanel4.add(t60);
        t60.setBounds(0, 250, 50, 40);

        t58.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t58ActionPerformed(evt);
            }
        });
        jPanel4.add(t58);
        t58.setBounds(0, 290, 50, 40);

        jPanel13.add(jPanel4);
        jPanel4.setBounds(240, 0, 50, 340);

        jPanel6.setBackground(new java.awt.Color(204, 255, 255));
        jPanel6.setLayout(null);

        t57.setFont(new java.awt.Font("SimSun", 1, 14)); // NOI18N
        t57.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        t57.setText("0");
        t57.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        t57.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                t57FocusGained(evt);
            }
        });
        t57.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t57ActionPerformed(evt);
            }
        });
        jPanel6.add(t57);
        t57.setBounds(0, 0, 60, 40);

        t59.setFont(new java.awt.Font("SimSun", 1, 14)); // NOI18N
        t59.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        t59.setText("0");
        t59.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        t59.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t59ActionPerformed(evt);
            }
        });
        jPanel6.add(t59);
        t59.setBounds(0, 40, 60, 40);

        t61.setFont(new java.awt.Font("SimSun", 1, 14)); // NOI18N
        t61.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        t61.setText("0");
        t61.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        t61.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t61ActionPerformed(evt);
            }
        });
        jPanel6.add(t61);
        t61.setBounds(0, 80, 60, 40);

        t62.setFont(new java.awt.Font("SimSun", 1, 14)); // NOI18N
        t62.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        t62.setText("0");
        t62.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        t62.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t62ActionPerformed(evt);
            }
        });
        jPanel6.add(t62);
        t62.setBounds(0, 120, 60, 40);

        t63.setFont(new java.awt.Font("SimSun", 1, 14)); // NOI18N
        t63.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        t63.setText("0");
        t63.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        t63.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t63ActionPerformed(evt);
            }
        });
        jPanel6.add(t63);
        t63.setBounds(0, 160, 60, 40);

        t64.setFont(new java.awt.Font("SimSun", 1, 14)); // NOI18N
        t64.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        t64.setText("0");
        t64.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        t64.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t64ActionPerformed(evt);
            }
        });
        jPanel6.add(t64);
        t64.setBounds(0, 200, 60, 40);

        t65.setFont(new java.awt.Font("SimSun", 1, 14)); // NOI18N
        t65.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        t65.setText("0");
        t65.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        t65.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t65ActionPerformed(evt);
            }
        });
        jPanel6.add(t65);
        t65.setBounds(0, 240, 60, 40);

        t66.setFont(new java.awt.Font("SimSun", 1, 14)); // NOI18N
        t66.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        t66.setText("0");
        t66.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        t66.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t66ActionPerformed(evt);
            }
        });
        jPanel6.add(t66);
        t66.setBounds(0, 280, 60, 40);

        jPanel13.add(jPanel6);
        jPanel6.setBounds(300, 10, 60, 360);

        jPanel1.add(jPanel13);
        jPanel13.setBounds(10, 110, 390, 340);

        jPanel32.setBackground(new java.awt.Color(204, 204, 255));
        jPanel32.setLayout(null);

        jLabel35.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel35.setText("Extra :");
        jPanel32.add(jLabel35);
        jLabel35.setBounds(500, 20, 110, 37);

        jLabel43.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel43.setText("Quntity");
        jPanel32.add(jLabel43);
        jLabel43.setBounds(620, 20, 110, 37);

        jLabel44.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel44.setText("Rate");
        jPanel32.add(jLabel44);
        jLabel44.setBounds(730, 20, 50, 37);

        jLabel45.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel45.setText("Extra :");
        jPanel32.add(jLabel45);
        jLabel45.setBounds(10, 0, 110, 20);

        jLabel46.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel46.setText("Quntity");
        jPanel32.add(jLabel46);
        jLabel46.setBounds(130, 0, 110, 20);

        jLabel47.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel47.setText("Rate");
        jPanel32.add(jLabel47);
        jLabel47.setBounds(240, 0, 50, 20);

        jLabel48.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel48.setText("RS");
        jPanel32.add(jLabel48);
        jLabel48.setBounds(340, 0, 40, 20);

        jPanel1.add(jPanel32);
        jPanel32.setBounds(20, 0, 390, 30);

        cb3.setBackground(new java.awt.Color(153, 255, 255));
        cb3.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 14)); // NOI18N
        cb3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cb3MouseClicked(evt);
            }
        });
        cb3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb3ActionPerformed(evt);
            }
        });
        cb3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cb3KeyPressed(evt);
            }
        });
        jPanel1.add(cb3);
        cb3.setBounds(10, 50, 130, 30);

        t116.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t116ActionPerformed(evt);
            }
        });
        t116.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                t116KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                t116KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                t116KeyTyped(evt);
            }
        });
        jPanel1.add(t116);
        t116.setBounds(154, 50, 90, 30);

        t117.setBackground(new java.awt.Color(153, 255, 255));
        t117.setFont(new java.awt.Font("Copperplate Gothic Bold", 1, 14)); // NOI18N
        t117.setForeground(new java.awt.Color(153, 0, 153));
        t117.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        t117.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        t117.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t117ActionPerformed(evt);
            }
        });
        jPanel1.add(t117);
        t117.setBounds(250, 50, 60, 32);

        t157.setFont(new java.awt.Font("SimSun", 1, 14)); // NOI18N
        t157.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        t157.setText("0");
        t157.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        t157.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                t157FocusGained(evt);
            }
        });
        t157.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t157ActionPerformed(evt);
            }
        });
        jPanel1.add(t157);
        t157.setBounds(320, 50, 60, 30);

        jTabbedPane1.addTab("Non_Veg", jPanel1);

        jPanel28.setBackground(new java.awt.Color(204, 255, 255));
        jPanel28.setLayout(null);
        jTabbedPane1.addTab("tab3", jPanel28);

        jPanel29.add(jTabbedPane1);
        jTabbedPane1.setBounds(10, 80, 1070, 450);

        b4.setBackground(new java.awt.Color(153, 153, 255));
        b4.setFont(new java.awt.Font("Copperplate Gothic Bold", 1, 14)); // NOI18N
        b4.setText("view bill");
        b4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b4ActionPerformed(evt);
            }
        });
        jPanel29.add(b4);
        b4.setBounds(360, 550, 160, 40);

        l7.setFont(new java.awt.Font("Copperplate Gothic Bold", 1, 24)); // NOI18N
        l7.setText("Total :");
        jPanel29.add(l7);
        l7.setBounds(500, 10, 100, 50);

        cnt1.setEditable(false);
        cnt1.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 20)); // NOI18N
        cnt1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        cnt1.setText("0");
        cnt1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        cnt1.setRequestFocusEnabled(false);
        cnt1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cnt1ActionPerformed(evt);
            }
        });
        jPanel29.add(cnt1);
        cnt1.setBounds(620, 10, 120, 50);

        jButton2.setBackground(new java.awt.Color(153, 153, 255));
        jButton2.setFont(new java.awt.Font("Copperplate Gothic Bold", 1, 14)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/B/print.png"))); // NOI18N
        jButton2.setText("Print");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel29.add(jButton2);
        jButton2.setBounds(540, 550, 160, 40);

        jButton3.setBackground(new java.awt.Color(153, 153, 255));
        jButton3.setFont(new java.awt.Font("Copperplate Gothic Bold", 1, 14)); // NOI18N
        jButton3.setText("clear all");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel29.add(jButton3);
        jButton3.setBounds(720, 550, 160, 40);

        t204.setEditable(false);
        t204.setBackground(new java.awt.Color(204, 255, 255));
        t204.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 20)); // NOI18N
        t204.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        t204.setText("1");
        t204.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        t204.setRequestFocusEnabled(false);
        t204.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t204ActionPerformed(evt);
            }
        });
        jPanel29.add(t204);
        t204.setBounds(200, 20, 60, 40);

        getContentPane().add(jPanel29);
        jPanel29.setBounds(0, 70, 1450, 630);

        jMenuBar1.setAlignmentX(1.0F);
        jMenuBar1.setAutoscrolls(true);
        jMenuBar1.setMinimumSize(new java.awt.Dimension(0, 4));

        jMenu1.setText("File");
        jMenu1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        jMenu3.setText("RateCard");
        jMenu3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu3MouseClicked(evt);
            }
        });
        jMenu3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu3ActionPerformed(evt);
            }
        });

        jMenuItem1.setText("veg");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem1);

        jMenuItem2.setText("Non-Veg");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem2);

        jMenuBar1.add(jMenu3);

        jMenu4.setText("Veg");
        jMenuBar1.add(jMenu4);

        jMenu5.setText("Non-veg");
        jMenuBar1.add(jMenu5);

        jMenu11.setText("Layout");

        jMenuItem5.setText("Background");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu11.add(jMenuItem5);

        jMenuBar1.add(jMenu11);

        jMenu12.setText("Auto Rate");

        jm1.setSelected(true);
        jm1.setText("on / off");
        jMenu12.add(jm1);

        jMenuBar1.add(jMenu12);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rb3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb3ActionPerformed
 if(jm1.isSelected()==false)
     t4.enable(true);
        if(rb3.isSelected())
       {
         t4.enable(true);
         t4.requestFocus();
          try{
                getConn();
             
                String sql="SELECT rate\n" +"FROM public.\"Rate\" where menu='Spl MTNThali                  ' ;";
                pst=conn.prepareStatement(sql);
                rs=pst.executeQuery();
                if(rs.next()){
                t44.setText(rs.getString(1));
                }
             
               
            }catch(Exception e)
            {
                JOptionPane.showMessageDialog(null, e);
            };

         
       } else
           if(rb3.isSelected()==false)
           {
              t4.enable(false); t62.setText("0");t4.setText("");
           }


    }//GEN-LAST:event_rb3ActionPerformed

    private void rb14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb14ActionPerformed
 if(rb14.isSelected())
       {
         t21.enable(true);
         t21.requestFocus();
         try{
                getConn();
             
                String sql="SELECT rate\n" +"FROM public.\"Rate\" where menu='Water Bottel                  ' ;";
                pst=conn.prepareStatement(sql);
                rs=pst.executeQuery();
                if(rs.next()){
                t53.setText(rs.getString(1));
                }
             
               
            }catch(Exception e)
            {
                JOptionPane.showMessageDialog(null, e);
            };
       } else
           if(rb14.isSelected()==false)
           {
              t21.enable(false);  t74.setText("0");t21.setText("");
           }
{
   
}        // TODO add your handling code here:
    }//GEN-LAST:event_rb14ActionPerformed

    private void rb12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb12ActionPerformed
 if(rb12.isSelected())
       {
         t12.enable(true);
         t12.requestFocus();
         try{
                getConn();
             
                String sql="SELECT rate\n" +"FROM public.\"Rate\" where menu='Jira Rise Full ' ;";
                pst=conn.prepareStatement(sql);
                rs=pst.executeQuery();
                if(rs.next()){
                t51.setText(rs.getString(1));
                }
             
               
            }catch(Exception e)
            {
                JOptionPane.showMessageDialog(null, e);
            };
       } else
           if(rb12.isSelected()==false)
           {
              t12.enable(false);  t72.setText("0");t12.setText("");
           }
{
   
}        // TODO add your handling code here:
    }//GEN-LAST:event_rb12ActionPerformed

    private void t8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t8ActionPerformed

    private void t10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t10ActionPerformed

    private void t12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t12ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t12ActionPerformed

    private void t21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t21ActionPerformed
     
    }//GEN-LAST:event_t21ActionPerformed

    private void jMenu3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu3ActionPerformed

    }//GEN-LAST:event_jMenu3ActionPerformed

    private void t1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t1KeyTyped

    }//GEN-LAST:event_t1KeyTyped

    private void t1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t1ActionPerformed
      
        
        
    }//GEN-LAST:event_t1ActionPerformed

    private void t1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t1KeyPressed
if(evt.getKeyCode()==KeyEvent.VK_ENTER)
{
    t41.requestFocus();
    
}      /*int total=0;
       {
           String a=t1.getText();
           String b=t41.getText();
           int a1  =Integer.parseInt(a);
           int b1 =Integer.parseInt(b);
           
           total=a1*b1;
           String str=String.valueOf(total);
        t57.setText(""+str);
        }*/
     
    }//GEN-LAST:event_t1KeyPressed

    private void rb1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb1ActionPerformed

       if(jm1.isSelected())
  {
      if(rb1.isSelected())
       {
           
         t1.enable(true); 
         t57.enable(true);
         t1.requestFocus();
         try{
                getConn();
             
                String sql="SELECT rate\n" +"FROM public.\"Rate\" where menu='Chikan Thali   ' ;";
                pst=conn.prepareStatement(sql);
                rs=pst.executeQuery();
                if(rs.next()){
                t41.setText(rs.getString(1));
                }
             
               
            }catch(Exception e)
            {
                JOptionPane.showMessageDialog(null, e);
            };
             } else
           if(rb1.isSelected()==false)
           {
              t1.setText("");t1.enable(false); t41.setText("");  t57.setText("0");t57.enable(false);
           }
           else{
               t1.enable(true); 
         t57.enable(true);
         t1.requestFocus();
           }
       }
    }//GEN-LAST:event_rb1ActionPerformed

    private void rb2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb2ActionPerformed
 if(rb2.isSelected())
       {
         t3.enable(true);
         t3.requestFocus();
          try{
                getConn();
             
                String sql="SELECT rate\n" +"FROM public.\"Rate\" where menu='Matan Thali    ' ;";
                pst=conn.prepareStatement(sql);
                rs=pst.executeQuery();
                if(rs.next()){
                t43.setText(rs.getString(1));
                }
             
               
            }catch(Exception e)
            {
                JOptionPane.showMessageDialog(null, e);
            };
       } else
           if(rb2.isSelected()==false)
           {
              t3.enable(false);t3.setText("");t61.setText("0"); 
           }
{
   
}      // TODO add your handling code here:
    }//GEN-LAST:event_rb2ActionPerformed

    private void rb41ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb41ActionPerformed
if(jm1.isSelected())
{
    if(rb41.isSelected())
       {
         t2.enable(true);
         t2.requestFocus();
         try{
                getConn();
             
                String sql="SELECT rate\n" +"FROM public.\"Rate\" where menu='Spl CkThali                   ' ;";
                pst=conn.prepareStatement(sql);
                rs=pst.executeQuery();
                if(rs.next()){
                  
                t42.setText(rs.getString(1));
                }
             
               
            }catch(Exception e)
            {
                JOptionPane.showMessageDialog(null, e);
            };

       } else
           if(rb41.isSelected()==false)
           {
              t2.enable(false); t2.setText("");t59.setText("0");
           }
}else{
    t2.enable(true);
         t2.requestFocus();

   
}        // TODO add your handling code here:
    }//GEN-LAST:event_rb41ActionPerformed

    private void rb5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb5ActionPerformed
 if(rb5.isSelected())
       {
         t5.enable(true);
         t5.requestFocus();
          try{
                getConn();
             
                String sql="SELECT rate\n" +"FROM public.\"Rate\" where menu='Chikan Handi H                ' ;";
                pst=conn.prepareStatement(sql);
                rs=pst.executeQuery();
                if(rs.next()){
                  
                t45.setText(rs.getString(1));
                }
             
               
            }catch(Exception e)
            {
                JOptionPane.showMessageDialog(null, e);
            };
       } else
           if(rb5.isSelected()==false)
           {
              t5.enable(false); t5.setText(""); t63.setText("0");
           }
{
   
}      // TODO add your handling code here:
    }//GEN-LAST:event_rb5ActionPerformed

    private void rb6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb6ActionPerformed
 if(rb6.isSelected())
       {
         t9.enable(true);
         t9.requestFocus();
         try{
                getConn();
             
                String sql="SELECT rate\n" +"FROM public.\"Rate\" where menu='MTN Handi F                   ' ;";
                pst=conn.prepareStatement(sql);
                rs=pst.executeQuery();
                if(rs.next()){
                  
                t60.setText(rs.getString(1));
                }
             
               
            }catch(Exception e)
            {
                JOptionPane.showMessageDialog(null, e);
            };
       } else
           if(rb6.isSelected()==false)
           {
              t9.enable(false);  t65.setText("0");    t9.setText("");
           }
{
   
}       // TODO add your handling code here:
    }//GEN-LAST:event_rb6ActionPerformed

    private void rb8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb8ActionPerformed
 if(rb8.isSelected())
       {
         t7.enable(true);
         t7.requestFocus();
          try{
                getConn();
             
                String sql="SELECT rate\n" +"FROM public.\"Rate\" where menu='Roti           ' ;";
                pst=conn.prepareStatement(sql);
                rs=pst.executeQuery();
                if(rs.next()){
                t47.setText(rs.getString(1));
                }
             
               
            }catch(Exception e)
            {
                JOptionPane.showMessageDialog(null, e);
            };
       } else
           if(rb8.isSelected()==false)
           {
              t7.enable(false);  t68.setText("0");t7.setText("");
           }
{
   
}        // TODO add your handling code here:
    }//GEN-LAST:event_rb8ActionPerformed

    private void rb9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb9ActionPerformed
 if(rb9.isSelected())
       {
         t8.enable(true);
         t8.requestFocus();
          try{
                getConn();
             
                String sql="SELECT rate\n" +"FROM public.\"Rate\" where menu='Butter Roti    ' ;";
                pst=conn.prepareStatement(sql);
                rs=pst.executeQuery();
                if(rs.next()){
                t48.setText(rs.getString(1));
                }
             
               
            }catch(Exception e)
            {
                JOptionPane.showMessageDialog(null, e);
            };
       } else
           if(rb9.isSelected()==false)
           {
              t8.enable(false);  t69.setText("0");t8.setText("");
           }
{
   
}        // TODO add your handling code here:
    }//GEN-LAST:event_rb9ActionPerformed

    private void rb10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb10ActionPerformed
 if(rb10.isSelected())
       {
         t10.enable(true);
         t10.requestFocus();
          try{
                getConn();
             
                String sql="SELECT rate\n" +"FROM public.\"Rate\" where menu='Rise Full      ' ;";
                pst=conn.prepareStatement(sql);
                rs=pst.executeQuery();
                if(rs.next()){
                t49.setText(rs.getString(1));
                }
             
               
            }catch(Exception e)
            {
                JOptionPane.showMessageDialog(null, e);
            };
       } else
           if(rb10.isSelected()==false)
           {
              t10.enable(false);  t70.setText("0");t10.setText("");
           }
{
   
}        // TODO add your handling code here:
    }//GEN-LAST:event_rb10ActionPerformed

    private void rb11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb11ActionPerformed
 if(rb11.isSelected())
       {
         t20.enable(true);
         t20.requestFocus();
         try{
                getConn();
             
                String sql="SELECT rate\n" +"FROM public.\"Rate\" where menu='Rise Half      ' ;";
                pst=conn.prepareStatement(sql);
                rs=pst.executeQuery();
                if(rs.next()){
                t50.setText(rs.getString(1));
                }
             
               
            }catch(Exception e)
            {
                JOptionPane.showMessageDialog(null, e);
            };
       } else
           if(rb11.isSelected()==false)
           {
              t20.enable(false);  t71.setText("0");t20.setText("");
           }
{
   
}        // TODO add your handling code here:
    }//GEN-LAST:event_rb11ActionPerformed

    private void rb13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb13ActionPerformed
 if(rb13.isSelected())
       {
         t11.enable(true);
         t11.requestFocus();
         try{
                getConn();
             
                String sql="SELECT rate\n" +"FROM public.\"Rate\" where menu='Jira Rise Half ' ;";
                pst=conn.prepareStatement(sql);
                rs=pst.executeQuery();
                if(rs.next()){
                t52.setText(rs.getString(1));
                }
             
               
            }catch(Exception e)
            {
                JOptionPane.showMessageDialog(null, e);
            };
       } else
           if(rb13.isSelected()==false)
           {
              t11.enable(false);  t73.setText("0");t11.setText("");
           }
{
   
}        // TODO add your handling code here:
    }//GEN-LAST:event_rb13ActionPerformed

    private void rb15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb15ActionPerformed
  if(rb15.isSelected())
       {
         t22.enable(true);
         t22.requestFocus();
         try{
                getConn();
             
                String sql="SELECT rate\n" +"FROM public.\"Rate\" where menu='Coldrinks      ' ;";
                pst=conn.prepareStatement(sql);
                rs=pst.executeQuery();
                if(rs.next()){
                t54.setText(rs.getString(1));
                }
             
               
            }catch(Exception e)
            {
                JOptionPane.showMessageDialog(null, e);
            };
       } else
           if(rb13.isSelected()==false)
           {
              t22.enable(false);  t75.setText("0");t22.setText("");
           }      // TODO add your handling code here:
    }//GEN-LAST:event_rb15ActionPerformed

    private void t7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t7ActionPerformed

    private void t2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t2ActionPerformed
        /*   int total=0;
           String a=t1.getText();
           String b=t41.getText();
           int a1  =Integer.parseInt(a);
           int b1 =Integer.parseInt(b);
           
           total=a1*b1;
           String str=String.valueOf(total);
        t57.setText(""+str);*/
                // TODO add your handling code here:
    }//GEN-LAST:event_t2ActionPerformed

    private void t5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t5ActionPerformed

    private void t6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t6ActionPerformed

    private void t22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t22ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t22ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed

    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
 new RateNV().setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void t42ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t42ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t42ActionPerformed

    private void t45ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t45ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t45ActionPerformed

    private void t46ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t46ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t46ActionPerformed

    private void t48ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t48ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t48ActionPerformed

    private void t54ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t54ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t54ActionPerformed

    private void t41ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t41ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t41ActionPerformed

    private void rb7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb7ActionPerformed
if(rb7.isSelected())
       {
         t6.enable(true);
         t6.requestFocus();
         try{
                getConn();
             
                String sql="SELECT rate\n" +"FROM public.\"Rate\" where menu='Chikan Handi F                ' ;";
                pst=conn.prepareStatement(sql);
                rs=pst.executeQuery();
                if(rs.next()){
                  
                t46.setText(rs.getString(1));
                }
             
               
            }catch(Exception e)
            {
                JOptionPane.showMessageDialog(null, e);
            };
       } else
           if(rb7.isSelected()==false)
           {
              t6.enable(false); t64.setText("0");t6.setText("");
           }        // TODO add your handling code here:
    }//GEN-LAST:event_rb7ActionPerformed

    private void rb16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb16ActionPerformed
if(rb16.isSelected())
       {
         t13.enable(true);
         t13.requestFocus();
          try{
                getConn();
             
                String sql="SELECT rate\n" +"FROM public.\"Rate\" where menu='MTN Handi H                   ' ;";
                pst=conn.prepareStatement(sql);
                rs=pst.executeQuery();
                if(rs.next()){
                  
                t58.setText(rs.getString(1));
                }
             
               
            }catch(Exception e)
            {
                JOptionPane.showMessageDialog(null, e);
            };
       } else
           if(rb16.isSelected()==false)
           {
              t13.enable(false);  t66.setText("0");t13.setText("");
           }        // TODO add your handling code here:
    }//GEN-LAST:event_rb16ActionPerformed

    private void t9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t9ActionPerformed

    private void t13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t13ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t13ActionPerformed

    private void t60ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t60ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t60ActionPerformed

    private void t58ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t58ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t58ActionPerformed

    private void t4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t4ActionPerformed

    private void b4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b4ActionPerformed

       /* if(!rb31.isSelected()){
           tt1.append(l1.getText()+"\t"+t56.getText()+"\n"+"********************************\n");
     }*/
      
        
        if(rb1.isSelected())
      {
          t111();
      }
      if(rb41.isSelected())
      {
          t112();
      }
      if(rb2.isSelected())
      {
         t113(); 
      }
      if(rb3.isSelected())
      {
         t114(); 
      }
      if(rb5.isSelected())
      {
         t115(); 
      }
      if(rb7.isSelected())
      {
         t116(); 
      }
      if(rb6.isSelected())
      {
         t117(); 
      }
      if(rb16.isSelected())
      {
         t118(); 
      }
      if(rb8.isSelected())
      {
         t119(); 
      }
      if(rb9.isSelected())
      {
         t120(); 
      }
      if(rb10.isSelected())
      {
         t121(); 
      }
      if(rb11.isSelected())
      {
         t122(); 
      }
      if(rb12.isSelected())
      {
         t123(); 
      }
      if(rb13.isSelected())
      {
         t124(); 
      }
      if(rb14.isSelected())
      {
         t125(); 
      }
      if(rb15.isSelected())
      {
         t126(); 
      }
      /*if(rb31.isSelected())
      {
         t127(); 
      } */
        if(rb32.isSelected())
      {
          t128();
      } 
        if(rb43.isSelected())
      {
          t129();
      }
        if(rb33.isSelected())
      {
          t130();
      }
        if(rb34.isSelected())
      {
          t131();
      }
      if(rb35.isSelected())
      {
          t132();
      }
      if(rb36.isSelected())
      {
          t133();
      }
      if(rb37.isSelected())
      {
          t134();
      }
      if(rb38.isSelected())
      {
          t135();
      }
      
       if(rb39.isSelected())
      {
         t136();
      }
       if(rb40.isSelected())
      {
           t137();
      }
        if(rb44.isSelected())
      {
          t138();
      }
         if(rb45.isSelected())
      {
           t139();
      }
          if(rb46.isSelected())
      {
           t140();
      }
           if(rb47.isSelected())
      {
          t141();
      }
            if(rb48.isSelected())
      {
          t142();
      }
             if(rb49.isSelected())
      {
          t143();
      }
       
       
       
       
       
       
       
      {
            int a=Integer.parseInt(t57.getText());
            int b=Integer.parseInt(t59.getText());
            int c=Integer.parseInt(t61.getText());
            int d=Integer.parseInt(t62.getText());
            int e=Integer.parseInt(t63.getText());
            int f=Integer.parseInt(t64.getText());
            int g=Integer.parseInt(t65.getText());
            int h=Integer.parseInt(t66.getText());
            
            int i=Integer.parseInt(t68.getText());
            int j=Integer.parseInt(t69.getText());
            int k=Integer.parseInt(t70.getText());
            int l=Integer.parseInt(t71.getText());
            int m=Integer.parseInt(t72.getText());
            int n=Integer.parseInt(t73.getText());
            int o=Integer.parseInt(t74.getText());
            int p=Integer.parseInt(t75.getText());
            int q=Integer.parseInt(t117.getText());
             int r=Integer.parseInt(t124.getText());
            int s=Integer.parseInt(t125.getText());
           int t=Integer.parseInt(t126.getText());
            int u=Integer.parseInt(t127.getText());
            int v=Integer.parseInt(t128.getText());
            int w=Integer.parseInt(t129.getText());
            int x=Integer.parseInt(t130.getText());
            int y=Integer.parseInt(t131.getText());
             int z=Integer.parseInt(t148.getText());
             int a1=Integer.parseInt(t149.getText());
             int a2=Integer.parseInt(t150.getText());
             int a3=Integer.parseInt(t151.getText());
             int a4=Integer.parseInt(t152.getText());
             int a5=Integer.parseInt(t153.getText());
              int a6=Integer.parseInt(t154.getText());
              int a7=Integer.parseInt(t155.getText());
             
             
             
             
             
          tot=a+b+c+d+e+f+g+h+i+j+k+l+m+n+o+p+q+r+s+t+u+v+w+x+y+z+a1+a2+a3+a4+a5+a6+a7;
           String tot1=String.valueOf(tot);
      cnt1.setText(tot1);
          
      }
      
      tt1.append("\n"+"Total"+"\t"+cnt1.getText()+"\n");
      
    }//GEN-LAST:event_b4ActionPerformed

    private void rb1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rb1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_rb1MouseClicked

    private void t57ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t57ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t57ActionPerformed

    private void t59ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t59ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t59ActionPerformed

    private void t61ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t61ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t61ActionPerformed

    private void t62ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t62ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t62ActionPerformed

    private void t63ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t63ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t63ActionPerformed

    private void t64ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t64ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t64ActionPerformed

    private void t65ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t65ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t65ActionPerformed

    private void t66ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t66ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t66ActionPerformed

    private void cnt1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cnt1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cnt1ActionPerformed

    private void t1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t1KeyReleased

       
            int total,x1=0;
        
           String a=t1.getText();
           String b=t41.getText();
           int a1  =Integer.parseInt(a);
           int b1 =Integer.parseInt(b);
           
           total=a1*b1;
          
           String str=String.valueOf(total);
           
           
        t57.setText(""+str);
         //x1=total+tot;
        // tot=x1;
        
       
               

    }//GEN-LAST:event_t1KeyReleased

    private void t2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t2KeyReleased
int total,x1=0;
           String a=t2.getText();
           String b=t42.getText();
           int a1  =Integer.parseInt(a);
           int b1 =Integer.parseInt(b);
           
           total=a1*b1;
           String str=String.valueOf(total);
        t59.setText(""+str);
        
        
        // x1=total+tot;
         //tot=x1;
       
    }//GEN-LAST:event_t2KeyReleased

    private void t3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t3KeyReleased
int total,x1=0;
           String a=t3.getText();
           String b=t43.getText();
           int a1  =Integer.parseInt(a);
           int b1 =Integer.parseInt(b);
           
           total=a1*b1;
           String str=String.valueOf(total);
        t61.setText(""+str);
         x1=total+tot;
         tot=x1;
         
        
        
        
        
        
                // TODO add your handling code here:
    }//GEN-LAST:event_t3KeyReleased

    private void t4KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t4KeyReleased
     
        int total,x1=0;
           String a=t4.getText();
           String b=t44.getText();
           int a1  =Integer.parseInt(a);
           int b1 =Integer.parseInt(b);
           
           total=a1*b1;
           String str=String.valueOf(total);
        t62.setText(""+str);
         x1=total+tot;
         tot=x1;
         
         
        
          // TODO add your handling code here:
    }//GEN-LAST:event_t4KeyReleased

    private void t5KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t5KeyReleased
int total,x1=0;
           String a=t5.getText();
           String b=t45.getText();
           int a1  =Integer.parseInt(a);
           int b1 =Integer.parseInt(b);
           
           total=a1*b1;
           String str=String.valueOf(total);
        t63.setText(""+str);
         x1=total+tot;
         tot=x1;
         
        
                // TODO add your handling code here:
    }//GEN-LAST:event_t5KeyReleased

    private void t6KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t6KeyReleased
int total,x1=0;
           String a=t6.getText();
           String b=t46.getText();
           int a1  =Integer.parseInt(a);
           int b1 =Integer.parseInt(b);
           
           total=a1*b1;
           String str=String.valueOf(total);
        t64.setText(""+str);
         x1=total+tot;
         tot=x1;
         
         
                // TODO add your handling code here:
    }//GEN-LAST:event_t6KeyReleased

    private void t9KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t9KeyReleased
int total,x1=0;
           String a=t9.getText();
           String b=t60.getText();
           int a1  =Integer.parseInt(a);
           int b1 =Integer.parseInt(b);
           
           total=a1*b1;
           String str=String.valueOf(total);
        t65.setText(""+str);
         x1=total+tot;
         tot=x1;
         
        
                // TODO add your handling code here:
    }//GEN-LAST:event_t9KeyReleased

    private void t13KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t13KeyReleased
int total,x1=0;
           String a=t13.getText();
           String b=t58.getText();
           int a1  =Integer.parseInt(a);
           int b1 =Integer.parseInt(b);
           
           total=a1*b1;
           String str=String.valueOf(total);
        t66.setText(""+str);
         x1=total+tot;
         tot=x1;
         
         
                // TODO add your handling code here:
    }//GEN-LAST:event_t13KeyReleased

    private void t68ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t68ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t68ActionPerformed

    private void t69ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t69ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t69ActionPerformed

    private void t70ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t70ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t70ActionPerformed

    private void t71ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t71ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t71ActionPerformed

    private void t72ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t72ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t72ActionPerformed

    private void t73ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t73ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t73ActionPerformed

    private void t74ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t74ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t74ActionPerformed

    private void t75ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t75ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t75ActionPerformed

    private void t7KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t7KeyReleased
       int total,x1=0;
           String a=t7.getText();
           String b=t47.getText();
           int a1  =Integer.parseInt(a);
           int b1 =Integer.parseInt(b);
           
           total=a1*b1;
           String str=String.valueOf(total);
        t68.setText(""+str);
         x1=total+tot;
         tot=x1;
         
         /*String str1=String.valueOf(x1);
         t67.setText(str1);*/
    }//GEN-LAST:event_t7KeyReleased

    private void t8KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t8KeyReleased
int total,x1=0;
           String a=t8.getText();
           String b=t48.getText();
           int a1  =Integer.parseInt(a);
           int b1 =Integer.parseInt(b);
           
           total=a1*b1;
           String str=String.valueOf(total);
        t69.setText(""+str);    
         x1=total+tot;
         tot=x1;
         
         /*String str1=String.valueOf(x1);
         t67.setText(str1);*/ 
    }//GEN-LAST:event_t8KeyReleased

    private void t10KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t10KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_t10KeyTyped

    private void t10KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t10KeyReleased
int total,x1=0;
           String a=t10.getText();
           String b=t49.getText();
           int a1  =Integer.parseInt(a);
           int b1 =Integer.parseInt(b);
           
           total=a1*b1;
           String str=String.valueOf(total);
        t70.setText(""+str); 
         x1=total+tot;
         tot=x1;
         
        /*String str1=String.valueOf(x1);
         t67.setText(str1);*/// TODO add your handling code here:
    }//GEN-LAST:event_t10KeyReleased

    private void t20KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t20KeyReleased
int total,x1=0;
           String a=t20.getText();
           String b=t50.getText();
           int a1  =Integer.parseInt(a);
           int b1 =Integer.parseInt(b);
           
           total=a1*b1;
           String str=String.valueOf(total);
        t71.setText(""+str); 
         x1=total+tot;
         tot=x1;
         
         /*String str1=String.valueOf(x1);
         t67.setText(str1);*/// TODO add your handling code here:
    }//GEN-LAST:event_t20KeyReleased

    private void t12KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t12KeyReleased
int total,x1=0;
           String a=t12.getText();
           String b=t51.getText();
           int a1  =Integer.parseInt(a);
           int b1 =Integer.parseInt(b);
           
           total=a1*b1;
           String str=String.valueOf(total);
        t72.setText(""+str);  
         x1=total+tot;
         tot=x1;
         
         /*String str1=String.valueOf(x1);
         t67.setText(str1);*/// TODO add your handling code here:
    }//GEN-LAST:event_t12KeyReleased

    private void t11KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t11KeyReleased
int total,x1=0;
           String a=t11.getText();
           String b=t52.getText();
           int a1  =Integer.parseInt(a);
           int b1 =Integer.parseInt(b);
           
           total=a1*b1;
           String str=String.valueOf(total);
        t73.setText(""+str);  
         x1=total+tot;
         tot=x1;
         
         /*String str1=String.valueOf(x1);
         t67.setText(str1);*/// TODO add your handling code here:
    }//GEN-LAST:event_t11KeyReleased

    private void t21KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t21KeyReleased
int total,x1=0;
           String a=t21.getText();
           String b=t53.getText();
           int a1  =Integer.parseInt(a);
           int b1 =Integer.parseInt(b);
           
           total=a1*b1;
           String str=String.valueOf(total);
        t74.setText(""+str);  
         x1=total+tot;
         tot=x1;
         /*String str1=String.valueOf(x1);
         t67.setText(str1);*/// TODO add your handling code here:
    }//GEN-LAST:event_t21KeyReleased

    private void t22KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t22KeyReleased
int total,x1=0;
           String a=t22.getText();
           String b=t54.getText();
           int a1  =Integer.parseInt(a);
           int b1 =Integer.parseInt(b);
           
           total=a1*b1;
           String str=String.valueOf(total);
        t75.setText(""+str);      
         x1=total+tot;
         tot=x1;
         
        /*String str1=String.valueOf(x1);
         t67.setText(str1);*/// TODO add your handling code here:
    }//GEN-LAST:event_t22KeyReleased

    private void t57FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_t57FocusGained
      
        

// TODO add your handling code here:
    }//GEN-LAST:event_t57FocusGained

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
 tt1.setText("********************************\n"+
                   "*       Hotel Shubham       *\n"+
                   "********************************\n"+
                   "\n"
                 );       // TODO add your handling code here:
    }//GEN-LAST:event_jButton6ActionPerformed

    private void t76ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t76ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t76ActionPerformed

    private void rb4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rb4MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_rb4MouseClicked

    private void rb4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rb4ActionPerformed

    private void t14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t14ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t14ActionPerformed

    private void t14KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t14KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_t14KeyPressed

    private void t14KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t14KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t14KeyReleased

    private void t14KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t14KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_t14KeyTyped

    private void rb42rb1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rb42rb1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_rb42rb1MouseClicked

    private void rb42ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb42ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rb42ActionPerformed

    private void t15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t15ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t15ActionPerformed

    private void t15KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t15KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t15KeyReleased

    private void rb17rb1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rb17rb1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_rb17rb1MouseClicked

    private void rb17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb17ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rb17ActionPerformed

    private void t16KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t16KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t16KeyReleased

    private void rb18rb1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rb18rb1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_rb18rb1MouseClicked

    private void rb18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb18ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rb18ActionPerformed

    private void t17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t17ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t17ActionPerformed

    private void t17KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t17KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t17KeyReleased

    private void rb19rb1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rb19rb1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_rb19rb1MouseClicked

    private void rb19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb19ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rb19ActionPerformed

    private void t18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t18ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t18ActionPerformed

    private void t18KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t18KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t18KeyReleased

    private void rb20rb1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rb20rb1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_rb20rb1MouseClicked

    private void rb20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb20ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rb20ActionPerformed

    private void t19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t19ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t19ActionPerformed

    private void t19KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t19KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t19KeyReleased

    private void rb21rb1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rb21rb1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_rb21rb1MouseClicked

    private void rb21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb21ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rb21ActionPerformed

    private void t23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t23ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t23ActionPerformed

    private void t23KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t23KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t23KeyReleased

    private void rb22rb1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rb22rb1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_rb22rb1MouseClicked

    private void rb22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb22ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rb22ActionPerformed

    private void t24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t24ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t24ActionPerformed

    private void t24KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t24KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t24KeyReleased

    private void rb23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb23ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rb23ActionPerformed

    private void t25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t25ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t25ActionPerformed

    private void t25KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t25KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t25KeyReleased

    private void rb24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb24ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rb24ActionPerformed

    private void t26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t26ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t26ActionPerformed

    private void t26KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t26KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t26KeyReleased

    private void rb25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb25ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rb25ActionPerformed

    private void t27ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t27ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t27ActionPerformed

    private void t27KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t27KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t27KeyReleased

    private void t27KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t27KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_t27KeyTyped

    private void rb26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb26ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rb26ActionPerformed

    private void t28KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t28KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t28KeyReleased

    private void rb27ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb27ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rb27ActionPerformed

    private void t29ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t29ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t29ActionPerformed

    private void t29KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t29KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t29KeyReleased

    private void rb28ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb28ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rb28ActionPerformed

    private void t30KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t30KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t30KeyReleased

    private void rb29ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb29ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rb29ActionPerformed

    private void t31ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t31ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t31ActionPerformed

    private void t31KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t31KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t31KeyReleased

    private void rb30ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb30ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rb30ActionPerformed

    private void t32ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t32ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t32ActionPerformed

    private void t32KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t32KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t32KeyReleased

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton9ActionPerformed

    private void t78ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t78ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t78ActionPerformed

    private void t79ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t79ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t79ActionPerformed

    private void t82ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t82ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t82ActionPerformed

    private void t83ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t83ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t83ActionPerformed

    private void t84ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t84ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t84ActionPerformed

    private void t85ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t85ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t85ActionPerformed

    private void t87ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t87ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t87ActionPerformed

    private void t93ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t93ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t93ActionPerformed

    private void t94FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_t94FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_t94FocusGained

    private void t94ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t94ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t94ActionPerformed

    private void t95ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t95ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t95ActionPerformed

    private void t96ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t96ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t96ActionPerformed

    private void t97ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t97ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t97ActionPerformed

    private void t98ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t98ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t98ActionPerformed

    private void t99ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t99ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t99ActionPerformed

    private void t100ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t100ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t100ActionPerformed

    private void t101ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t101ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t101ActionPerformed

    private void t102ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t102ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t102ActionPerformed

    private void t103ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t103ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t103ActionPerformed

    private void t104ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t104ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t104ActionPerformed

    private void t105ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t105ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t105ActionPerformed

    private void t106ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t106ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t106ActionPerformed

    private void t107ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t107ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t107ActionPerformed

    private void t108ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t108ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t108ActionPerformed

    private void t109ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t109ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t109ActionPerformed

    private void t110ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t110ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t110ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenu8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenu8ActionPerformed

    private void t43ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t43ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t43ActionPerformed

    private void t44ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t44ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t44ActionPerformed

    private void t4KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t4KeyPressed
// TODO add your handling code here:
    }//GEN-LAST:event_t4KeyPressed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        //admin database
        try{
        String n31=String.valueOf(cnt1.getText());
        String n2=t56.getText();
        String n11=t111.getText();
        int n1=Integer.valueOf(n11);
        int n3=Integer.valueOf(n31);
        
          String query="INSERT INTO public.\"ToalAdmin\"(\n" +
"	cno, date, total)\n" +
"	VALUES (?, ?, ?);";
        PreparedStatement pst;
            pst = conn.prepareStatement(query);
             pst.setInt(1,n1);
             pst.setString(2,n2);
             
             pst.setInt(3,n3);
             
        pst.executeUpdate();
        JOptionPane.showMessageDialog(null,"Manager add");
       
     }catch(Exception e){
         JOptionPane.showMessageDialog(null,e);
     }
        
        
        
        
        
        //manager database
        try{
        
        String n1=String.valueOf(t111.getText());
        String n2=String.valueOf(t56.getText());
        
          String query="INSERT INTO public.\"Date_co\"(\n" +
"	date, cno)\n" +
"	VALUES (?, ?);";
        PreparedStatement pst;
            pst = conn.prepareStatement(query);
             pst.setString(1,n1);
            
             pst.setString(2,n2);
             
        pst.executeUpdate();
        JOptionPane.showMessageDialog(null,"date wise");
       
     }catch(Exception e){
         JOptionPane.showMessageDialog(null,e);
     } 
        
        
        try{
        String n31=String.valueOf(cnt1.getText());
        String n2=t56.getText();
        String n11=t111.getText();
        int n1=Integer.valueOf(n11);
        int n3=Integer.valueOf(n31);
        
          String query="INSERT INTO public.\"Total\"(\n" +
"	cno, date, total)\n" +
"	VALUES (?, ?, ?);";
        PreparedStatement pst;
            pst = conn.prepareStatement(query);
             pst.setInt(1,n1);
             pst.setString(2,n2);
             
             pst.setInt(3,n3);
             
        pst.executeUpdate();
        JOptionPane.showMessageDialog(null,"Manager add");
       
     }catch(Exception e){
         JOptionPane.showMessageDialog(null,e);
     }
        
          String a=t111.getText();
          int aa=Integer.parseInt(a);
          int aaa=aa+1;
          String aaaa=String.valueOf(aaa);
          t111.setText(aaaa);
          
        
          try{ 

          String id=t111.getText();
          String total=cnt1.getText();
          String date=t56.getText();
          
          FileWriter wt=new FileWriter("DailyEarningReport.txt",true);
          wt.write("\n");
             wt.write(date);
          wt.write("\t");
          wt.write(id);
           wt.write("\t");
          wt.write(total);
          
        /*  File f=new File("D:\\DailyReport.xlsx");
          WritableWorkbook myexcel =Workbook.createWorkbook(f);
          WritableSheet mysheet = myexcel.createSheet("ms", 0);
          
          Label l=new Label("data1");
          
          Label l2=new Label("data2");
          mysheet.addCell( l);
          mysheet.addCell( l2);
          myexcel.write();
          myexcel.close();
          System.out.println("ok");
          */
          
         
          wt.close();
          JOptionPane.showMessageDialog(rootPane,"ok");
          
        }catch(Exception e){
            JOptionPane.showMessageDialog(rootPane,e);
          
       }
       
      tfclose();  
       clear(); 
       onload();
      
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
clear();      

// TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void t111ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t111ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t111ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void popupMenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_popupMenu1ActionPerformed
      
JOptionPane.showMessageDialog(null,"hii");
// TODO add your handling code here:
    }//GEN-LAST:event_popupMenu1ActionPerformed

    private void rb32MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rb32MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_rb32MouseClicked

    private void rb32ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb32ActionPerformed
 if(rb32.isSelected())
       { t33.enable(true); 
         t67.enable(true);
        t124.enable(true);
         t33.requestFocus();
        
       } else
           if(rb32.isSelected()==false)
           {
              t33.setText("");
              t33.enable(false);
              t67.setText(""); 
              t124.setText("0");
               t124.enable(false);
              t67.enable(false);
           }


// TODO add your handling code here:
    }//GEN-LAST:event_rb32ActionPerformed

    private void t33ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t33ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t33ActionPerformed

    private void t33KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t33KeyPressed
if(evt.getKeyCode()==KeyEvent.VK_ENTER)
{
    t67.requestFocus();
    
}         // TODO add your handling code here:
    }//GEN-LAST:event_t33KeyPressed

    private void t33KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t33KeyReleased



//int a=Integer.parseInt(t33.getText()) * Integer.parseInt(t67.getText());
//t124.setText(String.valueOf(a));
        // TODO add your handling code here:
    }//GEN-LAST:event_t33KeyReleased

    private void t33KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t33KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_t33KeyTyped

    private void rb43rb1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rb43rb1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_rb43rb1MouseClicked

    private void rb43ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb43ActionPerformed

        if(rb43.isSelected())
       {  t34.enable(true); 
         t112.enable(true);
          t125.enable(true);
         t34.requestFocus();
        
       } else
           if(rb43.isSelected()==false)
           {
              t34.setText("");    t112.setText("");        t125.setText("0");
              t34.enable(false);  t112.enable(false);      t125.enable(false);
           }        // TODO add your handling code here:
    }//GEN-LAST:event_rb43ActionPerformed

    private void t34ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t34ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t34ActionPerformed

    private void t34KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t34KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t34KeyReleased

    private void rb33rb1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rb33rb1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_rb33rb1MouseClicked

    private void rb33ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb33ActionPerformed
if(rb33.isSelected())
       { t35.enable(true); 
         t118.enable(true);
          t126.enable(true);
         t35.requestFocus();
        
       } else
           if(rb33.isSelected()==false)
           {
              t35.setText("");    t118.setText("");        t126.setText("0");
              t35.enable(false);  t118.enable(false);      t126.enable(false);
           }            // TODO add your handling code here:
    }//GEN-LAST:event_rb33ActionPerformed

    private void t35KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t35KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t35KeyReleased

    private void rb34rb1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rb34rb1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_rb34rb1MouseClicked

    private void rb34ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb34ActionPerformed
if(rb34.isSelected())
       {  t36.enable(true); 
         t119.enable(true);
          t127.enable(true);
         t36.requestFocus();
        
       } else
           if(rb43.isSelected()==false)
           {
              t36.setText("");    t119.setText("");        t127.setText("0");
              t36.enable(false);  t119.enable(false);      t127.enable(false);
           }            // TODO add your handling code here:
    }//GEN-LAST:event_rb34ActionPerformed

    private void t36ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t36ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t36ActionPerformed

    private void t36KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t36KeyPressed
if(evt.getKeyCode()==KeyEvent.VK_ENTER)
{
    t119.requestFocus();
    
}         // TODO add your handling code here:
    }//GEN-LAST:event_t36KeyPressed

    private void t36KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t36KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t36KeyReleased

    private void rb35rb1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rb35rb1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_rb35rb1MouseClicked

    private void rb35ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb35ActionPerformed
if(rb35.isSelected())
       {  t37.enable(true); 
         t120.enable(true);
          t128.enable(true);
         t37.requestFocus();
        
       } else
           if(rb35.isSelected()==false)
           {
              t37.setText("");    t120.setText("");        t128.setText("0");
              t37.enable(false);  t120.enable(false);      t128.enable(false);
           }               // TODO add your handling code here:
    }//GEN-LAST:event_rb35ActionPerformed

    private void t37ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t37ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t37ActionPerformed

    private void t37KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t37KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t37KeyReleased

    private void rb36rb1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rb36rb1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_rb36rb1MouseClicked

    private void rb36ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb36ActionPerformed
if(rb36.isSelected())
       { t38.enable(true); 
         t121.enable(true);
          t129.enable(true);
         t38.requestFocus();
        
       } else
           if(rb36.isSelected()==false)
           {
              t38.setText("");    t121.setText("");        t129.setText("0");
              t38.enable(false);  t121.enable(false);      t129.enable(false);
           }               // TODO add your handling code here:
    }//GEN-LAST:event_rb36ActionPerformed

    private void t38ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t38ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t38ActionPerformed

    private void t38KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t38KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t38KeyReleased

    private void rb37rb1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rb37rb1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_rb37rb1MouseClicked

    private void rb37ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb37ActionPerformed
if(rb37.isSelected())
       {  t39.enable(true); 
         t122.enable(true);
          t130.enable(true);
         t38.requestFocus();
        
       } else
           if(rb37.isSelected()==false)
           {
              t39.setText("");    t122.setText("");        t130.setText("0");
              t39.enable(false);  t122.enable(false);      t130.enable(false);
           }              // TODO add your handling code here:
    }//GEN-LAST:event_rb37ActionPerformed

    private void t39ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t39ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t39ActionPerformed

    private void t39KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t39KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t39KeyReleased

    private void rb38rb1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rb38rb1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_rb38rb1MouseClicked

    private void rb38ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb38ActionPerformed
if(rb38.isSelected())
       {  t40.enable(true); 
         t123.enable(true);
          t131.enable(true);
         t40.requestFocus();
        
       } else
           if(rb38.isSelected()==false)
           {
              t40.setText("");    t123.setText("");        t131.setText("0");
              t40.enable(false);  t123.enable(false);      t131.enable(false);
           }              // TODO add your handling code here:
    }//GEN-LAST:event_rb38ActionPerformed

    private void t40ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t40ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t40ActionPerformed

    private void t40KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t40KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t40KeyReleased

    private void t67ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t67ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t67ActionPerformed

    private void t112ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t112ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t112ActionPerformed

    private void t118ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t118ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t118ActionPerformed

    private void t119ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t119ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t119ActionPerformed

    private void t120ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t120ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t120ActionPerformed

    private void t121ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t121ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t121ActionPerformed

    private void t122ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t122ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t122ActionPerformed

    private void t123ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t123ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t123ActionPerformed

    private void t124FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_t124FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_t124FocusGained

    private void t124ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t124ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t124ActionPerformed

    private void t125ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t125ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t125ActionPerformed

    private void t126ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t126ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t126ActionPerformed

    private void t127ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t127ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t127ActionPerformed

    private void t128ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t128ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t128ActionPerformed

    private void t129ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t129ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t129ActionPerformed

    private void t130ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t130ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t130ActionPerformed

    private void t131ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t131ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t131ActionPerformed

    private void rb39ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb39ActionPerformed
if(rb39.isSelected())
       {  t132.enable(true); 
         t140.enable(true);
          t148.enable(true);
         t132.requestFocus();
        
       } else
           if(rb39.isSelected()==false)
           {
              t132.setText("");    t140.setText("");        t148.setText("0");
              t132.enable(false);  t140.enable(false);      t148.enable(false);
           }              // TODO add your handling code here:
    }//GEN-LAST:event_rb39ActionPerformed

    private void t132ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t132ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t132ActionPerformed

    private void t132KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t132KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t132KeyReleased

    private void rb40ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb40ActionPerformed
if(rb40.isSelected())
       { t133.enable(true); 
         t141.enable(true);
          t149.enable(true);
         t133.requestFocus();
        
       } else
           if(rb40.isSelected()==false)
           {
              t133.setText("");    t141.setText("");        t149.setText("0");
              t133.enable(false);  t141.enable(false);      t149.enable(false);
           }                      // TODO add your handling code here:
    }//GEN-LAST:event_rb40ActionPerformed

    private void t133ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t133ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t133ActionPerformed

    private void t133KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t133KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t133KeyReleased

    private void rb44ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb44ActionPerformed
if(rb44.isSelected())
       { t134.enable(true); 
         t142.enable(true);
          t150.enable(true);
         t134.requestFocus();
        
       } else
           if(rb44.isSelected()==false)
           {
              t134.setText("");    t142.setText("");        t150.setText("0");
              t134.enable(false);  t142.enable(false);      t150.enable(false);
           }                      // TODO add your handling code here:
    }//GEN-LAST:event_rb44ActionPerformed

    private void t134ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t134ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t134ActionPerformed

    private void t134KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t134KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t134KeyReleased

    private void t134KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t134KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_t134KeyTyped

    private void rb45ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb45ActionPerformed
if(rb45.isSelected())
       {  t135.enable(true); 
         t143.enable(true);
          t151.enable(true);
         t135.requestFocus();
        
       } else
           if(rb45.isSelected()==false)
           {
              t135.setText("");    t143.setText("");        t151.setText("0");
              t135.enable(false);  t143.enable(false);      t151.enable(false);
           }               // TODO add your handling code here:
    }//GEN-LAST:event_rb45ActionPerformed

    private void t135KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t135KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t135KeyReleased

    private void rb46ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb46ActionPerformed
if(rb46.isSelected())
       {  t136.enable(true); 
         t144.enable(true);
          t148.enable(true);
         t152.requestFocus();
        
       } else
           if(rb46.isSelected()==false)
           {
              t136.setText("");    t144.setText("");        t152.setText("0");
              t136.enable(false);  t144.enable(false);      t152.enable(false);
           }               // TODO add your handling code here:
    }//GEN-LAST:event_rb46ActionPerformed

    private void t136ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t136ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t136ActionPerformed

    private void t136KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t136KeyReleased
if(evt.getKeyCode()==KeyEvent.VK_ENTER)
{
    t144.requestFocus();
    
}         // TODO add your handling code here:
    }//GEN-LAST:event_t136KeyReleased

    private void rb47ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb47ActionPerformed
if(rb47.isSelected())
       {  t137.enable(true); 
         t145.enable(true);
          t148.enable(true);
         t153.requestFocus();
        
       } else
           if(rb47.isSelected()==false)
           {
              t137.setText("");    t145.setText("");        t153.setText("0");
              t137.enable(false);  t145.enable(false);      t153.enable(false);
           }        // TODO add your handling code here:
    }//GEN-LAST:event_rb47ActionPerformed

    private void t137KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t137KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t137KeyReleased

    private void rb48ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb48ActionPerformed
if(rb48.isSelected())
       {  t138.enable(true); 
         t146.enable(true);
          t154.enable(true);
         t138.requestFocus();
        
       } else
           if(rb48.isSelected()==false)
           {
              t138.setText("");    t146.setText("");        t154.setText("0");
              t138.enable(false);  t146.enable(false);      t154.enable(false);
           }        // TODO add your handling code here:
    }//GEN-LAST:event_rb48ActionPerformed

    private void t138ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t138ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t138ActionPerformed

    private void t138KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t138KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t138KeyReleased

    private void rb49ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb49ActionPerformed
if(rb49.isSelected())
       { 
           t139.enable(true); 
         t147.enable(true);
          t155.enable(true);
         t139.requestFocus();
        
       } else
           if(rb49.isSelected()==false)
           {
              t139.setText("");    t147.setText("");        t155.setText("0");
              t139.enable(false);  t147.enable(false);      t155.enable(false);
           }        // TODO add your handling code here:
    }//GEN-LAST:event_rb49ActionPerformed

    private void t139ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t139ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t139ActionPerformed

    private void t139KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t139KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t139KeyReleased

    private void t141ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t141ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t141ActionPerformed

    private void t147ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t147ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t147ActionPerformed

    private void t148ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t148ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t148ActionPerformed

    private void t149ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t149ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t149ActionPerformed

    private void t150ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t150ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t150ActionPerformed

    private void t151ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t151ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t151ActionPerformed

    private void t152ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t152ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t152ActionPerformed

    private void t153ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t153ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t153ActionPerformed

    private void t154ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t154ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t154ActionPerformed

    private void t155ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t155ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t155ActionPerformed

    private void t67KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t67KeyReleased
int a=Integer.parseInt(t33.getText()) * Integer.parseInt(t67.getText());
t124.setText(String.valueOf(a));
// TODO add your handling code here:
    }//GEN-LAST:event_t67KeyReleased

    private void t112KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t112KeyReleased
int a=Integer.parseInt(t34.getText()) * Integer.parseInt(t112.getText());
t125.setText(String.valueOf(a));        // TODO add your handling code here:
    }//GEN-LAST:event_t112KeyReleased

    private void t118KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t118KeyReleased
int a=Integer.parseInt(t35.getText()) * Integer.parseInt(t118.getText());
t126.setText(String.valueOf(a));        // TODO add your handling code here:
    }//GEN-LAST:event_t118KeyReleased

    private void t119KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t119KeyReleased
        int a=Integer.parseInt(t36.getText()) * Integer.parseInt(t119.getText());
t127.setText(String.valueOf(a));      // TODO add your handling code here:
    }//GEN-LAST:event_t119KeyReleased

    private void t120KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t120KeyReleased
         int a=Integer.parseInt(t37.getText()) * Integer.parseInt(t120.getText());
t128.setText(String.valueOf(a));   // TODO add your handling code here:
    }//GEN-LAST:event_t120KeyReleased

    private void t121KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t121KeyReleased
  int a=Integer.parseInt(t38.getText()) * Integer.parseInt(t121.getText());
t129.setText(String.valueOf(a));          // TODO add your handling code here:
    }//GEN-LAST:event_t121KeyReleased

    private void t122KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t122KeyReleased
  int a=Integer.parseInt(t39.getText()) * Integer.parseInt(t122.getText());
t130.setText(String.valueOf(a));          // TODO add your handling code here:
    }//GEN-LAST:event_t122KeyReleased

    private void t123KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t123KeyReleased
  int a=Integer.parseInt(t40.getText()) * Integer.parseInt(t123.getText());
t131.setText(String.valueOf(a));          // TODO add your handling code here:
    }//GEN-LAST:event_t123KeyReleased

    private void t140KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t140KeyReleased

          int a=Integer.parseInt(t132.getText()) * Integer.parseInt(t140.getText());
t148.setText(String.valueOf(a));  

        // TODO add your handling code here:
    }//GEN-LAST:event_t140KeyReleased

    private void t141KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t141KeyReleased
int a=Integer.parseInt(t133.getText()) * Integer.parseInt(t141.getText());
t149.setText(String.valueOf(a));          // TODO add your handling code here:
    }//GEN-LAST:event_t141KeyReleased

    private void t142KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t142KeyReleased
int a=Integer.parseInt(t134.getText()) * Integer.parseInt(t142.getText());
t150.setText(String.valueOf(a));          // TODO add your handling code here:
    }//GEN-LAST:event_t142KeyReleased

    private void t143KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t143KeyReleased
int a=Integer.parseInt(t135.getText()) * Integer.parseInt(t143.getText());
t151.setText(String.valueOf(a));          // TODO add your handling code here:
    }//GEN-LAST:event_t143KeyReleased

    private void t144KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t144KeyReleased
int a=Integer.parseInt(t136.getText()) * Integer.parseInt(t144.getText());
t152.setText(String.valueOf(a));          // TODO add your handling code here:
    }//GEN-LAST:event_t144KeyReleased

    private void t145KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t145KeyReleased
int a=Integer.parseInt(t137.getText()) * Integer.parseInt(t145.getText());
t153.setText(String.valueOf(a));          // TODO add your handling code here:
    }//GEN-LAST:event_t145KeyReleased

    private void t146KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t146KeyReleased
int a=Integer.parseInt(t138.getText()) * Integer.parseInt(t146.getText());
t154.setText(String.valueOf(a));          // TODO add your handling code here:
    }//GEN-LAST:event_t146KeyReleased

    private void t147KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t147KeyReleased
int a=Integer.parseInt(t139.getText()) * Integer.parseInt(t147.getText());
t155.setText(String.valueOf(a));          // TODO add your handling code here:
    }//GEN-LAST:event_t147KeyReleased

    private void t34KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t34KeyPressed
if(evt.getKeyCode()==KeyEvent.VK_ENTER)
{
    t112.requestFocus();
    
}         // TODO add your handling code here:
    }//GEN-LAST:event_t34KeyPressed

    private void t35KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t35KeyPressed
if(evt.getKeyCode()==KeyEvent.VK_ENTER)
{
    t118.requestFocus();
    
}         // TODO add your handling code here:
    }//GEN-LAST:event_t35KeyPressed

    private void t37KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t37KeyPressed
if(evt.getKeyCode()==KeyEvent.VK_ENTER)
{
    t120.requestFocus();
    
}         // TODO add your handling code here:
    }//GEN-LAST:event_t37KeyPressed

    private void t38KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t38KeyPressed
if(evt.getKeyCode()==KeyEvent.VK_ENTER)
{
    t121.requestFocus();
    
}         // TODO add your handling code here:
    }//GEN-LAST:event_t38KeyPressed

    private void t39KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t39KeyPressed
if(evt.getKeyCode()==KeyEvent.VK_ENTER)
{
    t122.requestFocus();
    
}         // TODO add your handling code here:
    }//GEN-LAST:event_t39KeyPressed

    private void t40KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t40KeyPressed
if(evt.getKeyCode()==KeyEvent.VK_ENTER)
{
    t123.requestFocus();
    
}         // TODO add your handling code here:
    }//GEN-LAST:event_t40KeyPressed

    private void t132KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t132KeyPressed
if(evt.getKeyCode()==KeyEvent.VK_ENTER)
{
    t140.requestFocus();
    
}         // TODO add your handling code here:
    }//GEN-LAST:event_t132KeyPressed

    private void t133KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t133KeyPressed
if(evt.getKeyCode()==KeyEvent.VK_ENTER)
{
    t141.requestFocus();
    
}         // TODO add your handling code here:
    }//GEN-LAST:event_t133KeyPressed

    private void t134KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t134KeyPressed
if(evt.getKeyCode()==KeyEvent.VK_ENTER)
{
    t142.requestFocus();
    
}         // TODO add your handling code here:
    }//GEN-LAST:event_t134KeyPressed

    private void t135KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t135KeyPressed
if(evt.getKeyCode()==KeyEvent.VK_ENTER)
{
    t143.requestFocus();
    
}         // TODO add your handling code here:
    }//GEN-LAST:event_t135KeyPressed

    private void t137KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t137KeyPressed
if(evt.getKeyCode()==KeyEvent.VK_ENTER)
{
    t145.requestFocus();
    
}         // TODO add your handling code here:
    }//GEN-LAST:event_t137KeyPressed

    private void t138KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t138KeyPressed
if(evt.getKeyCode()==KeyEvent.VK_ENTER)
{
    t146.requestFocus();
    
}         // TODO add your handling code here:
    }//GEN-LAST:event_t138KeyPressed

    private void t139KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t139KeyPressed
if(evt.getKeyCode()==KeyEvent.VK_ENTER)
{
    t147.requestFocus();
    
}         // TODO add your handling code here:
    }//GEN-LAST:event_t139KeyPressed

    private void t56ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t56ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t56ActionPerformed

    private void jMenu3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu3MouseClicked
new RateNV().setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_jMenu3MouseClicked

    private void t204ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t204ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t204ActionPerformed

    private void t156FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_t156FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_t156FocusGained

    private void t156ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t156ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t156ActionPerformed

    private void t114ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t114ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t114ActionPerformed

    private void cb2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cb2MouseClicked

        try{
            String a=cb2.getSelectedItem().toString();
            String sql=" SELECT menu, rate\n" +
            "	FROM public.\"Rate\"WHERE menu='"+a+"'             ; ";
            pst=conn.prepareStatement(sql);
            rs= pst.executeQuery();
            if(rs.next())
            {
                t2.setText(rs.getString(2));
            }
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        };      // TODO add your handling code here:
    }//GEN-LAST:event_cb2MouseClicked

    private void cb2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb2ActionPerformed

    }//GEN-LAST:event_cb2ActionPerformed

    private void cb2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cb2KeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            try{
                String a=cb2.getSelectedItem().toString();
                String sql=" SELECT menu, rate\n" +
                "	FROM public.\"Rate\"WHERE menu='"+a+"'             ; ";
                pst=conn.prepareStatement(sql);
                rs= pst.executeQuery();
                if(rs.next())
                {
                    t115.setText(rs.getString(2));
                }
            }catch(Exception e)
            {
                JOptionPane.showMessageDialog(null, e);
            };
             t115.enable(true);
            t115.requestFocus();
          
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_cb2KeyPressed

    private void t115ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t115ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t115ActionPerformed

    private void t115KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t115KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_t115KeyPressed

    private void t115KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t115KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t115KeyReleased

    private void t115KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t115KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_t115KeyTyped

    private void t47ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t47ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t47ActionPerformed

    private void cb3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cb3MouseClicked
           String a=cb3.getSelectedItem().toString();
        String v=null;
       
            try{
                String sql=" SELECT menu, rate\n" +
                "	FROM public.\"Rate\"WHERE menu='"+a+"'             ; ";
                pst=conn.prepareStatement(sql);
                rs= pst.executeQuery();
                if(rs.next())
                {
                    
                     v=rs.getString(2);
                    t117.setText(rs.getString(2));
                }
                
                t117.setText(v);
                
            }catch(Exception e)
            {
                JOptionPane.showMessageDialog(null, e);
            }; 
    }//GEN-LAST:event_cb3MouseClicked

    private void cb3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cb3ActionPerformed

    private void cb3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cb3KeyPressed
if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            try{
                String a=cb3.getSelectedItem().toString();
                String sql=" SELECT menu, rate\n" +
                "	FROM public.\"Rate\"WHERE menu='"+a+"'             ; ";
                pst=conn.prepareStatement(sql);
                rs= pst.executeQuery();
                if(rs.next())
                {
                    t117.setText(rs.getString(2));
                }
            }catch(Exception e)
            {
                JOptionPane.showMessageDialog(null, e);
            };
          t116.enable(true);
            t116.requestFocus();
        }          // TODO add your handling code here:
    }//GEN-LAST:event_cb3KeyPressed

    private void t116ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t116ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t116ActionPerformed

    private void t116KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t116KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_t116KeyPressed

    private void t116KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t116KeyReleased
int total,x1=0;
        
           String a=t116.getText();
           String b=t117.getText();
           int a1  =Integer.parseInt(a);
           int b1 =Integer.parseInt(b);
           
           total=a1*b1;
          
           String str=String.valueOf(total);
           
           
        t157.setText(""+str);
        // TODO add your handling code here:
    }//GEN-LAST:event_t116KeyReleased

    private void t116KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t116KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_t116KeyTyped

    private void t117ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t117ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t117ActionPerformed

    private void t157FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_t157FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_t157FocusGained

    private void t157ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t157ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t157ActionPerformed
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(billing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(billing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(billing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(billing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new billing().setVisible(true);
                
               
            }  
            
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton b4;
    private javax.swing.JComboBox<String> cb2;
    private javax.swing.JComboBox<String> cb3;
    private javax.swing.JTextField cnt1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu10;
    private javax.swing.JMenu jMenu11;
    private javax.swing.JMenu jMenu12;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenu jMenu9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JCheckBoxMenuItem jm1;
    private static javax.swing.JLabel l0;
    private javax.swing.JLabel l1;
    private javax.swing.JLabel l12;
    private javax.swing.JLabel l4;
    private javax.swing.JLabel l5;
    private javax.swing.JLabel l6;
    private javax.swing.JLabel l7;
    private java.awt.PopupMenu popupMenu1;
    private javax.swing.JRadioButton rb1;
    private javax.swing.JRadioButton rb10;
    private javax.swing.JRadioButton rb11;
    private javax.swing.JRadioButton rb12;
    private javax.swing.JRadioButton rb13;
    private javax.swing.JRadioButton rb14;
    private javax.swing.JRadioButton rb15;
    private javax.swing.JRadioButton rb16;
    private javax.swing.JRadioButton rb17;
    private javax.swing.JRadioButton rb18;
    private javax.swing.JRadioButton rb19;
    private javax.swing.JRadioButton rb2;
    private javax.swing.JRadioButton rb20;
    private javax.swing.JRadioButton rb21;
    private javax.swing.JRadioButton rb22;
    private javax.swing.JRadioButton rb23;
    private javax.swing.JRadioButton rb24;
    private javax.swing.JRadioButton rb25;
    private javax.swing.JRadioButton rb26;
    private javax.swing.JRadioButton rb27;
    private javax.swing.JRadioButton rb28;
    private javax.swing.JRadioButton rb29;
    private javax.swing.JRadioButton rb3;
    private javax.swing.JRadioButton rb30;
    private javax.swing.JRadioButton rb32;
    private javax.swing.JRadioButton rb33;
    private javax.swing.JRadioButton rb34;
    private javax.swing.JRadioButton rb35;
    private javax.swing.JRadioButton rb36;
    private javax.swing.JRadioButton rb37;
    private javax.swing.JRadioButton rb38;
    private javax.swing.JRadioButton rb39;
    private javax.swing.JRadioButton rb4;
    private javax.swing.JRadioButton rb40;
    private javax.swing.JRadioButton rb41;
    private javax.swing.JRadioButton rb42;
    private javax.swing.JRadioButton rb43;
    private javax.swing.JRadioButton rb44;
    private javax.swing.JRadioButton rb45;
    private javax.swing.JRadioButton rb46;
    private javax.swing.JRadioButton rb47;
    private javax.swing.JRadioButton rb48;
    private javax.swing.JRadioButton rb49;
    private javax.swing.JRadioButton rb5;
    private javax.swing.JRadioButton rb6;
    private javax.swing.JRadioButton rb7;
    private javax.swing.JRadioButton rb8;
    private javax.swing.JRadioButton rb9;
    private javax.swing.JTextField t1;
    private javax.swing.JTextField t10;
    private javax.swing.JTextField t100;
    private javax.swing.JTextField t101;
    private javax.swing.JTextField t102;
    private javax.swing.JTextField t103;
    private javax.swing.JTextField t104;
    private javax.swing.JTextField t105;
    private javax.swing.JTextField t106;
    private javax.swing.JTextField t107;
    private javax.swing.JTextField t108;
    private javax.swing.JTextField t109;
    private javax.swing.JTextField t11;
    private javax.swing.JTextField t110;
    private javax.swing.JTextField t111;
    private javax.swing.JTextField t112;
    private javax.swing.JTextField t114;
    private javax.swing.JTextField t115;
    private javax.swing.JTextField t116;
    private javax.swing.JTextField t117;
    private javax.swing.JTextField t118;
    private javax.swing.JTextField t119;
    private javax.swing.JTextField t12;
    private javax.swing.JTextField t120;
    private javax.swing.JTextField t121;
    private javax.swing.JTextField t122;
    private javax.swing.JTextField t123;
    private javax.swing.JTextField t124;
    private javax.swing.JTextField t125;
    private javax.swing.JTextField t126;
    private javax.swing.JTextField t127;
    private javax.swing.JTextField t128;
    private javax.swing.JTextField t129;
    private javax.swing.JTextField t13;
    private javax.swing.JTextField t130;
    private javax.swing.JTextField t131;
    private javax.swing.JTextField t132;
    private javax.swing.JTextField t133;
    private javax.swing.JTextField t134;
    private javax.swing.JTextField t135;
    private javax.swing.JTextField t136;
    private javax.swing.JTextField t137;
    private javax.swing.JTextField t138;
    private javax.swing.JTextField t139;
    private javax.swing.JTextField t14;
    private javax.swing.JTextField t140;
    private javax.swing.JTextField t141;
    private javax.swing.JTextField t142;
    private javax.swing.JTextField t143;
    private javax.swing.JTextField t144;
    private javax.swing.JTextField t145;
    private javax.swing.JTextField t146;
    private javax.swing.JTextField t147;
    private javax.swing.JTextField t148;
    private javax.swing.JTextField t149;
    private javax.swing.JTextField t15;
    private javax.swing.JTextField t150;
    private javax.swing.JTextField t151;
    private javax.swing.JTextField t152;
    private javax.swing.JTextField t153;
    private javax.swing.JTextField t154;
    private javax.swing.JTextField t155;
    private javax.swing.JTextField t156;
    private javax.swing.JTextField t157;
    private javax.swing.JTextField t16;
    private javax.swing.JTextField t17;
    private javax.swing.JTextField t18;
    private javax.swing.JTextField t19;
    private javax.swing.JTextField t2;
    private javax.swing.JTextField t20;
    private javax.swing.JTextField t204;
    private javax.swing.JTextField t21;
    private javax.swing.JTextField t22;
    private javax.swing.JTextField t23;
    private javax.swing.JTextField t24;
    private javax.swing.JTextField t25;
    private javax.swing.JTextField t26;
    private javax.swing.JTextField t27;
    private javax.swing.JTextField t28;
    private javax.swing.JTextField t29;
    private javax.swing.JTextField t3;
    private javax.swing.JTextField t30;
    private javax.swing.JTextField t31;
    private javax.swing.JTextField t32;
    private javax.swing.JTextField t33;
    private javax.swing.JTextField t34;
    private javax.swing.JTextField t35;
    private javax.swing.JTextField t36;
    private javax.swing.JTextField t37;
    private javax.swing.JTextField t38;
    private javax.swing.JTextField t39;
    private javax.swing.JTextField t4;
    private javax.swing.JTextField t40;
    private javax.swing.JTextField t41;
    private javax.swing.JTextField t42;
    private javax.swing.JTextField t43;
    private javax.swing.JTextField t44;
    private javax.swing.JTextField t45;
    private javax.swing.JTextField t46;
    private javax.swing.JTextField t47;
    private javax.swing.JTextField t48;
    private javax.swing.JTextField t49;
    private javax.swing.JTextField t5;
    private javax.swing.JTextField t50;
    private javax.swing.JTextField t51;
    private javax.swing.JTextField t52;
    private javax.swing.JTextField t53;
    private javax.swing.JTextField t54;
    public javax.swing.JTextField t56;
    private javax.swing.JTextField t57;
    private javax.swing.JTextField t58;
    private javax.swing.JTextField t59;
    private javax.swing.JTextField t6;
    private javax.swing.JTextField t60;
    private javax.swing.JTextField t61;
    private javax.swing.JTextField t62;
    private javax.swing.JTextField t63;
    private javax.swing.JTextField t64;
    private javax.swing.JTextField t65;
    private javax.swing.JTextField t66;
    private javax.swing.JTextField t67;
    private javax.swing.JTextField t68;
    private javax.swing.JTextField t69;
    private javax.swing.JTextField t7;
    private javax.swing.JTextField t70;
    private javax.swing.JTextField t71;
    private javax.swing.JTextField t72;
    private javax.swing.JTextField t73;
    private javax.swing.JTextField t74;
    private javax.swing.JTextField t75;
    private javax.swing.JTextField t76;
    private javax.swing.JTextField t77;
    private javax.swing.JTextField t78;
    private javax.swing.JTextField t79;
    private javax.swing.JTextField t8;
    private javax.swing.JTextField t80;
    private javax.swing.JTextField t81;
    private javax.swing.JTextField t82;
    private javax.swing.JTextField t83;
    private javax.swing.JTextField t84;
    private javax.swing.JTextField t85;
    private javax.swing.JTextField t86;
    private javax.swing.JTextField t87;
    private javax.swing.JTextField t88;
    private javax.swing.JTextField t89;
    private javax.swing.JTextField t9;
    private javax.swing.JTextField t90;
    private javax.swing.JTextField t91;
    private javax.swing.JTextField t92;
    private javax.swing.JTextField t93;
    private javax.swing.JTextField t94;
    private javax.swing.JTextField t95;
    private javax.swing.JTextField t96;
    private javax.swing.JTextField t97;
    private javax.swing.JTextField t98;
    private javax.swing.JTextField t99;
    private javax.swing.JTextArea tt1;
    private java.awt.TextArea tt2;
    // End of variables declaration//GEN-END:variables
}
