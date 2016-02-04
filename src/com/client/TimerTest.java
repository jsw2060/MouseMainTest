package com.client;

import java.awt.CardLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.border.Border;

public class TimerTest extends JFrame implements ActionListener{
	CardLayout card = new CardLayout();
	
	JPanel timePanel;
	JProgressBar timeBar;
	JButton startBtn;
	JButton readyBtn;
	JButton cancelBtn;
	boolean readyConfirm;

	public TimerTest() {
		setLayout(card);
		
		timePanel = new JPanel();
		timeBar = new JProgressBar();
		startBtn = new JButton("start");
		readyBtn = new JButton("ready");
		cancelBtn = new JButton("cancel");
		readyConfirm = false;
		
		startBtn.addActionListener(this);
		readyBtn.addActionListener(this);
		cancelBtn.addActionListener(this);

		
		/*startBtn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// Execute when button is pressed
				System.out.println("You clicked the button");
				if (e.getSource() == startBtn && readyConfirm == true) {
						new Move().start();
						startBtn.setEnabled(false);
						readyConfirm = false;
						cancelBtn.setEnabled(false);
				}
			}
		});
		
		readyBtn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// Execute when button is pressed

				if (e.getSource() == readyBtn) {
					readyBtn.setEnabled(false);
					readyConfirm = true;
					System.out.println("준비 확인이 되었습니다.");
				}
			}
		});
		
		cancelBtn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// Execute when button is pressed
				
				if (e.getSource() == cancelBtn) {
					readyConfirm = false;
					readyBtn.setEnabled(true);
					System.out.println("준비 확인이 취소 되었습니다.");
				}
			}
		});
*/
		//timerThread = new Thread();
		timePanel.setBounds(100, 100, 500, 500);
		//Border border = BorderFactory.createTitledBorder("Timer!!");
		//timeBar.setBorder(border);

	
		add(timePanel);
		timePanel.add(timeBar);
		timePanel.add(startBtn);
		timePanel.add(readyBtn);
		timePanel.add(cancelBtn);
		
		setSize(800, 600);
		setVisible(true);
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

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TimerTest pg = new TimerTest();
	}
	/*@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);

	}*/

}
