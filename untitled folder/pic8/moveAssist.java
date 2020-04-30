import java.io.File;
import java.util.ArrayList;

public class moveAssist {
	public static double H = 8;;
	public static double L1 = 90;
	public static double L2 = 140;
	public static int[][] distance = new int[3][3];
	public static double middleVer;
	public static double middleHor;
	public static double[][] angles = new double[3][3];
	public static int[][] middlesVer = new int[3][3];
	public static int[][] middlesHor = new int[3][3];

	public moveAssist() {

	}

	public static boolean setup(ArrayList<Integer> ends, ArrayList<Integer> liness) {

		int top = ends.get(0);
		int bottom = ends.get(1);
		int left = ends.get(2);
		int right = ends.get(3);

		int Ltop = liness.get(0);
		int Lbottom = liness.get(1);
		int Lleft = liness.get(2);
		int Lright = liness.get(3);

		middleHor = (int) (Lleft + Lright) / 2;
		System.out.println("middle: " + middleHor);
		middlesVer[0][0] = (int) (top + Ltop / 2);
		middlesHor[0][0] = (int) (right + Lright) / 2;

		middlesVer[0][1] = (int) (Ltop + Lbottom) / 2;
		middlesHor[0][1] = (int) (right + Lright) / 2;

		middlesVer[0][2] = (int) (Lbottom + bottom) / 2;
		middlesHor[0][2] = (int) (right + Lright) / 2;

		middlesVer[1][0] = (int) (top + Ltop / 2);
		middlesHor[1][0] = (int) (Lleft + Lright) / 2;

		middlesVer[1][1] = (int) (Ltop + Lbottom) / 2;
		middlesHor[1][1] = (int) (Lleft + Lright) / 2;

		middlesVer[1][2] = (int) (Lbottom + bottom) / 2;
		middlesHor[1][2] = (int) (Lleft + Lright) / 2;

		middlesVer[2][0] = (int) (top + Ltop / 2);
		middlesHor[2][0] = (int) (left + Lleft) / 2;

		middlesVer[2][1] = (int) (Ltop + Lbottom) / 2;
		middlesHor[2][1] = (int) (left + Lleft) / 2;

		middlesVer[2][2] = (int) (Lbottom + bottom) / 2;
		middlesHor[2][2] = (int) (left + Lleft) / 2;

		return true;
	}

	public static ArrayList<ArrayList<Integer>> moveDistance(int o, int oo, ArrayList<Integer> ends,
			ArrayList<Integer> liness) {

		ArrayList<ArrayList<Integer>> returning = new ArrayList<ArrayList<Integer>>();

		int[] borders = finding(o, oo, ends, liness);
		int off = (int) ((borders[1] - borders[0]) / 4);
		int top = borders[0] + off;
		int bottom = borders[1] - off;
		int off2 = (int) ((borders[3] - borders[2]) / 4);
		int left = borders[2] + off2;
		int right = borders[3] - off2;
		int middleHor2 = (int) ((borders[3] + borders[2]) / 2);
		int middleVer2 = (int) ((borders[0] + borders[1]) / 2);
		int[] boarders2 = { top, bottom, right, left };
		double multpilier = 205 / ((double) (ends.get(3) - ends.get(2)));
		System.out.println("mult " + multpilier);
		double offput = ((double) ends.get(2) * multpilier);
		System.out.println("offput " + offput);
		offput -= 36;
		System.out.println("offput " + offput);
		middleHor += offput;
		for (int i = 0; i < 4; i++) {
			ArrayList<Integer> going_distance = new ArrayList<Integer>();
			double f;
			double ff;
			double ver;

			if (i > 1) {
				f = (middleHor - boarders2[i]);

				ff = f / middleVer2;
				ver = middleVer2;

			}

			else {
				f = (middleHor - middleHor2);

				ff = f / boarders2[i];
				ver = boarders2[i];

			}

			double angle = Math.toDegrees(Math.atan(ff));

			f *= multpilier;
			ver += 40;
			ver *= multpilier;

			int distance = (int) (Math.sqrt((f * f) + ((ver) * (ver))));
			if (distance > (L1 + L2 - 2)) {
				distance = (int) (L1 + L2 - .01);

			}
			double a = Math.toDegrees(Math.acos(((distance * distance) - (L1 * L1) - (L2 * L2)) / (-2 * L1 * L2)));
			int angleTop = (int) (a);
			double b = Math.sin(Math.toRadians(a));
			b /= distance;
			b *= L2;
			b = Math.asin((b));
			b = Math.toDegrees(b);

			int angleSide = (int) b;

			int angle3 = (int) (90 + angle);
			angle3 -= angleSide;

			angle3 = (int) (angle3);

			going_distance.add(180 - angleTop);
			going_distance.add(angle3);

			returning.add(going_distance);

			System.out.println(returning.size());
			for (int l = 0; l < returning.size(); l++) {
				for (int ll = 0; ll < 2; ll++) {
					System.out.print(returning.get(l).get(ll) + " ");
				}
				System.out.println();
			}

		}

		return returning;

	}

	public static int[] finding(int o, int oo, ArrayList<Integer> ends, ArrayList<Integer> liness) {
		int[] total = new int[4];
		int[] hor = new int[2];
		int[] ver = new int[2];
		if (oo == 0) {
			ver[0] = ends.get(0);
			ver[1] = liness.get(0);
		} else if (oo == 1) {
			ver[0] = liness.get(0);
			ver[1] = liness.get(1);
		} else if (oo == 2) {
			ver[0] = liness.get(1);
			ver[1] = ends.get(1);
		}
		if (o == 2) {
			hor[0] = ends.get(2);
			hor[1] = liness.get(2);
		} else if (o == 1) {
			hor[0] = liness.get(2);
			hor[1] = liness.get(3);
		} else if (o == 0) {
			hor[0] = liness.get(3);
			hor[1] = ends.get(3);
		}
		total[0] = ver[0];
		total[1] = ver[1];
		total[2] = hor[0];
		total[3] = hor[1];
		return total;
	}
}
