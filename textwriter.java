
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class textwriter {
	public static void write(File file, ArrayList<Integer> Ethan) {

		BufferedWriter bw = null;
		FileWriter fw = null;
		try {

			fw = new FileWriter(file, false);
			bw = new BufferedWriter(fw);
			for (int i = 0; i < Ethan.size(); i++) {
				if (i == 0) {
					bw.write(Ethan.get(i).toString());
				} else {
					bw.write("\n" + Ethan.get(i).toString());
				}
			}

		} catch (IOException e) {

			e.printStackTrace();

		} finally {

			try {

				if (bw != null)
					bw.close();

				if (fw != null)
					fw.close();

			} catch (IOException ex) {

				ex.printStackTrace();

			}

		}
	}

	public static void writedouble(File file, ArrayList<Double> Ethan) {

		BufferedWriter bw = null;
		FileWriter fw = null;

		try {

			fw = new FileWriter(file, false);
			bw = new BufferedWriter(fw);
			for (int i = 0; i < Ethan.size(); i++) {
				if (i == 0) {
					bw.write(Ethan.get(i).toString());
				} else {
					bw.write("\n" + Ethan.get(i).toString());
				}
			}

		} catch (IOException e) {

			e.printStackTrace();

		} finally {

			try {

				if (bw != null)
					bw.close();

				if (fw != null)
					fw.close();

			} catch (IOException ex) {

				ex.printStackTrace();

			}

		}
	}

	public static void writeString(File file, ArrayList<String> Ethan) {

		BufferedWriter bw = null;
		FileWriter fw = null;

		try {

			fw = new FileWriter(file, false);
			bw = new BufferedWriter(fw);
			for (int i = 0; i < Ethan.size(); i++) {
				if (i == 0) {
					bw.write(Ethan.get(i).toString());
				} else {
					bw.write("\n" + Ethan.get(i).toString());
				}
			}

		} catch (IOException e) {

			e.printStackTrace();

		} finally {

			try {

				if (bw != null)
					bw.close();

				if (fw != null)
					fw.close();

			} catch (IOException ex) {

				ex.printStackTrace();

			}

		}
	}
}