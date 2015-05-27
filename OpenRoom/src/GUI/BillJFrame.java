package GUI;

import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import Application.LivingSystem;
import Object.*;

;

public class BillJFrame extends javax.swing.JFrame {
	private Room room;
	private Guest guest;
	private JPanel groundPanel;
	private JButton settleBtn;
	JLabel nameLabel;
	JLabel idLabel;
	JLabel phoneLabel;
	JLabel roomNumLabel;
	JLabel roomPriceLabel;
	JLabel bgLabel;

	public BillJFrame(final Room room,final Guest guest) {
		this.room = room;
		this.guest = guest;
		initGUI();
	}
	
	public void initGUI()
	{
		setLocation(200,100);
		setSize(600,480);
		groundPanel=new JPanel();
		groundPanel.setLocale(null);
		groundPanel.setBounds(0, 0, 600, 480);
		groundPanel.setOpaque(false);
		groundPanel.setLayout(null);

		bgLabel=new JLabel();
		bgLabel.setIcon( new ImageIcon("lib/mask_bg.png"));
		bgLabel.setBounds(0, 0, 600, 480);
		roomNumLabel=new JLabel("房间号："+room.getRoomID());
		roomNumLabel.setBounds(200, 20, 200, 50);
		roomNumLabel.setFont(new java.awt.Font("微软雅黑",1,26));
		
		roomPriceLabel=new JLabel("价格："+room.getPrice());
		roomPriceLabel.setBounds(60, 50, 200, 100);
		roomPriceLabel.setFont(new java.awt.Font("Microsoft YaHei UI",0,20));
		nameLabel=new JLabel("姓名："+guest.getName());
	    nameLabel.setBounds(60, 120, 200, 100);
	    nameLabel .setFont(new java.awt.Font("Microsoft YaHei UI",0,20));
	    idLabel=new JLabel("证件号:"+guest.getID());
	    idLabel.setBounds(60, 190, 200, 100);
	    idLabel.setFont(new java.awt.Font("Microsoft YaHei UI",0,20));
	    phoneLabel=new JLabel("电话:"+guest.getPhone());
	    phoneLabel.setBounds(60, 260, 200, 100);
	    phoneLabel.setFont(new java.awt.Font("Microsoft YaHei UI",0,20));

		settleBtn=new JButton("结账");
		settleBtn.setBounds(250, 385, 100, 30);
		settleBtn.addMouseListener(new MyMouseAdapter_s());//添加结账功能
		
		groundPanel.add(roomNumLabel);
		groundPanel.add(roomPriceLabel);
		groundPanel.add(nameLabel);
    	groundPanel.add(idLabel);
    	groundPanel.add(phoneLabel);
		groundPanel.add(bgLabel);
		groundPanel.add(settleBtn);
		
		groundPanel.setPreferredSize(new java.awt.Dimension(600, 480));
		add(groundPanel);
		this.setSize(600, 480);
		groundPanel.setVisible(true);
	}

	private class MyMouseAdapter_s extends java.awt.event.MouseAdapter {

		public void mousePressed(MouseEvent e) {
			if (e.getClickCount() == 1) {

				method(e);
			}
		}

		private void method(MouseEvent e) {
			new LivingSystem().checkOut(room, guest);
			ManageSystem.roomPanel.removeAll();
			ManageSystem.roomPanel.initGUI();
			ManageSystem.roomPanel.updateUI();
			ManageSystem.infoPanel.setVisible(false);
			ManageSystem.nothingPanel.setVisible(true);
			setVisible(false);
		}
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

}
