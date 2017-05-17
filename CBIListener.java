
	import java.awt.*;
	import java.awt.event.*;
	import javax.swing.*;
	 
	public class CBIListener implements ItemListener
	{
	String user1,pass1;
	  JFrame frame;
	  JCheckBox checkBoxArray[] = new JCheckBox[16];
	  JTextField textField;
	  JLabel label;
	  JPanel panel;
	  CBIListener(String user,String pass)
	  {
	user1=user;pass1=pass;
	    frame = new JFrame("JCheckBox Event Handling");
	    frame.setLayout(new GridLayout(4,4));
	    panel = new JPanel();
	    checkBoxArray[0] = new JCheckBox("ls"); 
	    checkBoxArray[1] = new JCheckBox("cd");
	    checkBoxArray[2] = new JCheckBox("cp");
	checkBoxArray[3] = new JCheckBox("who");
	checkBoxArray[4] = new JCheckBox("wc");
	checkBoxArray[5] = new JCheckBox("vim");
	checkBoxArray[6] = new JCheckBox("joe");
	checkBoxArray[7] = new JCheckBox("rm");
	checkBoxArray[8] = new JCheckBox("ls-l");
	checkBoxArray[9] = new JCheckBox("talk");
	    for(int i = 0; i<10; i++)
	    {
	       panel.add(checkBoxArray[i]);
	       checkBoxArray[i].addItemListener(this);
	    }
	    textField = new JTextField(20);
	    label = new JLabel("Select the command " +
	         "you want to use : ", JLabel.CENTER);
	    frame.add(label);  
	    frame.add(panel);   
	    frame.add(textField);
	    //frame.pack();
	    frame.setVisible(true);
		frame.setSize(500,500);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  }

	  public void itemStateChanged(ItemEvent ie)
	  {
	    String message=""; 
	    for(int i=0; i<10; i++)
	    {
	     if(checkBoxArray[i].isSelected())
	       message += checkBoxArray[i].getText() + "  ";

	}
	
	    textField.setText(message);
	STokenizer st=new STokenizer(user1,pass1,message);
  	}

}

