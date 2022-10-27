package avoidingGame;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;


public class Main extends JFrame { // 메인 화면
		
	public static ArrayList<DroppingObject> poopList = new ArrayList<>();
	Avoider avoider = new Avoider();
	OnPlayingScreen playingScreen = new OnPlayingScreen(avoider);
	ProducingObject producingPoopThread = new ProducingObject(playingScreen,avoider);
	DroppingThread droppingThread = new DroppingThread(playingScreen,avoider);
	
	Main(){
			setTitle("똥 피하기 게임");
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			StartScreen StartScreen = new StartScreen(this, playingScreen, producingPoopThread,droppingThread);
			add(StartScreen);
			setSize(700,800);
			setLocationRelativeTo(null);
			setVisible(true);
		}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main mainScreen = new Main();
	}
}