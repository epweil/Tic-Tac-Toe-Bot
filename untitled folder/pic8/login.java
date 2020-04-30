import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class login {
	public static game g;
	private JFrame frame;
	private JTextField txtWelcome;
	private JTextField txtPreviousUser;
	private JTextField txtNewUser;
	private JTextField txtEnterName;
	public static ArrayList<String> names = new ArrayList<String>();
	public static ArrayList<Integer> you = new ArrayList<Integer>();
	public static ArrayList<Integer> computer = new ArrayList<Integer>();
	public static File file = new File("names.txt");
	public static File file2 = new File("you.txt");
	public static File file3 = new File("computer.txt");
	private JTextField txtByEthanWeilheimer;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					textReader tr = new textReader();

					names = tr.Stringget1("names.txt");
					you = tr.get1("you.txt");
					computer = tr.get1("computer.txt");
					login window = new login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setForeground(Color.WHITE);
		frame.getContentPane().setBackground(Color.BLUE);
		frame.setBounds(100, 100, 631, 484);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		txtWelcome = new JTextField();
		txtWelcome.setFont(new Font("Lucida Grande", Font.PLAIN, 70));
		txtWelcome.setHorizontalAlignment(SwingConstants.CENTER);
		txtWelcome.setForeground(Color.WHITE);
		txtWelcome.setBackground(Color.BLUE);
		txtWelcome.setText("Welcome\n");
		txtWelcome.setBounds(0, 0, 631, 114);
		frame.getContentPane().add(txtWelcome);
		txtWelcome.setColumns(10);

		txtPreviousUser = new JTextField();
		txtPreviousUser.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		txtPreviousUser.setHorizontalAlignment(SwingConstants.CENTER);
		txtPreviousUser.setForeground(Color.WHITE);
		txtPreviousUser.setBackground(Color.BLUE);
		txtPreviousUser.setEditable(false);
		txtPreviousUser.setText("Previous User");
		txtPreviousUser.setBounds(25, 189, 227, 63);
		frame.getContentPane().add(txtPreviousUser);
		txtPreviousUser.setColumns(10);

		txtNewUser = new JTextField();
		txtNewUser.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		txtNewUser.setHorizontalAlignment(SwingConstants.CENTER);
		txtNewUser.setForeground(Color.WHITE);
		txtNewUser.setBackground(Color.BLUE);
		txtNewUser.setEditable(false);
		txtNewUser.setText("New User");
		txtNewUser.setColumns(10);
		txtNewUser.setBounds(396, 189, 201, 63);
		frame.getContentPane().add(txtNewUser);

		JComboBox comboBox = new JComboBox(names.toArray());
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int x = comboBox.getSelectedIndex();
					g = new game(names.get(x), you.get(x), computer.get(x), x);
					g.frame.setVisible(true);
					frame.setVisible(false);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		comboBox.setForeground(Color.WHITE);
		comboBox.setBackground(Color.BLUE);
		comboBox.setBounds(25, 264, 227, 63);
		frame.getContentPane().add(comboBox);

		txtEnterName = new JTextField();
		txtEnterName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				names.add(txtEnterName.getText());
				you.add(0);
				computer.add(0);

				try {
					Thread.sleep(500);
					g = new game(txtEnterName.getText(), 0, 0, names.size() - 1);
					g.frame.setVisible(true);
					frame.setVisible(false);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		txtEnterName.setForeground(Color.WHITE);
		txtEnterName.setBackground(Color.BLUE);
		txtEnterName.setText("Enter Name");
		txtEnterName.setBounds(396, 281, 201, 26);
		frame.getContentPane().add(txtEnterName);
		txtEnterName.setColumns(10);

		txtByEthanWeilheimer = new JTextField();
		txtByEthanWeilheimer.setEditable(false);
		txtByEthanWeilheimer.setText("By: Ethan Weilheimer");
		txtByEthanWeilheimer.setBounds(0, 430, 162, 26);
		frame.getContentPane().add(txtByEthanWeilheimer);
		txtByEthanWeilheimer.setColumns(10);

	}

	public static void write() {
		textwriter tw = new textwriter();
		tw.write(file2, you);
		tw.write(file3, computer);
		tw.writeString(file, names);
	}
}
