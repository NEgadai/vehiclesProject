package graphics;

import java.awt.Graphics;

public interface IDrawable {
	public final static String PICTURE_PATH = ".\\src\\images\\";
	public void loadImages();
	public void drawObject (Graphics g);
	public String getColor();
}
