package com.client;
import javax.swing.*;
import java.awt.*;
public class GameRule extends JPanel{
	
	Image back;
	JButton b1;//버튼     
	public GameRule()
	{	

		back = Toolkit.getDefaultToolkit().getImage("image/gr.png");
	
		b1=new JButton("돌아가기 >>");
		
		setLayout(null);
		
		b1.setBounds(630,450,100,50);
		b1.setOpaque(true);
	
		
		 add(b1);
		
		
	}
	@Override	//
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(back, 0, 0, getWidth(), getHeight(), this);
	}
}