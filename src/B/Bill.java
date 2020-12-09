/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package B;

import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.awt.print.Printable;
import static java.awt.print.Printable.NO_SUCH_PAGE;
import static java.awt.print.Printable.PAGE_EXISTS;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.jdbc.JDBCCategoryDataset;
import org.apache.poi.*;

public class Bill extends javax.swing.JFrame {
 ConnectDB cdb=new ConnectDB();
    public Connection conn=cdb.getConn();
     public ResultSet rs=null;
    PreparedStatement pst=null;
    Statement smt=null;
    int a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z,a1,a2,a3,a4,a5,a6,a7,a8,a9,a10=0;
  
    int tot;
    
    public Bill() {
        initComponents();
         tfclose();
        Date1();
        time1();
       fetchcno();
        onload();
        addCombo();
       
         AutoCompleteDecorator.decorate(cb3);
    }
    
    
    
    /////////////////////////////////////////////////////////////////////////////////////////////////////

public PageFormat getPageFormat(PrinterJob pj)
{
    
    PageFormat pf = pj.defaultPage();
    Paper paper = pf.getPaper();    

    double middleHeight =8.0;  
    double headerHeight = 2.0;                  
    double footerHeight = 2.0;                  
    double width = convert_CM_To_PPI(8);      //printer know only point per inch.default value is 72ppi
    double height = convert_CM_To_PPI(headerHeight+middleHeight+footerHeight); 
    paper.setSize(width, height);
    paper.setImageableArea(                    
        0,
        10,
        width,            
        height - convert_CM_To_PPI(1)
    );   //define boarder size    after that print area width is about 180 points
            
    pf.setOrientation(PageFormat.PORTRAIT);           //select orientation portrait or landscape but for this time portrait
    pf.setPaper(paper);    

    return pf;
}
    
    protected static double convert_CM_To_PPI(double cm) {            
	        return toPPI(cm * 0.393600787);            
}
 
protected static double toPPI(double inch) {            
	        return inch * 72d;            
}

public class BillPrintable implements Printable {
    
   
    
    
  public int print(Graphics graphics, PageFormat pageFormat,int pageIndex) 
  throws PrinterException 
  {    
      
                
        
      int result = NO_SUCH_PAGE;    
        if (pageIndex == 0) {                    
        
            Graphics2D g2d = (Graphics2D) graphics;                    

            double width = pageFormat.getImageableWidth();                    
           
            g2d.translate((int) pageFormat.getImageableX(),(int) pageFormat.getImageableY()); 

            ////////// code by alqama//////////////

            FontMetrics metrics=g2d.getFontMetrics(new Font("Arial",Font.BOLD,7));
        //    int idLength=metrics.stringWidth("000000");
            //int idLength=metrics.stringWidth("00");
            int idLength=metrics.stringWidth("000");
            int amtLength=metrics.stringWidth("000000");
            int qtyLength=metrics.stringWidth("00000");
            int priceLength=metrics.stringWidth("000000");
            int prodLength=(int)width - idLength - amtLength - qtyLength - priceLength-17;

        //    int idPosition=0;
        //    int productPosition=idPosition + idLength + 2;
        //    int pricePosition=productPosition + prodLength +10;
        //    int qtyPosition=pricePosition + priceLength + 2;
        //    int amtPosition=qtyPosition + qtyLength + 2;
            
            int productPosition = 0;
            int discountPosition= prodLength+5;
            int pricePosition = discountPosition +idLength+10;
            int qtyPosition=pricePosition + priceLength + 4;
            int amtPosition=qtyPosition + qtyLength;
            
            
              
        try{
            /*Draw Header*/
            int y=20;
            int yShift = 10;
            int headerRectHeight=15;
            int headerRectHeighta=40;
            
            ///////////////// Product names Get ///////////
            String  pn1a  ,pn2a,pn3a ;
              pn1a=tt1.getText();
                 pn2a=cnt1.getText();
                 pn3a=t111.getText();
//                String pn4a=pn4.getText();
            ///////////////// Product names Get ///////////
                
            
            ///////////////// Product price Get ///////////
//                int pp1a=Integer.valueOf(pp1.getText());
//                int pp2a=Integer.valueOf(pp2.getText());
//                int pp3a=Integer.valueOf(pp3.getText());
//                int pp4a=Integer.valueOf(pp4.getText());
//                int sum=pp1a+pp2a+pp3a+pp4a;
            ///////////////// Product price Get ///////////
                
             g2d.setFont(new Font("Monospaced",Font.PLAIN,9));
            g2d.drawString("-------------------------------------",12,y);y+=yShift;
            g2d.drawString("      Restaurant Bill Receipt        ",12,y);y+=yShift;
            g2d.drawString("-------------------------------------",12,y);y+=headerRectHeight;
      
            g2d.drawString("-------------------------------------",10,y);y+=yShift;
            g2d.drawString(" Food Name                 T.Price   ",10,y);y+=yShift;
            g2d.drawString("-------------------------------------",10,y);y+=headerRectHeight;
               
            g2d.drawString(" "+pn1a+"                    ",10,y);y+=yShift;
            g2d.drawString(" "+pn2a+"                    ",10,y);y+=yShift;
            g2d.drawString(" "+pn3a+"                   ",10,y);y+=yShift;
//            g2d.drawString(" "+pn4a+"                  "+pp4a+"  ",10,y);y+=yShift;
            g2d.drawString("-------------------------------------",10,y);y+=yShift;
            g2d.drawString(" Total amount: "+pn3a+"               ",10,y);y+=yShift;
            g2d.drawString("-------------------------------------",10,y);y+=yShift;
            g2d.drawString("          Free Home Delivery         ",10,y);y+=yShift;
            g2d.drawString("             03111111111             ",10,y);y+=yShift;
            g2d.drawString("*************************************",10,y);y+=yShift;
            g2d.drawString("    THANKS TO VISIT OUR RESTUARANT   ",10,y);y+=yShift;
            g2d.drawString("*************************************",10,y);y+=yShift;
                   
           
             
           
            
//            g2d.setFont(new Font("Monospaced",Font.BOLD,10));
//            g2d.drawString("Customer Shopping Invoice", 30,y);y+=yShift; 
          

    }
    catch(Exception r){
    r.printStackTrace();
    }

              result = PAGE_EXISTS;    
          }    
          return result;    
      }
   }

     public void addCombo()
     {
        try{
             String sql="SELECT menu, rate\n" +
"	FROM public.\"Rate\" ORDER BY menu ASC  ;";
        pst=conn.prepareStatement(sql);
        rs=pst.executeQuery();
        
        while(rs.next()){
            String menu=rs.getString(1);
            cb3.addItem(menu);
            cb2.addItem(menu);
        }
        }catch(Exception e){}
        
    }
   /*-------------------------------------------------------------------*/  
      void fetchcno()
    {   
        String sum = null,count=null;
        Date  date= new Date();
               SimpleDateFormat s= new SimpleDateFormat("dd-MM-yyyy");
               String dt=s.format(date);
        try{
            String query="SELECT  sum(total)\n" +
"           FROM public.\"Total\" WHERE  date='"+dt+"'   ;";
        pst=conn.prepareStatement(query);
        rs=pst.executeQuery();
        if(rs.next())
        {
             sum=rs.getString(1);
             if(sum.equals("")){
                 t204.setText("0");
             }else{
            t204.setText(sum);
             }
        }
       
        }catch(Exception e)
        {
            //JOptionPane.showMessageDialog(null, e);
        }
        
        try{
            String query="SELECT  count(cno)\n" +
"           FROM public.\"Total\" WHERE  date='"+dt+"'   ;";
        pst=conn.prepareStatement(query);
        rs=pst.executeQuery();
        if(rs.next())
        {
             count=rs.getString(1);
            t205.setText(count);
            t111.setText(count);
        }
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
        

    }
     
      public void  updatedaily()
      {
          try{
                Date  date= new Date();
               SimpleDateFormat s= new SimpleDateFormat("dd-MM-yyyy");
               String dt=s.format(date);
              
               int a=Integer.parseInt(t204.getText());
                int b=Integer.parseInt(cnt1.getText());
                 int sum=a+b;
                         String sum1=String.valueOf(sum);
                 String sql="SELECT  date, total\n" +
"	FROM public.\"EveryDay_Total\" WHERE date=?  ;";
                 
                
                 
                 String sql1="UPDATE public.\"EveryDay_Total\"\n" +
"	SET date=?, total=?\n" +
"	WHERE date='"+dt+"'   ;";
                 
                 
                  String sql2="INSERT INTO public.\"EveryDay_Total\"(\n" +
"	date, total)\n" +
"	VALUES (?, ?);";
                  
                  
                 pst=conn.prepareStatement(sql);
                 pst.setString(1,dt);
                 rs=pst.executeQuery();
                 if(rs.next())
                 {
                     pst=conn.prepareStatement(sql1);
                         pst.setString(1,dt);
                         pst.setInt(2,sum);
                         pst.execute();
                          JOptionPane.showMessageDialog(null, "updated");
                          fetchcno();
                   }else{                    
                        JOptionPane.showMessageDialog(null, "failsd");
                         pst=conn.prepareStatement(sql2);
                         pst.setString(1,dt);
                         pst.setInt(2,Integer.parseInt(cnt1.getText()));
                         pst.execute();
                          JOptionPane.showMessageDialog(null, "new Added");
                    }
            }catch(Exception e){System.out.println( e);
            }
   
     
      }
      void onload()
     {
      tt1.setText("********************************\n"+
                   "*       Hotel Shubham       *\n"+
                   "********************************\n"
                   
                 );
     }
      
      
    public void time1()
   {
       new Timer(0,new ActionListener(){
           public void actionPerformed(ActionEvent e) {
               
               Date  dt= new Date();
               SimpleDateFormat s= new SimpleDateFormat("dd-MM-yyyy");
               String dtt=s.format(dt);
               ldt.setText(dtt);
               }
            
       }).start();
   }
    
   public void Date1()
   {
       new Timer(0,new ActionListener(){
           public void actionPerformed(ActionEvent e) {
               
               Date  dt= new Date();
               SimpleDateFormat s= new SimpleDateFormat("hh:mm:ss a");
               
               l2.setText(s.format(dt));
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
    String a=ldt.getText();
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
   
    void rb1()
   {
         try{
             Date  date= new Date();
               SimpleDateFormat s= new SimpleDateFormat("dd-MM-yyyy");
                 String dt=s.format(date);
                 String item=rb1.getText();
                 String select="SELECT date, item, quntity,rupees\n" +
"	FROM public.\"ItemSell\" WHERE date=? AND item=?";
                 
               
                 
                 String insert="INSERT INTO public.\"ItemSell\"(\n" +
"	date, item, quntity, rupees)\n" +
"	VALUES (?, ?, ?, ?);";
                  pst=conn.prepareStatement(select);
                 pst.setString(1,dt);
                 pst.setString(2,item);
                 rs=pst.executeQuery();
                 if(rs.next())
                 {    String qt=rs.getString(3);
                     String st=rs.getString(4);
                    
                   int aa=Integer.valueOf(qt);
                   int bb=Integer.valueOf(t1.getText());
                   int cc=aa+bb;
                    double ff,ee=0.0;
                   String dd=rs.getString(4);
                    ee=Double.valueOf(dd);
                    ff=Double.valueOf(t57.getText());
                    double gg=ee+ff;
                  
                     pst=conn.prepareStatement("UPDATE public.\"ItemSell\"\n" +
"	SET  quntity='"+cc+"'  , rupees='"+gg+"'  \n" +
"	WHERE  item='"+rb1.getText().toString()+"' AND date='"+dt+"'  ;");
                        pst.execute();
                         JOptionPane.showMessageDialog(null, "updated");
                          }else{                    
                        JOptionPane.showMessageDialog(null, "failed");
                         pst=conn.prepareStatement(insert);
                         pst.setString(1,dt);
                         pst.setString(2,item);
                         pst.setInt(3,Integer.parseInt(t1.getText()));
                         pst.setDouble(4,Double.parseDouble(t57.getText()));
                         pst.execute();
                          JOptionPane.showMessageDialog(null, "new Added");
                    }
            }catch(Exception e){ JOptionPane.showMessageDialog(null, e);
            }
        }
   
   
    void rb2(){
       
            try{
             Date  date= new Date();
               SimpleDateFormat s= new SimpleDateFormat("dd-MM-yyyy");
                 String dt=s.format(date);
                 String item=rb2.getText();
                 String select="SELECT date, item, quntity,rupees\n" +
"	FROM public.\"ItemSell\" WHERE date=? AND item=?";
                 
               
                 
                 String insert="INSERT INTO public.\"ItemSell\"(\n" +
"	date, item, quntity, rupees)\n" +
"	VALUES (?, ?, ?, ?);";
                  pst=conn.prepareStatement(select);
                 pst.setString(1,dt);
                 pst.setString(2,item);
                 rs=pst.executeQuery();
                 if(rs.next())
                 {    String qt=rs.getString(3);
                     String st=rs.getString(4);
                    
                   int aa=Integer.valueOf(qt);
                   int bb=Integer.valueOf(t3.getText());
                   int cc=aa+bb;
                    double ff,ee=0.0;
                   String dd=rs.getString(4);
                    ee=Double.valueOf(dd);
                    ff=Double.valueOf(t61.getText());
                    double gg=ee+ff;
                  
                     pst=conn.prepareStatement("UPDATE public.\"ItemSell\"\n" +
"	SET  quntity='"+cc+"'  , rupees='"+gg+"'  \n" +
"	WHERE  item='"+rb2.getText().toString()+"' AND date='"+dt+"'  ;");
                        pst.execute();
                         JOptionPane.showMessageDialog(null, "updated");
                          }else{                    
                        JOptionPane.showMessageDialog(null, "failed");
                         pst=conn.prepareStatement(insert);
                         pst.setString(1,dt);
                         pst.setString(2,item);
                         pst.setInt(3,Integer.parseInt(t3.getText()));
                         pst.setDouble(4,Double.parseDouble(t61.getText()));
                         pst.execute();
                          JOptionPane.showMessageDialog(null, "new Added");
                    }
            }catch(Exception e){ JOptionPane.showMessageDialog(null, e);
            }
    }
   
  void rb3()
  {
       try{
             Date  date= new Date();
               SimpleDateFormat s= new SimpleDateFormat("dd-MM-yyyy");
                 String dt=s.format(date);
                 String item=rb3.getText();
                 String select="SELECT date, item, quntity,rupees\n" +
"	FROM public.\"ItemSell\" WHERE date=? AND item=?";
                 
               
                 
                 String insert="INSERT INTO public.\"ItemSell\"(\n" +
"	date, item, quntity, rupees)\n" +
"	VALUES (?, ?, ?, ?);";
                  pst=conn.prepareStatement(select);
                 pst.setString(1,dt);
                 pst.setString(2,item);
                 rs=pst.executeQuery();
                 if(rs.next())
                 {    String qt=rs.getString(3);
                     String st=rs.getString(4);
                    
                   int aa=Integer.valueOf(qt);
                   int bb=Integer.valueOf(t4.getText());
                   int cc=aa+bb;
                    double ff,ee=0.0;
                   String dd=rs.getString(4);
                    ee=Double.valueOf(dd);
                    ff=Double.valueOf(t62.getText());
                    double gg=ee+ff;
                  
                     pst=conn.prepareStatement("UPDATE public.\"ItemSell\"\n" +
"	SET  quntity='"+cc+"'  , rupees='"+gg+"'  \n" +
"	WHERE  item='"+rb3.getText().toString()+"' AND date='"+dt+"'  ;");
                        pst.execute();
                         JOptionPane.showMessageDialog(null, "updated");
                          }else{                    
                        JOptionPane.showMessageDialog(null, "failed");
                         pst=conn.prepareStatement(insert);
                         pst.setString(1,dt);
                         pst.setString(2,item);
                         pst.setInt(3,Integer.parseInt(t4.getText()));
                         pst.setDouble(4,Double.parseDouble(t62.getText()));
                         pst.execute();
                          JOptionPane.showMessageDialog(null, "new Added");
                    }
            }catch(Exception e){ JOptionPane.showMessageDialog(null, e);
            }
  }
    
    void rb5(){
          try{
             Date  date= new Date();
               SimpleDateFormat s= new SimpleDateFormat("dd-MM-yyyy");
                 String dt=s.format(date);
                 String item=rb5.getText();
                 String select="SELECT date, item, quntity,rupees\n" +
"	FROM public.\"ItemSell\" WHERE date=? AND item=?";
                 
               
                 
                 String insert="INSERT INTO public.\"ItemSell\"(\n" +
"	date, item, quntity, rupees)\n" +
"	VALUES (?, ?, ?, ?);";
                  pst=conn.prepareStatement(select);
                 pst.setString(1,dt);
                 pst.setString(2,item);
                 rs=pst.executeQuery();
                 if(rs.next())
                 {    String qt=rs.getString(3);
                     String st=rs.getString(4);
                    
                   int aa=Integer.valueOf(qt);
                   int bb=Integer.valueOf(t5.getText());
                   int cc=aa+bb;
                    double ff,ee=0.0;
                   String dd=rs.getString(4);
                    ee=Double.valueOf(dd);
                    ff=Double.valueOf(t63.getText());
                    double gg=ee+ff;
                  
                     pst=conn.prepareStatement("UPDATE public.\"ItemSell\"\n" +
"	SET  quntity='"+cc+"'  , rupees='"+gg+"'  \n" +
"	WHERE  item='"+rb5.getText().toString()+"' AND date='"+dt+"'  ;");
                        pst.execute();
                         JOptionPane.showMessageDialog(null, "updated");
                          }else{                    
                        JOptionPane.showMessageDialog(null, "failed");
                         pst=conn.prepareStatement(insert);
                         pst.setString(1,dt);
                         pst.setString(2,item);
                         pst.setInt(3,Integer.parseInt(t5.getText()));
                         pst.setDouble(4,Double.parseDouble(t63.getText()));
                         pst.execute();
                          JOptionPane.showMessageDialog(null, "new Added");
                    }
            }catch(Exception e){ JOptionPane.showMessageDialog(null, e);
            }
    }
    
    void rb7()
    {
         try{
             Date  date= new Date();
               SimpleDateFormat s= new SimpleDateFormat("dd-MM-yyyy");
                 String dt=s.format(date);
                 String item=rb7.getText();
                 String select="SELECT date, item, quntity,rupees\n" +
"	FROM public.\"ItemSell\" WHERE date=? AND item=?";
                 
               
                 
                 String insert="INSERT INTO public.\"ItemSell\"(\n" +
"	date, item, quntity, rupees)\n" +
"	VALUES (?, ?, ?, ?);";
                  pst=conn.prepareStatement(select);
                 pst.setString(1,dt);
                 pst.setString(2,item);
                 rs=pst.executeQuery();
                 if(rs.next())
                 {    String qt=rs.getString(3);
                     String st=rs.getString(4);
                    
                   int aa=Integer.valueOf(qt);
                   int bb=Integer.valueOf(t6.getText());
                   int cc=aa+bb;
                    double ff,ee=0.0;
                   String dd=rs.getString(4);
                    ee=Double.valueOf(dd);
                    ff=Double.valueOf(t64.getText());
                    double gg=ee+ff;
                  
                     pst=conn.prepareStatement("UPDATE public.\"ItemSell\"\n" +
"	SET  quntity='"+cc+"'  , rupees='"+gg+"'  \n" +
"	WHERE  item='"+rb7.getText().toString()+"' AND date='"+dt+"'  ;");
                        pst.execute();
                         JOptionPane.showMessageDialog(null, "updated");
                          }else{                    
                        JOptionPane.showMessageDialog(null, "failed");
                         pst=conn.prepareStatement(insert);
                         pst.setString(1,dt);
                         pst.setString(2,item);
                         pst.setInt(3,Integer.parseInt(t6.getText()));
                         pst.setDouble(4,Double.parseDouble(t64.getText()));
                         pst.execute();
                          JOptionPane.showMessageDialog(null, "new Added");
                    }
            }catch(Exception e){ JOptionPane.showMessageDialog(null, e);
            }
    }
    void rb6(){  try{
             Date  date= new Date();
               SimpleDateFormat s= new SimpleDateFormat("dd-MM-yyyy");
                 String dt=s.format(date);
                 String item=rb6.getText();
                 String select="SELECT date, item, quntity,rupees\n" +
"	FROM public.\"ItemSell\" WHERE date=? AND item=?";
                 
               
                 
                 String insert="INSERT INTO public.\"ItemSell\"(\n" +
"	date, item, quntity, rupees)\n" +
"	VALUES (?, ?, ?, ?);";
                  pst=conn.prepareStatement(select);
                 pst.setString(1,dt);
                 pst.setString(2,item);
                 rs=pst.executeQuery();
                 if(rs.next())
                 {    String qt=rs.getString(3);
                     String st=rs.getString(4);
                    
                   int aa=Integer.valueOf(qt);
                   int bb=Integer.valueOf(t9.getText());
                   int cc=aa+bb;
                    double ff,ee=0.0;
                   String dd=rs.getString(4);
                    ee=Double.valueOf(dd);
                    ff=Double.valueOf(t65.getText());
                    double gg=ee+ff;
                  
                     pst=conn.prepareStatement("UPDATE public.\"ItemSell\"\n" +
"	SET  quntity='"+cc+"'  , rupees='"+gg+"'  \n" +
"	WHERE  item='"+rb6.getText().toString()+"' AND date='"+dt+"'  ;");
                        pst.execute();
                         JOptionPane.showMessageDialog(null, "updated");
                          }else{                    
                        JOptionPane.showMessageDialog(null, "failed");
                         pst=conn.prepareStatement(insert);
                         pst.setString(1,dt);
                         pst.setString(2,item);
                         pst.setInt(3,Integer.parseInt(t9.getText()));
                         pst.setDouble(4,Double.parseDouble(t65.getText()));
                         pst.execute();
                          JOptionPane.showMessageDialog(null, "new Added");
                    }
            }catch(Exception e){ JOptionPane.showMessageDialog(null, e);
            }
        
    }
    void rb16(){
           try{
             Date  date= new Date();
               SimpleDateFormat s= new SimpleDateFormat("dd-MM-yyyy");
                 String dt=s.format(date);
                 String item=rb16.getText();
                 String select="SELECT date, item, quntity,rupees\n" +
"	FROM public.\"ItemSell\" WHERE date=? AND item=?";
                 
               
                 
                 String insert="INSERT INTO public.\"ItemSell\"(\n" +
"	date, item, quntity, rupees)\n" +
"	VALUES (?, ?, ?, ?);";
                  pst=conn.prepareStatement(select);
                 pst.setString(1,dt);
                 pst.setString(2,item);
                 rs=pst.executeQuery();
                 if(rs.next())
                 {    String qt=rs.getString(3);
                     String st=rs.getString(4);
                    
                   int aa=Integer.valueOf(qt);
                   int bb=Integer.valueOf(t13.getText());
                   int cc=aa+bb;
                    double ff,ee=0.0;
                   String dd=rs.getString(4);
                    ee=Double.valueOf(dd);
                    ff=Double.valueOf(t66.getText());
                    double gg=ee+ff;
                  
                     pst=conn.prepareStatement("UPDATE public.\"ItemSell\"\n" +
"	SET  quntity='"+cc+"'  , rupees='"+gg+"'  \n" +
"	WHERE  item='"+rb16.getText().toString()+"' AND date='"+dt+"'  ;");
                        pst.execute();
                         JOptionPane.showMessageDialog(null, "updated");
                          }else{                    
                        JOptionPane.showMessageDialog(null, "failed");
                         pst=conn.prepareStatement(insert);
                         pst.setString(1,dt);
                         pst.setString(2,item);
                         pst.setInt(3,Integer.parseInt(t13.getText()));
                         pst.setDouble(4,Double.parseDouble(t66.getText()));
                         pst.execute();
                          JOptionPane.showMessageDialog(null, "new Added");
                    }
            }catch(Exception e){ JOptionPane.showMessageDialog(null, e);
            }
    }
    void rb8(){
         try{
             Date  date= new Date();
               SimpleDateFormat s= new SimpleDateFormat("dd-MM-yyyy");
                 String dt=s.format(date);
                 String item=rb8.getText();
                 String select="SELECT date, item, quntity,rupees\n" +
"	FROM public.\"ItemSell\" WHERE date=? AND item=?";
                 
               
                 
                 String insert="INSERT INTO public.\"ItemSell\"(\n" +
"	date, item, quntity, rupees)\n" +
"	VALUES (?, ?, ?, ?);";
                  pst=conn.prepareStatement(select);
                 pst.setString(1,dt);
                 pst.setString(2,item);
                 rs=pst.executeQuery();
                 if(rs.next())
                 {    String qt=rs.getString(3);
                     String st=rs.getString(4);
                    
                   int aa=Integer.valueOf(qt);
                   int bb=Integer.valueOf(t7.getText());
                   int cc=aa+bb;
                    double ff,ee=0.0;
                   String dd=rs.getString(4);
                    ee=Double.valueOf(dd);
                    ff=Double.valueOf(t58.getText());
                    double gg=ee+ff;
                  
                     pst=conn.prepareStatement("UPDATE public.\"ItemSell\"\n" +
"	SET  quntity='"+cc+"'  , rupees='"+gg+"'  \n" +
"	WHERE  item='"+rb8.getText().toString()+"' AND date='"+dt+"'  ;");
                        pst.execute();
                         JOptionPane.showMessageDialog(null, "updated");
                          }else{                    
                        JOptionPane.showMessageDialog(null, "failed");
                         pst=conn.prepareStatement(insert);
                         pst.setString(1,dt);
                         pst.setString(2,item);
                         pst.setInt(3,Integer.parseInt(t7.getText()));
                         pst.setDouble(4,Double.parseDouble(t58.getText()));
                         pst.execute();
                          JOptionPane.showMessageDialog(null, "new Added");
                    }
            }catch(Exception e){ JOptionPane.showMessageDialog(null, e);
            }

    }
   void rb9(){
        try{
             Date  date= new Date();
               SimpleDateFormat s= new SimpleDateFormat("dd-MM-yyyy");
                 String dt=s.format(date);
                 String item=rb9.getText();
                 String select="SELECT date, item, quntity,rupees\n" +
"	FROM public.\"ItemSell\" WHERE date=? AND item=?";
                 
               
                 
                 String insert="INSERT INTO public.\"ItemSell\"(\n" +
"	date, item, quntity, rupees)\n" +
"	VALUES (?, ?, ?, ?);";
                  pst=conn.prepareStatement(select);
                 pst.setString(1,dt);
                 pst.setString(2,item);
                 rs=pst.executeQuery();
                 if(rs.next())
                 {    String qt=rs.getString(3);
                     String st=rs.getString(4);
                    
                   int aa=Integer.valueOf(qt);
                   int bb=Integer.valueOf(t8.getText());
                   int cc=aa+bb;
                    double ff,ee=0.0;
                   String dd=rs.getString(4);
                    ee=Double.valueOf(dd);
                    ff=Double.valueOf(t69.getText());
                    double gg=ee+ff;
                  
                     pst=conn.prepareStatement("UPDATE public.\"ItemSell\"\n" +
"	SET  quntity='"+cc+"'  , rupees='"+gg+"'  \n" +
"	WHERE  item='"+rb9.getText().toString()+"' AND date='"+dt+"'  ;");
                        pst.execute();
                         JOptionPane.showMessageDialog(null, "updated");
                          }else{                    
                        JOptionPane.showMessageDialog(null, "failed");
                         pst=conn.prepareStatement(insert);
                         pst.setString(1,dt);
                         pst.setString(2,item);
                         pst.setInt(3,Integer.parseInt(t8.getText()));
                         pst.setDouble(4,Double.parseDouble(t69.getText()));
                         pst.execute();
                          JOptionPane.showMessageDialog(null, "new Added");
                    }
            }catch(Exception e){ JOptionPane.showMessageDialog(null, e);
            }
   }
   
   void rb10(){
         try{
             Date  date= new Date();
               SimpleDateFormat s= new SimpleDateFormat("dd-MM-yyyy");
                 String dt=s.format(date);
                 String item=rb10.getText();
                 String select="SELECT date, item, quntity,rupees\n" +
"	FROM public.\"ItemSell\" WHERE date=? AND item=?";
                 
               
                 
                 String insert="INSERT INTO public.\"ItemSell\"(\n" +
"	date, item, quntity, rupees)\n" +
"	VALUES (?, ?, ?, ?);";
                  pst=conn.prepareStatement(select);
                 pst.setString(1,dt);
                 pst.setString(2,item);
                 rs=pst.executeQuery();
                 if(rs.next())
                 {    String qt=rs.getString(3);
                     String st=rs.getString(4);
                    
                   int aa=Integer.valueOf(qt);
                   int bb=Integer.valueOf(t10.getText());
                   int cc=aa+bb;
                    double ff,ee=0.0;
                   String dd=rs.getString(4);
                    ee=Double.valueOf(dd);
                    ff=Double.valueOf(t70.getText());
                    double gg=ee+ff;
                  
                     pst=conn.prepareStatement("UPDATE public.\"ItemSell\"\n" +
"	SET  quntity='"+cc+"'  , rupees='"+gg+"'  \n" +
"	WHERE  item='"+rb10.getText().toString()+"' AND date='"+dt+"'  ;");
                        pst.execute();
                         JOptionPane.showMessageDialog(null, "updated");
                          }else{                    
                        JOptionPane.showMessageDialog(null, "failed");
                         pst=conn.prepareStatement(insert);
                         pst.setString(1,dt);
                         pst.setString(2,item);
                         pst.setInt(3,Integer.parseInt(t10.getText()));
                         pst.setDouble(4,Double.parseDouble(t70.getText()));
                         pst.execute();
                          JOptionPane.showMessageDialog(null, "new Added");
                    }
            }catch(Exception e){ JOptionPane.showMessageDialog(null, e);
            }
   }
   
   void rb11(){
        try{
             Date  date= new Date();
               SimpleDateFormat s= new SimpleDateFormat("dd-MM-yyyy");
                 String dt=s.format(date);
                 String item=rb11.getText();
                 String select="SELECT date, item, quntity,rupees\n" +
"	FROM public.\"ItemSell\" WHERE date=? AND item=?";
                 
               
                 
                 String insert="INSERT INTO public.\"ItemSell\"(\n" +
"	date, item, quntity, rupees)\n" +
"	VALUES (?, ?, ?, ?);";
                  pst=conn.prepareStatement(select);
                 pst.setString(1,dt);
                 pst.setString(2,item);
                 rs=pst.executeQuery();
                 if(rs.next())
                 {    String qt=rs.getString(3);
                     String st=rs.getString(4);
                    
                   int aa=Integer.valueOf(qt);
                   int bb=Integer.valueOf(t20.getText());
                   int cc=aa+bb;
                    double ff,ee=0.0;
                   String dd=rs.getString(4);
                    ee=Double.valueOf(dd);
                    ff=Double.valueOf(t71.getText());
                    double gg=ee+ff;
                  
                     pst=conn.prepareStatement("UPDATE public.\"ItemSell\"\n" +
"	SET  quntity='"+cc+"'  , rupees='"+gg+"'  \n" +
"	WHERE  item='"+rb11.getText().toString()+"' AND date='"+dt+"'  ;");
                        pst.execute();
                         JOptionPane.showMessageDialog(null, "updated");
                          }else{                    
                        JOptionPane.showMessageDialog(null, "failed");
                         pst=conn.prepareStatement(insert);
                         pst.setString(1,dt);
                         pst.setString(2,item);
                         pst.setInt(3,Integer.parseInt(t20.getText()));
                         pst.setDouble(4,Double.parseDouble(t71.getText()));
                         pst.execute();
                          JOptionPane.showMessageDialog(null, "new Added");
                    }
            }catch(Exception e){ JOptionPane.showMessageDialog(null, e);
            }
   }
   void rb12(){
       try{
             Date  date= new Date();
               SimpleDateFormat s= new SimpleDateFormat("dd-MM-yyyy");
                 String dt=s.format(date);
                 String item=rb12.getText();
                 String select="SELECT date, item, quntity,rupees\n" +
"	FROM public.\"ItemSell\" WHERE date=? AND item=?";
                 
               
                 
                 String insert="INSERT INTO public.\"ItemSell\"(\n" +
"	date, item, quntity, rupees)\n" +
"	VALUES (?, ?, ?, ?);";
                  pst=conn.prepareStatement(select);
                 pst.setString(1,dt);
                 pst.setString(2,item);
                 rs=pst.executeQuery();
                 if(rs.next())
                 {    String qt=rs.getString(3);
                     String st=rs.getString(4);
                    
                   int aa=Integer.valueOf(qt);
                   int bb=Integer.valueOf(t12.getText());
                   int cc=aa+bb;
                    double ff,ee=0.0;
                   String dd=rs.getString(4);
                    ee=Double.valueOf(dd);
                    ff=Double.valueOf(t72.getText());
                    double gg=ee+ff;
                  
                     pst=conn.prepareStatement("UPDATE public.\"ItemSell\"\n" +
"	SET  quntity='"+cc+"'  , rupees='"+gg+"'  \n" +
"	WHERE  item='"+rb12.getText().toString()+"' AND date='"+dt+"'  ;");
                        pst.execute();
                         JOptionPane.showMessageDialog(null, "updated");
                          }else{                    
                        JOptionPane.showMessageDialog(null, "failed");
                         pst=conn.prepareStatement(insert);
                         pst.setString(1,dt);
                         pst.setString(2,item);
                         pst.setInt(3,Integer.parseInt(t12.getText()));
                         pst.setDouble(4,Double.parseDouble(t72.getText()));
                         pst.execute();
                          JOptionPane.showMessageDialog(null, "new Added");
                    }
            }catch(Exception e){ JOptionPane.showMessageDialog(null, e);
            }
   }
   
   void rb13(){
         try{
             Date  date= new Date();
               SimpleDateFormat s= new SimpleDateFormat("dd-MM-yyyy");
                 String dt=s.format(date);
                 String item=rb13.getText();
                 String select="SELECT date, item, quntity,rupees\n" +
"	FROM public.\"ItemSell\" WHERE date=? AND item=?";
                 
               
                 
                 String insert="INSERT INTO public.\"ItemSell\"(\n" +
"	date, item, quntity, rupees)\n" +
"	VALUES (?, ?, ?, ?);";
                  pst=conn.prepareStatement(select);
                 pst.setString(1,dt);
                 pst.setString(2,item);
                 rs=pst.executeQuery();
                 if(rs.next())
                 {    String qt=rs.getString(3);
                     String st=rs.getString(4);
                    
                   int aa=Integer.valueOf(qt);
                   int bb=Integer.valueOf(t11.getText());
                   int cc=aa+bb;
                    double ff,ee=0.0;
                   String dd=rs.getString(4);
                    ee=Double.valueOf(dd);
                    ff=Double.valueOf(t73.getText());
                    double gg=ee+ff;
                  
                     pst=conn.prepareStatement("UPDATE public.\"ItemSell\"\n" +
"	SET  quntity='"+cc+"'  , rupees='"+gg+"'  \n" +
"	WHERE  item='"+rb13.getText().toString()+"' AND date='"+dt+"'  ;");
                        pst.execute();
                         JOptionPane.showMessageDialog(null, "updated");
                          }else{                    
                        JOptionPane.showMessageDialog(null, "failed");
                         pst=conn.prepareStatement(insert);
                         pst.setString(1,dt);
                         pst.setString(2,item);
                         pst.setInt(3,Integer.parseInt(t11.getText()));
                         pst.setDouble(4,Double.parseDouble(t73.getText()));
                         pst.execute();
                          JOptionPane.showMessageDialog(null, "new Added");
                    }
            }catch(Exception e){ JOptionPane.showMessageDialog(null, e);
            }
   }
   void rb14(){
    try{
             Date  date= new Date();
               SimpleDateFormat s= new SimpleDateFormat("dd-MM-yyyy");
                 String dt=s.format(date);
                 String item=rb14.getText();
                 String select="SELECT date, item, quntity,rupees\n" +
"	FROM public.\"ItemSell\" WHERE date=? AND item=?";
                 
               
                 
                 String insert="INSERT INTO public.\"ItemSell\"(\n" +
"	date, item, quntity, rupees)\n" +
"	VALUES (?, ?, ?, ?);";
                  pst=conn.prepareStatement(select);
                 pst.setString(1,dt);
                 pst.setString(2,item);
                 rs=pst.executeQuery();
                 if(rs.next())
                 {    String qt=rs.getString(3);
                     String st=rs.getString(4);
                    
                   int aa=Integer.valueOf(qt);
                   int bb=Integer.valueOf(t21.getText());
                   int cc=aa+bb;
                    double ff,ee=0.0;
                   String dd=rs.getString(4);
                    ee=Double.valueOf(dd);
                    ff=Double.valueOf(t74.getText());
                    double gg=ee+ff;
                  
                     pst=conn.prepareStatement("UPDATE public.\"ItemSell\"\n" +
"	SET  quntity='"+cc+"'  , rupees='"+gg+"'  \n" +
"	WHERE  item='"+rb14.getText().toString()+"' AND date='"+dt+"'  ;");
                        pst.execute();
                         JOptionPane.showMessageDialog(null, "updated");
                          }else{                    
                        JOptionPane.showMessageDialog(null, "failed");
                         pst=conn.prepareStatement(insert);
                         pst.setString(1,dt);
                         pst.setString(2,item);
                         pst.setInt(3,Integer.parseInt(t21.getText()));
                         pst.setDouble(4,Double.parseDouble(t74.getText()));
                         pst.execute();
                          JOptionPane.showMessageDialog(null, "new Added");
                    }
            }catch(Exception e){ JOptionPane.showMessageDialog(null, e);
            }
   }
   void rb15(){
       try{
             Date  date= new Date();
               SimpleDateFormat s= new SimpleDateFormat("dd-MM-yyyy");
                 String dt=s.format(date);
                 String item=rb15.getText();
                 String select="SELECT date, item, quntity,rupees\n" +
"	FROM public.\"ItemSell\" WHERE date=? AND item=?";
                 
               
                 
                 String insert="INSERT INTO public.\"ItemSell\"(\n" +
"	date, item, quntity, rupees)\n" +
"	VALUES (?, ?, ?, ?);";
                  pst=conn.prepareStatement(select);
                 pst.setString(1,dt);
                 pst.setString(2,item);
                 rs=pst.executeQuery();
                 if(rs.next())
                 {    String qt=rs.getString(3);
                     String st=rs.getString(4);
                    
                   int aa=Integer.valueOf(qt);
                   int bb=Integer.valueOf(t22.getText());
                   int cc=aa+bb;
                    double ff,ee=0.0;
                   String dd=rs.getString(4);
                    ee=Double.valueOf(dd);
                    ff=Double.valueOf(t75.getText());
                    double gg=ee+ff;
                  
                     pst=conn.prepareStatement("UPDATE public.\"ItemSell\"\n" +
"	SET  quntity='"+cc+"'  , rupees='"+gg+"'  \n" +
"	WHERE  item='"+rb15.getText().toString()+"' AND date='"+dt+"'  ;");
                        pst.execute();
                         JOptionPane.showMessageDialog(null, "updated");
                          }else{                    
                        JOptionPane.showMessageDialog(null, "failed");
                         pst=conn.prepareStatement(insert);
                         pst.setString(1,dt);
                         pst.setString(2,item);
                         pst.setInt(3,Integer.parseInt(t22.getText()));
                         pst.setDouble(4,Double.parseDouble(t75.getText()));
                         pst.execute();
                          JOptionPane.showMessageDialog(null, "new Added");
                    }
            }catch(Exception e){ JOptionPane.showMessageDialog(null, e);
            }
   }
   void rb41(){
        try{
             Date  date= new Date();
               SimpleDateFormat s= new SimpleDateFormat("dd-MM-yyyy");
                 String dt=s.format(date);
                 String item=rb41.getText();
                 String select="SELECT date, item, quntity,rupees\n" +
"	FROM public.\"ItemSell\" WHERE date=? AND item=?";
                 
               
                 
                 String insert="INSERT INTO public.\"ItemSell\"(\n" +
"	date, item, quntity, rupees)\n" +
"	VALUES (?, ?, ?, ?);";
                  pst=conn.prepareStatement(select);
                 pst.setString(1,dt);
                 pst.setString(2,item);
                 rs=pst.executeQuery();
                 if(rs.next())
                 {    String qt=rs.getString(3);
                     String st=rs.getString(4);
                    
                   int aa=Integer.valueOf(qt);
                   int bb=Integer.valueOf(t2.getText());
                   int cc=aa+bb;
                    double ff,ee=0.0;
                   String dd=rs.getString(4);
                    ee=Double.valueOf(dd);
                    ff=Double.valueOf(t59.getText());
                    double gg=ee+ff;
                  
                     pst=conn.prepareStatement("UPDATE public.\"ItemSell\"\n" +
"	SET  quntity='"+cc+"'  , rupees='"+gg+"'  \n" +
"	WHERE  item='"+rb41.getText().toString()+"' AND date='"+dt+"'  ;");
                        pst.execute();
                         JOptionPane.showMessageDialog(null, "updated");
                          }else{                    
                        JOptionPane.showMessageDialog(null, "failed");
                         pst=conn.prepareStatement(insert);
                         pst.setString(1,dt);
                         pst.setString(2,item);
                         pst.setInt(3,Integer.parseInt(t2.getText()));
                         pst.setDouble(4,Double.parseDouble(t59.getText()));
                         pst.execute();
                          JOptionPane.showMessageDialog(null, "new Added");
                    }
            }catch(Exception e){ JOptionPane.showMessageDialog(null, e);
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


t114.setText("0");    t116.setText("");
t115.setText("");    t117.setText("0");


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
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jPanel27 = new javax.swing.JPanel();
        l0 = new javax.swing.JLabel();
        ldt = new javax.swing.JLabel();
        l2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        dp1 = new javax.swing.JDesktopPane();
        jLabel2 = new javax.swing.JLabel();
        tbp1 = new javax.swing.JTabbedPane();
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
        t114 = new javax.swing.JTextField();
        cb2 = new javax.swing.JComboBox<>();
        t115 = new javax.swing.JTextField();
        okb = new javax.swing.JButton();
        t161 = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
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
        jPanel4 = new javax.swing.JPanel();
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
        jPanel6 = new javax.swing.JPanel();
        t41 = new javax.swing.JTextField();
        t42 = new javax.swing.JTextField();
        t43 = new javax.swing.JTextField();
        t44 = new javax.swing.JTextField();
        t45 = new javax.swing.JTextField();
        t46 = new javax.swing.JTextField();
        t60 = new javax.swing.JTextField();
        t58 = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        t57 = new javax.swing.JTextField();
        t59 = new javax.swing.JTextField();
        t61 = new javax.swing.JTextField();
        t62 = new javax.swing.JTextField();
        t63 = new javax.swing.JTextField();
        t64 = new javax.swing.JTextField();
        t65 = new javax.swing.JTextField();
        t66 = new javax.swing.JTextField();
        cb3 = new javax.swing.JComboBox<>();
        t116 = new javax.swing.JTextField();
        t117 = new javax.swing.JTextField();
        t157 = new javax.swing.JTextField();
        okb1 = new javax.swing.JButton();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        cb4 = new javax.swing.JComboBox<>();
        t158 = new javax.swing.JTextField();
        t159 = new javax.swing.JTextField();
        t160 = new javax.swing.JTextField();
        okb2 = new javax.swing.JButton();
        b4 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tt1 = new javax.swing.JTextArea();
        jButton6 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        cnt1 = new javax.swing.JTextField();
        l7 = new javax.swing.JLabel();
        t111 = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        t204 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        t205 = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1358, 736));
        setPreferredSize(new java.awt.Dimension(1358, 736));
        getContentPane().setLayout(null);

        jPanel27.setBackground(new java.awt.Color(153, 102, 255));
        jPanel27.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        jPanel27.setLayout(null);

        l0.setFont(new java.awt.Font("Copperplate Gothic Bold", 1, 36)); // NOI18N
        l0.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        l0.setText("Hotel Name");
        jPanel27.add(l0);
        l0.setBounds(310, 0, 660, 70);

        ldt.setBackground(new java.awt.Color(255, 204, 204));
        ldt.setFont(new java.awt.Font("Copperplate Gothic Bold", 1, 18)); // NOI18N
        ldt.setForeground(new java.awt.Color(255, 255, 255));
        ldt.setText("date");
        jPanel27.add(ldt);
        ldt.setBounds(1180, 10, 130, 40);

        l2.setBackground(new java.awt.Color(255, 204, 204));
        l2.setFont(new java.awt.Font("Copperplate Gothic Bold", 1, 28)); // NOI18N
        l2.setForeground(new java.awt.Color(255, 255, 255));
        l2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        l2.setText("time");
        jPanel27.add(l2);
        l2.setBounds(880, 10, 280, 40);

        getContentPane().add(jPanel27);
        jPanel27.setBounds(0, 0, 1510, 70);

        jPanel1.setBackground(new java.awt.Color(153, 153, 255));
        jPanel1.setMinimumSize(new java.awt.Dimension(1400, 800));
        jPanel1.setPreferredSize(new java.awt.Dimension(1400, 800));
        jPanel1.setLayout(null);

        dp1.setBackground(new java.awt.Color(153, 153, 255));
        dp1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        dp1.setDesktopManager(null);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("+Cus");
        jLabel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(0, 0, 0), null, new java.awt.Color(0, 153, 153)));
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        dp1.add(jLabel2);
        jLabel2.setBounds(50, 0, 50, 20);

        tbp1.setBackground(new java.awt.Color(204, 255, 255));
        tbp1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tbp1.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);
        tbp1.setTabPlacement(javax.swing.JTabbedPane.LEFT);
        tbp1.setAutoscrolls(true);
        tbp1.setFocusable(false);
        tbp1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N

        jPanel14.setBackground(new java.awt.Color(204, 204, 255));
        jPanel14.setLayout(null);

        jPanel15.setBackground(new java.awt.Color(204, 204, 255));
        jPanel15.setLayout(null);

        rb32.setBackground(new java.awt.Color(204, 204, 255));
        rb32.setText("chips");
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

        t33.setBackground(new java.awt.Color(204, 255, 255));
        t33.setFont(new java.awt.Font("SimSun", 1, 16)); // NOI18N
        t33.setForeground(new java.awt.Color(0, 0, 204));
        t33.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        t33.setText("Quntity");
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

        rb43.setBackground(new java.awt.Color(204, 204, 255));
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

        t34.setBackground(new java.awt.Color(204, 255, 255));
        t34.setFont(new java.awt.Font("SimSun", 1, 16)); // NOI18N
        t34.setForeground(new java.awt.Color(0, 0, 204));
        t34.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        t34.setText("Quntity");
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
            public void keyTyped(java.awt.event.KeyEvent evt) {
                t34KeyTyped(evt);
            }
        });
        jPanel15.add(t34);
        t34.setBounds(120, 50, 114, 35);

        rb33.setBackground(new java.awt.Color(204, 204, 255));
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

        t35.setBackground(new java.awt.Color(204, 255, 255));
        t35.setFont(new java.awt.Font("SimSun", 1, 16)); // NOI18N
        t35.setForeground(new java.awt.Color(0, 0, 204));
        t35.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        t35.setText("Quntity");
        t35.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                t35KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                t35KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                t35KeyTyped(evt);
            }
        });
        jPanel15.add(t35);
        t35.setBounds(120, 90, 114, 35);

        rb34.setBackground(new java.awt.Color(204, 204, 255));
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

        t36.setBackground(new java.awt.Color(204, 255, 255));
        t36.setFont(new java.awt.Font("SimSun", 1, 16)); // NOI18N
        t36.setForeground(new java.awt.Color(0, 0, 204));
        t36.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        t36.setText("Quntity");
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
            public void keyTyped(java.awt.event.KeyEvent evt) {
                t36KeyTyped(evt);
            }
        });
        jPanel15.add(t36);
        t36.setBounds(120, 130, 114, 35);

        rb35.setBackground(new java.awt.Color(204, 204, 255));
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

        t37.setBackground(new java.awt.Color(204, 255, 255));
        t37.setFont(new java.awt.Font("SimSun", 1, 16)); // NOI18N
        t37.setForeground(new java.awt.Color(0, 0, 204));
        t37.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        t37.setText("Quntity");
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
            public void keyTyped(java.awt.event.KeyEvent evt) {
                t37KeyTyped(evt);
            }
        });
        jPanel15.add(t37);
        t37.setBounds(120, 170, 114, 35);

        rb36.setBackground(new java.awt.Color(204, 204, 255));
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

        t38.setBackground(new java.awt.Color(204, 255, 255));
        t38.setFont(new java.awt.Font("SimSun", 1, 16)); // NOI18N
        t38.setForeground(new java.awt.Color(0, 0, 204));
        t38.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        t38.setText("Quntity");
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
            public void keyTyped(java.awt.event.KeyEvent evt) {
                t38KeyTyped(evt);
            }
        });
        jPanel15.add(t38);
        t38.setBounds(120, 210, 114, 35);

        rb37.setBackground(new java.awt.Color(204, 204, 255));
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

        t39.setBackground(new java.awt.Color(204, 255, 255));
        t39.setFont(new java.awt.Font("SimSun", 1, 16)); // NOI18N
        t39.setForeground(new java.awt.Color(0, 0, 204));
        t39.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        t39.setText("Quntity");
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
            public void keyTyped(java.awt.event.KeyEvent evt) {
                t39KeyTyped(evt);
            }
        });
        jPanel15.add(t39);
        t39.setBounds(120, 250, 114, 35);

        rb38.setBackground(new java.awt.Color(204, 204, 255));
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

        t40.setBackground(new java.awt.Color(204, 255, 255));
        t40.setFont(new java.awt.Font("SimSun", 1, 16)); // NOI18N
        t40.setForeground(new java.awt.Color(0, 0, 204));
        t40.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        t40.setText("Quntity");
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
            public void keyTyped(java.awt.event.KeyEvent evt) {
                t40KeyTyped(evt);
            }
        });
        jPanel15.add(t40);
        t40.setBounds(124, 290, 110, 35);

        jPanel16.setBackground(new java.awt.Color(204, 204, 255));
        jPanel16.setLayout(new java.awt.GridLayout(8, 1, 0, 5));

        t67.setFont(new java.awt.Font("SimSun", 0, 18)); // NOI18N
        t67.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t67ActionPerformed(evt);
            }
        });
        t67.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                t67KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                t67KeyTyped(evt);
            }
        });
        jPanel16.add(t67);

        t112.setFont(new java.awt.Font("SimSun", 0, 18)); // NOI18N
        t112.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t112ActionPerformed(evt);
            }
        });
        t112.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                t112KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                t112KeyTyped(evt);
            }
        });
        jPanel16.add(t112);

        t118.setFont(new java.awt.Font("SimSun", 0, 18)); // NOI18N
        t118.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t118ActionPerformed(evt);
            }
        });
        t118.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                t118KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                t118KeyTyped(evt);
            }
        });
        jPanel16.add(t118);

        t119.setFont(new java.awt.Font("SimSun", 0, 18)); // NOI18N
        t119.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t119ActionPerformed(evt);
            }
        });
        t119.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                t119KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                t119KeyTyped(evt);
            }
        });
        jPanel16.add(t119);

        t120.setFont(new java.awt.Font("SimSun", 0, 18)); // NOI18N
        t120.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t120ActionPerformed(evt);
            }
        });
        t120.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                t120KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                t120KeyTyped(evt);
            }
        });
        jPanel16.add(t120);

        t121.setFont(new java.awt.Font("SimSun", 0, 18)); // NOI18N
        t121.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t121ActionPerformed(evt);
            }
        });
        t121.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                t121KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                t121KeyTyped(evt);
            }
        });
        jPanel16.add(t121);

        t122.setFont(new java.awt.Font("SimSun", 0, 18)); // NOI18N
        t122.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t122ActionPerformed(evt);
            }
        });
        t122.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                t122KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                t122KeyTyped(evt);
            }
        });
        jPanel16.add(t122);

        t123.setFont(new java.awt.Font("SimSun", 0, 18)); // NOI18N
        t123.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t123ActionPerformed(evt);
            }
        });
        t123.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                t123KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                t123KeyTyped(evt);
            }
        });
        jPanel16.add(t123);

        jPanel15.add(jPanel16);
        jPanel16.setBounds(240, 10, 60, 320);

        jPanel17.setBackground(new java.awt.Color(204, 204, 255));
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

        jPanel18.setBackground(new java.awt.Color(204, 204, 255));
        jPanel18.setLayout(null);

        rb39.setBackground(new java.awt.Color(204, 204, 255));
        rb39.setText("रोटी");
        rb39.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb39ActionPerformed(evt);
            }
        });
        jPanel18.add(rb39);
        rb39.setBounds(10, 10, 110, 37);

        t132.setBackground(new java.awt.Color(204, 255, 255));
        t132.setFont(new java.awt.Font("SimSun", 1, 16)); // NOI18N
        t132.setForeground(new java.awt.Color(0, 0, 204));
        t132.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        t132.setText("Quntity");
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
            public void keyTyped(java.awt.event.KeyEvent evt) {
                t132KeyTyped(evt);
            }
        });
        jPanel18.add(t132);
        t132.setBounds(130, 10, 110, 37);

        rb40.setBackground(new java.awt.Color(204, 204, 255));
        rb40.setText("बटर रोटी");
        rb40.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb40ActionPerformed(evt);
            }
        });
        jPanel18.add(rb40);
        rb40.setBounds(10, 50, 110, 37);

        t133.setBackground(new java.awt.Color(204, 255, 255));
        t133.setFont(new java.awt.Font("SimSun", 1, 16)); // NOI18N
        t133.setForeground(new java.awt.Color(0, 0, 204));
        t133.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        t133.setText("Quntity");
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
            public void keyTyped(java.awt.event.KeyEvent evt) {
                t133KeyTyped(evt);
            }
        });
        jPanel18.add(t133);
        t133.setBounds(130, 50, 110, 37);

        rb44.setBackground(new java.awt.Color(204, 204, 255));
        rb44.setText("साधा राईस  फूल");
        rb44.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb44ActionPerformed(evt);
            }
        });
        jPanel18.add(rb44);
        rb44.setBounds(10, 90, 110, 37);

        t134.setBackground(new java.awt.Color(204, 255, 255));
        t134.setFont(new java.awt.Font("SimSun", 1, 16)); // NOI18N
        t134.setForeground(new java.awt.Color(0, 0, 204));
        t134.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        t134.setText("Quntity");
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

        rb45.setBackground(new java.awt.Color(204, 204, 255));
        rb45.setText("साधा राईस हाफ ");
        rb45.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb45ActionPerformed(evt);
            }
        });
        jPanel18.add(rb45);
        rb45.setBounds(10, 130, 110, 37);

        t135.setBackground(new java.awt.Color(204, 255, 255));
        t135.setFont(new java.awt.Font("SimSun", 1, 16)); // NOI18N
        t135.setForeground(new java.awt.Color(0, 0, 204));
        t135.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        t135.setText("Quntity");
        t135.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                t135KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                t135KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                t135KeyTyped(evt);
            }
        });
        jPanel18.add(t135);
        t135.setBounds(130, 130, 110, 37);

        rb46.setBackground(new java.awt.Color(204, 204, 255));
        rb46.setText("जिरा राईस  फूल");
        rb46.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb46ActionPerformed(evt);
            }
        });
        jPanel18.add(rb46);
        rb46.setBounds(10, 170, 110, 37);

        t136.setBackground(new java.awt.Color(204, 255, 255));
        t136.setFont(new java.awt.Font("SimSun", 1, 16)); // NOI18N
        t136.setForeground(new java.awt.Color(0, 0, 204));
        t136.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        t136.setText("Quntity");
        t136.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t136ActionPerformed(evt);
            }
        });
        t136.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                t136KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                t136KeyTyped(evt);
            }
        });
        jPanel18.add(t136);
        t136.setBounds(130, 170, 110, 37);

        rb47.setBackground(new java.awt.Color(204, 204, 255));
        rb47.setText("जिरा राईस हाफ");
        rb47.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb47ActionPerformed(evt);
            }
        });
        jPanel18.add(rb47);
        rb47.setBounds(10, 210, 110, 37);

        t137.setBackground(new java.awt.Color(204, 255, 255));
        t137.setFont(new java.awt.Font("SimSun", 1, 16)); // NOI18N
        t137.setForeground(new java.awt.Color(0, 0, 204));
        t137.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        t137.setText("Quntity");
        t137.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                t137KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                t137KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                t137KeyTyped(evt);
            }
        });
        jPanel18.add(t137);
        t137.setBounds(130, 210, 110, 37);

        rb48.setBackground(new java.awt.Color(204, 204, 255));
        rb48.setText("पाणी (Bisleri)");
        rb48.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb48ActionPerformed(evt);
            }
        });
        jPanel18.add(rb48);
        rb48.setBounds(10, 250, 110, 37);

        t138.setBackground(new java.awt.Color(204, 255, 255));
        t138.setFont(new java.awt.Font("SimSun", 1, 16)); // NOI18N
        t138.setForeground(new java.awt.Color(0, 0, 204));
        t138.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        t138.setText("Quntity");
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
            public void keyTyped(java.awt.event.KeyEvent evt) {
                t138KeyTyped(evt);
            }
        });
        jPanel18.add(t138);
        t138.setBounds(130, 250, 110, 37);

        rb49.setBackground(new java.awt.Color(204, 204, 255));
        rb49.setText("Coldrinks ");
        rb49.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb49ActionPerformed(evt);
            }
        });
        jPanel18.add(rb49);
        rb49.setBounds(10, 290, 110, 37);

        t139.setBackground(new java.awt.Color(204, 255, 255));
        t139.setFont(new java.awt.Font("SimSun", 1, 16)); // NOI18N
        t139.setForeground(new java.awt.Color(0, 0, 204));
        t139.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        t139.setText("Quntity");
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
            public void keyTyped(java.awt.event.KeyEvent evt) {
                t139KeyTyped(evt);
            }
        });
        jPanel18.add(t139);
        t139.setBounds(130, 290, 110, 37);

        jPanel19.setBackground(new java.awt.Color(204, 204, 255));
        jPanel19.setLayout(new java.awt.GridLayout(8, 1, 1, 5));

        t140.setFont(new java.awt.Font("SimSun", 0, 18)); // NOI18N
        t140.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                t140KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                t140KeyTyped(evt);
            }
        });
        jPanel19.add(t140);

        t141.setFont(new java.awt.Font("SimSun", 0, 18)); // NOI18N
        t141.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t141ActionPerformed(evt);
            }
        });
        t141.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                t141KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                t141KeyTyped(evt);
            }
        });
        jPanel19.add(t141);

        t142.setFont(new java.awt.Font("SimSun", 0, 18)); // NOI18N
        t142.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                t142KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                t142KeyTyped(evt);
            }
        });
        jPanel19.add(t142);

        t143.setFont(new java.awt.Font("SimSun", 0, 18)); // NOI18N
        t143.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                t143KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                t143KeyTyped(evt);
            }
        });
        jPanel19.add(t143);

        t144.setFont(new java.awt.Font("SimSun", 0, 18)); // NOI18N
        t144.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                t144KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                t144KeyTyped(evt);
            }
        });
        jPanel19.add(t144);

        t145.setFont(new java.awt.Font("SimSun", 0, 18)); // NOI18N
        t145.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                t145KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                t145KeyTyped(evt);
            }
        });
        jPanel19.add(t145);

        t146.setFont(new java.awt.Font("SimSun", 0, 18)); // NOI18N
        t146.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                t146KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                t146KeyTyped(evt);
            }
        });
        jPanel19.add(t146);

        t147.setFont(new java.awt.Font("SimSun", 0, 18)); // NOI18N
        t147.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t147ActionPerformed(evt);
            }
        });
        t147.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                t147KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                t147KeyTyped(evt);
            }
        });
        jPanel19.add(t147);

        jPanel18.add(jPanel19);
        jPanel19.setBounds(250, 10, 50, 320);

        jPanel20.setBackground(new java.awt.Color(204, 204, 255));
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

        t114.setBackground(new java.awt.Color(153, 255, 255));
        t114.setFont(new java.awt.Font("Copperplate Gothic Bold", 1, 14)); // NOI18N
        t114.setForeground(new java.awt.Color(153, 0, 153));
        t114.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        t114.setText("0");
        t114.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        t114.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t114ActionPerformed(evt);
            }
        });
        jPanel14.add(t114);
        t114.setBounds(270, 50, 60, 32);

        cb2.setBackground(new java.awt.Color(153, 255, 255));
        cb2.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 14)); // NOI18N
        cb2.setForeground(new java.awt.Color(153, 0, 153));
        cb2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Search" }));
        cb2.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cb2PopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
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
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cb2KeyReleased(evt);
            }
        });
        jPanel14.add(cb2);
        cb2.setBounds(10, 50, 180, 30);

        t115.setBackground(new java.awt.Color(204, 255, 255));
        t115.setFont(new java.awt.Font("SimSun", 1, 16)); // NOI18N
        t115.setForeground(new java.awt.Color(0, 0, 204));
        t115.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        t115.setText("0");
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
        t115.setBounds(200, 50, 60, 30);

        okb.setText("ok");
        okb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okbActionPerformed(evt);
            }
        });
        jPanel14.add(okb);
        okb.setBounds(410, 50, 50, 30);

        t161.setFont(new java.awt.Font("SimSun", 1, 14)); // NOI18N
        t161.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        t161.setText("0");
        t161.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        t161.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                t161FocusGained(evt);
            }
        });
        t161.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t161ActionPerformed(evt);
            }
        });
        jPanel14.add(t161);
        t161.setBounds(340, 50, 60, 30);

        tbp1.addTab("Veg", jPanel14);

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));
        jPanel2.setLayout(null);

        jPanel3.setBackground(new java.awt.Color(204, 204, 255));
        jPanel3.setLayout(null);

        rb8.setBackground(new java.awt.Color(204, 204, 255));
        rb8.setText("Roti           ");
        rb8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb8ActionPerformed(evt);
            }
        });
        jPanel3.add(rb8);
        rb8.setBounds(0, 17, 100, 40);

        t7.setBackground(new java.awt.Color(204, 255, 255));
        t7.setFont(new java.awt.Font("SimSun", 1, 16)); // NOI18N
        t7.setForeground(new java.awt.Color(51, 0, 255));
        t7.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        t7.setText("Quntity");
        t7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t7ActionPerformed(evt);
            }
        });
        t7.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                t7KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                t7KeyTyped(evt);
            }
        });
        jPanel3.add(t7);
        t7.setBounds(110, 20, 110, 40);

        rb9.setBackground(new java.awt.Color(204, 204, 255));
        rb9.setText("Butter Roti    ");
        rb9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb9ActionPerformed(evt);
            }
        });
        jPanel3.add(rb9);
        rb9.setBounds(0, 57, 100, 40);

        t8.setBackground(new java.awt.Color(204, 255, 255));
        t8.setFont(new java.awt.Font("SimSun", 1, 16)); // NOI18N
        t8.setForeground(new java.awt.Color(51, 0, 255));
        t8.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        t8.setText("Quntity");
        t8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t8ActionPerformed(evt);
            }
        });
        t8.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                t8KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                t8KeyTyped(evt);
            }
        });
        jPanel3.add(t8);
        t8.setBounds(110, 60, 110, 40);

        rb10.setBackground(new java.awt.Color(204, 204, 255));
        rb10.setText("Rise Full      ");
        rb10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb10ActionPerformed(evt);
            }
        });
        jPanel3.add(rb10);
        rb10.setBounds(0, 97, 100, 40);

        t10.setBackground(new java.awt.Color(204, 255, 255));
        t10.setFont(new java.awt.Font("SimSun", 1, 16)); // NOI18N
        t10.setForeground(new java.awt.Color(51, 0, 255));
        t10.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        t10.setText("Quntity");
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
        jPanel3.add(t10);
        t10.setBounds(110, 100, 110, 40);

        rb11.setBackground(new java.awt.Color(204, 204, 255));
        rb11.setText("Rise Half      ");
        rb11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb11ActionPerformed(evt);
            }
        });
        jPanel3.add(rb11);
        rb11.setBounds(0, 137, 100, 40);

        t20.setBackground(new java.awt.Color(204, 255, 255));
        t20.setFont(new java.awt.Font("SimSun", 1, 16)); // NOI18N
        t20.setForeground(new java.awt.Color(51, 0, 255));
        t20.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        t20.setText("Quntity");
        t20.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                t20KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                t20KeyTyped(evt);
            }
        });
        jPanel3.add(t20);
        t20.setBounds(110, 140, 110, 40);

        rb12.setBackground(new java.awt.Color(204, 204, 255));
        rb12.setText("menu1");
        rb12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb12ActionPerformed(evt);
            }
        });
        jPanel3.add(rb12);
        rb12.setBounds(0, 177, 100, 40);

        t12.setBackground(new java.awt.Color(204, 255, 255));
        t12.setFont(new java.awt.Font("SimSun", 1, 16)); // NOI18N
        t12.setForeground(new java.awt.Color(51, 0, 255));
        t12.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        t12.setText("Quntity");
        t12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t12ActionPerformed(evt);
            }
        });
        t12.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                t12KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                t12KeyTyped(evt);
            }
        });
        jPanel3.add(t12);
        t12.setBounds(110, 180, 110, 40);

        rb13.setBackground(new java.awt.Color(204, 204, 255));
        rb13.setText("menu");
        rb13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb13ActionPerformed(evt);
            }
        });
        jPanel3.add(rb13);
        rb13.setBounds(0, 220, 100, 40);

        t11.setBackground(new java.awt.Color(204, 255, 255));
        t11.setFont(new java.awt.Font("SimSun", 1, 16)); // NOI18N
        t11.setForeground(new java.awt.Color(51, 0, 255));
        t11.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        t11.setText("Quntity");
        t11.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                t11KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                t11KeyTyped(evt);
            }
        });
        jPanel3.add(t11);
        t11.setBounds(110, 220, 110, 40);

        rb14.setBackground(new java.awt.Color(204, 204, 255));
        rb14.setText("menu");
        rb14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb14ActionPerformed(evt);
            }
        });
        jPanel3.add(rb14);
        rb14.setBounds(0, 260, 100, 40);

        t21.setBackground(new java.awt.Color(204, 255, 255));
        t21.setFont(new java.awt.Font("SimSun", 1, 16)); // NOI18N
        t21.setForeground(new java.awt.Color(51, 0, 255));
        t21.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        t21.setText("Quntity");
        t21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t21ActionPerformed(evt);
            }
        });
        t21.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                t21KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                t21KeyTyped(evt);
            }
        });
        jPanel3.add(t21);
        t21.setBounds(110, 260, 110, 40);

        rb15.setBackground(new java.awt.Color(204, 204, 255));
        rb15.setText("Coldrinks ");
        rb15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb15ActionPerformed(evt);
            }
        });
        jPanel3.add(rb15);
        rb15.setBounds(0, 300, 100, 40);

        t22.setBackground(new java.awt.Color(204, 255, 255));
        t22.setFont(new java.awt.Font("SimSun", 1, 16)); // NOI18N
        t22.setForeground(new java.awt.Color(51, 0, 255));
        t22.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        t22.setText("Quntity");
        t22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t22ActionPerformed(evt);
            }
        });
        t22.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                t22KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                t22KeyTyped(evt);
            }
        });
        jPanel3.add(t22);
        t22.setBounds(110, 300, 110, 40);

        jPanel4.setBackground(new java.awt.Color(204, 204, 255));
        jPanel4.setLayout(null);

        t47.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t47ActionPerformed(evt);
            }
        });
        t47.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                t47KeyTyped(evt);
            }
        });
        jPanel4.add(t47);
        t47.setBounds(0, 20, 50, 40);

        t48.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t48ActionPerformed(evt);
            }
        });
        t48.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                t48KeyTyped(evt);
            }
        });
        jPanel4.add(t48);
        t48.setBounds(0, 60, 50, 40);

        t49.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                t49KeyTyped(evt);
            }
        });
        jPanel4.add(t49);
        t49.setBounds(0, 100, 50, 40);

        t50.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                t50KeyTyped(evt);
            }
        });
        jPanel4.add(t50);
        t50.setBounds(0, 140, 50, 40);

        t51.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                t51KeyTyped(evt);
            }
        });
        jPanel4.add(t51);
        t51.setBounds(0, 180, 50, 40);

        t52.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                t52KeyTyped(evt);
            }
        });
        jPanel4.add(t52);
        t52.setBounds(0, 220, 50, 40);

        t53.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                t53KeyTyped(evt);
            }
        });
        jPanel4.add(t53);
        t53.setBounds(0, 260, 50, 40);

        t54.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t54ActionPerformed(evt);
            }
        });
        t54.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                t54KeyTyped(evt);
            }
        });
        jPanel4.add(t54);
        t54.setBounds(0, 300, 50, 40);

        jPanel3.add(jPanel4);
        jPanel4.setBounds(230, 0, 50, 340);

        jPanel5.setBackground(new java.awt.Color(204, 204, 255));
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

        jPanel3.add(jPanel5);
        jPanel5.setBounds(300, 10, 90, 330);

        jPanel2.add(jPanel3);
        jPanel3.setBounds(390, 80, 450, 350);

        jPanel13.setBackground(new java.awt.Color(204, 204, 255));
        jPanel13.setLayout(null);

        rb16.setBackground(new java.awt.Color(204, 204, 255));
        rb16.setText("menu");
        rb16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rb16rb1MouseClicked(evt);
            }
        });
        rb16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb16ActionPerformed(evt);
            }
        });
        jPanel13.add(rb16);
        rb16.setBounds(10, 290, 100, 30);

        rb6.setBackground(new java.awt.Color(204, 204, 255));
        rb6.setText("menu");
        rb6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rb6rb1MouseClicked(evt);
            }
        });
        rb6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb6ActionPerformed(evt);
            }
        });
        jPanel13.add(rb6);
        rb6.setBounds(10, 250, 100, 30);

        rb7.setBackground(new java.awt.Color(204, 204, 255));
        rb7.setText("menu");
        rb7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rb7rb1MouseClicked(evt);
            }
        });
        rb7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb7ActionPerformed(evt);
            }
        });
        jPanel13.add(rb7);
        rb7.setBounds(10, 210, 100, 30);

        rb5.setBackground(new java.awt.Color(204, 204, 255));
        rb5.setText("menu");
        rb5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rb5rb1MouseClicked(evt);
            }
        });
        rb5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb5ActionPerformed(evt);
            }
        });
        jPanel13.add(rb5);
        rb5.setBounds(10, 170, 100, 30);

        rb3.setBackground(new java.awt.Color(204, 204, 255));
        rb3.setText("menu");
        rb3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rb3rb1MouseClicked(evt);
            }
        });
        rb3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb3ActionPerformed(evt);
            }
        });
        jPanel13.add(rb3);
        rb3.setBounds(10, 130, 100, 30);

        rb2.setBackground(new java.awt.Color(204, 204, 255));
        rb2.setText("Matan Thali    ");
        rb2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rb2rb1MouseClicked(evt);
            }
        });
        rb2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb2ActionPerformed(evt);
            }
        });
        jPanel13.add(rb2);
        rb2.setBounds(10, 90, 100, 30);

        rb41.setBackground(new java.awt.Color(204, 204, 255));
        rb41.setText("Spl CkThali                   ");
        rb41.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rb41rb1MouseClicked(evt);
            }
        });
        rb41.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb41ActionPerformed(evt);
            }
        });
        jPanel13.add(rb41);
        rb41.setBounds(10, 50, 100, 30);

        rb1.setBackground(new java.awt.Color(204, 204, 255));
        rb1.setText("Chikan Thali   ");
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
        rb1.setBounds(10, 10, 100, 30);

        t1.setBackground(new java.awt.Color(204, 255, 255));
        t1.setFont(new java.awt.Font("SimSun", 1, 16)); // NOI18N
        t1.setForeground(new java.awt.Color(51, 0, 255));
        t1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        t1.setText("Quntity");
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

        t2.setBackground(new java.awt.Color(204, 255, 255));
        t2.setFont(new java.awt.Font("SimSun", 1, 16)); // NOI18N
        t2.setForeground(new java.awt.Color(51, 0, 255));
        t2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        t2.setText("Quntity");
        t2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t2ActionPerformed(evt);
            }
        });
        t2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                t2KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                t2KeyTyped(evt);
            }
        });
        jPanel13.add(t2);
        t2.setBounds(120, 50, 114, 40);

        t3.setBackground(new java.awt.Color(204, 255, 255));
        t3.setFont(new java.awt.Font("SimSun", 1, 16)); // NOI18N
        t3.setForeground(new java.awt.Color(51, 0, 255));
        t3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        t3.setText("Quntity");
        t3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                t3KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                t3KeyTyped(evt);
            }
        });
        jPanel13.add(t3);
        t3.setBounds(120, 90, 114, 40);

        t4.setBackground(new java.awt.Color(204, 255, 255));
        t4.setFont(new java.awt.Font("SimSun", 1, 16)); // NOI18N
        t4.setForeground(new java.awt.Color(51, 0, 255));
        t4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        t4.setText("Quntity");
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
            public void keyTyped(java.awt.event.KeyEvent evt) {
                t4KeyTyped(evt);
            }
        });
        jPanel13.add(t4);
        t4.setBounds(120, 130, 114, 40);

        t5.setBackground(new java.awt.Color(204, 255, 255));
        t5.setFont(new java.awt.Font("SimSun", 1, 16)); // NOI18N
        t5.setForeground(new java.awt.Color(51, 0, 255));
        t5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        t5.setText("Quntity");
        t5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t5ActionPerformed(evt);
            }
        });
        t5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                t5KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                t5KeyTyped(evt);
            }
        });
        jPanel13.add(t5);
        t5.setBounds(120, 170, 114, 40);

        t6.setBackground(new java.awt.Color(204, 255, 255));
        t6.setFont(new java.awt.Font("SimSun", 1, 16)); // NOI18N
        t6.setForeground(new java.awt.Color(51, 0, 255));
        t6.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        t6.setText("Quntity");
        t6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t6ActionPerformed(evt);
            }
        });
        t6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                t6KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                t6KeyTyped(evt);
            }
        });
        jPanel13.add(t6);
        t6.setBounds(120, 210, 114, 40);

        t9.setBackground(new java.awt.Color(204, 255, 255));
        t9.setFont(new java.awt.Font("SimSun", 1, 16)); // NOI18N
        t9.setForeground(new java.awt.Color(51, 0, 255));
        t9.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        t9.setText("Quntity");
        t9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t9ActionPerformed(evt);
            }
        });
        t9.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                t9KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                t9KeyTyped(evt);
            }
        });
        jPanel13.add(t9);
        t9.setBounds(120, 250, 114, 40);

        t13.setBackground(new java.awt.Color(204, 255, 255));
        t13.setFont(new java.awt.Font("SimSun", 1, 16)); // NOI18N
        t13.setForeground(new java.awt.Color(51, 0, 255));
        t13.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        t13.setText("Quntity");
        t13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t13ActionPerformed(evt);
            }
        });
        t13.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                t13KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                t13KeyTyped(evt);
            }
        });
        jPanel13.add(t13);
        t13.setBounds(120, 290, 114, 40);

        jPanel6.setBackground(new java.awt.Color(204, 204, 255));
        jPanel6.setLayout(null);

        t41.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t41ActionPerformed(evt);
            }
        });
        t41.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                t41KeyTyped(evt);
            }
        });
        jPanel6.add(t41);
        t41.setBounds(0, 11, 50, 40);

        t42.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t42ActionPerformed(evt);
            }
        });
        t42.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                t42KeyTyped(evt);
            }
        });
        jPanel6.add(t42);
        t42.setBounds(0, 50, 50, 40);

        t43.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t43ActionPerformed(evt);
            }
        });
        t43.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                t43KeyTyped(evt);
            }
        });
        jPanel6.add(t43);
        t43.setBounds(0, 89, 50, 40);

        t44.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t44ActionPerformed(evt);
            }
        });
        t44.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                t44KeyTyped(evt);
            }
        });
        jPanel6.add(t44);
        t44.setBounds(0, 130, 50, 40);

        t45.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t45ActionPerformed(evt);
            }
        });
        t45.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                t45KeyTyped(evt);
            }
        });
        jPanel6.add(t45);
        t45.setBounds(0, 170, 50, 40);

        t46.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t46ActionPerformed(evt);
            }
        });
        t46.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                t46KeyTyped(evt);
            }
        });
        jPanel6.add(t46);
        t46.setBounds(0, 210, 50, 40);

        t60.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t60ActionPerformed(evt);
            }
        });
        t60.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                t60KeyTyped(evt);
            }
        });
        jPanel6.add(t60);
        t60.setBounds(0, 250, 50, 40);

        t58.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t58ActionPerformed(evt);
            }
        });
        t58.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                t58KeyTyped(evt);
            }
        });
        jPanel6.add(t58);
        t58.setBounds(0, 290, 50, 40);

        jPanel13.add(jPanel6);
        jPanel6.setBounds(240, 0, 50, 340);

        jPanel7.setBackground(new java.awt.Color(204, 204, 255));
        jPanel7.setLayout(null);

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
        jPanel7.add(t57);
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
        jPanel7.add(t59);
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
        jPanel7.add(t61);
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
        jPanel7.add(t62);
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
        jPanel7.add(t63);
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
        jPanel7.add(t64);
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
        jPanel7.add(t65);
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
        jPanel7.add(t66);
        t66.setBounds(0, 280, 60, 40);

        jPanel13.add(jPanel7);
        jPanel7.setBounds(300, 10, 60, 330);

        jPanel2.add(jPanel13);
        jPanel13.setBounds(10, 90, 390, 340);

        cb3.setBackground(new java.awt.Color(153, 255, 255));
        cb3.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 14)); // NOI18N
        cb3.setForeground(new java.awt.Color(153, 0, 153));
        cb3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Search" }));
        cb3.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cb3PopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
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
        jPanel2.add(cb3);
        cb3.setBounds(10, 50, 160, 30);

        t116.setBackground(new java.awt.Color(204, 255, 255));
        t116.setFont(new java.awt.Font("SimSun", 1, 16)); // NOI18N
        t116.setForeground(new java.awt.Color(51, 0, 255));
        t116.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        t116.setText("0");
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
        jPanel2.add(t116);
        t116.setBounds(184, 50, 60, 30);

        t117.setBackground(new java.awt.Color(153, 255, 255));
        t117.setFont(new java.awt.Font("Copperplate Gothic Bold", 1, 14)); // NOI18N
        t117.setForeground(new java.awt.Color(153, 0, 153));
        t117.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        t117.setText("0");
        t117.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        t117.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t117ActionPerformed(evt);
            }
        });
        jPanel2.add(t117);
        t117.setBounds(250, 50, 50, 32);

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
        jPanel2.add(t157);
        t157.setBounds(310, 50, 60, 30);

        okb1.setText("ok");
        okb1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okb1ActionPerformed(evt);
            }
        });
        jPanel2.add(okb1);
        okb1.setBounds(380, 50, 50, 30);

        tbp1.addTab("Non_Veg", jPanel2);

        jDesktopPane1.setBackground(new java.awt.Color(204, 204, 255));

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        jDesktopPane1.add(jScrollPane2);
        jScrollPane2.setBounds(510, 10, 300, 360);

        cb4.setBackground(new java.awt.Color(153, 255, 255));
        cb4.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 14)); // NOI18N
        cb4.setForeground(new java.awt.Color(153, 0, 153));
        cb4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Search" }));
        cb4.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cb4PopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        cb4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cb4MouseClicked(evt);
            }
        });
        cb4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb4ActionPerformed(evt);
            }
        });
        cb4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cb4KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cb4KeyReleased(evt);
            }
        });
        jDesktopPane1.add(cb4);
        cb4.setBounds(50, 50, 120, 30);

        t158.setBackground(new java.awt.Color(204, 255, 255));
        t158.setFont(new java.awt.Font("SimSun", 1, 16)); // NOI18N
        t158.setForeground(new java.awt.Color(0, 0, 204));
        t158.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        t158.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t158ActionPerformed(evt);
            }
        });
        t158.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                t158KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                t158KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                t158KeyTyped(evt);
            }
        });
        jDesktopPane1.add(t158);
        t158.setBounds(50, 90, 120, 30);

        t159.setBackground(new java.awt.Color(153, 255, 255));
        t159.setFont(new java.awt.Font("Copperplate Gothic Bold", 1, 14)); // NOI18N
        t159.setForeground(new java.awt.Color(153, 0, 153));
        t159.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        t159.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        t159.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t159ActionPerformed(evt);
            }
        });
        jDesktopPane1.add(t159);
        t159.setBounds(50, 130, 120, 32);

        t160.setFont(new java.awt.Font("SimSun", 1, 14)); // NOI18N
        t160.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        t160.setText("0");
        t160.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        t160.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                t160FocusGained(evt);
            }
        });
        t160.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t160ActionPerformed(evt);
            }
        });
        jDesktopPane1.add(t160);
        t160.setBounds(70, 180, 60, 30);

        okb2.setText("ok");
        okb2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okb2ActionPerformed(evt);
            }
        });
        jDesktopPane1.add(okb2);
        okb2.setBounds(70, 220, 50, 30);

        tbp1.addTab("tab3", jDesktopPane1);

        dp1.add(tbp1);
        tbp1.setBounds(40, 90, 970, 450);

        b4.setBackground(new java.awt.Color(153, 102, 255));
        b4.setFont(new java.awt.Font("Copperplate Gothic Bold", 1, 14)); // NOI18N
        b4.setText("view bill");
        b4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b4ActionPerformed(evt);
            }
        });
        dp1.add(b4);
        b4.setBounds(480, 550, 160, 40);

        jButton2.setBackground(new java.awt.Color(0, 255, 0));
        jButton2.setFont(new java.awt.Font("Copperplate Gothic Bold", 1, 14)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/B/print.png"))); // NOI18N
        jButton2.setText("Print");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        dp1.add(jButton2);
        jButton2.setBounds(670, 550, 160, 40);

        jButton3.setBackground(new java.awt.Color(153, 102, 255));
        jButton3.setFont(new java.awt.Font("Copperplate Gothic Bold", 1, 14)); // NOI18N
        jButton3.setText("clear all");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        dp1.add(jButton3);
        jButton3.setBounds(850, 550, 160, 40);

        jScrollPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        tt1.setColumns(20);
        tt1.setRows(5);
        jScrollPane1.setViewportView(tt1);

        dp1.add(jScrollPane1);
        jScrollPane1.setBounds(1020, 130, 270, 400);

        jButton6.setFont(new java.awt.Font("SimSun-ExtB", 1, 14)); // NOI18N
        jButton6.setText("Reset Bill");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        dp1.add(jButton6);
        jButton6.setBounds(1070, 540, 180, 30);

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/B/bill.png"))); // NOI18N
        jLabel7.setText("BILL :");
        dp1.add(jLabel7);
        jLabel7.setBounds(1040, 80, 100, 40);

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
        dp1.add(cnt1);
        cnt1.setBounds(740, 30, 120, 50);

        l7.setFont(new java.awt.Font("Copperplate Gothic Bold", 1, 24)); // NOI18N
        l7.setForeground(new java.awt.Color(255, 255, 255));
        l7.setText("Total :");
        dp1.add(l7);
        l7.setBounds(630, 30, 100, 50);

        t111.setEditable(false);
        t111.setBackground(new java.awt.Color(153, 220, 255));
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
        dp1.add(t111);
        t111.setBounds(540, 40, 60, 40);

        jLabel21.setFont(new java.awt.Font("SimSun", 0, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("total");
        dp1.add(jLabel21);
        jLabel21.setBounds(1130, 30, 60, 20);

        t204.setEditable(false);
        t204.setBackground(new java.awt.Color(204, 204, 255));
        t204.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 14)); // NOI18N
        t204.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        t204.setText("0");
        t204.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        t204.setRequestFocusEnabled(false);
        t204.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t204ActionPerformed(evt);
            }
        });
        dp1.add(t204);
        t204.setBounds(1200, 30, 80, 20);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Rate card");
        jLabel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(0, 0, 0), null, new java.awt.Color(0, 153, 153)));
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        dp1.add(jLabel3);
        jLabel3.setBounds(160, 0, 70, 20);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("view Cus");
        jLabel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(0, 0, 0), null, new java.awt.Color(0, 153, 153)));
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });
        dp1.add(jLabel4);
        jLabel4.setBounds(100, 0, 60, 20);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Graph");
        jLabel5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(0, 0, 0), null, new java.awt.Color(0, 153, 153)));
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });
        dp1.add(jLabel5);
        jLabel5.setBounds(0, 0, 50, 20);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/B/close11.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        jLabel1.setBorder(new javax.swing.border.MatteBorder(null));
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        dp1.add(jLabel1);
        jLabel1.setBounds(40, 570, 170, 50);

        jLabel22.setFont(new java.awt.Font("SimSun", 1, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Customer No");
        dp1.add(jLabel22);
        jLabel22.setBounds(410, 40, 130, 40);

        t205.setEditable(false);
        t205.setBackground(new java.awt.Color(204, 204, 255));
        t205.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 14)); // NOI18N
        t205.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        t205.setText("0");
        t205.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        t205.setRequestFocusEnabled(false);
        t205.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t205ActionPerformed(evt);
            }
        });
        dp1.add(t205);
        t205.setBounds(1200, 0, 80, 20);

        jLabel23.setFont(new java.awt.Font("SimSun", 0, 14)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("Entries");
        dp1.add(jLabel23);
        jLabel23.setBounds(1130, 0, 80, 20);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Today");
        jLabel6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(0, 0, 0), null, new java.awt.Color(0, 153, 153)));
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });
        dp1.add(jLabel6);
        jLabel6.setBounds(230, 0, 70, 20);

        jPanel1.add(dp1);
        dp1.setBounds(0, 0, 1510, 670);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 70, 1510, 630);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void rb32MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rb32MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_rb32MouseClicked

    private void rb32ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb32ActionPerformed

        if(rb32.isSelected())
        { t33.enable(true);
        t33.setText("");
            t67.enable(true);
            t124.enable(true);
            t33.requestFocus();
             try{
                    String sql="SELECT rate\n" +"FROM public.\"Rate\" where menu='"+rb32.getText()+"' ;";
                    pst=conn.prepareStatement(sql);
                    rs=pst.executeQuery();
                    if(rs.next())
                    {
                        t67.setText(rs.getString(1));
                    }

                }catch(Exception e)
                {
                    JOptionPane.showMessageDialog(null, e);
                };

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
char c=evt.getKeyChar();
        if(!(Character.isDigit(c)) || (c==KeyEvent.VK_ENTER) ||(c==KeyEvent.VK_BACK_SPACE)   ){
            evt.consume();}        // TODO add your handling code here:
    }//GEN-LAST:event_t33KeyTyped

    private void rb43rb1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rb43rb1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_rb43rb1MouseClicked

    private void rb43ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb43ActionPerformed

        if(rb43.isSelected())
        {  t34.enable(true);
            t112.enable(true); t34.setText("");
            t125.enable(true);
            t34.requestFocus();

             try{
                    String sql="SELECT rate\n" +"FROM public.\"Rate\" where menu='"+rb43.getText()+"' ;";
                    pst=conn.prepareStatement(sql);
                    rs=pst.executeQuery();
                    if(rs.next())
                    {
                        t112.setText(rs.getString(1));
                    }

                }catch(Exception e)
                {
                    JOptionPane.showMessageDialog(null, e);
                };

            
            
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

    private void t34KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t34KeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER)
        {
            t112.requestFocus();

        }         // TODO add your handling code here:
    }//GEN-LAST:event_t34KeyPressed

    private void t34KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t34KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t34KeyReleased

    private void rb33rb1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rb33rb1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_rb33rb1MouseClicked

    private void rb33ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb33ActionPerformed
        if(rb33.isSelected())
        { t35.enable(true);
            t118.enable(true); t35.setText("");
            t126.enable(true);
            t35.requestFocus();
 try{
                    String sql="SELECT rate\n" +"FROM public.\"Rate\" where menu='"+rb33.getText()+"' ;";
                    pst=conn.prepareStatement(sql);
                    rs=pst.executeQuery();
                    if(rs.next())
                    {
                        t118.setText(rs.getString(1));
                    }

                }catch(Exception e)
                {
                    JOptionPane.showMessageDialog(null, e);
                };

        } else
        if(rb33.isSelected()==false)
        {
            t35.setText("");    t118.setText("");        t126.setText("0");
            t35.enable(false);  t118.enable(false);      t126.enable(false);
        }            // TODO add your handling code here:
    }//GEN-LAST:event_rb33ActionPerformed

    private void t35KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t35KeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER)
        {
            t118.requestFocus();

        }         // TODO add your handling code here:
    }//GEN-LAST:event_t35KeyPressed

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
            t127.enable(true); t36.setText("");
            t36.requestFocus();
 try{
                    String sql="SELECT rate\n" +"FROM public.\"Rate\" where menu='"+rb43.getText()+"' ;";
                    pst=conn.prepareStatement(sql);
                    rs=pst.executeQuery();
                    if(rs.next())
                    {
                        t119.setText(rs.getString(1));
                    }

                }catch(Exception e)
                {
                    JOptionPane.showMessageDialog(null, e);
                };

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
            t128.enable(true); t37.setText("");
            t37.requestFocus();
 try{
                    String sql="SELECT rate\n" +"FROM public.\"Rate\" where menu='"+rb35.getText()+"' ;";
                    pst=conn.prepareStatement(sql);
                    rs=pst.executeQuery();
                    if(rs.next())
                    {
                        t120.setText(rs.getString(1));
                    }

                }catch(Exception e)
                {
                    JOptionPane.showMessageDialog(null, e);
                };

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

    private void t37KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t37KeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER)
        {
            t120.requestFocus();

        }         // TODO add your handling code here:
    }//GEN-LAST:event_t37KeyPressed

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
            t129.enable(true); t38.setText("");
            t38.requestFocus();
 try{
                    String sql="SELECT rate\n" +"FROM public.\"Rate\" where menu='"+rb36.getText()+"' ;";
                    pst=conn.prepareStatement(sql);
                    rs=pst.executeQuery();
                    if(rs.next())
                    {
                        t121.setText(rs.getString(1));
                    }

                }catch(Exception e)
                {
                    JOptionPane.showMessageDialog(null, e);
                };

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

    private void t38KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t38KeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER)
        {
            t121.requestFocus();

        }         // TODO add your handling code here:
    }//GEN-LAST:event_t38KeyPressed

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
            t39.requestFocus(); t39.setText("");
 try{
                    String sql="SELECT rate\n" +"FROM public.\"Rate\" where menu='"+rb37.getText()+"' ;";
                    pst=conn.prepareStatement(sql);
                    rs=pst.executeQuery();
                    if(rs.next())
                    {
                        t122.setText(rs.getString(1));
                    }

                }catch(Exception e)
                {
                    JOptionPane.showMessageDialog(null, e);
                };

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

    private void t39KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t39KeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER)
        {
            t122.requestFocus();

        }         // TODO add your handling code here:
    }//GEN-LAST:event_t39KeyPressed

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
            t131.enable(true); t40.setText("");
            t40.requestFocus();
 try{
                    String sql="SELECT rate\n" +"FROM public.\"Rate\" where menu='"+rb38.getText()+"' ;";
                    pst=conn.prepareStatement(sql);
                    rs=pst.executeQuery();
                    if(rs.next())
                    {
                        t123.setText(rs.getString(1));
                    }

                }catch(Exception e)
                {
                    JOptionPane.showMessageDialog(null, e);
                };

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

    private void t40KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t40KeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER)
        {
            t123.requestFocus();

        }         // TODO add your handling code here:
    }//GEN-LAST:event_t40KeyPressed

    private void t40KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t40KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t40KeyReleased

    private void t67ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t67ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t67ActionPerformed

    private void t67KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t67KeyReleased
        int a=Integer.parseInt(t33.getText()) * Integer.parseInt(t67.getText());
        t124.setText(String.valueOf(a));
        // TODO add your handling code here:
    }//GEN-LAST:event_t67KeyReleased

    private void t112ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t112ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t112ActionPerformed

    private void t112KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t112KeyReleased
        int a=Integer.parseInt(t34.getText()) * Integer.parseInt(t112.getText());
        t125.setText(String.valueOf(a));        // TODO add your handling code here:
    }//GEN-LAST:event_t112KeyReleased

    private void t118ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t118ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t118ActionPerformed

    private void t118KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t118KeyReleased
        int a=Integer.parseInt(t35.getText()) * Integer.parseInt(t118.getText());
        t126.setText(String.valueOf(a));        // TODO add your handling code here:
    }//GEN-LAST:event_t118KeyReleased

    private void t119ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t119ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t119ActionPerformed

    private void t119KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t119KeyReleased
        int a=Integer.parseInt(t36.getText()) * Integer.parseInt(t119.getText());
        t127.setText(String.valueOf(a));      // TODO add your handling code here:
    }//GEN-LAST:event_t119KeyReleased

    private void t120ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t120ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t120ActionPerformed

    private void t120KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t120KeyReleased
        int a=Integer.parseInt(t37.getText()) * Integer.parseInt(t120.getText());
        t128.setText(String.valueOf(a));   // TODO add your handling code here:
    }//GEN-LAST:event_t120KeyReleased

    private void t121ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t121ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t121ActionPerformed

    private void t121KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t121KeyReleased
        int a=Integer.parseInt(t38.getText()) * Integer.parseInt(t121.getText());
        t129.setText(String.valueOf(a));          // TODO add your handling code here:
    }//GEN-LAST:event_t121KeyReleased

    private void t122ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t122ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t122ActionPerformed

    private void t122KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t122KeyReleased
        int a=Integer.parseInt(t39.getText()) * Integer.parseInt(t122.getText());
        t130.setText(String.valueOf(a));          // TODO add your handling code here:
    }//GEN-LAST:event_t122KeyReleased

    private void t123ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t123ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t123ActionPerformed

    private void t123KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t123KeyReleased
        int a=Integer.parseInt(t40.getText()) * Integer.parseInt(t123.getText());
        t131.setText(String.valueOf(a));          // TODO add your handling code here:
    }//GEN-LAST:event_t123KeyReleased

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
            t132.requestFocus();t132.setText("");

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

    private void t132KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t132KeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER)
        {
            t140.requestFocus();

        }         // TODO add your handling code here:
    }//GEN-LAST:event_t132KeyPressed

    private void t132KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t132KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t132KeyReleased

    private void rb40ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb40ActionPerformed
        if(rb40.isSelected())
        { t133.enable(true);
            t141.enable(true);
            t149.enable(true);t133.setText("");
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

    private void t133KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t133KeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER)
        {
            t141.requestFocus();

        }         // TODO add your handling code here:
    }//GEN-LAST:event_t133KeyPressed

    private void t133KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t133KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t133KeyReleased

    private void rb44ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb44ActionPerformed
        if(rb44.isSelected())
        { t134.enable(true);
            t142.enable(true);
            t150.enable(true);t134.setText("");
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

    private void t134KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t134KeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER)
        {
            t142.requestFocus();

        }         // TODO add your handling code here:
    }//GEN-LAST:event_t134KeyPressed

    private void t134KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t134KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t134KeyReleased

    private void t134KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t134KeyTyped
char c=evt.getKeyChar();
        if(!(Character.isDigit(c)) || (c==KeyEvent.VK_ENTER) ||(c==KeyEvent.VK_BACK_SPACE)   ){
            evt.consume();}        // TODO add your handling code here:
    }//GEN-LAST:event_t134KeyTyped

    private void rb45ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb45ActionPerformed
        if(rb45.isSelected())
        {  t135.enable(true);
            t143.enable(true);
            t151.enable(true);
            t135.requestFocus();t135.setText("");

        } else
        if(rb45.isSelected()==false)
        {
            t135.setText("");    t143.setText("");        t151.setText("0");
            t135.enable(false);  t143.enable(false);      t151.enable(false);
        }               // TODO add your handling code here:
    }//GEN-LAST:event_rb45ActionPerformed

    private void t135KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t135KeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER)
        {
            t143.requestFocus();

        }         // TODO add your handling code here:
    }//GEN-LAST:event_t135KeyPressed

    private void t135KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t135KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t135KeyReleased

    private void rb46ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb46ActionPerformed
        if(rb46.isSelected())
        {  t136.enable(true);
            t144.enable(true);
            t148.enable(true);t136.setText("");
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
            t153.requestFocus();t137.setText("");

        } else
        if(rb47.isSelected()==false)
        {
            t137.setText("");    t145.setText("");        t153.setText("0");
            t137.enable(false);  t145.enable(false);      t153.enable(false);
        }        // TODO add your handling code here:
    }//GEN-LAST:event_rb47ActionPerformed

    private void t137KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t137KeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER)
        {
            t145.requestFocus();

        }         // TODO add your handling code here:
    }//GEN-LAST:event_t137KeyPressed

    private void t137KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t137KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t137KeyReleased

    private void rb48ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb48ActionPerformed
        if(rb48.isSelected())
        {  t138.enable(true);
            t146.enable(true);
            t154.enable(true);t138.setText("");
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

    private void t138KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t138KeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER)
        {
            t146.requestFocus();

        }         // TODO add your handling code here:
    }//GEN-LAST:event_t138KeyPressed

    private void t138KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t138KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t138KeyReleased

    private void rb49ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb49ActionPerformed
        if(rb49.isSelected())
        {
            t139.enable(true);
            t147.enable(true);t139.setText("");
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

    private void t139KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t139KeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER)
        {
            t147.requestFocus();

        }         // TODO add your handling code here:
    }//GEN-LAST:event_t139KeyPressed

    private void t139KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t139KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t139KeyReleased

    private void t140KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t140KeyReleased

        int a=Integer.parseInt(t132.getText()) * Integer.parseInt(t140.getText());
        t148.setText(String.valueOf(a));

        // TODO add your handling code here:
    }//GEN-LAST:event_t140KeyReleased

    private void t141ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t141ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t141ActionPerformed

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

    private void t147ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t147ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t147ActionPerformed

    private void t147KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t147KeyReleased
        int a=Integer.parseInt(t139.getText()) * Integer.parseInt(t147.getText());
        t155.setText(String.valueOf(a));          // TODO add your handling code here:
    }//GEN-LAST:event_t147KeyReleased

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

    private void t114ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t114ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t114ActionPerformed

    private void cb2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cb2MouseClicked
 AutoCompleteDecorator.decorate(cb2);
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

        
        
     
        t115.setText("");
    }//GEN-LAST:event_cb2ActionPerformed

    private void cb2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cb2KeyPressed
        
        
        
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            
            
            t115.enable(true);
            t115.requestFocus();

        }
        // TODO add your handling code here:
    }//GEN-LAST:event_cb2KeyPressed

    private void t115ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t115ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t115ActionPerformed

    private void t115KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t115KeyPressed
 if(evt.getKeyCode()==KeyEvent.VK_ENTER)
        {
         int total,x1=0,y1=0;
         String a =t114.getText();
        String b=t115.getText();
        int a1  =Integer.parseInt(a);
        int b1 =Integer.parseInt(b);
        int cnt  =Integer.parseInt(cnt1.getText());
      
            total=a1*b1;
        y1=total+cnt;

        String str=String.valueOf(total);
        cnt1.setText(""+y1);

        t161.setText(""+str);    
     try{
                 Date  date= new Date();
                  SimpleDateFormat s= new SimpleDateFormat("dd-MM-yyyy");
                 String dt=s.format(date);
                 String item=cb2.getSelectedItem().toString();
                 String select="SELECT date, item, quntity,rupees\n" +
"	FROM public.\"ItemSell\" WHERE date=? AND item=?";
                 
                 String insert="INSERT INTO public.\"ItemSell\"(\n" +
"	date, item, quntity, rupees)\n" +
"	VALUES (?, ?, ?, ?);";
                  pst=conn.prepareStatement(select);
                 pst.setString(1,dt);
                 pst.setString(2,item);
                 rs=pst.executeQuery();
                 if(rs.next())
                 {    String qt=rs.getString(3);
                     String st=rs.getString(4);
                    
                   int aa=Integer.valueOf(qt);
                   int bb=Integer.valueOf(t115.getText());
                   int cc=aa+bb;
                    double ff,ee=0.0;
                   String dd=rs.getString(4);
                    ee=Double.valueOf(dd);
                    ff=Double.valueOf(t161.getText());
                    double gg=ee+ff;
                  
                     pst=conn.prepareStatement("UPDATE public.\"ItemSell\"\n" +
"	SET  quntity='"+cc+"'  , rupees='"+gg+"'  \n" +
"	WHERE  item='"+item+"' AND date='"+dt+"'  ;");
                        pst.execute();
                         JOptionPane.showMessageDialog(null, "updated");
                          }else{                    
                        JOptionPane.showMessageDialog(null, "failed");
                         pst=conn.prepareStatement(insert);
                         pst.setString(1,dt);
                         pst.setString(2,item);
                         pst.setInt(3,Integer.parseInt(t115.getText()));
                         pst.setDouble(4,Double.parseDouble(t161.getText()));
                         pst.execute();
                          JOptionPane.showMessageDialog(null, "new Added");
                    }
            }catch(Exception e){ JOptionPane.showMessageDialog(null, e);
            }
      try{
            String n31=String.valueOf(cnt1.getText());
            String n2=ldt.getText();
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
         
         try{
            String n31=String.valueOf(cnt1.getText());
            String n2=ldt.getText();
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
        tt1.append(""+cb2.getSelectedItem()+":"+t115.getText()+"\t"+t114.getText()+"\t"+t161.getText()+"\n");
        t115.setText("");
        t114.setText("0");
      t161.setText("0");
        cb2.setSelectedIndex(0);
       
       
        fetchcno();
        }
         
   
    }//GEN-LAST:event_t115KeyPressed

    private void t115KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t115KeyReleased
  int total,x1=0;

        String a=t114.getText();
        String b=t115.getText();
        int a1  =Integer.parseInt(a);
        int b1 =Integer.parseInt(b);

        total=a1*b1;

        String str=String.valueOf(total);

        t161.setText(""+str);
        // TODO add your handling code here:
    }//GEN-LAST:event_t115KeyReleased

    private void t115KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t115KeyTyped
        char c=evt.getKeyChar();
        if(!(Character.isDigit(c)) || (c==KeyEvent.VK_ENTER) ||(c==KeyEvent.VK_BACK_SPACE)   ){
            evt.consume();}
            
        
        // TODO add your handling code here:
    }//GEN-LAST:event_t115KeyTyped

    private void rb8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb8ActionPerformed
        if(rb8.isSelected())
        {
            t7.enable(true);
            t7.requestFocus();t7.setText("");
            try{
                

                String sql="SELECT rate\n" +"FROM public.\"Rate\" where menu='"+rb8.getText()+"' ;";
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

    private void t7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t7ActionPerformed

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

    private void rb9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb9ActionPerformed
        if(rb9.isSelected())
        {
            t8.enable(true);t8.setText("");
            t8.requestFocus();
            try{
               

                 String sql="SELECT rate\n" +"FROM public.\"Rate\" where menu='"+rb9.getText()+"' ;";
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

    private void t8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t8ActionPerformed

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

    private void rb10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb10ActionPerformed
        if(rb10.isSelected())
        {
            t10.enable(true);
            t10.requestFocus();t10.setText("");
            try{
                

                 String sql="SELECT rate\n" +"FROM public.\"Rate\" where menu='"+rb10.getText()+"' ;";
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

    private void t10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t10ActionPerformed

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

    private void t10KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t10KeyTyped
char c=evt.getKeyChar();
        if(!(Character.isDigit(c)) || (c==KeyEvent.VK_ENTER) ||(c==KeyEvent.VK_BACK_SPACE)   ){
            evt.consume();}        // TODO add your handling code here:
    }//GEN-LAST:event_t10KeyTyped

    private void rb11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb11ActionPerformed
        if(rb11.isSelected())
        {
            t20.enable(true);
            t20.requestFocus();t20.setText("");
            try{
                

                String sql="SELECT rate\n" +"FROM public.\"Rate\" where menu='"+rb11.getText()+"' ;";
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

    private void rb12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb12ActionPerformed
        if(rb12.isSelected())
        {
            t12.enable(true);
            t12.requestFocus();t12.setText("");
            try{
                

                 String sql="SELECT rate\n" +"FROM public.\"Rate\" where menu='"+rb12.getText()+"' ;";
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

    private void t12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t12ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t12ActionPerformed

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

    private void rb13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb13ActionPerformed
        if(rb13.isSelected())
        {
            t11.enable(true);
            t11.requestFocus();t11.setText("");
            try{
                

                String sql="SELECT rate\n" +"FROM public.\"Rate\" where menu='"+rb13.getText()+"' ;";
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

    private void rb14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb14ActionPerformed
        if(rb14.isSelected())
        {
            t21.enable(true);
            t21.requestFocus();t21.setText("");
            try{
                

                String sql="SELECT rate\n" +"FROM public.\"Rate\" where menu='"+rb14.getText()+"' ;";
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

    private void t21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t21ActionPerformed

    }//GEN-LAST:event_t21ActionPerformed

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

    private void rb15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb15ActionPerformed
        if(rb15.isSelected())
        {
            t22.enable(true);
            t22.requestFocus();t22.setText("");
            try{
                

                String sql="SELECT rate\n" +"FROM public.\"Rate\" where menu='"+rb15.getText()+"' ;";
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

    private void t22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t22ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t22ActionPerformed

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

    private void t47ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t47ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t47ActionPerformed

    private void t48ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t48ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t48ActionPerformed

    private void t54ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t54ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t54ActionPerformed

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

    private void rb16rb1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rb16rb1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_rb16rb1MouseClicked

    private void rb16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb16ActionPerformed
        if(rb16.isSelected())
        {
            t13.enable(true);t13.setText("");
            t13.requestFocus();
            try{
               

                String sql="SELECT rate\n" +"FROM public.\"Rate\" where menu='"+rb16.getText()+"' ;";
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

    private void rb6rb1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rb6rb1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_rb6rb1MouseClicked

    private void rb6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb6ActionPerformed
        if(rb6.isSelected())
        {
            t9.enable(true);
            t9.requestFocus();t9.setText("");
            try{
              

                 String sql="SELECT rate\n" +"FROM public.\"Rate\" where menu='"+rb6.getText()+"' ;";
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

    private void rb7rb1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rb7rb1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_rb7rb1MouseClicked

    private void rb7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb7ActionPerformed
        if(rb7.isSelected())
        {
            t6.enable(true);t6.setText("");
            t6.requestFocus();
            try{
             

                 String sql="SELECT rate\n" +"FROM public.\"Rate\" where menu='"+rb7.getText()+"' ;";
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

    private void rb5rb1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rb5rb1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_rb5rb1MouseClicked

    private void rb5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb5ActionPerformed
        if(rb5.isSelected())
        {
            t5.enable(true);t5.setText("");
            t5.requestFocus();
            try{
            
                String sql="SELECT rate\n" +"FROM public.\"Rate\" where menu='"+rb5.getText()+"' ;";
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

    private void rb3rb1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rb3rb1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_rb3rb1MouseClicked

    private void rb3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb3ActionPerformed
       
        t4.enable(true);t4.setText("");
        if(rb3.isSelected())
        {
            t4.enable(true);
            t4.requestFocus();
            try{
               
                 String sql="SELECT rate\n" +"FROM public.\"Rate\" where menu='"+rb3.getText()+"' ;";
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

    private void rb2rb1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rb2rb1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_rb2rb1MouseClicked

    private void rb2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb2ActionPerformed
        if(rb2.isSelected())
        {
            t3.enable(true);t3.setText("");
            t3.requestFocus();
            try{
                

                String sql="SELECT rate\n" +"FROM public.\"Rate\" where menu='"+rb2.getText()+"' ;";
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

    private void rb41rb1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rb41rb1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_rb41rb1MouseClicked

    private void rb41ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb41ActionPerformed

        
            if(rb41.isSelected())
            {
                t2.enable(true);t2.setText("");
                t2.requestFocus();
                try{
                    

                   String sql="SELECT rate\n" +"FROM public.\"Rate\" where menu='"+rb41.getText()+"' ;";
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
        else{
            t2.enable(true);
            t2.requestFocus();

        }        // TODO add your handling code here:
    }//GEN-LAST:event_rb41ActionPerformed

    private void rb1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rb1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_rb1MouseClicked

    private void rb1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb1ActionPerformed

        
        
            if(rb1.isSelected())
            {

                t1.enable(true);t1.setText("");
                t57.enable(true);
                t1.requestFocus();
                try{
                    String sql="SELECT rate\n" +"FROM public.\"Rate\" where menu='"+rb1.getText()+"' ;";       
                    pst=conn.prepareStatement(sql);
                    rs=pst.executeQuery();
                    if(rs.next())
                    {
                        t41.setText(rs.getString(1));
                    }

                }catch(Exception e)
                {
                    JOptionPane.showMessageDialog(null, e);
                };
            }
            
            
            if(rb1.isSelected()==false)
            {
                t1.setText("");t1.enable(false); t41.setText("");  t57.setText("0");t57.enable(false);
                    }
            else{
                t1.enable(true);
                t57.enable(true);
                t1.requestFocus();
            }
        
    }//GEN-LAST:event_rb1ActionPerformed

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

    private void t1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t1KeyTyped
char c=evt.getKeyChar();
        if(!(Character.isDigit(c)) || (c==KeyEvent.VK_ENTER) ||(c==KeyEvent.VK_BACK_SPACE)   ){
            evt.consume();}
    }//GEN-LAST:event_t1KeyTyped

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

    private void t4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t4ActionPerformed

    private void t4KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t4KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_t4KeyPressed

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

    private void t5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t5ActionPerformed

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

    private void t6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t6ActionPerformed

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

    private void t9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t9ActionPerformed

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

    private void t13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t13ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t13ActionPerformed

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

    private void t41ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t41ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t41ActionPerformed

    private void t42ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t42ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t42ActionPerformed

    private void t43ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t43ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t43ActionPerformed

    private void t44ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t44ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t44ActionPerformed

    private void t45ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t45ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t45ActionPerformed

    private void t46ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t46ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t46ActionPerformed

    private void t60ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t60ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t60ActionPerformed

    private void t58ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t58ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t58ActionPerformed

    private void t57FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_t57FocusGained

        // TODO add your handling code here:
    }//GEN-LAST:event_t57FocusGained

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
t116.setText("");        // TODO add your handling code here:
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

        int total,x1=0,y1=0;
         String a =t116.getText();
        String b=t117.getText();
        int a1  =Integer.parseInt(a);
        int b1 =Integer.parseInt(b);
        int cnt  =Integer.parseInt(cnt1.getText());
       if(evt.getKeyCode()==KeyEvent.VK_ENTER)
        {
            total=a1*b1;
        y1=total+cnt;

        String str=String.valueOf(total);
        cnt1.setText(""+y1);

        t157.setText(""+str);    
        
        
          try{
                 Date  date= new Date();
                  SimpleDateFormat s= new SimpleDateFormat("dd-MM-yyyy");
                 String dt=s.format(date);
                 String item=cb3.getSelectedItem().toString();
                 String select="SELECT date, item, quntity,rupees\n" +
"	FROM public.\"ItemSell\" WHERE date=? AND item=?";
                 
                 String insert="INSERT INTO public.\"ItemSell\"(\n" +
"	date, item, quntity, rupees)\n" +
"	VALUES (?, ?, ?, ?);";
                  pst=conn.prepareStatement(select);
                 pst.setString(1,dt);
                 pst.setString(2,item);
                 rs=pst.executeQuery();
                 if(rs.next())
                 {    String qt=rs.getString(3);
                     String st=rs.getString(4);
                    
                   int aa=Integer.valueOf(qt);
                   int bb=Integer.valueOf(t116.getText());
                   int cc=aa+bb;
                    double ff,ee=0.0;
                   String dd=rs.getString(4);
                    ee=Double.valueOf(dd);
                    ff=Double.valueOf(t157.getText());
                    double gg=ee+ff;
                  
                     pst=conn.prepareStatement("UPDATE public.\"ItemSell\"\n" +
"	SET  quntity='"+cc+"'  , rupees='"+gg+"'  \n" +
"	WHERE  item='"+item+"' AND date='"+dt+"'  ;");
                        pst.execute();
                         JOptionPane.showMessageDialog(null, "updated");
                          }else{                    
                        JOptionPane.showMessageDialog(null, "failed");
                         pst=conn.prepareStatement(insert);
                         pst.setString(1,dt);
                         pst.setString(2,item);
                         pst.setInt(3,Integer.parseInt(t116.getText()));
                         pst.setDouble(4,Double.parseDouble(t157.getText()));
                         pst.execute();
                          JOptionPane.showMessageDialog(null, "new Added");
                    }
            }catch(Exception e){ JOptionPane.showMessageDialog(null, e);
            }
       
        }
        
         tt1.append(""+cb3.getSelectedItem()+":"+t116.getText()+"\t"+t117.getText()+"\t"+t157.getText()+"\n");
        t116.setText("");
        t117.setText("0");
      t157.setText("0");
        cb3.setSelectedIndex(0);
        
    
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
char c=evt.getKeyChar();
        if(!(Character.isDigit(c)) || (c==KeyEvent.VK_ENTER) ||(c==KeyEvent.VK_BACK_SPACE)   ){
            evt.consume();}        // TODO add your handling code here:
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

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        tt1.setText("********************************\n"+
            "*       Hotel Shubham       *\n"+
            "********************************\n"+
            "\n"
        );       // TODO add your handling code here:
    }//GEN-LAST:event_jButton6ActionPerformed

    private void b4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b4ActionPerformed

        /* if(!rb31.isSelected()){
            tt1.append(l1.getText()+"\t"+ldt.getText()+"\n"+"********************************\n");
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
            int a8=Integer.parseInt(cnt1.getText());

            tot=a+b+c+d+e+f+g+h+i+j+k+l+m+n+o+p+q+r+s+t+u+v+w+x+y+z+a1+a2+a3+a4+a5+a6+a7+a8;
           
            cnt1.setText(""+tot);

        }

        tt1.append("\n"+"Total"+"\t"+cnt1.getText()+"\n");

    }//GEN-LAST:event_b4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        
        updatedaily();
//        //admin database
        try{
            String n31=String.valueOf(cnt1.getText());
            String n2=ldt.getText();
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

        try{
            String n31=String.valueOf(cnt1.getText());
            String n2=ldt.getText();
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
            String date=ldt.getText();

            FileWriter wt=new FileWriter("DailyEarningReport.txt",true);
            wt.write("\n");
            wt.write(date);
            wt.write("\t");
            wt.write(id);
            wt.write("\t");
            wt.write(total);
////
////             File f=new File("Documents\\DailyReport.xlsx");
////            WritableWorkbook myexcel =Workbook.createWorkbook(f);
////            WritableSheet mysheet = myexcel.createSheet("ms", 0);
////
////            Label l=new Label("data1");
////
////            Label l2=new Label("data2");
////            mysheet.addCell( l);
////            mysheet.addCell( l2);
////            myexcel.write();
////            myexcel.close();
////            System.out.println("ok");
////            
//
            wt.close();
            JOptionPane.showMessageDialog(rootPane,"ok");

        }catch(Exception e){
            JOptionPane.showMessageDialog(rootPane,e);

        }
////        
        
         /*-------------------------------------------------------------------------------------   */
          if(rb1.isSelected())
          { rb1();
          }
          if(rb2.isSelected())
        {       rb2(); }
          
        if(rb3.isSelected())
        {
          rb3();
        }
          
           if(rb5.isSelected())
        {
           rb5();
        }
           if(rb7.isSelected())
        {
           rb7();
        }
           if(rb6.isSelected())
        {
           rb6();
        }
           if(rb16.isSelected())
        {
          rb16();
        }
           if(rb8.isSelected())
        {rb8();
                   }
//           
           if(rb9.isSelected())
        {
           rb9();
        }
          if(rb10.isSelected())
        {
          rb10();
        }
           if(rb11.isSelected())
        {
           rb11();
        }
           if(rb12.isSelected())
        {
           rb13();
        }
            if(rb13.isSelected())
        {
         rb13();
        }
            if(rb14.isSelected())
        {
           rb14();
        }
           if(rb15.isSelected())
        {
          rb15();
        }
           if(rb41.isSelected())
        {
          rb41();
        }
            try{
            boolean cm=tt1.print();
            if(cm){
                JOptionPane.showMessageDialog(rootPane, "done");
            }else{
                JOptionPane.showMessageDialog(rootPane, "failed");
            }
        }catch(Exception e){
            
        }
//-------------------------------------------------------------------------------------
        tfclose();
        clear();
        onload();
        fetchcno();

//       
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        clear();

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void t204ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t204ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t204ActionPerformed

    private void t111ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t111ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t111ActionPerformed

    private void cnt1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cnt1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cnt1ActionPerformed

    private void okbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okbActionPerformed
 updatedaily();
        
        {
         int total,x1=0,y1=0;
         String a =t114.getText();
        String b=t115.getText();
        int a1  =Integer.parseInt(a);
        int b1 =Integer.parseInt(b);
        int cnt  =Integer.parseInt(cnt1.getText());
      
        total=a1*b1;
        y1=total+cnt;

        String str=String.valueOf(total);
        cnt1.setText(""+y1);
         t161.setText(""+str);    
        
    
        tt1.append(""+cb2.getSelectedItem()+":"+t115.getText()+"\t"+t114.getText()+"\t"+t161.getText()+"\n");
       
        
        }
        try{
                 Date  date= new Date();
                  SimpleDateFormat s= new SimpleDateFormat("dd-MM-yyyy");
                 String dt=s.format(date);
                 String item=cb2.getSelectedItem().toString();
                 String select="SELECT date, item, quntity,rupees\n" +
"	FROM public.\"ItemSell\" WHERE date=? AND item=?";
                 
                 String insert="INSERT INTO public.\"ItemSell\"(\n" +
"	date, item, quntity, rupees)\n" +
"	VALUES (?, ?, ?, ?);";
                  pst=conn.prepareStatement(select);
                 pst.setString(1,dt);
                 pst.setString(2,item);
                 rs=pst.executeQuery();
                 if(rs.next())
                 {    String qt=rs.getString(3);
                     String st=rs.getString(4);
                    
                   int aa=Integer.valueOf(qt);
                   int bb=Integer.valueOf(t115.getText());
                   int cc=aa+bb;
                    double ff,ee=0.0;
                   String dd=rs.getString(4);
                    ee=Double.valueOf(dd);
                    ff=Double.valueOf(t161.getText());
                    double gg=ee+ff;
                  
                     pst=conn.prepareStatement("UPDATE public.\"ItemSell\"\n" +
"	SET  quntity='"+cc+"'  , rupees='"+gg+"'  \n" +
"	WHERE  item='"+item+"' AND date='"+dt+"'  ;");
                        pst.execute();
                         JOptionPane.showMessageDialog(null, "updated");
                          }else{                    
                        JOptionPane.showMessageDialog(null, "failed");
                         pst=conn.prepareStatement(insert);
                         pst.setString(1,dt);
                         pst.setString(2,item);
                         pst.setInt(3,Integer.parseInt(t115.getText()));
                         pst.setDouble(4,Double.parseDouble(t161.getText()));
                         pst.execute();
                          JOptionPane.showMessageDialog(null, "new Added");
                    }
            }catch(Exception e){ JOptionPane.showMessageDialog(null, e);
            }
            
         try{
            String n31=String.valueOf(cnt1.getText());
            String n2=ldt.getText();
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
         
         try{
            String n31=String.valueOf(cnt1.getText());
            String n2=ldt.getText();
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
         
       
       
  t115.setText("");
        t114.setText("0");
      t161.setText("0");
        cb2.setSelectedIndex(0);
    tfclose();
        clear();
        onload();
        fetchcno();
 
// TODO add your handling code here:
    }//GEN-LAST:event_okbActionPerformed

    private void okb1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okb1ActionPerformed

        int total,x1=0,y1=0;
        String a =t116.getText();
        String b=t117.getText();
        int a1  =Integer.parseInt(a);
        int b1 =Integer.parseInt(b);
        int cnt  =Integer.parseInt(cnt1.getText());
      
            total=a1*b1;
        y1=total+cnt;

        String str=String.valueOf(total);
        cnt1.setText(""+y1);

        t161.setText(""+str);    
             
        tt1.append(""+cb3.getSelectedItem()+":"+t116.getText()+"\t"+t117.getText()+"\t"+t157.getText()+"\n");
        try{
                 Date  date= new Date();
                  SimpleDateFormat s= new SimpleDateFormat("dd-MM-yyyy");
                 String dt=s.format(date);
                 String item=cb3.getSelectedItem().toString();
                 String select="SELECT date, item, quntity,rupees\n" +
"	FROM public.\"ItemSell\" WHERE date=? AND item=?";
                 
                 String insert="INSERT INTO public.\"ItemSell\"(\n" +
"	date, item, quntity, rupees)\n" +
"	VALUES (?, ?, ?, ?);";
                  pst=conn.prepareStatement(select);
                 pst.setString(1,dt);
                 pst.setString(2,item);
                 rs=pst.executeQuery();
                 if(rs.next())
                 {    String qt=rs.getString(3);
                     String st=rs.getString(4);
                    
                   int aa=Integer.valueOf(qt);
                   int bb=Integer.valueOf(t116.getText());
                   int cc=aa+bb;
                    double ff,ee=0.0;
                   String dd=rs.getString(4);
                    ee=Double.valueOf(dd);
                    ff=Double.valueOf(t157.getText());
                    double gg=ee+ff;
                  
                     pst=conn.prepareStatement("UPDATE public.\"ItemSell\"\n" +
"	SET  quntity='"+cc+"'  , rupees='"+gg+"'  \n" +
"	WHERE  item='"+item+"' AND date='"+dt+"'  ;");
                        pst.execute();
                         JOptionPane.showMessageDialog(null, "updated");
                          }else{                    
                        JOptionPane.showMessageDialog(null, "failed");
                         pst=conn.prepareStatement(insert);
                         pst.setString(1,dt);
                         pst.setString(2,item);
                         pst.setInt(3,Integer.parseInt(t116.getText()));
                         pst.setDouble(4,Double.parseDouble(t157.getText()));
                         pst.execute();
                          JOptionPane.showMessageDialog(null, "new Added");
                    }
            }catch(Exception e){ JOptionPane.showMessageDialog(null, e);
            }
        
      
           t116.setText("");
        t117.setText("0");
        t157.setText("0");
        cb3.setSelectedIndex(0);
          
          
          
        
       
        // TODO add your handling code here:
    }//GEN-LAST:event_okb1ActionPerformed

    private void cb2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cb2KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_cb2KeyReleased

    private void cb2PopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cb2PopupMenuWillBecomeInvisible
         String a=cb2.getSelectedItem().toString();
                String sql=" SELECT menu, rate\n" +
                "	FROM public.\"Rate\"WHERE menu=?        ; ";
            
            try{
               
                pst=conn.prepareStatement(sql);
                pst.setString(1, a);
                rs= pst.executeQuery();
                if(rs.next())
                {
                    t114.enable(true);
                    t114.setText(rs.getString(2));
                }
            }catch(Exception e)
            {
                JOptionPane.showMessageDialog(null, e);
            };
            
            t115.enable(true);
            t115.requestFocus();

        


        // TODO add your handling code here:
    }//GEN-LAST:event_cb2PopupMenuWillBecomeInvisible

    private void cb3PopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cb3PopupMenuWillBecomeInvisible
 String a=cb3.getSelectedItem().toString();
                String sql=" SELECT menu, rate\n" +
                "	FROM public.\"Rate\"WHERE menu=?        ; ";
            
            try{
               
                pst=conn.prepareStatement(sql);
                pst.setString(1, a);
                rs= pst.executeQuery();
                if(rs.next())
                {
                    t117.enable(true);
                    t117.setText(rs.getString(2));
                }
            }catch(Exception e)
            {
                JOptionPane.showMessageDialog(null, e);
            };
            t116.enable(true);
            t116.requestFocus();
        // TODO add your handling code here:
    }//GEN-LAST:event_cb3PopupMenuWillBecomeInvisible

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked

//        Add_Customer ac=new Add_Customer();
//        this.add(ac);
//        ac.show();
//        ac.moveToFront();
       CAdd la=new CAdd();
       dp1.add(la);
       la.show();
       la.setSize(295, 388);
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked

         rateIF la=new rateIF();
       dp1.add(la);
       la.show();
       la.setSize(294, 156);
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
    
        
        
    }//GEN-LAST:event_jLabel4MouseClicked

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked

 ConnectDB c=new ConnectDB();
        try{
     String dt=ldt.getText().toString();
     String query="SELECT cno, date, total\n" +
"	FROM public.\"Total\" WHERE date='"+dt+"';";
      JDBCCategoryDataset dataset=new JDBCCategoryDataset(c.getConn(),query);
      
      JFreeChart jc= ChartFactory.createLineChart("Report Chart", "rs", "total", dataset, PlotOrientation.VERTICAL, false, true, true);
      BarRenderer renderer=null;
      CategoryPlot plot=null;
      renderer=new BarRenderer();
      
ChartFrame cf= new ChartFrame("record Report",jc,true);
        cf.setVisible(true);
        cf.setSize(1300,600);   
        cf.setLocation(40,70);
  }catch(Exception e)
  {
JOptionPane.showMessageDialog(null, e);
  }

        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel5MouseClicked

    private void t205ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t205ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t205ActionPerformed

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
this.dispose();
// TODO add your handling code here:
    }//GEN-LAST:event_jLabel1MouseClicked

    private void cb4PopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cb4PopupMenuWillBecomeInvisible
        // TODO add your handling code here:
    }//GEN-LAST:event_cb4PopupMenuWillBecomeInvisible

    private void cb4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cb4MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_cb4MouseClicked

    private void cb4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cb4ActionPerformed

    private void cb4KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cb4KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_cb4KeyPressed

    private void cb4KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cb4KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_cb4KeyReleased

    private void t158ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t158ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t158ActionPerformed

    private void t158KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t158KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_t158KeyPressed

    private void t158KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t158KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t158KeyReleased

    private void t158KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t158KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_t158KeyTyped

    private void t159ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t159ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t159ActionPerformed

    private void t160FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_t160FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_t160FocusGained

    private void t160ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t160ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t160ActionPerformed

    private void okb2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okb2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_okb2ActionPerformed

    private void t2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t2KeyTyped
char c=evt.getKeyChar();
        if(!(Character.isDigit(c)) || (c==KeyEvent.VK_ENTER) ||(c==KeyEvent.VK_BACK_SPACE)   ){
            evt.consume();}        // TODO add your handling code here:
    }//GEN-LAST:event_t2KeyTyped

    private void t3KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t3KeyTyped
char c=evt.getKeyChar();
        if(!(Character.isDigit(c)) || (c==KeyEvent.VK_ENTER) ||(c==KeyEvent.VK_BACK_SPACE)   ){
            evt.consume();}        // TODO add your handling code here:
    }//GEN-LAST:event_t3KeyTyped

    private void t4KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t4KeyTyped
char c=evt.getKeyChar();
        if(!(Character.isDigit(c)) || (c==KeyEvent.VK_ENTER) ||(c==KeyEvent.VK_BACK_SPACE)   ){
            evt.consume();}        // TODO add your handling code here:
    }//GEN-LAST:event_t4KeyTyped

    private void t5KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t5KeyTyped
char c=evt.getKeyChar();
        if(!(Character.isDigit(c)) || (c==KeyEvent.VK_ENTER) ||(c==KeyEvent.VK_BACK_SPACE)   ){
            evt.consume();}        // TODO add your handling code here:
    }//GEN-LAST:event_t5KeyTyped

    private void t6KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t6KeyTyped
char c=evt.getKeyChar();
        if(!(Character.isDigit(c)) || (c==KeyEvent.VK_ENTER) ||(c==KeyEvent.VK_BACK_SPACE)   ){
            evt.consume();}        // TODO add your handling code here:
    }//GEN-LAST:event_t6KeyTyped

    private void t9KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t9KeyTyped
char c=evt.getKeyChar();
        if(!(Character.isDigit(c)) || (c==KeyEvent.VK_ENTER) ||(c==KeyEvent.VK_BACK_SPACE)   ){
            evt.consume();}        // TODO add your handling code here:
    }//GEN-LAST:event_t9KeyTyped

    private void t13KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t13KeyTyped
char c=evt.getKeyChar();
        if(!(Character.isDigit(c)) || (c==KeyEvent.VK_ENTER) ||(c==KeyEvent.VK_BACK_SPACE)   ){
            evt.consume();}        // TODO add your handling code here:
    }//GEN-LAST:event_t13KeyTyped

    private void t7KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t7KeyTyped
char c=evt.getKeyChar();
        if(!(Character.isDigit(c)) || (c==KeyEvent.VK_ENTER) ||(c==KeyEvent.VK_BACK_SPACE)   ){
            evt.consume();}        // TODO add your handling code here:
    }//GEN-LAST:event_t7KeyTyped

    private void t8KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t8KeyTyped
char c=evt.getKeyChar();
        if(!(Character.isDigit(c)) || (c==KeyEvent.VK_ENTER) ||(c==KeyEvent.VK_BACK_SPACE)   ){
            evt.consume();}        // TODO add your handling code here:
    }//GEN-LAST:event_t8KeyTyped

    private void t20KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t20KeyTyped
char c=evt.getKeyChar();
        if(!(Character.isDigit(c)) || (c==KeyEvent.VK_ENTER) ||(c==KeyEvent.VK_BACK_SPACE)   ){
            evt.consume();}        // TODO add your handling code here:
    }//GEN-LAST:event_t20KeyTyped

    private void t12KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t12KeyTyped
char c=evt.getKeyChar();
        if(!(Character.isDigit(c)) || (c==KeyEvent.VK_ENTER) ||(c==KeyEvent.VK_BACK_SPACE)   ){
            evt.consume();}        // TODO add your handling code here:
    }//GEN-LAST:event_t12KeyTyped

    private void t11KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t11KeyTyped
char c=evt.getKeyChar();
        if(!(Character.isDigit(c)) || (c==KeyEvent.VK_ENTER) ||(c==KeyEvent.VK_BACK_SPACE)   ){
            evt.consume();}        // TODO add your handling code here:
    }//GEN-LAST:event_t11KeyTyped

    private void t21KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t21KeyTyped
char c=evt.getKeyChar();
        if(!(Character.isDigit(c)) || (c==KeyEvent.VK_ENTER) ||(c==KeyEvent.VK_BACK_SPACE)   ){
            evt.consume();}        // TODO add your handling code here:
    }//GEN-LAST:event_t21KeyTyped

    private void t22KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t22KeyTyped
char c=evt.getKeyChar();
        if(!(Character.isDigit(c)) || (c==KeyEvent.VK_ENTER) ||(c==KeyEvent.VK_BACK_SPACE)   ){
            evt.consume();}        // TODO add your handling code here:
    }//GEN-LAST:event_t22KeyTyped

    private void t47KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t47KeyTyped
char c=evt.getKeyChar();
        if(!(Character.isDigit(c)) || (c==KeyEvent.VK_ENTER) ||(c==KeyEvent.VK_BACK_SPACE)   ){
            evt.consume();}        // TODO add your handling code here:
    }//GEN-LAST:event_t47KeyTyped

    private void t48KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t48KeyTyped
char c=evt.getKeyChar();
        if(!(Character.isDigit(c)) || (c==KeyEvent.VK_ENTER) ||(c==KeyEvent.VK_BACK_SPACE)   ){
            evt.consume();}        // TODO add your handling code here:
    }//GEN-LAST:event_t48KeyTyped

    private void t49KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t49KeyTyped
char c=evt.getKeyChar();
        if(!(Character.isDigit(c)) || (c==KeyEvent.VK_ENTER) ||(c==KeyEvent.VK_BACK_SPACE)   ){
            evt.consume();}        // TODO add your handling code here:
    }//GEN-LAST:event_t49KeyTyped

    private void t50KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t50KeyTyped
char c=evt.getKeyChar();
        if(!(Character.isDigit(c)) || (c==KeyEvent.VK_ENTER) ||(c==KeyEvent.VK_BACK_SPACE)   ){
            evt.consume();}        // TODO add your handling code here:
    }//GEN-LAST:event_t50KeyTyped

    private void t51KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t51KeyTyped
char c=evt.getKeyChar();
        if(!(Character.isDigit(c)) || (c==KeyEvent.VK_ENTER) ||(c==KeyEvent.VK_BACK_SPACE)   ){
            evt.consume();}        // TODO add your handling code here:
    }//GEN-LAST:event_t51KeyTyped

    private void t52KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t52KeyTyped
char c=evt.getKeyChar();
        if(!(Character.isDigit(c)) || (c==KeyEvent.VK_ENTER) ||(c==KeyEvent.VK_BACK_SPACE)   ){
            evt.consume();}        // TODO add your handling code here:
    }//GEN-LAST:event_t52KeyTyped

    private void t53KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t53KeyTyped
char c=evt.getKeyChar();
        if(!(Character.isDigit(c)) || (c==KeyEvent.VK_ENTER) ||(c==KeyEvent.VK_BACK_SPACE)   ){
            evt.consume();}        // TODO add your handling code here:
    }//GEN-LAST:event_t53KeyTyped

    private void t54KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t54KeyTyped
char c=evt.getKeyChar();
        if(!(Character.isDigit(c)) || (c==KeyEvent.VK_ENTER) ||(c==KeyEvent.VK_BACK_SPACE)   ){
            evt.consume();}        // TODO add your handling code here:
    }//GEN-LAST:event_t54KeyTyped

    private void t41KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t41KeyTyped
char c=evt.getKeyChar();
        if(!(Character.isDigit(c)) || (c==KeyEvent.VK_ENTER) ||(c==KeyEvent.VK_BACK_SPACE)   ){
            evt.consume();}        // TODO add your handling code here:
    }//GEN-LAST:event_t41KeyTyped

    private void t42KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t42KeyTyped
char c=evt.getKeyChar();
        if(!(Character.isDigit(c)) || (c==KeyEvent.VK_ENTER) ||(c==KeyEvent.VK_BACK_SPACE)   ){
            evt.consume();}        // TODO add your handling code here:
    }//GEN-LAST:event_t42KeyTyped

    private void t43KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t43KeyTyped
char c=evt.getKeyChar();
        if(!(Character.isDigit(c)) || (c==KeyEvent.VK_ENTER) ||(c==KeyEvent.VK_BACK_SPACE)   ){
            evt.consume();}        // TODO add your handling code here:
    }//GEN-LAST:event_t43KeyTyped

    private void t44KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t44KeyTyped
char c=evt.getKeyChar();
        if(!(Character.isDigit(c)) || (c==KeyEvent.VK_ENTER) ||(c==KeyEvent.VK_BACK_SPACE)   ){
            evt.consume();}        // TODO add your handling code here:
    }//GEN-LAST:event_t44KeyTyped

    private void t45KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t45KeyTyped
char c=evt.getKeyChar();
        if(!(Character.isDigit(c)) || (c==KeyEvent.VK_ENTER) ||(c==KeyEvent.VK_BACK_SPACE)   ){
            evt.consume();}        // TODO add your handling code here:
    }//GEN-LAST:event_t45KeyTyped

    private void t46KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t46KeyTyped
char c=evt.getKeyChar();
        if(!(Character.isDigit(c)) || (c==KeyEvent.VK_ENTER) ||(c==KeyEvent.VK_BACK_SPACE)   ){
            evt.consume();}        // TODO add your handling code here:
    }//GEN-LAST:event_t46KeyTyped

    private void t60KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t60KeyTyped
char c=evt.getKeyChar();
        if(!(Character.isDigit(c)) || (c==KeyEvent.VK_ENTER) ||(c==KeyEvent.VK_BACK_SPACE)   ){
            evt.consume();}        // TODO add your handling code here:
    }//GEN-LAST:event_t60KeyTyped

    private void t58KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t58KeyTyped
char c=evt.getKeyChar();
        if(!(Character.isDigit(c)) || (c==KeyEvent.VK_ENTER) ||(c==KeyEvent.VK_BACK_SPACE)   ){
            evt.consume();}        // TODO add your handling code here:
    }//GEN-LAST:event_t58KeyTyped

    private void t67KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t67KeyTyped
char c=evt.getKeyChar();
        if(!(Character.isDigit(c)) || (c==KeyEvent.VK_ENTER) ||(c==KeyEvent.VK_BACK_SPACE)   ){
            evt.consume();}        // TODO add your handling code here:
    }//GEN-LAST:event_t67KeyTyped

    private void t34KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t34KeyTyped
char c=evt.getKeyChar();
        if(!(Character.isDigit(c)) || (c==KeyEvent.VK_ENTER) ||(c==KeyEvent.VK_BACK_SPACE)   ){
            evt.consume();}        // TODO add your handling code here:
    }//GEN-LAST:event_t34KeyTyped

    private void t35KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t35KeyTyped
char c=evt.getKeyChar();
        if(!(Character.isDigit(c)) || (c==KeyEvent.VK_ENTER) ||(c==KeyEvent.VK_BACK_SPACE)   ){
            evt.consume();}        // TODO add your handling code here:
    }//GEN-LAST:event_t35KeyTyped

    private void t36KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t36KeyTyped
char c=evt.getKeyChar();
        if(!(Character.isDigit(c)) || (c==KeyEvent.VK_ENTER) ||(c==KeyEvent.VK_BACK_SPACE)   ){
            evt.consume();}        // TODO add your handling code here:
    }//GEN-LAST:event_t36KeyTyped

    private void t37KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t37KeyTyped
char c=evt.getKeyChar();
        if(!(Character.isDigit(c)) || (c==KeyEvent.VK_ENTER) ||(c==KeyEvent.VK_BACK_SPACE)   ){
            evt.consume();}        // TODO add your handling code here:
    }//GEN-LAST:event_t37KeyTyped

    private void t38KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t38KeyTyped
char c=evt.getKeyChar();
        if(!(Character.isDigit(c)) || (c==KeyEvent.VK_ENTER) ||(c==KeyEvent.VK_BACK_SPACE)   ){
            evt.consume();}        // TODO add your handling code here:
    }//GEN-LAST:event_t38KeyTyped

    private void t39KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t39KeyTyped
char c=evt.getKeyChar();
        if(!(Character.isDigit(c)) || (c==KeyEvent.VK_ENTER) ||(c==KeyEvent.VK_BACK_SPACE)   ){
            evt.consume();}        // TODO add your handling code here:
    }//GEN-LAST:event_t39KeyTyped

    private void t40KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t40KeyTyped
char c=evt.getKeyChar();
        if(!(Character.isDigit(c)) || (c==KeyEvent.VK_ENTER) ||(c==KeyEvent.VK_BACK_SPACE)   ){
            evt.consume();}        // TODO add your handling code here:
    }//GEN-LAST:event_t40KeyTyped

    private void t112KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t112KeyTyped
char c=evt.getKeyChar();
        if(!(Character.isDigit(c)) || (c==KeyEvent.VK_ENTER) ||(c==KeyEvent.VK_BACK_SPACE)   ){
            evt.consume();}        // TODO add your handling code here:
    }//GEN-LAST:event_t112KeyTyped

    private void t118KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t118KeyTyped
char c=evt.getKeyChar();
        if(!(Character.isDigit(c)) || (c==KeyEvent.VK_ENTER) ||(c==KeyEvent.VK_BACK_SPACE)   ){
            evt.consume();}        // TODO add your handling code here:
    }//GEN-LAST:event_t118KeyTyped

    private void t119KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t119KeyTyped
char c=evt.getKeyChar();
        if(!(Character.isDigit(c)) || (c==KeyEvent.VK_ENTER) ||(c==KeyEvent.VK_BACK_SPACE)   ){
            evt.consume();}        // TODO add your handling code here:
    }//GEN-LAST:event_t119KeyTyped

    private void t120KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t120KeyTyped
char c=evt.getKeyChar();
        if(!(Character.isDigit(c)) || (c==KeyEvent.VK_ENTER) ||(c==KeyEvent.VK_BACK_SPACE)   ){
            evt.consume();}        // TODO add your handling code here:
    }//GEN-LAST:event_t120KeyTyped

    private void t121KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t121KeyTyped
char c=evt.getKeyChar();
        if(!(Character.isDigit(c)) || (c==KeyEvent.VK_ENTER) ||(c==KeyEvent.VK_BACK_SPACE)   ){
            evt.consume();}        // TODO add your handling code here:
    }//GEN-LAST:event_t121KeyTyped

    private void t122KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t122KeyTyped
char c=evt.getKeyChar();
        if(!(Character.isDigit(c)) || (c==KeyEvent.VK_ENTER) ||(c==KeyEvent.VK_BACK_SPACE)   ){
            evt.consume();}        // TODO add your handling code here:
    }//GEN-LAST:event_t122KeyTyped

    private void t123KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t123KeyTyped
char c=evt.getKeyChar();
        if(!(Character.isDigit(c)) || (c==KeyEvent.VK_ENTER) ||(c==KeyEvent.VK_BACK_SPACE)   ){
            evt.consume();}        // TODO add your handling code here:
    }//GEN-LAST:event_t123KeyTyped

    private void t132KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t132KeyTyped
char c=evt.getKeyChar();
        if(!(Character.isDigit(c)) || (c==KeyEvent.VK_ENTER) ||(c==KeyEvent.VK_BACK_SPACE)   ){
            evt.consume();}        // TODO add your handling code here:
    }//GEN-LAST:event_t132KeyTyped

    private void t133KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t133KeyTyped
char c=evt.getKeyChar();
        if(!(Character.isDigit(c)) || (c==KeyEvent.VK_ENTER) ||(c==KeyEvent.VK_BACK_SPACE)   ){
            evt.consume();}        // TODO add your handling code here:
    }//GEN-LAST:event_t133KeyTyped

    private void t135KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t135KeyTyped
char c=evt.getKeyChar();
        if(!(Character.isDigit(c)) || (c==KeyEvent.VK_ENTER) ||(c==KeyEvent.VK_BACK_SPACE)   ){
            evt.consume();}        // TODO add your handling code here:
    }//GEN-LAST:event_t135KeyTyped

    private void t136KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t136KeyTyped
char c=evt.getKeyChar();
        if(!(Character.isDigit(c)) || (c==KeyEvent.VK_ENTER) ||(c==KeyEvent.VK_BACK_SPACE)   ){
            evt.consume();}        // TODO add your handling code here:
    }//GEN-LAST:event_t136KeyTyped

    private void t137KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t137KeyTyped
char c=evt.getKeyChar();
        if(!(Character.isDigit(c)) || (c==KeyEvent.VK_ENTER) ||(c==KeyEvent.VK_BACK_SPACE)   ){
            evt.consume();}        // TODO add your handling code here:
    }//GEN-LAST:event_t137KeyTyped

    private void t138KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t138KeyTyped
char c=evt.getKeyChar();
        if(!(Character.isDigit(c)) || (c==KeyEvent.VK_ENTER) ||(c==KeyEvent.VK_BACK_SPACE)   ){
            evt.consume();}        // TODO add your handling code here:
    }//GEN-LAST:event_t138KeyTyped

    private void t139KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t139KeyTyped
char c=evt.getKeyChar();
        if(!(Character.isDigit(c)) || (c==KeyEvent.VK_ENTER) ||(c==KeyEvent.VK_BACK_SPACE)   ){
            evt.consume();}        // TODO add your handling code here:
    }//GEN-LAST:event_t139KeyTyped

    private void t140KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t140KeyTyped
char c=evt.getKeyChar();
        if(!(Character.isDigit(c)) || (c==KeyEvent.VK_ENTER) ||(c==KeyEvent.VK_BACK_SPACE)   ){
            evt.consume();}        // TODO add your handling code here:
    }//GEN-LAST:event_t140KeyTyped

    private void t141KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t141KeyTyped
char c=evt.getKeyChar();
        if(!(Character.isDigit(c)) || (c==KeyEvent.VK_ENTER) ||(c==KeyEvent.VK_BACK_SPACE)   ){
            evt.consume();}        // TODO add your handling code here:
    }//GEN-LAST:event_t141KeyTyped

    private void t142KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t142KeyTyped
char c=evt.getKeyChar();
        if(!(Character.isDigit(c)) || (c==KeyEvent.VK_ENTER) ||(c==KeyEvent.VK_BACK_SPACE)   ){
            evt.consume();}        // TODO add your handling code here:
    }//GEN-LAST:event_t142KeyTyped

    private void t143KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t143KeyTyped
char c=evt.getKeyChar();
        if(!(Character.isDigit(c)) || (c==KeyEvent.VK_ENTER) ||(c==KeyEvent.VK_BACK_SPACE)   ){
            evt.consume();}        // TODO add your handling code here:
    }//GEN-LAST:event_t143KeyTyped

    private void t144KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t144KeyTyped
char c=evt.getKeyChar();
        if(!(Character.isDigit(c)) || (c==KeyEvent.VK_ENTER) ||(c==KeyEvent.VK_BACK_SPACE)   ){
            evt.consume();}        // TODO add your handling code here:
    }//GEN-LAST:event_t144KeyTyped

    private void t145KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t145KeyTyped
char c=evt.getKeyChar();
        if(!(Character.isDigit(c)) || (c==KeyEvent.VK_ENTER) ||(c==KeyEvent.VK_BACK_SPACE)   ){
            evt.consume();}        // TODO add your handling code here:
    }//GEN-LAST:event_t145KeyTyped

    private void t146KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t146KeyTyped
char c=evt.getKeyChar();
        if(!(Character.isDigit(c)) || (c==KeyEvent.VK_ENTER) ||(c==KeyEvent.VK_BACK_SPACE)   ){
            evt.consume();}        // TODO add your handling code here:
    }//GEN-LAST:event_t146KeyTyped

    private void t147KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t147KeyTyped
char c=evt.getKeyChar();
        if(!(Character.isDigit(c)) || (c==KeyEvent.VK_ENTER) ||(c==KeyEvent.VK_BACK_SPACE)   ){
            evt.consume();}        // TODO add your handling code here:
    }//GEN-LAST:event_t147KeyTyped

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
today_report la=new today_report();
       dp1.add(la);
       la.show();
       la.setSize(885, 541); 
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel6MouseClicked

    private void t161FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_t161FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_t161FocusGained

    private void t161ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t161ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t161ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Bill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Bill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Bill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Bill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Bill().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton b4;
    private javax.swing.JComboBox<String> cb2;
    private javax.swing.JComboBox<String> cb3;
    private javax.swing.JComboBox<String> cb4;
    private javax.swing.JTextField cnt1;
    public javax.swing.JDesktopPane dp1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton6;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
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
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private static javax.swing.JLabel l0;
    public javax.swing.JLabel l2;
    private javax.swing.JLabel l7;
    public javax.swing.JLabel ldt;
    private javax.swing.JButton okb;
    private javax.swing.JButton okb1;
    private javax.swing.JButton okb2;
    private javax.swing.JRadioButton rb1;
    private javax.swing.JRadioButton rb10;
    private javax.swing.JRadioButton rb11;
    private javax.swing.JRadioButton rb12;
    private javax.swing.JRadioButton rb13;
    private javax.swing.JRadioButton rb14;
    private javax.swing.JRadioButton rb15;
    private javax.swing.JRadioButton rb16;
    private javax.swing.JRadioButton rb2;
    private javax.swing.JRadioButton rb3;
    private javax.swing.JRadioButton rb32;
    private javax.swing.JRadioButton rb33;
    private javax.swing.JRadioButton rb34;
    private javax.swing.JRadioButton rb35;
    private javax.swing.JRadioButton rb36;
    private javax.swing.JRadioButton rb37;
    private javax.swing.JRadioButton rb38;
    private javax.swing.JRadioButton rb39;
    private javax.swing.JRadioButton rb40;
    private javax.swing.JRadioButton rb41;
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
    private javax.swing.JTextField t11;
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
    private javax.swing.JTextField t150;
    private javax.swing.JTextField t151;
    private javax.swing.JTextField t152;
    private javax.swing.JTextField t153;
    private javax.swing.JTextField t154;
    private javax.swing.JTextField t155;
    private javax.swing.JTextField t157;
    private javax.swing.JTextField t158;
    private javax.swing.JTextField t159;
    private javax.swing.JTextField t160;
    private javax.swing.JTextField t161;
    private javax.swing.JTextField t2;
    private javax.swing.JTextField t20;
    private javax.swing.JTextField t204;
    private javax.swing.JTextField t205;
    private javax.swing.JTextField t21;
    private javax.swing.JTextField t22;
    private javax.swing.JTextField t3;
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
    private javax.swing.JTextField t8;
    private javax.swing.JTextField t9;
    private javax.swing.JTabbedPane tbp1;
    private javax.swing.JTextArea tt1;
    // End of variables declaration//GEN-END:variables
}
