package com.epam.library.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.epam.library.entity.Book;
import com.epam.library.exeption.DAOException;



public class BookDAO extends AbstractDAO<Book>{
	
	private static final String CREATE = "INSERT INTO book (brief, publish_year, author) "
			+ "values (?,?,?)";
	private static final String UPDATE = "UPDATE book SET brief=?, publish_year=?, author=? WHERE"
			+ "book_id=?";
	private static final String DELETE = "";
	private static final String SELECT = "SELECT book_id, brief, publish_year, author FROM book";
	private static final String RENAME = "UPDATE book SET brief=? WHERE brief=?";
	
	
	public BookDAO(){
		super();
	}

	@Override
	public boolean insert(Book book) throws DAOException{
		PreparedStatement ps = null;
		boolean isInserted = false;
		try{
			ps = cn.prepareStatement(CREATE);
			ps.setString(1, book.getBrief());
			ps.setInt(2, book.getPublishYear());
			ps.setString(3, book.getAuthor());
			ps.executeUpdate();
			isInserted = true;
		}catch (SQLException e){
			throw new DAOException("Database error", e);
		}finally{
			close(ps);
		}
		return isInserted;
	}

	@Override
	public boolean update(Book book) throws DAOException {
		PreparedStatement ps = null;
		boolean isUpdated = false;
		try{
			ps = cn.prepareStatement(UPDATE);
			ps.setString(1, book.getBrief());
			ps.setInt(2, book.getPublishYear());
			ps.setString(3, book.getAuthor());
			ps.setInt(4, book.getBookId());
			ps.executeUpdate();
			isUpdated = true;
		}catch (SQLException e){
			throw new DAOException("Database error", e);
		}finally{
			close(ps);
		}
		return isUpdated;
		
	}

	@Override
	public List<Book> select() throws DAOException {
		List<Book> books = new ArrayList<>();
		PreparedStatement ps = null;
		try {
			ps = cn.prepareStatement(SELECT);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				books.add(new Book(rs.getInt(1), rs.getString(2), rs.getInt(3),
						rs.getString(4)));
			}
		} catch (SQLException e) {
			throw new DAOException("Database error", e);
		}finally{
			close(ps);
		}
		return books;
	}

	@Override
	public boolean delete(Book t) throws DAOException {
		return false;
		// TODO Auto-generated method stub
		
	}
	
	public boolean renameBrief(String oldBrief, String newBrief) throws DAOException{
		boolean isUpdated = false;
		PreparedStatement ps = null;
		try{
			ps = cn.prepareStatement(RENAME);
			ps.setString(1, newBrief);
			ps.setString(2, oldBrief);
			ps.executeUpdate();
			isUpdated = true;
		}catch (SQLException e){
			throw new DAOException("Database error", e);
		}finally{
			close(ps);
		}
		return isUpdated;
	}

	

}
