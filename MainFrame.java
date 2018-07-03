package ispit_zad_7_v2;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.LabelUI;

import javafx.scene.control.ComboBox;

public class MainFrame extends JFrame {
	private JPanel panelTop, panelBot;
	private JLabel firstLab, lastLab, depLab, idLab;
	private JTextField firstFi, lastFi, idFi;
	private JRadioButton cro, fore;
	private JComboBox<String> combo;
	private JButton send, cancel, search;
	private InfoFrame infoFrame;

	public MainFrame() {
		setTitle("Enrolment app");
		setLayout(new BorderLayout());
		setSize(600, 400);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		createComp();
		add(panelTop, BorderLayout.CENTER);
		add(panelBot, BorderLayout.SOUTH);
		layoutComp();
		activateComp();

	}

	private void createComp() {
		panelTop = new JPanel();
		panelTop.setBorder(
				new CompoundBorder(new EmptyBorder(10, 10, 0, 10), BorderFactory.createTitledBorder("Student's data")));
		firstLab = new JLabel("First name:");
		lastLab = new JLabel("Last name:");
		idLab = new JLabel("Unique id:");
		firstFi = new JTextField();
		lastFi = new JTextField();
		idFi = new JTextField();
		depLab = new JLabel("Department:");
		cro = new JRadioButton("CRO citizen");
		fore = new JRadioButton("Foreign citizen");
		ButtonGroup group = new ButtonGroup();
		group.add(cro);
		group.add(fore);
		cro.setSelected(true);
		String[] str = { "Dep 1", "Dep 2", "Dep 3", "Dep 4", "Dep 5" };
		combo = new JComboBox<String>(str);

		// ----------------------------------------------//
		panelBot = new JPanel();
		send = new JButton("Send");
		cancel = new JButton("Cancel");
		search = new JButton("Search");
		panelBot.add(send);
		panelBot.add(cancel);
		panelBot.add(search);
		search.setEnabled(false);
		infoFrame = new InfoFrame();
	}

	private void layoutComp() {
		panelBot.setLayout(new FlowLayout(FlowLayout.CENTER, 100, 25));
		panelTop.setLayout(null);
		panelTop.add(firstLab);
		panelTop.add(lastLab);
		panelTop.add(idLab);
		panelTop.add(firstFi);
		panelTop.add(lastFi);
		panelTop.add(idFi);
		panelTop.add(depLab);
		panelTop.add(cro);
		panelTop.add(fore);
		panelTop.add(combo);
		combo.setSelectedIndex(2);
		// ----------------------------//
		firstLab.setBounds(40, 40, 100, 25);
		firstFi.setBounds(40, 65, 100, 25);
		idLab.setBounds(40, 100, 100, 25);
		idFi.setBounds(40, 125, 100, 25);
		lastLab.setBounds(200, 40, 100, 25);
		lastFi.setBounds(200, 65, 100, 25);
		depLab.setBounds(360, 40, 100, 25);
		combo.setBounds(360, 65, 150, 25);
		cro.setBounds(210, 150, 125, 25);
		fore.setBounds(210, 180, 125, 25);

	}

	private void activateComp() {
		search.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				infoFrame.setVisible(true);

			}
		});
		send.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				String first = firstFi.getText();
				String last = lastFi.getText();
				int id = Integer.parseInt(idFi.getText());
				String dep = combo.getSelectedItem().toString();
				String cit;
				if (cro.isSelected()) {
					cit = cro.getText();
				} else {
					cit = fore.getText();
				}

				Student st = new Student(first, last, id, dep, cit);
				DataBase data = new DataBase();

				if (data.getBaza().containsKey(id)) {
					JOptionPane.showMessageDialog(null, "Takav id vec postoji", "Error", JOptionPane.ERROR_MESSAGE);
				} else {
					data.addToBase(st, id);
				}

				if (data.getBaza().size() > 2) {
					search.setEnabled(true);
				}
			}
		});
	}

}
