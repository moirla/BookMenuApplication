package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Series;

public class BookDao {

	private Connection connection;
	private final String CREATE_NEW_SERIES_QUERY =												//CREATE 
			"INSERT INTO series(author, name, series_length) VALUES (?, ?, ?)";			
	private final String GET_SERIES_BY_ID	= "SELECT * FROM series WHERE id = ?";  //READ
	private final String CHANGE_SERIES_LENGTH_QUERY = "UPDATE series SET series_length = ? WHERE id = ?";	//UPDATE 
	private final String DELETE_SERIES_BY_ID_QUERY = "DELETE FROM series WHERE id = ?";			//DELETE
	private final String GET_SERIES_QUERY = "SELECT * FROM series";
	
	public BookDao() {
		connection = BConnection.getConnection();
	}
	
	public void createNewSeries(String author, String name, int series_length)
			throws SQLException {
		PreparedStatement ps = connection.prepareStatement(CREATE_NEW_SERIES_QUERY);
		ps.setString(1, author);
		ps.setString(2, name);
		ps.setInt(3, series_length);
		ps.executeUpdate();		
	}
	
	public Series getSeriesById(int id) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(GET_SERIES_BY_ID);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		rs.next();
		return populateSeries(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));
	}	
	
	public void changeSeriesLength(int num, int id) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(CHANGE_SERIES_LENGTH_QUERY);
		ps.setInt(1, num);
		ps.setInt(2, id);
		ps.executeUpdate();
	}
	
	public void deleteSeriesById(int id) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(DELETE_SERIES_BY_ID_QUERY);
		ps.setInt(1, id);
		ps.executeUpdate();
	}
	
	public List<Series> getSeries() throws SQLException{
		ResultSet rs = connection.prepareStatement(GET_SERIES_QUERY).executeQuery();
		List<Series> series = new ArrayList<Series>();
		
		while(rs.next()) {
			series.add(populateSeries(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4)));
		}
		
		return series;
	}
	
	private Series populateSeries(int id, String author, String name, int length) {
		return new Series(id, author, name, length);
	}
		
}
