import java.awt.image.BufferedImage;
import java.util.*;

import javax.imageio.ImageIO;

import java.io.*;

public class Picture {
	private BufferedImage bufferedImage;
	public Pixel[][] pixels;

	public Picture(String fileName) throws IOException {

		File file = new File(fileName);

		this.bufferedImage = ImageIO.read(file);
		pixels = this.getPixels2D();

	}

	public static ArrayList<ArrayList> lines(Picture one) throws Exception {

		Pixel[][] onePixels;
		ArrayList<Integer> liness = new ArrayList<Integer>();
		ArrayList<ArrayList> both = new ArrayList<ArrayList>();
		ArrayList<Integer> ends = new ArrayList<Integer>();
		int index = 60;
		while (ends.size() != 2) {
			index += 5;
			onePixels = one.getPixels2D();
			Thread.sleep(500);
			ends.clear();
			for (int i = 0; i < onePixels.length; i++) {
				if ((onePixels[i][index].getGreen() - onePixels[i][index].getBlue()) > 25) {
					ends.add(i);
					System.out.println("end vert: " + i);
					i += 50;

				}
			}
		}
		index = 60;
		while (ends.size() != 4) {
			index += 5;
			onePixels = one.getPixels2D();
			Thread.sleep(500);

			for (int ii = 0; ii < 300; ii++) {
				if ((onePixels[index][ii].getRed() - onePixels[index][ii].getBlue()) > 25
						&& onePixels[index][ii].getRed() > 30) {
					ends.add(ii);
					System.out.println("end horz: " + ii);
					ii += 50;
				}

			}
			if (ends.size() != 4) {
				ends.subList(2, ends.size()).clear();

			}

		}

		while (liness.size() != 2) {
			onePixels = one.getPixels2D();
			Thread.sleep(500);
			liness.clear();

			index = (ends.get(2) + ends.get(3)) / 2;
			for (int i = ends.get(0) + 10; i < ends.get(1) - 10; i++) {
				int red = onePixels[i][index].getRed();
				if (red < 70) {
					System.out.println("vert: " + i);
					liness.add(i);
					i += 50;
				}

			}

		}
		while (liness.size() != 4) {
			onePixels = one.getPixels2D();
			Thread.sleep(500);
			index = (ends.get(0) + ends.get(1)) / 2;
			for (int ii = ends.get(2) + 10; ii < ends.get(3) - 10; ii++) {
				int red = onePixels[index][ii].getRed();
				if (red < 70) {
					System.out.println("horz: " + ii);
					liness.add(ii);
					ii += 50;
				}

			}
			if (liness.size() != 4) {
				liness.subList(2, liness.size()).clear();

			}

		}
		both.add(liness);
		both.add(ends);
		return both;
	}

	public static int[] changes(Picture one, Picture two, int[][] c, ArrayList<Integer> ends,
			ArrayList<Integer> liness) {

		boolean[][] a = new boolean[3][3];
		Pixel[][] onePixels = one.getPixels2D();
		Pixel[][] twoPixels = two.getPixels2D();
		for (int b = 0; b < 3; b++) {
			for (int bb = 0; bb < 3; bb++) {
				a[b][bb] = false;
			}

		}

		int aa[][] = new int[3][3];
		int top = ends.get(0);
		int bottom = ends.get(1);
		int left = ends.get(2);
		int right = ends.get(3);

		int Ltop = liness.get(0);
		int Lbottom = liness.get(1);
		int Lleft = liness.get(2);
		int Lright = liness.get(3);

		for (int i = top + 10; i < bottom - 10; i++) {
			for (int ii = left + 10; ii < right - 10; ii++) {
				boolean red = onePixels[i][ii].getRed() - twoPixels[i][ii].getRed() > 80;
				boolean blue = onePixels[i][ii].getBlue() - twoPixels[i][ii].getBlue() > 80;
				boolean green = onePixels[i][ii].getGreen() - twoPixels[i][ii].getGreen() > 80;

				if (red || blue || green) {

					if (ii > left + 10 && ii < Lleft - 10 && i > Ltop + 10 && i < top - 5) {
						aa[2][0]++;
						System.out.print("1");
					}

					else if (ii > left + 10 && ii < Lleft - 10 && i > Ltop + 10 && i < Lbottom - 5) {
						aa[2][1]++;
						System.out.print("2");
					} else if (ii > left + 10 && ii < Lleft - 10 && i > Lbottom + 10 && i < bottom - 5) {
						aa[2][2]++;
						System.out.print("3");
					}

					else if (ii > Lleft + 10 && ii < Lright - 10 && i < Ltop + 10 && i > top - 5) {
						aa[1][0]++;
						System.out.print("4");
					} else if (ii > Lleft + 10 && ii < Lright - 10 && i > Ltop + 10 && i < Lbottom - 5) {
						aa[1][1]++;
						System.out.print("5");
					} else if (ii > Lleft + 10 && ii < Lright - 10 && i > Lbottom + 10 && i < bottom - 5) {
						aa[1][2]++;
						System.out.print("6");
					}

					else if (ii > Lright + 10 && ii < right - 10 && i > Ltop + 10 && i < top - 5) {
						aa[0][0]++;
						System.out.print("7");
					} else if (ii > Lright + 10 && ii < right - 10 && i > Ltop + 10 && i < Lbottom - 5) {
						aa[0][1]++;
						System.out.print("8");
					} else if (ii > Lright + 10 && ii < right - 10 && i > Lbottom + 10 && i < bottom - 5) {
						aa[0][2]++;
						System.out.print("9");
					}
				}
			}

		}
		int min = Integer.MIN_VALUE;
		int onee = 50;
		int twoo = 50;
		for (int x = 0; x < 3; x++) {
			for (int xx = 0; xx < 3; xx++) {
				if (aa[x][xx] > min && c[x][xx] == 0) {
					min = aa[x][xx];
					onee = x;
					twoo = xx;

				}
			}

		}
		if (onee == 50) {
			for (int x = 0; x < 3; x++) {
				for (int xx = 0; xx < 3; xx++) {
					if (c[x][xx] == 0) {
						min = aa[x][xx];
						onee = x;
						twoo = xx;

					}
				}

			}

		}
		int[] returning = { onee, twoo };
		return returning;
	}

	public Pixel[][] getPixels2D() {
		int width = getWidth();
		int height = getHeight();
		Pixel[][] pixelArray = new Pixel[height][width];

		// loop through height rows from top to bottom
		for (int row = 0; row < height; row++)
			for (int col = 0; col < width; col++)
				pixelArray[row][col] = new Pixel(this.bufferedImage, col, row);

		return pixelArray;
	}

	public int getHeight() {
		return this.bufferedImage.getHeight();
	}

	public int getWidth() {
		return this.bufferedImage.getWidth();
	}

}
