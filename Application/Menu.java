package Application;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import dao.BookDao;
import entity.Series;

public class Menu {

	private BookDao bookDao = new BookDao();
	private Scanner scanner = new Scanner(System.in);
	private List<String> options = Arrays.asList(
			"Display series'",
			"Display series by id",
			"Create a series",
			"Update series length",
			"Delete a series");
	
	public void start() {
		String selection = "";
	
	do {
		printMenu();
		selection = scanner.nextLine();
		try {
			if(selection.equals("1")) {
				displaySeries();
			} else if (selection.equals("2")) {
				displayASeries();
			} else if (selection.equals("3")) {
				createSeries();
			} else if (selection.equals("4")) {
				updateSeriesLength();
			} else if (selection.equals("5")) {
				deleteSeries();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		System.out.println("Press enter to continue.....");
		scanner.nextLine();
		
		
	} while (!selection.equals("-1"));
}
	
		private void printMenu() {
		System.out.println("Select an Option: \n------------------------");
		for (int i = 0; i < options.size(); i++) {
			System.out.println(i + 1 + ") " + options.get(i));
		}
	}
		
		private void displaySeries() throws SQLException {
			List<Series> books = bookDao.getSeries();
			for (Series book : books) {
				System.out.println(book.getId() + ": " + book.getName() + " # of books: "
				+ book.getSeriesLength() + " By: " + book.getAuthor());
			}
		}
		
		private void displayASeries() throws SQLException {
			System.out.print("Enter Book id: ");
			int id = Integer.parseInt(scanner.nextLine());
			Series series = bookDao.getSeriesById(id);
			System.out.println(id + ": " + series.getName() + "# of books:"
					+ series.getSeriesLength() + " By: " + series.getAuthor());
		}
		
		private void createSeries() throws SQLException {
			System.out.print("Please enter the author's name: ");
			String author = scanner.nextLine();
			System.out.print("Please enter series name: ");
			String name = scanner.nextLine();
			System.out.print("Please enter the series length: ");
			int seriesLength = Integer.parseInt(scanner.nextLine());
			bookDao.createNewSeries(author, name, seriesLength);
						
		}
		
		private void updateSeriesLength() throws SQLException {
			System.out.print("Please Enter series id: ");
			int id = Integer.parseInt(scanner.nextLine());
			System.out.print("Please Enter the updated # of books: ");
			int num = Integer.parseInt(scanner.nextLine());
			bookDao.changeSeriesLength(num, id);
		}
		
		private void deleteSeries() throws SQLException {
			System.out.print("Please enter the id of the series you wish to delete: ");
			int id = Integer.parseInt(scanner.nextLine());
			bookDao.deleteSeriesById(id);			
		}
	
		
		
		
}
