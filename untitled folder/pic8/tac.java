import java.util.ArrayList;

public class tac {

	public static int winning = 2;
	public static ArrayList<Integer> numbers = new ArrayList<Integer>();
	public static ArrayList<Integer> first = new ArrayList<Integer>();
	public static ArrayList<Integer> second = new ArrayList<Integer>();

	public static boolean twoWays(int[][] a, int index) {
		int g[] = new int[2];

		int yyy = 0;
		for (int d = 0; d < 3; d++) {
			for (int dd = 0; dd < 3; dd++) {

				g[0] = d;
				g[1] = dd;
				if (a[d][dd] == 0) {

					a[d][dd] = index;
					if (winAcross(a, index) > 0)
						yyy++;
					if (winVertical(a, index) > 0)
						yyy++;
					if (winDiag(a, index) > 0)
						yyy++;

					System.out.println("D: " + d + "DD: " + dd + "   " + yyy);
					a[d][dd] = 0;
				}

			}
		}

		if (yyy > 1)
			return true;

		return false;
	}

	public static int[] what(int[][] a, int index) {

		int[] p = new int[2];

		for (int i = 0; i < 3; i++) {
			for (int ii = 0; ii < 3; ii++) {

				if (a[i][ii] == 0) {
					System.out.println("a");
					p[0] = i;
					p[1] = ii;
					a[i][ii] = index;
					System.out.println("I: " + i + "II: " + ii);
					if (twoWays(a, index)) {

						return p;
					}

					a[i][ii] = 0;
				}
			}
		}
		return p;
	}

	public static int[] canWin(int[][] a, int index) {
		System.out.println("Wins: ");
		int g[] = new int[2];
		for (int d = 0; d < 3; d++) {
			for (int dd = 0; dd < 3; dd++) {
				g[0] = d;
				g[1] = dd;

				if (a[d][dd] == 0) {

					a[d][dd] = index;
					if (winAcross(a, index) > 0)
						return g;
					if (winVertical(a, index) > 0)
						return g;
					if (winDiag(a, index) > 0)
						return g;
					a[d][dd] = 0;
				}

			}
		}

		return null;
	}

	public static int[] firsting2(int[][] a, int time) {
		int index2 = 1;
		int index = 2;

		int[] p = new int[2];

		if (time > 2) {
			p = canWin(a, index);

			if (p != null) {
				return p;
			}
			p = canWin(a, index2);
			if (p != null) {
				return p;
			}
			return what(a, index);

		}
		boolean corner1 = (a[0][0] == index2);
		boolean corner2 = (a[0][2] == index2);
		boolean corner3 = (a[2][0] == index2);
		boolean corner4 = (a[2][2] == index2);
		boolean middle = a[1][1] == index2;
		boolean down = a[2][1] == index2;
		boolean right = a[1][2] == index2;
		boolean left = a[1][0] == index2;
		if (time == 1) {
			p[0] = 0;
			p[1] = 1;
			return p;
		}
		if (time == 2) {
			if (middle) {
				p[0] = 1;
				p[1] = 0;
				return p;
			}
			if (right || left || down) {
				p[0] = 1;
				p[1] = 1;
				return p;
			}
			if (corner1) {
				p[0] = 2;
				p[1] = 0;
				return p;
			}
			if (corner2) {
				p[0] = 2;
				p[1] = 2;
				return p;
			}
			if (corner4) {
				p[0] = 0;
				p[1] = 2;
				return p;
			}
			if (corner3) {
				p[0] = 0;
				p[1] = 0;
				return p;
			}

		}
		return p;
	}

	public static int[] firsting(int[][] a, int time) {
		System.out.println("Wins: ");
		int index2 = 1;
		int index = 2;

		int[] p = new int[2];

		if (time > 2) {
			p = canWin(a, index);

			if (p != null) {
				return p;
			}
			p = canWin(a, index2);
			if (p != null) {
				return p;
			}
			return what(a, index);

		}

		boolean corner1 = (a[0][0] == index2);
		boolean corner2 = (a[0][2] == index2);
		boolean corner3 = (a[2][0] == index2);
		boolean corner4 = (a[2][2] == index2);
		boolean middle = a[1][1] == index2;
		boolean up = a[0][1] == index2;
		boolean down = a[2][1] == index2;
		boolean right = a[1][2] == index2;
		boolean left = a[1][0] == index2;
		if (time == 1) {
			if (middle || right) {
				p[0] = 0;
				p[0] = 2;

				return p;
			} else if (up || left) {
				p[0] = 0;
				p[0] = 0;

				return p;
			} else if (down) {
				p[0] = 2;
				p[0] = 0;

				return p;
			}

			else {
				p[0] = 1;
				p[1] = 1;

				return p;
			}

		}
		if (time == 2) {
			System.out.println("No Wins");
			p = canWin(a, index);

			if (p != null) {
				return p;
			}
			p = canWin(a, index2);
			if (p != null) {
				return p;
			}
			p = new int[2];

			if (corner1 && corner4) {
				p[0] = 1;
				p[1] = 0;
				return p;
			} else if (corner1 && corner2) {
				p[0] = 0;
				p[1] = 1;
				return p;
			} else if (corner1 && corner3) {
				p[0] = 1;
				p[1] = 0;
				return p;
			} else if (corner2 && corner4) {
				p[0] = 1;
				p[1] = 2;
				return p;
			} else if (corner2 && corner3) {
				p[0] = 1;
				p[1] = 2;
				return p;
			} else if (corner3 && corner4) {
				p[0] = 2;
				p[1] = 1;
				return p;
			} else if (middle && corner1) {
				p[0] = 0;
				p[1] = 2;
				return p;
			} else if (middle && corner2) {
				p[0] = 0;
				p[1] = 2;
				return p;
			} else if (middle && corner3) {
				p[0] = 2;
				p[1] = 0;
				return p;
			}

		}
		return p;
	}

	public static int winAcross(int[][] a, int winner) {
		for (int i = 0; i < 3; i++) {
			int b = a[i][0];
			if (b != 0) {
				int c = 0;
				for (int ii = 0; ii < 3; ii++) {
					if (a[i][ii] != b)
						break;
					else
						c++;

				}
				if (c == 3)
					if (b == winner)
						return 1;
					else
						return -1;
				else
					c = 0;
			}
		}
		return 0;
	}

	public static int winVertical(int[][] a, int winner) {
		for (int i = 0; i < 3; i++) {

			int b = a[0][i];
			int c = a[1][i];
			int d = a[2][i];

			if (b != 0 && (b == c && b == d)) {
				if (b == winner)
					return 1;
				else
					return -1;

			}
		}
		return 0;
	}

	public static int winDiag(int[][] a, int winner) {
		int c = 1;
		int b = a[0][0];
		if (b != 0) {
			for (int i = 1; i < 3; i++) {
				if (a[i][i] == b) {
					c++;
				}
			}
		}
		if (c == 3)
			if (b == winner)
				return 1;
			else
				return -1;
		else
			c = 1;
		if (b != 0) {
			b = a[0][2];
			for (int i = 1; i < 3; i++) {
				if (a[0 + i][2 - i] == b) {
					c++;
				}
			}
		}
		if (c == 3)
			if (b == winner)
				return 1;
			else
				return -1;
		else
			return 0;
	}
}
