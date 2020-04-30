import java.awt.Color;
import java.awt.image.BufferedImage;

public class Pixel {

	private BufferedImage bufferedImage;

	private int x;

	private int y;

	public Pixel(BufferedImage bufferedImage2, int x, int y) {

		this.bufferedImage = bufferedImage2;

		this.x = x;

		this.y = y;

	}

	public int getRed() {

		int value = bufferedImage.getRGB(x, y);

		int red = (value >> 16) & 0xff;

		return red;
	}

	public int getGreen() {

		int value = bufferedImage.getRGB(x, y);

		int green = (value >> 8) & 0xff;

		return green;
	}

	public int getBlue() {

		int value = bufferedImage.getRGB(x, y);

		int blue = value & 0xff;

		return blue;
	}

}
