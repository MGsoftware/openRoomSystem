package DAO;

import java.util.ArrayList;
import java.sql.*;

import Object.Room;

public class RoomDAO {

	public RoomDAO() {
	}

	public ArrayList<Room> getRoomList() {
		ArrayList<Room> rooms = new ArrayList<Room>();
		rooms.clear();
		// 定义数据库驱动程序
		String DBDRIVER = "sun.jdbc.odbc.JdbcOdbcDriver";
		// 定义数据库连接地址
		String DBURL = "jdbc:odbc:" + "OpenRoomDB";
		// 定义数据库连接对象，属于java.sql包中的接口
		Connection conn = null;
		// 定义Statement对象，用于操作数据库
		Statement stmt = null;
		// 定义一字符串变量，用于保存SQL语句
		String sql = null;

		ResultSet r = null;

		// 1、加载驱动程序
		try {
			Class.forName(DBDRIVER);
		} catch (Exception e) {
			System.out.println("数据库驱动程序加载失败！！！");
			return rooms;
		}

		// 2、连接数据库
		try {
			conn = DriverManager.getConnection(DBURL);
		} catch (Exception e) {
			System.out.println("数据库连接失败！！！");

			return rooms;
		}

		// 3、操作数据库
		// 通过Connection对象实例化Statement对象
		try {
			stmt = conn.createStatement();
			// 为sql变量赋值
			// 插入语句
			sql = "SELECT * FROM RoomTable ORDER BY roomID";
			r = stmt.executeQuery(sql);
			while (r.next()) {
				rooms.add(new Room(r.getInt("roomID"),
						r.getBoolean("isLiving"), r.getFloat("price")));
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("操作数据库失败！！！");
			return rooms;
		}

		// 4、关闭数据库
		try {
			// 关闭操作
			stmt.close();
			// 关闭连接
			conn.close();
		} catch (Exception e) {
			System.out.println("数据库关闭失败！！！");
			return rooms;
		}
		return rooms;
	}

	public void changeRoomState(Room room) {
		// 定义数据库驱动程序
		String DBDRIVER = "sun.jdbc.odbc.JdbcOdbcDriver";
		// 定义数据库连接地址
		String DBURL = "jdbc:odbc:" + "OpenRoomDB";
		// 定义数据库连接对象，属于java.sql包中的接口
		Connection conn = null;
		// 定义Statement对象，用于操作数据库
		Statement stmt = null;
		// 定义一字符串变量，用于保存SQL语句
		String sql_del = null;
		String sql_insert = null;

		ResultSet r = null;

		// 1、加载驱动程序
		try {
			Class.forName(DBDRIVER);
		} catch (Exception e) {
			System.out.println("数据库驱动程序加载失败！！！");
			return;
		}

		// 2、连接数据库
		try {
			conn = DriverManager.getConnection(DBURL);
		} catch (Exception e) {
			System.out.println("数据库连接失败！！！");

			return;
		}

		// 3、操作数据库
		// 通过Connection对象实例化Statement对象
		try {
			stmt = conn.createStatement();
			// 为sql变量赋值
			// 插入语句
			sql_del = "DELETE * FROM RoomTable WHERE roomID = " + String.valueOf(room.getRoomID());
			stmt.execute(sql_del);
			
			sql_insert = "INSERT into RoomTable(roomID,isLiving,price) values(?,?,?);";
			PreparedStatement ppst=conn.prepareStatement(sql_insert);  
            ppst.setInt(1, room.getRoomID());
            ppst.setBoolean(2, room.isLiving());
            ppst.setFloat(3, room.getPrice());             
            ppst.executeUpdate();  

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("操作数据库失败！！！");
			return;
		}

		// 4、关闭数据库
		try {
			// 关闭操作
			stmt.close();
			// 关闭连接
			conn.close();
		} catch (Exception e) {
			System.out.println("数据库关闭失败！！！");
			return;
		}
		return;
	}
}
