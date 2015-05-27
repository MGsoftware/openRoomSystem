package Object;

public class Guest {
	private String name;
	private String ID;
	private String phone;
	public Guest() {
	}
	public Guest(String name, String iD, String phone) {
		super();
		this.name = name;
		ID = iD;
		this.phone = phone;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	@Override
	public String toString() {
		return "Guest [name=" + name + ", ID=" + ID + ", phone=" + phone + "]";
	}
	
}
