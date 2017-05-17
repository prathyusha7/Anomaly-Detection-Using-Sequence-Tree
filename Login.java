import javax.swing.*;
import java.awt.event.*;
import java.sql.*;


public class Login {
	Connection con;
	Statement st;
	ResultSet rs;
	
	JFrame f = new JFrame("User Login");
	JLabel l = new JLabel("Username");
	JLabel l1 = new JLabel ("Password");
	JTextField t = new JTextField(10);
	JTextField t1 = new JPasswordField(10);
	JButton b = new JButton("login");
	JButton c = new JButton("create account");
	public Login()
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
				
				String sql = "select user,pass from login where user = '"+user+"' and pass = '"+pass+"'";
				rs = st.executeQuery(sql);
				
				int count=0;
				while(rs.next())
				{
					count = count + 1;
				}
				
				if(count == 1)
				{
										
					String sq="UPDATE login SET LogCount=LogCount+1 where user='"+user+"'";
					int j = st.executeUpdate( sq);


					JOptionPane.showMessageDialog(null, " user found , access granted");
					f.setVisible(false);    
					CBIListener next=new CBIListener(user,pass);

				}
				else
				{
					JOptionPane.showMessageDialog(null,"user not found!");
				}
				
				
				}
				catch(Exception ex)
				{
					
				}
				
					
			}
		});
		c.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
			CA account=new CA();
			//account.setVisible(true);
			}
			});
		
}
	
	public static void main(String[] args) {
		new Login();

	}

}
