package CAB_BOOKING;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;

public class View_Truck_Details extends JFrame {
    Font f;
  JTable t;
    String x[]={"BookId","Username","Name","Drivername","Source","Destination","Weight","Truck","Distance","Price"};
    String y[][]=new String [20][10];
    int i=0,j=0;

    View_Truck_Details()
    {

        super("Truck Records");
        setSize(1300,400);
        setLocation(0,10);
        f=new Font("MS UI Gothic",Font.BOLD,17);

        //create Connection
        try
        {
            Connection_Class obj=new Connection_Class();
            String q="select * from transport";
            ResultSet set=obj.stmt.executeQuery(q);

            while (set.next())
            {
                y[i][j++]=set.getString("BookId");
                y[i][j++]=set.getString("Username");
                y[i][j++]=set.getString("Name");
                y[i][j++]=set.getString("Drivername");
                y[i][j++]=set.getString("Source");
                y[i][j++]=set.getString("Destination");
                y[i][j++]=set.getString("Weight");
                y[i][j++]=set.getString("Truck");
                y[i][j++]=set.getString("Distance");
                y[i][j++]=set.getString("Price");
                i++;
                j=0;
            }
            t=new JTable(y,x);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        t.setFont(f);
        t.setBackground(Color.BLACK);
        t.setForeground(Color.WHITE);
        JScrollPane js=new JScrollPane(t);
        add(js);

    }

    public static void main(String[] args)
    {
       new View_Truck_Details().setVisible(true);
    }
}
