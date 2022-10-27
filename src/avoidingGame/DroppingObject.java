package avoidingGame;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class DroppingObject extends JPanel
{
	public DroppingObject() {
		try {
			File poop = new File("./img/pngtree-a-cute-brawn-turd-vector-or-color-illustration-png-image_2030317-removebg-preview.png");
			System.out.println("isFile is= "+ poop.isFile());
			System.out.println("fileExists is= "+ poop.exists());
			BufferedImage bufferedImage = ImageIO.read(poop);
			Image image = bufferedImage.getScaledInstance(70, 70, Image.SCALE_DEFAULT);
			JLabel pic = new JLabel(new ImageIcon(image));
			pic.setOpaque(false);
			add(pic);
			setBounds(130, 180, 70, 70); // 크기설정
		}
		
		catch(Exception e) {
			 e.printStackTrace();
			System.out.println("failed to load image");
		}
	}
	
   
}