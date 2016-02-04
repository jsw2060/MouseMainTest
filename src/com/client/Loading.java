package com.client;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
// Loading Page 로딩화면
public class Loading extends JPanel {
	Image loadImage, backImage;		// 추가이미지, 배경화면
	JPanel progressPanel;
	JLabel loadTitle;				// Loading!!! 출력용
	JButton loadConfirm;			// Start Button 스타트 버튼
	JProgressBar percentBar;		// Loading Bar 진행도 나타내는 막대
	
	// 이미지 불러오고, 각종 컴포넌트 초기화
	public Loading() {
		//loadImage = Toolkit.getDefaultToolkit().getImage("c:\\image\\load.gif");
		backImage = Toolkit.getDefaultToolkit().getImage("image/back.png");
		
		progressPanel = new JPanel();
		percentBar = new JProgressBar(JProgressBar.HORIZONTAL,0,100);
		loadTitle = new JLabel("Loading!!!");
		loadConfirm = new JButton("시작!");
		
		setLayout(null);			// ClientMain의 레이아웃을 해제시키고, 새로 위치를 배치할 수 있도록 함
		loadTitle.setFont(new Font("맑은고딕", Font.BOLD, 24));		// 폰트 지정 맑은고딕, 굵게, 크기 24
		//progressPanel.setBounds(180, 330, 600, 200);
		//progressPanel.setLayout(null);
		
		loadConfirm.setBounds(20, 430, 60, 40);
		percentBar.setBounds(10, 550, 775, 30);
		
		add(loadTitle);
		add(loadConfirm);
		add(percentBar);
		
		// 프로그레스 패널에 Loading!!! |===100%===| |시작| 을 묶어줌

		loadConfirm.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// Execute when button is pressed
				System.out.println("You clicked the button");	// 버튼이 눌려지는지 콘솔창에서 확인하기 위함
				if (e.getSource() == loadConfirm) {				// 시작버튼 누르면
						new Move().start();						// thread working! 게이지바 차는 것을 시작함
						loadConfirm.setEnabled(false);			// 시작 버튼 비활성화 시킴
				}
			}
		});
	}
	
	@Override	// 그림 출력부
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(backImage, 0, 0, getWidth(), getHeight(), this);
		//g.drawImage(loadImage, 10, 0, 775, 500, this);
	}
	
	// Thread 쓰레드
	class Move extends Thread {
		public void run() {
			try {										// 예외처리 num이 0~100으로 증가하면서 게이지바를 그려줌
				int num = 0;
				while (true) {
					System.out.println(num);			// 콘솔창에 게이지가 잘 작동하는지 출력
					percentBar.setValue(num);			// 화면에 게이지 0% -> 100% 출력
					percentBar.setStringPainted(true);	// 게이지 차오르는 것 출력
					num++;
					Thread.sleep(70);					// millisecond 단위  1초는 1000 // 출력 1번당 70만큼 지연을 줌
					if (num > 100){						// 100% 도달시
						Thread.interrupted();			// Thread death 쓰레드 소멸
						break;
					}
				}
			} catch (Exception e) {}
		}
	}
}


