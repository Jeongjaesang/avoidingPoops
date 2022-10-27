package avoidingGame;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.io.File;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class Avoider extends JPanel { // 피하는 캐릭터
	int life = 1;
	BufferedImage bufferedImage;
	public Avoider() {
		try {
			
			File avoider = new File("./img/25709038585FBC5621.png");
			System.out.println("isFile is= "+ avoider.isFile());
			System.out.println("fileExist= "+ avoider.exists());
			bufferedImage = ImageIO.read(avoider);
			Image image = bufferedImage.getScaledInstance(70, 70, Image.SCALE_DEFAULT);
			JLabel pic = new JLabel(new ImageIcon(image));
			pic.setOpaque(false);
			add(pic);
		}
		
		catch(IOException e) 
		{
			 e.printStackTrace();
			System.out.println("failed to load image");

		}
	}
}
