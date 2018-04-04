package pl.coderslab.dao;

public class Employee {
	private int id;
	private String name;
	private String surname;
	private String address;
	private String phone;
	private String note;
	private double wrkHourCost;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Employee(String name, String surname, String address, String phone, String note, double wrkHourCost) {
		super();
		this.name = name;
		this.surname = surname;
		this.address = address;
		this.phone = phone;
		this.note = note;
		this.wrkHourCost = wrkHourCost;
	}

	public Employee(String name, String surname, String address, String phone, String note, double wrkHourCost,
			int id) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.address = address;
		this.phone = phone;
		this.note = note;
		this.wrkHourCost = wrkHourCost;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public double getWrkHourCost() {
		return wrkHourCost;
	}

	public void setWrkHourCost(double wrkHourCost) {
		this.wrkHourCost = wrkHourCost;
	}

}
