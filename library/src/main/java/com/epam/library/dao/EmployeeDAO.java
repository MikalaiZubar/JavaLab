package com.epam.library.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.epam.library.entity.Employee;
import com.epam.library.exeption.DAOException;

public class EmployeeDAO extends AbstractDAO<Employee>{
	
	private static final Logger LOGGER = LogManager.getLogger(EmployeeDAO.class);
	private static final String CREATE = "INSERT INTO emloyee (name, dare_of_birh, email) "
			+ "values (?,?,?)";
	private static final String UPDATE = "UPDATE emloyee SET name=?, dare_of_birh=?, email=? WHERE"
			+ "book_id=?";
	private static final String DELETE = "";
	private static final String SELECT = "SELECT employee_id, name, date_of_birth, email FROM employee";
	private static final String MORE_THAN_ONE = "SELECT employee.name, count(employee_book.book_id) AS num_of_books "
			+ "FROM employee "
			+ "JOIN employee_book ON employee.employee_id=employee_book.employee_id "
			+ "GROUP BY employee.name "
			+ "HAVING count(employee_book.book_id)>1";
	private static final String LESS_THAN_THREE = "SELECT employee.name, employee.date_of_birth, "
			+ "count(employee_book.book_id) AS num_of_books "
			+ "FROM employee "
			+ "JOIN employee_book ON employee.employee_id=employee_book.employee_id "
			+ "GROUP BY employee.name "
			+ "HAVING count(employee_book.book_id)>0 AND count(employee_book.book_id)<3";
	
	
	public EmployeeDAO(){
		super();
	}

	@Override
	public boolean insert(Employee empl) throws DAOException {
		PreparedStatement ps = null;
		boolean isInserted = false;
		try{
			ps = cn.prepareStatement(CREATE);
			ps.setString(1, empl.getName());
			ps.setDate(2, empl.getDateOfBirth());
			ps.setString(3, empl.getEmail());
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
	public boolean update(Employee empl) throws DAOException {
		PreparedStatement ps = null;
		boolean isUpdated = false;
		try{
			ps = cn.prepareStatement(UPDATE);
			ps.setString(1, empl.getName());
			ps.setDate(2, empl.getDateOfBirth());
			ps.setString(3, empl.getEmail());
			ps.setInt(4, empl.getEmployeeId());
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
	public List<Employee> select() throws DAOException {
		List<Employee> employees = new ArrayList<>();
		PreparedStatement ps = null;
		try {
			ps = cn.prepareStatement(SELECT);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				employees.add(new Employee(rs.getInt(1), rs.getString(2), rs.getDate(3),
						rs.getString(4)));
			}
		} catch (SQLException e) {
			throw new DAOException("Database error", e);
		}finally{
			close(ps);
		}
		return employees;
	}
	
	@Override
	public boolean delete(Employee t) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	public List<String> selectMoreThanOne() throws DAOException{
		PreparedStatement ps = null;
		List<String> dataList = new ArrayList<>();
		try{
			ps = cn.prepareStatement(MORE_THAN_ONE);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				dataList.add(rs.getString(1) + " : " + rs.getInt(2));
			}
		} catch (SQLException e) {
			throw new DAOException("Database error", e);
		}finally{
			close(ps);
		}
		return dataList;
	}
	
	public List<String> selectLessThanThree() throws DAOException{
		PreparedStatement ps = null;
		List<String> dataList = new ArrayList<>();
		try{
			ps = cn.prepareStatement(LESS_THAN_THREE);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				dataList.add(rs.getString(1) + " : " + rs.getDate(2) + " : " + rs.getInt(3));
			}
		} catch (SQLException e) {
			throw new DAOException("Database error", e);
		}finally{
			close(ps);
		}
		return dataList;
	}
		
}
