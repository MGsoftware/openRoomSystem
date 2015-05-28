package GUI;

import javax.swing.JButton;

import Object.Room;

public class RoomButton extends JButton{
	private Room room;

	public RoomButton(Room room) {
		super();
		this.room = room;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}
	
}
