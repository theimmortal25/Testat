package lager.view.lagerwindow;

import java.awt.Dimension;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import lager.view.View;

/**
 * Der JOptionPane Dialog um ein neues Lager hinzuzuf�gen
 */
public class NewLagerWindow {
	private String buttonCheck = "DEFAULT";
	private View view;
	private JPanel panel = new JPanel();
	private ObserverButton go = new ObserverButton("Weiter");
	private ObserverButton back = new ObserverButton("Zur�ck");
	private JPanel panelName = new JPanel();
	private JLabel labelName = new JLabel("Name: ");
	private JTextField textFieldName = new JTextField(10);
	private ObservableKeyListener oKLName = new ObservableKeyListener(textFieldName, "NAME");
	private JPanel panelCapacity = new JPanel();
	private JLabel labelCapacity = new JLabel("Kapazit�t: ");
	private JTextField textFieldCapacity = new JTextField(10);
	private ObservableKeyListener oKLCapacity = new ObservableKeyListener(textFieldCapacity, "CAPACITY");

	public NewLagerWindow(View view) {
		this.view = view;
	}

	/**
	 * Anzeigen des Dialogs zum hinzuf�gen eines Lagers
	 * 
	 * @return
	 */
	public Boolean optionPane() {
		go.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Window w = SwingUtilities.getWindowAncestor(go);
				w.dispose();
				buttonCheck = "WEITER";
			}
		});

		back.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Window w = SwingUtilities.getWindowAncestor(back);
				w.dispose();
			}
		});

		ObserverButton[] options = { go, back };

		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

		labelName.setPreferredSize(new Dimension(75, 20));
		labelCapacity.setPreferredSize(new Dimension(75, 20));

		oKLName.addObserver(options[0]);
		textFieldName.addKeyListener(oKLName);

		panelName.add(labelName);
		panelName.add(textFieldName);
		panel.add(panelName);

		oKLCapacity.addObserver(options[0]);
		textFieldCapacity.addKeyListener(oKLCapacity);

		panelCapacity.add(labelCapacity);
		panelCapacity.add(textFieldCapacity);
		panel.add(panelCapacity);

		JOptionPane.showOptionDialog(view, panel, "Neues Lager", JOptionPane.OK_CANCEL_OPTION,
				JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

		if (buttonCheck.equals("WEITER")) {
			return true;
		}

		return false;
	}

	public String getName() {
		return textFieldName.getText();
	}

	public int getCapacity() {
		return Integer.valueOf(textFieldCapacity.getText());
	}

}
