import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class Anomaly 
{
Connection con;
Statement st;
ResultSet rs,rs1;

public Anomaly(String user,String pass,int h)
{System.out.println("in anomaly");
connect();
try
{
System.out.println("in try");
String sql = "select LogCount from login where user = '"+user+"' and pass = '"+pass+"'";
rs = st.executeQuery(sql);
System.out.println(rs.next());
String str=rs.getString(1);
System.out.println("Logcount " + str);
int i = Integer.parseInt(str);
System.out.println(i);
if(i==1)
{
String sq="UPDATE login SET height='"+h+"' where user='"+user+"'";
int j = st.executeUpdate( sq);
}

else 
{
System.out.println("in else");
String s = "select height from login where user = '"+user+"' and pass = '"+pass+"'";
rs1 = st.executeQuery(s);
System.out.println(rs1.next());
String str1=rs1.getString(1);
System.out.println("height " + str1);
int j = Integer.parseInt(str1);
if(h>j)
{
JOptionPane.showMessageDialog(null, "Anomaly Detected");
}
}
}
catch(Exception e){}


}

public void connect()
	{
		try
		{
		System.out.println("in connect");
		String driver="sun.jdbc.odbc.JdbcOdbcDriver";
		Class.forName(driver);
		
		String db="jdbc:odbc:db1";
		con = DriverManager.getConnection(db);
		st = con.createStatement();
		
		
		}
		catch (Exception ex)
		{
			
		}
		
		
	}
}