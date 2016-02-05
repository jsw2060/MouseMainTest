package com.client;
import javax.swing.*;
import java.awt.*;
public class GameRule extends JPanel{
	
	Image back, img;		//마우스 그림 추가
	JButton b1;//버튼     
	Cursor cursor;			//커서 추가
	
	
	
	public GameRule()
	{	
		//마우스 그림 초기화
		img=Toolkit.getDefaultToolkit().getImage("image/01.png");
		cursor=Toolkit.getDefaultToolkit().createCustomCursor(img, new Point(0,0), "null");
		this.setCursor(cursor);

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
















