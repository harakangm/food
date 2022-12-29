package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import DTO.Menu;
import DTO.Rstrn;

public class FoodDAO {
	final String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";
	final String JDBC_URL = "jdbc:oracle:thin:@localhost:1521:xe";

	public Connection open() {
		Connection conn = null;	
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(JDBC_URL,"test","test1234");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public ArrayList<Menu> showMenu() throws SQLException {
		Connection conn = open();
		String sql = " select * from menu ";
		ArrayList<Menu> menu = new ArrayList<>();
		
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		
		try(conn; ps; rs){
			
			while(rs.next()) {
				Menu m = new Menu();
				m.setFood_name(rs.getString(1));
				m.setPrice(rs.getInt(2));
				m.setMtr_inf(rs.getString(3));
				m.setClr_inf(rs.getString(4));
				m.setFood_img(rs.getString(5));
				menu.add(m);
			}		
		}
		return menu;
	}
	
	public Menu detail(String name) throws SQLException {
		Connection conn = open();
		String sql = " select * from menu where  food_name = ? ";
		Menu m = new Menu();
		
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, name);
		ResultSet rs = ps.executeQuery();
		
		try(conn; ps; rs) {
			while(rs.next()) {
				m.setFood_name(rs.getString(1));
				m.setPrice(rs.getInt(2));
				m.setMtr_inf(rs.getString(3));
				m.setClr_inf(rs.getString(4));
				m.setFood_img(rs.getString(5));	
			}
		}
		
		return m;
	}
	
	//주문자 정보입력받기
	public void insert(String name,String food, int price,String addr) {
		Rstrn rt = new Rstrn();
		try {			
			Connection conn = open();
			String sql = " insert into rstrn values(order_no.nextval,?,?,?,?,to_char(sysdate, 'yyyy-mm-dd')) ";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, food);
			ps.setInt(3, price);
			ps.setString(4, addr);
			
			ps.executeUpdate();
			
			conn.close();
			ps.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}
						
	}
	
	public Rstrn insertOrderList(HttpServletRequest request) throws SQLException {
		Rstrn rt = new Rstrn();
		Connection conn = open();
		String sql = " SELECT * FROM (SELECT * FROM rstrn ORDER BY ROWNUM DESC) WHERE ROWNUM = 1 ";
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ResultSet rs = ps.executeQuery();
		
		try(conn; ps; rs;){
			while (rs.next()) {
				rt.setOrder_number(rs.getInt(1));
				rt.setCust_name(rs.getString(2));
				rt.setFood_name(rs.getString(3));
				rt.setPay(rs.getInt(4));
				rt.setOrder_addr(rs.getString(5));
				rt.setPay_t(rs.getString(6));
			}
			
		}
		return rt;
	}
	
	public Rstrn vieworder(HttpServletRequest request) throws SQLException {
		Rstrn rt = new Rstrn();
		int order_number = Integer.parseInt(request.getParameter("order_number"));
		Connection conn = open();
		String sql = " select * from rstrn where order_number = ? ";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, order_number);
		
		ResultSet rs = ps.executeQuery();
		
		try(conn; ps; rs){
			while (rs.next()) {
				rt.setOrder_number(rs.getInt(1));
				rt.setCust_name(rs.getString(2));
				rt.setFood_name(rs.getString(3));
				rt.setPay(rs.getInt(4));
				rt.setOrder_addr(rs.getString(5));
				rt.setPay_t(rs.getString(6));
			}

		}
		
		return rt;
	}
	
	public Rstrn lookup (int num) throws SQLException {
		Rstrn rt = new Rstrn();
		Connection conn = open();
		String sql = " select * from rstrn where order_number = ? ";
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ps.setInt(1, num);
		ResultSet rs = ps.executeQuery();
		
		try(conn; ps; rs){
			while(rs.next()) {
				rt.setOrder_number(rs.getInt(1));
				rt.setCust_name(rs.getString(2));
				rt.setFood_name(rs.getString(3));
				rt.setPay(rs.getInt(4));
				rt.setOrder_addr(rs.getString(5));
				rt.setPay_t(rs.getString(6));
			}
			return rt;
		}
		
	}
	
	public void delete(int num) throws SQLException {
		Connection conn = open();
		String sql = " delete from rstrn where order_number = ? ";
		
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ps.setInt(1, num);
		
		ps.executeUpdate();
		
		conn.close();
		ps.close();
	}
	
	public void modify(int num) {
		Rstrn rt = new Rstrn();
		Connection conn = open();
		String sql = "update rstrn set order_addr = ? where order_number = ? ";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, num);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
