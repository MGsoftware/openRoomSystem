package GUI;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
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
public class InformationPanel extends javax.swing.JPanel {
	private Room room;
	private Guest guest;
	JPanel groundPanel;
	JLabel roomIDLabel;
	JLabel nameLabel;
	JLabel priceLabel;
	JLabel userIDLabel;
	JLabel phoneLabel;

	JLabel bgLabel;
	JButton settleButton;

	public InformationPanel(Room room) {
		this.room = room;
	}

	public void initGui() {
		guest = new LivingSystem().getGuestInRoom(room);

		/*
		 * 界面设置
		 */
		groundPanel = new JPanel();
		groundPanel.setLayout(null);
		groundPanel.setOpaque(false);
		bgLabel = new JLabel();
		bgLabel.setIcon(new ImageIcon("lib/right_mask.png"));
		bgLabel.setBounds(0, 0, 225, 600);
		roomIDLabel = new JLabel("房间号：" + room.getRoomID());
		roomIDLabel.setBounds(30, 70, 194, 50);
		roomIDLabel.setFont(new java.awt.Font("微软雅黑", 1, 26));
		nameLabel = new JLabel("用户名：" + guest.getName());
		nameLabel.setBounds(30, 160, 100, 40);
		phoneLabel = new JLabel("电话：" + guest.getPhone());
		phoneLabel.setBounds(30, 220, 100, 40);
		userIDLabel = new JLabel("证件号：" + guest.getID());
		userIDLabel.setBounds(30, 280, 100, 44);
		priceLabel = new JLabel("房价：" + room.getPrice());
		priceLabel.setBounds(30, 340, 100, 40);

		settleButton = new JButton("结账");
		settleButton.setBounds(150, 495, 61, 30);
		settleButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				BillJFrame bp = new BillJFrame(room, guest);
				bp.setBounds(0, 0, 600, 480);
				bp.setVisible(true);
			}
		});

		groundPanel.add(roomIDLabel);
		groundPanel.add(nameLabel);
		groundPanel.add(phoneLabel);
		groundPanel.add(userIDLabel);
		groundPanel.add(priceLabel);
		groundPanel.add(settleButton);
		groundPanel.add(bgLabel);

		// placeholder
		groundPanel.setPreferredSize(new Dimension(240, 600));
		add(groundPanel);
		this.setOpaque(false);
		groundPanel.setVisible(true);
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
		initGui();
	}

	public Guest getGuest() {
		return guest;
	}

	public void setGuest(Guest guest) {
		this.guest = guest;
	}

}
