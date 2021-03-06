package com.client;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.table.*;
public class WaitRoom extends JPanel implements ActionListener{ 
	Image back, img; 							// 배경화면, 마우스 그림
	JTable table1, table2; 					// table1 : 방이름,공개/비공개,인원 올라갈 테이블   table2 : ID,대화명,위치 올라갈 테이블
	DefaultTableModel model1, model2; 		// model1=table1 모델링 , model2=table2 모델링
	JTextArea ta; 							// 채팅창
	JTextField tf; 							// 채팅창 입력
	JPanel movie;							// 오전강사님 소스따온거 대채할거 생기면 대체바람
	JButton b1, b2, b3, b4, b5, b6, b7;		// 들어갈 버튼 선언부
	
	Cursor cursor;
	
	public WaitRoom(){
		// Room information
		back = Toolkit.getDefaultToolkit().getImage("image/back.png");
		
		// 마우스 그림 초기화
		img=Toolkit.getDefaultToolkit().getImage("image/02.png");
		cursor=Toolkit.getDefaultToolkit().createCustomCursor(img, new Point(0,0), "null");
		this.setCursor(cursor);
		
		setLayout(null);
				
		String[] col1 = {"방이름", "공개/비공개", "인원"}; 		// table1 배열에 들어갈 내용 선언
		String[] [] row1 = new String[0][3]; 			// table1 가로로3,세로로 1칸생성
		model1 = new DefaultTableModel(row1, col1); 	// table1에 들어갈 내용을 model1으로 모음
		table1 = new JTable(model1); 					// table 1과 model1을 동기화
		JScrollPane js1 = new JScrollPane(table1); 		// table1을 스크롤되게 만듬
		
		
		// stand by 
		String[] col2 = {"ID", "대화명", "위치"};		// table2 배열에 들어갈 내용 선언
		String[] [] row2 = new String[0][3];		// table2 가로로3,세로로 1칸생성
		model2 = new DefaultTableModel(row2, col2);	// table2에 들어갈 내용을 model2으로 모음
		table2 = new JTable(model2);				// table2과  model2을 동기화
		JScrollPane js2 = new JScrollPane(table2);	// table2을 스크롤되게 만듬
		
		// chatting
		ta = new JTextArea();						// 채팅창에 메모리 생성
		JScrollPane js3 = new JScrollPane(ta); 		// 채팅창 스크롤 되게 만듬
		tf = new JTextField(); 						// 채팅창 입력칸
		
		// media   없어도됨.
		movie = new JPanel();						// 오전강사님 소스. 영상 띄울 메모리 생성
		movie.setBackground(Color.black); 			// 오전강사님 소스. 영상배경을 검은색으로 지정
		
		b1 = new JButton("방만들기");
		b2 = new JButton("방들어가기");
		b3 = new JButton("게임신청");
		b4 = new JButton("쪽지보내기");
		b5 = new JButton("정보보기");
		b6 = new JButton("나가기");
		b7 = new JButton("보내기");
		b7.addActionListener(this);					//7번은 채팅창 입력받아야해서 액션리스너 받음
		
		// There are 6 button in Panel
		JPanel p = new JPanel();					//버튼 묶어줌
		p.setOpaque(false);							//버튼 배경 투명화
		p.setLayout(new GridLayout(3, 2, 5, 5));	//버튼 배열 정리및 크기조절
		p.add(b1);
		p.add(b2);
		p.add(b3);
		p.add(b4);
		p.add(b5);
		p.add(b6);
		
		// set location
		js1.setBounds(10, 15, 500, 320);			// table1위치와 크기정해줌
		js2.setBounds(515, 15, 265, 230);			// table2 위치와 크기정해줌
		js3.setBounds(10, 340, 500, 180);			// 채팅창 위치및 크기잡아줌
		tf.setBounds(10, 530, 400, 30);				// 채팅입력란 위치 및 크기 잡아줌
		movie.setBounds(515, 255, 265, 180);		//오전강사님 소스. 영상란 위치 및 크기잡아줌
		p.setBounds(515, 440, 265, 120);			//버튼 레이어 위치 및 크기 잡아줌
		b7.setBounds(420, 530, 85, 30);				//채팅 입력 버튼 위치및 크기
	
		add(js1);
		add(js2);
		add(js3);
		add(tf);
		//add(box);
		add(b7);
		add(movie);
		add(p);
	}
	@Override	// draw image 
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(back, 0, 0, getWidth(), getHeight(), this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO 자동 생성된 메소드 스텁
		
	}
}