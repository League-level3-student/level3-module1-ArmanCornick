package _06_Intro_To_Hash_Maps;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class _02_LogSearch implements ActionListener {
	/*
	 * Crate a HashMap of Integers for the keys and Strings for the values.
	 * Create a GUI with three buttons.
	 * Button 1: Add Entry
	 *      When this button is clicked, use an input dialog to ask the user
	 *      to enter an ID number.
	 *      After an ID is entered, use another input dialog to ask the user
	 *      to enter a name. Add this information as a new entry to your
	 *      HashMap.
	 * 
	 * Button 2: Search by ID
	 *      When this button is clicked, use an input dialog to ask the user
	 *      to enter an ID number.
	 *      If that ID exists, display that name to the user.
	 *      Otherwise, tell the user that that entry does not exist.
	 * 
	 * Button 3: View List
	 *      When this button is clicked, display the entire list in a message
	 *      dialog in the following format:
	 *      ID: 123  Name: Harry Howard
	 *      ID: 245  Name: Polly Powers
	 *      ID: 433  Name: Oliver Ortega
	 *      etc...
	 * 
	 * When this is complete, add a fourth button to your window.
	 * Button 4: Remove Entry
	 *      When this button is clicked, prompt the user to enter an ID using
	 *      an input dialog.
	 *      If this ID exists in the HashMap, remove it. Otherwise, notify the
	 *      user that the ID is not in the list.
	 */

	JFrame frame;
	JPanel panel;
	Button entry;
	Button search;
	Button view;
	Button remove;
	HashMap<Integer, String> hash;

	_02_LogSearch() {
		hash = new HashMap<Integer, String>();
		frame = new JFrame();
		panel = new JPanel();
		entry = new Button();
		search = new Button();
		view = new Button();
		remove = new Button();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel);
		panel.add(remove);
		panel.add(entry);
		panel.add(view);
		panel.add(search);
		entry.addActionListener(this);
		search.addActionListener(this);
		view.addActionListener(this);
		remove.addActionListener(this);
		entry.setLabel("Enter Index");
		search.setLabel("Search Index");
		view.setLabel("View Index");
		remove.setLabel("Remove Index");
		frame.pack();
	}



	public static void main(String[] args) {
		_02_LogSearch e = new _02_LogSearch();
	}



	@Override
	public void actionPerformed(ActionEvent z) {
		// TODO Auto-generated method stub
		if(z.getSource() == entry) {
			String IDS = JOptionPane.showInputDialog("What ID do you want to assign a value to?");
			Integer ID = Integer.parseInt(IDS);
			String entryAnswer = JOptionPane.showInputDialog("What would you like to assign to this ID?");
			hash.put(ID,entryAnswer);
		}
		if(z.getSource() == view) {
			String list = "";
			for(int q : hash.keySet()) {
				list += "key:" + q + ", value:" + hash.get(q) +  "\n";
			}
			JOptionPane.showMessageDialog(null, list);
		}
		if(z.getSource() == search) {
			String IDsearchS = JOptionPane.showInputDialog("What ID do you want to check the value of?");
			Integer IDsearch = Integer.parseInt(IDsearchS);
			if(hash.containsKey(IDsearch)) {
				JOptionPane.showMessageDialog(null, "The ID is " + hash.get(IDsearch));
			} else {
				
			}
		}
		if(z.getSource() == remove) {
			String IDS = JOptionPane.showInputDialog("What ID do you want to assign a value to?");
			Integer ID = Integer.parseInt(IDS);
			String entryAnswer = JOptionPane.showInputDialog("What would you like to assign to this ID?");
			hash.put(ID,entryAnswer);
		}
	}

}
