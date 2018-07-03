package ispit_zad_7_v2;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

import javafx.beans.property.IntegerProperty;

public class InfoFrame extends JFrame {
	private JPanel panelTop, panelBot;
	private JButton exit, search;
	private JLabel firstLab, lastLab, depLab, idLab, citLab;
	private JTextField firstFi, lastFi, idFi, depFi, citFi;

	public InfoFrame() {
		setTitle("Student's info");
		setLayout(new GridLayout(2, 1));
		setLocationRelativeTo(null);
		setSize(600, 300);
		setVisible(false);
		createComp();
		add(panelTop);
		add(panelBot);
		layoutComp();
		activateComp();
	}

	private void createComp() {
		panelTop = new JPanel();
		panelBot = new JPanel();
		panelBot.setBorder(
				new CompoundBorder(new EmptyBorder(5, 10, 5, 10), BorderFactory.createTitledBorder("Student's info")));
		exit = new JButton("Exit");
		search = new JButton("Search");
		firstLab = new JLabel("First name:");
		lastLab = new JLabel("Last name:");
		idLab = new JLabel("Enter Unique id:");
		depLab = new JLabel("Department");
		citLab = new JLabel("Citizenship");
		firstFi = new JTextField();
		lastFi = new JTextField();
		idFi = new JTextField();
		depFi = new JTextField();
		citFi = new JTextField();

	}

	private void layoutComp() {
		panelTop.setLayout(null);
		panelTop.add(idLab);
		panelTop.add(idFi);
		panelTop.add(search);
		panelTop.add(exit);
		idLab.setBounds(150, 20, 100, 25);
		idFi.setBounds(260, 20, 125, 25);
		search.setBounds(160, 80, 125, 25);
		exit.setBounds(300, 80, 125, 25);
		// --------------------------------------------------//
		panelBot.setLayout(null);
		panelBot.add(firstFi);
		panelBot.add(lastFi);
		panelBot.add(depFi);
		panelBot.add(citFi);
		panelBot.add(lastLab);
		panelBot.add(firstLab);
		panelBot.add(citLab);
		panelBot.add(depLab);
		firstLab.setBounds(80, 40, 100, 25);
		firstFi.setBounds(160, 40, 100, 25);
		lastLab.setBounds(80, 75, 100, 25);
		lastFi.setBounds(160, 75, 100, 25);
		depLab.setBounds(325, 40, 100, 25);
		depFi.setBounds(410, 40, 100, 25);
		citLab.setBounds(325, 75, 100, 25);
		citFi.setBounds(410, 75, 100, 25);
	}

	private void activateComp() {
		exit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				clearTxt();

			}
		});
		search.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				int id = Integer.parseInt(idFi.getText());
				DataBase db = new DataBase();
				HashMap<Integer, Student> mapa = db.getBaza();
				if (mapa.containsKey(id)) {
					Student st = mapa.get(id);
					firstFi.setText(st.getFirst());
					lastFi.setText(st.getLast());
					depFi.setText(st.getDep());
					citFi.setText(st.getCit());
				} else {
					JOptionPane.showMessageDialog(null, "Ne postoji takav id u bazi", "Error",
							JOptionPane.ERROR_MESSAGE);
				}

			}
		});
	}

	private void clearTxt() {
		firstFi.setText("");
		lastFi.setText("");
		idFi.setText("");
		depFi.setText("");
		citFi.setText("");

	}
}
