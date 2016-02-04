package com.client;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

public class ScoreCount extends JPanel implements ActionListener{
	Image back, fistMole;
	JPanel timePanel, gamePanel;
	JProgressBar timeBar;
	JButton startBtn;
	JButton readyBtn;
	JButton cancelBtn;
	boolean readyConfirm;
	
	JButton[][] bu = new JButton[3][3];	// null
	int[][] panCount = new int[3][3];	// 0
	
	public ScoreCount() {
		back = Toolkit.getDefaultToolkit().getImage("c:\\image\\back.png");
		fistMole = Toolkit.getDefaultToolkit().getImage("c:\\image\\mole.png");
		timePanel = new JPanel();
		timeBar = new JProgressBar();
		startBtn = new JButton("start");
		readyBtn = new JButton("ready");
		cancelBtn = new JButton("cancel");
		readyConfirm = false;
		// 게임 맵
		gamePanel = new JPanel();
		gamePanel.setLayout(new GridLayout(3, 3, 5, 5));
		int k=1;
		
		for(int i=0; i<3; i++){
			for(int j=0; j<3; j++){
				bu[i][j] = new JButton(String.valueOf(k));
				// ����(��������) => ���ڿ�(String.valueOf())
				k++;
				gamePanel.add(bu[i][j]);
				bu[i][j].setEnabled(false);
				bu[i][j].setFont(new Font("맑은고딕", Font.BOLD, 25));
				bu[i][j].addActionListener(this);
			}
		}
		
		startBtn.addActionListener(this);
		readyBtn.addActionListener(this);
		cancelBtn.addActionListener(this);

		setLayout(null);

		timePanel.setBounds(430, 540, 400, 30);
		timePanel.setOpaque(false);
		//Border border = BorderFactory.createTitledBorder("Timer!!");
		//timeBar.setBorder(border);
		gamePanel.setBounds(40, 70, 400, 400);

		add(gamePanel);
		add(timePanel);
		timePanel.add(timeBar);
		timePanel.add(startBtn);
		timePanel.add(readyBtn);
		timePanel.add(cancelBtn);
		
	}
	
	public void display(){
		for(int i=0; i<3; i++){
			for(int j=0; j<3; j++){
				bu[i][j].setEnabled(true);
				bu[i][j].setText(String.valueOf(panCount[i][j]+1));
				bu[i][j].setIcon(new ImageIcon(fistMole));
			}
		}
	}
	

	class Move extends Thread {
		public void run() {
			try {
				int num = 10;
				while (true) {
					System.out.println(num);
					timeBar.setValue(num);
					timeBar.setStringPainted(true);
					num--;
					Thread.sleep(100);
					if (num < 0){
						Thread.interrupted();
						break;
					}
				}
			} catch (Exception e) {}
			
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.println("You clicked the button");
		if (e.getSource() == startBtn && readyConfirm == true) {
				new Move().start();
				startBtn.setEnabled(false);
				readyConfirm = false;
				cancelBtn.setEnabled(false);
				display();
		}
		
		if (e.getSource() == readyBtn) {
			readyBtn.setEnabled(false);
			readyConfirm = true;
			System.out.println("준비 확인이 되었습니다.");
		}
		
		if (e.getSource() == cancelBtn) {
			readyConfirm = false;
			readyBtn.setEnabled(true);
			System.out.println("준비 확인이 취소 되었습니다.");
		}
	}
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(back, 0, 0, getWidth(), getHeight(), this);
	}

}