
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class textReader {
	public static ArrayList<Integer> get1(String file) {
		try {
			ArrayList<Integer> Ethan = new ArrayList<Integer>();
			File f2 = new File(file);

			BufferedReader b2 = new BufferedReader(new FileReader(f2));

			String readLine2 = "";

			while ((readLine2 = b2.readLine()) != null) {
				Ethan.add(Integer.parseInt(readLine2));
			}

			return Ethan;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static ArrayList<Double> get2(String file) {
		try {
			ArrayList<Double> Ethan = new ArrayList<Double>();
			File f2 = new File(file);

			BufferedReader b2 = new BufferedReader(new FileReader(f2));

			String readLine2 = "";

			while ((readLine2 = b2.readLine()) != null) {
				Ethan.add(Double.parseDouble(readLine2));
			}

			return Ethan;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static ArrayList<String> Stringget1(String file) {
		try {
			ArrayList<String> Ethan = new ArrayList<String>();
			File f2 = new File(file);

			BufferedReader b2 = new BufferedReader(new FileReader(f2));

			String readLine2 = "";

			while ((readLine2 = b2.readLine()) != null) {
				Ethan.add((readLine2));
			}

			return Ethan;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
