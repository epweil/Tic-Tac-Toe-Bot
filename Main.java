
import java.io.File;

import java.util.ArrayList;

public class Main {
	public static String[] opt = { "base", "shoulder", "elbow", "wrist", "clippers" };

	public static textwriter tw = new textwriter();
	public static File file = new File("starting.txt");
	public static String Path = file.getAbsolutePath().substring(0, file.getAbsolutePath().length() - 12);
	public static textwriter tw3 = new textwriter();

	public static textReader rd = new textReader();
	public static ArrayList<Integer> starting = starting = rd.get1(Path + "starting.txt");

	public static void main(String[] args) {

	}

	public static void write() {
		File file6 = new File(Path + "starting.txt");
		tw3.write(file6, starting);

	}

	public static void redo(String a) throws Exception {

		ArrayList<String> type2 = rd.Stringget1(a + ".txt");
		ArrayList<Integer> distance2 = rd.get1(a + "_distance.txt");
		for (int i = 0; i < type2.size(); i++) {
			new Move(distance2.get(i), type2.get(i));
			try {

				Thread.sleep(150);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
		}
	}

	public static int index(String a) {
		for (int i = 0; i < opt.length; i++) {
			if (a.equals(opt[(i)])) {
				return i;
			}

		}
		return 0;
	}

	public static void home() throws Exception {
		new Move((starting.get(2) * -1), "elbow");
		new Move((starting.get(1) * -1), "shoulder");
		new Move((starting.get(3) * -1), "wrist");
		Thread.sleep(3000);
		for (int i = 0; i < starting.size(); i++) {
			starting.set(i, 0);
		}
		write();

	}

	public static void mover(int distance, String what) throws Exception {
		new Move(distance, what);

	}

	public static void mover2(int distance, String what, int distance2, String what2) throws Exception {
		new Move(distance, what, distance2, what2);

	}
}
