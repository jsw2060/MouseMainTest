package com.client;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;

public class CreateRoom extends JPanel{
	Image back;
	JTable table1, table2;
	DefaultTableModel model1, model2;
	JTextArea ta;
	JTextField tf;
	JComboBox box;
	JButton b1, b2, b3, b4, b5, b6, b7;
	JLabel la1, la2;
	
	public CreateRoom(){
		back=Toolkit.getDefaultToolkit().getImage("C:\\image\\back.png");
		tf=new JTextField();
		box=new JComboBox();
		box.addItem("user vs com");
		box.addItem("user vs user");
		la1 = new JLabel("방제목");
		la2 = new JLabel("인원");
		
		b1=new JButton("생성");
		
		setLayout(null);
		la1.setBounds(280, 250, 120, 30);
		la2.setBounds(280, 300, 120, 30);
		tf.setBounds(350, 250, 150, 30);
		box.setBounds(350, 300, 120, 30);
		b1.setBounds(320, 350, 85, 30);
		
		add(tf);
		add(b1);
		add(la1);
		add(la2);
		add(box);
	
	}
	
	protected void paintComponent(Graphics g) {
		//창에 그림 입히는 것-skin 입힐때는 꼭 paintComponet 쓰자 paint 쓰지 말 것
		g.drawImage(back, 0, 0, getWidth(),getHeight(),this);
	}
}