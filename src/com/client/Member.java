package com.client;

import java.awt.Checkbox;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
//import javax.swing.JRadioButton;
import javax.swing.JTextField;
public class Member extends JPanel{
	
	Image back;
	JPanel selecPane;
	
	JLabel la1,la2,la3,la4,la5,la6,la7;
	JTextField tf1,tf2;
	JPasswordField pf;
	JButton b1,b2;
	JRadioButton rb1,rb2;
	ButtonGroup bg;
	
	public Member()
	{	
		
		back=Toolkit.getDefaultToolkit().getImage("C:\\image\\back.png");
		selecPane = new JPanel();
		
		la1=new JLabel("회원가입");
		la2=new JLabel("이름");
		la3=new JLabel("ID");
		la4=new JLabel("PW");
		la5=new JLabel("성별");

		b1=new JButton("중복체크");
		b2=new JButton("회원가입");
		tf1=new JTextField("이름을 입력하세요.");
		tf2=new JTextField("ID를 입력하세요.");
		pf=new JPasswordField();
		
		bg = new ButtonGroup(); // Radio button Grouping
		rb1 = new JRadioButton("남자", true);
		rb2 = new JRadioButton("여자", false);
		
		bg.add(rb1);
		bg.add(rb2);
		
		selecPane.add(rb1);
		selecPane.add(rb2);
		
		setLayout(null);
		
		la1.setBounds(370,100,200,50);//
		la2.setBounds(250,170,50,50);//
		la3.setBounds(250,220,50,50);//id
		la4.setBounds(250,270,50,50);//pw
		la5.setBounds(250,310,50,50);//
		
		rb1.setBounds(300,310,50,50);//
		rb1.setOpaque(false);
		rb2.setBounds(420,310,50,50);//
		rb2.setOpaque(false);
		
		b2.setBounds(340,380,120,30);//
		b1.setBounds(530,230,100,30);//
		b1.setOpaque(false);
		tf1.setBounds(300, 180, 200, 30);//
		tf2.setBounds(300, 230, 200, 30);//
		pf.setBounds(300, 280, 200, 30);//
		selecPane.setBounds(320, 320, 140, 30);
		selecPane.setOpaque(false);
	
		add(la1);	add(la2); 
		add(la3);   add(la4); 
		add(la5);  

		add(tf1);	add(tf2);   add(pf);
		add(b1);	add(b2); 
		add(selecPane);
		
	}

	protected void paintComponent(Graphics g) {
		g.drawImage(back, 0, 0, getWidth(),getHeight(),this);
	}
}