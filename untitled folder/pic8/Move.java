
public class Move {

	public Move(int a, String b) throws Exception {
		Main.starting.set(Main.index(b), (Main.starting.get(Main.index(b))) + a);
		Main.write();

		Runtime.getRuntime().exec("sudo python /home/pi/stepper1/stepper" + (Main.index(b)) + ".py " + a);

	}

	public Move(int a, String b, int aa, String bb) throws Exception {
		Main.starting.set(Main.index(b), (Main.starting.get(Main.index(b))) + a);
		Main.starting.set(Main.index(bb), (Main.starting.get(Main.index(bb))) + aa);
		Main.write();
		Runtime.getRuntime().exec("sudo python /home/pi/stepper1/stepper7.py " + a + "L" + aa);

	}

}
