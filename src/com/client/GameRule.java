package com.client;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
public class GameRule extends JPanel implements Runnable, MouseMotionListener{
	
	Image imgGround, img;		//마우스 그림 추가
	JButton b1;//버튼     
	Cursor cursor;			//커서 추가
	
	//타이머와 스레드 추가
	//Timer timer=new Timer(10,null);
	//Thread thread;
	
	// 변수 선언-용도: 이미지 영역내에서 마우스 해머크기가 크게 나오게 하기
	int hammerX, hammerY;
	
	
	public GameRule()
	{	
		//마우스모션 리스너 추가
		this.addMouseMotionListener(this);
		
		//그림 초기화
		imgGround = Toolkit.getDefaultToolkit().getImage("image/gr.png");
		img=Toolkit.getDefaultToolkit().getImage("image/01.png");	
	
		b1=new JButton("돌아가기 >>");
		
		setLayout(null);
		
		b1.setBounds(630,450,100,50);
		b1.setOpaque(true);
	
		
		 add(b1);
		
		
	}
	@Override	//
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(imgGround, 0, 0, getWidth(), getHeight(), this);
		g.drawImage(img, hammerX-35, hammerY-35, 70,70,this);
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseDragged(MouseEvent e) {
		this.setCursor(this.getToolkit().createCustomCursor(new BufferedImage(3,3,BufferedImage.TYPE_INT_ARGB), new Point(0,0), "null"));
		hammerX=e.getX();
		hammerY=e.getY();
		repaint();
		
	}
	@Override
	public void mouseMoved(MouseEvent e) {
		this.setCursor(this.getToolkit().createCustomCursor(new BufferedImage(3,3,BufferedImage.TYPE_INT_ARGB), new Point(0,0), "null"));
		hammerX=e.getX();
		hammerY=e.getY();
		repaint();
	}
}
















