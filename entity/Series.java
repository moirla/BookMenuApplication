package entity;

public class Series {

	private int id;
	private String author;
	private String name;
	private int seriesLength;
	
	public Series(int id, String author, String name, int seriesLength) {
		this.setId(id);
		this.setAuthor(author);
		this.setName(name);
		this.setSeriesLength(seriesLength);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSeriesLength() {
		return seriesLength;
	}

	public void setSeriesLength(int seriesLength) {
		this.seriesLength = seriesLength;
	}
	
}
