package pl.coderslab.dao;


public class Vehicle {

	private int id;
	private String make;
	private String model;
	private String yearOfProduction;
	private String regNumber;
	private String nextReview;

	public Vehicle(String make, String model, String yearOfProduction, String regNumber, String nextReview) {
		super();
		this.make = make;
		this.model = model;
		this.yearOfProduction = yearOfProduction;
		this.regNumber = regNumber;
		this.nextReview = nextReview;
	}

	public Vehicle(int id, String make, String model, String yearOfProduction, String regNumber, String nextReview) {
		super();
		this.id = id;
		this.make = make;
		this.model = model;
		this.yearOfProduction = yearOfProduction;
		this.regNumber = regNumber;
		this.nextReview = nextReview;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getYearOfProduction() {
		return yearOfProduction;
	}

	public void setYearOfProduction(String yearOfProduction) {
		this.yearOfProduction = yearOfProduction;
	}

	public String getRegNumber() {
		return regNumber;
	}

	public void setRegNumber(String regNumber) {
		this.regNumber = regNumber;
	}

	public String getNextReview() {
		return nextReview;
	}

	public void setNextReview(String nextReview) {
		this.nextReview = nextReview;
	}

}
