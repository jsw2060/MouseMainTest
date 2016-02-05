package com.client;
import javax.swing.*;
import java.awt.*;


public class Login extends JPanel{
	//그림정보를 가져온다.
	Image loadImage, backImage;
	
	int lx=80; //로고시작위치
	int ly=90;
	int logoWidth=610;
	int logoHeight=300;
	
	//ID & PW & 로그인 & 회원가입버튼
	JLabel IDLabel,PWLabel;
	JTextField IDField;
	JPasswordField PWField;
	JButton getNew,login;
	
	//마우스 커서 추가
	Cursor cursor;
	
	public Login()
	{
		backImage=Toolkit.getDefaultToolkit().getImage("image/back.png");
		loadImage=Toolkit.getDefaultToolkit().getImage("image/logo.png");
		
		//버튼들 메모리 할당
		IDLabel=new JLabel("ID");
		PWLabel=new JLabel("PW");
		IDField=new JTextField();
		PWField=new JPasswordField();
		getNew=new JButton("회원가입");
		login=new JButton("Login");
		
		//배치 
		setLayout(null);
		IDLabel.setBounds(280,415,30,30);
		IDField.setBounds(315,415,150,30);
		PWLabel.setBounds(280,450,30,30);
		PWField.setBounds(315,450,150,30);
		getNew.setBounds(315,485,100,30);
		login.setBounds(470,415,65,65);
		
		//추가
		add(IDLabel);add(IDField);add(login);
		add(PWLabel);add(PWField);
		add(getNew);
		
		
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		g.drawImage(backImage, 0, 0, getWidth(),getHeight(),this);
		g.drawImage(loadImage, lx,ly,logoWidth,logoHeight,this);
		
	}

}
