package Application;
import java.util.ArrayList;

import DAO.*;
import GUI.RoomButton;
import Object.*;

public class LivingSystem {

	public void openRoom(Room room,Guest guest)
	{
		room.setLiving(true);
		new RoomDAO().changeRoomState(room);
		new LivingDAO().createLiving(room.getRoomID(), guest.getID());
		new GuestDAO().changeGuestInfo(guest);
	}
	
	public void checkOut(Room room,Guest guest)
	{
		room.setLiving(false);
		new RoomDAO().changeRoomState(room);
		new LivingDAO().deleteLiving(room.getRoomID());
	}
	
	public ArrayList<Room> getRooms()
	{
		return new RoomDAO().getRoomList();
	}
	
	public Guest getGuestInRoom(Room room)
	{
		return new GuestDAO().getGuestByID(new LivingDAO().getGuestIDByroomID(room.getRoomID()));
	}
}
