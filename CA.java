import javax.swing.*;
import java.awt.event.*;
import java.sql.*;


		public class CA 
		{


		Connection con;
		Statement st;
		ResultSet rs;
		
		JFrame f = new JFrame("Create Account");
		JLabel l = new JLabel("Username");
		JLabel l1 = new JLabel ("Password");
		JTextField t = new JTextField(10);
		JTextField t1 = new JPasswordField(10);
		JButton b = new JButton("save");
		JButton c = new JButton("exit");
		public CA()
		{
			connect();
			frame();
			
		}
		
		public void connect()
		{
			try
			{
				
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
		
		public void frame()
		{
			f.setSize(600, 400);
			f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			f.setVisible(true);
			
			JPanel p = new JPanel();
			p.add(l);
			p.add(t);
			p.add(l1);
			p.add(t1);
			p.add(b);
			p.add(c);
			f.add(p);
			
			
			
			b.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e)
				{
					try
					{
					String user = t.getText().trim();
					String pass = t1.getText().trim();
					System.out.println(user);
					System.out.println(pass);
					
					int i = st.executeUpdate("insert into login(user,pass,height,LogCount) values('"+user+"','"+pass+"',0,0)" );
					
					JOptionPane.showMessageDialog(null, " data succefully saved!");
										
					}
					catch(Exception ex)
					{
						
					}
					
						
				}
			});
			c.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent ae){
								f.setVisible(false);
				}
				});
			
	}
		
		public static void main(String[] args) {
			new CA();

		}




}
