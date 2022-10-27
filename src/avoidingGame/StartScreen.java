package avoidingGame;
import java. awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.net.*;
import java.util.Map;
import java.util.HashMap;


public class StartScreen extends JPanel {

		OnPlayingScreen playingScreen;
		Main mainScreen;
		ProducingObject producingPoopThread;
		DroppingThread droppingThread;
		static long start;
		
		StartScreen(Main mainScreen,OnPlayingScreen playingScreen, ProducingObject producingPoopThread , DroppingThread droppingThread){
			this.mainScreen = mainScreen;
			this.playingScreen = playingScreen;
			this.producingPoopThread = producingPoopThread;
			this.droppingThread = droppingThread;
			
			setLayout(new GridBagLayout()); // 무슨 layout인지모름 => 공부할 것
			
			JLabel gameTitle = new JLabel("똥 피하기 게임"); //			게임제목
			gameTitle.setFont(new Font("Serif", Font.BOLD, 50));
			
			
			JButton startBtn = new JButton("게임시작"); //게임 시작 버튼
			
			startBtn.addMouseListener(new MouseListener() {
				public void mousePressed(MouseEvent e) {
					// 메인에 있는 panel을 지우고 현재 panel을 삽입한다.
					start = System.currentTimeMillis();
					mainScreen.add(playingScreen);
					producingPoopThread.start();
					droppingThread.start();
					setVisible(false); // 왜 돼지
				};
				public void mouseReleased(MouseEvent e) {};
				public void mouseClicked(MouseEvent e) {};
				public void mouseEntered(MouseEvent e) {};
				public void mouseExited(MouseEvent e) {};
				
			}); // 시작 버튼 클릭
			GridBagConstraints c = new GridBagConstraints();
			c.insets = new Insets(150,10,100,10);
			c.gridx = 0;
			c.gridy = 1;
			add(startBtn,c);
			c.gridx = 0;
			c.gridy = 2;
			add(gameTitle); // 메인 메뉴에서 컴포넌트 위치지정
		}
}
