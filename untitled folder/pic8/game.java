import java.awt.EventQueue;
import java.io.File;
import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class game {
	public JButton btnRestart = new JButton("Restart");
	public int moveTime = 10;
	public int you = 0;
	public int computer = 0;
	public String symbol = "X";
	public String symbol2 = "O";
	public int index = 2;
	public int index2 = 1;
	public JFrame frame;
	public boolean first = false;
	public boolean impossible = true;
	public JTextField txtTicTacToe;
	public JTextField txtScore;
	public JTextField txtSimulation;
	public JTextField txtComputer;
	public JTextField txtYou;
	public int personIndex;
	public JTextField[][] boardss = new JTextField[3][3];
	public JButton btnStop;
	public JTextField txtDifficulty;
	public int[][] a = { { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 } };
	public ArrayList<Integer> liness;
	public ArrayList<Integer> ends;
	public Main k = new Main();
	private JTextField txtWhoGoesFirst;
	private JComboBox comboBox_2;
	private JButton btnStart;
	public JComboBox comboBox = new JComboBox();
	public JTextField textField_10;
	public moveAssist MoveAssist = new moveAssist();
	private JTextField txtTimeBetweenMovessec;
	private JTextField textField_11;
	public boolean h = true;
	public String name;

	public game(String name2, int you2, int computer2, int personIndex2) throws Exception {
		name = name2;
		you = you2;
		computer = computer2;
		personIndex = personIndex2;
		k.home();
		File file1111 = new File("/home/pi/pic8/image3.jpg");
		file1111.delete();
		file1111 = new File("/home/pi/pic8/image1.jpg");
		file1111.delete();
		initialize();

	}

	public void initialize() throws Exception {

		frame = new JFrame();
		frame.getContentPane().setBackground(Color.BLUE);
		frame.setBounds(100, 100, 600, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		txtTicTacToe = new JTextField();
		txtTicTacToe.setEditable(false);
		txtTicTacToe.setForeground(Color.WHITE);
		txtTicTacToe.setBackground(Color.BLUE);
		txtTicTacToe.setHorizontalAlignment(SwingConstants.CENTER);
		txtTicTacToe.setFont(new Font("Lucida Grande", Font.PLAIN, 53));
		txtTicTacToe.setText("Tic Tac Toe\n");
		txtTicTacToe.setBounds(6, 6, 588, 72);
		frame.getContentPane().add(txtTicTacToe);
		txtTicTacToe.setColumns(10);

		txtScore = new JTextField();
		txtScore.setEditable(false);
		txtScore.setForeground(Color.WHITE);
		txtScore.setBackground(Color.BLUE);
		txtScore.setHorizontalAlignment(SwingConstants.CENTER);
		txtScore.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		txtScore.setText("Score\n");
		txtScore.setBounds(23, 103, 155, 46);
		frame.getContentPane().add(txtScore);
		txtScore.setColumns(10);

		txtSimulation = new JTextField();
		txtSimulation.setEditable(false);
		txtSimulation.setForeground(Color.WHITE);
		txtSimulation.setBackground(Color.BLUE);
		txtSimulation.setText("Simulation");
		txtSimulation.setHorizontalAlignment(SwingConstants.CENTER);
		txtSimulation.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		txtSimulation.setColumns(10);
		txtSimulation.setBounds(345, 103, 201, 46);
		frame.getContentPane().add(txtSimulation);

		txtComputer = new JTextField();
		txtComputer.setEditable(false);
		txtComputer.setForeground(Color.WHITE);
		txtComputer.setBackground(Color.BLUE);
		txtComputer.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		txtComputer.setText("Computer: 0");
		txtComputer.setBounds(23, 175, 155, 32);
		frame.getContentPane().add(txtComputer);
		txtComputer.setColumns(10);

		txtYou = new JTextField();
		txtYou.setEditable(false);
		txtYou.setForeground(Color.WHITE);
		txtYou.setBackground(Color.BLUE);
		txtYou.setText("You: 0");
		txtYou.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		txtYou.setColumns(10);
		txtYou.setBounds(23, 225, 155, 32);
		frame.getContentPane().add(txtYou);

		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "Imposible ", "Easy" }));
		comboBox.setBounds(23, 386, 155, 32);
		frame.getContentPane().add(comboBox);

		btnRestart.setBounds(33, 430, 117, 29);
		frame.getContentPane().add(btnRestart);

		boardss[0][0] = new JTextField();
		boardss[0][0].setBounds(355, 162, 51, 51);
		frame.getContentPane().add(boardss[0][0]);
		boardss[0][0].setColumns(10);

		boardss[0][1] = new JTextField();
		boardss[0][1].setColumns(10);
		boardss[0][1].setBounds(405, 162, 51, 51);
		frame.getContentPane().add(boardss[0][1]);

		boardss[0][2] = new JTextField();
		boardss[0][2].setColumns(10);
		boardss[0][2].setBounds(454, 162, 51, 51);
		frame.getContentPane().add(boardss[0][2]);

		boardss[1][0] = new JTextField();
		boardss[1][0].setColumns(10);
		boardss[1][0].setBounds(355, 216, 51, 51);
		frame.getContentPane().add(boardss[1][0]);

		boardss[1][1] = new JTextField();
		boardss[1][1].setColumns(10);
		boardss[1][1].setBounds(405, 216, 51, 51);
		frame.getContentPane().add(boardss[1][1]);

		boardss[1][2] = new JTextField();
		boardss[1][2].setColumns(10);
		boardss[1][2].setBounds(454, 216, 51, 51);
		frame.getContentPane().add(boardss[1][2]);

		boardss[2][0] = new JTextField();
		boardss[2][0].setColumns(10);
		boardss[2][0].setBounds(355, 269, 51, 51);
		frame.getContentPane().add(boardss[2][0]);

		boardss[2][1] = new JTextField();
		boardss[2][1].setColumns(10);
		boardss[2][1].setBounds(405, 269, 51, 51);
		frame.getContentPane().add(boardss[2][1]);

		boardss[2][2] = new JTextField();
		boardss[2][2].setColumns(10);
		boardss[2][2].setBounds(454, 269, 51, 51);
		frame.getContentPane().add(boardss[2][2]);

		txtDifficulty = new JTextField();
		txtDifficulty.setEditable(false);
		txtDifficulty.setForeground(Color.WHITE);
		txtDifficulty.setBackground(Color.BLUE);
		txtDifficulty.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		txtDifficulty.setHorizontalAlignment(SwingConstants.CENTER);
		txtDifficulty.setText("Difficulty");
		txtDifficulty.setBounds(23, 362, 155, 26);
		frame.getContentPane().add(txtDifficulty);
		txtDifficulty.setColumns(10);

		txtWhoGoesFirst = new JTextField();
		txtWhoGoesFirst.setEditable(false);
		txtWhoGoesFirst.setText("Who goes first?\n");
		txtWhoGoesFirst.setHorizontalAlignment(SwingConstants.CENTER);
		txtWhoGoesFirst.setForeground(Color.WHITE);
		txtWhoGoesFirst.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		txtWhoGoesFirst.setColumns(10);
		txtWhoGoesFirst.setBackground(Color.BLUE);
		txtWhoGoesFirst.setBounds(23, 283, 155, 26);
		frame.getContentPane().add(txtWhoGoesFirst);

		comboBox_2 = new JComboBox();
		comboBox_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comboBox_2.getSelectedIndex() == 0)
					first = false;
				else
					first = true;
			}
		});
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] { "You ", "Computer" }));
		comboBox_2.setBounds(23, 307, 155, 32);
		frame.getContentPane().add(comboBox_2);
		Runtime.getRuntime().exec("sudo service motion stop");
		btnStart = new JButton("Start");
		btnStart.setBounds(205, 103, 117, 29);
		frame.getContentPane().add(btnStart);

		textField_10 = new JTextField();
		textField_10.setEditable(false);
		textField_10.setHorizontalAlignment(SwingConstants.CENTER);
		textField_10.setBounds(209, 209, 130, 26);
		frame.getContentPane().add(textField_10);
		textField_10.setColumns(10);

		txtTimeBetweenMovessec = new JTextField();
		txtTimeBetweenMovessec.setText("Time Between Moves(Sec)");
		txtTimeBetweenMovessec.setHorizontalAlignment(SwingConstants.CENTER);
		txtTimeBetweenMovessec.setForeground(Color.WHITE);
		txtTimeBetweenMovessec.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		txtTimeBetweenMovessec.setColumns(10);
		txtTimeBetweenMovessec.setBackground(Color.BLUE);
		txtTimeBetweenMovessec.setBounds(190, 362, 172, 26);
		frame.getContentPane().add(txtTimeBetweenMovessec);

		textField_11 = new JTextField();

		textField_11.setText("10\n");
		textField_11.setHorizontalAlignment(SwingConstants.CENTER);
		textField_11.setForeground(Color.WHITE);
		textField_11.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		textField_11.setColumns(10);
		textField_11.setBackground(Color.BLUE);
		textField_11.setBounds(190, 388, 172, 26);
		frame.getContentPane().add(textField_11);
		doing.start();
		doing.suspend();
		btnStop = new JButton("Stop");
		btnStop.setBounds(205, 144, 117, 29);
		frame.getContentPane().add(btnStop);

		btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login.you.set(personIndex, you);
				login.computer.set(personIndex, computer);
				login.write();
				System.exit(0);

			}
		});
		btnExit.setBounds(409, 362, 117, 29);
		frame.getContentPane().add(btnExit);

		btnSwitchUser = new JButton("Switch User");
		btnSwitchUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login.you.set(personIndex, you);
				login.computer.set(personIndex, computer);
				login.write();
				login.main(null);
				frame.setVisible(false);
			}
		});
		btnSwitchUser.setBounds(409, 403, 117, 29);
		frame.getContentPane().add(btnSwitchUser);

		txtHi = new JTextField();
		txtHi.setHorizontalAlignment(SwingConstants.CENTER);
		txtHi.setText("Hi " + name);
		txtHi.setBounds(209, 430, 130, 26);
		frame.getContentPane().add(txtHi);
		txtHi.setColumns(10);

		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comboBox.getSelectedIndex() == 0) {
					impossible = true;
				} else
					impossible = false;
			}
		});
		btnRestart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				you = 0;
				computer = 0;

				try {
					txtComputer.setText("Computer: " + computer);
					txtYou.setText("You: " + you);
				} catch (Exception eee) {
					// TODO Auto-generated catch block
					eee.printStackTrace();
				}

			}
		});

		textField_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				moveTime = Integer.valueOf(textField_11.getText().trim());
			}
		});

		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				h = !h;
				btnStart.setVisible(h);
				comboBox_2.setVisible(h);

				comboBox.setVisible(h);
				btnRestart.setVisible(h);
				txtWhoGoesFirst.setVisible(h);
				txtDifficulty.setVisible(h);

				btnStop.setVisible(!h);
				try {

					doing.resume();

				} catch (Exception e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}

			}
		});

	}

	Thread doing = new Thread() {
		public void run() {
			int q = 0;
			Picture two = null;
			while (q == 0) {
				a = new int[3][3];
				sim();
				int[] b = new int[2];
				btnStop.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						changes();

						doing.suspend();

					}
				});
				try {

					for (int llll = moveTime; llll > 0; llll--) {
						textField_10.setText(Integer.toString(llll));
						doing.sleep(1000);
						textField_10.setText("Taking Photo");
					}
					while (!(new File("/home/pi/pic8/image3.jpg").exists())) {
						Runtime.getRuntime().exec("fswebcam --no-banner /home/pi/pic8/image3.jpg");
						doing.sleep(5000);
					}
					Picture one = new Picture("/home/pi/pic8/image3.jpg");

					doing.sleep(1000);
					ArrayList<ArrayList> total = Picture.lines(one);
					liness = total.get(0);
					ends = total.get(1);
					MoveAssist.setup(ends, liness);
					if (!first) {
						for (int llll = moveTime; llll > 0; llll--) {
							textField_10.setText(Integer.toString(llll));
							doing.sleep(1000);
							textField_10.setText("Taking photo");
						}

						while (!(new File("/home/pi/pic8/image1.jpg").exists())) {
							Runtime.getRuntime().exec("fswebcam --no-banner /home/pi/pic8/image1.jpg");
							doing.sleep(5000);
						}
						two = new Picture("/home/pi/pic8/image1.jpg");
						doing.sleep(1000);
						textField_10.setText("Thinking");
					}
					int time = 1;

					if (first) {

						if (impossible)
							b = tac.firsting2(a, time);

						else {
							int z = (int) (Math.random() * 3);
							int zz = (int) (Math.random() * 3);
							while (a[z][zz] != 0) {
								z = (int) (Math.random() * 3);
								zz = (int) (Math.random() * 3);
							}
							b[0] = z;
							b[1] = zz;
						}

						a[b[0]][b[1]] = 2;
						sim();
					}

					for (int i = 0; i == 0;) {

						if (!first || time > 1) {
							textField_10.setText("Thinking");
							int[] aa = Picture.changes(one, two, a, ends, liness);
							doing.sleep(3000);

							a[aa[0]][aa[1]] = 1;

							sim();
							doing.sleep(500);
							i = done();
							doing.sleep(500);

							b = new int[2];
							if (impossible) {
								if (comboBox_2.getSelectedIndex() == 1) {
									b = tac.firsting2(a, time);
								} else {
									b = tac.firsting(a, time);
								}

							}

							else {
								int z = (int) (Math.random() * 3);
								int zz = (int) (Math.random() * 3);
								while (a[z][zz] != 0) {
									z = (int) (Math.random() * 3);
									zz = (int) (Math.random() * 3);
								}
								b[0] = z;
								b[1] = zz;
							}

							a[b[0]][b[1]] = 2;

							sim();doing.sleep(500);
							i = done();

							doing.sleep(500);
						}
						time++;
						textField_10.setText("Arm moving");
						ArrayList<Integer> newer = new ArrayList<Integer>();

						ArrayList<ArrayList<Integer>> files = thingToDo(b);

						for (int kk = 0; kk < 5; kk++) {

							newer = files.get(kk);

							newer.set(0, newer.get(0) - Main.starting.get(2));
							newer.set(1, newer.get(1) - Main.starting.get(1));

							k.mover2(newer.get(0), "elbow", newer.get(1), "shoulder");
							if (newer.get(0) > newer.get(1))
								doing.sleep(Math.abs(newer.get(0) * 50) + 1000);
							else
								doing.sleep(Math.abs((newer.get(1) * 50)) + 1000);
							if (kk == 0) {
								k.mover(90, "wrist");
								doing.sleep(4700);
							}
							if (kk == 4) {
								k.mover(-90, "wrist");
								doing.sleep(4700);
							}
							newer.clear();
						}

						k.home();
						doing.sleep(12000);
						System.out.println("done");
						txtComputer.setText("Computer: " + computer);
						txtYou.setText("You: " + you);
						one = new Picture("/home/pi/pic8/image1.jpg");
						File file2222 = new File("/home/pi/pic8/image1.jpg");
						file2222.delete();
						for (int llll = moveTime; llll > 0; llll--) {
							textField_10.setText(Integer.toString(llll));
							doing.sleep(1000);
							textField_10.setText("Taking picture");
						}

						while (!(new File("/home/pi/pic8/image1.jpg").exists())) {
							Runtime.getRuntime().exec("fswebcam --no-banner /home/pi/pic8/image1.jpg");
							doing.sleep(5000);
						}
						two = new Picture("/home/pi/pic8/image1.jpg");
						doing.sleep(1000);
						textField_10.setText("Thinking");
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				changes();

				
				doing.suspend();
			}
		}

	};
	private JButton btnExit;
	private JButton btnSwitchUser;
	private JTextField txtHi;

	public ArrayList<ArrayList<Integer>> thingToDo(int[] b) throws Exception {
		ArrayList<ArrayList<Integer>> returning1 = moveAssist.moveDistance(b[0], b[1], ends, liness);
		ArrayList<ArrayList<Integer>> returning2 = new ArrayList<ArrayList<Integer>>();

		ArrayList<Integer> newer = new ArrayList<Integer>();
		newer.add(returning1.get(0).get(0));
		newer.add(returning1.get(0).get(1));
		returning1.add(newer);

		System.out.println(returning1.size());
		returning2.add(returning1.get(0));
		returning2.add(returning1.get(2));
		returning2.add(returning1.get(1));
		returning2.add(returning1.get(3));
		returning2.add(returning1.get(4));
		return returning2;
	}

	public void changes() {
		h = !h;
		btnStart.setVisible(h);
		comboBox_2.setVisible(h);

		comboBox.setVisible(h);
		btnRestart.setVisible(h);
		txtWhoGoesFirst.setVisible(h);
		txtDifficulty.setVisible(h);
		btnStop.setVisible(!h);
	}

	public int done() {

		if (tac.winAcross(a, index) > 0 || tac.winVertical(a, index) > 0 || tac.winDiag(a, index) > 0) {
			computer++;

			return 5;
		}

		if (tac.winAcross(a, index) < 0 || tac.winVertical(a, index) < 0 || tac.winDiag(a, index) < 0) {
			you++;

			return 5;
		}

		for (int u = 0; u < 3; u++) {

			for (int uu = 0; uu < 3; uu++) {

				if (a[u][uu] == 0) {
					return 0;

				}
			}

		}
		return 5;
	}

	public void sim() {
		for (int y = 0; y < 3; y++) {
			for (int yy = 0; yy < 3; yy++) {
				if (a[y][yy] == 1) {
					boardss[y][yy].setText(symbol);
				} else if (a[y][yy] == 2) {
					boardss[y][yy].setText(symbol2);
				
				}
				else {
					boardss[y][yy].setText("");
				}

			}
		}

	}
}