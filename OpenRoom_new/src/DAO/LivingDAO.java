package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import Object.Guest;
import Object.Room;

public class LivingDAO {

	public String getGuestIDByroomID(int roomID) {
		String guest = null;
		// �������ݿ���������
		String DBDRIVER = "sun.jdbc.odbc.JdbcOdbcDriver";
		// �������ݿ����ӵ�ַ
		String DBURL = "jdbc:odbc:" + "OpenRoomDB";
		// �������ݿ����Ӷ�������java.sql���еĽӿ�
		Connection conn = null;
		// ����Statement�������ڲ������ݿ�
		Statement stmt = null;
		// ����һ�ַ������������ڱ���SQL���
		String sql = null;

		ResultSet r = null;

		// 1��������������
		try {
			Class.forName(DBDRIVER);
		} catch (Exception e) {
			System.out.println("���ݿ������������ʧ�ܣ�����");
			return null;
		}

		// 2���������ݿ�
		try {
			conn = DriverManager.getConnection(DBURL);
		} catch (Exception e) {
			System.out.println("���ݿ�����ʧ�ܣ�����");

			return null;
		}

		// 3���������ݿ�
		// ͨ��Connection����ʵ����Statement����
		try {
			stmt = conn.createStatement();
			// Ϊsql������ֵ
			// �������
			sql = "SELECT * FROM LivingTable WHERE roomID = "
					+ String.valueOf(roomID);
			r = stmt.executeQuery(sql);
			while (r.next()) {
				guest = r.getString("guestID");
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("�������ݿ�ʧ�ܣ�����");
			return null;
		}

		// 4���ر����ݿ�
		try {
			// �رղ���
			stmt.close();
			// �ر�����
			conn.close();
		} catch (Exception e) {
			System.out.println("���ݿ�ر�ʧ�ܣ�����");
			return null;
		}
		return guest;
	}

	public void createLiving(int room, String guest) {
		// �������ݿ���������
		String DBDRIVER = "sun.jdbc.odbc.JdbcOdbcDriver";
		// �������ݿ����ӵ�ַ
		String DBURL = "jdbc:odbc:" + "OpenRoomDB";
		// �������ݿ����Ӷ�������java.sql���еĽӿ�
		Connection conn = null;
		// ����Statement�������ڲ������ݿ�
		Statement stmt = null;
		// ����һ�ַ������������ڱ���SQL���
		String sql_insert = null;

		ResultSet r = null;

		// 1��������������
		try {
			Class.forName(DBDRIVER);
		} catch (Exception e) {
			System.out.println("���ݿ������������ʧ�ܣ�����");
			return;
		}

		// 2���������ݿ�
		try {
			conn = DriverManager.getConnection(DBURL);
		} catch (Exception e) {
			System.out.println("���ݿ�����ʧ�ܣ�����");

			return;
		}

		// 3���������ݿ�
		// ͨ��Connection����ʵ����Statement����
		try {
			stmt = conn.createStatement();
			// Ϊsql������ֵ
			// �������

			sql_insert = "INSERT into LivingTable(roomID,guestID) values(?,?);";
			PreparedStatement ppst = conn.prepareStatement(sql_insert);
			ppst.setInt(1, room);
			ppst.setString(2, guest);
			ppst.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("�������ݿ�ʧ�ܣ�����");
			return;
		}

		// 4���ر����ݿ�
		try {
			// �رղ���
			stmt.close();
			// �ر�����
			conn.close();
		} catch (Exception e) {
			System.out.println("���ݿ�ر�ʧ�ܣ�����");
			return;
		}
		return;
	}

	public void deleteLiving(int room) {
		// �������ݿ���������
		String DBDRIVER = "sun.jdbc.odbc.JdbcOdbcDriver";
		// �������ݿ����ӵ�ַ
		String DBURL = "jdbc:odbc:" + "OpenRoomDB";
		// �������ݿ����Ӷ�������java.sql���еĽӿ�
		Connection conn = null;
		// ����Statement�������ڲ������ݿ�
		Statement stmt = null;
		// ����һ�ַ������������ڱ���SQL���
		String sql_del = null;

		ResultSet r = null;

		// 1��������������
		try {
			Class.forName(DBDRIVER);
		} catch (Exception e) {
			System.out.println("���ݿ������������ʧ�ܣ�����");
			return;
		}

		// 2���������ݿ�
		try {
			conn = DriverManager.getConnection(DBURL);
		} catch (Exception e) {
			System.out.println("���ݿ�����ʧ�ܣ�����");

			return;
		}

		// 3���������ݿ�
		// ͨ��Connection����ʵ����Statement����
		try {
			stmt = conn.createStatement();
			// Ϊsql������ֵ
			// �������
			sql_del = "DELETE * FROM LivingTable WHERE roomID = "
					+ String.valueOf(room);
			stmt.execute(sql_del);

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("�������ݿ�ʧ�ܣ�����");
			return;
		}

		// 4���ر����ݿ�
		try {
			// �رղ���
			stmt.close();
			// �ر�����
			conn.close();
		} catch (Exception e) {
			System.out.println("���ݿ�ر�ʧ�ܣ�����");
			return;
		}
		return;
	}
}
