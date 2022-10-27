package avoidingGame;
import java.util.ArrayList;
import java. awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class ProducingObject extends Thread{

	OnPlayingScreen playingScreen;
    volatile boolean terminationFlag = true;
    Avoider avoider;
    		
	ProducingObject(OnPlayingScreen playingScreen  ,Avoider avoider ){
		this.playingScreen = playingScreen;
		this.avoider =avoider;
	}
	
	public void delay(int time) {
		try {
			Thread.sleep(time);
		} catch(InterruptedException e){} 
	}
	
	public void run() {
		try {
			while(terminationFlag) {
				  DroppingObject poop = new DroppingObject();
				  int min = poop.getWidth();
				  int max = playingScreen.getWidth() - min;
				  int randomX = (int)(Math.random() * (max-min)) + min;
			      poop.setBounds(randomX, poop.getY(),poop.getWidth(), poop.getHeight());
			      Main.poopList.add(poop);
			      playingScreen.add(poop);
			      
			      
			      if(avoider.life == 0) {
			    	  stopThread();
			      }
			      
			      playingScreen.revalidate();
			      playingScreen.repaint();
			      delay(1000);
			}// 객체를 생성해서 list에 넣고 화면에도 표시한다. 1초마다 시행한다.
			
		}catch(ArrayIndexOutOfBoundsException e) {}
		
	}
	
    public void stopThread() {
        terminationFlag = false;
    }
	
}
