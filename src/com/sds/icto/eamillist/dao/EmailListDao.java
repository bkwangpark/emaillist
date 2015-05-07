package com.sds.icto.eamillist.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.sds.icto.eamillist.vo.EmailListVo;

public class EmailListDao {
	private Connection getConnection() throws ClassNotFoundException,
			SQLException {
		Connection conn = null;
		// 1. 드라이버 로딩
		Class.forName("oracle.jdbc.driver.OracleDriver");

		// 2. connection 생성
		String dbURL = "jdbc:oracle:thin:@localhost:1521:xe";
		conn = DriverManager.getConnection(dbURL, "webdb", "webdb");

		return conn;
	}

	public void insert(EmailListVo vo) throws ClassNotFoundException,
			SQLException {
		// 1. Connection 생성
		Connection conn = getConnection();

		// 2. Statement 준비, SQL문 날리기
		String sql = " insert into email_list values(email_list_no_seq.nextval, ?, ?, ?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);

		// 3. binding
		pstmt.setString(1, vo.getFirstName());
		pstmt.setString(2, vo.getLastName());
		pstmt.setString(3, vo.getEmail());

		// 4. query 실행
		pstmt.executeUpdate();
		// 5. 자원정리
		if (pstmt != null) {
			pstmt.close();
		}
		if (conn != null) {
			conn.close();
		}
	}

	public void delete(Long id) {
		
	}

	public void delete() throws ClassNotFoundException, SQLException {
		//1. Connection 생성
		Connection conn=getConnection();
		Statement stmt=conn.createStatement();
		String sql="delete * from email_list";
		stmt.executeUpdate(sql);
		
	}

	public List<EmailListVo> fetchList() throws ClassNotFoundException,
			SQLException {
		List<EmailListVo> list = new ArrayList<EmailListVo>();
		Connection conn = getConnection();
		Statement stmt = conn.createStatement();
		String sql = "select * from email_list";
		ResultSet rs = stmt.executeQuery(sql);

		while (rs.next()) {
			Long no = rs.getLong(1);
			String fname = rs.getString(2);
			String lname = rs.getString(3);
			String email = rs.getString(4);

			EmailListVo vo = new EmailListVo();
			vo.setNo(no);
			vo.setFirstName(fname);
			vo.setLastName(lname);
			vo.setEmail(email);

			list.add(vo);
		}
		if (rs != null) {
			rs.close();
		}
		if (stmt != null) {
			stmt.close();
		}
		if (conn != null) {
			conn.close();
		}
		return list;
	}
}
