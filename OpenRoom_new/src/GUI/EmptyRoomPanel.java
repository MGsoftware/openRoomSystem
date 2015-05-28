package GUI;

import java.awt.Dimension;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListModel;
import javax.swing.WindowConstants;
import javax.swing.JFrame;

import Object.Room;

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
public class EmptyRoomPanel extends javax.swing.JPanel {
	private Room room;
	private JPanel groundPanel;
	JLabel roomIDLabel;
	JLabel priceLabel;
	JLabel bgLabel;
	JButton getRoomButton;

	public EmptyRoomPanel(Room room) {
		this.room = room;
	}

	public void initGui() {
		groundPanel = new JPanel();
		groundPanel.setLayout(null);
		groundPanel.setOpaque(false);
		groundPanel.setSize(225, 600);
		bgLabel = new JLabel();
		bgLabel.setIcon(new ImageIcon("lib/right_mask.png"));
		bgLabel.setBounds(0, 0, 225, 600);
		roomIDLabel = new JLabel("·¿¼äºÅ£º" + room.getRoomID());
		roomIDLabel.setBounds(12, 117, 201, 50);
		roomIDLabel.setFont(new java.awt.Font("Î¢ÈíÑÅºÚ", 1, 26));

		priceLabel = new JLabel("¼ÛÇ®£º" + room.getPrice());
		priceLabel.setBounds(21, 277, 200, 50);
		priceLabel.setFont(new java.awt.Font("Î¢ÈíÑÅºÚ", 1, 26));

		getRoomButton = new JButton("¿ª·¿");
		getRoomButton.setBounds(150, 480, 60, 30);
		getRoomButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				OpenRoomFrame opr = new OpenRoomFrame(room);
				opr.setBounds(0, 0, 600, 480);
				opr.setVisible(true);
			}

		});
		groundPanel.add(roomIDLabel);
		groundPanel.add(priceLabel);
		groundPanel.add(getRoomButton);
		groundPanel.add(bgLabel);

		groundPanel.setPreferredSize(new Dimension(225, 600));
		add(groundPanel);
		this.setOpaque(false);
		groundPanel.setVisible(true);

	}

	public void setRoom(Room room) {
		this.room = room;
		initGui();
	}
}
