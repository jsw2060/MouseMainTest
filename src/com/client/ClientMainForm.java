package com.client;
import java.awt.*; // layout
import java.awt.event.*;
import javax.swing.*; // window
import javax.swing.text.Document;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;

//import com.client.MouseCursor;

public class ClientMainForm extends JFrame implements ActionListener, MouseMotionListener, MouseListener{
	CardLayout card = new CardLayout();
	Login login = new Login();
	WaitRoom wr = new WaitRoom();
	Member memb = new Member();
	ScoreCount ScoreCount = new ScoreCount();
	CreateRoom cr = new CreateRoom();
	Loading loading = new Loading();
	MakeRoom mr = new MakeRoom();
	GetNewone no=new GetNewone();
	ChatRoom ch = new ChatRoom();
	GameRule gr = new GameRule();
	//TimerTest timer = new TimerTest();
	
	boolean b = false;
	
	
	public ClientMainForm(){
		setLayout(card);	// BoarderLayout => CardLayout
		//add("ScoreCount", ScoreCount);
		//add("Cursur", mouseMa);//留덉슦�뒪 �븸�뀡 異붽�
		add("LOG", login);
		add("CH", ch);
		add("LOADING", loading);
		//add("GetNewOne", no);
		//add("MEMBER", memb);
		add("WR", wr);
		add("CR", cr);
		add("GAMERULE", gr);
		// 
		setTitle("�옟�븘�씪�몢�뜑吏�");
		setSize(800, 600);
		setVisible(true);
		setResizable(false);
		
		login.getNew.addActionListener(this);
		login.login.addActionListener(this);
		
		wr.tf.addActionListener(this);
		wr.b1.addActionListener(this);
		wr.b5.addActionListener(this);
		wr.b6.addActionListener(this);
		gr.b1.addActionListener(this);
		cr.b1.addActionListener(this);
		memb.b2.addActionListener(this);
		ch.tf.addActionListener(this);
		
		addMouseMotionListener(this);
		addMouseListener(this);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);//硫붾え由� �쉶�닔
		
	}
	public static void main(String[] args) {
		// �삁�쇅泥섎━
		try{
			UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");
		}catch(Exception ex) {}
		ClientMainForm cm = new ClientMainForm();
		//new GetNewone();
		
		//MouseCursor mm = new MouseCursor();		// 留덉슦�뒪 硫붿씤 媛앹껜 �깮�꽦
	}
	
	// �뙣�꼸諛붽씀湲�
	@Override
	public void actionPerformed(ActionEvent e) {

		if(e.getSource() == wr.tf){
			String data = wr.tf.getText();
			wr.ta.append(data + "\n"); //
			wr.tf.setText("");
		}
		else if(e.getSource() == login.getNew){
			//card.show(getContentPane(), "MEMBER");
			no.setBounds(275,200,550,330);
			no.setVisible(true);
		}
		else if(e.getSource() == login.login){
			card.show(getContentPane(), "WR");
		}
		else if(e.getSource() == wr.b6){
			card.show(getContentPane(), "LOG");
		}
		else if(e.getSource()==wr.b1)
		{
			//mr.setSize(230, 235);
			mr.setBounds(285, 180, 230, 240);
			mr.setVisible(true);
			//card.show(getContentPane(), "CreateRoom");
		}
		else if(e.getSource()==cr.b1)
		{
			card.show(getContentPane(), "WR");
		}
		else if(e.getSource() == ch.tf){
	         String msg = ch.tf.getText().trim();
	         if(msg.length()<1) return;
	         String color = ch.box.getSelectedItem().toString();
	         initStyle();
	         append(msg, color);
	         ch.tf.setText("");
	      }
		else if(e.getSource() == wr.b5){
			card.show(getContentPane(), "GAMERULE");
		}
		else if(e.getSource() == gr.b1){
			card.show(getContentPane(), "WR");
		}
	}
	
	public void initStyle(){
		Style def = StyleContext.getDefaultStyleContext().getStyle(StyleContext.DEFAULT_STYLE);
		Style blue = ch.jp.addStyle("blue", def);
		StyleConstants.setForeground(blue, Color.blue);
		
		Style green = ch.jp.addStyle("green", def);
		StyleConstants.setForeground(green, Color.green);
		
		Style cyan = ch.jp.addStyle("cyan", def);
		StyleConstants.setForeground(cyan, Color.cyan);
		
		Style yellow = ch.jp.addStyle("yellow", def);
		StyleConstants.setForeground(yellow, Color.yellow);
		
		Style magenta = ch.jp.addStyle("magenta", def);
		StyleConstants.setForeground(magenta, Color.magenta);
	}
	public void append(String msg, String color){
		try {
			Document doc = ch.jp.getDocument();
			doc.insertString(doc.getLength(), msg+"\n", ch.jp.getStyle(color));
		} catch (Exception ex) {
			// TODO: handle exception
		}
	}
	
	// 留덉슦�뒪 �씠踰ㅽ듃
	
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
	}
	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
	}
	
	// 留덉슦�뒪 �씠踰ㅽ듃
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
/*		b=!b;
		if(b==true){
			mouseMa.a=1;
			mouseMa.repaint();
		}
		else
			mouseMa.a=0;*/
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
