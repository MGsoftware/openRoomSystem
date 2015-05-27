package GUI;

import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;

public class NothingPanel extends javax.swing.JPanel {
	
	private JPanel groundPanel;
	JLabel bgLabel;

	public NothingPanel() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		groundPanel = new JPanel();
		groundPanel.setLayout(null);
		groundPanel.setOpaque(false);
		groundPanel.setSize(225, 600);
		bgLabel = new JLabel();
		bgLabel.setIcon(new ImageIcon("lib/right_mask.png"));
		bgLabel.setBounds(0, 0, 225, 600);
		groundPanel.add(bgLabel);

		groundPanel.setPreferredSize(new Dimension(225, 600));
		add(groundPanel);
		groundPanel.setVisible(true);
	}

}
