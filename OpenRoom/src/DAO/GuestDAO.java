package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import Object.Guest;
import Object.Room;

public class GuestDAO {

		public void changeGuestInfo(Guest guest) {
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
			sql_del = "DELETE * FROM GuestTable WHERE ID = \'" + guest.getID() + "\';";
			stmt.execute(sql_del);
			
			sql_insert = "INSERT into GuestTable(ID,name,telephone) values(?,?,?);";
			PreparedStatement ppst=conn.prepareStatement(sql_insert);  
            ppst.setString(1, guest.getID());
            ppst.setString(2, guest.getName());
            ppst.setString(3, guest.getPhone());             
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
		
		public Guest getGuestByID(String ID) {
			Guest guest = null;
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
				sql = "SELECT * FROM GuestTable WHERE ID = \'" + ID +"\';";
				r = stmt.executeQuery(sql);
				while (r.next()) {
					guest = new Guest(r.getString("name"),r.getString("ID"),r.getString("telephone"));
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
}

