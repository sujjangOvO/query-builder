package jdbc;

import java.sql.*;

import domain.User;

public class Jdbc {


	public static void main(String[] args) throws Exception {
		String delete_sql = "DELETE FROM user WHERE no = ?";
		String update_sql = " UPDATE user SET name = ? WHERE no = ?";
		String select_sql = "SELECT * FROM user";
		String insert_sql = "INSERT INTO user(name, age) VALUES(?, ?)";

		Connection connection = getConnection();
		PreparedStatement pstmt = connection.prepareStatement(select_sql);
		ResultSet rs = pstmt.executeQuery();
		while((rs.next())) {
			User user = new User(rs.getInt("no"), rs.getString("name"), rs.getInt("age"));
			System.out.println(user);
		}

		pstmt = connection.prepareStatement(delete_sql);
		pstmt.setInt(1, 9);
		int delete = pstmt.executeUpdate();
		System.out.println("delete :" + delete );


		pstmt = connection.prepareStatement(update_sql);
		pstmt.setString(1, "수정");
		pstmt.setInt(2, 2);
		boolean update = pstmt.execute(); // excute는 모든 구문을 수행할 수 있으나 반환값은 오직 true/false, rs를 담을 수 없다
		System.out.println("update : " + update ); // return값이 ResultSet인 경우만 true이므로 이 경우 false

		pstmt = connection.prepareStatement(insert_sql);
		pstmt.setString(1, "NEW멤버");
		pstmt.setInt(2, 17);
		int insert = pstmt.executeUpdate();
		System.out.println("insert : " + insert);


		connection.close();
		pstmt.close();
		rs.close();
	}

	private static Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String dburl = "jdbc:mysql://localhost:3306/jdbc"; // jdbc는 db의 스키마 이름

		// DriverManger.getConnection은 실제 자바프로그램과 DB를 네트워크 상에서 연결해준다
		// Connection은 네트워크상 연결 자체를 의미한다
		// 보통 Connection 하나당 트랜잭션 하나를 관리한다
		Connection connection = DriverManager.getConnection(dburl, "spring4", "spring4");
		return connection;
	}

	private static void close(Connection connection, PreparedStatement pstmt) {
		if (pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
