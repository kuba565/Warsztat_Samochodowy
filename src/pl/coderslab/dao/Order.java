package pl.coderslab.dao;

public class Order {
	private int id;
	private String arrivalString;
	private String repairBeginStringPlan;
	private String repairBeginStringReal;
	private String assignedWorker;
	private String problemDesc;
	private String repairDesc;
	private String status;
	private String vehicleRepaired;
	private double customerRepairCost;
	private double partsCost;
	private double wrkHourCost;
	private int wrkHours;

	public Order(String arrivalString, String repairBeginStringPlan, String repairBeginStringReal, String assignedWorker,
			String problemDesc, String repairDesc, String status, String vehicleRepaired, double customerRepairCost,
			double partsCost, double wrkHourCost, int wrkHours) {
		super();
		this.arrivalString = arrivalString;
		this.repairBeginStringPlan = repairBeginStringPlan;
		this.repairBeginStringReal = repairBeginStringReal;
		this.assignedWorker = assignedWorker;
		this.problemDesc = problemDesc;
		this.repairDesc = repairDesc;
		this.status = status;
		this.vehicleRepaired = vehicleRepaired;
		this.customerRepairCost = customerRepairCost;
		this.partsCost = partsCost;
		this.wrkHourCost = wrkHourCost;
		this.wrkHours = wrkHours;
	}

	
	public Order(int id, String arrivalString, String repairBeginStringPlan, String repairBeginStringReal, String assignedWorker,
			String problemDesc, String repairDesc, String status, String vehicleRepaired, double customerRepairCost,
			double partsCost, double wrkHourCost, int wrkHours) {
		super();
		this.id = id;
		this.arrivalString = arrivalString;
		this.repairBeginStringPlan = repairBeginStringPlan;
		this.repairBeginStringReal = repairBeginStringReal;
		this.assignedWorker = assignedWorker;
		this.problemDesc = problemDesc;
		this.repairDesc = repairDesc;
		this.status = status;
		this.vehicleRepaired = vehicleRepaired;
		this.customerRepairCost = customerRepairCost;
		this.partsCost = partsCost;
		this.wrkHourCost = wrkHourCost;
		this.wrkHours = wrkHours;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getArrivalString() {
		return arrivalString;
	}

	public void setArrivalString(String arrivalString) {
		this.arrivalString = arrivalString;
	}

	public String getRepairBeginStringPlan() {
		return repairBeginStringPlan;
	}

	public void setRepairBeginStringPlan(String repairBeginStringPlan) {
		this.repairBeginStringPlan = repairBeginStringPlan;
	}

	public String getRepairBeginStringReal() {
		return repairBeginStringReal;
	}

	public void setRepairBeginStringReal(String repairBeginStringReal) {
		this.repairBeginStringReal = repairBeginStringReal;
	}

	public String getAssignedWorker() {
		return assignedWorker;
	}

	public void setAssignedWorker(String assignedWorker) {
		this.assignedWorker = assignedWorker;
	}

	public String getProblemDesc() {
		return problemDesc;
	}

	public void setProblemDesc(String problemDesc) {
		this.problemDesc = problemDesc;
	}

	public String getRepairDesc() {
		return repairDesc;
	}

	public void setRepairDesc(String repairDesc) {
		this.repairDesc = repairDesc;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getVehicleRepaired() {
		return vehicleRepaired;
	}

	public void setVehicleRepaired(String vehicleRepaired) {
		this.vehicleRepaired = vehicleRepaired;
	}

	public double getCustomerRepairCost() {
		return customerRepairCost;
	}

	public void setCustomerRepairCost(double customerRepairCost) {
		this.customerRepairCost = customerRepairCost;
	}

	public double getPartsCost() {
		return partsCost;
	}

	public void setPartsCost(double partsCost) {
		this.partsCost = partsCost;
	}

	public double getWrkHourCost() {
		return wrkHourCost;
	}

	public void setWrkHourCost(double wrkHourCost) {
		this.wrkHourCost = wrkHourCost;
	}

	public int getWrkHours() {
		return wrkHours;
	}

	public void setWrkHours(int wrkHours) {
		this.wrkHours = wrkHours;
	}

}
