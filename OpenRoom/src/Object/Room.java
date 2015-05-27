package Object;

public class Room {
	private int roomID;
	private boolean isLiving;
	private float price;
	public Room() {
		super();
	}
	public Room(int roomID, boolean isLiving, float price) {
		super();
		this.roomID = roomID;
		this.isLiving = isLiving;
		this.price = price;
	}
	public int getRoomID() {
		return roomID;
	}
	public void setRoomID(int roomID) {
		this.roomID = roomID;
	}
	public boolean isLiving() {
		return isLiving;
	}
	public void setLiving(boolean isLiving) {
		this.isLiving = isLiving;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Room [roomID=" + roomID + ", isLiving=" + isLiving + ", price="
				+ price + "]";
	}
	

}
