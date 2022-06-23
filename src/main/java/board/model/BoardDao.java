package board.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BoardDao { // DAO(Data Access Object)
	private static BoardDao boardDao = null;
	
	private BoardDao() {

		try { Class.forName("oracle.jdbc.OracleDriver"); }		// 오라클이 존재한다면 
		catch (Exception e) { e.printStackTrace(); } 

	}
	
	private Connection getConnection() throws Exception {

		return DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521:xe", "oj", "oj"); // 연결객체 넣어준다;
	}
	
	public static BoardDao getInstance() {
		if(boardDao == null) {
			boardDao = new BoardDao();
		}
		return boardDao;
	}

	private void dbClose(Connection conn, PreparedStatement pstmt, ResultSet rs) {
		// 얻어온 자원 역순으로 닫아준다.
		if (rs != null) try { rs.close(); } catch (Exception e) {}
		if (pstmt != null) try { pstmt.close(); } catch (Exception e) {}
		if (conn != null) try { conn.close(); } catch (Exception e) {}
	}
	
	private void dbClose(Connection conn, PreparedStatement pstmt) {
		// 얻어온 자원 역순으로 닫아준다.
		if (pstmt != null) try { pstmt.close(); } catch (Exception e) {}
		if (conn != null) try { conn.close(); } catch (Exception e) {}
	}
	
	public List<BoardDto> getBoardList() {

		List<BoardDto> list = new ArrayList<>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null; // 쿼리 실행한 결과 데이터를 담고 있는 객체

		String sql = "SELECT no, title, name, to_char(writeday, 'YYYY-MM-DD') AS writeday, readcount ";
		sql += "FROM m1board ORDER BY no DESC"; // 글번호

		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				BoardDto boardDto = new BoardDto();
				boardDto.setNo(rs.getLong("no"));
				boardDto.setTitle(rs.getString("title"));
				boardDto.setName(rs.getString("name"));
				boardDto.setWriteday(rs.getString("writeday"));
				boardDto.setReadcount(rs.getInt("readcount"));

				list.add(boardDto);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose(conn, pstmt, rs);
		}

		return list;
	}

	

	public boolean insertBoard(BoardDto boardDto) {

		String sql = "INSERT INTO m1board(no, title, name, password, content) ";
		sql += "VALUES(m1board_seq.nextval, ?, ?, ?, ?)";

		boolean result = false;

		Connection conn = null; // JDBC 연결 위한 객체
		PreparedStatement pstmt = null; // sql 쿼리문 준비시켜 놓는 객체
		// ResultSet rs = null;

		try {
			conn = getConnection();

			pstmt = conn.prepareStatement(sql); // 미리 sql넘겨주기
			pstmt.setString(1, boardDto.getTitle());
			pstmt.setString(2, boardDto.getName());
			pstmt.setString(3, boardDto.getPassword());
			pstmt.setString(4, boardDto.getContent()); // ?네개 바인딩처리

			pstmt.executeUpdate(); // executeQuery = select할때 거의
									// executeUpdate = 글쓰기, 수정, 삭제
			result = true;

		} catch (Exception e) {
			e.printStackTrace();
		} finally { // 얻어온 자원 역순으로 닫아준다.
			dbClose(conn, pstmt);
		}

		return result;
	}

	
}
