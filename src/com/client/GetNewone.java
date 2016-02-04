package com.client;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class GetNewone extends JFrame implements ActionListener{

	JLabel la1,la2,la3,la4;
	JTextField nf;
	JTextField tf;
	JPasswordField pf;
	

	JRadioButton  M;
	JRadioButton  W;
	
	JButton b1,b2;//확인,취소
	
	public GetNewone()
	{
		setTitle("회원가입");
		
		la1=new JLabel("이름");
		la2=new JLabel("ID");
		la3=new JLabel("PW");
		la4=new JLabel("성별");
		
		nf=new JTextField();
		tf=new JTextField();
		pf=new JPasswordField();
		
		M=new JRadioButton("남자");
		W=new JRadioButton("여자");
		
		//확인취소 버튼
		ButtonGroup  group = new ButtonGroup();
		group.add(M);  group.add(W);
		M.setSelected(true);
		
		b1=new JButton("확인 ");
		b2=new JButton("취소 ");
		
		
		JPanel p = new JPanel();
		p.add(M); p.add(W);
		
		JPanel p2=new JPanel(); //FlowLayout 패널로 딱 묶어서 가운데에 뜨게 도와줌
		p2.add(b1);
		p2.add(b2);
	
		
		setLayout(null);
		la1.setBounds(10,55,30,30);
		nf.setBounds(55,55,150,30);
		
		la2.setBounds(10,90,30,30);
		tf.setBounds(55,90,150,30);
		
		la3.setBounds(10,125,30,30);
		pf.setBounds(55,125,150,30);
		
		la4.setBounds(10,160,30,30);
		p.setBounds(55,160,150,30);
		p2.setBounds(400,250,150,30);
		//p2.setOpaque(true);
		
		
		add(la1);add(nf);
		add(la2);add(tf);
		add(la3);add(pf);
		add(la4); add(p); //라디오버튼
		add(p2);
			
		setSize(500,300);
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new GetNewone();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == b1) {
			//확인버튼
		}
		else if(e.getSource()==b2)
		{
			//종료버튼
		}
	}
	
}
