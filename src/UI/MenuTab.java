package UI;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;

public class MenuTab extends MenuBar {

	private Menu file;
	private Menu help;

	public MenuItem nBook; // New Book
	public MenuItem exit; // Exit;

	public MenuTab() {
		file = new Menu("File");
		help = new Menu("Help");

		nBook = new MenuItem("New Book");
		exit = new MenuItem("Exit");

		file.getItems().addAll(nBook, exit);
		getMenus().addAll(file, help);

	}
}
