package avoidingGame;
import java.util.ArrayList;
import java. awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;


public class DroppingThread extends Thread {

	OnPlayingScreen playingScreen;
	Avoider avoider;
	DroppingObject poopSample = new DroppingObject();
	boolean vForCrushingCount;
    volatile boolean terminationFlag = true;
	
	DroppingThread(OnPlayingScreen playingScreen, Avoider avoider){
		this.playingScreen = playingScreen;
		this.avoider = avoider;
	}
	
	
	public void delay(int time) {
		try {
			Thread.sleep(time);
		} catch(InterruptedException e){} 
	}
	
	
	public void handleCrushing(DroppingObject poopForHandling, boolean crushingCount) {
		
		int poopX = poopForHandling.getX();
		int poopY = poopForHandling.getY();
		int avoiderX = avoider.getX();
		int avoiderY = avoider.getY();
		
			if(avoiderX >= poopX) {
			if(((avoiderX+avoider.getWidth())-poopX-(avoider.getWidth() + poopSample.getWidth()) <= 0)&&(((avoiderY+avoider.getHeight()) - poopY - (avoider.getHeight() + poopSample.getHeight()) <=0))) {
				if(crushingCount == false) {
					avoider.life = avoider.life - 1;
					crushingCount = true;
					vForCrushingCount = crushingCount;
				}
			} 
		} else if (avoiderX <= poopX) {
			if(((poopX+poopSample.getWidth())-avoiderX-(avoider.getWidth() + poopSample.getWidth()) <= 0)&&(((avoiderY+avoider.getHeight()) - poopY - (avoider.getHeight() + poopSample.getHeight()) <=0))) {
				if(crushingCount == false) {
					avoider.life = avoider.life - 1;
					crushingCount = true;
					vForCrushingCount = crushingCount;
				}
			}
		} 
		
			
		if(avoider.life ==0) {
			long end = System.currentTimeMillis();
			    JOptionPane aa=new JOptionPane();
			    float aliveTime = (end - StartScreen.start)/1000.0f; 
			    aa.showMessageDialog(null, "탈락입니다. 버틴 초: "+ aliveTime);
		}
		
	}       

	public void run(){
			delay(500);
		while(terminationFlag) {
			
			if(avoider.life == 0) {
				stopThread();
			}
			try {
				for(int i = 0; i<Main.poopList.size(); i++) {
					
					if(avoider.life > 0) {
					DroppingObject poop = Main.poopList.get(i);
					int droppingY = poop.getY() + 50;
					poop.setBounds(poop.getX(), droppingY, poop.getWidth(), poop.getHeight()); 
					playingScreen.add(poop);
					playingScreen.revalidate();
					playingScreen.repaint();
					delay(70);
					handleCrushing(poop,vForCrushingCount);
					vForCrushingCount = false;
					
					if(poop.getY() >= playingScreen.getHeight()) {
						if(Main.poopList.size() == 1) {
							continue;
						}
						else {
						Main.poopList.remove(i);
						playingScreen.remove(poop);
						}
					}
					}}// for문 끝. list에 있는 객체를 반복문으로 돌면서 위치를 아래로 이동시킨다. 
			} catch(ArrayIndexOutOfBoundsException e){}
		}
	}
	
	
    public void stopThread() {
        terminationFlag = false;
    }
	
	
}
