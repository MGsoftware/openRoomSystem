package GUI;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;

import Object.Room;


/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/
public class ManageSystem extends javax.swing.JFrame {
	private JLayeredPane groundPane;
	static public RoomPanel roomPanel;
	static public InformationPanel infoPanel = new InformationPanel(new Room());;
	static public EmptyRoomPanel emptyPanel = new EmptyRoomPanel(new Room());
	static public NothingPanel nothingPanel = new NothingPanel();
	
	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				ManageSystem inst = new ManageSystem();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public ManageSystem() {
		super("开房管理系统");
		super.setVisible(true);
		super.setResizable(false);
		initGUI();
	}
	
	private void initGUI() {
		try {
			pack();
			this.setSize(800, 600);
			setLocation(200,100);
			setLayout(null);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			groundPane=new JLayeredPane();
			groundPane.setLayout(null);
			groundPane.setBounds(0, 0, 800, 600);
			
			
		
			groundPane.setSize(800, 660);
			{
				roomPanel = new RoomPanel();
				groundPane.add(roomPanel, JLayeredPane.DEFAULT_LAYER);
				roomPanel.setBounds(-4, -3, 575, 571);
				roomPanel.setVisible(true);
			}
			{
				groundPane.add(infoPanel, JLayeredPane.DEFAULT_LAYER);
				infoPanel.setBounds(568, -19, 225, 600);
				infoPanel.setVisible(false);
			}
			{
				groundPane.add(emptyPanel, JLayeredPane.DEFAULT_LAYER);
				emptyPanel.setBounds(568, -19, 225, 600);
				emptyPanel.setVisible(false);
			}
			{
				groundPane.add(nothingPanel, JLayeredPane.DEFAULT_LAYER);
				nothingPanel.setBounds(568, -19, 225, 600);
				nothingPanel.setVisible(true);
			}
			
			add(groundPane);
			this.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

}
