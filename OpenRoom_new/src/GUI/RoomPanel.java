package GUI;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Application.LivingSystem;
import Object.Room;

public class RoomPanel extends javax.swing.JPanel {
	private ArrayList<Room> al;
	private int roomNum;
	private GridLayout roomLayout;
	private JPanel roomPanel;
	private JLabel bgLabel;

	public RoomPanel() {
		initGUI();
	}

	public void initGUI() {
		al = new LivingSystem().getRooms();
		roomNum = al.size();

		roomLayout = new GridLayout(0, 4);
		roomPanel = new JPanel(roomLayout);
		roomPanel.setOpaque(false);
		RoomButton roomButton[] = new RoomButton[roomNum];

		for (int i = 0; i < roomNum; i++) {
			roomButton[i] = new RoomButton(al.get(i));
			if (!al.get(i).isLiving()) {
				roomButton[i].setIcon(new ImageIcon("lib/room_free.PNG"));
				roomButton[i].addMouseListener(new MyMouseAdapter_Free());
			} else {
				roomButton[i].setIcon(new ImageIcon("lib/room_use.PNG"));
				roomButton[i].addMouseListener(new MyMouseAdapter_Living());
			}
			roomButton[i].setSize(65, 65);
			roomButton[i].setVisible(true);

			roomPanel.add(roomButton[i]);
		}
		bgLabel = new JLabel();
		bgLabel.setIcon(new ImageIcon("lib/mask.png"));
		bgLabel.setBounds(0, 0, 568, 600);
		bgLabel.setOpaque(false);

		// roomPanel.add(bgLabel);
		roomPanel.setPreferredSize(new Dimension(568, 571));
		add(roomPanel);
		roomPanel.setVisible(true);
		this.setOpaque(false);
	}

	public class MyMouseAdapter_Living extends java.awt.event.MouseAdapter {
		public void mouseClicked(MouseEvent e) {
			method_Living(e);
		}

		/*
		 * 在这里控制显示房间信息的内容
		 */
		private void method_Living(MouseEvent e) {
			System.out.println(((RoomButton) e.getSource()).getRoom());
			ManageSystem.infoPanel.setVisible(false);
			ManageSystem.emptyPanel.setVisible(false);
			ManageSystem.nothingPanel.setVisible(false);
			ManageSystem.infoPanel.removeAll();
			ManageSystem.infoPanel.setRoom(((RoomButton) e.getSource())
					.getRoom());
			ManageSystem.infoPanel.updateUI();
			ManageSystem.infoPanel.setVisible(true);
		}
	}

	public class MyMouseAdapter_Free extends java.awt.event.MouseAdapter {
		public void mouseClicked(MouseEvent e) {
			method_Free(e);
		}

		/*
		 * 在这里控制显示房间信息的内容
		 */
		private void method_Free(MouseEvent e) {
			System.out.println(((RoomButton) e.getSource()).getRoom());
			ManageSystem.infoPanel.setVisible(false);
			ManageSystem.emptyPanel.setVisible(false);
			ManageSystem.nothingPanel.setVisible(false);
			ManageSystem.emptyPanel.removeAll();
			ManageSystem.emptyPanel.setRoom(((RoomButton) e.getSource())
					.getRoom());
			ManageSystem.emptyPanel.updateUI();
			ManageSystem.emptyPanel.setVisible(true);
		}

	}
}
