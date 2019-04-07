package graphics;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class CityPanel extends JPanel {
	private BufferedImage background = loadImage();
	private Dimension backgroundSize = new Dimension(background.getWidth(),background.getHeight());
//	private void setBackground(BufferedImage background){this.background = background;}
//	private BufferedImage getBackgroundImage(){return this.background;}
	public Dimension getBackgroundSize(){return this.backgroundSize;}
	private BufferedImage loadImage(){
        URL imagePath = getClass().getResource("/images/cityBackground.png");
        BufferedImage result = null;
        try {
            result = ImageIO.read(imagePath);//read the image file with ImageIO class.
        } catch (IOException e) {//Catch due to try to read the image file.
            System.err.println("Errore, immagine non trovata");
        }
        return result;
    }
	@Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);//Call the default method due to overriding.
        setPreferredSize(backgroundSize);
        Dimension size = getSize();//get the size of this panel and set it into Dimension(size) object.
        g.drawImage(background, 0, 0,size.width, size.height,0, 0, background.getWidth(), background.getHeight(), null);//set the background in 0,0 location (drawing the background)
    }
}
