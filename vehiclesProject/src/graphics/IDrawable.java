package graphics;

import java.awt.Graphics;
/**
 * A Drawable Interface.
 * 
 * @author Tony Schneider,Daniel Sukharev
 */
public interface IDrawable {
	public final static String PICTURE_PATH = ".\\src\\images\\";
	public void loadImages();
	public void drawObject (Graphics g);
	public String getColor();
}
