package GUI;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.JFrame;

import Application.LivingSystem;
import Object.*;

/**
 * This code was edited or generated using CloudGarden's Jigloo SWT/Swing GUI
 * Builder, which is free for non-commercial use. If Jigloo is being used
 * commercially (ie, by a corporation, company or business for any purpose
 * whatever) then you should purchase a license for each developer using Jigloo.
 * Please visit www.cloudgarden.com for details. Use of Jigloo implies
 * acceptance of these licensing terms. A COMMERCIAL LICENSE HAS NOT BEEN
 * PURCHASED FOR THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED LEGALLY FOR
 * ANY CORPORATE OR COMMERCIAL PURPOSE.
 */
public class OpenRoomFrame extends javax.swing.JFrame {

	private Guest guest;
	private Room room;

	JPanel groundPanel;
	JLabel roomNumLabel;
	JLabel roomPriceLabel;
	JLabel bgLabel;

	JLabel nameLabel;
	JLabel idLabel;
	JLabel phoneLabel;

	JButton openRoomButton;

	JTextField nameTextField;
	private JLabel emptyLabel;
	private JLabel telWarningLabel;
	private JLabel idWarningLabel;
	private JLabel nameWarngingLabel;
	JLabel temp;
	JTextField idTextField;
	JTextField phoneTextField;

	public OpenRoomFrame(final Room room) {
		this.room = room;
		guest = new Guest();
		temp = new JLabel();
		temp.setVisible(false);
		initGUI();
	}

	public OpenRoomFrame(final Room room, final Guest guest) {
		this.room = room;
		this.guest = guest;
		temp = new JLabel();
		temp.setVisible(false);
		initGUI();
	}

	public void initGUI() {
		setLocation(200, 100);
		groundPanel = new JPanel();
		groundPanel.setLayout(null);
		groundPanel.setOpaque(false);
		bgLabel = new JLabel();
		bgLabel.setIcon(new ImageIcon("lib/mask_bg.png"));
		bgLabel.setBounds(0, 0, 583, 440);
		roomNumLabel = new JLabel("房间号：" + room.getRoomID());
		roomNumLabel.setBounds(200, 20, 200, 50);
		roomNumLabel.setFont(new java.awt.Font("微软雅黑", 1, 26));
		roomPriceLabel = new JLabel("-------------------------------价格："
				+ room.getPrice());
		roomPriceLabel.setBounds(100, 50, 400, 50);
		roomPriceLabel.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 20));

		nameLabel = new JLabel("姓名：");
		nameLabel.setBounds(60, 120, 200, 30);
		nameLabel.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 20));
		idLabel = new JLabel("证件号:");
		idLabel.setBounds(60, 190, 200, 30);
		idLabel.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 20));
		phoneLabel = new JLabel("电话:");
		phoneLabel.setBounds(60, 260, 200, 30);
		phoneLabel.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 20));

		nameTextField = new JTextField();
		nameTextField.setBounds(260, 120, 300, 30);
		nameTextField.setText(guest.getName());
		idTextField = new JTextField();
		idTextField.setBounds(260, 190, 300, 30);
		phoneTextField = new JTextField();
		phoneTextField.setBounds(260, 260, 300, 30);
		
		{
			nameWarngingLabel = new JLabel();
			groundPanel.add(nameWarngingLabel);
			nameWarngingLabel.setText("\u540d\u5b57\u8d85\u8fc720\u4e2a\u5b57\uff0c\u8bf7\u91cd\u65b0\u8f93\u5165\uff01");
			nameWarngingLabel.setBounds(315, 161, 232, 17);
			nameWarngingLabel.setVisible(false);
		}
		{
			idWarningLabel = new JLabel();
			groundPanel.add(idWarningLabel);
			idWarningLabel.setText("\u8bc1\u4ef6\u53f7\u7801\u5e94\u8be5\u4e3a15\u4f4d\u6216\u800518\u4f4d\uff0c\u8bf7\u91cd\u65b0\u8f93\u5165\uff01");
			idWarningLabel.setBounds(275, 232, 278, 14);
			idWarningLabel.setVisible(false);
		}
		{
			telWarningLabel = new JLabel();
			groundPanel.add(telWarningLabel);
			telWarningLabel.setText("\u7535\u8bdd\u53f7\u7801\u4e0d\u5e94\u8be5\u8d85\u8fc711\u4f4d\uff0c\u8bf7\u91cd\u65b0\u8f93\u5165\uff01");
			telWarningLabel.setBounds(292, 302, 244, 20);
			telWarningLabel.setVisible(false);
		}
		{
			emptyLabel = new JLabel();
			groundPanel.add(emptyLabel);
			emptyLabel.setText("\u4fe1\u606f\u4e0d\u5b8c\u6574\uff0c\u8bf7\u91cd\u65b0\u586b\u5199\uff01");
			emptyLabel.setBounds(225, 352, 197, 17);
			emptyLabel.setVisible(false);
		}

		openRoomButton = new JButton("开房");
		openRoomButton.setBounds(250, 385, 100, 30);
		openRoomButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				guest.setName(nameTextField.getText());
				guest.setID(idTextField.getText());
				guest.setPhone(phoneTextField.getText());
				if(guest.getID().equals("")||guest.getName().equals("")||guest.getPhone().equals(""))
				{
					temp.setVisible(false);
					temp = emptyLabel;
					temp.setVisible(true);
					return;
				}
				if(guest.getName().length()>20)
				{
					temp.setVisible(false);
					temp = nameWarngingLabel;
					temp.setVisible(true);
					return;
				}
				if(guest.getID().length()!=15&&guest.getID().length()!=18)
				{
					temp.setVisible(false);
					temp = idWarningLabel;
					temp.setVisible(true);
					return;
				}
				if(guest.getPhone().length()>11)
				{
					temp.setVisible(false);
					temp = telWarningLabel;
					temp.setVisible(true);
					return;
				}
				new LivingSystem().openRoom(room, guest);
				ManageSystem.roomPanel.removeAll();
				ManageSystem.roomPanel.initGUI();
				ManageSystem.roomPanel.updateUI();
				ManageSystem.emptyPanel.setVisible(false);
				ManageSystem.nothingPanel.setVisible(true);
				setVisible(false);// 关闭窗口
			}

		});

		if (guest != null) {

			idTextField.setText(guest.getID());
			nameTextField.setText(guest.getName());
			phoneTextField.setText(guest.getPhone());
		}

		groundPanel.add(roomNumLabel);
		groundPanel.add(roomPriceLabel);
		groundPanel.add(nameLabel);
		groundPanel.add(nameTextField);
		groundPanel.add(idLabel);
		groundPanel.add(idTextField);
		groundPanel.add(phoneLabel);
		groundPanel.add(phoneTextField);
		groundPanel.add(openRoomButton);
		groundPanel.add(bgLabel);
		

		// placeholder
		groundPanel.setPreferredSize(new java.awt.Dimension(600, 480));
		add(groundPanel);
		this.setSize(600, 480);
		groundPanel.setVisible(true);

	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public Guest getCustomer() {
		return guest;
	}

	public void setCustomer(Guest guest) {
		this.guest = guest;
	}

}
