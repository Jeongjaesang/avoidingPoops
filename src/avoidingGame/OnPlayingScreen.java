package avoidingGame;
import java. awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.util.ArrayList;


public class OnPlayingScreen extends JPanel { //플레이 화면

	 Avoider avoider;
	 public static boolean gameEnd = false;
	 
	public OnPlayingScreen(Avoider avoider) {
		setLayout(null);
		
		this.avoider = avoider;
		avoider.setBounds(330, 680, 70, 70);   // avoider(extends JPanel)의 크기 및 위치 설정
		add(avoider);
		
		setFocusable(true);
		requestFocus(); // 키 이벤트 먹을 수 있도록 focus 시킴
		addKeyListener(new KeyListenerForAvoiding()); //방향키 이벤트
		
		setSize(700,800);
		System.out.println("OnPlaying Screen starts to work");
		
		
	}
	
	class KeyListenerForAvoiding extends KeyAdapter{// avoider 방향키 리스너

		public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			int coordX = avoider.getX(); //330
			coordX = coordX - 10;
			if(coordX > -20) {
				avoider.setBounds(coordX, avoider.getY(), 70,70 );
			}
		} //왼쪽 이동
		else if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			int coordX = avoider.getX(); //330
			coordX = coordX + 10;
			if(coordX<630) {
				avoider.setBounds(coordX, avoider.getY(), 70,70 );
			}
		} //오른쪽 이동
	}
		
	}
}