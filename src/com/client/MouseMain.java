package com.client;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JPanel;
import javax.swing.table.*;

public class MouseMain extends JPanel {
	Image back, img, img1;
	int x,y;
	//Cursor cursor, cursor1;
    Toolkit tk = Toolkit.getDefaultToolkit();
    Point point = new Point(0,0);
	//MouseClick mc = new MouseClick();
	int a=0;
	public MouseMain() {
		back = Toolkit.getDefaultToolkit().getImage("image/back.png");
		
		img = tk.getImage("image/01.png");
        //cursor = tk.createCustomCursor(img,point,"roman");  // 이건 커서모양 바꾸는거
		//setCursor(cursor);
        
        img1 = tk.getImage("image/02.png");
        //cursor1 = tk.createCustomCursor(img1,point,"roman");  // 이것도
        //setCursor(cursor1);
        
        setSize(800,600);
        setVisible(true);
        
	}
	
	@Override
	public void paint(Graphics g) {
		g.drawImage(back, 0, 0, getWidth(), getHeight(), this);
		if(a==0)
			g.drawImage(img, x, y, this);
		else
			g.drawImage(img1, x, y, this);
	}
}