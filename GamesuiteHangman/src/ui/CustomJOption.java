package ui;

import javax.swing.JOptionPane;

import domain.exceptions.CancelledException;

public class CustomJOption {

	/**
	 * Maak een custom JOptionInputDialog dat controleert of de gebruiker
	 * "cancel" heeft gedrukt
	 * 
	 * @param message
	 * @param title
	 * @return waarde dat in de input is ingevuld
	 * @throws CancelledException,
	 *             indien de user cancel klikt
	 */
	protected static String showJOptionInputDialog(final String message, final String title) throws CancelledException {
		String value = JOptionPane.showInputDialog(null, message, title, JOptionPane.PLAIN_MESSAGE);

		if (value == null) {
			throw new CancelledException("User pressed the cancel button");
		} else {
			return value;
		}
	}

	/**
	 * Maak een custom JOptionDropdownDialog dat controleert of de gebruiker
	 * "cancel" heeft gedrukt
	 * 
	 * @param message
	 * @param title
	 * @param list
	 * @param selectedItem
	 * @return waarde dat in de input is ingevuld
	 * @throws CancelledException,
	 *             indien de user cancel klikt
	 */
	protected static String showJOptionDropdownDialog(final String message, final String title, String[] list,
			String selectedItem) throws CancelledException {
		String value = (String) JOptionPane.showInputDialog(null, message, title, JOptionPane.QUESTION_MESSAGE, null,
				list, selectedItem);

		if (value == null) {
			throw new CancelledException("User pressed the cancel button");
		} else {
			return value;
		}
	}

}
